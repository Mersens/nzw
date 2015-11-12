<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<title>免费注册</title>
  <link type="text/css" rel="stylesheet" href="/resources/login/css/Public.css" />
  <link type="text/css" rel="stylesheet" href="/resources/login/css/Login.css" />
  <script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="/resources/login/js/global.js"></script>
  <script type="text/javascript" src="/resources/login/js/reg.js"></script>
</head>
  <body onload="xiexi()">
  <div class="Login_heard">
    	<div class="heard_Cont">
        	<div class="Cont_logo">
            	<a href="http://www.nz101.com"><img src="/resources/login/images/logo.png" title="101农资网Logo" /></a>
            </div>
            <div class="Cont_Shuxian">
            </div>
            <div class="Cont_Huiyuan">
            	<img src="/resources/login/images/Huiyuan2.jpg" />
            </div>
            <div class="Cont_Denglu">
            	我已经注册，现在就 <a href="http://www.nz101.com/login.html">登录 ></a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!--头部header-->
    <div class="register">
    	<div class="Regi_banner">
        	<a href="http://www.nz101.com"><img src="/resources/login/images/Login_banner2.jpg" /></a>
        </div>
        <div class="Regi_login">
        	<div class="DengMod Shouji" style="margin-top:0px;">
                <p class="P_input" style="background:none;">
                	<input type="text" id ="phone" name="phone" value="请输入手机号" class="user" style="color:#999;"  onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
            </div>
        	<div class="DengMod DengNmae">
                <p class="P_input">
                	<input type="text"  id ="username" name="username"  value="请输入用户名" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
            </div>
            <div class="DengMod DengMi">
                <p class="P_input" style=" background:none;">
                	<input type="password"  id ="userpwd" name="userpwd"  value="请输入登录密码" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
            </div>
            
            <div class="DengMod HuoquYzm">
                <p class="P_input" style=" background:none;">
                	<input type="text"  id ="userrand" name="userrand"  value="请输入验证码" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                </p>
                <input class="Input_Yzm" type="button" id="btn" value="免费获取验证码" onclick="sendrand(this)" /> 
                <div class="clear" ></div>
            </div>
            <div class="DengXuanze" style="margin-top:10px;">
            	<div class="Zidong">
                	<input name="xiexi"  id="xiexi" type="checkbox" onclick="xiexi()"/>
                	<em>我已经阅读并接受<a href="#">《101农资网用户注册协议》</a></em>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="DengMod Submit" style="margin-top:10px; display:none;" id="xianshisubmit"  onclick="IsReg()">
            	<a href="#">立即注册</a>
            </div>
            <div class="DengMod Submit2" style="margin-top:10px;"  id="yincangsubmit">
            	<a href="#">立即注册</a>
            </div>
            <div class="Mianfei">
            	<div class="CuowuInfo" style="float:right;">
                	<p><div id="tishi" name="tishi"></div></p>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    
   <jsp:include  page="foot.jsp"/>
  </body>
</html>
