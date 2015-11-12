<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>公司动态</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/hyzx.css" rel="stylesheet" />
<link href="/resources/css/resource.css" rel="stylesheet" />
<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/resources/js/Header-top.js" ></script>
<script type="text/javascript" src="/resources/js/Left-nav.js" ></script>
  <script type="text/javascript" src="/resources/company/fabudongtai.js"></script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main" style="margin-bottom:25px;">

<jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">公司动态</p>
                 <!--未认证-->
                
                <div class="mj_rm">
                    <div class="dtgl">
                        <div class="dtgl_t">
                            <div class="dtgl_ss">
                       <form action="" method="get">
                         <input class="ss_inp" id="newstitle" name="newstitle" type="text" value="${newstitle }"/>
                         <input type="submit" class="dt_ss" onclick="sousuo()" value="搜 索" />
                        </form>
                            </div>
                            <a class="fbdt_but" href="/user/company/addnews.html">发布店铺动态</a>
                        </div>
                        <div id="dongtaidiv">
                        
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
