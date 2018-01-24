package com.share.locker.dao;

import com.share.locker.bo.LockerBO;

public interface LockerDao {
	LockerBO selectLockerById(Long lockerId);

}
