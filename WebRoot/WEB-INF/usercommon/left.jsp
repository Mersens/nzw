<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
function do_list_row_show(strid){
	strid.getElementsByTagName('a')[0].className='on';
	strid.getElementsByTagName('span')[0].style.display="block";
	strid.style.position="relative";
}
function do_list_row_unshow(strid){
	strid.getElementsByTagName('a')[0].className='';
	strid.getElementsByTagName('span')[0].style.display="";
	strid.style.position="";
}
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".Xs_button").click(function(){
  $("ul.Yc_ceng").toggle();
  });
  
  $(".Xs_button2").click(function(){
  $("ul.Yc_ceng2").toggle();
  });
  
  $(".Xs_button3").click(function(){
  $("ul.Yc_ceng3").toggle();
  });
  
  $(".Xs_button4").click(function(){
  $("ul.Yc_ceng4").toggle();
  });
  
  $(".Xs_button5").click(function(){
  $("ul.Yc_ceng5").toggle();
  });
});
</script>
<%
  String path = request.getRequestURL().toString();
  request.setAttribute("url", path ); 
 %>
 

<div class="tjskl-sidebar">
           	    <div <c:choose><c:when test="${fn:contains(url,'seller')}">class="ti_Biaoti Xs_button" </c:when><c:otherwise>class="ti_Biaoti Xs_button2"</c:otherwise></c:choose>  >
           	    <em>我是供应商</em><img src="/resources/images/left-nav-bj.png" />
           	    <div class="clear"></div>
           	    </div>
                <ul  <c:choose><c:when test="${fn:contains(url,'seller') or fn:contains(url,'xunjiadan')}">class="tj_submain Yc_ceng" </c:when><c:otherwise>class="tj_submain Yc_ceng2"</c:otherwise></c:choose>   >
                <!-- 
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">已卖出的货物</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">交易账务</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">提取货款</a></h3>
                    </li>
                     -->
                    <li  <c:if test="${fn:contains(url,'fabuchanpin') }">class="Dangqian_amod"</c:if>  onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="/user/seller/fabu.html">发布产品</a></h3>
                    </li>
                    <li <c:if test="${fn:contains(url,'chanpinguanli') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="/user/seller/shangpin.html">产品管理</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">查看店铺</a></h3>
                    </li>
                    
                    <li <c:if test="${fn:contains(url,'xunjiadan') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#"><em>询盘管理</em><img src="/resources/images/Left-nav.png" /><div class="clear"></div></a></h3>
                        <span>
                            <a href="/user/seller/xjd.html">收到的询盘</a>
                             <!-- 
                            <a href="#">发出的报价</a>
                            -->
                        </span>
                    </li>
                </ul>
                <div class="clear"></div>
                
                <!-- 
                <div class="ti_Biaoti Xs_button2"><em>我是采购商</em><img src="/resources/images/left-nav-bj.png" /><div class="clear"></div></div>
                <ul class="tj_submain Yc_ceng2">
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">已买到的货物</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">发布询价单</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="/userCenter/gotoXunjiadan">采购管理</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">收货地址管理</a></h3>
                    </li>
                    <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">我的收藏</a></h3>
                    </li>
                </ul>
                <div class="clear"></div>
                 -->
                
                <div <c:choose><c:when test="${fn:contains(url,'company')}">class="ti_Biaoti Xs_button" </c:when><c:otherwise>class="ti_Biaoti Xs_button3"</c:otherwise></c:choose>>
                <em>旺铺管理</em><img src="/resources/images/left-nav-bj.png" /><div class="clear"></div></div>
                <ul <c:choose>
                   <c:when test="${fn:contains(url,'company') }">
                     class="tj_submain Yc_ceng" 
                   </c:when>
                   <c:otherwise>
                    class="tj_submain Yc_ceng3"
                   </c:otherwise>
                </c:choose>>
                   <!--  <li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="#">店铺模板</a></h3>
                    </li> -->
                    <li <c:if test="${fn:contains(url,'gongsi') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a style="cursor:pointer;"><em>公司管理</em><img src="/resources/images/Left-nav.png" /><div class="clear"></div></a></h3>
                        <span>
                            <a href="/user/company/info.html">企业资料</a>
                           <!--  <a href="#">联系方式</a>
                            <a href="#">证书荣誉</a> -->
                        </span>
                    </li>
                    <li class="QingchuFd"></li>
                    <li <c:if test="${fn:contains(url,'wangpu') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a style="cursor:pointer;"><em>旺铺服务</em><img src="/resources/images/Left-nav.png" /><div class="clear"></div></a></h3>
                        <span>
                            <a href="/user/company/wangpuinfo.html">旺铺资料</a>
                            <a href="/user/company/domain.html">旺铺域名</a> 
                        </span>
                    </li>
                    <li class="QingchuFd"></li>
                    <li <c:if test="${fn:contains(url,'dongtai') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a style="cursor:pointer;"><em>公司动态</em><img src="/resources/images/Left-nav.png" /><div class="clear"></div></a></h3>
                        <span>
                            <a href="/user/company/addnews.html">发布公司动态</a>
                            <a href="/user/company/news.html">公司动态管理</a>
                        </span>
                    </li>
                    <li class="QingchuFd"></li>
                </ul>
                <div class="clear"></div>
                <div <c:choose><c:when test="${fn:contains(url , 'message') }">class="ti_Biaoti Xs_button" </c:when><c:otherwise>class="ti_Biaoti Xs_button4" </c:otherwise></c:choose>>
                <em>消息管理</em><img src="/resources/images/left-nav-bj.png" /><div class="clear"></div></div>
           		<ul <c:choose> <c:when test="${fn:contains(url , 'message') }"> class="tj_submain Yc_ceng" </c:when><c:otherwise> class="tj_submain Yc_ceng4"</c:otherwise></c:choose>>
                    <li <c:if test="${fn:contains(url , 'myxiaoxi') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                        <h3><a href="/user/message.html">我的消息</a></h3>
                    </li>
                </ul>
                <div class="clear"></div>
                
                <div <c:choose>
                   <c:when test="${fn:contains(url , 'zhanghu') }">
                     class="ti_Biaoti Xs_button" 
                   </c:when>
                   <c:otherwise>
                     class="ti_Biaoti Xs_button5" 
                   </c:otherwise>
                </c:choose> ><em>账号管理</em><img src="/resources/images/left-nav-bj.png" /><div class="clear"></div></div>
                <ul  <c:choose>
                   <c:when test="${fn:contains(url , 'zhanghu')}">
                     class="tj_submain Yc_ceng"
                   </c:when>
                   <c:otherwise>
                    class="tj_submain Yc_ceng5"
                   </c:otherwise>
                </c:choose>>
                  <li <c:if test="${fn:contains(url,'gerenxinxi') }">class="Dangqian_amod"</c:if> onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                      <h3><a href="#"><em>会员管理</em><img src="/resources/images/Left-nav.png" /><div class="clear"></div></a></h3>
                      <span>
                          <a href="/user/info.html">个人资料管理</a>
                          <a href="/user/company/info.html">企业资料管理</a>
                      </span>
                  </li>
                  <div class="clear"></div>
                  <li <c:if test="${fn:contains(url , 'zhanghuanquan') }">class="Dangqian_amod"</c:if>  onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
                      <h3><a href="/user/zhanghu/safe.html">账户安全</a></h3>
                  </li>
              </ul>
              <div class="clear"></div>
			  </div>