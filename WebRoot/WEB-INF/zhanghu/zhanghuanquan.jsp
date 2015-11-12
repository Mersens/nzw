<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>账户安全</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
	<link href="/resources/css/qye.css" rel="stylesheet"/>
	<script src="/resources/js/jquery-1.10.2.min.js"></script>
	<script src="/resources/js/Header-top.js"></script>
	<script src="/resources/js/Left-nav.js"></script>
	<script src="/resources/js/layer.min.js"></script>
	<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
	<script src="/resources/js/h.js" type="text/javascript"></script>
	<script src="/resources/js/Tianxie.js" type="text/javascript"></script>
  </head>
  <body>
 <jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">
<jsp:include page="/userCommonCenter/gotoLeft" />


        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">账户安全</p>
                 <!--未认证-->
                <div class="qiye">
                    <div class="qiye_left"><img src="/resources/images/checkmark_u136.png"/>&nbsp;登录密码</div>
                    <div class="qiye_center">
                        <p style="color:#C27200;line-height: 79px;">
                            互联网账号存在被盗风险，建议您定期更改密码以保护账户安全。
                        </p>
                    </div>
                    <div class="qiye_right">
                    	<a href="/user/zhanghu/xgmm.html" class="zhucek_mk colormk">修改</a>
                    </div>
                </div>

                <div class="qiye">
                    <div class="qiye_left">
                 		<img src="/resources/images/checkmark_u136.png"/>        手机验证
                    </div>
                    <div class="qiye_center">
                            <p style="line-height: 79px;">
                                <span style="color:silver;">您验证的手机：</span>${fn:substring(user.userphone,0,3) }****${fn:substring(user.userphone,7,12) }
                                <span style="color:silver;">若已丢失或停用，请立即更换，</span><span style="color:#C27200;">避免账户被盗</span>
                            </p>
                    </div>
                    <div class="qiye_right">
                            <a href="/user/zhanghu/xgsj.html" class="zhucek_mk colormk">修改</a>
                    </div>
                </div>
                
                
                <!-- 
                <div class="qiye liubai">
                    <div class="qiye_left">
                		 <img src="/resources/images/exclamationmark_u67.png"/>支付密码
                    </div>
                    <div class="qiye_center">
                        <p style="line-height:79px;">
                            付款或修改账户信息时输入，保护账户资金安全
                            <span style="color:#C27200;">未设置</span>
                        </p>
                        <p>
                            安全程度：<img src="/resources/images/paypwd_qiangruo0.png"/>
                        </p>
                    </div>
                    <div class="qiye_right">
                    <a href="#" class="zhucek_mk colormk">立即修改</a>
                    </div>
                </div>
                 -->
                
                
        </div>
        </div>
    </div>
    <div class="clear"></div>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
