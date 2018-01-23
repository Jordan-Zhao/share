package com.share.locker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.ItemBO;
import com.share.locker.bo.ItemImgBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.dao.ItemDao;

@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	public List<ItemBO> getHotItemList() {
		// TODO 先mock取前10条数据
		List<String> normalStatusList = new ArrayList<>();
		normalStatusList.add(LockerConstants.ItemStatus.TO_PUT.getStatusCode());
		normalStatusList.add(LockerConstants.ItemStatus.ON_LINE.getStatusCode());
		normalStatusList.add(LockerConstants.ItemStatus.OFF_LINE.getStatusCode());
		return itemDao.selectItemTop10(normalStatusList);
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
				imgBO.setStatus(LockerConstants.BaseDataStatus.VALID.getCode());
				itemImgList.add(imgBO);
			}
		}
		itemDao.saveItemImg(itemImgList);

		return itemBO.getItemId();
	}
	

	public List<ItemBO> getItemByUserId(Long userId,List<String> statusList){
		//获取基本信息
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("statusList", statusList);
		List<ItemBO> itemList = itemDao.getItemByUserId(paramMap);
		
		//获取img信息
		if(CollectionUtils.isNotEmpty(itemList)) {
			List<Long> itemIdList = new ArrayList<>();
			for(ItemBO itemBO : itemList) {
				itemIdList.add(itemBO.getItemId());
			}
			List<String> imgStatusList = new ArrayList<>();
			imgStatusList.add(LockerConstants.BaseDataStatus.VALID.getCode());
			
			Map<String, Object> paramMap1 = new HashMap<>();
			paramMap1.put("itemIdList",itemIdList);
			paramMap1.put("statusList",imgStatusList);
			paramMap1.put("imgSizeCode", LockerConstants.ImgSizeCode.SMALL.getSizeCode());
			List<ItemImgBO> imgList = itemDao.getImgByItemIdList(paramMap1);
			
			if(CollectionUtils.isNotEmpty(imgList)) {
				for(ItemImgBO imgBO : imgList) {
					for(ItemBO itemBO : itemList) {
						if(imgBO.getItemId().equals(itemBO.getItemId())) {
							if(CollectionUtils.isEmpty(itemBO.getSmallImgList())) {
								itemBO.setSmallImgList(new ArrayList<>());
							}
							itemBO.getSmallImgList().add(imgBO);
						}
					}
				}
			}
		}
		
		return itemList;
	}
}
