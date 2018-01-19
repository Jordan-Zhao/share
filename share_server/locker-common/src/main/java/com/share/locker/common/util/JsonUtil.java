package com.share.locker.common.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;



public class JsonUtil {

	/** The Constant LOG. */
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

	/**
	 * json�����ַ���ת����list
	 * 
	 */
	public static List jsonArraytoObject(String jsonArray,Class c) {
		if(StringUtil.isEmpty(jsonArray)){
			log.warn("jsonArraytoObject error.json:{};c:{}",jsonArray,c);
			return null;
		}
		List rs = new ArrayList();
		JSONArray arr = JSONArray.fromObject(jsonArray);
		for(int i = 0;i < arr.size(); i++){
			rs.add(JSONObject.toBean(arr.getJSONObject(i), c));
		}
		return rs;
	}
	
	public static String toJson(Object obj){
		if(obj == null){
			return null;
		}
		StringWriter out = new StringWriter();
		try {
			ObjectMapper oMapper = new ObjectMapper();
			oMapper.writeValue(out, obj);
		} catch (Exception e) {
			log.error("toJson.error={}", obj);
			throw new RuntimeException("toJson.exception:" + obj, e);
		}
		return out.toString();
	}
	
	public static Object getObject(String json,Class cls){
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(json);
        return  JSONObject.toBean(jsonObject,cls); 
	}
	
	public static Object getObject(String json,Class cls,Map map){
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(json);
        return  JSONObject.toBean(jsonObject,cls,map); 
	}

	public static void main(String[] arg){
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 23);
		map.put("data",new ArrayList());
		System.out.println(toJson(map));*/
		
		//=====================================
		User user = new User();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("isSuccess", true);
		map2.put("msg", null);
		map2.put("data", user);
		System.out.println(toJson(map2));
	}
	
	static class User{
		public int id = 1001;
		public String name = "jordan";
	}
}
