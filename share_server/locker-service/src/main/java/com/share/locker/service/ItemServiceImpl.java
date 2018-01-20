package com.share.locker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.ItemBO;
import com.share.locker.dao.ItemDao;

@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	public List<ItemBO> getHotItemList() {
		List<Integer> itemIdList = new ArrayList<>();
		// mock
		itemIdList.add(1);
		itemIdList.add(2);
		itemIdList.add(3);
		itemIdList.add(4);
		itemIdList.add(5);

		return itemDao.selectItemByIdList(itemIdList);
	}
}
