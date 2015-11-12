package com.nongzi.user.serviceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IChanpinService;
import com.nongzi.util.Paginator;
import com.nongzi.vo.Chanpin;

public class ChanpinServiceImpl implements IChanpinService{
	@Autowired
	private CommonDAO commonDao;
	
    
   
	@Override
	public String getChanpinData(String userid, String page, String status)
			throws IOException {
		if(page==null || page.equals("")){
			page="1";
		}
		if(status==null || status.equals("")){
			status="1";
		}
		System.out.println("from Chanpin where user.userid='"+userid+"' and xinxiststic=0");
		List<Chanpin> chanpinlist=commonDao.findPageByHql(Integer.parseInt(page), 10, "from Chanpin where user.userid='"+userid+"' and xinxiststic= "+status+"");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
//        sb.append(" <div class=\"ding_tit\"> ");
//        sb.append(" <span class=\"pin\" style=\"float:left;width:350px;\">产品信息</span> ");
//        sb.append(" <span class=\"jine\" style=\"float:left;width:200px;\">发布时间</span> ");
//        sb.append(" <span class=\"zjine\" style=\"float:left;width:150px;\">操作</span> ");
//        sb.append(" <span class=\"zht\" style=\"float:left;width:150px;\">商机</span> ");
//        sb.append("<div class=\"clear\"></div></div>");
        
        
		sb.append("<table class=\"dd_tab\"><tbody>");
		int i=0;
        for (Chanpin chanpin : chanpinlist) {
        	i++;
			sb.append("<tr class=\"ddxx_l\"> ");
			sb.append("<td class=\"dwidth_2\"><input name=\"chanpin\" type=\"checkbox\" id=\""+chanpin.getChanpinid()+"\" value=\""+chanpin.getChanpinid()+"\"><a href=\"#\">"+chanpin.getTitle()+"</a></td>");
			sb.append("<td class=\"dwidth_3\" style=\"text-align:center;\">"+sdf.format(chanpin.getAddtime())+"</td>");
			if(chanpin.getXinxiststic()==1){
				sb.append(" <td class=\"dwidth_4\" style=\" text-align:center;\"><p><a class=\"Caozuo_a2\" style=\"margin-left:36px;\" href=\"#\"  onclick=\"deleteAll()\">删除</a><a class=\"Caozuo_a2\" style=\"cursor:pointer;\" onclick=\"xiajia('"+chanpin.getChanpinid()+"','"+page+"')\" >下架</a></p></td>");
			}else if(chanpin.getXinxiststic()==2){
				sb.append(" <td class=\"dwidth_4\" style=\" text-align:center;\"><p><a class=\"Caozuo_a2\" style=\"margin-left:36px;\" style=\"cursor:pointer;\"  onclick=\"deleteAll()\">删除</a></p></td>");
			}else if(chanpin.getXinxiststic()==3){
				sb.append(" <td class=\"dwidth_4\" style=\" text-align:center;\"><p><a class=\"Caozuo_a2\" style=\"margin-left:36px;\" style=\"cursor:pointer;\" onclick=\"shangjia('"+chanpin.getChanpinid()+"',"+page+")\" >上架</a><a class=\"Caozuo_a2\" style=\"cursor:pointer;\" onclick=\"deleteAll()\">删除</a></p></td>");
			}else if(chanpin.getXinxiststic()==0){
				sb.append(" <td class=\"dwidth_4\" style=\" text-align:center;\"><p><a class=\"Caozuo_a2\" style=\"margin-left:36px;\" style=\"cursor:pointer;\" onclick=\"deleteAll()\">删除</a></p></td>");
			}
			
			
			sb.append("</tr>");
			
		}
		sb.append("</tbody></table>");
		int totalcount=commonDao.findBySqlSize("select count(chanpinid) from Chanpin where userid='"+userid+"' and xinxiststic= "+status+"");
		Paginator paginator = new Paginator(Integer.parseInt(page), 10, totalcount);	
		String strPage = paginator.toHtmlAjaxPage("chanpindata", null,status, null, null, "/sellerCenter/getChanpinData");
		sb.append(strPage);
		System.out.println(sb.toString()+"---------");
		
		return sb.toString();
	}

}
