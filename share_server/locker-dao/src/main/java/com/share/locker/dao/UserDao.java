package com.share.locker.dao;

import java.util.List;

import com.share.locker.bo.UserBO;

public interface UserDao {
	UserBO selectUserByEmail(String email);

	UserBO selectUserByPhoneNumber(String phoneNumber);

	UserBO selectUserById(Long userId);
	
	void insertUser(UserBO userBO);
	
	List<UserBO> selectAllPhoneUser();
}
