package com.nongzi.data.controller;

import hidden.org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongzi.dao.CommonDAO;
import com.nongzi.data.utils.JsonUtils;
import com.nongzi.util.MD5;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
	public static final String CODE = "code";
	public static final String STATE = "state";
	@Autowired
	private CommonDAO commonDao;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/existUsername", method = RequestMethod.POST)
	private @ResponseBody
	void existUsername(HttpServletRequest request, HttpServletResponse response)throws IOException {
		String username = request.getParameter("username");
		Map<String, Object> userMap = new LinkedHashMap<String, Object>();
		if (username == null || "".equals(username)) {
			userMap.put(CODE, "0");
			userMap.put(STATE, "输入的用户名为空！");
		} else {
			List<User> userlist = commonDao.findByHql("FROM User WHERE username='" + username + "' ");
			if (userlist == null || userlist.size() == 0) {
				userMap.put(CODE, "1");
				userMap.put(STATE, "用户名可用！");
			} else {
					userMap.put(CODE, "2");
					userMap.put(STATE, "用户名已被占用！");
			}
		}
		response.getWriter().write(JsonUtils.obj2json(userMap));
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/existUserphone", method = RequestMethod.POST)
	private @ResponseBody void existUserphone(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userphone =request.getParameter("userphone");
		Map<String, Object> userMap = new LinkedHashMap<String, Object>();
		if(userphone==null || "".equals(userphone)){
			userMap.put(CODE, "0");
			userMap.put(STATE, "输入的手机号为空！");
		}else{
			List<User> userlist = commonDao.findByHql("FROM User WHERE userphone='" + userphone + "' ");
			if (userlist == null || userlist.size() == 0) {
				userMap.put(CODE, "1");
				userMap.put(STATE, "手机号可用！");
			} else {
					userMap.put(CODE, "2");
					userMap.put(STATE, "手机号已被占用！");
			}
		}
		response.getWriter().write(JsonUtils.obj2json(userMap));
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	private @ResponseBody void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean isHasUserName=true;
		boolean isHasuserPhone=true;
		String username=request.getParameter("username");
		String userphone=request.getParameter("userphone");
		String userpwd=request.getParameter("userpwd");
		Map<String, Object> userMap = new LinkedHashMap<String, Object>();
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(userphone) ||StringUtils.isEmpty(userpwd) ){
			userMap.put(CODE, "0");
			userMap.put(STATE, "输入的用户名 密码 手机号码 有空值");
			response.getWriter().write(JsonUtils.obj2json(userMap));
			return;
		}
		
		if(username.equals(userpwd)){
				userMap.put(CODE, "4");
				userMap.put(STATE, "账户名和密码相同!");
				response.getWriter().write(JsonUtils.obj2json(userMap));
				return;
		}
		
		List<User> userlist = commonDao.findByHql("FROM User WHERE username='" + username + "' ");
			if(userlist!=null &&  userlist.size() > 0){
					userMap.put(CODE, "2");
					userMap.put(STATE, "用户名已被占用！");
					response.getWriter().write(JsonUtils.obj2json(userMap));
					return;
			}
			
			List<User> userphonelist = commonDao.findByHql("FROM User WHERE userphone='" + userphone + "' ");
			if (userphonelist != null &&  userphonelist.size() > 0) {
					userMap.put(CODE, "3");
					userMap.put(STATE, "手机号已被占用！");
					response.getWriter().write(JsonUtils.obj2json(userMap));
					return;
			}
			
				User user = new  User();
				user.setAddtime(new Timestamp(new Date().getTime()));
				user.setUserislock(0);
				user.setUsername(username);
				user.setUserjiaoyipwd(MD5.encrypt(userpwd));
				user.setUserjiaoyipwdStatic("1");
				user.setUserphone(userphone);
				user.setUserpwd(MD5.encrypt(userpwd));
				user.setUserpwdStatic("1");
				user.setTouxiang("/images/Not-Ico-touxiang.jpg");
				user.save();
				
					userMap.put(CODE, "1");
					userMap.put(STATE, "注册成功！");
					userMap.put("userid", user.getUserid());
					response.getWriter().write(JsonUtils.obj2json(userMap));
					return;
	}
}
