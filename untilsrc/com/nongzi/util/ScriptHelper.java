package com.nongzi.util;

/**
 * ���ܣ�js���ܺ���
 * ��Ȩ���ƹ�
 */
public class ScriptHelper {
	//���캯��
	public ScriptHelper(){
		
	}
	/// <summary>
	/// ���¼��ر�ҳ
	/// </summary>
	public String Reload()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("<script language=\"javascript\">\n");
		sb.append("window.location.href=window.location.href;");
		sb.append("\n");
		sb.append("</script>");
        return sb.toString();
	}
	
	//��������´�ҳ��
	public String Redirect(String url)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<script language='javascript'>");
		sb.append("window.location.href ='");
		sb.append(url);
		sb.append("';");
		sb.append("</script>");
		return sb.toString();
	}
	
	/// <summary>
	/// ��ʾ��ʾ��Ϣ,����msgInfo-����ʾ����Ϣ,url-���ص�t�ӵ�ַ
	/// </summary>
	/// <param name="msgInfo"></param>
	public String ShowMessage(String msgInfo,String url)
	{  
		String strMessage;
		strMessage="<script language='javascript'>";
		strMessage=strMessage + "alert('" + msgInfo + "')" + ";";
		if (!"".equals(url) && url!=null)
			strMessage=strMessage + "window.location.href='" + url + "';";
		strMessage=strMessage + "</script>";
		return strMessage;
	}
	/**
	 * 跳转到父级
	 * @param msgInfo
	 * @param url
	 * @return
	 */
	public String ShowParentMessage(String msgInfo,String url)
	{  
		String strMessage;
		strMessage="<script language='javascript'>";
		strMessage=strMessage + "alert('" + msgInfo + "')" + ";";
		if (!"".equals(url) && url!=null)
			strMessage=strMessage + "window.parent.location.href='" + url + "';";
		strMessage=strMessage + "</script>";
		return strMessage;
	}
	/**
	 * Confirm 当用户选择是时，跳转到url，否则返回
	 * @param msgInfo	confirm内容
	 * @param okUrl	点击确定跳转到的url
	 * @param cancleUrl 点击取消跳转到的url
	 * @return String
	 */
	public String showConfirm(String msgInfo,String okUrl,String cancleUrl)
	{  
		StringBuffer sb=new StringBuffer();
		sb.append("<script language='javascript'>\n");
		sb.append("if(confirm('" + msgInfo + "')){\n");
		sb.append("window.location.href='" + okUrl + "';\n}else{\n");
		sb.append("window.location.href='" + cancleUrl + "';\n}\n");
		sb.append("</script>");
		return sb.toString();
	}

}