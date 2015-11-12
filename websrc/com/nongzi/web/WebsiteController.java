package com.nongzi.web;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nongzi.Datas.DatasManager.ChanpinDatas;
import com.nongzi.Datas.DatasManager.DianpuDatas;
import com.nongzi.dao.CommonDAO;
import com.nongzi.util.ScriptHelper;
import com.nongzi.vo.Chanpin;
import com.nongzi.vo.Chanpinorleimu;
import com.nongzi.vo.Dianpuleimu;
import com.nongzi.vo.Leimu;

/**
 * 网站首页
 * @author 朱庆杰
 *
 */
@Controller
@RequestMapping("/website")
public class WebsiteController  {
	//新建工具对象
	ScriptHelper sh = new ScriptHelper();
	//新建日子打印对象
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CommonDAO commonDao;
	
	/*** 说明: 获取网页的通用部分 */
	@RequestMapping(value = "/gotoCommon",method = RequestMethod.GET)
	public String gotoCommon(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 return "wwwindex/common";
	}
	
	@RequestMapping(value="/gotoWangzhanDaohang",method=RequestMethod.GET)
	public String gotoWangzhanDaohang(HttpServletRequest request,HttpServletResponse response){
		return "daohangcommon/wangzhandaohang";
	}
	
	@RequestMapping(value="/gotoShangpinFenlei",method=RequestMethod.GET)
	public String gotoShangpinFenlei(HttpServletRequest request,HttpServletResponse response){
		
		return "daohangcommon/shangpinfenlei";
	}
	
	
	/**
	 * 
	 * 说明: 获取首页的top部分
	 * 时间：2015-1-8
	 * 作者：管东升
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/gotoindex",method = RequestMethod.GET)
	public String gotoindex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//判断时间减少数据库查询
		UpdataStatic();
		//商品分类
		request.setAttribute("fIdList",DianpuDatas.fIdList);
		request.setAttribute("cheList",DianpuDatas.cheList);
		//热门推荐店铺信息
		request.setAttribute("newdianpu",DianpuDatas.dpList);
		//搜索8条最热品牌信息
		String pinpaisql = "select pp FROM Chanpinpinpai pp , Chanpin cp  where   pp.pinpaiid=cp.chanpinpinpai.pinpaiid GROUP BY cp.chanpinpinpai.pinpaiid ORDER BY COUNT(cp.chanpinid) DESC ";
		List<Chanpin> pinpailist = commonDao.findByHql(pinpaisql);
		request.setAttribute("tuijianpinpailist",pinpailist);
		//肥料企业
		request.setAttribute("List1", DianpuDatas.flqyList);
		//农药企业
		request.setAttribute("List2",DianpuDatas.nyqyList );
		//种子企业
		request.setAttribute("List3",DianpuDatas.zzqyList );
		//农机企业
		request.setAttribute("List4",DianpuDatas.njqyList );
		//农膜企业
		request.setAttribute("List5",DianpuDatas.nmqyList );
		request.setAttribute("tuijianleimuList",DianpuDatas.tuijianleimuList );
		
		request.setAttribute("flcpList", ChanpinDatas.flcpList);
		request.setAttribute("nycpList", ChanpinDatas.nycpList);
		request.setAttribute("zzcpList", ChanpinDatas.zzcpList);
		request.setAttribute("njcpList", ChanpinDatas.njcpList);
		request.setAttribute("nmcpList", ChanpinDatas.nmcpList);
		//行业新闻
		request.setAttribute("hangyenews", commonDao.findByHqlAsCount("from Newstable where newstatic='1' and newtype.newtypeid='hyxw' order by addtime desc",4));
		//产品价格
		request.setAttribute("jiagenews", commonDao.findByHqlAsCount("from Newstable where newstatic='1' and newtype.typefid='hfjg' order by addtime desc",4));
		//农资知识
		request.setAttribute("zhishinews", commonDao.findByHqlAsCount("from Newstable where newstatic='1' and newtype.type='zhishi' order by addtime desc",4));
		//政策法规
		request.setAttribute("faguinews", commonDao.findByHqlAsCount("from Newstable where newstatic='1' and newtype.newtypeid='zcfg' order by addtime desc",4));
		//农商学院
		request.setAttribute("xueyuannews", commonDao.findByHqlAsCount("from Newstable where newstatic='1' and newtype.typefid='nsxy' order by addtime desc",5));
		//热门专题
		request.setAttribute("zhuantinews", commonDao.findByHqlAsCount("from NewstableZhuanti where status=1 order by addtime desc",5));
		return "wwwindex/index";
	}
	
	
	/**
	 * 跳转到项目的Head页面
	 * @param request
	 * @param response
	 * @return 返回的JSP页面
	 */
	@RequestMapping(value = "/gotoHead",method = RequestMethod.GET)
	public String gotoHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Leimu> leimulist = commonDao.findByProperty("Leimu", "parentId", "0");
		request.setAttribute("leimulist", leimulist);
		List<Leimu> llist = commonDao.findByProperty("Leimu", "isshow", 1);
		request.setAttribute("hlimulist", llist);
    	 return "wwwindex/head";
	}
	
	@RequestMapping(value="/gotoFoot",method=RequestMethod.GET)
	public String gotoFoot(HttpServletRequest request,HttpServletResponse response){
		
		return "wwwindex/foot";
	}
	
	public void UpdataStatic(){
		if(DianpuDatas.QykzsTime==null || new Date().getTime()-DianpuDatas.QykzsTime.getTime()>30*60*1000){
			DianpuDatas.QykzsTime=new Date();
			DianpuDatas.fIdList = commonDao.findByHql("from Leimu where parentId=0");
			DianpuDatas.cheList = commonDao.findByHql("from Leimu where parentId!=0");
			DianpuDatas.dpList = commonDao.findByHqlAsCount("from Dianpu where islock=0 order by addtime desc  ", 6);
			DianpuDatas.diqulist =  commonDao.findByHqlAsCount("from City", 11);
			DianpuDatas.qiyecount =  commonDao.findBySqlSize("select count(gongsiid) from gongsi where islock=0 ");
			DianpuDatas.flqyList=getDianpuByLeimu("1",12);
			DianpuDatas.nyqyList=getDianpuByLeimu("2",12);
			DianpuDatas.zzqyList=getDianpuByLeimu("3",12);
			DianpuDatas.njqyList=getDianpuByLeimu("4",12);
			DianpuDatas.nmqyList=getDianpuByLeimu("5",12);
			DianpuDatas.leimuList=commonDao.findByHql("from Dianpuleimu");
			DianpuDatas.tuijianleimuList = commonDao.findByHql("from Leimu where parentId!=0 and isshow=1");
		}
		
		if(ChanpinDatas.CpcxTime==null || new Date().getTime()-ChanpinDatas.CpcxTime.getTime()>30*60*1000){
			ChanpinDatas.flcpList=getChanpinByLeimu("1", 9);
			ChanpinDatas.nycpList=getChanpinByLeimu("2", 9);
			ChanpinDatas.zzcpList=getChanpinByLeimu("3", 9);
			ChanpinDatas.njcpList=getChanpinByLeimu("4", 9);
			ChanpinDatas.nmcpList=getChanpinByLeimu("5", 9);
		}
		
	}
	/**
	 * 查询是否存在某种类型的店铺 并返回相应条数的店铺
	 *
	 */
	public  List<Dianpuleimu> getDianpuByLeimu(String  leimuId,int nums){
		return commonDao.findByHqlAsCount("from Dianpuleimu where leimu.categoryId='"+leimuId+"' and dianpu.islock=0 order by addtime desc",nums);
	}
	
	public List<Chanpinorleimu> getChanpinByLeimu(String leimuid,int nums){
		return commonDao.findByHqlAsCount("from Chanpinorleimu where leimu.parentId='"+leimuid+"' and chanpin.xinxiststic=1 order by addtime desc", nums);
	}
	
	@RequestMapping(value="/gotoYuming",method=RequestMethod.GET)
	public String gotoYuming(HttpServletRequest request,HttpServletResponse response){
		
		return "company/wangpuyuming2";
	}
	
	
}