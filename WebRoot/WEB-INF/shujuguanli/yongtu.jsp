<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>导航页面</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
<script src="/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
  </head>
  <body >
     <div >
    	<%@ include file="left.jsp" %> 
         <div>
         <a href="/addyongtu.html" >添加</a>
            <table>
              <th>用途名称</th>
              <th>排序</th>
               <th>添加时间</th>
               <c:forEach items="${yongtulist }" var="y">
                 <tr>
                  <td>${y.yongtuname }</td>
                  <td>${y.paixuval }</td>
                  <td><fmt:formatDate value="${y.addtime }" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
                 </tr>
               </c:forEach>
             </table>
         </div>
        </div>
  </body>
</html>
