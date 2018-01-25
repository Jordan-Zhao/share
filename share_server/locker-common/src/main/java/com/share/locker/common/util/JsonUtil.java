package com.share.locker.common.util;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	/** The Constant LOG. */
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
	
	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	 /**
     * json 转 map
     *
     * @param jsonStr
     * @return
     */
    public static HashMap json2Map(String jsonStr) {
        Gson gson = new Gson();
        HashMap hashMap = gson.fromJson(jsonStr, HashMap.class);
        return hashMap;
    }

    /**
     * json 转 Object
     *
     * @param jsonStr
     * @return
     */
    public static Object json2Object(String jsonStr,Class c) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, c);
    }

    /**
     * json 转 list
     *
     * @param jsonStr
     * @param typeToken  list中的类构建的TypeToken
     * @return
     */
    public static List json2List(String jsonStr,TypeToken typeToken) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, typeToken.getType());
    }
    /*
    public static void main(String[] arg) {
    	String json = "[{\"imgUrl\":\"http://192.168.0.104:8080/locker/banner1.png\",\"itemId\":46}]";
    	List list = json2List(json, new TypeToken<BannerDTO>() {}) ;  			
    }*/
}
