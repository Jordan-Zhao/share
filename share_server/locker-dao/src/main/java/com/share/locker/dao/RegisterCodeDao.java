package com.share.locker.dao;

import java.util.Map;

import com.share.locker.bo.RegisterCodeBO;

public interface RegisterCodeDao {
	void insertRegisterCode(RegisterCodeBO codeBO);
	
	RegisterCodeBO getRegisterCode(Map<String, Object> params);
}
