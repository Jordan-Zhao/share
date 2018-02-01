package com.share.locker.service.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.share.locker.bo.UserBO;
import com.share.locker.common.LockerConstants;

public class BizUtil {
	/**
	 * 获取登录用户
	 * 
	 * @param request
	 * @return
	 */
	public static UserBO getLoginUser(HttpServletRequest request) {
		Object loginUser = request.getAttribute(LockerConstants.KEY_REQUEST_LOGIN_USER);
		return loginUser == null ? null : (UserBO) loginUser;
	}

	/**
	 * 把页面输入的价格数字转成以“分”为单位的整数
	 * 
	 * @param price
	 * @return
	 */
	public static int convertInputPrice2Int(String price) {
		return Math.round(Float.parseFloat(price) * 100);
	}

	/**
	 * 把DB查出的价格数字转成以“元”为单位的float
	 * 
	 * @param price
	 * @return
	 */
	public static Float convertDbPrice2Float(Integer price) {
		return (float) (price / 100.00);
	}

	/**
	 * 把DB数据转化成页面显示的价格字符串
	 * 
	 * @param priceTime
	 * @param priceTimeUnit
	 * @param price
	 * @return 每 天 5元
	 */
	public static String convertPrice2Str(Integer priceTime, String priceTimeUnit, Integer price) {
		StringBuilder sb = new StringBuilder();
		if (priceTime.equals(1)) {
			sb.append("每");
		} else {
			sb.append(priceTime.toString());
		}
		sb.append(LockerConstants.PriceTimeUnit.valueOf(priceTimeUnit).getName()).append(convertDbPrice2Float(price))
				.append("元");
		return sb.toString();
	}
	
	/**
	 * 获取验证码剩余时间
	 * @param createTime
	 * @param expireTime
	 * @return
	 */
	public static int getCheckCodeRemainTime(Date createTime,Long expireTime) {
		Long currentTime = System.currentTimeMillis();
		Long createTimeMills = createTime.getTime();
		Long remainTimeMills = expireTime - (currentTime - createTimeMills);
		if(remainTimeMills < 1000*30) {
			//剩余时间小于半分钟
			return 0;
		}
		Float remainMin = 1.0f*remainTimeMills /(1000*60);
		return Math.round(remainMin);
	}

	public static void main(String[] arg) {
		String f = "100.554";
		System.out.println(convertInputPrice2Int(f));
	}
	
	/**
	 * 获取已租用时长,页面显示的string
	 * @param priceTimeUnit
	 * @return
	 */
	public static String getRentTimeStr(Date startTime, String priceTimeUnit) {
		float rentTime = getRentTime(startTime, priceTimeUnit);
		if(LockerConstants.PriceTimeUnit.DAY.getCode().equals(priceTimeUnit)) {
			return rentTime+"天";
		}else if(LockerConstants.PriceTimeUnit.HALF_DAY.getCode().equals(priceTimeUnit)) {
			return rentTime+"天";
		}else if(LockerConstants.PriceTimeUnit.HOUR.getCode().equals(priceTimeUnit)) {
			return rentTime + "小时";
		}
		return "";
	}
	
	/**
	 * 计算租金
	 * @param startTime
	 * @param priceTime
	 * @param priceTimeUnit
	 * @param price
	 * @return
	 */
	public static Float getRentFee(Date startTime,Integer priceTime,String priceTimeUnit,Float price) {
		float rentTime = getRentTime(startTime, priceTimeUnit);
		float rentFee = rentTime / priceTime * price;
		return Math.round(rentFee*100)/100.0f;
	}
	
	/**
	 * 获取已租用时长
	 * @param priceTimeUnit
	 * @return
	 */
	private static float getRentTime(Date startTime, String priceTimeUnit) {
		long curTimeMills = System.currentTimeMillis();
		long startTimeMills = startTime.getTime();
		long timeMin = (curTimeMills - startTimeMills)/(1000*60); //分钟
		if(LockerConstants.PriceTimeUnit.DAY.getCode().equals(priceTimeUnit)) {
			double days = 1.0*timeMin / (60*24);
			return Math.round(days);
		}else if(LockerConstants.PriceTimeUnit.HALF_DAY.getCode().equals(priceTimeUnit)) {
			double halfDays = 1.0*timeMin / (60*12);
			return (Math.round(halfDays)) / 2;
		}else if(LockerConstants.PriceTimeUnit.HOUR.getCode().equals(priceTimeUnit)) {
			double hours = 1.0*timeMin / 60;
			return Math.round(hours);
		}
		return -1;
	}
}
