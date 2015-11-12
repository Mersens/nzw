package com.nongzi.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.dao.CommonDAO;
import com.nongzi.user.iservice.IMyMessageService;
import com.nongzi.util.Paginator;
import com.nongzi.vo.Sysmessage;

public class MyMessageServiceImpl implements IMyMessageService{

	@Autowired
	private CommonDAO commonDao;
	
	@Override
	public String getMyMessageData(String userid, String page, String typeid) {
		if(page==null || page.equals("")){
			page="1";
		}
		String hql="";
		String sql="";
		
		if(typeid!=null && !typeid.equals("") && !typeid.equals("0")){
			hql+=" and typeid="+Integer.parseInt(typeid)+"";
			sql+=" and typeid="+Integer.parseInt(typeid)+"";
		}
		List<Sysmessage> msglist=commonDao.findPageByHql(Integer.parseInt(page), 8, "from Sysmessage where userByUserid.userid='"+userid+"' and msgstatic!=2  "+hql+"  order by addtime desc");
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb=new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\"  class=\"mj_tab\" ");
		sb.append("<thead><tr>");
		sb.append("<th width=\"100\">序号</th>");
		sb.append("<th width=\"100\">来源</th>");
		sb.append("<th width=\"370\">内容</th>");
		sb.append("<th width=\"180\">时间</th>");
		sb.append("<th width=\"120\">操作</th>");
//		sb.append("<th width=\"120\">状态</th>");
		sb.append("</tr></thead>");
		sb.append("<tbody>");
		int i=1;
        for (Sysmessage smg : msglist) {
        	sb.append("<tr>");
        	sb.append("<td>"+(i++)+"</td>");
        	sb.append("<td>"+smg.getUserByFormuserid().getUsername()+"</td>");
        	sb.append("<td>"+smg.getMsgcenter()+"</td>");
        	sb.append("<td>"+fmt.format(smg.getAddtime())+"</td>");
//        	if(smg.getMsgstatic()==0){
//        		sb.append("<td>未读</td>");
//        	}else if(smg.getMsgstatic()==1){
//        		sb.append("<td>已读</td>");
//        	}
        	sb.append("<td><a style=\"cursor:pointer\" onclick=\"delmsg("+smg.getMessageid()+","+page+")\" >删除</a></td>");
        	sb.append("</tr>");
		}
        sb.append("</tbody>");
        
        sb.append("</table>");
		sb.append("<div style=\"float:right;margin-right:10px;\"></div>");
		
		int totalcount=commonDao.findBySqlSize("select count(messageid) from sysmessage where userid='"+userid+"' and msgstatic!=2  "+sql+" ");
		Paginator paginator = new Paginator(Integer.parseInt(page), 8, totalcount);	
		String strPage = paginator.toHtmlAjaxPage("msgdiv", null,typeid, null, null, "/userCenter/getMyMessageData");
		sb.append(strPage);
		
		return sb.toString();
		
	}

}
