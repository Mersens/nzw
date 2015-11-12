package com.nongzi.web;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/password")
public class FindPasswordController  {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao;
	

	@RequestMapping(value="/gotoFindPassword2",method=RequestMethod.GET)
	public String gotoFindPassword2(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=(User) request.getSession().getAttribute("finduser");
		if(user==null){
			response.getWriter().print(sh.ShowMessage("请不要非法登录", "/login.html"));
			return null;
		}
		return "u_login/findpassword_2";
	}
	
	@RequestMapping(value="/gotoFindPassword3",method=RequestMethod.GET)
	public String gotoFindPassword3(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=(User) request.getSession().getAttribute("finduser");
		String userphone=(String) request.getSession().getAttribute("userphone");
		if(user==null || userphone==null || userphone.equals("")){
			response.getWriter().print(sh.ShowMessage("请不要非法登录", "/login.html"));
			return null;
		}
		return "u_login/findpassword_3";
	}
	
	@RequestMapping(value="/gotoFindPassword4",method=RequestMethod.GET)
	public String gotoFindPassword4(HttpServletRequest request,HttpServletResponse response){
		
		return "u_login/findpassword_4";
	}
	
	@RequestMapping(value="/gotoTestUsername",method=RequestMethod.POST)
	public String gotoTestUsername(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String username=request.getParameter("username");
		String yanzhengma=request.getParameter("yanzhengma");
		User user=null;
		if(username==null || username.equals("") || yanzhengma==null || yanzhengma.equals("")){
			response.getWriter().print("0");
			return null;
		}
		
		List<User> userlist=commonDao.findByHql("from User where username='"+username+"'");
		if(userlist==null || userlist.size()==0){
			response.getWriter().print("2");   //用户名不存在
			return null;
		}else{
			user=userlist.get(0);
			request.getSession().setAttribute("finduser", user);
		}
		
		String rand=(String) request.getSession().getAttribute("rand");
		if(!yanzhengma.equals(rand)){
			response.getWriter().print("3");  //验证码输入错误
			return null;
		}
		response.getWriter().print("1");
		return null;
	}
	
	
	@RequestMapping(value="/gotoTestUserphone",method=RequestMethod.POST)
	public String gotoTestUserphone(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=(User) request.getSession().getAttribute("finduser");
		if(user==null){
			response.getWriter().print("4");
			return null;
		}
		String userphone=request.getParameter("userphone");
		String phonecode=request.getParameter("phonecode");
		if(userphone==null || userphone.equals("") || phonecode==null || phonecode.equals("")){
			response.getWriter().print("0");
			return null;
		}
		
		if(!user.getUserphone().equals(userphone)){
			response.getWriter().print("2");
			return null;
		}
		String phonerand=(String) request.getSession().getAttribute(userphone);
		if(!phonerand.equals(phonecode)){
			response.getWriter().print("3");
			return null;
		}
		request.getSession().setAttribute("userphone", userphone);
		response.getWriter().print("1");
		return null;
	}
	
	
	@RequestMapping(value="/gotoUpdatePassword",method=RequestMethod.POST)
	public String gotoUpdatePassword(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=(User) request.getSession().getAttribute("finduser");
		String userphone=(String) request.getSession().getAttribute("userphone");
		if(user==null || userphone==null || userphone.equals("")){
			response.getWriter().print("3");
			return null;
		}
		String newpwd=request.getParameter("newpwd");
		String renewpwd=request.getParameter("renewpwd");
		if(newpwd==null || newpwd.equals("") || renewpwd==null || renewpwd.equals("")){
			response.getWriter().print("0");
			return null;
		}
		if(!newpwd.equals(renewpwd)){
			response.getWriter().print("2");
			return null;
		}
		user.setUserpwd(MD5.encrypt(newpwd));
		user.update();
		request.getSession().removeAttribute("finduser");
		request.getSession().removeAttribute("userphone");
		response.getWriter().print("1");
		return null;
	}
	
	
	
	@RequestMapping(value = "/sendrandByPhone",method = RequestMethod.POST)
	public String  sendrandByPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone=request.getParameter("userphone");
		User user=(User) request.getSession().getAttribute("finduser");
		//验证手机号码格式是否正确
		String phoneregExp = "^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\\d{8}$";  
		Pattern pexp = Pattern.compile(phoneregExp);  
		Matcher phonep = pexp.matcher(phone);  
		if(!phonep.find()){response.getWriter().write("false");return null;}
		//验证手机号码在数据库中是否存在
		if(!user.getUserphone().equals(phone)){response.getWriter().write("false");return null;}
		String yanzhengma = RandomString.getRandomString(6);
		request.getSession().setAttribute(phone, yanzhengma);
//		SendPhoneMSG.sendSMS(phone, "尊敬的用户您好：您正在使用农资101网的找回密码功能，验证码是"+yanzhengma);
		System.out.println("尊敬的用户您好：您正在使用农资101网的找回密码功能，验证码是"+yanzhengma);
		response.getWriter().write("true");
		return null;
	}
	
}