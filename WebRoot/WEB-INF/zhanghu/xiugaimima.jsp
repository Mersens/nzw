<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>修改密码</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/resource.css" rel="stylesheet" />
<link href="/resources/css/jquery-ui-1.9.2.custom.css" rel="stylesheet" />
<link href="/resources/css/qye.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/layer.min.js"></script>
<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
<script src="/resources/js/Tianxie.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/zhanghu/updatepwd.js"></script>
  </head>
  <body>
  <jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">

    <jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">修改密码</p>
                 <!--未认证-->
                <div class="mpp" style="margin-top:20px;">
                 <form name="pwdForm" id="pwdForm">
                    <div class="information">
                        <div class="information-left">验证原始密码 ：</div>
                        <div class="information-right"><input class="input" type="password" id="oldPassword" name="oldPassword" onkeyup="this.value=this.value.replace(/[^\w]/g,'');"  /></div>
                        <div class="information-leftu">
                    </div>
                    </div>
                    <div class="information">
                        <div class="information-left">请输入新密码 ：</div>
                        <div class="information-right"><input class="input" type="password" id="newPassword" name="newPassword" onkeyup="this.value=this.value.replace(/[^\w]/g,'');"   /></div>
                        <div id="div_Password" class="information-leftu"> </div>
                    </div>
                    <div class="information">
                        <div class="information-left">再次输入新密码 ：</div>
                        <div class="information-right"><input class="input" type="password" id="confirmPassword" name="confirmPassword" onkeyup="this.value=this.value.replace(/[^\w]/g,'');"  /></div>
                        <div id="div_ConfirmPassword" class="information-leftu"> </div>
                    </div>
                
                    <div class="information">
                    <div class="information-left"></div>
                    <div class="information-right" style="height:auto;">
                        <input name="submit" id="submit" type="button" class="zhuce color" onclick="updatepwd()" value="确认提交" />
                    </div>
                  <div class="information-leftu"></div>
			 </div>
			 </form>
		</div>
        </div>
        </div>
    </div>
    <div class="clear"></div>
    

<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
