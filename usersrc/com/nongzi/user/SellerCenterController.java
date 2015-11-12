package com.nongzi.user;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IChanpinService;
import com.nongzi.user.iservice.IImgService;
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Chanpin;
import com.nongzi.vo.Chanpinimg;
import com.nongzi.vo.Chanpinorleimu;
import com.nongzi.vo.Chanpinpinpai;
import com.nongzi.vo.Chanpinshuxing;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Leimuorshuxing;
import com.nongzi.vo.User;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/sellerCenter")
public class SellerCenterController  {
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IXunjiaService xunjiaService;
	@Autowired
	private IChanpinService chanpinService;
	@Autowired
	private IImgService imgService;
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/gotoSelectChanpinLeimu",method=RequestMethod.GET)
	public String gotoSelectChanpinLeimu(HttpServletRequest request,HttpServletResponse response){
		String leimuid=request.getParameter("leimuid");
		String fid=request.getParameter("fid");
		String cid=request.getParameter("cid");
		
		List<Leimu> leimulist=commonDao.findByHql("from Leimu where parentId=0");
		request.setAttribute("flist", leimulist);
		
		if(fid!=null && !fid.equals("0")){
			request.setAttribute("llist", commonDao.findPageByHql(1, 8,"from Leimu where parentId='"+fid+"' "));
		}
		
		if(leimuid!=null && !leimuid.equals("0")){
			request.setAttribute("clist", commonDao.findPageByHql(1, 8,"from Leimu where parentId='"+leimuid+"' "));
		}
		List<Leimu> fleimu=commonDao.findByProperty("Leimu", "categoryId", fid);
		if(fleimu!=null && fleimu.size()>0){
			request.setAttribute("f",fleimu.get(0) );
			
			List<Leimu> lleimu=commonDao.findByProperty("Leimu", "categoryId", leimuid);
			if(lleimu!=null && lleimu.size()>0){
				request.setAttribute("l", lleimu.get(0));
				
				List<Leimu> cidleimu=commonDao.findByProperty("Leimu", "categoryId", cid);
				if(cidleimu!=null && cidleimu.size()>0){
					request.setAttribute("c", cidleimu.get(0));
				}
			}
		}
		return "seller/fabuchanpin_2";
	}
	
	@RequestMapping(value="/gotoAddChanpinXinxi",method=RequestMethod.GET)
	public String gotoAddChanpinXinxi(HttpServletRequest request,HttpServletResponse response){
		String fid=request.getParameter("fid");
		String lid=request.getParameter("lid");
		String cid=request.getParameter("cid");
		System.out.println(fid);
		Leimu fleimu=getLeimuById(fid);
		request.setAttribute("fleimu", getLeimuById(fid));
		request.setAttribute("lleimu", getLeimuById(lid));
		request.setAttribute("cleimu", getLeimuById(cid));
		List<Leimuorshuxing> shuxinglist=commonDao.findByHql("from Leimuorshuxing where leimu.categoryId='"+cid+"' ");
		request.setAttribute("shuxinglist", shuxinglist);
		return "seller/fabuchanpin_3";
	}
	
