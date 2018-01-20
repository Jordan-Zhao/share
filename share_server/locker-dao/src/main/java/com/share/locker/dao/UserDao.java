package com.share.locker.dao;

import com.share.locker.bo.UserBO;

public interface UserDao {
	UserBO selectUserByEmail(String email);

	UserBO selectUserByPhoneNumber(String phoneNumber);
}
