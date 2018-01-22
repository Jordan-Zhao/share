package com.share.locker.service.util;

import javax.servlet.http.HttpServletRequest;

import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;

public class BizUtil {
	/**
	 * 获取登录用户
	 * @param request
	 * @return
	 */
	public static UserBO getLoginUser(HttpServletRequest request) {
		Object loginUser = request.getAttribute(LockerConstants.KEY_REQUEST_LOGIN_USER);
		return loginUser == null?null:(UserBO)loginUser;
	}
	
	/**
	 * 把页面输入的价格数字转成以“分”为单位的整数
	 * @param price
	 * @return
	 */
	public static int convertInputPrice2Int(String price) {
		return Math.round(Float.parseFloat(price)*100);
	}
	
	/**
	 * 把DB查出的价格数字转成以“元”为单位的float
	 * @param price
	 * @return
	 */
	public static Float convertInputPrice2Int(Integer price) {
		return (float)(price / 100.00);
	}
	
	public static void main(String[] arg) {
		String f = "100.554";
		System.out.println(convertInputPrice2Int(f));
	}
}
