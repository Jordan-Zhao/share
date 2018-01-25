package com.share.locker.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.reflect.TypeToken;
import com.share.locker.bo.ItemBO;
import com.share.locker.bo.OperationConfigBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.JsonUtil;
import com.share.locker.service.ItemService;
import com.share.locker.service.OperationService;
import com.share.locker.service.util.BizUtil;
import com.share.locker.web.dto.BannerDTO;
import com.share.locker.web.dto.HotItemDTO;
import com.share.locker.web.dto.OperationSettingDTO;

@Controller
public class OperationController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(OperationController.class);

	@Resource
	private OperationService operationService;
	@Resource
	private ItemService itemService;

	/**
	 * 获取主页渲染时需要的数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/home/getOperationData.json", method = RequestMethod.POST)
	public Object getOperationData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// center
		OperationConfigBO centerConfig = operationService.getOperationCenterConfig();
		OperationSettingDTO operationSettingDTO = (OperationSettingDTO)JsonUtil.json2Object(centerConfig.getContent(), OperationSettingDTO.class);
		
		// banner
		OperationConfigBO bannerConfig = operationService.getOperationBannerConfig();
		operationSettingDTO.setBannerDTOList(JsonUtil.json2List(bannerConfig.getContent(), new TypeToken<List<BannerDTO>>() {}));

		// hot items
		List<ItemBO> itemBOList = itemService.getHotItemList();
		List<HotItemDTO> hotItemList = convertHotItemList(itemBOList);
		operationSettingDTO.setHotItemDTOList(hotItemList);

		writeJsonMsg(response, true, operationSettingDTO);
		return null;
	}

	private List<HotItemDTO> convertHotItemList(List<ItemBO> itemBOList) {
		List<HotItemDTO> resultList = new ArrayList<>();
		if (CollectionUtils.isEmpty(itemBOList)) {
			return new ArrayList<>();
		}
		for (ItemBO itemBO : itemBOList) {
			HotItemDTO dto = new HotItemDTO();
			dto.setItemId(itemBO.getItemId());
			dto.setImgUrl(itemBO.getSmallImgList().get(0).getUrl());
			dto.setTitle(itemBO.getTitle());
			dto.setDeposit(BizUtil.convertDbPrice2Float(itemBO.getDeposit()));
			dto.setPriceTxt(BizUtil.convertPrice2Str(itemBO.getPriceTime(), itemBO.getPriceTimeUnit(), itemBO.getPrice()));
			dto.setCommentCount(LockerConstants.MOCK_COMMENT_NUMBER);
			resultList.add(dto);
		}
		return resultList;
	}

	private String convertPriceStr(ItemBO itemBO) {
		return "每天" + itemBO.getPrice(); // TODO
	}

	private String getRandomItemUrl() {
		String[] arr = { "http://192.168.0.104:8080/locker/item2.png", "http://192.168.0.104:8080/locker/item3.png",
				"http://192.168.0.104:8080/locker/item4.png" };
		return arr[new Random().nextInt(3)];
	}

	  public static void main(String[] arg) {
	    	/*String json = "[{\"imgUrl\":\"http://192.168.0.104:8080/locker/banner1.png\",\"itemId\":46}]";
	    	List list = JsonUtil.json2List(json, new TypeToken<BannerDTO>() {}) ;  */	
	    	
	    	List<BannerDTO> bannerDTOs = new ArrayList<>();
	    	BannerDTO bannerDTO = new BannerDTO();
	    	bannerDTO.setImgUrl("http://192.168.0.104:8080/locker/banner1.png");
	    	bannerDTO.setItemId(46L);
	    	bannerDTOs.add(bannerDTO);
	    	String string = JsonUtil.toJson(bannerDTOs);
	    	System.out.println(string);
	    	
	    	List list = JsonUtil.json2List(string, new TypeToken<List<BannerDTO>>() {}) ;
	    }
}
