package com.share.locker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.ItemImgBO;
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

	public Long publishItem(ItemBO itemBO, Map<String, List<String>> imgUrlListMap) {
		// 保存基本信息
		itemDao.saveItem(itemBO);

		// 保存图片url
		List<ItemImgBO> itemImgList = new ArrayList<>();
		for (String key : imgUrlListMap.keySet()) {
			for (String url : imgUrlListMap.get(key)) {
				ItemImgBO imgBO = new ItemImgBO();
				imgBO.setItemId(itemBO.getItemId());
				imgBO.setImgSizeCode(key);
				imgBO.setUrl(url);
				itemImgList.add(imgBO);
			}
		}
		itemDao.saveItemImg(itemImgList);

		return itemBO.getItemId();
	}
}
