package com.share.locker.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;
import com.share.locker.common.util.StringUtil;
import com.share.locker.service.UserService;

public class LockerFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		bindLoginUserToRequest((HttpServletRequest) request);

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	private void bindLoginUserToRequest(HttpServletRequest request) {
		// 提取request中的userName和password参数
		String userName = null;
		String password = null;
		userName = request.getParameter("userName");
		password = request.getParameter("password");

		// 存在用户登录信息，则取用户数据
		if (userName != null && password != null) {
			UserBO loginUser = null;
			UserService userService = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext())
					.getBean(UserService.class);
			if (StringUtil.isPhoneNumber(userName)) {
				loginUser = userService.getUserByPhoneNumber(userName);
			} else {
				loginUser = userService.getUserByEmail(userName);
			}
			if (loginUser != null) {
				request.setAttribute(LockerConstants.KEY_REQUEST_LOGIN_USER, loginUser);
			}
		}
	}

}
