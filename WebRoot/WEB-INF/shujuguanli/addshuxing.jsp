<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>添加属性页面</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
<script src="/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
  <script type="text/javascript" src="/resources/shujuguanli/shujuguanli.js"></script>
  </head>
  <body >
     <div >
        <%@ include file="left.jsp" %> 
         <div>
         <h3>产品属性的添加</h3>
         <form id="form" action="/shuju/addShuxingData" method="post">
                     属性id:  <input type="text" name="shuxingid" id="shuxingid" />
                     属性名称:  <input type="text" name="shuxingname" id="shuxingname" />
              <input type="button" name="btn" id="btn" value="提交" onclick="addshuxing()"/>  
          </form>     
         </div>
        </div>
  </body>
</html>
