
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/resources/zhanghu/gerenxinxi.js"></script>

<div id="imgdiv" class="fitem">
	<label>上传图片:</label>
	<form id="upform" method="post" action="/zhanghuCenter/up" enctype="multipart/form-data">
		<input type="file" name="imgsrc" id="imgsrc"  class="easyui-validatebox" validType="fileType['BMP|GIF|JPG|JPEG|ICO|PNG|TIF']" invalidMessage="请选择(BMP|GIF|JPG|JPEG|ICO|PNG|TIF)等格式的图片"/> 
		<a style="cursor:pointer" id="upphotobutton" onclick="upfile();" >上传图片</a> 
		<input type="hidden" name="type" id="type" value="${type }"/>
	</form>
</div>