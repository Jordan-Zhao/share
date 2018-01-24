package com.share.locker.service;

import com.share.locker.bo.LockerBO;

public interface LockerService {
	LockerBO getLockerById(Long lockerId);
}
