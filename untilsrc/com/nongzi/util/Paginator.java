package com.nongzi.util;


public class Paginator {
	// 当前页
	private int currPage = 1;
	// 总页数
	private int totalPage = 0;
	// 总记录数
	private int totalCount = 0;
	// 每页多少个
	private int pageSize = 0;

	
	//计数器
	private int addnum = 0;
	private int minusnum = 0;
	public Paginator() {
	}

	public Paginator(int currPage, int pageSize, int totalCount) {
		this.currPage = currPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.countPage();
		// 做安全检查 当前页是不能大于总页数的 如果大于 做自动处理
		if (this.currPage > this.totalPage)
			this.currPage = this.totalPage;
		// 做安全检查 当前页最小就是1不能在也1小了 做自动处理
		if (this.currPage < 1)
			this.currPage = 1;
	}

	private void countPage() {
		if (this.totalCount % this.pageSize == 0) {
			this.totalPage = this.totalCount / this.pageSize;
		} else {
			this.totalPage = this.totalCount / this.pageSize + 1;
		}
	}

	/**
	 * 看是否可以向前翻页
	 * 
	 * @param void
	 * @return boolean
	 */
	public boolean has_previous() {
		if (this.currPage <= 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 看是否可以向后翻页
	 * 
	 * @param void
	 * @return boolean
	 */
	public boolean has_next() {
		if (this.currPage != this.totalPage && this.totalPage != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 上一页的页数
	 * 
	 * @param void
	 * @return int
	 */
	public int previous_page_number() {
		if (this.currPage > 1)
			return this.currPage - 1;
		else
			return 1;
	}

	/**
	 * 下一页的页数
	 * 
	 * @param void
	 * @return int
	 */
	public int next_page_number() {
		if (this.currPage < this.totalPage)
			return this.currPage + 1;
		else
			return this.totalPage;
	}

	
	/**
	 * 
	 * 说明:用于目录性质的翻页 
	 * 时间：2015-1-15
	 * 作者：朱庆杰
	 * @param url
	 * @return
	 */
	public String toHtmlForMulu(String url) {
		StringBuffer sn = new StringBuffer();
		sn.append("<ul>");
		if (this.has_previous()) {
			sn.append("<li class='Shangyiye Daodile'><a style='cursor:pointer;' href='"+url+"_"+this.previous_page_number()+"/' target='_self'>上一页</a></li>");
		} else {
			sn.append("<li class='Shangyiye Daodile'><a style='cursor:pointer;'>上一页</a></li>");
		}
		if(this.getCurrPage()>1){
			for(int i = 1; i<this.getCurrPage() ;i++){
				sn.append("<li><a style='cursor:pointer;' href='"+url+"_"+i+"/' target='_self'>"+i+"</a></li>");
				minusnum++;
				if(minusnum==3)break;
			}
		}
			//选中的效果
			sn.append("<li class='Dangqian-a'><a style='cursor:pointer;' href='"+url+"_"+this.getCurrPage()+"/' target='_self'>"+this.getCurrPage()+"</a></li>");
			
			if(this.getCurrPage()<this.getTotalPage()){
				for(int i = this.getCurrPage()+1; i<this.getTotalPage()+1 ;i++){
					sn.append("<li><a style='cursor:pointer;' href='"+url+"_"+i+"/' target='_self'>"+i+"</a></li>");
					addnum++;
					if(addnum==3)break;
				}
			}
			
		if (this.has_next()) {
			sn.append("<li class='Xiayiye'><a style='cursor:pointer;' href='"+url+"_"+next_page_number()+"/' target='_self'>&nbsp;&nbsp;下一页&nbsp;&nbsp;</a></li>");
		} else {
			sn.append("<li class='Xiayiye'><a style='cursor:pointer;'>&nbsp;&nbsp;下一页&nbsp;&nbsp;</a><li>");
		}
		sn.append("<li><span>共"+totalPage+"页</span><li>");
		sn.append("<li><span>到</span><input name=\"tzpage\" id=\"tzpage\" type=\"text\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\"  /><span>页</span><li>");
		sn.append("<li class=\"Quedingdd\"><a style=\"cursor:pointer;\" target=\"_self\" onclick=\"location ='"+url+"_'+document.getElementById('tzpage').value"+"+'/'"+"\">确定</a><li>");
		sn.append("<ul>");
		sn.append("<div class=\"clear\"></div>");
		return sn.toString();
	}
	
	
	
	/**
	 * 
	 * 说明:用于翻页 
	 * 时间：2015-1-15
	 * 作者：朱庆杰
	 * @param url
	 * @return
	 */
	public String toHtmlForDianpu(String url) {
		StringBuffer sn = new StringBuffer();
		sn.append("<ul>");
		if (this.has_previous()) {
			sn.append("<li class=\"Shangyiye Daodile\"><a style=\"cursor:pointer;\" href='"+url+"_"+this.previous_page_number()+".html' target=\"_self\">上一页</a></li>");
		} else {
			sn.append("<li class=\"Shangyiye Daodile\"><a style=\"cursor:pointer;\">上一页</a></li>");
		}
		if(this.getCurrPage()>1){
			for(int i = 1; i<this.getCurrPage() ;i++){
				sn.append("<li><a style=\"cursor:pointer;\" href='"+url+"_"+this.previous_page_number()+".html' target=\"_self\"\">"+i+"</a></li>");
				minusnum++;
				if(minusnum==3)break;
			}
		}
			//选中的效果
			sn.append("<li class=\"Dangqian-a\"><a style=\"cursor:pointer;\" href='"+url+"_"+this.previous_page_number()+".html' target=\"_self\")\">"+this.getCurrPage()+"</a></li>");
			
			if(this.getCurrPage()<this.getTotalPage()){
				for(int i = this.getCurrPage()+1; i<this.getTotalPage()+1 ;i++){
					sn.append("<li><a style=\"cursor:pointer;\" href='"+url+"_"+this.previous_page_number()+".html' target=\"_self\")\">"+i+"</a></li>");
					addnum++;
					if(addnum==3)break;
				}
			}
			
		if (this.has_next()) {
			sn.append("<li class=\"Xiayiye\"><a style=\"cursor:pointer;\" href='"+url+"_"+this.previous_page_number()+".html' target=\"_self\")\">&nbsp;&nbsp;下一页&nbsp;&nbsp;</a></li>");
		} else {
			sn.append("<li class=\"Xiayiye\"><a style=\"cursor:pointer;\">&nbsp;&nbsp;下一页&nbsp;&nbsp;</a><li>");
		}
		sn.append("<li><span>共"+totalPage+"页</span><li>");
		sn.append("<li><span>到</span><input name=\"tzpage\" id=\"tzpage\" type=\"text\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\"  /><span>页</span><li>");
		sn.append("<li class=\"Quedingdd\"><a style=\"cursor:pointer;\" target=\"_self\" onclick=\"location ='"+url+"_'+document.getElementById('tzpage').value;\">确定</a><li>");
		sn.append("<ul>");
		sn.append("<div class=\"clear\"></div>");
		return sn.toString();
	}
	
	/**
	 * 
	 * 说明:用于AJAX翻页 显示id  开始时间   结束时间  访问路径
	 * 时间：2015-1-15
	 * 作者：朱庆杰
	 * @param id 显示id
	 * @param starttime 开始时间
	 * @param endtime 结束时间
	 * @param url
	 * @return
	 */
	public String toHtmlAjaxPage(String id,String typeid,String title,String starttime, String endtime, String url) {
		StringBuffer sn = new StringBuffer();
		sn.append(" <div class=\"Fanye\"><ul>");
		if (this.has_previous()) {
			sn.append("<li><a style=\"cursor:pointer;\" onclick=\"ajaxpage('"+this.previous_page_number()+"','"+id+"','"+typeid+"','"+title+"','"+starttime+"','"+endtime+"','"+url+"')\">上一页</a></li>");
		} else {
			sn.append("<li><a style=\"cursor:pointer;\">上一页</a></li>");
		}
		if(this.getCurrPage()>1){
			for(int i = 1; i<this.getCurrPage() ;i++){
				sn.append("<li><a style=\"cursor:pointer;\" class=\"Duan_a\" onclick=\"ajaxpage('"+i+"','"+id+"','"+typeid+"','"+title+"','"+starttime+"','"+endtime+"','"+url+"')\">"+i+"</a></li>");
				minusnum++;
				if(minusnum==3)break;
			}
		}
			//选中的效果
			sn.append("<li><a class=\"Duan_a Dangqian_a\" style=\"cursor:pointer;\" onclick=\"ajaxpage('"+this.getCurrPage()+"','"+id+"','"+typeid+"','"+title+"','"+starttime+"','"+endtime+"','"+url+"')\">"+this.getCurrPage()+"</a></li>");
			
			if(this.getCurrPage()<this.getTotalPage()){
				for(int i = this.getCurrPage()+1; i<this.getTotalPage()+1 ;i++){
					sn.append("<li><a style=\"cursor:pointer;\" class=\"Duan_a\" onclick=\"ajaxpage('"+i+"','"+id+"','"+typeid+"','"+title+"','"+starttime+"','"+endtime+"','"+url+"')\">"+i+"</a></li>");
					addnum++;
					if(addnum==3)break;
				}
			}
		
			
		if (this.has_next()) {
			sn.append("<li><a style=\"cursor:pointer;\" onclick=\"ajaxpage('"+this.next_page_number()+"','"+id+"','"+typeid+"','"+title+"','"+starttime+"','"+endtime+"','"+url+"')\">&nbsp;&nbsp;下一页&nbsp;&nbsp;</a></li>");
		} else {
			sn.append("<li><a style=\"cursor:pointer;\">&nbsp;&nbsp;下一页&nbsp;&nbsp;</a></li>");
		}
		sn.append("</ul></div>");
		return sn.toString();
	}
	
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	

}
