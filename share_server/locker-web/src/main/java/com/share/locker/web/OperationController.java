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

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.OperationConfigBO;
import com.share.locker.service.ItemService;
import com.share.locker.service.OperationService;

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
	@RequestMapping("/getOperationData.json")
	public Object getOperationData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		// banner
		OperationConfigBO bannerConfig = operationService.getOperationBannerConfig();
		resultMap.put("banner", bannerConfig.getContent());

		// center
		OperationConfigBO centerConfig = operationService.getOperationCenterConfig();
		resultMap.put("center", centerConfig.getContent());

		// hot items
		List<ItemBO> itemBOList = itemService.getHotItemList();
		List<Map<String, Object>> hotItemList = convertHotItemList(itemBOList);
		resultMap.put("hot_items", hotItemList);

		writeJsonMsg(response, true, resultMap);
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

	/**
	 * 获取主页需要显示的运营配置信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationInfo.json")
	public Object getOperationInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<OperationConfigBO> configList = operationService.getOperationConfig4HomePage();
		writeJsonMsg(response, true, configList);
		return null;
	}

	private String convertPriceStr(ItemBO itemBO) {
		return "每天" + itemBO.getPrice(); // TODO
	}

	private String getRandomItemUrl() {
		String[] arr = { "http://192.168.0.104:8080/locker/item2.png", "http://192.168.0.104:8080/locker/item3.png",
				"http://192.168.0.104:8080/locker/item4.png" };
		return arr[new Random().nextInt(3)];
	}

}
