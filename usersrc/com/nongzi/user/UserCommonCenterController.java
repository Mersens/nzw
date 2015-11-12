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
@RequestMapping("/userCommonCenter")
public class UserCommonCenterController  {
	
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	@RequestMapping(value = "/gotoHead",method = RequestMethod.GET)
	public String gotoHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "usercommon/head";
	}
	@RequestMapping(value = "/gotoFoot",method = RequestMethod.GET)
	public String gotoFoot(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "usercommon/foot";
	}
	@RequestMapping(value = "/gotoHelp",method = RequestMethod.GET)
	public String gotoHelp(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "usercommon/help";
	}
	@RequestMapping(value = "/gotoLeft",method = RequestMethod.GET)
	public String gotoLeft(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "usercommon/left";
	}
	@RequestMapping(value = "/gotoIndex",method = RequestMethod.GET)
	public String gotoIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "usercommon/main";
	}
}