package com.share.locker.service;

import com.share.locker.bo.SettingBO;

public interface SettingService {
	void saveOrUpdate(SettingBO settingBO);

	SettingBO getSetting(String type,String key);
}
