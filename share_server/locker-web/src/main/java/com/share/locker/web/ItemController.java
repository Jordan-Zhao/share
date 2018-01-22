package com.share.locker.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.service.ItemService;
import com.share.locker.service.util.BizUtil;

@Controller
public class ItemController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Resource
	private ItemService itemService;

	/**
	 * 获取主页需要显示的运营配置信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHotItemList.json")
	public Object getHotItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ItemBO> itemBOList = itemService.getHotItemList();
		List<Map<String, Object>> hotItemList = convertHotItemList(itemBOList);
		writeJsonMsg(response, true, hotItemList);
		return null;
	}

	/**
	 * 发布宝贝
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/publishItem.json", method = RequestMethod.POST)
	public Object publishItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 初始化文件上传对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(200 * 1024); // 200KB
		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> formlists = null;
		try {
			formlists = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Long itemId;
		// 保存文件
		List<FileItem> fileList = new ArrayList<>();
		int maxSize = 2 * 1024 * 1024; // 2MB
		Iterator<FileItem> iterator = formlists.iterator();
		while (iterator.hasNext()) {
			FileItem formitem = iterator.next();
			if (!formitem.isFormField()) {
				// 上传的文件
				if (formitem.getSize() > maxSize) {
					writeJsonMsg(response, false, "上传的图片文件太大，不能超过2M");
					return null;
				} else {
					fileList.add(formitem);
				}
			}
		}
		Map<String, List<String>> savedFileUrlList = saveUploadFiles(request, fileList);

		// 保存其他字段
		ItemBO itemBO = new ItemBO();
		UserBO loginUser = BizUtil.getLoginUser(request);
		itemBO.setUserId(loginUser.getUserId());
		itemBO.setEditor(loginUser.getEmail() + ";"+loginUser.getPhoneNumber());
		itemBO.setStatus(LockerConstants.ItemStatus.VALID.getStatusCode());//状态
		iterator = formlists.iterator();
		while (iterator.hasNext()) {
			FileItem formItem = iterator.next();
			if (formItem.isFormField()) {
				String fieldName = formItem.getFieldName();
				String fieldValue = formItem.getString();
				if("title".equals(fieldName)){
					itemBO.setTitle(fieldValue);
				}else if("priceTimeUnit".equals(fieldName)){
					itemBO.setPriceTimeUnit(fieldValue);
				}else if("priceTime".equals(fieldName)){
					itemBO.setPriceTime(Integer.parseInt(fieldValue));
				}else if("price".equals(fieldName)){
					itemBO.setPrice(Integer.parseInt(fieldValue));
				}else if("deposit".equals(fieldName)){
					itemBO.setDeposit(Integer.parseInt(fieldValue));
				}else if("lockerSize".equals(fieldName)){
					itemBO.setLockerSizeCode(fieldValue);
				}else if("lockerId".equals(fieldName)){
					itemBO.setLockerId(Long.parseLong(fieldValue));
				}else if("description".equals(fieldName)){
					itemBO.setDescription(fieldValue);
				}else if("publishStatus".equals(fieldName)) {
					itemBO.setPublishStatus(getPublishStatus(Boolean.valueOf(fieldValue)));
				}
			}
		}
		itemId = itemService.publishItem(itemBO, savedFileUrlList);
		writeJsonMsg(response, true, itemId);
		return null;
	}

	private List<Map<String, Object>> convertHotItemList(List<ItemBO> itemBOList) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		if (CollectionUtils.isEmpty(itemBOList)) {
			return new ArrayList<>();
		}
		for (ItemBO itemBO : itemBOList) {
			Map<String, Object> itemMap = new HashMap<>();
			itemMap.put("itemId", itemBO.getItemId());
			itemMap.put("itemImgUrl", getRandomItemUrl()); // TODO
			itemMap.put("title", itemBO.getTitle());
			itemMap.put("deposit", itemBO.getDeposit());
			itemMap.put("priceStr", convertPriceStr(itemBO));
			itemMap.put("comment", 139); // TODO
			resultList.add(itemMap);
		}
		return resultList;
	}

	private String convertPriceStr(ItemBO itemBO) {
		return "每天" + itemBO.getPrice(); // TODO
	}

	private String getRandomItemUrl() {
		String[] arr = { LockerConstants.MOCK_URL_BASE + "item2.png", LockerConstants.MOCK_URL_BASE + "item3.png",
				LockerConstants.MOCK_URL_BASE + "item4.png" };
		return arr[new Random().nextInt(3)];
	}

	private Map<String, List<String>> saveUploadFiles(HttpServletRequest request, List<FileItem> fileItemList) {
		Map<String, List<String>> resultMap = new HashMap<>();
		List<String> normalFileList = new ArrayList<>();
		List<String> smallFileList = new ArrayList<>();
		resultMap.put(LockerConstants.ImgSizeCode.NORMAL.getSizeCode(), normalFileList);
		resultMap.put(LockerConstants.ImgSizeCode.SMALL.getSizeCode(), smallFileList);
		
		String smallImgFilePath = request.getSession().getServletContext().getRealPath("") + "images\\small\\";
		String normalImgFilePath = request.getSession().getServletContext().getRealPath("") + "images\\normal\\";

		Iterator<FileItem> iterator = fileItemList.iterator();
		while (iterator.hasNext()) {
			FileItem formitem = (FileItem) iterator.next();
			// 这里是上传文件的表单域
			String name = formitem.getName();
			String fileSize = new Long(formitem.getSize()).toString();
			if (name == null || "".equals(name) && "0".equals(fileSize))
				continue;
			int delimiter = name.lastIndexOf("\\");
			String simpleFileName = (delimiter == -1) ? name : name.substring(delimiter + 1);
			try {
				// save normal file
				File normalFile = new File(normalImgFilePath, simpleFileName);
				formitem.write(normalFile);
				normalFileList.add(LockerConstants.MOCK_URL_BASE + "images/normal/" + simpleFileName);
				// save small file
				File smallFile = new File(smallImgFilePath, simpleFileName);
				formitem.write(smallFile); // TODO 裁剪图片
				normalFileList.add(LockerConstants.MOCK_URL_BASE + "images/small/" + simpleFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}
	
	private String getPublishStatus(boolean isOnLine) {
		return isOnLine?LockerConstants.ItemStatus.ON_LINE.getStatusCode():LockerConstants.ItemStatus.OFF_LINE.getStatusCode();
	}

	public static void main(String[] arg) {
		System.out.println(new Random().nextInt(3));
	}

}
