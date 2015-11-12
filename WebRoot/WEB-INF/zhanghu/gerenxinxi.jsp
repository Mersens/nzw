<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>个人信息</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
	<link href="/resources/css/mj.css" rel="stylesheet" />
	<script src="/resources/js/jquery-1.10.2.min.js"></script>
	<script src="/resources/js/Header-top.js"></script>
	<script src="/resources/js/Left-nav.js"></script>
	<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
  <script type="text/javascript" src="/resources/zhanghu/gerenxinxi.js"></script>
  <script type="text/javascript" src="/resources/jquery/layer.min.js"></script>
  </head>
  <body>
  <jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main">
 <jsp:include page="/userCommonCenter/gotoLeft" />
        <div class="main_r" style="width:905px; min-height:800px; margin-bottom:20px;">
        <p class="r_tit">个人资料设置</p>
       <form action="/zhanghuCenter/updateGerenXinxi" method="post" name="form" id="form" >         
        <div class="mppp" style="margin-top:20px;">
        <div class="informationk_mm xinxi">
            <div class="information-leftk_mm">
                <span style="color:#ff4400; border-bottom:2px solid #ff4400; font-size:14px; font-weight:bold;">基本信息</span>
            </div>
        </div>
        <div class="informationk_mm txmm" style="margin-bottom:30px;">
            <div class="information-leftk_mm yhm " style="width:88px;margin-left:66px;text-align: right">
                <span style="color:#f00;"></span> <label for="username">头像：</label>
            </div>
                <div class="tx">
                    <img width="120" height="120" src="/resources${user.touxiang}" />
                    <div class="tx_bg"></div>
                    <a style="cursor:pointer;" onclick="addimg()" class="xgtx">上传头像</a>
                    
                </div>
        </div>

        <div class="informationk_mm" id="divxingming">
            <div class="information-leftk_mm yhm" style="width:88px;margin-left:66px;text-align: right">
                <span style="color:#C27200;">*</span> <label for="xingming">真实姓名：</label>
            </div>
            <div class="information-rightk_mm">
                <input style=" width: 230px;" class="inputk" maxlength="20" type="text" id="xingming" name="xingming" value="${user.xingming}" />
                <span id="xingmingTip1" class="ts_red" style="display:none;">真实姓名不能为空</span>
                <span id="xingmingTip2" class="ts_red" style="display:none;">请输入真实姓名，英文长度:4-20 中文长度:2-10</span>
            </div>
        </div>
        <div class="informationk_mm">
            <div class="information-leftk_mm yhm" style="width:88px;margin-left:66px;text-align: right">
                <span style="color:#C27200;">*</span> <label for="Mobile">手机号码：</label>
                
            </div>
            <div class="information-rightk_mm">
                 ${fn:substring(user.userphone,0,3) }****${fn:substring(user.userphone,7,12) } &nbsp;
                        <span class="yyz">[已验证]</span>   <a href="/user/zhanghu/xgsj.html">修改</a>
            </div>

        </div>
        <div class="informationk_mm" id="divQQ">
            <div class="information-leftk_mm yhm" style="width:88px;margin-left:66px;text-align: right">
                <span style="color:#C27200;"></span>QQ:
            </div>
            <div class="information-rightk_mm" id="divQQ">
                <input style=" width: 230px;" class="inputk" type="text" id="qq" name="qq" value="${user.qq}" />
            </div>
        </div>
        <div class="informationk_mm liubai">
            <div class="information-leftk_mm">

            </div>
            <div class="information-rightk_mm" style="width: 460px;">
                <a style="cursor:pointer" onclick="updatexinxi()" class="XinTijiao" >提交</a>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript">
    $(function () {
        var msg = "";
        if (msg == "资料保存成功") {
            $("#successTip").show();
            setTimeout(function () { $("#msg").fadeOut("slow"); }, 3000);
        }
    });
</script>
        </div>
    </div>
    <div class="clear"></div>
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
