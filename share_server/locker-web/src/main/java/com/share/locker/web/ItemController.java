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

import com.share.locker.bo.CheckCodeBO;
import com.share.locker.bo.ItemBO;
import com.share.locker.bo.ItemImgBO;
import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.ImageUtil;
import com.share.locker.service.CheckCodeService;
import com.share.locker.service.ItemService;
import com.share.locker.service.LockerService;
import com.share.locker.service.UserService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.service.util.MockUtil;
import com.share.locker.web.dto.ItemDetailDTO;
import com.share.locker.web.dto.ItemPutLockerDTO;
import com.sun.mail.imap.protocol.Item;

@Controller
public class ItemController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Resource
	private ItemService itemService;

	@Resource
	private UserService userService;

	@Resource
	private LockerService lockerService;
	
	@Resource
	private CheckCodeService checkCodeService;
	
	/**
	 * 获取主页需要显示的运营配置信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/item/getHotItemList.json")
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
	@RequestMapping(value = "/item/publishItem.json", method = RequestMethod.POST)
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
		itemBO.setEditor(loginUser.getEmail() + ";" + loginUser.getPhoneNumber());
		itemBO.setStatus(LockerConstants.ItemStatus.CREATED.getCode());// 状态
		iterator = formlists.iterator();
		while (iterator.hasNext()) {
			FileItem formItem = iterator.next();
			if (formItem.isFormField()) {
				String fieldName = formItem.getFieldName();
				String fieldValue = formItem.getString();
				if ("title".equals(fieldName)) {
					itemBO.setTitle(fieldValue);
				} else if ("priceTimeUnit".equals(fieldName)) {
					itemBO.setPriceTimeUnit(fieldValue);
				} else if ("priceTime".equals(fieldName)) {
					itemBO.setPriceTime(Integer.parseInt(fieldValue));
				} else if ("price".equals(fieldName)) {
					itemBO.setPrice(BizUtil.convertInputPrice2Int(fieldValue));
				} else if ("deposit".equals(fieldName)) {
					itemBO.setDeposit(BizUtil.convertInputPrice2Int(fieldValue));
				} else if ("lockerSize".equals(fieldName)) {
					itemBO.setLockerSizeCode(fieldValue);
				} else if ("lockerId".equals(fieldName)) {
					itemBO.setLockerId(Long.parseLong(fieldValue));
				} else if ("description".equals(fieldName)) {
					itemBO.setDescription(fieldValue);
				} else if ("publishStatus".equals(fieldName)) {
					itemBO.setPublishStatus(getPublishStatus(Boolean.valueOf(fieldValue)));
				}
			}
		}
		itemId = itemService.publishItem(itemBO, savedFileUrlList);
		
		//生成存件二维码
		String code = checkCodeService.createCheckCode(LockerConstants.CheckCodeType.PUT.getCode(), String.valueOf(itemId));
		
		//更新宝贝状态为“已生成存件二维码”
		itemService.updateItemStatus(itemId, LockerConstants.ItemStatus.GENERATED_PUT_QRCODE.getCode());
		
		writeJsonMsg(response, true, String.valueOf(itemId));	
		return null;
	}

	/**
	 * 获取宝贝详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/getItemDetail.json", method = RequestMethod.POST)
	public Object getItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long itemId = Long.parseLong(request.getParameter("itemId"));

		ItemDetailDTO detailDTO = new ItemDetailDTO();
		ItemBO itemBO = itemService.getItemDetail(itemId);
		detailDTO.setItemId(itemBO.getItemId());
		detailDTO.setUserId(itemBO.getUserId());
		detailDTO.setTitle(itemBO.getTitle());
		detailDTO.setPriceStr(
				BizUtil.convertPrice2Str(itemBO.getPriceTime(), itemBO.getPriceTimeUnit(), itemBO.getPrice()));
		detailDTO.setDeposit(BizUtil.convertDbPrice2Float(itemBO.getDeposit()));
		detailDTO.setMachineName(lockerService.getLockerById(itemBO.getLockerId()).getMachineBO().getName());
		detailDTO.setComment(MockUtil.MOCK_COMMENT_NUMBER);
		detailDTO.setDescription(itemBO.getDescription());

		List<String> imgUrlList = new ArrayList<>();
		for (ItemImgBO imgBO : itemBO.getNormalImgList()) {
			imgUrlList.add(imgBO.getUrl());
		}
		detailDTO.setImgList(imgUrlList);

		UserBO owner = userService.getUserById(itemBO.getUserId());
		detailDTO.setOwnnerNick(owner.getNick());

		writeJsonMsg(response, true, detailDTO);
		return null;
	}

	/**
	 * 上架宝贝
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/onLineItem.json", method = RequestMethod.POST)
	public Object onLineItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		// TODO 校验是否本人操作、是否可上架
		itemService.onLineItem(itemId);
		writeJsonMsg(response, true, "上架成功");
		return null;
	}

	/**
	 * 下架宝贝
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/offLineItem.json", method = RequestMethod.POST)
	public Object offLineItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		// TODO 校验是否本人操作、是否可上架
		itemService.offLineItem(itemId);
		writeJsonMsg(response, true, "下架成功");
		return null;
	}

	/**
	 * 删除宝贝
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/deleteItem.json", method = RequestMethod.POST)
	public Object deleteItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		// TODO 校验是否本人操作、是否可上架
		itemService.deleteItem(itemId);
		writeJsonMsg(response, true, "删除成功");
		return null;
	}
	
	/**
	 * 存件初始化页面时，获取信息
	 * @param request	
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/getPutLockerData.json", method = RequestMethod.POST)
	public Object getPutLockerData(HttpServletRequest request, HttpServletResponse response) { 
		Long itemId = Long.parseLong(request.getParameter("itemId"));
		ItemBO itemBO = itemService.getItemDetail(itemId);
		CheckCodeBO checkCodeBO = checkCodeService.getValidCheckCode(LockerConstants.CheckCodeType.PUT.getCode(), String.valueOf(itemId));
		
		ItemPutLockerDTO dto = new ItemPutLockerDTO();
		dto.setItemId(itemId);
		dto.setItemTitle(itemBO.getTitle());
		dto.setLockerId(itemBO.getLockerId());
		dto.setMachineName(MockUtil.getMachineNameBylockerId(itemBO.getLockerId()));
		dto.setQrcode(checkCodeBO.getCheckCode());
		dto.setRemainTime(BizUtil.getCheckCodeRemainTime(checkCodeBO.getCreateTime(), checkCodeBO.getExpireTime()));
		
		writeJsonMsg(response, true, dto);
		return null;
	}
	
	/**
	 * 机柜发来请求，判断是否可以开柜
	 * @param request	机柜传过来：lockerId（保存在机柜中）、qrcode(用户手机扫码)
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/openLockerForPut.json", method = RequestMethod.POST)
	public Object openLockerForPut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		String qrcode = request.getParameter("qrcode");
		
		//判断机柜和二维码是否匹配
		List<CheckCodeBO> codeBOList = checkCodeService.getValidCheckCodeByCode(LockerConstants.CheckCodeType.PUT.getCode(), qrcode);
		if(CollectionUtils.isNotEmpty(codeBOList)) {
			for(CheckCodeBO codeBO : codeBOList) {
				Long itemId = Long.parseLong(codeBO.getCheckId());	//宝贝ID，生成code时作为checkId存入的
				ItemBO itemBO = itemService.getItemDetail(itemId);
				if(itemBO.getStatus().equals(LockerConstants.ItemStatus.GENERATED_PUT_QRCODE.getCode()) 
						&& itemBO.getLockerId().equals(lockerId)) {	//lockerId匹配，则认为可以开门
					writeJsonMsg(response, true, true);
					return null;
				}
			}
		}
		
		writeJsonMsg(response, true, false);
		return null;
	}
	
	/**
	 * 机柜发来请求，告知柜门已放入宝贝
	 * @param request	机柜传过来：lockerId（保存在机柜中）
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/item/closeLockerAfterPut.json", method = RequestMethod.POST)
	public Object closeLockerAfterPut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long lockerId = Long.parseLong(request.getParameter("lockerId"));
		
		//查询lockerId对应的“CREATED"状态的宝贝
		ItemBO itemBO = itemService.getToPutItem(lockerId);
		
		//更新宝贝状态为“上架”
		itemService.onLineItem(itemBO.getItemId());
		
		writeJsonMsg(response, true, true);
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
			itemMap.put("itemImgUrl", itemBO.getSmallImgList().get(0));	//取第一张图片
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

	private Map<String, List<String>> saveUploadFiles(HttpServletRequest request, List<FileItem> fileItemList) {
		Map<String, List<String>> resultMap = new HashMap<>();
		List<String> normalFileList = new ArrayList<>();
		List<String> smallFileList = new ArrayList<>();
		resultMap.put(LockerConstants.ImgSizeCode.NORMAL.getSizeCode(), normalFileList);
		resultMap.put(LockerConstants.ImgSizeCode.SMALL.getSizeCode(), smallFileList);

		String smallImgFilePath = MockUtil.MOCK_IMAGE_FILE_PATH + "small/";
		String normalImgFilePath = MockUtil.MOCK_IMAGE_FILE_PATH + "normal/";

		Iterator<FileItem> iterator = fileItemList.iterator();
		while (iterator.hasNext()) {
			FileItem formitem = (FileItem) iterator.next();
			// 这里是上传文件的表单域
			String name = formitem.getName();
			String fileSize = new Long(formitem.getSize()).toString();
			if (name == null || "".equals(name) && "0".equals(fileSize))
				continue;
			int delimiter = name.lastIndexOf("\\");
			String simpleFileName = "image_"+System.currentTimeMillis()+"_"+((delimiter == -1) ? name : name.substring(delimiter + 1));
			try {
				//保存正常图片
				File normalFile = new File(normalImgFilePath, simpleFileName);
				formitem.write(normalFile);
				normalFileList.add(MockUtil.MOCK_URL_IMAGE + "normal/" + simpleFileName);
				//生成200的小图片
				ImageUtil.zoomByWidthAndSave(normalImgFilePath+simpleFileName, 200, smallImgFilePath+simpleFileName);
				smallFileList.add(MockUtil.MOCK_URL_IMAGE + "small/" + simpleFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	private String getPublishStatus(boolean isOnLine) {
		return isOnLine ? LockerConstants.ItemStatus.ONLINE.getCode() : LockerConstants.ItemStatus.OFFLINE.getCode();
	}

	public static void main(String[] arg) {
		System.out.println(new Random().nextInt(3));
	}

}
