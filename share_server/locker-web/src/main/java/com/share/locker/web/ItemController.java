package com.share.locker.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.share.locker.bo.ItemBO;
import com.share.locker.service.ItemService;

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
		String[] arr = {"http://192.168.0.104:8080/locker/item2.png","http://192.168.0.104:8080/locker/item3.png","http://192.168.0.104:8080/locker/item4.png"};
		return arr[new Random().nextInt(3)];
	}
	
	public static void main(String[] arg) {
		System.out.println(new Random().nextInt(3));
	}

}
