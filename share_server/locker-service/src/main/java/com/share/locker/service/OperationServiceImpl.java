package com.share.locker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.OperationConfigBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.dao.OperationConfigDao;

@Service
public class OperationServiceImpl implements OperationService{

	@Autowired
	private OperationConfigDao operationConfigDao;

	public OperationConfigBO getOperationBannerConfig() {
		List<String> configCodeList = new ArrayList<>();
		configCodeList.add(LockerConstants.OPERATION_BANNER);
		return operationConfigDao.selectOperationConfigByCode(configCodeList).get(0);
	}
	
	public OperationConfigBO getOperationCenterConfig() {
		List<String> configCodeList = new ArrayList<>();
		configCodeList.add(LockerConstants.OPERATION_CENTER);
		return operationConfigDao.selectOperationConfigByCode(configCodeList).get(0);
	}
	
	public List<OperationConfigBO> getOperationConfig4HomePage() {
		List<String> configCodeList = new ArrayList<>();
		configCodeList.add(LockerConstants.OPERATION_BANNER);
		configCodeList.add(LockerConstants.OPERATION_CENTER);
		return operationConfigDao.selectOperationConfigByCode(configCodeList);
	}
	
}
