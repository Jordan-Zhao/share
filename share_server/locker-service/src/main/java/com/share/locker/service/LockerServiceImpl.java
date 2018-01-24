package com.share.locker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.LockerBO;
import com.share.locker.bo.MachineBO;
import com.share.locker.dao.LockerDao;
import com.share.locker.dao.MachineDao;

@Service
public class LockerServiceImpl extends BaseServiceImpl implements LockerService {
	@Autowired
	private LockerDao lockerDao;
	@Autowired
	private MachineDao machineDao;

	public LockerBO getLockerById(Long lockerId) {
		LockerBO lockerBO = lockerDao.selectLockerById(lockerId);
		MachineBO machineBO = machineDao.selectMachineById(lockerBO.getMachineId());
		lockerBO.setMachineBO(machineBO);
		return lockerBO;
	}
}
