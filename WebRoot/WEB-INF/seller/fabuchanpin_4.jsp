<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>发布产品</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet"/>
<link href="/resources/css/hyzx.css" rel="stylesheet"/>
<link href="/resources/css/resource.css" rel="stylesheet"/>
<link href="/resources/css/Fabuchanpin.css" rel="stylesheet"/>
<!--引入 fontawesom-4.2.0-->
<link rel="stylesheet" type="text/css" href="/resources/fontawesome-4.2.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="/resources/css/jquery.inputbox.css" type="text/css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
<![endif]-->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css" href="/resources/css/wangEditor-1.1.0-min.css"/>
<link rel="stylesheet" href="/resources/css/release-pro.css"/>
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/js/select-widget-min.js"></script>
<script type="text/javascript">
$(document).ready(function(){		
	$(".ui-select").selectWidget({
		change       : function (changes) {
			return changes;
		},
		effect       : "slide",
		keyControl   : true,
		speed        : 200,
		scrollHeight : 250
	});
	
});		
</script>

  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
  <div class="BuzhouBeijing">
    	<div class="FabuChanpin" style="margin-top:0px; padding-top:30px;">
            <ul class="Buzhou_1">
                <li class="time1">选择商品分类</li>
                <li class="time2">填写商品信息</li>
                <li class="time3 T_cur">提交成功,等待审核</li>
                <div class="clear"></div>
            </ul>
            <div class="BuzhouImg">
                <img src="/resources/images/BuzhouImg4.png" />
            </div>
        </div>
    </div>
    
    <div class="FenbuCnt">
         <div class="WanchengIcon">
         	<div class="ChenggongIco">
            	<div class="IconImg">
            		<img src="/resources/images/pic-global_03.png" />
                </div>
                <div class="IconTxt">
               		<h3>恭喜！您的商品信息已经发布成功</h3>
                    <p>正常工作日内（周一到周五 9：00-17：30），一般24小时内发布上网。
审核不通过的信息，将通过邮件通知。</p>
					<p>
                    	<a class="Fabu_a" href="/user/seller/fabu.html">继续发布商品信息</a>
                        <a class="Guanli_a" style="margin-right:0px;" href="/user/seller/shangpin.html">管理商品信息</a>
                    </p>
                </div>
                <div class="clear"></div>
            </div>
            
         </div>
    </div>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
