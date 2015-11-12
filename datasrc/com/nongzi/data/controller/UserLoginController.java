package com.nongzi.data.controller;

import java.io.IOException;
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
@RequestMapping("/login")
public class UserLoginController {
	@Autowired
	private CommonDAO commonDao;
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public @ResponseBody void userLogin(HttpServletRequest request, HttpServletResponse response)throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> userMap = new LinkedHashMap<String, Object>();
		if ((username == null || password == null) || ("".equals(username) || ("".equals(password)))) {
			userMap.put("code", "2");
			userMap.put("state", "用户名或密码为空!");
		}  else {
			List<User> userlist = commonDao.findByHql("FROM User WHERE (username='" + username+ "'  OR  userphone='" + username	+ "' ) AND userislock='0' ");
			if (userlist == null || userlist.size() == 0) {
				userMap.put("code", "3");
				userMap.put("state", "找不到对应的用户信息!");
			} else {
				if (userlist.get(0).getUserpwd().equals(MD5.encrypt(password))) {
					userMap.put("code", "1");
					userMap.put("state", "登陆成功!");
					userMap.put("userid", userlist.get(0).getUserid());
				}else{
					userMap.put("code", "4");
					userMap.put("state", "用户密码错误!");
				}
			}
		}
		response.getWriter().write(JsonUtils.obj2json(userMap));
	}

}
