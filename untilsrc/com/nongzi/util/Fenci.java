package com.nongzi.util;

import java.io.IOException;
import java.io.StringReader;

import net.sf.json.JSONObject;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Fenci {

	/**
	 * 
	 * @param Text 分词的原数据
	 * @param IsType  分词的类型  false 细分   true 处分
	 * @return String 字符串
	 * @throws IOException
	 */
	public String fenciText(String Text , boolean IsType) throws IOException {
		if(Text==null || Text=="" || Text=="null") return null;
		StringReader sr=new StringReader(Text);  
     	IKSegmenter ik=new IKSegmenter(sr, IsType);  
     	
     	 StringBuffer sb = new StringBuffer();  
    	
     	Lexeme lex=null;  
     	while((lex=ik.next())!=null){  
     		System.out.println("111111111111111");
     		JSONObject data = new JSONObject();
     		sb.append(lex.getLexemeText()+",");
     		System.out.println(sb.toString()+"1111111");
      }  
		return sb.toString().substring(0, sb.toString().length()-1);  
	}

}
