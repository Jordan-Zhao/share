package com.share.locker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.share.locker.service.UserService;
import com.zheng.dao.UserDao;
import com.zheng.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired  
    private UserDao userDao;  
  
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
          
    } 
}
