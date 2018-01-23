package com.share.locker.service;

import java.util.List;
import java.util.Map;

import com.share.locker.bo.ItemBO;

public interface ItemService {
	List<ItemBO> getHotItemList();
	
	Long publishItem(ItemBO itemBO, Map<String, List<String>> imgUrlList);
	
	List<ItemBO> getItemByUserId(Long userId,List<String> statusList);
}
