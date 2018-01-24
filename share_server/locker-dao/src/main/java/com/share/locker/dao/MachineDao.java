package com.share.locker.dao;

import com.share.locker.bo.MachineBO;

public interface MachineDao {
	MachineBO selectMachineById(Long machineId);
}
