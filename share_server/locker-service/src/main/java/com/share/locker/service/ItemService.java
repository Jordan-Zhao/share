package com.share.locker.service;

import java.util.List;
import java.util.Map;

import com.share.locker.bo.ItemBO;
import com.share.locker.common.LockerConstants;

public interface ItemService {
	List<ItemBO> getHotItemList();

	Long publishItem(ItemBO itemBO, Map<String, List<String>> imgUrlList);

	List<ItemBO> getItemByUserId(Long userId, List<String> statusList);

	ItemBO getItemDetail(Long itemId);

	void onLineItem(Long itemId);

	void offLineItem(Long itemId);

	void deleteItem(Long itemId);

	// 查询lockerId对应的“TO_PUT"状态的宝贝
	ItemBO getToPutItem(Long lockerId);
}
