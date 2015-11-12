package com.nongzi.user.serviceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IXunjiaService;
import com.nongzi.util.Fenci;
import com.nongzi.util.Paginator;
import com.nongzi.vo.Dianpunews;
import com.nongzi.vo.Zaixianyijia;

public class XunjiaServiceImpl implements IXunjiaService{

	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private Fenci fenci;
	
	@Override
	public String getXunjiaData(String dianpuid, String page,String status,String title,String startDate,String endDate)throws IOException {
		if(page==null || page.equals("")){
			page="1";
		}
		String hql="";
		String sql="";
		String key="";
		if(status!=null && !status.equals("") && !status.equals("2")){
			hql+=" and xinxistatic="+Integer.parseInt(status);
			sql+=" and xinxistatic="+Integer.parseInt(status);
		}
		
		if(title!=null && !title.equals("")){
			key=fenci.fenciText(title, false);
			if(key!=null && !key.equals("")){
				String[] keys=key.split(",");
				for(int i=0;i<keys.length;i++){
					if(i==0){
						hql+=" and (mingcheng like '%"+keys[i]+"%' ";
						sql+=" and (mingcheng like '%"+keys[i]+"%'";
					}else{
						hql+=" or (mingcheng like '%"+keys[i]+"%' ";
						sql+=" or (mingcheng like '%"+keys[i]+"%'";
					}
				}
			}
			hql+=")";
			sql+=")";
		}
		if(startDate!=null && !startDate.equals("") && endDate!=null && !endDate.equals("")){
			hql+=" and addtime between '"+startDate+"' and '"+endDate+"'";
			sql+=" and addtime between '"+startDate+"' and '"+endDate+"'";
		}
		List<Zaixianyijia> xunjialist=commonDao.findPageByHql(Integer.parseInt(page), 8, "from Zaixianyijia where dianpu.dianpuid='"+dianpuid+"' "+hql+" order by addtime desc");
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\" class=\"cgd_tab\"> ");
		sb.append("<tbody><tr>");
		sb.append("<th width=\"200\">询价名称</th>");
		sb.append("<th width=\"50\">数量</th>");
		sb.append("<th width=\"100\">联系人</th>");
		sb.append("<th width=\"100\">联系电话</th>");
		sb.append("<th width=\"100\">询价时间</th>");
		sb.append("<th width=\"80\">状态</th>");
		sb.append("</tr>");
		int i=0;
        for (Zaixianyijia xunjia : xunjialist) {
			i++;
    	   sb.append("<tr>");
    	   sb.append("<td><a style=\"cursor:pointer\" onclick=\"chakan('"+xunjia.getXunjiaid()+"')\"  data-reveal-id=\"myModal"+i+"\"> "+xunjia.getMingcheng()+"</a>");
    	   sb.append(" <div id=\"myModal"+i+"\" class=\"reveal-modal3\">");
    	   sb.append(" <div class=\"reveal-modal-title\">");
    	   sb.append(" <span class=\"Spwidth\">询价单内容</span>");
    	   sb.append("  <a class=\"close-reveal-modal\"></a>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">询价名称：</span>");
    	   sb.append(" <span>"+xunjia.getMingcheng()+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">询价数量：</span>");
    	   sb.append(" <span>"+xunjia.getShuliang()+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">询价内容：</span>");
    	   sb.append(" <span>"+xunjia.getMsgcenter()+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">联系人：</span>");
    	   sb.append(" <span>"+xunjia.getLianxiren()+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">联系电话：</span>");
    	   sb.append(" <span>"+xunjia.getDianhua()+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>");
    	   sb.append(" <div class=\"reveal-con\">");
    	   sb.append(" <span class=\"Spwidth\">询价时间：</span>");
    	   sb.append(" <span>"+fmt.format(xunjia.getAddtime())+"</span>");
    	   sb.append("<div class=\"clear\"> </div>");
    	   sb.append(" </div>"); 	   
    	   sb.append(" </div>");
    	   sb.append("</td>");
    	   sb.append("<td>"+xunjia.getShuliang()+"</td>");
    	   sb.append("<td>"+xunjia.getLianxiren()+"</td>");
    	   sb.append("<td>"+xunjia.getDianhua()+"</td>");
    	   sb.append("<td>"+fmt.format(xunjia.getAddtime())+"</td>");
    	   if(xunjia.getXinxistatic()==0){
    		   sb.append("<td id=\"wd"+xunjia.getXunjiaid()+"\">未读</td>");
    		   sb.append("<td style=\"display:none\" id=\"yd"+xunjia.getXunjiaid()+"\"><div >已读</div></td>");
    	   }else if(xunjia.getXinxistatic()==1){
    		   sb.append("<td>已读</td>");
    	   }
    	   sb.append("</tr>");
		}
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<div style=\"float:right;margin-right:10px;\"></div>");
		System.out.println(sb.toString());
		int totalcount=commonDao.findBySqlSize("select count(xunjiaid) from Zaixianyijia where dianpuid='"+dianpuid+"' "+sql+"");
		Paginator paginator = new Paginator(Integer.parseInt(page), 8, totalcount);	
		String strPage = paginator.toHtmlAjaxPage("xjdata", status,title, null, null, "/xunjia/getXunjiaData");
		sb.append(strPage);
		
		return sb.toString();
	}
}
