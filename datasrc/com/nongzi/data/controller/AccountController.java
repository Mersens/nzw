package com.nongzi.data.controller;
import hidden.org.codehaus.plexus.util.StringUtils;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.nongzi.dao.CommonDAO;
import com.nongzi.data.utils.JsonUtils;
import com.nongzi.user.iservice.IImgService;
import com.nongzi.util.MD5;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/userAccount")
public class AccountController {
	public static final String CODE = "code";
	public static final String STATE = "state";
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IImgService imgService;
	@Autowired
	private MD5 md5;
	
	@RequestMapping(value="/updateGerenXinxi",method=RequestMethod.POST)
	public @ResponseBody void updateGerenXinxi(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String xingming=request.getParameter("xingming");
		String qq=request.getParameter("qq");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(StringUtils.isEmpty(xingming) || StringUtils.isEmpty(qq)){
			map.put(CODE, "2");
			map.put(STATE, "姓名 QQ存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);
		user.setXingming(xingming);
		user.setQq(qq);
		user.update();
		map.put(CODE, "1");
		map.put(STATE, "修改成功！");
		response.getWriter().write(JsonUtils.obj2json(map));
	}
	
	@RequestMapping(value = "/upUserImg", method = RequestMethod.POST)
	public @ResponseBody void upUserImg(@RequestParam(value = "imgsrc", required = false) MultipartFile file, HttpServletResponse response, HttpServletRequest request, ModelMap model) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);
		String resultstr = imgService.upload(file);
		if(resultstr != null){
			if(resultstr.equals("fileismax")){
				map.put(CODE, "3");
				map.put(STATE, "上传失败！原因：文件上传数据过大！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;

			}else if(resultstr.equals("fileisnull")){
				map.put(CODE, "4");
				map.put(STATE, "上传失败！原因：文件不存在！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			}else {
				user.setTouxiang(resultstr.split("_")[2]);
				user.update();
				map.put(CODE, "1");
				map.put(STATE, "上传成功！");
				map.put("imgsrc", resultstr.split("_")[2]);
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			}
		}else{
			map.put(CODE, "2");
			map.put(STATE, "上传失败！原因：头像路径为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}

	}
	
	@RequestMapping(value="/updateUserPassword",method=RequestMethod.POST)
	public @ResponseBody void testUserPassword(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		String confirmpwd=request.getParameter("confirmpwd");
		String userid = request.getParameter("userid");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);

		if(oldpwd.equals("") || oldpwd==null || newpwd.equals("") || newpwd==null || confirmpwd.equals("") || confirmpwd==null){
			map.put(CODE, "2");
			map.put(STATE, "输入信息存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		
		if(!oldpwd.equals(md5.decrypt(user.getUserpwd()))) {
			map.put(CODE, "3");
			map.put(STATE, "原密码输入不正确！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(!newpwd.equals(confirmpwd)){
			map.put(CODE, "4");
			map.put(STATE, "两次密码输入不一致！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		user.setUserpwd(md5.encrypt(newpwd));
		user.update();
		map.put(CODE, "1");
		map.put(STATE, "修改成功！");
		response.getWriter().write(JsonUtils.obj2json(map));
	}
	
	@RequestMapping(value="/sendOldPhoneCode",method=RequestMethod.POST)
	public @ResponseBody void sendOldPhoneCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");
		String phonecode = request.getParameter("phonecode");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(StringUtils.isEmpty(content) || StringUtils.isEmpty(phonecode)){
			map.put(CODE, "2");
			map.put(STATE, "输入数据存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);
		System.out.println("sendOldPhoneCode---------->content===="+content+"--------phonecode-------"+phonecode);
/*		SendPhoneMSG send=new SendPhoneMSG();
		String codestatic=send.sendSMS(user.getUserphone(), content+phonecode);
		map.put(CODE, "1");
		map.put(STATE, "发送成功！");
		response.getWriter().write(JsonUtils.obj2json(map));*/

	}
	
	@RequestMapping(value="/sendNewPhoneCode",method=RequestMethod.POST)
	public @ResponseBody void sendNewPhoneCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");
		String phonecode = request.getParameter("phonecode");
		String newphone = request.getParameter("newphone");
		if(StringUtils.isEmpty(userid)){
			map.put(CODE, "0");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if(StringUtils.isEmpty(content) || StringUtils.isEmpty(phonecode) || StringUtils.isEmpty(newphone)){
			map.put(CODE, "2");
			map.put(STATE, "输入数据存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user= getUserById(userid);
		if(user.getUserphone().equals(newphone)){
			map.put(CODE, "3");
			map.put(STATE, "新手机号与旧手机号相同！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		
		user.setUserphone(newphone);
		user.update();
		System.out.println("sendNewPhoneCode----------->content===="+content+"--------phonecode-------"+phonecode+"--------newphone----"+newphone);

/*		SendPhoneMSG send=new SendPhoneMSG();
		String codestatic=send.sendSMS(newphone, content+phonecode);
		map.put(CODE, "1");
		map.put(STATE, "发送成功！");
		response.getWriter().write(JsonUtils.obj2json(map));*/
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
