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
import com.nongzi.user.iservice.IGongsiService;
import com.nongzi.user.iservice.IImgService;
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
@RequestMapping("/company")
public class CompanyController {
	public static final String CODE = "code";
	public static final String STATE = "state";

	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private IGongsiService gongsiService;
	@Autowired
	private IImgService imgService;

	@RequestMapping(value = "/upDocumentsImage", method = RequestMethod.POST)
	public @ResponseBody
	void upDocumentsImage(
			@RequestParam(value = "imgsrc", required = false) MultipartFile file,
			HttpServletResponse response, HttpServletRequest request,
			ModelMap model) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		if (StringUtils.isEmpty(userid)) {
			map.put(CODE, "5");
			map.put(STATE, "userid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		User user = getUserById(userid);
		if (user == null) {
			map.put(CODE, "6");
			map.put(STATE, "用户不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		String resultstr = imgService.upload(file, 300);
		String type = request.getParameter("type");
		if (type == null || "".equals(type)) {
			map.put(CODE, "4");
			map.put(STATE, "上传失败！原因：照片类型为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}

		if (resultstr == null || "".equals(resultstr)) {
			map.put(CODE, "0");
			map.put(STATE, "上传失败！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		} else {
			if (resultstr.equals("fileismax")) {
				map.put(CODE, "2");
				map.put(STATE, "上传失败！原因：上传文件过大。");
				response.getWriter().write(JsonUtils.obj2json(map));
			} else if (resultstr.equals("fileisnull")) {
				map.put(CODE, "3");
				map.put(STATE, "上传失败！原因：上传文件不存在。");
				response.getWriter().write(JsonUtils.obj2json(map));
			} else {
				if (type != null && !type.equals("")) {
					if (user.getGongsi() != null) {
						if (type.equals("yingyezhizhao")) {
							user.getGongsi().setYingyezhizhao(
									resultstr.split("_")[2]);
						} else if (type.equals("shuiwuzheng")) {
							user.getGongsi().setShuiwudengji(
									resultstr.split("_")[2]);
						} else if (type.equals("zuzhidaima")) {
							user.getGongsi().setJigoudaima(
									resultstr.split("_")[2]);
						}
						user.getGongsi().update();
					}
					map.put(CODE, "1");
					map.put(STATE, "上传成功！");
					map.put("imgsrc", resultstr.split("_")[2]);
					response.getWriter().write(JsonUtils.obj2json(map));
				}
			}
		}
	}

	@RequestMapping(value = "/addGongsiXinxi", method = RequestMethod.POST)
	public @ResponseBody
	void addGongsiXinxi(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
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
		String provinceid = request.getParameter("provinceid");
		String cityid = request.getParameter("cityid");
		String areaid = request.getParameter("areaid");

		String gongsinama = request.getParameter("gongsinama");
		String jiancheng = request.getParameter("jiancheng");
		String miaoshu = request.getParameter("miaoshu");
		String dianhua = request.getParameter("dianhua");
		String chuanzhen = request.getParameter("chuanzhen");
		String lianxiren = request.getParameter("lianxiren");
		String lianxirendianhua = request.getParameter("lianxirendianhua");
		String dizhi = request.getParameter("dizhi");
		String yingyezhizhao = request.getParameter("yingyezhizhao");
		String shuiwudengji = request.getParameter("shuiwudengji");
		String zuzhidaima = request.getParameter("zuzhidaima");

		Gongsi gongsi = new Gongsi();
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

		List<Province> provincelist = commonDao
				.findByHql("from Province where provinceid='" + provinceid
						+ "'");
		gongsi.setProvince(provincelist.get(0));
		List<City> citylist = commonDao.findByHql("from City where cityid='"
				+ cityid + "'");
		gongsi.setCity(citylist.get(0));
		List<Area> arealist = commonDao.findByHql("from Area where areaid='"
				+ areaid + "'");
		gongsi.setArea(arealist.get(0));
		gongsi.setJingweidu("0");
		gongsi.setIslock(0);
		gongsi.save();
		user.setGongsi(gongsi);
		user.update();

		map.put(CODE, "1");
		map.put(STATE, "提交成功！");
		response.getWriter().write(JsonUtils.obj2json(map));

	}

	@RequestMapping(value = "/updateGongsiXinxi", method = RequestMethod.POST)//
	public @ResponseBody
	void updateGongsiXinxi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
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
		String provinceid = request.getParameter("provinceid");
		String cityid = request.getParameter("cityid");
		String areaid = request.getParameter("areaid");

		String jiancheng = request.getParameter("jiancheng");
		String miaoshu = request.getParameter("miaoshu");
		String dianhua = request.getParameter("dianhua");
		String chuanzhen = request.getParameter("chuanzhen");
		String lianxiren = request.getParameter("lianxiren");
		String lianxirendianhua = request.getParameter("lianxirendianhua");
		String dizhi = request.getParameter("dizhi");
		String yingyezhizhao = request.getParameter("yingyezhizhao");
		String shuiwudengji = request.getParameter("shuiwudengji");
		String zuzhidaima = request.getParameter("zuzhidaima");
		Gongsi gongsi = user.getGongsi();
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
		List<Province> provincelist = commonDao
				.findByHql("from Province where provinceid='" + provinceid
						+ "'");
		gongsi.setProvince(provincelist.get(0));
		List<City> citylist = commonDao.findByHql("from City where cityid='"
				+ cityid + "'");
		gongsi.setCity(citylist.get(0));
		List<Area> arealist = commonDao.findByHql("from Area where areaid='"
				+ areaid + "'");
		gongsi.setArea(arealist.get(0));
		gongsi.update();
		map.put(CODE, "1");
		map.put(STATE, "修改成功！");
		response.getWriter().write(JsonUtils.obj2json(map));

	}

	@RequestMapping(value = "/gotoWangpuZiliao", method = RequestMethod.POST)
	public @ResponseBody
	void gotoWangpuZiliao(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Map<String, Object> datamap = new LinkedHashMap<String, Object>();
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
		if (user.getGongsi() == null) {
			map.put(CODE, "0");
			map.put(STATE, "您还未添加公司！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Leimu> leimulist = commonDao
				.findByHql("from Leimu where parentId=0");
		JSONArray datajson = new JSONArray();
		for (Leimu leimu : leimulist) {
			JSONObject jsonnow = new JSONObject();
			jsonnow.put("areaid", leimu.getCategoryId());
			jsonnow.put("area", leimu.getName());
			datajson.add(jsonnow);
		}
		datamap.put("leimuinfo", datajson);
		List<Dianputype> typelist = commonDao.findByHql("from Dianputype");
		JSONArray datas = new JSONArray();
		for (Dianputype dianputype : typelist) {
			JSONObject jsonnow = new JSONObject();
			jsonnow.put("areaid", dianputype.getTypeid());
			jsonnow.put("area", dianputype.getTypename());
			datas.add(jsonnow);
		}
		datamap.put("dianputypeinfo", datas);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("info", datamap);
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/addWangpuZiliao", method = RequestMethod.POST)
	public @ResponseBody
	void addWangpuZiliao(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
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
		Gongsi gongsi = user.getGongsi();
		String dianputype = request.getParameter("dianputype");
		String dianpuleimu = request.getParameter("dianpuleimu");
		String dianpujieshao = request.getParameter("dianpujieshao");
		Dianputype dptype = null;
		if (StringUtils.isEmpty(dianputype) || StringUtils.isEmpty(dianpuleimu)
				|| StringUtils.isEmpty(dianpujieshao)) {
			map.put(CODE, "0");
			map.put(STATE, "输入的数据存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		} else {
			if (dianputype!=null && !dianputype.equals("")) {
				List<Dianputype> typelist = commonDao
						.findByHql("from Dianputype where typeid='"
								+ dianputype + "'");
				if (typelist != null && typelist.size() > 0) {
					dptype = typelist.get(0);
				}
			}
		}

		Dianpu dianpu = new Dianpu();
		dianpu.setAddtime(new Timestamp(new Date().getTime()));
		dianpu.setDianpujieshao(dianpujieshao);
		dianpu.setDianpuname(gongsi.getGongsinama());
		dianpu.setDianputype(dptype);
		dianpu.setGongsi(gongsi);
		dianpu.setIslock(0);
		dianpu.setUser(user);
		dianpu.save();

		String[] leimus = dianpuleimu.split(",");
		for (int i = 0; i < leimus.length; i++) {
			String leimui = leimus[i];
			List<Leimu> leimulisti = commonDao
					.findByHql("from Leimu where categoryId='" + leimui + "'");
			if (leimulisti != null && leimulisti.size() > 0) {
				Dianpuleimu dpleimui = new Dianpuleimu();
				dpleimui.setAddtime(new Timestamp(new Date().getTime()));
				dpleimui.setDianpu(dianpu);
				dpleimui.setLeimu(leimulisti.get(0));
				dpleimui.setUser(user);
				dpleimui.save();
			}
		}
		map.put(CODE, "1");
		map.put(STATE, "添加成功！");
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/updateWangpuZiliao", method = RequestMethod.POST)
	public @ResponseBody
	void updateWangpuZiliao(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		String dianpuleimu = request.getParameter("dianpuleimu");
		String dianpujieshao = request.getParameter("dianpujieshao");
		if (StringUtils.isEmpty(dianpuleimu)
				|| StringUtils.isEmpty(dianpujieshao)) {
			map.put(CODE, "0");
			map.put(STATE, "输入的数据存在空值！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
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
		List<Dianpu> dianpulist = commonDao
				.findByHql("from Dianpu where gongsi.gongsiid='"
						+ user.getGongsi().getGongsiid() + "'");
		Dianpu dianpu = dianpulist.get(0);

		dianpu.setDianpujieshao(dianpujieshao);
		dianpu.update();
		List<Dianpuleimu> leimulist = commonDao
				.findByHql("from Dianpuleimu where dianpu.dianpuid='"
						+ dianpu.getDianpuid() + "'");
		for (Dianpuleimu leimu : leimulist) {
			leimu.delete();
		}

		String[] leimus = dianpuleimu.split(",");
		for (int i = 0; i < leimus.length; i++) {
			String leimui = leimus[i];
			List<Leimu> leimulisti = commonDao
					.findByHql("from Leimu where categoryId='" + leimui + "'");
			if (leimulisti != null && leimulisti.size() > 0) {
				Dianpuleimu dpleimui = new Dianpuleimu();
				dpleimui.setAddtime(new Timestamp(new Date().getTime()));
				dpleimui.setDianpu(dianpu);
				dpleimui.setLeimu(leimulisti.get(0));
				dpleimui.setUser(user);
				dpleimui.save();
			}
		}
		map.put(CODE, "1");
		map.put(STATE, "修改成功！");
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/fabuDongtai", method = RequestMethod.POST)
	public @ResponseBody
	void fabuDongtai(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String keywords = request.getParameter("keywords");
		String miaoshu = request.getParameter("miaoshu");
		String center = request.getParameter("center");
		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(keywords)
				|| StringUtils.isEmpty(miaoshu) || StringUtils.isEmpty(center)
				|| StringUtils.isEmpty(userid)) {
			map.put(CODE, "0");
			map.put(STATE, "填写的数据存在空值！");
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

		if (user.getGongsi() == null) {
			map.put(CODE, "3");
			map.put(STATE, "您还未开通公司，不能发布动态!");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		Dianpu dianpu = getDianpuByGongsiId(user.getGongsi().getGongsiid());
		if (dianpu == null) {
			map.put(CODE, "4");
			map.put(STATE, "您还未开通店铺，不能发布动态!");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		Dianpunews news = new Dianpunews();
		news.setAddtime(new Timestamp(new Date().getTime()));
		news.setCenter(center);
		news.setDianpu(dianpu);
		news.setKeywords(keywords);
		news.setMiaoshu(miaoshu);
		news.setTitle(title);
		news.setXinwenstatic(1);
		news.setUser(user);
		news.save();
		map.put(CODE, "1");
		map.put(STATE, "发布成功!");
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/getGongsiDongtaiData", method = RequestMethod.POST)
	public @ResponseBody
	void getGongsiDongtaiData(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String userid = request.getParameter("userid");
		String page = request.getParameter("page");
		String typeid = request.getParameter("typeid");
		if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(typeid)) {
			map.put(CODE, "0");
			map.put(STATE, "数据存在空值！");
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
		if (typeid != null && !typeid.equals("")) {
			typeid = new String(typeid.getBytes("iso-8859-1"), "UTF-8");
		}
		String gongsidongtai = gongsiService.getGongsiDongtaiData(
				user.getUserid(), page, typeid);
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("gongsidongtai", gongsidongtai);
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/deleteGongsiDongtai", method = RequestMethod.POST)
	public @ResponseBody
	void deleteGongsiDongtai(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String newsid = request.getParameter("newsid");
		if (StringUtils.isEmpty(newsid)) {
			map.put(CODE, "0");
			map.put(STATE, "newsid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		List<Dianpunews> newslist = commonDao
				.findByHql("from Dianpunews where newsid='" + newsid + "'");
		if (newslist != null && newslist.size() > 0) {
			newslist.get(0).setXinwenstatic(2);
			newslist.get(0).update();
			map.put(CODE, "1");
			map.put(STATE, "删除成功！");
			response.getWriter().write(JsonUtils.obj2json(map));
		} else {
			map.put(CODE, "2");
			map.put(STATE, "查询结果不存在！");
			response.getWriter().write(JsonUtils.obj2json(map));
		}
	}

	public Dianpu getDianpuByGongsiId(String gongsiId) {
		List<Dianpu> dianpulist = commonDao
				.findByHql("from Dianpu where gongsi.gongsiid='" + gongsiId
						+ "'");
		if (dianpulist != null && dianpulist.size() > 0) {
			return dianpulist.get(0);
		} else {
			return null;
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