	@RequestMapping(value = "/gotoUploadFiles",method = RequestMethod.GET)
	public String gotoUploadFiles(HttpServletRequest request, HttpServletResponse response){
		return "/seller/chanpinup";
	}
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public String up(@RequestParam(value = "chanpinimgsrc", required = false) MultipartFile file, HttpServletResponse response, HttpServletRequest request, ModelMap model) throws IOException {
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String resultstr = imgService.upload(file,300);
		System.out.println(file+"==========res");
		if(resultstr != null){
			if(resultstr.equals("fileismax")){
				response.getWriter().println("<script type=\"text/javascript\">");
				response.getWriter().println("alert('文件上传数据过大');");
				response.getWriter().println("</script>");
			}else if(resultstr.equals("fileisnull")){
				response.getWriter().println("<script type=\"text/javascript\">");
				response.getWriter().println("alert('请选择您上传的图片');");
				response.getWriter().println("</script>");
			}else {
				response.getWriter().println("<script type=\"text/javascript\">");
				response.getWriter().println("window.parent.document.getElementById('chanpinimgsrc').value='"+ resultstr.split("_")[2]+"'");
			//	response.getWriter().println("window.parent.document.getElementById('imageshow').src='"+resultstr.split("_")[2]+"';");
				response.getWriter().println("</script>");
					
				List imglist=(List) request.getSession().getAttribute("imglist");
				if(imglist==null || imglist.size()==0){
					imglist=new ArrayList();
					imglist.add(resultstr.split("_")[2]);
					response.getWriter().println("<script type=\"text/javascript\">");
					response.getWriter().println("alert(\"图片上传成功\")");
				}else if(imglist.size()==8){
					response.getWriter().println("<script type=\"text/javascript\">");
					response.getWriter().println("alert(\"您已经上传了8张图片\")");
					response.getWriter().println("var index = parent.layer.getFrameIndex(window.name);");
					response.getWriter().println("parent.location.reload();");
					response.getWriter().println("parent.layer.close(index); //执行关闭");
					response.getWriter().println("</script>");
				}else{
					imglist.add(resultstr.split("_")[2]);
					response.getWriter().println("<script type=\"text/javascript\">");
					response.getWriter().println("alert(\"图片上传成功\")");
					
				}
				request.getSession().setAttribute("imglist", imglist);
				response.getWriter().println("var index = parent.layer.getFrameIndex(window.name);");
				response.getWriter().println("parent.location.reload();");
				response.getWriter().println("parent.layer.close(index); //执行关闭");
				response.getWriter().println("</script>");
			}
			
		}
		return null;
	}
	
	
	@RequestMapping(value="/addChanpinXinxi",method=RequestMethod.POST)
	public String addChanpinXinxi(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"'");
		if(dianpulist==null || dianpulist.size()==0){
			response.getWriter().print("0");   //没有店铺不能添加商品
			return null;
		}
		String title=request.getParameter("title");
		String chanpinleimu=request.getParameter("chanpinleimu");
		String keyword=request.getParameter("keyword");
		String miaoshu=request.getParameter("miaoshu");
		String offerDetail=request.getParameter("offerDetail");
		
		
		
		Chanpinpinpai pinpai=(Chanpinpinpai) commonDao.findByHql("from Chanpinpinpai where pinpaiid='1'").get(0);
		Chanpin chanpin=new Chanpin();
		chanpin.setAddtime(new Timestamp(new Date().getTime()));
		chanpin.setChanpinpinpai(null);
		chanpin.setDianpu(dianpulist.get(0));
		chanpin.setGongsi(user.getGongsi());
		chanpin.setJiage(0.0);
		chanpin.setKeyword(keyword);
		chanpin.setMiaoshu(miaoshu);
		chanpin.setOfferDetail(offerDetail);
		chanpin.setTitle(title);
		chanpin.setUnit("件");
		chanpin.setUser(user);
		chanpin.setXinxiststic(0);
		chanpin.setChanpinpinpai(pinpai);
		chanpin.setHtmlid(Integer.valueOf(chanpinleimu));
		chanpin.save();

