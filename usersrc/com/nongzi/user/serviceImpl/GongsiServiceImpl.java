package com.nongzi.user.serviceImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IGongsiService;
import com.nongzi.util.Fenci;
import com.nongzi.util.Paginator;
import com.nongzi.vo.Dianpunews;
import com.nongzi.vo.Gongsi;

public class GongsiServiceImpl implements IGongsiService{

	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private Fenci fenci;
	@Override
	public String getGongsiDongtaiData(String userid, String page,String keywords)throws IOException {
		if(page==null || page.equals("")){
			page="1";
		}
		String hql="";
		String sql="";
		String key="";
		if(keywords!=null && !keywords.equals("")){
			key=fenci.fenciText(keywords, false);
			if(key!=null && !key.equals("")){
				String[] keys=key.split(",");
				for(int i=0;i<keys.length;i++){
					if(i==0){
						hql+="and (title like '%"+keys[i]+"%' ";
						sql+="and (title like '%"+keys[i]+"%'";
					}else{
						hql+="or title like '%"+keys[i]+"%' ";
						sql+="or title like '%"+keys[i]+"%'";
					}
				}
				
				hql+=")";
				sql+=")";
			}
		}
		List<Dianpunews> newslist=commonDao.findPageByHql(Integer.parseInt(page), 8, "from Dianpunews where user.userid='"+userid+"' and xinwenstatic=1 "+hql+" order by addtime desc");
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\" class=\"mj_tab\"> ");
		sb.append("<thead><tr>");
		sb.append("<th width=\"286\">标题</th>");
		sb.append("<th width=\"240\">店铺名称</th>");
		sb.append("<th width=\"260\">发布时间</th>");
		sb.append("<th width=\"180\">操作</th>");
		sb.append("</tr></thead>");
		sb.append("<tbody>");
       for (Dianpunews news : newslist) {
    	   sb.append("<tr>");
    	   sb.append("<td>"+news.getTitle()+"</td>");
    	   sb.append("<td>"+news.getDianpu().getDianpuname()+"</td>");
    	   sb.append("<td>"+fmt.format(news.getAddtime())+"</td>");
    	   sb.append("<td><a style=\"cursor:pointer;\" onclick=\"deleteDongtai('"+news.getNewsid()+"')\" >删除</a> </td>");
    	   sb.append("</tr>");
		}
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<div style=\"float:right;margin-right:10px;\"></div>");
		System.out.println("select count(newsid) from Dianpunews where userid='"+userid+"' and xinwenstatic=1 "+sql+""+"-----------");
		
		int totalcount=commonDao.findBySqlSize("select count(newsid) from Dianpunews where userid='"+userid+"' and xinwenstatic=1 "+sql+"");
		Paginator paginator = new Paginator(Integer.parseInt(page), 8, totalcount);	
		String strPage = paginator.toHtmlAjaxPage("dongtaidiv", null,keywords, null, null, "/gongsi/getGongsiDongtaiData");
		sb.append(strPage);
		System.out.println(sb.toString()+"-------------");
		return sb.toString();
	}
	@Override
	public Gongsi addGongsiXinxi(Gongsi gongsi) {
		Gongsi gs=new Gongsi();
		gs.setAddtime(new Timestamp(new Date().getTime()));
		gs.setArea(gongsi.getArea());
		gs.setChuanzhen(gongsi.getChuanzhen());
		gs.setCity(gongsi.getCity());
		gs.setDianhua(gongsi.getDianhua());
		gs.setDizhi(gongsi.getDizhi());
		gs.setGongsinama(gongsi.getGongsinama());
		gs.setIslock(0);
		gs.setJiancheng(gongsi.getJiancheng());
		gs.setJigoudaima(gongsi.getJigoudaima());
		gs.setLianxiren(gongsi.getLianxiren());
		gs.setLianxirendianhua(gongsi.getLianxirendianhua());
		gs.setMiaoshu(gongsi.getMiaoshu());
		gs.setProvince(gongsi.getProvince());
		gs.setShuiwudengji(gongsi.getShuiwudengji());
		gs.setYingyezhizhao(gongsi.getYingyezhizhao());
		gs.save();
		return gs;
	}
	@Override
	public Gongsi updateGongsiXinxi(Gongsi gongsi) {
		List<Gongsi> gongsilist=commonDao.findByHql("from Gongsi where gongsiid='"+gongsi.getGongsiid()+"'");
		Gongsi gs=null;
		if(gongsilist!=null && gongsilist.size()>0){
			gs=gongsilist.get(0);
			gs.setArea(gongsi.getArea());
			gs.setChuanzhen(gongsi.getChuanzhen());
			gs.setCity(gongsi.getCity());
			gs.setDianhua(gongsi.getDianhua());
			gs.setDizhi(gongsi.getDizhi());
			gs.setIslock(0);
			gs.setJiancheng(gongsi.getJiancheng());
			gs.setJigoudaima(gongsi.getJigoudaima());
			gs.setLianxiren(gongsi.getLianxiren());
			gs.setLianxirendianhua(gongsi.getLianxirendianhua());
			gs.setMiaoshu(gongsi.getMiaoshu());
			gs.setProvince(gongsi.getProvince());
			gs.setShuiwudengji(gongsi.getShuiwudengji());
			gs.setYingyezhizhao(gongsi.getYingyezhizhao());
			gs.update();
			return gs;
		}
		return null;
	}

}
