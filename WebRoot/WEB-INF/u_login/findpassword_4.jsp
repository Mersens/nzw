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
                <li><img src="/resources/login/images/d3.png" /></li>
                <li><img src="/resources/login/images/d9.png" /></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="MimazhCnt" style=" margin-bottom:130px;">
        	<div class="MimaLeftIg">
            	<img src="/resources/login/images/pic-global_03.png" />
            </div>
            <div class="MimarightTx">
            	<h3>恭喜您，找回密码成功！</h3>
                <p>
                	<a href="http://www.nz101.com">返回首页</a>
                    <a href="/user/info.html">进入会员中心</a>
                </p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
  <jsp:include  page="foot.jsp"/>
  
</body>
</html>
