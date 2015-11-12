<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>产品管理</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet"/>
<link href="/resources/css/order.css" rel="stylesheet"/>
<link href="/resources/css/ChanpGL.css" rel="stylesheet"/>
<script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/resources/js/Header-top.js"></script>
<script type="text/javascript" src="/resources/js/Left-nav.js"></script>
<script type="text/javascript" src="/resources/seller/chanpin.js"></script>
<script type="text/javascript" src="/resources/seller/quanxuan.js"></script>
</head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">
     <jsp:include page="/userCommonCenter/gotoLeft" />  
        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="dd_mr">
    <div class="ssdd">
        <div class="ssdd_t">
            <p class="r_tit">产品管理</p>
            <div class="ssdd_tr"></div>
        </div>
    </div>
    <div class="Biaotijie">
    	<p>供应产品发布、修改后，工作日审核时间为24小时内，感谢您的耐心等待！</p>
    </div>
    <div class="qbdd">
        <div class="tab">
          <ul class="menu">
              <li id="cpstatus1" onclick="chaxun('1')" >已发布</li>
              <li id="cpstatus0" onclick="chaxun('0')">审核中</li>
              <li id="cpstatus2" onclick="chaxun('2')">审核未通过</li>
              <li id="cpstatus3" onclick="chaxun('3')">已下架</li>
              <div class="clear"></div>
              <input type="hidden" id="status" name="status" value="${status }" />
          </ul>
          <div class="con1">
              <div class="ding_t">
              		<div class="piling">
                        <div style="float:left; width:auto; margin-top:6px;">
                            <div style="margin-left:10px;" class="find1a"><input style="margin-right:5px;" type="checkbox" id="chanpin" name="chanpin" onclick="allCheck(this, 'chanpin')"/>全选</div>
                            <div style="width:100px;" class="find2a"> <input class="zhoa coloa" type="button" value="批量下架" onclick="allxiajia()" /> </div>
                            <div class="fin6a" style="float:left;">
                            	<a style="cursor:pointer;" onclick="deleteAll()">删除</a>
                             
                            </div>
                        </div>
                        <div style="width:300px;overflow:hidden; float:right;">
                        </div>
                    </div>
                       <div class="ding_tit">
                        <span class="pin" style="float:left;width:450px;">产品标题</span>
                        <span class="jine" style="float:left;width:200px;">发布时间</span>
                        <span class="zjine" style="float:left;width:200px;">操作</span>
                        <div class="clear"></div>
                    </div>
                  <div id="chanpindata">

                  </div>
                </div>
              	
          </div>
         
          <div class="clear"></div>
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
