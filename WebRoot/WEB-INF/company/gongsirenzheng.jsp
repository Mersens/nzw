<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>公司信息_认证</title>
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
<script src="/resources/js/h.js" type="text/javascript"></script>
<script src="/resources/js/Tianxie.js" type="text/javascript"></script>
  </head>
  <body>
  <jsp:include page="/userCommonCenter/gotoHead" />

       <div class="main" style="margin-bottom:25px;">
       <jsp:include page="/userCommonCenter/gotoLeft" />



        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">企业认证</p>
                 <!--未认证-->
                <div class="qiye" style="display:none;">
                    <div class="qiye_left" style="width:200px; font-size:18px; color:#333;">
                        <img style="margin-right:6px;" src="/resources/images/rz_wrz.png" />企业资料认证
                        <img style="margin-left:6px;margin-right:6px;" src="/resources/images/rz_img.png" />
                    </div>
                    <div class="qiye_center" style="width:460px;">
                        <p style="line-height: 20px; color:#999; font-size:12px; border-bottom:none; margin-top:8px; margin-left:20px;">
                            <span style=" color:#414141;line-height: 24px; font-size:14px; font-weight:bold;">完成认证，增加信任</span><br/>
                            完成认证可以增加交易对象对您的信任度，也是农资网在线交易<br>的基础工作。
                                <span class="red" style=" font-weight:normal;">未认证</span>
                        </p>
                    </div>
                    <div class="qiye_right" style=" float:left">
                        <input name="button" type="button" class="rzpq" style=" " onclick="" value="我要认证" />
                    </div>
                </div>
                
                <div class="qiye" style="height:90px;">
            <div class="qiye_left" style="width:80px; font-size:18px; color:#333; border-right:none;">
            	<img style="margin-right:6px;width:50px;height:50px;" src="/resources/images/rz_shz.png" /></div>
            <div class="qiye_center" style="width:740px; margin-bottom:12px;">
                <p style="line-height: 24px; color:#333; width:740px; border-bottom:none; margin-top:8px; margin-left:20px; position:relative;">
                    <span style=" color:#ff4400;line-height: 24px; font-size:14px; font-weight:bold;">正在审核中：</span><br>
                    您的认证资料已经提交成功，农资网客服将在1-2个工作日内进行处理，请您耐心等待，如您急需认证可点此直接<br/>联系客服
                    <a style="position:absolute; left:57px; top:47px;" href="#" qq="4007008508" target="_blank" onclick="QQPanel()" class="qqoffline" title="农资网客服">
                     <img width="73" height="22" src="/resources/images/kef1-h2.png" onerror="this.src=&#39;/images/kef1-h2.png&#39;" />  
                    </a>
                    <span style="margin-left:80px;">或致电：<span style="color:#ff4400">400-700-8508</span></span>
                        <span class="red" style=" font-weight:normal; display:none;">正在审核认证</span>
                </p>
            </div>
        </div>
                
                
                
                <div class="qiye" style="display:none;">
                    <div class="qiye_left" style="width:200px; font-size:18px; color:#333;">
                        <img style="margin-right:6px;" src="images/rz_wrz.png" />企业资料认证
                        <img style="margin-left:6px;margin-right:6px;" src="images/rz_img.png" />
                    </div>
                    <div class="qiye_center" style="width:460px;">
                        <p style="line-height: 20px; color:#999; font-size:12px; border-bottom:none; margin-top:8px; margin-left:20px;">
                            <span style=" color:#414141;line-height: 24px; font-size:14px; font-weight:bold;">完成认证，增加信任</span><br>
                            完成认证可以增加交易对象对您的信任度，也是农资网在线交易<br>的基础工作。
                                <span class="red" style=" font-weight:normal; color:#0eb306">已认证</span>
                        </p>
                    </div>
                    <div class="qiye_right" style=" float:left">
                        <input name="button" type="button" class="rzpq" style=" " onclick="" value="修改信息" />
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
