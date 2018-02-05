package com.share.locker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.SettingBO;
import com.share.locker.dao.SettingDao;

@Service
public class SettingServiceImpl extends BaseServiceImpl implements SettingService {
	
	@Autowired
	private SettingDao settingDao;
	
	public void saveOrUpdate(SettingBO settingBO) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", settingBO.getType());
		params.put("key", settingBO.getKey());
		SettingBO settingBO1 = settingDao.selectSetting(params);
		if(settingBO1 == null) {
			//插入
			settingDao.insertSetting(settingBO);
		}else {
			//update
			settingDao.updateSetting(params);
		}
	}
	
	public SettingBO getSetting(String type,String key) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("key", key);
		return settingDao.selectSetting(params);
	}
}
