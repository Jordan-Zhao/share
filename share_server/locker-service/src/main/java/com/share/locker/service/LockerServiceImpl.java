package com.share.locker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.LockerBO;
import com.share.locker.bo.MachineBO;
import com.share.locker.dao.LockerDao;
import com.share.locker.dao.MachineDao;
import com.share.locker.service.util.MockUtil;

@Service
public class LockerServiceImpl extends BaseServiceImpl implements LockerService {
	@Autowired
	private LockerDao lockerDao;
	@Autowired
	private MachineDao machineDao;

	public LockerBO getLockerById(Long lockerId) {
		//Mock
		LockerBO lockerBO = new LockerBO();
		lockerBO.setLockerId(lockerId);
		MachineBO machineBO = new MachineBO();
		machineBO.setMachineId(1L);
		machineBO.setName(MockUtil.getMachineNameBylockerId(lockerId));
		lockerBO.setMachineBO(machineBO);
		return lockerBO;
	}
}
