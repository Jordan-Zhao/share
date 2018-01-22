package com.share.locker.common;

public class LockerConstants {
	public final static String OPERATION_BANNER = "OPERATION_BANNER";	//banner图片配置code
	public final static String OPERATION_CENTER = "OPERATION_CENTER";	//首页中间位置配置code
	
	public final static String MOCK_URL_BASE = "http://192.168.0.102:8080/locker/";
	
	public final static String KEY_REQUEST_LOGIN_USER = "loginUser";
	
	//item对应的图片尺寸大小编码
	public static enum ImgSizeCode{
        NORMAL("normal"),SMALL("small");
        private String sizeCode;

        ImgSizeCode(String sizeCode){
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
	 * @author Jordan
	 *
	 */
	public static enum ItemStatus{
		//有效效数据
        VALID("VALID"),
		//无效数据
        INVALID("INVALID"),
        //上架
        ON_LINE("ON_LINE"),
        //下架
        OFF_LINE("OFF_LINE");
        private String statusCode;

        ItemStatus(String statusCode){
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
	 * 租用计价时间单位
	 * @author Jordan
	 *
	 */
	public static enum PriceTimeUnit{
        DAY("DAY"),HALF_DAY("HALF_DAY"),HOUR("HOUR");
        private String code;

        PriceTimeUnit(String code){
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
