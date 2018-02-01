package com.share.locker.service;

import java.util.List;

import com.share.locker.bo.CheckCodeBO;

public interface CheckCodeService {
	String createCheckCode(String type, String checkId);
	
	String createCheckCode(String type, String checkId,Long expireTime);
	
	boolean isCodeValid(String type,String checkId,String checkCode);
	
	CheckCodeBO getValidCheckCode(String type,String checkId);
	
	List<CheckCodeBO> getValidCheckCodeByCode(String type, String code);
}
