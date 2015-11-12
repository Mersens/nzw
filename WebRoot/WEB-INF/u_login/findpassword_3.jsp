<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
<link type="text/css" rel="stylesheet" href="/resources/login/css/Mimazh.css" />
<link type="text/css" rel="stylesheet" href="/resources/login/css/Public.css" />

<script type="text/javascript" src="/resources/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/resources/login/js/global.js"></script>
<script type="text/javascript" src="/resources/login/js/password.js"></script>
</head>

<body>
	<div class="Login_heard">
    	<div class="heard_Cont">
        	<div class="Cont_logo">
            	<a href="#"><img src="/resources/login/images/logo.png" title="101农资网Logo" /></a>
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
            	<li><img src="/resources/login/images/d5.png" /></li>
                <li><img src="/resources/login/images/d2.png" /></li>
                <li><img src="/resources/login/images/d7.png" /></li>
                <li><img src="/resources/login/images/d4.png" /></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="MimazhCnt">
        <form action="/password/gotoUpdatePassword" method="post">
        	<p>
            	<span>输入新密码：</span>
                <input type="password" id="newpwd" name="newpwd" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
             	<div class="clear"></div> 
            </p>
            <p>
            	<span>重复新密码：</span>
                <input type="password" id="renewpwd" name="renewpwd" class="user" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
             	<div class="clear"></div> 
            </p>
            <p>
            	<span>　</span>
                <a class="Tijiao_a" style="cursor:pointer;" onclick="updatepwd()">修改完成</a>
             	<div class="clear"></div> 
            </p>
            </form>
        </div>
    </div>
  <jsp:include  page="foot.jsp"/>
  
</body>
</html>
