package com.nongzi.until.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nongzi.dao.CommonDAO;

@Controller
@RequestMapping("/diquUtil")
public class LeimuUtil {

	@Autowired
	private CommonDAO commonDao;
	
	
}
