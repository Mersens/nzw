<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>旺铺资料</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/resource.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>

<script src="/resources/easyui/jquery.min.js" type="text/javascript"></script>
<script src="/resources/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/resources/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="/resources/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="/resources/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="/resources/easyui/easyui-kindeditor.js"></script>
  <script type="text/javascript" src="/resources/company/wangpuziliao.js"></script>
  </head>
  <body>
  
<jsp:include page="/userCommonCenter/gotoHead" />

    <div class="main" style="margin-bottom:25px;">
<jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">旺铺资料</p>
  		  </div>
    <div class="mj_rm" >
        <div class="inf">
            <div class="inf_l" style="width:91px;"><span class="red">*</span>旺铺名称：</div>
            <div class="inf_r" style="width:749px;">
                <input class="text_inp" id="dianpuname" name="dianpuname" style="width:370px;" type="text" value="${gongsi.gongsinama }" disabled="disabled"/><span class="color:#c27200" id="spShopName"></span>

            </div>
        </div>
           <div class="inf">
                <div class="inf_l" style="width: 91px;"><span class="red">*</span>旺铺类型：</div>
               <div style="float:left;"> 
                 <c:forEach items="${typelist }" var="t" varStatus="status">
                     <input class="radio"  id="type${status.index }" name="type" type="radio" value="${t.typeid }"   />${t.typename }&nbsp;
                 </c:forEach>
               </div>
               <div style="float:left;position: relative;width:399px;margin-left:4px;" id="wehao">
               
               <a class="huaguo_a4" style="cursor:pointer;">
                       <img class="navs" onmouseover="showSubNav('subNav_1');" onmouseout="hideSubNav('subNav_1');" src="/resources/images/wenhao.jpg" />
                       <div id="subNav_1" class="sub_nav">
					        <p>旺铺类型一经确定将不能再修改，如需修改请直拨服务热线：400-700-8508</p>
					    </div>
                   </a>
                  
             </div>
               
            </div>
        <div class="inf">
            <div class="inf_l" style="width:91px;"><span class="red">*</span>主营类目：</div>

            <c:forEach items="${leimulist }" var="l" varStatus="status">
             <input class="zliao_ra"  id="leimu${status.index }" type="checkbox" name="leimu"  value="${l.categoryId }"  />${l.name }&nbsp;&nbsp;
            </c:forEach>

            <span class="color:#c27200" id="spMain"></span>

        </div>

        <div class="inf">
            <div class="inf_l" style="width:91px;">旺铺简介：</div>
             <div class="fitem" >
                 <textarea name="dianpujieshao" id="dianpujieshao"  class="easyui-kindeditor" style="width: 65%; height: 350px; visibility: hidden;"></textarea>
             </div>
        </div>

        <div class="inf">
            <div class="inf_l" style="width:91px;">&nbsp;</div>
            <div class="inf_r">
                <input type="submit" id="btn" value="保存并提交" class="tj_but" onclick="addwangpu()" />
            </div>
        </div>

    </div>
             </div> 
        </div >
        </div>
    </div>
    <div class="clear"></div>
    

    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
