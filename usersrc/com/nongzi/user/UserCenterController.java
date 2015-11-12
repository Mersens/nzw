package com.nongzi.user;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import com.nongzi.user.iservice.IMyMessageService;
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.util.MD5;
import com.nongzi.util.RandomString;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Area;
import com.nongzi.vo.City;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.Dianpunews;
import com.nongzi.vo.Gongsi;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Province;
import com.nongzi.vo.Sysmessage;
import com.nongzi.vo.User;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/userCenter")
public class UserCenterController  {
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private MD5 md5;
	@Autowired
	private IImgService imgService;
	
	
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 跳转到账户安全页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 下午2:41:18 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoZhanghuSafe",method=RequestMethod.GET)
	public String gotoZhanghuSafe(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("user", getUserById((User) request.getSession().getAttribute("user")));
		return "user/zhanghuanquan";
	}
	/**
	 * 跳转到个人信息页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 下午2:43:10 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoGerenXinxi",method=RequestMethod.GET)
	public String gotoGerenXinxi(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("user", getUserById((User) request.getSession().getAttribute("user")));
		return "user/gerenxinxi";
	}
	
	@RequestMapping(value="/updateGerenXinxi",method=RequestMethod.POST)
	public String updateGerenXinxi(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String xingming=request.getParameter("xingming");
		String userphone=request.getParameter("userphone");
		String qq=request.getParameter("qq");
		if(xingming==null || xingming.equals("") || userphone==null || userphone.equals("")){
			response.getWriter().print(sh.ShowMessage("请完善信息后再提交", "/userCenter/gotoGerenXinxi"));
			return null;
		}
		user.setXingming(xingming);
		user.setUserphone(userphone);
		user.setQq(qq);
		user.update();
		response.getWriter().print(sh.ShowMessage("信息修改成功", "/userCenter/gotoGerenXinxi"));
		return null;
	}
	
	
	@RequestMapping(value = "/gotoUpFile",method = RequestMethod.GET)
	public String gotoUpFile(HttpServletRequest request, HttpServletResponse response){
		String type=request.getParameter("type");
		System.out.println("===type======="+type);
		if(type!=null && !type.equals("")){
			request.setAttribute("type", type);
		}
		return "user/upFile";
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
		System.out.println(type+"==========res");
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
						System.out.println(request.getSession().getAttribute(type)+"----------------");
					}
					
				}else{
					user=(User) commonDao.findByHql("from User where userid='1'").get(0);
					user.setTouxiang(resultstr.split("_")[2]);
					user.update();
				}
			}
		}
		response.getWriter().println("<script type=\"text/javascript\">");
		response.getWriter().println("alert(\"图片上传成功\")");
		response.getWriter().println("var index = parent.layer.getFrameIndex(window.name);");
		response.getWriter().println("parent.location.reload();");
		response.getWriter().println("parent.layer.close(index); //执行关闭");
		response.getWriter().println("</script>");
		return null;
	}
	
	/**
	 * 修改用户密码
	 * 
	 * @author LHC
	 * @date 2015-9-17 下午6:27:29 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/updateUserPassword",method=RequestMethod.POST)
	public String testUserPassword(HttpServletRequest request,HttpServletResponse response)throws IOException{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		String confirmpwd=request.getParameter("confirmpwd");
		if(oldpwd.equals("") || oldpwd==null || newpwd.equals("") || newpwd==null || confirmpwd.equals("") || confirmpwd==null){
			response.getWriter().print("0");  
			return null;
		}
		
		if(!oldpwd.equals(md5.decrypt(user.getUserpwd()))) {
			response.getWriter().print("2");  //原密码输入不正确
			return null;
		}
		if(!newpwd.equals(confirmpwd)){
			response.getWriter().print("3");  //两次密码输入不一致
			return null;
		}
		user.setUserpwd(md5.encrypt(newpwd));
		user.update();
		response.getWriter().print("1");
		
		return null;
	}
	
	
	/**
	 * 跳转到修改手机页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:46:17 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoUpdatePhone_1",method=RequestMethod.GET)
	public String gotoUpdatePhone_1(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("user",  getUserById((User) request.getSession().getAttribute("user")));
		return "user/xiugaishouji_1";
	}
	/**
	 * 发送手机验证码
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:46:00 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 *
	 */
	@RequestMapping(value="/sendPhoneCode",method=RequestMethod.POST)
	public String sendPhoneCode(HttpServletRequest request,HttpServletResponse response)throws Exception{
		User user= getUserById((User) request.getSession().getAttribute("user"));
		String phonecode=new RandomString().getRandombianhao(6);;
		String content="【农资101】尊敬的用户您好，您的验证码是：";
		System.out.println(phonecode+"==============");
//		SendPhoneMSG send=new SendPhoneMSG();
	//	String codestatic=send.sendSMS(user.getUserphone(), content+phonecode);
		String codestatic="0";
		System.out.println(content+phonecode);
		if(codestatic.startsWith("0")){
			request.getSession().setAttribute("oldphonecode", phonecode);
			response.getWriter().print("1");
		}
		return null;
	}
	/**
	 * 验证验证码是否输入正确
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:45:44 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/testOldPhoneCode",method=RequestMethod.GET)
	public String testOldPhoneCode(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String phoneCode=request.getParameter("phoneCode");
		String yanzhengma=request.getParameter("validateCode");
		System.out.println(phoneCode+"===="+yanzhengma);
		if( phoneCode==null || phoneCode.equals("") || yanzhengma==null || yanzhengma.equals("") ){
			response.getWriter().print(sh.ShowMessage("信息填写不完整", "/userCenter/gotoUpdatePhone_1"));
			return null;
		}
		String oldphonecode=(String) request.getSession().getAttribute("oldphonecode");
		System.out.println(!phoneCode.equals(oldphonecode));
		if(!phoneCode.equals(oldphonecode)){
			response.getWriter().print(sh.ShowMessage("手机验证码不正确", "/userCenter/gotoUpdatePhone_1"));   //手机验证码输入不正确
			return null;
		}
		String yzm=(String) request.getSession().getAttribute("rand");
		if(!yanzhengma.equals(yzm)){
			response.getWriter().print(sh.ShowMessage("验证码不正确", "/userCenter/gotoUpdatePhone_1"));  //验证码输入不正确
			return null;
		}
		request.getSession().removeAttribute("oldphonecode");
		request.getSession().removeAttribute("rand");
		return "user/xiugaishouji_2";
	}
	
	/**
	 * 往新的手机上面发送验证码
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:45:22 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 *
	 */
	@RequestMapping(value="/sendNewPhoneCode",method=RequestMethod.POST)
	public String sendNewPhoneCode(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String newphone=request.getParameter("newphone");
		String phonecode=new RandomString().getRandombianhao(6);;
		String content="【农资101】尊敬的用户您好，您的验证码是：";
//		SendPhoneMSG send=new SendPhoneMSG();
		System.out.println(phonecode+"===============================new");
	//	String codestatic=send.sendSMS(newphone, content+phonecode);
		String codestatic="0";
		System.out.println(content+phonecode);
		if(codestatic.startsWith("0")){
			request.getSession().setAttribute("newphonecode", phonecode);
			response.getWriter().print("1");
		}
		return null;
	}
	/**
	 * 修改手机
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:45:03 
	 * @comment 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value="/testNewPhoneCode",method=RequestMethod.POST)
	public String testNewPhoneCode(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String newphone=request.getParameter("newphone");
		String phoneCode=request.getParameter("phoneCode");
		String yanzhengma=request.getParameter("yanzhengma");
		if( phoneCode==null || phoneCode.equals("") ||  yanzhengma==null || yanzhengma.equals("") || newphone==null || newphone.equals("") ){
			response.getWriter().print("0");
			return null;
		}
		String oldphonecode=(String) request.getSession().getAttribute("newphonecode");
		if(!phoneCode.equals(oldphonecode)){
			response.getWriter().print("2");   //手机验证码输入不正确
			return null;
		}
		String yzm=(String) request.getSession().getAttribute("rand");
		if(!yanzhengma.equals(yzm)){
			response.getWriter().print("3");  //验证码输入不正确
			return null;
		}
		request.getSession().removeAttribute("newphonecode");
		request.getSession().removeAttribute("rand");
//		User user=(User) request.getSession().getAttribute("user");
			List<User> userList=commonDao.findByHql("from User where userid='1'");
			User user=userList.get(0);
			user.setUserphone(newphone);
			user.update();
		
		response.getWriter().print("1");
		return null;
	}
	/**
	 * 跳转到修改手机成功页面
	 * 
	 * @author LHC
	 * @date 2015-9-21 上午9:44:41 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="gotoUpdatePhoneSuccess",method=RequestMethod.GET)
	public String gotoUpdatePhoneSuccess(HttpServletRequest request,HttpServletResponse response){
		
		return "user/xiugaishouji_3";
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 跳转到发布产品页面
	 * 
	 * @author LHC
	 * @date 2015-10-8 下午2:41:57 
	 * @comment 
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value="/gotoFabuChanpin",method=RequestMethod.GET)
	public String gotoFabuChanpin(HttpServletRequest request,HttpServletResponse response){
		
		return "user/fabuchanpin_1";
	}
	
	@RequestMapping(value="/gotoSelectChanpinLeimu",method=RequestMethod.GET)
	public String gotoSelectChanpinLeimu(HttpServletRequest request,HttpServletResponse response){
		String leimuid=request.getParameter("leimuid");
		String pid=request.getParameter("pid");
		List<Leimu> leimulist=commonDao.findByHql("from Leimu where parentId=0");
		request.setAttribute("leimulist", leimulist);
		if(leimuid!=null && !leimuid.equals("")){
			request.setAttribute("leimulist2", commonDao.findByHql("from Leimu where parentId='"+leimuid+"' "));
		}
		if(pid!=null && !pid.equals("")){
			request.setAttribute("leimulist3", commonDao.findByHql("from Leimu where parentId='"+pid+"' "));
		}
		return "user/fabuchanpin_2";
	}
	
	@RequestMapping(value="/gotoAddChanpinXinxi",method=RequestMethod.GET)
	public String gotoAddChanpinXinxi(HttpServletRequest request,HttpServletResponse response){
		
		return "user/fabuchanpin_3";
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

	
	
	
	
	
}