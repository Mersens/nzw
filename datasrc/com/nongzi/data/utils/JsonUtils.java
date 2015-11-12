package com.nongzi.data.utils;

import net.sf.json.JSONObject;

public class JsonUtils {
	 public static String obj2json(Object obj) {  
		 if("".equals(obj) || null==obj){
			 obj=new Object();
		 }
	        JSONObject jsonObject = JSONObject.fromObject(obj); 
	        return jsonObject.toString();
	    }  
}
