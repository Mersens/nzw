package com.nongzi.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

/**
 * 基本的工具类，包含很多工具函数。
 * @author 朱庆杰
 *
 */
public class BaseUtil {

	public BaseUtil() {
	}

	/**
	 * 重新加载页面。<br/>
	 * 执行方法 response.getWrite().print(此函数返回值);
	 * @return String 
	 */
	public String Reload() {
		StringBuilder sb = new StringBuilder();
		sb.append("<script language=\"javascript\">\n");
		sb.append("window.location.href=window.location.href;");
		sb.append("\n");
		sb.append("</script>");
		return sb.toString();
	}
	public String Html2Text(String inputString) {
		String htmlStr = inputString; // ��html��ǩ���ַ�
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // ����script��������ʽ{��<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // ����style��������ʽ{��<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // ����HTML��ǩ��������ʽ

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // ����script��ǩ

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // ����style��ǩ

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // ����html��ǩ

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("yjxHtml2Text().Html2Text: " + e.getMessage());
		}

		return textStr;// �����ı��ַ�
	}

	/**
	 * 重定向到一个地址
	 * <br/>
	 * 执行方法 response.getWrite().print(此函数返回值);
	 * @param url 地址
	 * @return String
	 */
	public String Redirect(String url) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script language='javascript'>");
		sb.append("window.location.href ='");
		sb.append(url);
		sb.append("';");
		sb.append("</script>");
		return sb.toString();
	}

	/**
	 * 弹出一个confirm，如果用户点击了是重定向到url页面。否则仍然停留在此页面。
	 * @param msgInfo confirm 弹出的信息提示
	 * @param url 点击确定后重定向到的地址
	 * @param response
	 * @throws IOException 
	 */
	public void ShowMessage(String msgInfo, String url,
			HttpServletResponse response) throws IOException {
		String strMessage;
		strMessage = "<script language='javascript'>";
		strMessage = strMessage + "alert('" + msgInfo + "')" + ";";
		if (!"".equals(url) && url != null)
			strMessage = strMessage + "window.location.href='" + url + "';";
		strMessage = strMessage + "</script>";
		response.getWriter().print(strMessage);
	}

	/**
	 * Confirm 当用户选择是时，跳转到url，否则返回
	 * @param msgInfo	confirm内容
	 * @param okUrl	点击确定跳转到的url
	 * @param cancleUrl 点击取消跳转到的url
	 * @return String
	 */
	public String showConfirm(String msgInfo, String okUrl, String cancleUrl) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script language='javascript'>\n");
		sb.append("if(confirm('" + msgInfo + "')){\n");
		sb.append("window.location.href='" + okUrl + "';\n}else{\n");
		sb.append("window.location.href='" + cancleUrl + "';\n}\n");
		sb.append("</script>");
		return sb.toString();
	}

	/**
	 * 通过url和postdata获取返回值。该函数为主要函数可以copy使用返回值为一个Html页面的数据。
	 * @param url post的url
	 * @param postData post的data
	 * @return String
	 * @throws Exception 
	 */
	public String postData(String url, String postData) throws Exception {
		String data = null;
		URL dataUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) dataUrl.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Proxy-Connection", "Keep-Alive");
		con.setDoOutput(true);
		con.setDoInput(true);

		OutputStream os = con.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.write(postData.getBytes());
		dos.flush();
		dos.close();

		InputStream is = con.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		byte d[] = new byte[dis.available()];
		dis.read(d);
		data = new String(d);
		con.disconnect();
		return data;
	}

	/**
	 * 得到某个时间的时间戳 yyyyMMddHHmmss
	 * 
	 * @param date
	 *            时间
	 * @return String
	 */
	public String getTimeStamp(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 得到classpath路径。
	 * 
	 * @return String
	 */
	public String getClassPath() {
		String strResult = null;
		if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
			strResult = BaseUtil.class.getResource("/").toString().replace(
					"file:/", "").replace("%20", " ");
		} else {
			strResult = BaseUtil.class.getResource("/").toString().replace(
					"file:", "").replace("%20", " ");
		}
		return strResult;
	}

	/**
	 * 随机一个指定位数的正整数，并将其转换为字符串作为函数的返回值
	 * 
	 * @param numberLength
	 *            数字的位数
	 * @return String
	 */
	public String randomNumber(int numberLength) {
		// 记录生成的每一位随机数
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numberLength; i++) {
			// 每次生成一位,随机生成一个0-10之间的随机数,不含10。
			Double ranDouble = Math.floor(Math.random() * 10);
			sb.append(ranDouble.intValue());
		}
		return sb.toString();
	}

	/**
	 * 格式化double多少位小数
	 * 
	 * @param value
	 *            原double
	 * @param decimals
	 *            小数位数
	 * @return 格式化后的double
	 */
	public String formatDouble(double value, int decimals) {
		String doubleStr = "" + value;
		int index = doubleStr.indexOf(".") != -1 ? doubleStr.indexOf(".")
				: doubleStr.indexOf(",");
		// Decimal point can not be found...
		if (index == -1)
			return doubleStr;
		// Truncate all decimals
		if (decimals == 0) {
			return doubleStr.substring(0, index);
		}

		int len = index + decimals + 1;
		if (len >= doubleStr.length())
			len = doubleStr.length();

		double d = Double.parseDouble(doubleStr.substring(0, len));
		return String.valueOf(d);
	}

	// 地球半径 6378.137 公里
	private double EARTH_RADIUS = 6378.137;

	private double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据地球上两点经纬度，计算两点的距离
	 * 
	 * @param lat1
	 *            第一个点的纬度
	 * @param lng1
	 *            第一个点的经度
	 * @param lat2
	 *            第儿个点的纬度
	 * @param lng2
	 *            第二个点的经度
	 * @return 公里
	 */
	public double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		// s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * 得到文件的扩展名
	 * 
	 * @param fileName
	 *            文件全名
	 * @return
	 */
	public String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	/**
	 * 将文件从一个地方copy另一个地方
	 * @param src 源文件
	 * @param dst 目标文件
	 * @throws Exception 
	 */
	public void copy(File src, File dst) throws Exception {
		int BUFFER_SIZE = 16 * 1024;
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 模仿php的empty函数(判断一个对象是不是null或者是不是空字符)
	 * 
	 * @param object
	 *            object
	 * @return boolean
	 */
	public boolean isEmpty(Object obj) {
		if (obj == null || "".equals(obj.toString()))
			return true;
		else
			return false;
	}

	/**
	 * 将日期按照一定的格式进行格式化
	 * 
	 * @param date
	 *            日期
	 * @param formate
	 *            格式化格式
	 * @return String 格式后的日期字符串
	 */
	public String toString(Date date, String formate) {
		DateFormat df = new SimpleDateFormat(formate);
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 将字符串按照一定的编码格式进行转换
	 * 
	 * @param s
	 *            源字符串
	 * @param iso
	 *            编码格式，例如"utf-8"
	 * @return 编码后的字符串
	 * @throws UnsupportedEncodingException 
	 */
	public String toString(String s, String iso)
			throws UnsupportedEncodingException {
		if (s == null) {
			return "";
		} else {
			byte[] b = new byte[0];
			b = s.getBytes("8859_1");
			String out = "";
			out = new String(b, iso);
			return out;
		}
	}

	/**
	 * 用于字符串过长时显示指定的长度+...
	 * 
	 * @param s
	 *            元字符串
	 * @param length
	 *            字符串最长显示的长度
	 * @return 转换后的字符串
	 */
	public String trimString(String s, int length) {
		if (s == null) {
			return "";
		} else if (s.length() > length) {
			return s.substring(0, length - 3) + "...";
		} else {
			return s;
		}
	}

	/**
	 * 将日期转换成短日期字符串 例如：2009-09-09
	 * 
	 * @param date
	 *            源日期
	 * @return String 转换后的短日期
	 */
	public String toShortDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 将日期转换成长日期字符串 例如：2009-09-09 01:01:01
	 * 
	 * @param date
	 *            源日期
	 * @return String 转换后的长日期字符串
	 */
	public String toLongDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 转换日期到分钟，例如：2009-09-09 01:01
	 * 
	 * @param date
	 *            源日期
	 * @return String 转换后的日期字符串
	 */
	public String toDateMin(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 只得到当前时间的小时和分钟，例如：23:21
	 * 
	 * @param date
	 *            源日期
	 * @return String
	 */
	public String toHourMin(Date date) {
		DateFormat df = new SimpleDateFormat("HH:mm");
		return (null == date) ? "" : df.format(date);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss字符串转换成日期<br/> 如果s为null或者为""直接返回null
	 * @param s yyyy-MM-dd HH:mm:ss字符串
	 * @return Date 日期
	 * @throws ParseException  字符串转换日期失败
	 */
	public Date toDate(String s) throws ParseException {
		if (s == null || "".equals(s)) {
			return null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = new Date();
			d = sdf.parse(s);
			return new Date(d.getTime());
		}
	}

	/**
	 * 得到今天的最后一秒的时间
	 * 
	 * @param d
	 *            今天的某个时间
	 * @return Date 今天最后一秒的时间
	 */
	public Date getDayEnd(Date d) {
		if (d == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 得到今天的第一秒的时间
	 * 
	 * @param d
	 *            今天的某个时间
	 * @return Date 今天第一秒的时间
	 */
	public Date getDayStart(Date d) {
		if (d == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return new Date(c.getTimeInMillis());

	}

	/**
	 * 将日历转换为 "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param calValue
	 *            日历
	 * @return String
	 */
	public String getStr(Calendar calValue) {
		return getStr(calValue, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将日历类型转换为指定格式的字符串
	 * 
	 * @param calValue
	 *            日历
	 * @param patten
	 *            指定格式 ，如："yyyy-MM-dd HH:mm:ss"
	 * @return String
	 */
	public String getStr(Calendar calValue, String patten) {
		SimpleDateFormat formatter = new SimpleDateFormat(patten);
		if (calValue == null) {
			return "";
		} else {
			return formatter.format(calValue.getTime());
		}
	}

	/**
	 * 几年以后的此时时间
	 * 
	 * @param years
	 *            几年
	 * @return Date
	 */
	public Date getAfterDateByYears(int years) {
		Calendar calValue = Calendar.getInstance();
		calValue.add(Calendar.YEAR, years);
		return new Date(calValue.getTime().getTime());
	}

	/**
	 * 得到某个时间几天之后的时间
	 * 
	 * @param d
	 *            开始时间
	 * @param days
	 *            经过的时间
	 * @return Date
	 */
	public Date getAfterDateByDays(Date d, int days) {
		Date d2 = new Date();
		d2.setTime(d.getTime() + days * 24 * 60 * 60 * 1000);
		return d2;
	}

	/**
	 * 得到某个时间几天之前的时间
	 * 
	 * @param d
	 *            开始时间
	 * @param days
	 *            之前的天数
	 * @return Date
	 */
	public Date getBeforeDateByDays(Date d, int days) {
		Date d2 = new Date();
		d2.setTime(d.getTime() - days * 24 * 60 * 60 * 1000);
		return d2;
	}

	/**
	 * 得到从此时开始几天之后的时间
	 * 
	 * @param days
	 *            天数
	 * @return Date
	 */
	public Date getAfterDateByDays(int days) {
		Calendar calValue = Calendar.getInstance();
		calValue.add(Calendar.DATE, days);
		return new Date(calValue.getTime().getTime());
	}

	/**
	 * 得到从开始时间到结束时间之间的秒数
	 * 
	 * @param startdate
	 *            开始时间
	 * @param enddate
	 *            结束时间
	 * @return int
	 */
	public int getSeconds(Date startdate, Date enddate) {
		long time = enddate.getTime() - startdate.getTime();
		int totalS = new Long(time / 1000).intValue();
		return totalS;
	}

	/**
	 * 得到当前时间的年份
	 * 
	 * @return int
	 */
	public int getCurrentYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}

	/**
	 * 将数据库Blob字段内容转换成byte[]
	 * 
	 * @param blob
	 *            数据库Blob字段内容
	 * @return byte[]
	 */
	public byte[] BlobtoByteArray(Blob blob) {
		InputStream bin = null;
		try {
			bin = blob.getBinaryStream();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		byte[] readblob = null;
		try {
			readblob = new byte[bin.available()];
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bin.read(readblob);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readblob;
	}

	/**
	 * 判断是不是数字
	 * 
	 * @param str
	 *            字符串
	 * @return 如果是返回true，不是返回false
	 */
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断str只含有字母和数字中一种或两种
	 * 
	 * @param str
	 *            字符串
	 * @return 如果是返回true，不是返回false
	 */
	public boolean isNumerAndEnglish(String str) {
		byte[] bytes = str.getBytes();
		for (byte temp : bytes) {
			if (temp < 48 || (temp > 57 && temp < 65)
					|| (temp > 90 && temp < 97) || temp > 122) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否为联通G网手机号码<br/> 目前包含号段130 131 132 155 156 186
	 * 
	 * @param str
	 *            手机号码
	 * @return 如果是返回true，不是返回false
	 */
	public boolean isGNet(String str) {
		Pattern pattern = Pattern
				.compile("13[0-2][0-9]{8}|15[5-6][0-9]{8}|18[6][0-9]{8}");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否电信(C网)号段<br/> 目前包含号段：133 153 189
	 * 
	 * @param str
	 *            手机号码
	 * @return 如果是返回true，不是返回false
	 */
	public boolean isCNet(String str) {
		Pattern pattern = Pattern
				.compile("13[3][0-9]{8}|15[3][0-9]{8}|18[9][0-9]{8}");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否是移动手机号码<br/> 目前包含号段：134-139 150 151 152 157 158 159 187 188
	 * 
	 * @param str
	 *            手机号码
	 * @return 如果是移动手机号码返回TRUE 否则返回FALSE
	 */
	public boolean isMobileNet(String str) {
		Pattern pattern = Pattern
				.compile("13[4-9][0-9]{8}|15[012789][0-9]{8}|18[78][0-9]{8}");
		return pattern.matcher(str).matches();
	}

	/**
	 * 将数组随机打乱
	 * 
	 * @param a
	 *            原始数组
	 * @return Object[] 随机打乱后的数组
	 */
	public Object[] RandomArraysValue(Object[] a) {
		List<Object> list = Arrays.asList(a);
		Collections.shuffle(list);
		return list.toArray();
	}

	/**
	 * 将html字符串转换成普通的text字符串，清除了html中的符号(此处需要添加&符号的清除......)
	 * 
	 * @param inputString
	 *            被转换的html
	 * @return 清除后的字符串
	 */
	public String HtmlToText(String inputString) {
		String htmlStr = inputString;
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
		// }
		String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
		// }
		String regEx_html = "<[^>]+>";

		p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll("");

		p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll("");

		p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll("");
		textStr = htmlStr;
		return textStr;
	}

	/**
	 * 根据时间得到星期几
	 * 
	 * @param date
	 *            时间
	 * @return String 如：星期一
	 */
	public String getWeekDay(Date date) {
		String dayNames[] = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		return dayNames[dayOfWeek];
	}

	/**
	 * 根据日期得到星期几
	 * 
	 * @param date
	 *            时间
	 * @return Integer 如：6
	 */
	public Integer getWeekDayInt(Date date) {
		Integer dayNames[] = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		return dayNames[dayOfWeek];
	}

	/**
	 * 返回两个Double值的差 a-b
	 * 
	 * @param a
	 * @param b
	 * @return Double
	 */
	public Double differDouble(Double a, Double b) {
		BigDecimal b1 = new BigDecimal(a.toString());
		BigDecimal b2 = new BigDecimal(b.toString());
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 返回两个Double的和值 a+b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double sumDouble(Double a, Double b) {
		BigDecimal b1 = new BigDecimal(a.toString());
		BigDecimal b2 = new BigDecimal(b.toString());
		return b1.add(b2).doubleValue();
	}

	/**
	 * 得到今天是星期几。例如：星期一
	 * 
	 * @return String
	 */
	public String getCurrentWeekDay() {
		Calendar c = Calendar.getInstance();
		int i = c.get(Calendar.DAY_OF_WEEK);
		String week = "星期一";
		switch (i) {
		case 1:
			week = "星期一";
			break;
		case 2:
			week = "星期二";
			break;
		case 3:
			week = "星期三";
			break;
		case 4:
			week = "星期四";
			break;
		case 5:
			week = "星期五";
			break;
		case 6:
			week = "星期六";
			break;
		case 7:
			week = "星期日";
			break;
		}
		return week;
	}

	/**
	 * 连接2个byte数组
	 * 
	 * @param buf1
	 *            byte数组1
	 * @param buf2
	 *            byte数组2
	 * @return byte[]
	 */
	public byte[] arraycat(byte[] buf1, byte[] buf2) {
		byte[] bufret = null;
		int len1 = 0;
		int len2 = 0;
		if (buf1 != null)
			len1 = buf1.length;
		if (buf2 != null)
			len2 = buf2.length;
		if (len1 + len2 > 0)
			bufret = new byte[len1 + len2];
		if (len1 > 0)
			System.arraycopy(buf1, 0, bufret, 0, len1);
		if (len2 > 0)
			System.arraycopy(buf2, 0, bufret, len1, len2);
		return bufret;
	}

	public static String toYear(java.util.Date date) {
		DateFormat df = new SimpleDateFormat("yyyy");
		return (null == date) ? "" : df.format(date);
	}

	public static String toMonth(java.util.Date date) {
		DateFormat df = new SimpleDateFormat("MM");
		return (null == date) ? "" : df.format(date);
	}

	public static String Base64Encode(String src) {
		return new String(Base64.encode(src.getBytes()));
	}

	public static String Base64Decode(String src) {
		return new String(Base64.decode(src.toCharArray()));
	}

	public static String toString(String s) {
		return (s == null) ? "" : s;
	}

	public static String toString(Object object) {
		return (null == object) ? "" : object.toString();
	}
    public boolean empty(Object obj){
    	if(obj==null || "".equals(obj.toString()))
    		return true;
    	else
    		return false;
    }
}