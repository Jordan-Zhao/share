package com.share.locker.service;

import java.util.List;

import com.share.locker.bo.ItemBO;

public interface ItemService {
	List<ItemBO> getHotItemList();
}
