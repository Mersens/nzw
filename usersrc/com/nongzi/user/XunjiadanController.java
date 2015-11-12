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
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.User;
import com.nongzi.vo.Zaixianyijia;

@Controller
@RequestMapping("/xunjia")
public class XunjiadanController {

	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IXunjiaService xunjiaService;
	
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	
	/**
	 * 跳转到询价单页面
	 * 
	 * @author LHC
	 * @date 2015-9-22 下午7:25:07 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoXunjiadan",method=RequestMethod.GET)
	public String gotoXunjiadan(HttpServletRequest request,HttpServletResponse response){
		User user= getUserById((User) request.getSession().getAttribute("user"));
		if(user.getGongsi()==null){
			sh.ShowMessage("您还未开通公司和店铺，尚没有询价单", "/user/company/info.html");
			return null;
		}
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"' ");
		if(dianpulist==null || dianpulist.size()==0){
			sh.ShowMessage("您还未开通公司和店铺，尚没有询价单", "/user/company/wangpuinfo.html");
			return null;
		}
		//全部询价单
		int total=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' ");
		//未查看
		int daichakan=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' and xinxistatic=0 ");
		//已查看
		int yichakan=commonDao.findBySqlSize("select count(xunjiaid) from zaixianyijia where dianpuid='"+dianpulist.get(0).getDianpuid()+"' and xinxistatic=1 ");
		request.setAttribute("total",total );
		request.setAttribute("daichakan",daichakan);
		request.setAttribute("yichakan",yichakan );
		return "xunjiadan/xunjiadan";
	}
	/**
	 * 获取询价单的数据
	 * 
	 * @author LHC
	 * @date 2015-9-22 下午7:24:54 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/getXunjiaData",method=RequestMethod.GET)
	public String getXunjiaData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"' ");
		String page=request.getParameter("page");
		if(page==null || page.equals("")){
			page="1";
		}
		String status=request.getParameter("status");
		String xjname=request.getParameter("xjname");
		if(xjname!=null && !xjname.equals("")){
			xjname =new String(xjname.getBytes("iso-8859-1"),"UTF-8"); 
		}
		String startDate=request.getParameter("sdate");
		String endDate=request.getParameter("edate");
	    String xunjiadata=xunjiaService.getXunjiaData(dianpulist.get(0).getDianpuid(), page, status,xjname, startDate, endDate);
	    response.getWriter().print(xunjiadata);
		return null;
	}
	
	@RequestMapping(value="/updateXunjiaStatic",method=RequestMethod.POST)
	public String updateXunjiaStatic(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String xunjiaid=request.getParameter("xunjiaid");
		List<Zaixianyijia> xunjialist=commonDao.findByHql("from Zaixianyijia where xunjiaid='"+xunjiaid+"' ");
		if(xunjialist!=null && xunjialist.size()>0){
			if(xunjialist.get(0).getXinxistatic()==0){
				xunjialist.get(0).setXinxistatic(1);
				xunjialist.get(0).update();
				response.getWriter().print("1");
			}
		}
		
		return null;
	}
	
	
	public User getUserById(User user){
		List<User> userList=commonDao.findByHql("from User where userid='"+user.getUserid()+"'");
		return userList.get(0);
	}
}
