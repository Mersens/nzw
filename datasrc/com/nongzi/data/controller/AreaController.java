package com.nongzi.data.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongzi.dao.CommonDAO;
import com.nongzi.data.utils.JsonUtils;
import com.nongzi.vo.Area;
import com.nongzi.vo.City;
import com.nongzi.vo.Province;

@Controller
@RequestMapping("/area")
public class AreaController {
	public static final String CODE = "code";
	public static final String STATE = "state";

	@Autowired
	private CommonDAO commonDao;


	@RequestMapping(value = "/getProvince", method = RequestMethod.POST)
	public @ResponseBody
	void getProvince(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<Province> provinceList = commonDao.findByHql("from Province where provinceid!='0'");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (provinceList == null || provinceList.size() == 0) {
			map.put(CODE, "0");
			map.put(STATE, "查询结果为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		}
		JSONArray datajson = new JSONArray();
		for (Province pro : provinceList) {
			JSONObject jsonnow = new JSONObject();
			jsonnow.put("provinceid", pro.getProvinceid());
			jsonnow.put("province", pro.getProvince());
			datajson.add(jsonnow);
		}
		map.put(CODE, "1");
		map.put(STATE, "查询成功！");
		map.put("info", datajson);
		response.getWriter().write(JsonUtils.obj2json(map));
	}

	@RequestMapping(value = "/getCityByProvinceId", method = RequestMethod.POST)
	public @ResponseBody
	void getCityByProvinceId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String provinceid = request.getParameter("provinceid");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (provinceid == null || "".equals(provinceid)) {
			map.put(CODE, "0");
			map.put(STATE, "输入的provinceid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		} else {
			List<City> citylist = commonDao.findByHql("from City where province.provinceid='"+ provinceid + "' ");
			if (citylist == null || citylist.size() == 0) {
				map.put(CODE, "2");
				map.put(STATE, "查询结果不存在！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			}
			JSONArray datajson = new JSONArray();
			for (City city : citylist) {
				JSONObject jsonnow = new JSONObject();
				jsonnow.put("cityid", city.getCityid());
				jsonnow.put("cityname", city.getCityname());
				datajson.add(jsonnow);
			}
			map.put(CODE, "1");
			map.put(STATE, "查询成功！");
			map.put("info", datajson);
			response.getWriter().write(JsonUtils.obj2json(map));
		}
	}

	@RequestMapping(value = "/getAreaByCityId", method = RequestMethod.POST)
	public @ResponseBody
	void getAreaByCityId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cityid = request.getParameter("cityid");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (cityid == null || "".equals(cityid)) {
			map.put(CODE, "0");
			map.put(STATE, "输入的cityid为空！");
			response.getWriter().write(JsonUtils.obj2json(map));
			return;
		} else {
			List<Area> arealist = commonDao.findByHql("from Area where city.cityid='" + cityid + "'");
			if (arealist == null || arealist.size() == 0) {
				map.put(CODE, "2");
				map.put(STATE, "查询结果不存在！");
				response.getWriter().write(JsonUtils.obj2json(map));
				return;
			}
			JSONArray datajson = new JSONArray();
			for (Area area : arealist) {
				JSONObject jsonnow = new JSONObject();
				jsonnow.put("areaid", area.getAreaid());
				jsonnow.put("area", area.getArea());
				datajson.add(jsonnow);
			}
			map.put(CODE, "1");
			map.put(STATE, "查询成功！");
			map.put("info", datajson);
			response.getWriter().write(JsonUtils.obj2json(map));
		}
	}
}
