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
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/hyzx.css" rel="stylesheet"/>
<link href="/resources/css/resource.css" rel="stylesheet"/>
<link href="/resources/css/Fabuchanpin.css" rel="stylesheet"/>
<!--引入 fontawesom-4.2.0-->
<link rel="stylesheet" type="text/css" href="/resources/fontawesome-4.2.0/css/font-awesome.min.css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
<![endif]-->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css" href="/resources/css/wangEditor-1.1.0-min.css"/>
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
<script type="text/javascript" src='/resources/js/wangEditor-1.1.0-min.js'></script>
<script type="text/javascript">
	$(function(){
		$('#spanTime').text((new Date()).toString());

		//一句话，即可把一个div 变为一个富文本框！o(∩_∩)o 
		var $editor = $('#txtDiv').wangEditor();

		//显示 html / text
		var $textarea = $('#textarea'),
			$btnHtml = $('#btnHtml'),
			$btnText = $('#btnText'),
			$btnHide = $('#btnHide');
		$textarea.hide();
		$btnHtml.click(function(){
			$textarea.show();
			$textarea.val( $editor.html() );
		});
		$btnText.click(function(){
			$textarea.show();
			$textarea.val( $editor.text() );
		});
		$btnHide.click(function(){
			$textarea.hide();
		});
	});
</script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />

    <div class="main" style="margin-bottom:25px;">

 <jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">发布产品</p>
                 <!--未认证-->
          	<div class="FabuChanpin">
            	<ul class="Buzhou_1">
                	<li class="time1 T_cur">选择商品分类</li>
                    <li class="time2">填写商品信息</li>
                    <li class="time3">提交成功,等待审核</li>
                    <div class="clear"></div>
                </ul>
                <div class="BuzhouImg">
                	<img src="/resources/images/BuzhouImg1.png" />
                </div>
                <div class="FabuAnniu">
                	<a class="a_anniua" href="/user/seller/fabu2.html">发布产品</a>
                </div>
                
                <div class="PaimingKao">
                	<div class="PaimingImg">
                    	<img src="/resources/images/20150720_3.jpg" />
                    </div>
                    <div class="PaimingTxt">
                    	<h3>如何让产品排名靠前</h3>
                        <p>1、您的产品名称务必出现在标题中。</p>
                        <p>2、标题的填写尽量规范化，不要堆砌多个产品词，核心产品词最好1~2个。</p>
                        <p>3、产品属性如实填写，并尽可能的填写完整。</p>
                        <p>4、为每条产品信息选择合适的类目。</p>
                        <p>5、填写准确完整的产品信息，包括属性信息，价格，详情信息等，并且尽可能填写准确，以获得较高的信息质量星级。</p>
                        <p>6、上传清晰的产品图片，给买家更好的指引，尽量增加实拍图。</p>
                        <p>7、产品详情页面，图片清晰，文字描述清楚，图片和文字描述吻合，不要出现不相关的内容。</p>
                        <p>8、产品名称+产品特点（产品优势）+一句话广告（可引用最新的网络流行语，更吸引眼球）。</p>
                    </div>
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
