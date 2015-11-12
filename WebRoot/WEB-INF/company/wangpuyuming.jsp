<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>旺铺域名</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet"/>
<link href="/resources/css/WangYuming.css" rel="stylesheet"/>
<script src="/resources/js/jquery-1.10.2.min.js"/>
<script src="/resources/js/Header-top.js"/>
<script src="/resources/js/Left-nav.js" />

  </head>
  <body>
  
<jsp:include page="/userCommonCenter/gotoHead" />

    <div class="main" style="margin-bottom:25px;">
<jsp:include page="/userCommonCenter/gotoLeft" />

             <div class="main_r" style="width:905px; min-height:700px;">
         <div class="main_r" style="width:905px; min-height:700px;">
        <div class="right">
            <p class="r_tit">旺铺域名</p>
                <div class="WangYuming" style="position:relative;">
					<div class="TShezhi">
                    	<h3>初始旺铺域名：</h3>
                        <p>http://2301320.b2b.csc86.com</p>
                        <i>（提示：设置您的个性域名）</i>
                        <div class="clear"></div>
                    </div>
                    <div class="ShezhiAnniu">
                    	<input id="btn1" onclick="btn1()" name="" type="button" value="设置域名" />
                    </div>                      

                    <div class="BaoweiYU" id="div1" style="display:none; position:absolute; top:0; width:862px; background:#fff; min-height:60px;">
                      <div class="TShezhi">
                          <h3>您的旺铺域名：</h3>
                          <p>http://<input name="" type="text" />.b2b.csc86.com</p>
                          <i>（提示：设置您的个性域名）</i>
                          <div class="clear"></div>
                      </div>
                      <div class="ShezhiAnniu">
                          <input name="" type="button" value="保存域名" />
                      </div>                
                    </div> 
<script type="text/javascript">
function btn1(){
	document.getElementById('div1').style.display='block';	
	document.getElementById('btn1').style.display='none';
}

</script>           
                </div>
        </div>
        </div>
        </div >
    <div class="clear"></div>
    
</div>
    
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />
  </body>
</html>
