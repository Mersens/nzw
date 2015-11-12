package com.nongzi.Datas;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nongzi.dao.CommonDAO;
import com.nongzi.vo.Chanpinorleimu;
import com.nongzi.vo.Chanpinoryongtu;
import com.nongzi.vo.City;
import com.nongzi.vo.Dianpu;
import com.nongzi.vo.Dianpuleimu;
import com.nongzi.vo.Gongsi;
import com.nongzi.vo.Leimu;
import com.nongzi.vo.Province;


public class DatasManager {
	public  static  class DianpuDatas{
	public static final long serialVersionUID = 1L;
	/**
	 * 企业库首页  招商加盟页
	 */
	public static Date  QykzsTime = null;
	public static List<Leimu>  leimuList = null;
	public static List<Leimu>  tuijianleimuList = null;
	public static List<Leimu>  fIdList = null;
	public static List<Leimu>  cheList = null;
	public static List<Dianpu>  dpList = null;
	public static List<City>  diqulist = null;
	public static int  qiyecount = 0;
	public static List<Dianpuleimu>  flqyList = null;
	public static List<Dianpuleimu>  nyqyList = null;
	public static List<Dianpuleimu>  zzqyList = null;
	public static List<Dianpuleimu>  njqyList = null;
	public static List<Dianpuleimu>  nmqyList = null;
	public static List<Province> ProvinceList = null;
	public static Map userMapList  = new HashMap();
	
	}
	
	public static class ChanpinDatas{
		public static Date CpcxTime=null;
		public static List<Chanpinorleimu> flcpList=null;
		public static List<Chanpinorleimu> nycpList=null;
		public static List<Chanpinorleimu> zzcpList=null;
		public static List<Chanpinorleimu> njcpList=null;
		public static List<Chanpinorleimu> nmcpList=null;
	}
	
	public static String getChanpinYongtuById(String chanpinid){
		CommonDAO commonDao=new CommonDAO();
		List<Chanpinoryongtu> yongtulist=commonDao.findByHql("from Chanpinoryongtu where chanpin.chanpinid='"+chanpinid+"' and chanpin.xinxiststic=1 ");
		if(yongtulist!=null && yongtulist.size()>0){
			return yongtulist.get(0).getChanpinyongtu().getYongtuname();
		}
		return "";
	}
}
