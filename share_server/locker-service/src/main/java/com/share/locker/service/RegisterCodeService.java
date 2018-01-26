package com.share.locker.service;

import com.share.locker.bo.RegisterCodeBO;

public interface RegisterCodeService {
	RegisterCodeBO createRegisterCode(RegisterCodeBO codeBO);
	
	RegisterCodeBO getRegisterCode(String key,String code);
}
