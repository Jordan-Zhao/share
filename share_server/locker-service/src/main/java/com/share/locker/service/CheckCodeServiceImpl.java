package com.share.locker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.CheckCodeBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.StringUtil;
import com.share.locker.dao.CheckCodeDao;

@Service
public class CheckCodeServiceImpl extends BaseServiceImpl implements CheckCodeService {

	@Autowired
	private CheckCodeDao checkCodeDao;
	
	/**
	 * 生成code
	 * @param type
	 * @param checkId
	 * @return
	 */
	public String createCheckCode(String type, String checkId) {
		return createCheckCode(type, checkId,LockerConstants.VERIFY_CODE_EXPIRE_TIME); // 10分钟
	}
	
	/**
	 * 生成code
	 * @param type
	 * @param checkId
	 * @return
	 */
	public String createCheckCode(String type, String checkId, Long expireTime) {
		String code = StringUtil.getRandomNumberString();
		CheckCodeBO codeBO = new CheckCodeBO();
		codeBO.setType(type);
		codeBO.setCheckCode(code);
		codeBO.setCreateTime(new Date());
		codeBO.setEditor(LockerConstants.EDITOR_SYSTEM);
		codeBO.setEditTime(new Date());
		codeBO.setExpireTime(expireTime); // 10分钟
		codeBO.setStatus(LockerConstants.BaseDataStatus.VALID.toString());
		codeBO.setCheckId(checkId);
		checkCodeDao.insertCheckCode(codeBO);

		return code;
	}

	/**
	 * 是否过期
	 */
	public boolean isCodeValid(String type, String checkId, String checkCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("checkId", checkId);
		params.put("checkCode", checkCode);
		params.put("status", LockerConstants.BaseDataStatus.VALID.getCode());
		List<CheckCodeBO> checkCodeBOList = checkCodeDao.getCheckCodeList(params);
		if (CollectionUtils.isNotEmpty(checkCodeBOList)) {
			for (CheckCodeBO bo : checkCodeBOList) {
				if (System.currentTimeMillis() <= (bo.getCreateTime().getTime() + bo.getExpireTime())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 获取可用的code
	 */
	public CheckCodeBO getValidCheckCode(String type, String checkId) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("checkId", checkId);
		params.put("status", LockerConstants.BaseDataStatus.VALID.getCode());
		List<CheckCodeBO> checkCodeBOList = checkCodeDao.getCheckCodeList(params);
		checkCodeBOList = filterExpiredCheckCode(checkCodeBOList);
		if (CollectionUtils.isNotEmpty(checkCodeBOList)) {
			return checkCodeBOList.get(0);
		}
		return null;
	}
	
	/**
	 * 获取CodeBo
	 */
	public List<CheckCodeBO> getValidCheckCodeByCode(String type, String code) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("checkCode", code);
		params.put("status", LockerConstants.BaseDataStatus.VALID.getCode());
		List<CheckCodeBO> checkCodeBOList = checkCodeDao.getCheckCodeList(params);
		//过滤掉已过期的
		return filterExpiredCheckCode(checkCodeBOList);
	}
	
	private List<CheckCodeBO> filterExpiredCheckCode(List<CheckCodeBO> codeBOList){
		if (CollectionUtils.isNotEmpty(codeBOList)) {
			List<CheckCodeBO> resultList = new ArrayList<>();
			for (CheckCodeBO bo : codeBOList) {
				if (System.currentTimeMillis() < (bo.getCreateTime().getTime() + bo.getExpireTime())) {
					resultList.add(bo);
				}
			}
			return resultList;
		}
		return codeBOList;
	}
}
