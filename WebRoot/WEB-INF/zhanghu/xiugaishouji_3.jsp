<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>修改手机成功</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/Anquan.css" rel="stylesheet"/>
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>

  </head>
  <body>
  
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">
<jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">修改已验证手机</p>
                 <!--未认证-->
                <form action="" method="post">
                <input name="__RequestVerificationToken" type="hidden" value="" />    
                <div style="clear:both;" class="uup">
                	<img src="/resources/images/phone3.png" />
                    <img style="display:none;" src="/resources/images/yanzheng2.png" />
                </div>
                <div class="hppl">
                	<img src="/resources/images/pgone.png" />
               	</div>
                <div class="nnr">
                    <p>最新安全评级：<span>较低</span><span style="display:none;">中等</span><span style="display:none;">安全</span></p>
                    <p>您的账户安全级还能提升哦，快去安全中心完善其它<a href="/user/zhanghu/safe.html">安全设置</a>提高评价吧！</p>
                </div>
</form>
                
        </div>
        </div>
    </div>
    <div class="clear"></div>
    
<jsp:include page="/userCommonCenter/gotohelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
