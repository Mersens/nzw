
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="/resources/seller/upchanpinimg.js"></script>

<div class="fitem">
	<form id="chanpinform" method="post" action="/sellerCenter/up" enctype="multipart/form-data">
		<input type="file" name="chanpinimgsrc" id="chanpinimgsrc"  class="easyui-validatebox" validType="fileType['BMP|GIF|JPG|JPEG|ICO|PNG|TIF']" invalidMessage="请选择(BMP|GIF|JPG|JPEG|ICO|PNG|TIF)等格式的图片"/> 
		<a style="cursor:pointer" id="upphotobutton" onclick="upimg();" >上传图片</a> 
	</form>
</div>