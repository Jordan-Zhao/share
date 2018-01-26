package com.share.locker.service.util;

import java.util.Random;

public class MockUtil {
	private final static String[] nickArr = {"村里小芳","孤独求败","摘花骑士","雷神","巨魔"};
	
	private final static String SERVER = "http://192.168.0.104:8080/";
	public final static String MOCK_URL_BASE = SERVER+"locker/";
	
	public final static String MOCK_IMAGE_FILE_PATH = "C:\\dev\\IDE\\apache-tomcat-8.5.24\\webapps\\images\\";
	public final static String MOCK_URL_IMAGE = SERVER+"images/";

	/*
	 * public final static String MOCK_URL_BASE =
	 * "http://192.168.2.195:8080/locker/";
	 */

	public final static Integer MOCK_COMMENT_NUMBER = 99;
	
	public final static String MOCK_ICON_URL = MOCK_URL_BASE+"icon1.png";
	
	public static String getRandomNick() {
		int idx = new Random().nextInt(nickArr.length-1);
		return nickArr[idx]+new Random().nextInt(999999);
	}
}
