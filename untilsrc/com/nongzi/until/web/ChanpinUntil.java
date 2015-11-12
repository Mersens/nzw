package com.nongzi.until.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.dao.CommonDAO;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Chanpin;
import com.nongzi.vo.Chanpinimg;
import com.nongzi.vo.Dianpuleimu;

public class ChanpinUntil {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao=new CommonDAO();
	
	public List getChanpinImgByChanpinId(String chanpinid){
		List myList = new ArrayList();
		List<Chanpinimg> chanpinimglist = commonDao.findByHql("from Chanpinimg where chanpin.chanpinid='"+chanpinid+"' order by orderval");
		if(chanpinimglist!=null && chanpinimglist.size()>0){
			for(Chanpinimg cptu : chanpinimglist){
				myList.add(cptu.getImgsrc());
			}
		}else{
			//添加默认图片
			myList.add("/resources/userfile/chanpinimg/RiCimg.jpg");
		}
		return myList;
	}
	
	public List<Chanpin> getChanpinByDianpuId(String dianpuid , int nums){
		return commonDao.findPageByHql(1, nums,"from Chanpin where dianpu.dianpuid='"+dianpuid+"' ");
	}
	
	public List<Dianpuleimu> getDianpuleimuByDianpuId(String dianpuid ){
		return commonDao.findByHql("from Dianpuleimu where dianpu.dianpuid='"+dianpuid+"' ");
	}
}