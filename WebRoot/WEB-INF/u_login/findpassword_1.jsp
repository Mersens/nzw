<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码页面</title>
<link type="text/css" rel="stylesheet" href="/resources/login/css/Mimazh.css" />
<link type="text/css" rel="stylesheet" href="/resources/login/css/Public.css" />
<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/resources/login/js/global.js"></script>
<script type="text/javascript" src="/resources/login/js/password.js"></script>
</head>
<body>
	<div class="Login_heard">
    	<div class="heard_Cont">
        	<div class="Cont_logo">
            	<a href="/"><img src="/resources/login/images/logo.png" title="101农资网Logo" /></a>
            </div>
            <div class="Cont_Shuxian">
            </div>
            <div class="Cont_Huiyuan">
            	<img src="/resources/login/images/Mimazhaohui.png" />
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!--头部header-->
    
    <div class="WangjiMm">
    	<div class="Buzhou">
        	<ul>
            	<li><img src="/resources/login/images/d1.png" /></li>
                <li><img src="/resources/login/images/d2.png" /></li>
                <li><img src="/resources/login/images/d3.png" /></li>
                <li><img src="/resources/login/images/d4.png" /></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="MimazhCnt">
        <form id="form" action="/password/gotoTestUsername" method="post">
        	<p>
            	<span>账户名：</span>
                <input type="text" id="username" name="username" value="${username}" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
             	<div class="clear"></div> 
            </p>
            <p>
            	<span>验证码：</span>
                <input type="text" id="yanzhengma" name="yanzhengma" value="${yanzhengma}" class="user" style="color:#999; width:120px;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                <img id="yzm" src="/yanzhengma.html" width="68" height="36" />
                <a style="cursor:pointer;" onclick="genghuan()">换一张</a>
             	<div class="clear"></div> 
            </p>
            <p>
            	<span>　</span>
                <a class="Tijiao_a" style="cursor:pointer;" onclick="testname()" >下一步</a>
             	<div class="clear"></div> 
            </p>
            </form>
        </div>
    </div>
    <span>${flag }</span>
  <jsp:include  page="foot.jsp"/>
  
</body>
</html>
