package com.nongzi.data.controller;

import hidden.org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.nongzi.user.iservice.IChanpinService;
import com.nongzi.user.iservice.IImgService;
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.vo.Chanpin;
import com.nongzi.vo.Chanpinimg;
import com.nongzi.vo.Chanpinorleimu;
import com.nongzi.vo.Chanpinpinpai;
import com.nongzi.vo.Chanpinshuxing;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Leimuorshuxing;
import com.nongzi.vo.User;

@Controller
@RequestMapping("/seller")
public class SellerController {
	public static final String CODE = "code";
	public static final String STATE = "state";
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IChanpinService chanpinService;
	@Autowired
	private IImgService imgService;

	@RequestMapping(value = "/gotoSelectChanpinLeimu", method = RequestMethod.POST)
	public @ResponseBody
	void gotoSelectChanpinLeimu(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<Leimu> leimulist = commonDao
				.findByHql("from Leimu where parentId=0");
		JSONArray datajson = new JSONArray();
		for (Leimu leimu : leimulist) {
			JSONObject jsonnow = new JSONObject();
			jsonnow.put("categoryId", leimu.getCategoryId());
			jsonnow.put("name", leimu.getName());
			datajson.add(jsonnow);
		}
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("leimuinfo", datajson);
		response.getWriter().write(JsonUtils.obj2json(map));
		return;
	}

