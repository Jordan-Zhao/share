/**
 *@Title: LogUtil.java 
 * @Package com.taobao.wlb.res.biz.util 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 */
package com.share.locker.common.util;

/**
 * @ClassName: LogUtil 
 * @Description: TODO(������һ�仰��������������) 
 * @author ��ګ
 * @date 2016-1-7 ����5:23:49 
 */
public class LogUtil {
	//TODO: 分业务日志和系统日志，打到不同路径
	/**
	 * 
	 * @Title: logMessageSend 
	 * @Description: topic+messageId ȷ����Ϣ   
	 * @param @param topic
	 * @param @param messageType
	 * @param @param messageID
	 * @param @param bussinessMessage
	 * @param @param success
	 * @param @return    �趨�ļ� 
	 * @return String    �������� 
	 * @throws
	 */
	public static String  logMessageSend(String topic,String messageType,String messageID,String bussinessMessage,boolean success){
		StringBuffer sb=new StringBuffer();
		sb.append("send,");
		sb.append(topic+",");
		sb.append(messageType+",");
		sb.append(messageID+","+"(");
		sb.append(bussinessMessage+")"+",");
		sb.append(success);
		return sb.toString();
	}
	
	public static String  logMessageRecieve(String topic,String messageType,String messageID,String bussinessMessage,boolean success){
		StringBuffer sb=new StringBuffer();
		sb.append("recieve,");
		sb.append(topic+",");
		sb.append(messageType+",");
		sb.append(messageID+","+"(");
		sb.append(bussinessMessage+")"+",");
		sb.append(success);
		return sb.toString();
	}
	
}
