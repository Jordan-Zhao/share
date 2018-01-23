package com.share.locker.dao;

import java.util.List;
import java.util.Map;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.ItemImgBO;

public interface ItemDao {
	public List<ItemBO> selectItemByIdList(List<Integer> itemIdList);
	
	public List<ItemBO> selectItemTop10(List<String> normalStatusList);
	
	public Integer saveItem(ItemBO itemBO);
	
	public void saveItemImg(List<ItemImgBO> itemImgBOList);

	public List<ItemBO> getItemByUserId(Map<String, Object> paramMap);
	
	public List<ItemImgBO> getImgByItemIdList(Map<String, Object> paramMap);
}
