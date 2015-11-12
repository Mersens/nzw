package com.nongzi.data.controller;
import java.io.IOException;
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
import com.nongzi.vo.User;

@Controller
@RequestMapping("/myInfo")
public class MyInfoController {
	@Autowired
	private CommonDAO commonDao;
	@RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
	public @ResponseBody void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userid=request.getParameter("userid");
		Map<String, Object> userMap = new LinkedHashMap<String, Object>();
		if(userid==null || "".equals(userid)){
			userMap.put("code", "0");
			userMap.put("state", "userid为空!");
		}else{
			List<User> userlist = commonDao.findByHql("FROM User WHERE userid='"+userid+"' ");
			if(userlist==null || userlist.size()==0){
				userMap.put("code", "2");
				userMap.put("state", "未查到用户信息!");
			}else{
					userMap.put("code", "1");
					userMap.put("state", "查找成功!");
					Map<String,Object> map=new LinkedHashMap<String, Object>();
					User user=userlist.get(0);
					map.put("userid",user.getUserid() );
					map.put("username", user.getUsername());
					map.put("userphone", user.getUserphone());
					map.put("qq", user.getQq());
					map.put("xingming", user.getXingming());
					map.put("touxiang", user.getTouxiang());
					map.put("userpwdStatic", user.getUserpwdStatic());
					map.put("userjiaoyipwdStatic", user.getUserjiaoyipwdStatic());
					map.put("addtime", user.getAddtime());
					userMap.put("userinfo", map);
			}
		}
		response.getWriter().write(JsonUtils.obj2json(userMap));
	 }
}
