<script type="text/javascript" src="/resources/dianpu/js/common.js"></script>
<%@ page language="java" import="java.util.*,com.nongzi.Datas.DatasManager.DianpuDatas" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
           <div class="topline">
                <div class="top">
                 <div id="topleft" class="topleft">
		                <c:if test="${empty sessionScope.user}">
		                      <p>亲，欢迎来到101农资网！</p>
                       		  <a class="dengluw" href="/login.html" target="_blank">请登录</a>
                       		  <a class="dengluw" href="/reg.html" target="_blank">免费注册</a>
		                </c:if>
		                 <c:if test="${!empty sessionScope.user}">
		                      <p><a class="dengluw" href="/user.html" target="_blank">${sessionScope.user.username}</a>欢迎来到101农资网！</p>
		                </c:if>
                    </div>
                    <div class="topright">
                        <a id="a_index" href="/" class="denglu">101农资网首页</a>
                        <span class="xianxian">|</span>
                        <span id="s_wnz" class="xianxiana" style="width:105px;">
                            <a id="a_wnz" class="wode" href="/user.html">我的101农资网</a>
                            <img id="i_wnz" src="/resources/dianpu/images/top_xia2.png" width="7" height="4" style="margin-top:15px; float:left;">
                            <div id="d_wnz" class="kuangr" style="width:105px; display: none;">
                                <p><a href="#">加入现货通</a></p>
                                <p><a href="#">套餐办理</a></p>
                                <p><a href="#">老客户续费</a></p>
                            </div>
                        </span>
                        <span class="xianxian">|</span>
                        <span id="s_xht" class="xianxiana" style="width:79px;">
                            <a id="a_xht" class="wode" href="http://q.nz101.com">网站导航</a>
                            <img id="i_xht" src="/resources/dianpu/images/top_xia2.png" width="7" height="4" style="margin-top:15px; float:left;">
                            <div id="d_xht" class="kuangr" style="width:377px; top:35px; right:0px; display:none;">
                                    <jsp:include page="/website/gotoWangzhanDaohang" />
                            </div>
                        </span>
                        <span class="xianxian ">|</span>
                        <span id="s_service" class="xianxiana" style="width:79px;">
                            <a id="a_service" href="#" style="float: left; margin-left: 9px; margin-right: 5px; line-height: 35px;">客户服务</a>
                            <img id="i_service" src="/resources/dianpu/images/top_xia2.png" width="7" height="4" style="float: left; margin-top: 15px;">
                            <div id="d_service" class="kuangr" style="width:79px; top:35px; height: auto; float: left; display: none">
                                <p><a href="/user/company/wangpuinfo.html" target="_blank">商家入驻</a></p>
                                <p><a href="#">帮助中心 </a></p>
                                <p><a href="#" target="_blank" class="online qqoffline zxkf">在线客服</a></p>
                            </div>
                        </span>
                        </div>
                    </div>
            </div>
            
<div class="logo_Sousuo">
    	<div class="logo">
        	<a href="/"><img src="/resources/images/shouyelogo.jpg" alt="101农资网logo" title="101农资网logo" /></a>
        </div>
        <!--logo-->
        
       <div class="Sousuo">
                <table>
                    <tr>
                        <td>
                            <select name="selecttypeid"  id="selecttypeid" class="ui-select">
                              <c:forEach items="${leimulist }" var="lm">
                                <option value="${lm.categoryId }" >${lm.name }</option>
                              </c:forEach>
                                <option value="qy">企业</option>
                            </select>
                        </td>	
                    </tr>
                </table>
            <input name="selectname"  id="selectname"  type="text" />
            <a href="#" class="a-Sousuo" onclick="sousuo();" >搜索</a>
        </div>
        <div class="Zinav xunjia">
        	<a href="#">
            	<img src="/resources/images/Zinav-ico-1.png" />
                <i>发布询价单</i>
            </a>
        </div>
        <div class="Zinav xunjia">
        	<a href="#">
            	<img style="margin-left:6px" src="/resources/images/Zinav-ico-2.png" />
                <i style="margin-left:5px;">购物车<em style="color:#ff6c00;">（0）</em></i>
            </a>
        </div>
        <div class="Zinav xunjia">
        	<a href="#">
            	<img style="margin-left:17px;" src="/resources/images/Zinav-ico-3.png" />
                <i style="margin-left:15px;">意见反馈</i>
            </a>
        </div>
        <!--sousuo-->
        <div class="clear"></div>
    </div>
       