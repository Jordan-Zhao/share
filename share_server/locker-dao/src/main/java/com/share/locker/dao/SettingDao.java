package com.share.locker.dao;

import java.util.Map;

import com.share.locker.bo.SettingBO;

public interface SettingDao {
	SettingBO selectSetting(Map<String, Object> params);
	
	Long insertSetting(SettingBO settingBO);
	
	void updateSetting(Map<String, Object> params);
}
