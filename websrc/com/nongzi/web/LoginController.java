package com.nongzi.web;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nongzi.dao.CommonDAO;
import com.nongzi.util.MD5;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.User;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController  {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao;
	
	
	
	
	@RequestMapping(value = "/gotoLogin",method = RequestMethod.GET)
	public String gotoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询session中的sessionid
		User user =  (User) request.getSession().getAttribute("user");
		//如果是已经打开过登录系统 单位成功登陆 讲直接跳转到登陆页面
		if(user==null || user.equals("null")){
			return  "u_login/login" ;
		}
		response.setStatus(302);
		response.setHeader("Location","/user/zhanghu/safe.html");
	    return null;
	}
	
	@RequestMapping(value = "/IsLogin",method = RequestMethod.POST)
	public String IsLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = 	request.getParameter("username");
		String userpwd = 	request.getParameter("userpwd");
		User returnuser = UserLoginData(username, userpwd ,request, response);
		if (null != returnuser ) {
			request.getSession().setAttribute("user", returnuser);// 把登录用户放入session中
			response.getWriter().print(true);
		} else {// 非法用户
			response.getWriter().print(false);
		}
    	 return null;
	}
	
	public User UserLoginData(String username, String userpwd,HttpServletRequest request, HttpServletResponse response) {
		List<User> userlist = commonDao.findByHql("from User where (username='"+username+"'  or  userphone='"+username+"' )and userislock='0' ");
		if (null != userlist && userlist.size() > 0) {
			if (userlist.get(0).getUserpwd().toString().equals(MD5.encrypt(userpwd)))
			{
				return userlist.get(0);
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/loginOut",method = RequestMethod.GET)
	public String loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		response.getWriter().write(sh.Redirect("/login.html"));
		return null;
	}
	
	
	
	
}