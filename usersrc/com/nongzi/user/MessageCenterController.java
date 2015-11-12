package com.nongzi.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IMyMessageService;
import com.nongzi.vo.Sysmessage;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/message")
public class MessageCenterController {
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IMyMessageService messageService;
	
	/**
	 * 跳转到我的消息页面
	 * 
	 * @author LHC
	 * @date 2015-9-28 下午6:59:52 
	 * @comment 
	 * @param rquest
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoMyMessage",method=RequestMethod.GET)
	public String gotoMyMessage(HttpServletRequest request,HttpServletResponse response){
		User user=(User) request.getSession().getAttribute("user");
		int totalmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2");
		int xitongmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=1");
		int gonggaomsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=2");
		int sixinmsg=commonDao.findBySqlSize("select count(messageid) from Sysmessage where userid='"+user.getUserid()+"' and msgstatic!=2 and typeid=3");
		request.setAttribute("totalmsg",totalmsg );
		request.setAttribute("xitongmsg",xitongmsg );
		request.setAttribute("gonggaomsg",gonggaomsg );
		request.setAttribute("sixinmsg", sixinmsg);
		return "message/myxiaoxi";
	}
	
	@RequestMapping(value="/getMyMessageData",method=RequestMethod.GET)
	public String getMyMessageData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=(User) request.getSession().getAttribute("user");
		String page=request.getParameter("page");
		String typeid=request.getParameter("typeid");
		String msgdata=messageService.getMyMessageData(user.getUserid(), page, typeid);
		response.getWriter().print(msgdata);
		return null;
	}
	
	@RequestMapping(value="/deleteMyMessage",method=RequestMethod.POST)
	public String deleteMyMessage(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String msgid=request.getParameter("msgid");
		List<Sysmessage> msglist=commonDao.findByHql("from Sysmessage where messageid='"+msgid+"'");
		if(msglist!=null && msglist.size()>0){
			msglist.get(0).setMsgstatic(2);
			msglist.get(0).update();
			response.getWriter().print("1");
		}
		return null;
	}
	
	
}
