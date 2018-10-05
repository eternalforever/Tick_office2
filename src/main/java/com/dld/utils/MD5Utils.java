package com.dld.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String md5(String password){
		try {
			//获取摘要对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//设置要签名的内容
			md.update(password.getBytes());
			//获取摘要结果
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}