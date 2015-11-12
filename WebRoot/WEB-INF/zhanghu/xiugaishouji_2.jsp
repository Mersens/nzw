<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>修改手机</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/Anquan.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
 <script type="text/javascript" src="/resources/zhanghu/updatephone.js" ></script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">
<jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">修改已验证手机</p>
                 <!--未认证-->
                <form  id="newPhoneForm" >
          		  <div class="uup"><img src="/resources/images/phone2.png"></div>
           	 <div class="informationk">
                <div class="information-leftk">
                    我的手机号：
                </div>
                <div class="information-rightk">
                    <input type="text" class="inputk" id="NewMobile" name="NewMobile" value="">            
                    <span id="lbmsg" style="color:red; display:none;">此手机号码已被注册</span>
                </div>
            </div>
    		<a style="cursor:pointer;" id="huoqu" onclick="getNewPhoneCode()" class="HuoquYzm">获取短信验证码</a>
    		<a style="display: none" id="rehuoqu"  class="HuoquYzm">(<span id="showtime"></span>秒)后重新获取</a>
            <div id="sendcodetip">
            	已发送，验证码30分钟内有效；若未收到短信，可再次点击获取验证码
            </div>
            <div class="mppp">
                <div class="informationk">
                    <div class="information-leftk">请填写手机校验码：</div>
                    <div class="information-rightk">
                        <input class="inputk" type="text" id="MobileCode" name="MobileCode" value="" maxlength="6">
                    </div>
                    <span id="lbcodemsg" style="color:#c27200;"></span>
                </div>
                <div class="informationk">
                    <div class="information-leftk">验证码：</div>
                    <div style="width:120px;" class="information-rightk">
                        <input class="inputk" style="width:100px;" type="text" id="ValidateCode" name="ValidateCode" value="" maxlength="5">
                    </div>
                    <img style="float: left; margin-left: 2px; margin-right:6px;height: 38px !important;" src="/yanzhengma.html" alt="看不清楚">
                    <div style="margin-left:5px;" class="information-leftkk">
                        看不清？
                        <a style="color:#ff8800;cursor:pointer" onclick="genghuan();">换一张</a>
                    </div>
                    <img id="onSuccess" style="display: none; margin-top: 13px;" src="/resources/images/success.png">
                    <img id="onError" style="display: none; margin-top: 13px;" src="/resources/images/error.png">
                </div>
                <div class="informationk">
                    <div class="information-leftk"></div>
                    <div class="information-rightk">
                        <a style="cursor:pointer" onclick="updatePhone()" class="Tijiao-Mod">提交</a>
                    </div>
                    <span id="lbvalmsg" style="color:red;"></span>
                </div>
            </div>
</form>
<div class="why">
    <div class="wee">为什么要进行身份验证？</div>
    <div class="whyy">
        <p style="margin-top:22px;">
            1、为保障您的账户信息安全，在变更账户中的重要信息时需要进行身份验证，感谢您的理解和支持。
        </p>
        <p>2、验证身份遇到问题？请发送用户名、手机号、历史订单发票至kf@steelcn.com，客服将尽快联系您。</p>



    </div>
</div>
               
                
        </div>
        </div>
    </div>
    <div class="clear"></div>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
