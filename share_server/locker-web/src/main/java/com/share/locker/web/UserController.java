package com.share.locker.web;

import java.io.OutputStream;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.share.locker.service.UserService;
import com.zheng.model.User;

@Controller
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/getUserInfo.json")
	public Object getUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		User user = userService.selectUserById(1);
		mav.addObject("user", user);
		OutputStream out = response.getOutputStream();
		out.write(user.getUserName().getBytes());
		Thread.sleep(1000);
		out.flush();
		out.close();
		return null;
	}
}
