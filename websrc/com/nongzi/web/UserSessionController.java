package com.nongzi.web;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nongzi.Datas.DatasManager;
import com.nongzi.dao.CommonDAO;
import com.nongzi.util.MD5;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.User;
import com.nongzi.vo.Usersession;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/GetuserSession")
public class UserSessionController  {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao;
	
	
	
	
	@RequestMapping(value = "/gotoData",method = RequestMethod.GET)
	public String gotoData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user =  (User) request.getSession().getAttribute("user");
		//设计返回数据是的数组
		JSONArray sendjsonarray = new JSONArray();
	 	Map returnmap = new HashMap(); 
	 	if(user==null){
	 		returnmap.put("statics", "0");  
	 	}else{ 
	 		
	 		//设计保存在缓存中的数据内容
	 		Map sessionmap = new HashMap(); 
	 		//通过ip  时间    host  区分登陆的是不是一个人
	 		Usersession se = new Usersession();
	 		se.setAddtime(new Timestamp(new Date().getTime()));
	 		se.setIp(request.getHeader("X-Real-IP"));
	 		se.setUser(user);
	 		se.save();
	 		returnmap.put("statics", "1"); 
	 		returnmap.put("id", se.getUsersessionid()); 
	 		returnmap.put("userid", user.getUserid()); 
	 	}
	 	
        JSONObject jsonObject = JSONObject.fromObject( returnmap );  
        sendjsonarray.add(0, jsonObject);
        response.getWriter().print("jsonp={'returns':"+sendjsonarray+"}");
	    return null;
	}
	
	
}