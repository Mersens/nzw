<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>添加类目属性页面</title>
    <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
<script src="/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
  
  <script type="text/javascript" src="/resources/shujuguanli/shujuguanli.js"></script>
  </head>
  <body >
     <div >
    	<%@ include file="left.jsp" %> 
         <div>
         <h3>产品类目属性的添加</h3>
         <form id="form" action="/shuju/addLeimuShuxingData" method="post">
         类目：<select name="category" id="category">
           <c:forEach items="${leimulist }" var="m">
             <option value="${m.categoryId }">${m.name }</option>
           </c:forEach>
         </select><br/><br/>
                    属性:   <select multiple="multiple" name="shuxing" id="shuxing" style="width:150px;height: 200px;" onclick="xuanze(this)">
                      <c:forEach items="${shuxinglist }" var="l">
                        <option value="${l.shuxingid }">${l.shuxingname }</option>
                      </c:forEach>
                    </select><span>您已经选择了<span id="xzvalue" style="color:red"></span> </span>   <br/><br/>
                     排序数字:  <input type="text" name="orderby" id="orderby" /><br/>
                     <input type="hidden" name="shuxingval" id="shuxingval"/>
              <input type="button" name="btn" id="btn" value="提交" onclick="addleimushuxing()"/>  
          </form>     
         </div>
        </div>
  </body>
</html>
