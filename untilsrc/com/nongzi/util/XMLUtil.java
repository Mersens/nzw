package com.nongzi.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * DOM解析XML
 * 通过获取子节点方法
 * @author 朱庆杰
 *
 */
public class XMLUtil {
	/*
	 * XML 文件文档
	 */
	private Document doc=null;
	
	/**
	 * 根据xml内容直接生成xml dom
	 * @param xmlContent xml内容
	 * @param flag 无用，为了和构造函数根据路径生成区别开。
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public XMLUtil(String xmlContent,String flag) throws ParserConfigurationException, SAXException, IOException{
		StringReader sr = new StringReader(xmlContent);
		InputSource is = new InputSource(sr); 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		//不检查DTD
		db.setEntityResolver( new EntityResolver() {
			 public InputSource resolveEntity(String publicId, String systemId)  
			         throws SAXException, IOException {                   
				   return new InputSource(new StringReader(""));
			 }
			}   
		);
		//读取文件
		doc=db.parse(is);
	}
	
	/**
	 * 根据xml文件路径生成xml dom
	 * @param xmlFilePath xml文件路径
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public XMLUtil(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		//不检查DTD
		db.setEntityResolver( new EntityResolver() {
			 public InputSource resolveEntity(String publicId, String systemId)  
			         throws SAXException, IOException {                   
				   return new InputSource(new StringReader(""));
			 }
			}   
		);
		//读取文件
		doc=db.parse(new File(xmlFilePath));
	}
	
	/**
	 * 根据流生成xml dom
	 * @param is 流
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public XMLUtil(InputSource is) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		//不检查DTD
		db.setEntityResolver( new EntityResolver() {
			 public InputSource resolveEntity(String publicId, String systemId)  
			         throws SAXException, IOException {                   
				   return new InputSource(new StringReader(""));
			 }
			}   
		);
		//读取文件
		doc=db.parse(is);
	}
	
	/**
	 * 根据节点名称读取节点列表
	 * @param nodeName 节点名称
	 * @return NodeList
	 */
	public NodeList readNode(String nodeName){
		return doc.getElementsByTagName(nodeName);
	}
	
	/**
	 * 更新某个节点的内容
	 * @param nodeName 节点名称
	 * @param index 节点序号
	 * @param newContent 新节点内容
	 */
	public void updateNodeContent(String nodeName,int index,String newContent){
		NodeList nodeList=doc.getElementsByTagName(nodeName);
		//有这个节点时才更新
		if(nodeList.getLength()>=(index+1)){
			nodeList.item(index).setTextContent(newContent);
		}
	}
	
	/**
	 * XML org.w3c.dom.Document 转 String
	 * @throws Exception 
	 */
	public String xmlToString() throws Exception {
		// XML转字符串
		String xmlStr = "";
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty("encoding", "UTF-8");// 解决中文问题，试过用GBK不行
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		t.transform(new DOMSource(doc), new StreamResult(bos));
		xmlStr = bos.toString();
		return xmlStr;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			XMLUtil a=new XMLUtil("d://CorpBindRsp.xml");
			System.out.println(a.xmlToString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
