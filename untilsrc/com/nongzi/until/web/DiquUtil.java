package com.nongzi.until.web;

import java.io.IOException;
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
import com.nongzi.vo.Area;
import com.nongzi.vo.City;
import com.nongzi.vo.Province;

@Controller
@RequestMapping("/diquUtil")
public class DiquUtil {

	@Autowired
	private CommonDAO commonDao;
	
	@RequestMapping(value="/getProvinceData",method=RequestMethod.POST)
	public String getProvinceData(HttpServletRequest request,HttpServletResponse response)throws IOException{
		List<Province> procenter = commonDao.findByHql("from Province where provinceid!=0");
		JSONArray datajson = new JSONArray();
		for (Province pro :  procenter) {
			 	JSONObject jsonnow = new JSONObject();
				jsonnow.put("provinceid", pro.getProvinceid());
				jsonnow.put("province",pro.getProvince());
				datajson.add(jsonnow);
			 }
		response.getWriter().print(datajson.toString());
		return null;
	}
	
	
	@RequestMapping(value = "/getCityByProvinceId",method = RequestMethod.POST)
	public String getCityByProvinceId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String provinceid=request.getParameter("id");
		System.out.println(provinceid+"============pid");
		List<City> citylist = commonDao.findByHql("from City where province.provinceid='"+provinceid+"' ");
		 JSONArray datajson = new JSONArray();
		 for (City city : citylist) {
			 JSONObject jsonnow = new JSONObject();
			 jsonnow.put("cityid", city.getCityid());
			 jsonnow.put("cityname",city.getCityname());
			 datajson.add(jsonnow);
		  }
		 
		response.getWriter().print(datajson.toString());
		return null;
	}
	
	@RequestMapping(value="/getAreaByCityId",method=RequestMethod.POST)
	public String getAreaByCityId(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String cityid=request.getParameter("id");
		List<Area> arealist=commonDao.findByHql("from Area where city.cityid='"+cityid+"'");
		JSONArray datajson = new JSONArray();
		for (Area area : arealist) {
			JSONObject jsonnow = new JSONObject();
			 jsonnow.put("areaid", area.getAreaid());
			 jsonnow.put("area",area.getArea());
			 datajson.add(jsonnow);
		}
		response.getWriter().print(datajson.toString());
		return null;
	}
	
	
}