		List imglist=(List) request.getSession().getAttribute("imglist");
		if(imglist!=null && imglist.size()>0){
			for(int i=0;i<imglist.size();i++){
				Chanpinimg cpimg=new Chanpinimg();
				cpimg.setAddtime(new Timestamp(new Date().getTime()));
				cpimg.setChanpin(chanpin);
				cpimg.setImgsrc(imglist.get(i).toString());
				cpimg.setImgtype(0);
				cpimg.setOrderval(0);
				cpimg.setTypeid("title");
				cpimg.save();
			}
		}
		List<Leimu> leimulist=commonDao.findByHql("from Leimu where categoryId='"+chanpinleimu+"'");
		Chanpinorleimu cplm=new Chanpinorleimu();
		cplm.setChanpin(chanpin);
		cplm.setLeimu(leimulist.get(0));
		cplm.save();
		List<Leimuorshuxing> shuxinglist=commonDao.findByHql("from Leimuorshuxing where leimu.categoryId='"+chanpinleimu+"'");
		for(int i=0;i<shuxinglist.size();i++){
			
			Chanpinshuxing cpsx=new Chanpinshuxing();
			cpsx.setChanpin(chanpin);
			cpsx.setChanpinshuxingid(shuxinglist.get(i).getShuxing().getShuxingid());
			cpsx.setShuxing(shuxinglist.get(i).getShuxing());
			cpsx.setShuxingval(request.getParameter(shuxinglist.get(i).getShuxing().getShuxingid()));
			cpsx.save();
		}
		request.getSession().setAttribute("chanpin", chanpin);
		request.getSession().removeAttribute("imglist");
		response.getWriter().print("1");
		return null;
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/addChanpinJiaoyiXinxi",method=RequestMethod.POST)
	public String addChanpinJiaoyiXinxi(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Chanpin chanpin=(Chanpin) request.getSession().getAttribute("chanpin");
		if(chanpin==null){
			response.getWriter().print(sh.Redirect("/user/seller/fabu.html"));
			return null;
		}
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+chanpin.getChanpinid()+"'");
		chanpin=chanpinlist.get(0);
		String unit=request.getParameter("unit");
		String jiage=request.getParameter("jiage");
		chanpin.setUnit(unit);
		chanpin.setJiage(Double.parseDouble(jiage));
		chanpin.update();
		request.getSession().removeAttribute("chanpin");
		response.getWriter().print("1");
		return null;
	}
	/**
	 * 跳转到添加产品成功页面
	 * 
	 * @author LHC
	 * @date 2015-10-16 下午2:19:13 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoAddChanpinSuccess",method=RequestMethod.GET)
	public String gotoAddChanpinSuccess(HttpServletRequest request,HttpServletResponse response){
		
		return "seller/fabuchanpin_5";
	}
	/**
	 * 跳转到产品管理页面
	 * 
	 * @author LHC
	 * @date 2015-10-16 下午2:32:08 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoChanpinGuanli",method=RequestMethod.GET)
	public String gotoChanpinGuanli(HttpServletRequest request,HttpServletResponse response){
		System.out.println("=====================");
		return "seller/chanpinguanli";
	}
	
	@RequestMapping(value="/getChanpinData",method=RequestMethod.GET)
	public String getChanpinData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		String page=request.getParameter("page");
		String status=request.getParameter("status");
		if(status==null){
			status="1";
		}
		response.getWriter().print(chanpinService.getChanpinData(user.getUserid(), page, status));
		return null;
	}
	
	@RequestMapping(value="/updateChanpinStatus",method=RequestMethod.POST)
	public String updateChanpinStatus(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String id=request.getParameter("id");
		System.out.println(id+"---------------");
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id+"'");
		if(chanpinlist!=null && chanpinlist.size()>0){
			chanpinlist.get(0).setXinxiststic(3);
			chanpinlist.get(0).update();
			response.getWriter().print("1");
		}
		return null;
	}
	/**
	 * 批量下架产品
	 * 
	 * @author LHC
	 * @date 2015-10-19 上午10:50:38 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/updateAllChanpinStatus",method=RequestMethod.POST)
	public String updateAllChanpinStatus(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String ids=request.getParameter("ids");
		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++){
			List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id[i]+"'");
			if(chanpinlist!=null && chanpinlist.size()>0){
				chanpinlist.get(0).setXinxiststic(3);
				chanpinlist.get(0).update();
			}
		}
		response.getWriter().print("1");
		return null;
	}
	/**
	 * 批量删除产品
	 * 
	 * @author LHC
	 * @date 2015-10-19 上午11:04:00 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/deleteAllChanpin",method=RequestMethod.POST)
	public String deleteAllChanpin(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String ids=request.getParameter("ids");
		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++){
			List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id[i]+"'");
			if(chanpinlist!=null && chanpinlist.size()>0){
				chanpinlist.get(0).setXinxiststic(4);
				chanpinlist.get(0).update();
			}
		}
		response.getWriter().print("1");
		return null;
	}
	/**
	 * 产品上架
	 * 
	 * @author LHC
	 * @date 2015-10-19 下午6:00:42 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/chanpinShangjia",method=RequestMethod.POST)
	public String chanpinShangjia(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String id=request.getParameter("id");
		System.out.println(id+"---------------");
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id+"'");
		if(chanpinlist!=null && chanpinlist.size()>0){
			chanpinlist.get(0).setXinxiststic(1);
			chanpinlist.get(0).update();
			response.getWriter().print("1");
		}
		return null;
	}
	
	
	
	public Dianpu getDianpuById(int htmlid){
		List<Dianpu> dianpulist = commonDao.findByProperty("Dianpu", "htmlid", htmlid); 
		if(dianpulist!=null && dianpulist.size()>0){return dianpulist.get(0);}
		else{return null;}
	}
	public User getUserById(User user){
		List<User> userList=commonDao.findByHql("from User where userid='"+user.getUserid()+"'");
		return userList.get(0);
	}

	
	public Leimu getLeimuById(String leimuid){
		List<Leimu> leimulist=commonDao.findByProperty("Leimu", "categoryId", leimuid);
		if(leimulist!=null && leimulist.size()>0){
			return leimulist.get(0);
		}else{
			return null;
		}
	}
	
	
	
}