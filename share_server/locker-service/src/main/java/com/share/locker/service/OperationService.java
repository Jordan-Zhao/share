package com.share.locker.service;

import java.util.List;

import com.share.locker.bo.OperationConfigBO;

public interface OperationService {
	OperationConfigBO getOperationBannerConfig();

	OperationConfigBO getOperationCenterConfig();

	List<OperationConfigBO> getOperationConfig4HomePage();
}
