package com.share.locker.dao;

import java.util.List;
import java.util.Map;

import com.share.locker.bo.CheckCodeBO;

public interface CheckCodeDao {
	void insertCheckCode(CheckCodeBO codeBO);
	
	List<CheckCodeBO> getCheckCodeList(Map<String, Object> params);
}
