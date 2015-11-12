package com.nongzi.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nongzi.dao.CommonDAO;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Chanpinchengfen;
import com.nongzi.vo.Chanpinpinpai;
import com.nongzi.vo.Chanpinyongtu;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Leimuorshuxing;
import com.nongzi.vo.Province;
import com.nongzi.vo.Shuxing;

@Controller
@RequestMapping("/shuju")
public class ShujuGuanliController {

	@Autowired
	private CommonDAO commonDao;
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	/**
	 * 跳转到属性数据页面
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:11:33 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoShuxingDatas",method=RequestMethod.GET)
	public String gotoShuxingDatas(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("shuxinglist",commonDao.findByHql("from Shuxing") );
		return "shujuguanli/shuxing";
	}
	/**
	 * 跳转到添加属性数据页面
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:11:45 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoAddShuxing",method=RequestMethod.GET)
	public String gotoAddShuxing(HttpServletRequest request,HttpServletResponse response){
		
		return "shujuguanli/addshuxing";
	}
	/**
	 * 添加属性数据
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:12:00 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/addShuxingData",method=RequestMethod.POST)
	public String addShuxingData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String shuxingid=request.getParameter("shuxingid");
		String shuxingname=request.getParameter("shuxingname");
		if(shuxingid==null || shuxingid.equals("") || shuxingname==null || shuxingname.equals("")){
				response.getWriter().print(sh.ShowMessage("请完善信息再提交", "/addshuxing.html"));
				return null;
		}
		List<Shuxing> shuxinglist=commonDao.findByHql("from Shuxing where shuxingid='"+shuxingid+"'");
		if(shuxinglist!=null && shuxinglist.size()>0){
				response.getWriter().print(sh.ShowMessage("属性id已经存在", "/addshuxing.html"));
				return null;
		}
		List<Shuxing> shuxinglist2=commonDao.findByHql("from Shuxing where shuxingname='"+shuxingname+"'");
		if(shuxinglist2!=null && shuxinglist2.size()>0){
				response.getWriter().print(sh.ShowMessage("属性名称已经存在", "/addshuxing.html"));
				return null;
		}
		Shuxing shuxing=new Shuxing();
		shuxing.setShuxingid(shuxingid);
		shuxing.setShuxingname(shuxingname);
		shuxing.save();
		response.getWriter().print(sh.ShowMessage("添加成功", "/shuxing.html"));
		return null;
	}
	/**
	 * 跳转到产品用途数据页面
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:31:40 
	 * @comment 
	 * @param response
	 * @param request
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoYongtuDatas",method=RequestMethod.GET)
	public String gotoYongtuDatas(HttpServletResponse response,HttpServletRequest request){
		request.setAttribute("yongtulist", commonDao.findByHql("from Chanpinyongtu order by paixuval asc") );
		return "shujuguanli/yongtu";
	}
	/**
	 * 跳转到添加用途页面
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:31:56 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoAddYongtu",method=RequestMethod.GET)
	public String gotoAddYongtu(HttpServletRequest request,HttpServletResponse response){
		
		return "shujuguanli/addyongtu";
	}
	/**
	 * 添加产品用途
	 * 
	 * @author LHC
	 * @date 2015-10-30 上午11:32:10 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/addYongtuData",method=RequestMethod.POST)
	public String addYongtuData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String yongtuname=request.getParameter("yongtuname");
		String paixuval=request.getParameter("paixuval");
		if(yongtuname==null || yongtuname.equals("") || paixuval==null || paixuval.equals("")){
			response.getWriter().print(sh.ShowMessage("请完善信息再提交","/addyongtu.html" ));
			return null;
		}
		List<Chanpinyongtu> yongtulist=commonDao.findByHql("from Chanpinyongtu where yongtuname='"+yongtuname+"'");
		if(yongtulist!=null && yongtulist.size()>0){
			response.getWriter().print(sh.ShowMessage("用途名称已存在", "/addyongtu.html"));
			return null;
		}
		Chanpinyongtu yongtu=new Chanpinyongtu();
		yongtu.setAddtime(new Timestamp(new Date().getTime()));
		yongtu.setPaixuval(Integer.parseInt(paixuval));
		yongtu.setYongtuname(yongtuname);
		yongtu.save();
		response.getWriter().print(sh.ShowMessage("添加成功", "/yongtu.html"));
		return null;
	}
	/**
	 * 跳转到产品品牌页面
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午2:15:24 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoChanpinPinpai",method=RequestMethod.GET)
	public String gotoChanpinPinpai(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("pinpailist", commonDao.findByHql("from Chanpinpinpai order by addtime desc") );
		return "shujuguanli/pinpai";
	}
	/**
	 * 跳转到添加产品品牌页面
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午2:15:36 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoAddPinpai",method=RequestMethod.GET)
	public String gotoAddPinpai(HttpServletRequest request,HttpServletResponse response){
		return "shujuguanli/addpinpai";
	}
	/**
	 * 添加产品品牌
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午2:15:52 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/addPinpaiData",method=RequestMethod.POST)
	public String addPinpaiData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String pinpainame=request.getParameter("pinpainame");
		String paixuval=request.getParameter("paixuval");
		List<Chanpinpinpai> pinpailist=commonDao.findByHql("from Chanpinpinpai where pinpainame='"+pinpainame+"'");
		if(pinpailist!=null && pinpailist.size()>0){
			response.getWriter().print(sh.ShowMessage("品牌名称已存在", "/addpinpai.html"));
			return null;
		}
		Chanpinpinpai pp=new Chanpinpinpai();
		pp.setAddtime(new Timestamp(new Date().getTime()));
		pp.setPaixuval(Integer.parseInt(paixuval));
		pp.setPinpainame(pinpainame);
		pp.save();
		response.getWriter().print(sh.ShowMessage("添加成功", "/pinpai.html"));
		return null;
	}
	/**
	 * 跳转到产品成分页面
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午2:16:05 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoChengfenDatas",method=RequestMethod.GET)
	public String gotoChengfenDatas(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("chengfenlist", commonDao.findByHql("from Chanpinchengfen order by addtime desc"));
		return "shujuguanli/chengfen";
	}
	/**
	 * 跳转到添加产品成分页面
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午2:16:20 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoAddChengfen",method=RequestMethod.GET)
	public String gotoAddChengfen(HttpServletRequest request,HttpServletResponse response){
		List<Leimu> leimulist=commonDao.findByHql("from Leimu order by parentId asc");
		request.setAttribute("leimulist", leimulist);
		return "shujuguanli/addchengfen";
	}
	/**
	 * 添加成分
	 * 
	 * @author LHC
	 * @date 2015-11-2 下午3:21:10 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/addChengfenData",method=RequestMethod.POST)
	public String addChengfenData(HttpServletRequest request,HttpServletResponse response)throws IOException {
		String category=request.getParameter("cate");
		String chengfenname=request.getParameter("chengfenname");
		String paixuval=request.getParameter("paixuval");
		List<Chanpinchengfen> chengfenlist=commonDao.findByHql("from Chanpinchengfen where chengfenname='"+chengfenname+"'");
		if(chengfenlist!=null && chengfenlist.size()>0){
			response.getWriter().print(sh.ShowMessage("成分名称已存在", "/addchengfen.html"));
			return null;
		}
		String[] categoryids=category.split(",");
		for(int i=0;i<categoryids.length;i++){
			List<Leimu> leimulist=commonDao.findByHql("from Leimu where categoryId='"+categoryids[i]+"'");
			if(leimulist!=null && leimulist.size()>0){
				Chanpinchengfen cf=new Chanpinchengfen();
				cf.setAddtime(new Timestamp(new Date().getTime()));
				cf.setChengfenname(chengfenname);
				cf.setPaixuval(Integer.parseInt(paixuval));
				cf.setLeimu(leimulist.get(0));
				cf.save();
			}
		}
		response.getWriter().print(sh.ShowMessage("添加成功", "/chengfen.html"));
		return null;
	}
	
	@RequestMapping(value="/gotoLeimuShuxing",method=RequestMethod.GET)
	public String gotoLeimuShuxing(HttpServletRequest request,HttpServletResponse response){
		List<Leimuorshuxing> lslist=commonDao.findByHql("from Leimuorshuxing order by addtime desc");
		request.setAttribute("leimushuxing", lslist);
		return "shujuguanli/leimushuxing";
	}
	
	@RequestMapping(value="/gotoAddLeimuShuxing",method=RequestMethod.GET)
	public String gotoAddLeimuShuxing(HttpServletRequest request,HttpServletResponse response){
		List<Leimu> leimulist=commonDao.findByHql("from Leimu order by parentId asc");
		request.setAttribute("leimulist", leimulist);
		List<Shuxing> shuxinglist=commonDao.findByHql("from Shuxing");
		request.setAttribute("shuxinglist", shuxinglist);
		return "shujuguanli/addleimushuxing";
	}
	
	@RequestMapping(value="/addLeimuShuxingData",method=RequestMethod.POST)
	public String addLeimuShuxingData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String category=request.getParameter("category");
		String shuxing=request.getParameter("shuxingval");
		String orderby=request.getParameter("orderby");
		System.out.println(category+"============="+shuxing);
		 List<Leimu> leimulist=commonDao.findByHql("from Leimu where categoryId='"+category+"'");
		String[] shuxingids=shuxing.split(",");
		for(int i=0;i<shuxingids.length;i++){
			List<Leimuorshuxing> lslist=commonDao.findByHql("from Leimuorshuxing where shuxing.shuxingid='"+shuxingids[i]+"' and leimu.categoryId='"+category+"' ");
		    if(lslist!=null && lslist.size()>0){
		    	response.getWriter().print(sh.ShowMessage("请不要重复添加类型属性", "/addleimushuxing.html"));
		    	return null;
		    }
		   
		    List<Shuxing> shuxinglist=commonDao.findByHql("from Shuxing where shuxingid='"+shuxingids[i]+"'");
		    Leimuorshuxing ls=new Leimuorshuxing();
		    ls.setAddtime(new Timestamp(new Date().getTime()));
		    ls.setOrderval(Integer.parseInt(orderby));
		    ls.setLeimu(leimulist.get(0));
		    ls.setShuxing(shuxinglist.get(0));
		    ls.save();
		}
		
		response.getWriter().print(sh.ShowMessage("添加成功", "/leimushuxing.html"));
		return null;
	}
	
}
