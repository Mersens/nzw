<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>我的消息</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/Anquan.css" rel="stylesheet" />
<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="/resources/js/Header-top.js" ></script>
<script type="text/javascript" src="/resources/js/Left-nav.js" ></script>
  <script type="text/javascript;" src="/resources/message/mymessage.js"></script>
  </head>
  <body>
<jsp:include page="/userCommonCenter/gotoHead" />

    <div class="main" style="margin-bottom:25px;">
 <jsp:include page="/userCommonCenter/gotoLeft" />

        <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">我的消息</p>
                 <!--未认证-->
                <div class="szz1">
  <div class="szz2">
   <input type="hidden" id="typeid" value="0" />
    <table class="msgnav" cellspacing="0">
        <tbody><tr>
            <td height="34" align="center" id="type0" class="itemnav curnav" onclick="chaxun(0)" >
                     所有消息(${totalmsg })
            </td>
            <td align="center" id="type1" class="itemnav" onclick="chaxun(1)">系统通知(${xitongmsg })</td>
            <td align="center" id="type2" class="itemnav" onclick="chaxun(2)">农资公告(${gonggaomsg })</td>
            <td align="center" id="type3" class="itemnav" onclick="chaxun(3)">私信(${sixinmsg })</td>
            <td style="border-bottom:1px solid #D7DCE1;"></td>
        </tr>
    </tbody>
    </table>
    <div id="msgdiv">
    
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
