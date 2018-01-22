package com.share.locker.common;

public class LockerConstants {
	public final static String OPERATION_BANNER = "OPERATION_BANNER";	//banner图片配置code
	public final static String OPERATION_CENTER = "OPERATION_CENTER";	//首页中间位置配置code
	
	public final static String MOCK_URL_BASE = "http://192.168.0.102:8080/locker/";
	
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
	
}
