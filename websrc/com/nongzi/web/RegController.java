package com.nongzi.web;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

import com.nongzi.dao.CommonDAO;
import com.nongzi.util.MD5;
import com.nongzi.util.RandomString;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.User;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/reg")
public class RegController  {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao;

	
	@RequestMapping(value = "/IsReg",method = RequestMethod.POST)
	public String IsReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String phone = 	request.getParameter("phone");
		String username = 	request.getParameter("username");
		String userpwd = 	request.getParameter("userpwd");
		String userrand = 	request.getParameter("userrand");
		if(!IsRegfunction( phone, username, userpwd, userrand,request)){
			response.getWriter().write("false");
			return null;
		}
		if(!SaveUser( phone, username, userpwd, userrand,request)){
			response.getWriter().write("false");
			return null;
		}
		response.getWriter().write("true");
    	 return null;
	}
	
	public boolean SaveUser(String phone,String username,String userpwd,String userrand,HttpServletRequest request) throws IOException {
		User user = new  User();
		user.setAddtime(new Timestamp(new Date().getTime()));
		user.setUserislock(0);
		user.setUsername(username);
		user.setUserjiaoyipwd(MD5.encrypt(userpwd));
		user.setUserjiaoyipwdStatic("1");
		user.setUserphone(phone);
		user.setUserpwd(MD5.encrypt(userpwd));
		user.setUserpwdStatic("1");
		user.setTouxiang("/images/Not-Ico-touxiang.jpg");
		user.save();
		request.getSession().setAttribute("user", user);
		return true;
	}
	
	
	
	public boolean IsRegfunction(String phone,String username,String userpwd,String userrand,HttpServletRequest request) throws IOException {
		//验证手机号码格式是否正确
		String phoneregExp = "^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\\d{8}$";  
		Pattern pexp = Pattern.compile(phoneregExp);  
		Matcher phonep = pexp.matcher(phone);  
		if(!phonep.find()){return false;}
		//验证手机号码在数据库中是否存在
		List<User> userlist = commonDao.findByProperty("User", "userphone", phone);
		if(userlist!=null &&userlist.size()>0){return false;}
		//验证用户名格式正确性
		String nameregExp = "^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$";  
		Pattern pexname = Pattern.compile(nameregExp);  
		Matcher namep = pexname.matcher(username);  
		if(!namep.find()){return false;}
		//验证用户名在数据库中是否存在
		List<User> usernamelist = commonDao.findByProperty("User", "username", username);
		if(usernamelist!=null &&usernamelist.size()>0){return false;}
		//验证用户输入的验证码是否正确	 
		if(request.getSession().getAttribute(phone)==null || !request.getSession().getAttribute(phone).toString().equals(userrand)){return false;}
		//验证用户输入的验证码是否正确	 
		if(userpwd.length()<=0 || userpwd.length()>=20){return false;}
		return true;
	}
	
	
	@RequestMapping(value = "/sendrandByPhone",method = RequestMethod.POST)
	public String  sendrandByPhone(String phone,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//验证手机号码格式是否正确
		String phoneregExp = "^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\\d{8}$";  
		Pattern pexp = Pattern.compile(phoneregExp);  
		Matcher phonep = pexp.matcher(phone);  
		if(!phonep.find()){response.getWriter().write("false");return null;}
		//验证手机号码在数据库中是否存在
		List<User> userlist = commonDao.findByProperty("User", "userphone", phone);
		if(userlist!=null &&userlist.size()>0){response.getWriter().write("false");return null;}
		String yanzhengma = RandomString.getRandomString(6);
		request.getSession().setAttribute(phone, yanzhengma);
//		SendPhoneMSG.sendSMS(phone, "欢迎注册101农资网，您的验证码是"+yanzhengma);
		System.out.println( "欢迎注册101农资网，您的验证码是"+yanzhengma);
		response.getWriter().write("true");
		return null;
	}
}