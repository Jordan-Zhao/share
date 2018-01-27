package com.share.locker.service;

import java.util.List;

import com.share.locker.bo.CheckCodeBO;

public interface CheckCodeService {
	String createCheckCode(String type, String checkId);
	
	boolean isCodeValid(String type,String checkId,String checkCode);
	
	String getValidCheckCode(String type,String checkId);
	
	List<CheckCodeBO> getValidCheckCodeByCode(String type, String code);
}
