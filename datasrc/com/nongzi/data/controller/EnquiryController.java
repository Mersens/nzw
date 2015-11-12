package com.nongzi.data.controller;

import hidden.org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
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
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.User;
import com.nongzi.vo.Zaixianyijia;

@Controller
@RequestMapping("/enquiry")
public class EnquiryController {
	public static final String CODE = "code";
	public static final String STATE = "state";
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IXunjiaService xunjiaService;
	
	@RequestMapping(value="/getEnquiryCount",method=RequestMethod.POST)
	public @ResponseBody void getEnquiryCount(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		if (StringUtils.isEmpty(userid)) {
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user = getUserById(userid);
		if (user == null) {
			map.put(CODE, "2");
			map.put(STATE, "用户不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(user.getGongsi()==null){
			map.put(CODE, "3");
			map.put(STATE, "您还未开通公司和店铺，尚没有询价单！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"' ");
		if(dianpulist==null || dianpulist.size()==0){
			map.put(CODE, "3");
			map.put(STATE, "您还未开通公司和店铺，尚没有询价单！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return ;
		}
		//全部询价单
		int total=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' ");
		//未查看
		int daichakan=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' and xinxistatic=0 ");
		//已查看
		int yichakan=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' and xinxistatic=1 ");
		Map<String,Integer> mapcount=new HashMap<String, Integer>();
		mapcount.put("total", total);
		mapcount.put("daichakan", daichakan);
		mapcount.put("yichakan", yichakan);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("info", mapcount);
		response.getWriter().write(JsonUtils.obj2json(map));
	}
	

	@RequestMapping(value="/getEnquiryData",method=RequestMethod.POST)
	public @ResponseBody void getEnquiryData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();	
		String page=request.getParameter("page");
		String status=request.getParameter("status");
		String xjname=request.getParameter("xjname");
		String startDate=request.getParameter("sdate");
		String endDate=request.getParameter("edate");
		String userid = request.getParameter("userid");
		if (StringUtils.isEmpty(userid)) {
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user = getUserById(userid);
		if (user == null) {
			map.put(CODE, "2");
			map.put(STATE, "用户不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"' ");
	
		if(page==null || page.equals("")){
			page="1";
		}

		if(xjname!=null && !xjname.equals("")){
			xjname =new String(xjname.getBytes("iso-8859-1"),"UTF-8"); 
		}

	    String xunjiadata=xunjiaService.getXunjiaData(dianpulist.get(0).getDianpuid(), page, status,xjname, startDate, endDate);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("datas", xunjiadata);
		response.getWriter().write(JsonUtils.obj2json(map));

	}
	
	@RequestMapping(value="/updateEnquiryStatic",method=RequestMethod.POST)
	public @ResponseBody void updateEnquiryStatic(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();	
		String xunjiaid=request.getParameter("xunjiaid");
		if (StringUtils.isEmpty(xunjiaid)) {
			map.put(CODE, "0");
			map.put(STATE, "xunjiaid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Zaixianyijia> xunjialist=commonDao.findByHql("from Zaixianyijia where xunjiaid='"+xunjiaid+"' ");
		if(xunjialist!=null && xunjialist.size()>0){
			if(xunjialist.get(0).getXinxistatic()==0){
				xunjialist.get(0).setXinxistatic(1);
				xunjialist.get(0).update();
				map.put(CODE, "1");
				map.put(STATE, "更新成功！");
				response.getWriter().write(JsonUtils.obj2json(map));
			}
		}else{
			map.put(CODE, "2");
			map.put(STATE, "查询结果为空！");
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
