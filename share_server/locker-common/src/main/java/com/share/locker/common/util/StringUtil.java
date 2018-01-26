package com.share.locker.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtil {

	/**
	 * 判断字符串是不是邮箱
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isEmail(String userName) {
		// TODO 优化
		return userName.contains("@");
	}

	/**
	 * 判断字符串是不是手机号
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isPhoneNumber(String userName) {
		if (userName == null || userName.trim().length() < 1) {
			return false;
		}
		try {
			String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
			Pattern p = Pattern.compile(regExp);
			Matcher m = p.matcher(userName);
			return m.matches();
		} catch (PatternSyntaxException ex) {
			return false;
		}
	}
	
	/**
	 * 对敏感字段用星号代替
	 * @param s
	 * @return
	 */
	public static String getMaskString(String s) {
		if(!isEmpty(s)) {
			if(s.length() == 1) {
				return s+"***";
			}else if(s.length() < 5) {
				return s.substring(0, 1)+"***"+s.substring(s.length()-1);
			}else {
				return s.substring(0,3)+"***"+s.substring(s.length() - 2);
			}
		}
		return s;
	}

	/**
	 * ������ɹ̶����ȵ��ַ���
	 * 
	 * @param length
	 * @return String
	 */
	public static String getRandomString(int length) { // length��ʾ�����ַ����ĳ���
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * �ж��ַ����������Ƿ����ĳ�ַ���
	 * 
	 * @param source
	 * @param needle
	 * @return
	 */
	public static Boolean isHave(String right, String needle) {
		if (right == null || needle == null)
			return false;
		String[] source = right.split(";");
		for (String s : source) {
			if (s.equals(needle))
				return true;
		}
		return false;
	}

	/**
	 * ������2��ͷ�����16λ���ִ�������pk
	 * 
	 * @return
	 */
	public static String uuid() {
		String timeStamp = String.valueOf(System.currentTimeMillis());
		return "2" + randomNumString(4) + timeStamp.substring(2);
	}

	/**
	 * ���ɴ����ֵ������
	 * 
	 * @param length
	 * @return
	 */
	public static final String randomNumString(int length) {
		Random random = new Random(System.nanoTime());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(10);
			sb.append(number);
		}
		return sb.toString();
	}

	/**
	 * ����ַ����Ƿ�Ϊ<code>null</code>����ַ���<code>""</code>��
	 * 
	 * <pre>
	 * StringUtil.isEmpty(null) = true
	 * StringUtil.isEmpty("") = true
	 * StringUtil.isEmpty(" ") = false
	 * StringUtil.isEmpty("bob") = false
	 * StringUtil.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * @param str
	 *            Ҫ�����ַ���
	 * @return ���Ϊ��, �򷵻�<code>true</code>
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	public static boolean isInt(String str) {
		if (isEmpty(str)) {
			return false;
		}
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		// string
		if (obj instanceof String) {
			return obj.toString();
		}
		// ����
		if (obj instanceof List || obj.getClass().isArray()) {
			return JSONArray.fromObject(obj).toString();
		}
		// ����
		JSONObject jsonObject = JSONObject.fromObject(obj);
		if (!jsonObject.isEmpty()) {
			return jsonObject.toString();
		}
		return String.valueOf(obj);
	}

	public static Object toObject(String json, Class c) {
		return JSONObject.toBean(JSONObject.fromObject(json), c);
	}

	public static boolean isInStringArray(String[] arr, String s) {
		if (arr == null || arr.length == 0 || isEmpty(s)) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public static String contactStrings(List<String> list, String separator) {
		if (CollectionUtil.isEmptyArray(list)) {
			return null;
		}
		StringBuilder sBuilder = new StringBuilder();
		for (String s : list) {
			sBuilder.append(s).append(separator);
		}
		return sBuilder.toString().substring(0, sBuilder.toString().length() - 1);
	}

	public static void main(String[] arg) {
	/*	List<String> list = new ArrayList<String>();
		list.add("zzzzz");
		list.add("xxxx");
		System.out.println(contactStrings(list, ","));*/
		
		System.out.println(getMaskString("18676"));

	}

}
