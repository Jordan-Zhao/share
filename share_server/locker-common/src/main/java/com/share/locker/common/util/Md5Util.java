/**
 *@Title: Md5Util.java 
 * @Package com.taobao.wlb.res.web.manage.util 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 */
package com.share.locker.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5Util 
 * @Description: md5����
 * @author ��ګ
 * @date 2015-12-23 ����3:30:33 
 */
public class Md5Util {
	/**
	 * ���ɵ�MD5  MD5���ļ���+�ļ����ݽ���
	 * 
	 */
	public static String createMd5(File file) {
		try {
			return doCreateMd5(file);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * У��MD5
	 */
	public static boolean checkMd5(File file,String md5) {
		try {
			return doCheckMd5(file,md5);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String  doCreateMd5(File file) throws IOException, NoSuchAlgorithmException {
	return calcMd5(file);
	}

	private static boolean doCheckMd5(File file,String md5) throws IOException, NoSuchAlgorithmException {

		return md5.toString().trim().equalsIgnoreCase(calcMd5(file));
	}
	/**
	 * 
	 * @Title: calcMd5 
	 * @Description: md5У��  ���ļ�����+�ļ����ֹ�ͬ���
	 * @param @param file
	 * @param @return
	 * @param @throws IOException
	 * @param @throws NoSuchAlgorithmException    �趨�ļ� 
	 * @return String    �������� 
	 * @throws
	 */
	private static String calcMd5(File file) throws IOException, NoSuchAlgorithmException {
	
		byte[] buf = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance("md5");
		StringBuilder r = new StringBuilder();
			FileInputStream fin = new FileInputStream(file);
			int c;
			try {
				while ((c = fin.read(buf)) > 0) {
					md5.update(buf, 0, c);
				}
			} finally {
				fin.close();
			}
			//�����ļ������� 
			md5.update(file.getName().getBytes());
			r.append(binToHex(md5.digest()));
			// r.append(Base64.encodeBase64(md5.digest()));
		
		
		if (r.length() > 0) {
			r.setLength(r.length() - 1);
		}
		return r.toString();
	}

	private static String binToHex(byte[] b) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				s.append('0');
			}
			s.append(hex);
		}
		return s.toString();
	}
	
	public static void main(String[] args){
		
		File file=new File("D://����.sql");
		
		File file2=new File("D://119.dat");
		
		File file3=new File("D://���� - ����.sql");
		String fileMd5=Md5Util.createMd5(file);
		
		System.out.println(fileMd5);
		System.out.println(Md5Util.checkMd5(file, fileMd5));
		System.out.println(Md5Util.checkMd5(file2, fileMd5));
		System.out.println(Md5Util.checkMd5(file3, fileMd5));
		
	}
}
