<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script src="/resources/js/Header-top.js"></script>
  <div class="topline">
    <div class="top">
        <div id="topleft" class="topleft">
        	<a href="/user/info.html"  style=" float:left; margin-right:5px;">${user.username }</a>
            <a class="dengluw" style="margin-left:10px;" href="/exit.html">退出</a>
        </div>
        <div class="topright">
            <a id="a_index" href="#" class="denglu">101农资网首页</a>
            <span class="xianxian">|</span>
            <a id="a_myorder" href="#" class="denglu">我的订单</a>
            <span class="xianxian">|</span>

            <span id="s_xht" class="xianxiana" style="width:88px;">
                <a id="a_xht" class="wode" href="#">现货通服务</a>
                <img id="i_xht" src="/resources/images/top_xia2.png" width="7" height="4" style="margin-top: 15px; float: left;">
                <div id="d_xht" class="kuangr" style="width: 88px; display: none;">
                    <p><a href="#">加入现货通</a> </p>
                    <p><a href="#">套餐办理</a> </p>
                    <p><a href="#">老客户续费</a> </p>
                </div>
            </span>
            <span class="xianxian ">|</span>
            <span id="s_service" class="xianxiana" style="width: 79px;">
                <a id="a_service" href="#" style="float: left; margin-left: 9px; margin-right: 5px; line-height: 35px;">客户服务</a>
                <img id="i_service" src="/resources/images/top_xia2.png" width="7" height="4" style="float: left; margin-top: 15px;">
                <div id="d_service" class="kuangr" style="width: 79px; top: 28px; height: auto; float: left; display: none">
                    <p>
                        <a href="#" target="_blank">商家入驻</a>
                    </p>
                    <p><a href="#">帮助中心 </a></p>
                    
                    <p><a href="#" target="_blank" class="online qqoffline zxkf">在线客服</a></p>
                    <p><a href="#">投诉中心</a> </p>
                    <p><a href="#">客服邮箱</a> </p>
                </div>
            </span>

        </div>
    </div>
</div>
<script src="/resources/js/qqkefu.js"></script>
    <div class="nav">
            <div class="nav_m">
                <div class="logo"><a target="_blank" href="#"><img src="/resources/images/hyzx_logo.png"></a></div>
                <div class="nav_r">
                    <a href="/user.html" class="wdhyzx">我的会员中心</a>
                    <span class="z_line"></span>
                    <a target="_blank" href="#">首页</a>
                    <a target="_blank" href="#">现货商城</a>
                    <a target="_blank" href="#">我的服务</a>
                    <a href="#">完善采购信息</a></div>
                </div>
            </div>
   