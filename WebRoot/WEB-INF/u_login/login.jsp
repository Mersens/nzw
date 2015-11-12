<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
<link type="text/css" rel="stylesheet" href="/resources/login/css/Login.css" />
<link type="text/css" rel="stylesheet" href="/resources/login/css/Public.css" />
<script type="text/javascript" src="/resources/login/js/jquery-1.11.2.min.js"></script>
  <script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/resources/login/js/global.js"></script>
<script type="text/javascript" src="/resources/login/js/login.js"></script></head>
<body>
	<div class="Login_heard">
    	<div class="heard_Cont">
        	<div class="Cont_logo">
            	<a href="http://www.nz101.com"><img src="/resources/login/images/logo.png" title="101农资网Logo" /></a>
            </div>
            <div class="Cont_Shuxian">
            </div>
            <div class="Cont_Huiyuan">
            	<img src="/resources/login/images/Huiyuan.jpg" />
            </div>
            <div class="Cont_Denglu">
            	还没有注册，现在就 <a href="http://www.nz101.com/reg.html">注册 </a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!--头部header-->
    <div class="register">
    	<div class="Regi_banner">
        	<a href="http://www.nz101.com"><img src="/resources/login/images/Login_banner.jpg" /></a>
        </div>
        <div class="Regi_login">
        	<div class="DengMod DengNmae" style="margin-top:10px;">
                <p style="padding-bottom:10px;">登录名</p>
                <p class="P_input">
                	<input type="text" id="username"  name="username" value="请输入登录账号/手机号" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
            </div>
            <div class="DengMod DengMi">
                <p style="padding-bottom:10px;">密码</p>
                <p class="P_input">
                	<input type="password"  id="userpwd"  name="userpwd" value="请输入登录密码" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
            </div>
            <div class="DengXuanze">
            <!-- 
                   <div class="Zidong">
                	<input name="" type="checkbox" value="" />
                	<em>自动登录</em>
                    <div class="clear"></div>
                </div>
                -->
                <div class="forgPass">
                	<a href="http://www.nz101.com/findpwd.html">忘记密码？</a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="DengMod Submit" style=" margin-top:10px;">
            	<a href="#" onclick="login()" id="xianshisubmit">立即登录</a>
            </div>
            <div class="Mianfei">
            	<div class="CuowuInfo">
                	<p><div id="tishi"></div></p>
                </div>
                
                <div class="MianLogin">
                	<a href="http://www.nz101.com/reg.html">免费注册</a>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    
    
    
  <jsp:include  page="foot.jsp"/>
  
</body>
</html>
