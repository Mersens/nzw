package com.nongzi.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IGongsiService;
import com.nongzi.user.iservice.IImgService;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Area;
import com.nongzi.vo.City;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.Dianpuleimu;
import com.nongzi.vo.Dianpunews;
import com.nongzi.vo.Dianputype;
import com.nongzi.vo.Gongsi;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Province;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/gongsi")
public class GongsiCenterController {

	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IGongsiService gongsiService;
	@Autowired
	private IImgService imgService;
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
		
	/**
	 * 跳转到发布新闻动态页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午11:17:33 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoFabuDongtai",method=RequestMethod.GET)
	public String gotoFabuDongtai(HttpServletRequest request,HttpServletResponse response){
		
		return "company/fabudongtai";
	}
	/**
	 * 添加新闻动态
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午11:17:46 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/FabuDongtai",method=RequestMethod.POST)
	public String FabuDongtai(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String title=request.getParameter("title");
		String keywords=request.getParameter("keywords");
		String miaoshu=request.getParameter("miaoshu");
		String center=request.getParameter("center");
		if(title==null || title.equals("") || miaoshu==null || miaoshu.equals("") || center==null || center.equals("")){
			response.getWriter().print(sh.ShowMessage("信息填写不完整", "/user/company/addnews.html"));
			return null;
		}
		if(user.getGongsi()==null){
			response.getWriter().print(sh.ShowMessage("您还未开通公司，不能发布动态", "/user/company/info.html"));
			return null;
		}
		Dianpu dianpu=getDianpuByGongsiId(user.getGongsi().getGongsiid());
		if(dianpu==null){
			response.getWriter().print(sh.ShowMessage("您还未开通店铺，不能发布动态", "/user/company/wangpuinfo.html"));
			return null;
		}
		Dianpunews news=new Dianpunews();
		news.setAddtime(new Timestamp(new Date().getTime()));
		news.setCenter(center);
		news.setDianpu(dianpu);
		news.setKeywords(keywords);
		news.setMiaoshu(miaoshu);
		news.setTitle(title);
		news.setXinwenstatic(1);
		news.setUser(user);
		news.save();
		response.getWriter().print(sh.ShowMessage("发布成功", "/user/company/news.html"));
		return null;
	}
	
	/**
	 * 跳转到公司动态页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午11:32:43 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoGongsiDongtai",method=RequestMethod.GET)
	public String gotoGongsiDongtai(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String newstitle=request.getParameter("newstitle");
		if(newstitle!=null && !newstitle.equals(""))
		newstitle =new String(newstitle.getBytes("iso-8859-1"),"UTF-8"); 
		request.setAttribute("newstitle", newstitle);
		return "company/gongsidongtai";
	}
	/**
	 * 获取公司动态数据
	 * 
	 * @author LHC
	 * @date 2015-9-22 下午7:25:32 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/getGongsiDongtaiData",method=RequestMethod.GET)
	public String getGongsiDongtaiData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String page=request.getParameter("page");
		if(page==null || page.equals("")){
			page="1";
		}
		String typeid=request.getParameter("typeid");
		if(typeid!=null && !typeid.equals("")){
			typeid =new String(typeid.getBytes("iso-8859-1"),"UTF-8"); 
			
		}
		String gongsidongtai=gongsiService.getGongsiDongtaiData(user.getUserid(), page,typeid);
		response.getWriter().print(gongsidongtai);
		return null;
	}
	/**
	 * 删除公司动态
	 * 
	 * @author LHC
	 * @date 2015-9-22 下午7:25:21 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/deleteGongsiDongtai",method=RequestMethod.POST)
	public String deleteGongsiDongtai(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String newsid=request.getParameter("newsid");
		List<Dianpunews> newslist=commonDao.findByHql("from Dianpunews where newsid='"+newsid+"'");
		if(newslist!=null && newslist.size()>0){
			newslist.get(0).setXinwenstatic(2);
			newslist.get(0).update();
			response.getWriter().print("1");
		}
		return null;
	}
	/**
	 * 跳转到公司信息页面
	 * 
	 * @author LHC
	 * @date 2015-9-28 下午4:05:14 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoGongsiXinxi",method=RequestMethod.GET)
	public String gotoGongsiXinxi(HttpServletRequest request,HttpServletResponse response){
		User user= getUserById((User) request.getSession().getAttribute("user"));
		request.setAttribute("user", user);
		List<Province> provinceList=commonDao.findByHql("from Province where provinceid!='0'");
		request.setAttribute("provinceList", provinceList);
		if(user.getGongsi()!=null){
			request.setAttribute("gongsi", user.getGongsi());
			return "company/updategongsixinxi";
		}
		return "company/gongsixinxi";
	}

	@RequestMapping(value = "/gotoUpFile",method = RequestMethod.GET)
	public String gotoUpFile(HttpServletRequest request, HttpServletResponse response){
		String type=request.getParameter("type");
		if(type!=null && !type.equals("")){
			request.setAttribute("type", type);
		}
		return "company/upFile";
	}
	/**
	 * 
	 * 说明: 上传文件
	 * 时间：2015-5-13
	 * 作者：管东升
	 * @param file
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public String up(@RequestParam(value = "imgsrc", required = false) MultipartFile file, HttpServletResponse response, HttpServletRequest request, ModelMap model) throws IOException {
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String resultstr = imgService.upload(file,300);
		String type=request.getParameter("type");
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
				response.getWriter().println("window.parent.document.getElementById('imgsrc').value='"+ resultstr.split("_")[2]+"'");
				response.getWriter().println("window.parent.document.getElementById('imageshow').src='"+resultstr.split("_")[2]+"';");
				response.getWriter().println("</script>");
				if(type!=null && !type.equals("")){
					if(user.getGongsi()!=null){
						if(type.equals("yingyezhizhao")){
							user.getGongsi().setYingyezhizhao(resultstr.split("_")[2]);
						}else if(type.equals("shuiwuzheng")){
							user.getGongsi().setShuiwudengji(resultstr.split("_")[2]);
						}else if(type.equals("zuzhidaima")){
							user.getGongsi().setJigoudaima(resultstr.split("_")[2]);
						}
						user.getGongsi().update();
					}else{
						if(type.equals("yingyezhizhao")){
							request.getSession().setAttribute("yingyezhizhao", resultstr.split("_")[2]);
						}else if(type.equals("shuiwuzheng")){
							request.getSession().setAttribute("shuiwuzheng", resultstr.split("_")[2]);
						}else if(type.equals("zuzhidaima")){
							request.getSession().setAttribute("zuzhidaima", resultstr.split("_")[2]);
						}
					}
					
					response.getWriter().println("<script type=\"text/javascript\">");
					response.getWriter().println("alert(\"图片上传成功\")");
					response.getWriter().println("var index = parent.layer.getFrameIndex(window.name);");
					response.getWriter().println("parent.location.reload();");
					response.getWriter().println("parent.layer.close(index); //执行关闭");
					response.getWriter().println("</script>");
					
				}
			}
		}
		return null;
	}
	/**
	 * 跳转到公司审核页面
	 * 
	 * @author LHC
	 * @date 2015-10-12 下午5:12:33 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoRenzhengGongsiXinxi",method=RequestMethod.GET)
	public String gotoRenzhengGongsiXinxi(HttpServletRequest request,HttpServletResponse response){
	
		return "company/gongsirenzheng";
	}
	
	/**
	 * 添加公司信息
	 * 
	 * @author LHC
	 * @date 2015-9-28 下午4:05:27 
	 * @comment 
	 * @param gs
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/addGongsiXinxi",method=RequestMethod.POST)
	public String addGongsiXinxi(@ModelAttribute Gongsi gs, HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		System.out.println(gs.getGongsinama()+"-------");
		String gongsinama=gs.getGongsinama();
		String jiancheng=gs.getJiancheng();
		String miaoshu=gs.getMiaoshu();
		String dianhua=gs.getDianhua();
		String chuanzhen=gs.getChuanzhen();
		String lianxiren=gs.getLianxiren();
		String lianxirendianhua=gs.getLianxirendianhua();
		String dizhi=gs.getDizhi();
		String yingyezhizhao=gs.getYingyezhizhao();
		String shuiwudengji=gs.getShuiwudengji();
		String zuzhidaima=gs.getJigoudaima();
		String provinceid=request.getParameter("provinceid");
		String cityid=request.getParameter("cityid");
		String areaid=request.getParameter("areaid");
		System.out.println(gs.getGongsinama()+"-------"+dizhi);
		Gongsi gongsi=new Gongsi();
		gongsi.setAddtime(new Timestamp(new Date().getTime()));
		gongsi.setChuanzhen(chuanzhen);
		gongsi.setDianhua(dianhua);
		gongsi.setDizhi(dizhi);
		gongsi.setGongsinama(gongsinama);
		gongsi.setJiancheng(jiancheng);
		gongsi.setLianxiren(lianxiren);
		gongsi.setLianxirendianhua(lianxirendianhua);
		gongsi.setMiaoshu(miaoshu);
		gongsi.setYingyezhizhao(yingyezhizhao);
		gongsi.setShuiwudengji(shuiwudengji);
		gongsi.setJigoudaima(zuzhidaima);
		gongsi.setGslogo("/userfile/gongsilogo/gslogo.jpg");
		List<Province> provincelist=commonDao.findByHql("from Province where provinceid='"+provinceid+"'");
		gongsi.setProvince(provincelist.get(0));
		List<City> citylist=commonDao.findByHql("from City where cityid='"+cityid+"'");
		gongsi.setCity(citylist.get(0));
		List<Area> arealist=commonDao.findByHql("from Area where areaid='"+areaid+"'");
		gongsi.setArea(arealist.get(0));
		gongsi.setJingweidu("0");
		gongsi.setIslock(0);
		gongsi.save();
		user.setGongsi(gongsi);
		user.update();
		request.getSession().removeAttribute("yingyezhizhao");
		request.getSession().removeAttribute("shuiwuzheng");
		request.getSession().removeAttribute("zuzhidaima");
		response.getWriter().print("1");
		return null;
	}
	
	@RequestMapping(value="/updateGongsiXinxi",method=RequestMethod.POST)
	public String updateGongsiXinxi(@ModelAttribute Gongsi gs, HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		System.out.println(gs.getProvince()+"-------");
		String jiancheng=gs.getJiancheng();
		String miaoshu=gs.getMiaoshu();
		String dianhua=gs.getDianhua();
		String chuanzhen=gs.getChuanzhen();
		String lianxiren=gs.getLianxiren();
		String lianxirendianhua=gs.getLianxirendianhua();
		String dizhi=gs.getDizhi();
		String yingyezhizhao=gs.getYingyezhizhao();
		String shuiwudengji=gs.getShuiwudengji();
		String zuzhidaima=gs.getJigoudaima();
		String provinceid=request.getParameter("provinceid");
		String cityid=request.getParameter("cityid");
		String areaid=request.getParameter("areaid");
		System.out.println(gs.getGongsinama()+"-------"+dizhi);
		Gongsi gongsi=user.getGongsi();
		gongsi.setAddtime(new Timestamp(new Date().getTime()));
		gongsi.setChuanzhen(chuanzhen);
		gongsi.setDianhua(dianhua);
		gongsi.setDizhi(dizhi);
		gongsi.setJiancheng(jiancheng);
		gongsi.setLianxiren(lianxiren);
		gongsi.setLianxirendianhua(lianxirendianhua);
		gongsi.setMiaoshu(miaoshu);
		gongsi.setYingyezhizhao(yingyezhizhao);
		gongsi.setShuiwudengji(shuiwudengji);
		gongsi.setJigoudaima(zuzhidaima);
		List<Province> provincelist=commonDao.findByHql("from Province where provinceid='"+provinceid+"'");
		gongsi.setProvince(provincelist.get(0));
		List<City> citylist=commonDao.findByHql("from City where cityid='"+cityid+"'");
		gongsi.setCity(citylist.get(0));
		List<Area> arealist=commonDao.findByHql("from Area where areaid='"+areaid+"'");
		gongsi.setArea(arealist.get(0));
		gongsi.update();
		response.getWriter().print("1");
		return null;
	}
	
	@RequestMapping(value="/gotoWangpuZiliao",method=RequestMethod.GET)
	public String gotoWangpuZiliao(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		if(user.getGongsi()==null){
			response.getWriter().print(sh.ShowMessage("您还未添加公司", "/user/company/info.html"));
			return null;
		}
		request.setAttribute("gongsi", user.getGongsi());
		//主营类目
		List<Leimu> leimulist=commonDao.findByHql("from Leimu where parentId=0");
		request.setAttribute("leimulist",leimulist );
		//旺铺类型
		List<Dianputype> typelist=commonDao.findByHql("from Dianputype");
		request.setAttribute("typelist", typelist);
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"'");
		if(dianpulist!=null && dianpulist.size()>0){
			request.setAttribute("dianpu",dianpulist.get(0));
			List<Dianpuleimu> dianpuleimu=commonDao.findByHql("from Dianpuleimu where dianpu.dianpuid='"+dianpulist.get(0).getDianpuid()+"'");
			request.setAttribute("dianpuleimu", dianpuleimu);
			return "company/updatewangpuziliao";
		}
		return "company/wangpuziliao";
	}
	/**
	 * 添加旺铺信息
	 * 
	 * @author LHC
	 * @date 2015-10-13 下午6:16:09 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/addWangpuZiliao",method=RequestMethod.POST)
	public String addWangpuZiliao(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		Gongsi gongsi=user.getGongsi();
		String dianputype=request.getParameter("dianputype");
		String dianpuleimu=request.getParameter("dianpuleimu");
		String dianpujieshao=request.getParameter("dianpujieshao");
		Dianputype dptype=null;
		if(dianputype!=null && !dianputype.equals("")){
			List<Dianputype> typelist=commonDao.findByHql("from Dianputype where typeid='"+dianputype+"'");
			if(typelist!=null && typelist.size()>0){
				dptype=typelist.get(0);
			}
		}
		
		
		Dianpu dianpu=new Dianpu();
		dianpu.setAddtime(new Timestamp(new Date().getTime()));
		dianpu.setDianpujieshao(dianpujieshao);
		dianpu.setDianpuname(gongsi.getGongsinama());
		dianpu.setDianputype(dptype);
		dianpu.setGongsi(gongsi);
		dianpu.setIslock(0);
		dianpu.setUser(user);
		dianpu.save();
		
		String[] leimus=dianpuleimu.split(",");
		for(int i=0;i<leimus.length;i++){
			String leimui=leimus[i];
			System.out.println(leimui+"---------------");
			List<Leimu> leimulisti=commonDao.findByHql("from Leimu where categoryId='"+leimui+"'");
			if(leimulisti!=null && leimulisti.size()>0){
				Dianpuleimu dpleimui=new Dianpuleimu();
				dpleimui.setAddtime(new Timestamp(new Date().getTime()));
				dpleimui.setDianpu(dianpu);
				dpleimui.setLeimu(leimulisti.get(0));
				dpleimui.setUser(user);
				dpleimui.save();
			}
			
			
		}
		response.getWriter().print("1");
		return null;
	}
	
	@RequestMapping(value="/updateWangpuZiliao",method=RequestMethod.POST)
	public String updateWangpuZiliao(HttpServletResponse response,HttpServletRequest request)throws IOException{
		User user=getUserById((User) request.getSession().getAttribute("user"));
		List<Dianpu> dianpulist=commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+user.getGongsi().getGongsiid()+"'");
		Dianpu dianpu=dianpulist.get(0);
		String dianpuleimu=request.getParameter("dianpuleimu");
		String dianpujieshao=request.getParameter("dianpujieshao"); 
		
		dianpu.setDianpujieshao(dianpujieshao);
		dianpu.update();
		List<Dianpuleimu> leimulist=commonDao.findByHql("from Dianpuleimu where dianpu.dianpuid='"+dianpu.getDianpuid()+"'");
		for (Dianpuleimu leimu : leimulist) {
			leimu.delete();
		}
		
		String[] leimus=dianpuleimu.split(",");
		for(int i=0;i<leimus.length;i++){
			String leimui=leimus[i];
			System.out.println(leimui+"---------------");
			List<Leimu> leimulisti=commonDao.findByHql("from Leimu where categoryId='"+leimui+"'");
			if(leimulisti!=null && leimulisti.size()>0){
				Dianpuleimu dpleimui=new Dianpuleimu();
				dpleimui.setAddtime(new Timestamp(new Date().getTime()));
				dpleimui.setDianpu(dianpu);
				dpleimui.setLeimu(leimulisti.get(0));
				dpleimui.setUser(user);
				dpleimui.save();
			}
		}
		
	   response.getWriter().print("1");
		return null;
	}
	
	public Dianpu getDianpuById(int htmlid){
		List<Dianpu> dianpulist = commonDao.findByProperty("Dianpu", "htmlid", htmlid); 
		if(dianpulist!=null && dianpulist.size()>0){return dianpulist.get(0);}
		else{return null;}
	}
	public Dianpu getDianpuByGongsiId(String gongsiId){
		List<Dianpu> dianpulist = commonDao.findByHql("from Dianpu where gongsi.gongsiid='"+gongsiId+"'"); 
		if(dianpulist!=null && dianpulist.size()>0){return dianpulist.get(0);}
		else{return null;}
	}
	public User getUserById(User user){
		List<User> userList=commonDao.findByHql("from User where userid='"+user.getUserid()+"'");
		return userList.get(0);
	}
	
}