	@RequestMapping(value = "/getFidLeimuById", method = RequestMethod.POST)
	public @ResponseBody
	void getFidLeimuById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String fid = request.getParameter("fid");
		if(StringUtils.isEmpty(fid)){
			map.put(CODE, "0");
			map.put(STATE, "fid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if (fid != null && !fid.equals("0")) {
			List<Leimu> fids = commonDao.findPageByHql(1, 8,
					"from Leimu where parentId='" + fid + "' ");
			JSONArray fidjson = new JSONArray();
			for (Leimu leimu : fids) {
				JSONObject jsonnow = new JSONObject();
				jsonnow.put("categoryId", leimu.getCategoryId());
				jsonnow.put("name", leimu.getName());
				fidjson.add(jsonnow);
			}
			map.put(CODE, "1");
			map.put(STATE, "查询成功！");
			map.put("fidinfo", fidjson);
			response.getWriter().write(JsonUtils.obj2json(map));
		}else{
			map.put(CODE, "2");
			map.put(STATE, "查询结果为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
		}

	}
	
	@RequestMapping(value = "/getCidLeimuById", method = RequestMethod.POST)
	public @ResponseBody
	void getCidLeimuById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String cid = request.getParameter("cid");
		if(StringUtils.isEmpty(cid)){
			map.put(CODE, "0");
			map.put(STATE, "fid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		if (cid != null && !cid.equals("0")) {
			List<Leimu> clist = commonDao.findPageByHql(1, 8,
					"from Leimu where parentId='" + cid + "' ");
			JSONArray clistjson = new JSONArray();
			for (Leimu leimu : clist) {
				JSONObject jsonnow = new JSONObject();
				jsonnow.put("categoryId", leimu.getCategoryId());
				jsonnow.put("name", leimu.getName());
				clistjson.add(jsonnow);
			}
			map.put(CODE, "1");
			map.put(STATE, "查询成功！");
			map.put("clistinfo", clistjson);
			response.getWriter().write(JsonUtils.obj2json(map));
		}else{
			map.put(CODE, "2");
			map.put(STATE, "查询结果为空！！");
			response.getWriter().write(JsonUtils.obj2json(map));
		}

	}
	
	@RequestMapping(value = "/upProductImage", method = RequestMethod.POST)
	public @ResponseBody
	void upProductImage(
			@RequestParam(value = "imgsrc", required = false) MultipartFile file,
			HttpServletResponse response, HttpServletRequest request,
			ModelMap model) throws IOException {
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

		String resultstr = imgService.upload(file, 300);
		if (StringUtils.isEmpty(resultstr)) {
			map.put(CODE, "3");
			map.put(STATE, "路径为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		} else {
			if (resultstr.equals("fileismax")) {
				map.put(CODE, "4");
				map.put(STATE, "文件上传数据过大！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			} else if (resultstr.equals("fileisnull")) {
				map.put(CODE, "5");
				map.put(STATE, "请选择您上传的图片！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			} else {
				map.put(CODE, "1");
				map.put(STATE, "图片上传成功！");
				map.put("productImgsrc", resultstr.split("_")[2]);
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			}
		}
	}

	@RequestMapping(value = "/addChanpinXinxi", method = RequestMethod.POST)
	public @ResponseBody
	void addChanpinXinxi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String chanpinleimu = request.getParameter("categoryId");
		String keyword = request.getParameter("keyword");
		String miaoshu = request.getParameter("miaoshu");
		String offerDetail = request.getParameter("offerDetail");
		String imgstr = request.getParameter("image");

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
		List<Dianpu> dianpulist = commonDao
				.findByHql("from Dianpu where gongsi.gongsiid='"
						+ user.getGongsi().getGongsiid() + "'");
		if (dianpulist == null || dianpulist.size() == 0) {
			map.put(CODE, "3");
			map.put(STATE, "没有店铺不能添加商品!");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}

		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(chanpinleimu)
				|| StringUtils.isEmpty(keyword) || StringUtils.isEmpty(miaoshu)
				|| StringUtils.isEmpty(offerDetail)) {
			map.put(CODE, "4");
			map.put(STATE, "输入信息存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}

		Chanpinpinpai pinpai = (Chanpinpinpai) commonDao.findByHql(
				"from Chanpinpinpai where pinpaiid='1'").get(0);
		Chanpin chanpin = new Chanpin();
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
		//chanpin.setHtmlid(Integer.valueOf(chanpinleimu));
		chanpin.save();
		if(!StringUtils.isEmpty(imgstr) && imgstr.contains(",")){
			String []imgstrs=imgstr.split(",");
			for (int i = 0; i < imgstrs.length; i++) {
				Chanpinimg cpimg = new Chanpinimg();
				cpimg.setAddtime(new Timestamp(new Date().getTime()));
				cpimg.setChanpin(chanpin);
				cpimg.setImgsrc(imgstrs[i]);
				cpimg.setImgtype(0);
				cpimg.setOrderval(0);
				cpimg.setTypeid("title");
				cpimg.save();
			}
		}
/*
		List imglist = (List) request.getSession().getAttribute("imglist");
		if (imglist != null && imglist.size() > 0) {
			for (int i = 0; i < imglist.size(); i++) {
				Chanpinimg cpimg = new Chanpinimg();
				cpimg.setAddtime(new Timestamp(new Date().getTime()));
				cpimg.setChanpin(chanpin);
				cpimg.setImgsrc(imglist.get(i).toString());
				cpimg.setImgtype(0);
				cpimg.setOrderval(0);
				cpimg.setTypeid("title");
				cpimg.save();
			}
		}*/
		
		List<Leimu> leimulist = commonDao
				.findByHql("from Leimu where categoryId='" + chanpinleimu + "'");
		Chanpinorleimu cplm = new Chanpinorleimu();
		cplm.setChanpin(chanpin);
		cplm.setLeimu(leimulist.get(0));
		cplm.save();
		List<Leimuorshuxing> shuxinglist = commonDao
				.findByHql("from Leimuorshuxing where leimu.categoryId='"
						+ chanpinleimu + "'");
		for (int i = 0; i < shuxinglist.size(); i++) {

			Chanpinshuxing cpsx = new Chanpinshuxing();
			cpsx.setChanpin(chanpin);
			cpsx.setChanpinshuxingid(shuxinglist.get(i).getShuxing()
					.getShuxingid());
			cpsx.setShuxing(shuxinglist.get(i).getShuxing());
			cpsx.setShuxingval(request.getParameter(shuxinglist.get(i)
					.getShuxing().getShuxingid()));
			cpsx.save();
		}
		map.put(CODE, "1");
		map.put(STATE, "添加成功！");
		map.put("chanpinid", chanpin.getChanpinid());
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value="/addChanpinJiaoyiXinxi",method=RequestMethod.POST)
	public @ResponseBody void addChanpinJiaoyiXinxi(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String chanpinid = request.getParameter("chanpinid");
		String unit=request.getParameter("unit");
		String jiage=request.getParameter("jiage");
		if(StringUtils.isEmpty(chanpinid)){
			map.put(CODE, "0");
			map.put(STATE, "chanpinid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));	
			return;
		}
		
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+chanpinid+"'");
		if(chanpinlist==null || chanpinlist.size()==0){
			map.put(CODE, "2");
			map.put(STATE, "查询结果不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));	
			return;	
		}
		Chanpin chanpin=chanpinlist.get(0);
		chanpin.setUnit(unit);
		chanpin.setJiage(Double.parseDouble(jiage));
		chanpin.update();
		map.put(CODE, "1");
		map.put(STATE, "设置成功！");
		response.getWriter().write(JsonUtils.obj2json(map));	
	}
	
	@RequestMapping(value="/getChanpinData",method=RequestMethod.POST)
	public @ResponseBody void getChanpinData(HttpServletRequest request,HttpServletResponse response)throws IOException{
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
		String page=request.getParameter("page");
		String status=request.getParameter("status");
		if(status==null){
			status="1";
		}
		String datas=chanpinService.getChanpinData(user.getUserid(), page, status);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("datas", datas);
		response.getWriter().write(JsonUtils.obj2json(map));
	}
	
	
	@RequestMapping(value="/updateChanpinStatus",method=RequestMethod.POST)
	public @ResponseBody void updateChanpinStatus(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String id=request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			map.put(CODE, "0");
			map.put(STATE, "id为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id+"'");
		if(chanpinlist!=null && chanpinlist.size()>0){
			chanpinlist.get(0).setXinxiststic(3);
			chanpinlist.get(0).update();
			map.put(CODE, "1");
			map.put(STATE, "更新成功！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}else{
			map.put(CODE, "2");
			map.put(STATE, "查询结果为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
	}
	
	@RequestMapping(value="/updateAllChanpinStatus",method=RequestMethod.POST)
	public @ResponseBody void updateAllChanpinStatus(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String[] ids=request.getParameter("ids").split(",");
		if(ids.length==0 || ids==null){
			map.put(CODE, "0");
			map.put(STATE, "ids集合为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}

		for(int i=0;i<ids.length;i++){
			List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+ids[i]+"'");
			if(chanpinlist!=null && chanpinlist.size()>0){
				chanpinlist.get(0).setXinxiststic(3);
				chanpinlist.get(0).update();
			}
		}
		map.put(CODE, "1");
		map.put(STATE, "更新成功！");
		response.getWriter().write(JsonUtils.obj2json(map));
	}
	
	@RequestMapping(value="/deleteAllChanpin",method=RequestMethod.POST)
	public @ResponseBody void deleteAllChanpin(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String[] ids=request.getParameter("ids").split(",");
		if(ids.length==0 || ids==null){
			map.put(CODE, "0");
			map.put(STATE, "ids集合为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		for(int i=0;i<ids.length;i++){
			List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+ids[i]+"'");
			if(chanpinlist!=null && chanpinlist.size()>0){
				chanpinlist.get(0).setXinxiststic(4);
				chanpinlist.get(0).update();
			}
		}
		map.put(CODE, "1");
		map.put(STATE, "删除成功！");
		response.getWriter().write(JsonUtils.obj2json(map));

	}
	
	
	@RequestMapping(value="/chanpinShangjia",method=RequestMethod.POST)
	public @ResponseBody void chanpinShangjia(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String id=request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			map.put(CODE, "0");
			map.put(STATE, "id为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Chanpin> chanpinlist=commonDao.findByHql("from Chanpin where chanpinid='"+id+"'");
		if(chanpinlist!=null && chanpinlist.size()>0){
			chanpinlist.get(0).setXinxiststic(1);
			chanpinlist.get(0).update();
			map.put(CODE, "1");
			map.put(STATE, "上架成功！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}else{
			map.put(CODE, "2");
			map.put(STATE, "查询结果不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
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
