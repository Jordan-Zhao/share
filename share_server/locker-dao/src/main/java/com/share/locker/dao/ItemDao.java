package com.share.locker.dao;

import java.util.List;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.ItemImgBO;

public interface ItemDao {
	public List<ItemBO> selectItemByIdList(List<Integer> itemIdList);
	
	public Integer saveItem(ItemBO itemBO);
	
	public void saveItemImg(List<ItemImgBO> itemImgBOList);
}
