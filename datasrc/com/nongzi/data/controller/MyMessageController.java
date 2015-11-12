package com.nongzi.data.controller;

import hidden.org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
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
import com.nongzi.user.iservice.IMyMessageService;
import com.nongzi.vo.Sysmessage;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/myMessage")
public class MyMessageController {
	public static final String CODE = "code";
	public static final String STATE = "state";
	
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IMyMessageService messageService;
	@RequestMapping(value="/getMyMessageCount",method=RequestMethod.POST)
	public @ResponseBody void getMyMessageCount(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);
		if(user==null){
			map.put(CODE, "2");
			map.put(STATE, "用户不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		int totalmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2");
		int xitongmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=1");
		int gonggaomsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=2");
		int sixinmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=3");
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		List<Integer> list=new ArrayList<Integer>();
		list.add(totalmsg);
		list.add(xitongmsg);
		list.add(gonggaomsg);
		list.add(sixinmsg);
		map.put("countInfo", list);
		response.getWriter().write(JsonUtils.obj2json(map));
		
	}

	@RequestMapping(value="/getMyMessageDatas",method=RequestMethod.POST)
	public @ResponseBody void getMyMessageDatas(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String page=request.getParameter("page");
		String typeid=request.getParameter("typeid");
		String userid = request.getParameter("userid");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(StringUtils.isEmpty(page) || StringUtils.isEmpty(typeid)){
			map.put(CODE, "2");
			map.put(STATE, "输入数据存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;	
		}

		String msgdata=messageService.getMyMessageData(userid, page, typeid);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("datainfo", msgdata);
		response.getWriter().write(JsonUtils.obj2json(map));

	}
	
	@RequestMapping(value="/deleteMyMessage",method=RequestMethod.POST)
	public @ResponseBody void deleteMyMessage(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String msgid=request.getParameter("msgid");
		if(StringUtils.isEmpty(msgid)){
			map.put(CODE, "0");
			map.put(STATE, "msgid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		
		List<Sysmessage> msglist=commonDao.findByHql("from Sysmessage where messageid='"+msgid+"'");
		if(msglist!=null && msglist.size()>0){
			msglist.get(0).setMsgstatic(2);
			msglist.get(0).update();
			map.put(CODE, "1");
			map.put(STATE, "删除成功！");
			response.getWriter().write(JsonUtils.obj2json(map));
		}
	}
	

	public User getUserById(String userid) {
		List<User> userList = commonDao.findByHql("from User where userid='"
				+ userid + "'");
		if (userList.size() == 0 || userList == null)
			return null;
		else
			return userList.get(0);
	}

}
