package com.share.locker.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.RegisterCodeBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.dao.RegisterCodeDao;

@Service
public class RegisterCodeServiceImpl extends BaseServiceImpl implements RegisterCodeService {
	
	@Autowired
	private RegisterCodeDao registerCodeDao;
	
	public RegisterCodeBO createRegisterCode(RegisterCodeBO codeBO) {
		registerCodeDao.insertRegisterCode(codeBO);
		return codeBO;
	}
	
	public RegisterCodeBO getRegisterCode(String registerId,String code) {
		Map<String, Object> params = new HashMap<>();
		params.put("registerId", registerId);
		params.put("code", code);
		params.put("status", LockerConstants.BaseDataStatus.VALID);
		return registerCodeDao.getRegisterCode(params);
	}
}
