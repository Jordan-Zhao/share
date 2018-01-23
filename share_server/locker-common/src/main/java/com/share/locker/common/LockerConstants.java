package com.share.locker.common;

import java.util.ArrayList;
import java.util.List;

public class LockerConstants {
	public final static String OPERATION_BANNER = "OPERATION_BANNER"; // banner图片配置code
	public final static String OPERATION_CENTER = "OPERATION_CENTER"; // 首页中间位置配置code

	//public final static String MOCK_URL_BASE = "http://192.168.0.102:8080/locker/";

	public final static String MOCK_URL_BASE = "http://192.168.2.195:8080/locker/";

	public final static String KEY_REQUEST_LOGIN_USER = "loginUser";

	// item对应的图片尺寸大小编码
	public static enum ImgSizeCode {
		NORMAL("normal"), SMALL("small");
		private String sizeCode;

		ImgSizeCode(String sizeCode) {
			this.sizeCode = sizeCode;
		}

		public String getSizeCode() {
			return sizeCode;
		}

		public void setSizeCode(String sizeCode) {
			this.sizeCode = sizeCode;
		}
	}

	/**
	 * 宝贝数据状态
	 * 
	 * @author Jordan
	 *
	 */
	public static enum ItemStatus {
		// 有效效数据
		TO_PUT("TO_PUT"),
		// 无效数据
		INVALID("INVALID"),
		// 上架
		ON_LINE("ON_LINE"),
		// 下架
		OFF_LINE("OFF_LINE");
		private String statusCode;

		ItemStatus(String statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}
	}

	/**
	 * 我的宝贝 列表 ，状态
	 */
	public final static List<String> MY_ITEM_STATUS_LIST = new ArrayList<>();
	static{
		MY_ITEM_STATUS_LIST.add(ItemStatus.TO_PUT.getStatusCode());
		MY_ITEM_STATUS_LIST.add(ItemStatus.OFF_LINE.getStatusCode());
		MY_ITEM_STATUS_LIST.add(ItemStatus.OFF_LINE.getStatusCode());
	}

	/**
	 * 租用计价时间单位
	 * 
	 * @author Jordan
	 *
	 */
	public static enum PriceTimeUnit {
		DAY("DAY", "天"), HALF_DAY("HALF_DAY", "半天"), HOUR("HOUR", "小时");
		private String code;
		private String name;

		PriceTimeUnit(String code, String name) {
			this.code = code;
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
	/**
	 * 基本的数据状态
	 * @author Jordan
	 *
	 */
	public static enum BaseDataStatus{
		VALID("valid"),INVALID("invalid");
		private String code;
		BaseDataStatus(String code){
			this.code = code;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	}
	
	

}
