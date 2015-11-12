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
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
<![endif]-->

<script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
<script src="/resources/easyui/jquery.min.js" type="text/javascript"></script>
<script src="/resources/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/resources/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="/resources/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="/resources/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="/resources/easyui/easyui-kindeditor.js"></script>
 <script type="text/javascript" src="/resources/jquery/layer.min.js"></script>
<script type="text/javascript" src="/resources/seller/upchanpinimg.js"></script>

  <script type="text/javascript" src="/resources/seller/chanpin.js"></script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="BuzhouBeijing">
    	<div class="FabuChanpin" style="margin-top:0px; padding-top:30px;">
            <ul class="Buzhou_1">
                <li class="time1">选择商品分类</li>
                <li class="time2 T_cur">填写商品信息</li>
                <li class="time3">提交成功,等待审核</li>
                <div class="clear"></div>
            </ul>
            <div class="BuzhouImg">
                <img src="/resources/images/BuzhouImg2.png" />
            </div>
        </div>
    </div>
    
    <div class="DangXuan">
    	<ul>
        	<li>您选择的类目：</li>
            <li>${fleimu.name }></li>
            <li>${lleimu.name }></li>
            <li>${cleimu.name }</li>
        </ul>
    </div>
    <form id="shangpinform">
    <input type="hidden" name="chanpinleimu" id="chanpinleimu" value="${cleimu.categoryId }" />
    <div class="FenbuCnt">
		 <div class="FenbuCnt_title">
         	商品基本信息
         </div>
         <div class="JibenCanshu">
         	<h3>商品基本参数：<em>（填错商品属性将可能导致商品下架或搜索不到，请准确填写商品属性！）</em></h3>
             <p>
            	<span>商品标题：</span>
                <input style="width:400px;" name="title" id="title" type="text"/>
                <i style="color:#666; margin-left:7px;">60字以内</i>
                <i style="display:none;">请填写正确的信息</i>
            </p><br/>
            <p>
            	<span>关键字：</span>
                <input style="width:400px;" name="keyword" id="keyword" type="text"/>
                <i style="color:#666; margin-left:7px;">30字以内</i>
                <i style="display:none;">请填写正确的信息</i>
            </p><br/>
            <p>
            	<span>商品描述：</span>
                <input style="width:400px;" name="miaoshu" id="miaoshu" type="text"/>
                <i style="color:#666; margin-left:7px;">100字以内</i>
                <i style="display:none;">请填写正确的信息</i>
            </p><br/>
            <c:forEach items="${shuxinglist }" var="s">
              <p>
            	<span>${s.shuxing.shuxingname }：</span>
                <input style="width:400px;" name="${s.shuxing.shuxingid }" id="${s.shuxing.shuxingid }" type="text"/>
                <i style="display:none;">请填写正确的信息</i>
            </p><br/>
            </c:forEach>
            
         </div>       
    </div>
    
    <div class="FenbuCnt">
		 <div class="FenbuCnt_title">
         	图片和详细说明
         </div>
         <div class="TianjieImg">
         	<div class="LeftH3">
            	<h3>商品图片：</h3>
            </div>
            <div class="RightImg">
            	<h3>您可以上传8张图片大小不超过5M，支持jpg,jpeg,gif格式。</h3>
            	<!-- <form id="imgform" action="/sellerCenter/up" enctype="multipart/form-data"> -->
            	<div style="width: 500px; margin-top:15px; height: auto;">  
                   <!--  <input id="imgsrc" name="imgsrc" type="file" value="选择文件" />   -->
                   <c:forEach items="${imglist }" var="m">
                     <img src="${m }" width="130px;" height="100px;"/>
                   </c:forEach>
                    <input id="files" type="button" value="上传图片" onclick="addimg()" />  
                    <!-- <div style="width: 420px; height: 180px; overflow:auto;border:1px solid #C0C0C0;">-->  
                    <div id="fileList" style="margin-top: 10px; padding-top:10px; font-size: 13px; width:400px">  
                          
                    </div>  
                    <!-- </div>-->  
                </div>
               <!--  </form> -->
            </div>
            <div class="clear"></div>
         </div>
         
         <div class="TianjieImg">
         	<div class="LeftH3">
            	<h3>商品详情：</h3>
            </div>
             <div class="fitem" >
               <textarea name="offerDetail" id="offerDetail"  class="easyui-kindeditor" style="width: 65%; height: 350px; visibility: hidden;"></textarea>
             </div>
            <div class="clear"></div>
         </div>       
    </div>
    
   	<div class="FabuAnniu" style="margin-top:20px;">
    	<a class="a_anniua" style="cursor:pointer;" onclick="addChanpin()">下一步,设置交易信息</a>
    </div>
   </form>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
