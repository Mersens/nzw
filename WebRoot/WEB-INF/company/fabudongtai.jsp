<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>发布公司动态</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/hyzx.css" rel="stylesheet" />
<link href="/resources/css/resource.css" rel="stylesheet" />
<!--引入 fontawesom-4.2.0-->
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
<![endif]-->

<!--引入wangEditor.css-->

<link href="/resources/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/resources/kindeditor/themes/default/default.css" type="text/css"/>
<link rel="stylesheet" href="/resources/kindeditor/plugins/code/prettify.css" type="text/css"/>

<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="/resources/js/Header-top.js"></script>
<script type="text/javascript" src="/resources/js/Left-nav.js" ></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js" ></script>
<script type="text/javascript" src="/resources/js/select-widget-min.js" ></script>

<script src="/resources/easyui/jquery.min.js" type="text/javascript"></script>
<script src="/resources/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/resources/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="/resources/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="/resources/kindeditor/plugins/code/prettify.js"></script>

<script type="text/javascript" src="/resources/easyui/easyui-kindeditor.js"></script>

<script type="text/javascript" src="/resources/company/fabudongtai.js"></script>
<!-- <script type="text/javascript">
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
</script> -->
<script type="text/javascript" src='/resources/js/wangEditor-1.1.0-min.js'></script>
<!-- <script type="text/javascript">
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
</script> -->

  </head>
  <body>
  
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">

<jsp:include page="/userCommonCenter/gotoLeft" />
<input  name="newstitle" id="newstitle" type="hidden" />
        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">公司动态</p>
                 <!--未认证-->
               <form id="newsForm" action="/gongsi/FabuDongtai" method="post">
               <div class="Fabu_dt">
                 	<ul>
                    	<%-- <li style="padding-bottom:20px;">
                        	<span>选择新闻分类：</span>
                            <select name="drop2" class="ui-select">
                                <option value="">structure empty</option>
                                <option value="1">structure 1</option>
                                <option value="2">structure 2</option>
                                <option value="3">structure 3</option>
                            </select>
                            <p><a href="#">设置新闻分类</a></p>
                            <div class="clear"></div>
                        </li> --%>
                        <li><span><em>*</em>新闻标题：</span><input class="Txt_biao" name="title" id="title" type="text" /><div class="clear"></div></li>
                        <li><span>新闻关键字：</span><input class="Txt_biao" name="keywords" id="keywords" type="text" /><div class="clear"></div></li>
                        <li><span><em>*</em>新闻描述：</span><input class="Txt_biao" name="miaoshu" id="miaoshu" type="text" /><div class="clear"></div></li>
                    </ul>
                    <div class="clear"></div>
                    <div class="ShuruTxt">
                    	<div class="ShuruNmae">
                        	<em>*</em>新闻内容：
                        </div>
                        <div class="fitem" >
                        <textarea name="center" id="center"  class="easyui-kindeditor" style="width: 65%; height: 350px; visibility: hidden;"></textarea>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="ShuruTxt">
                    	<a style="cursor:pointer;" onclick="fabu()" class="Fabiao_a">发布新闻</a>
                    </div>
                </div>
                </form>
        </div>
        </div>
    </div>
    <div class="clear"></div>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
