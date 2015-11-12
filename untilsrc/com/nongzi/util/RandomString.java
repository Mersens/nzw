package com.nongzi.util;

import java.util.Random;

public class RandomString {

	/**
	 * 说明:
	 * 时间：2015-1-6
	 * 作者：朱庆杰
	 * @param args
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }  
	
	/**
	 * 说明:
	 * 时间：2015-1-6
	 * 作者：朱庆杰
	 * @param args
	 */
	public static String getRandombianhao(int length) { //length表示生成字符串的长度  
	    String base = "0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }  

}
