<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>采购管理</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/caigoudan.css" rel="stylesheet" />
<script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script> 
  <script type="text/javascript" src="/resources/js/showdate.js"></script>

  <script type="text/javascript" src="/resources/js/jquery.reveal.js"></script>
  <script type="text/javascript" src="/resources/xunjiadan/xunjiadan.js"></script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">

  <jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
        <script type="text/javascript">
    $(function () {
        $(".cgd_gl a").click(function () {
            $("#status").val($(this).attr("status"));
            $("#frmxj").submit();
        });
        $(".xxyy").mouseover(function(){
            $(this).find(".yuan").show();
        }).mouseout(function(){
            $(this).find(".yuan").hide();
        });
    });
    function chexiaoXj(cgid) {
        $.layer({
            type: 2,
            title: ["", false],
            border: [0],
            closeBtn: [0, false],
            iframe: { src: "/UCenter/Caigou/ChexiaoXj/?id=" + cgid },
            area: ["580px", "445px"]
        });
    }
</script>
            <p class="r_tit">询价单管理</p>
                 <!--未认证-->
        <div class="cgd_gl" style="margin-left:21px;">

            <input type="hidden" id="status" name="status" value="${status }" />
            <a style="cursor:pointer;" id="cxstatus2" onclick="chaxun(2)">全部（<span id="status2">${total }</span>  ）</a>
            <a style="cursor:pointer;" id="cxstatus0" onclick="chaxun(0)">未查看（<span id="status0">${daichakan }</span>）</a>
            <a style="cursor:pointer;" id="cxstatus1" onclick="chaxun(1)">已查看（<span id="status1">${yichakan }</span>）</a>
        </div>
        <div class="cgd_sx" style="margin-left:21px;">
            <div class="cgd_sxl">
                <input class="srnm" type="text" placeholder="请输入询价单名称" id="xjname" name="xjname" />
                <div class="fbsj">
                    发布时间：
                    <input style="width:90px;" class="rq_inp" type="text" id="sdate" name="sdate"  onclick="return Calendar('sdate');"  />
                    至
                    <input style="width: 90px;" class="rq_inp" type="text" id="edate" name="edate" onclick="return Calendar('edate');"  />


                </div>
            </div>
            <input class="cgd_ss" type="submit" onclick="sousuo()" value="搜 索" />
        </div>
        <div id="xjdata">
        
                                   
          
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
