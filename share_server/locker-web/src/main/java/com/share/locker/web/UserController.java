package com.share.locker.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.service.UserService;

@Controller
public class UserController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	public Object login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBO loginUser = null;
		if (isEmail(userName)) {
			// email 登录
			loginUser = userService.getUserByEmail(userName);
		} else {
			loginUser = userService.getUserByPhoneNumber(userName);
		}
		if (loginUser == null || !loginUser.getPassword().equals(password)) {
			writeJsonMsg(response, false, "Login failed");
			return null;
		} else {
			writeJsonMsg(response, true, "Login successed");
			return null;
		}
	}
	
	/**
	 * 获取“我的”信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMineData.json", method = RequestMethod.POST)
	public Object getMineData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBO loginUser = null;
		if (isEmail(userName)) {
			// email 登录
			loginUser = userService.getUserByEmail(userName);
		} else {
			loginUser = userService.getUserByPhoneNumber(userName);
		}
		if (loginUser == null || !loginUser.getPassword().equals(password)) {
			writeJsonMsg(response, false, "Login failed");
			return null;
		} else {
			Map<String, Object> userInfoMap = new HashMap<>();
			userInfoMap.put("user_icon_url", LockerConstants.MOCK_URL_BASE + "icon11.png");
			userInfoMap.put("nick", loginUser.getNick());
			userInfoMap.put("email", loginUser.getEmail());
			userInfoMap.put("phone_number", loginUser.getPhoneNumber());
			writeJsonMsg(response, true, userInfoMap);
			return null;
		}
	}
	
	private boolean isEmail(String userName) {
		//TODO 优化
		return userName.contains("@");
	}
}
