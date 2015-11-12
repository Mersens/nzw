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
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
<![endif]-->

<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css" href="/resources/css/wangEditor-1.1.0-min.css"/>
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/js/jquery.reveal.js"></script>
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

    <div class="BuzhouBeijing">
    	<div class="FabuChanpin" style="margin-top:0px; padding-top:30px;">
            <ul class="Buzhou_1">
                <li class="time1 T_cur">选择商品分类</li>
                <li class="time2">填写商品信息</li>
                <li class="time3">提交成功,等待审核</li>
                <div class="clear"></div>
            </ul>
            <div class="BuzhouImg">
                <img src="/resources/images/BuzhouImg1.png" />
            </div>
        </div>
    </div>
    <div class="FenbuCnt">
    	<div class="FnebuCnt_title">
        	<h3>选择类目</h3>
        </div>
        
        <div class="FenleiMod">
        	<div class="Fenlei_D">
            	<ul>
                   <c:forEach items="${flist}" var="m">
                	<li>
                    	<a href="/user/seller/fabu2_${m.categoryId}_0_0.html"><p>${m.name }</p><img src="/resources/images/selico_03.png" /></a>
                    </li>
                   </c:forEach>
                </ul>
            </div>
            <div class="Fenlei_D">
            	<ul>
                	<c:forEach items="${llist}" var="m">
                	<li>
                    	<a href="/user/seller/fabu2_${m.parentId}_${m.categoryId}_0.html"><p>${m.name }</p><img src="/resources/images/selico_03.png" /></a>
                    </li>
                   </c:forEach>
                </ul>
            </div>
            <div class="Fenlei_D">
            	<ul>
                	<c:forEach items="${clist}" var="m">
                	<li>
                    	<a href="/user/seller/fabu2_${f.categoryId}_${m.parentId}_${m.categoryId}.html" ><p>${m.name}</p></a>
                    </li>
                   </c:forEach>
                </ul>
            </div>
            <div class="clear"></div>
            <div class="Dangqianxuan">
            	<ul>
                	<li>您当前的选择：</li>
                    <li><c:if test="${!empty f}">${f.name}
                    
                    <c:if test="${!empty l}">>>${l.name}
                    
                     <c:if test="${!empty c}">>>${c.name}
                    
                    </c:if>
                    
                    </c:if>
                    
                    
                    </c:if>
                    
                    </li>
                </ul>
            </div>
        </div>
    </div>
   	<div class="FabuAnniu" style="margin-top:20px; width:400px;">
   	<form action="/user/seller/fabu3.html" method="get" id="leimufrom">
   		<input  name="fid"   id="fid"  type="hidden" value="${f.categoryId}"/>
   		<input  name="lid"   id="lid"  type="hidden" value="${l.categoryId}"/>
   		<input  name="cid"   id="cid"  type="hidden" value="${c.categoryId}"/>
   		<input class="a_anniua" name="" type="button"  onclick="tijiao();" value="下一步,填写商品信息"/>
   	</form>
   		
   	
   	<script type="text/javascript">
	function tijiao(){
		if($("#fid").val()!="" || $("#lid").val()!="" || $("#cid").val()!=""){
			$("#leimufrom").submit();
		}
	}
</script>



    	<a class="a_anniua" style="float:left;display:none;" href="/userCenter/gotoAddChanpinXinxi">下一步,填写商品信息</a>
        <a class="a_xuzhi" href="javascript:void(0);" data-reveal-id="myModal">商品发布须知</a>
        <div id="myModal" class="reveal-modal3">
              <div class="reveal-modal-title">
              	  <span>商品发布须知</span>
                  <a class="close-reveal-modal"></a>
              </div>
              <div class="reveal-con">
              		<div class="TitleGuifan">
                    	<h3>商品发布规范</h3>
                    </div>
              		<textarea name="" cols="" rows="" readonly>
达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑达大厦桑
                    </textarea>
              </div>
          </div>
    </div>
   
   
 	
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
