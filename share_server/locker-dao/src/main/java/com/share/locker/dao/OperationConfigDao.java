package com.share.locker.dao;


import java.util.List;

import com.share.locker.bo.OperationConfigBO;

public interface OperationConfigDao {
	public List<OperationConfigBO> selectOperationConfigByCode(List<String> configCodeList);  
}
