package com.share.locker.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.bo.UserBO;
import com.share.locker.dao.UserDao;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserBO getUserByEmail(String email) {
		return userDao.selectUserByEmail(email);
	}

	public UserBO getUserByPhoneNumber(String phoneNumber) {
		return userDao.selectUserByPhoneNumber(phoneNumber);
	}

	public UserBO getUserById(Long userId) {
		return userDao.selectUserById(userId);
	}
	
	public UserBO register(UserBO userBO) {
		userDao.insertUser(userBO);
		return userBO;
	}
	
	public UserBO getRandomUser() {
		List<UserBO> allUserList = userDao.selectAllPhoneUser();
		return allUserList.get(new Random().nextInt(allUserList.size() - 1));
	}
}
