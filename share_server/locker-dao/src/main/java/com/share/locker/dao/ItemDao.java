package com.share.locker.dao;


import java.util.List;

import com.share.locker.bo.ItemBO;

public interface ItemDao {
	public List<ItemBO> selectItemByIdList(List<Integer> itemIdList);  
}
