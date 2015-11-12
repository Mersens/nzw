<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.nongzi.vo.Chanpinorleimu" %>
<%@page import="com.nongzi.Datas.DatasManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>平台首页</title>
 	<jsp:include page="/website/gotoCommon" />
 	</head>
  <body>
    <!---header头部-->
     <jsp:include page="/website/gotoHead" />
 <!--logo+搜索-->
      <!--顶部四个广告-->
    <div class="GuanggaoImg">
    	<a href="#" class="Guangg1 JianjuQc"><img src="/resources/images/290-1.gif"/></a>
        <a href="#" class="Guangg1"><img src="/resources/images/290-2.gif"/></a>
        <a href="#" class="Guangg1"><img src="/resources/images/290-3.gif"/></a>
        <a href="#" class="Guangg1"><img src="/resources/images/290-4.gif"/></a>
        <div class="clear"></div>
    </div>
    <!--广告-->
    
    
    <div class="Nav">
    	<div class="Nav_title">
        	<img src="/resources/dianpu/images/Nav_title-ico.png" />
            <i>全部商品分类</i>
        </div>
        <div class="Nav-cnt">
            <a href="http://www.nz101.com" class="">首页</a>
            <i></i>
            <a href="http://q.nz101.com" class="dangqian">企业库</a>
            <i></i>
            <a href="#" class="">行业资讯</a>
            <i></i>
            <a href="#" class="">农博会</a>
            <i></i>
            <a href="#" class="">排行榜</a>
        </div>
        <div class="clear"></div>
    </div>
    <!--导航-->
    
    <div class="banner">
  <div class="yHeader">
     	   <div class="yNavIndex">
            <div class="pullDown">
                <ul class="pullDownList">
                    <li>
                        <a class="yidong" href="#">
                            <p>肥料企业</p>
                            <p class="zifenlei"><em>复合肥</em><em>氮肥</em><em>磷肥</em></p>
                        </a>
                    </li>
                    <li>
                        <a class="yidong yidong2" href="#">
                            <p>农药企业</p>   
                            <p class="zifenlei"><em>杀虫剂</em><em>杀菌剂</em><em>除草剂</em></p>
                        </a>
                    </li>
                    <li>
                        <a class="yidong yidong3" href="#">
                            <p>种子企业</p>
                            <p class="zifenlei"><em>小麦</em><em>玉米</em><em>水稻</em></p>
                        </a>
                    </li>
                    <li>
                        <a class="yidong yidong4" href="#">
                            <p>农机企业</p>
                            <p class="zifenlei"><em>拖拉机</em><em>收割机</em><em>播种机</em></p>
                        </a>
                    </li>
                    <li style="border-bottom:0px;">
                        <a class="yidong yidong5" href="#">
                            <p>农膜企业</p>
                            <p class="zifenlei"><em>棚膜</em><em>地膜</em><em>其他农膜</em></p>
                        </a>
                    </li>
                </ul>
                
                            <!-- 下拉详细列表具体分类 -->
            <div class="yMenuListCon">
                 <jsp:include page="/website/gotoShangpinFenlei" />
            </div>
        </div>
    	</div>
    	</div>
        <!--left子导航-->
        <div class="banner-img">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><a href="#"><img src="/resources/images/banner1.jpg" alt=""/></a></li>
                    <li><a href="#"><img src="/resources/images/banner2.jpg" alt=""/></a></li>
                </ul>
            </div>
        </div>
        <!---banner-->
        <div class="DengluMod">
       
        	<div class="NotLogin"  <c:if test="${sessionScope.user eq null }">style="display:block;"</c:if> <c:if test="${sessionScope.user ne null }">style="display:none;"</c:if> >
            	<div class="NotTitle">
                	<div class="NotTitle-left">
                    	<a href="#"><img src="/resources/dianpu/images/Not-Ico-touxiang.jpg" /></a>
                    </div>
                    <!--left头像-->
                    <div class="NotTitle-right">
                    	<em>Hi，上午好！</em>
                        <p>欢迎来到101nz.com</p>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--头像以及ID-->
                <div class="NotLogin_dengzhu">
                	<div class="dengzhu_d">
                    	<a href="/login.html"><img src="/resources/dianpu/images/dengzhu_d.png" />登录</a>
                    </div>
                    <div class="dengzhu_z">
                    	<a href="/reg.html"><img src="/resources/dianpu/images/dengzhu_z.png" />注册</a>
                    </div>
                </div>
                <!--登录/注册-->
                <div class="tabbox">
                    <div class="tab">
                        <a href="javascript:;" class="on">账号服务</a>
                        <a href="javascript:;">买家入门</a>
                        <a style="width:72px;" href="javascript:;">卖家入门</a>
                    </div>
                    <div class="content">
                        <ul>
                            <li>
                            	<a style="margin-left:12px;" href="/user/company/addnews.html">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="/user/company/wangpuinfo.html">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="/user/seller/fabu.html">发布<br />现货</a>
                            </li>
                            <li>
                            	<a style="margin-left:12px;" href="/user/company/addnews.html">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="/user/company/wangpuinfo.html">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="/user/seller/fabu.html">发布<br />现货</a>
                            </li>
                            <li>
                            	<a style="margin-left:12px;" href="/user/company/addnews.html">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="/user/company/wangpuinfo.html">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="/user/seller/fabu.html">发布<br />现货</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--服务信息-->
                <div class="NotNew">
                	<div class="NotNew_title">
                    	<h3>农资快报</h3>
                    </div>
                    <div class="NotNew-txt">
                    	<p><a href="#">· 8月秋粮作物重大病虫进入盛发期</a></p>
                        <p><a href="#">· 8月秋粮作物重大病虫进入盛发期</a></p>
                        <p><a href="#">· 8月秋粮作物重大病虫进入盛发期</a></p>
                    </div>
                </div>
            </div>
            
            
            <div class="NotLogin2"  <c:if test="${sessionScope.user ne null }">style="display:block;"</c:if> <c:if test="${sessionScope.user eq null }">style="display:none;"</c:if>>
            	<div class="NotTitle">
                	<div class="NotTitle-left">
                    	<a href="#"><img src="/resources/dianpu/images/Not-Ico-touxiang.jpg" /></a>
                    </div>
                    <!--left头像-->
                    <div class="NotTitle-right">
                    	<em>${sessionScope.user.username }，上午好！</em>
                        <p>欢迎来到101nz.com</p>
                    </div>
                    <div class="Wanshan"><a href="/user/info.html">立即完善企业资料</a></div>
                    <div class="clear"></div>
                </div>
                
                <div class="Xinxicaozuo">
                	<p>
                    	<span>0</span> <br />
                        <i>待付款</i>
                    </p>
                    <p>
                    	<span>0</span> <br />
                        <i>待收获</i>
                    </p>
                    <p style="border:0px;">
                    	<span>0</span> <br />
                        <i>我的招标</i>
                    </p>
                </div>
                
                <!--头像以及ID-->
                <!--登录/注册-->
                <div class="tabbox">
                    <div class="tab">
                        <a href="javascript:;" class="on">账号服务</a>
                        <a href="javascript:;">买家入门</a>
                        <a style="width:72px;" href="javascript:;">卖家入门</a>
                    </div>
                    <div class="content">
                        <ul>
                            <li style="margin-top:10px;">
                            	<a style="margin-left:12px;" href="#">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="#">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="#">发布<br />现货</a>
                            </li>
                            <li style="margin-top:10px;">
                            	<a style="margin-left:12px;" href="#">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="#">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="#">发布<br />现货</a>
                            </li>
                            <li style="margin-top:10px;">
                            	<a style="margin-left:12px;" href="#">发公<br />司介绍</a>
                                <a style="margin-left:12px;" href="#">开通<br />店铺</a>
                                <a style="margin-left:12px;" href="#">发布<br />现货</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--服务信息-->
            </div>
        </div>
        <!--已登录状/未登录状态-->
        <!--<div class="NotLogin register  DengluMod">
        
        </div>-->
    </div>
    
    
    <!--子导航-banner-登录状态-->
    
    <div class="Tuijian">
    	<div class="RemenTui">
        	<div class="RemenTui_title">
            	<h3>热门推荐</h3>
            </div>
            <div class="RemenTui_Cnt"  style="width:951px;border-right:0px;">
              <c:forEach items="${newdianpu}" var="c">
                           <div class="Cnt_Mod RemenCnt1">
                			<div class="Cnt_mod_gird">
                     			   <div class="Cnt_Mod_title">
                           			 <img src="/resources/userfile/gongsilogo/${c.gongsi.gslogo}" width="151px" height="35px"/>
                           			 <a href="http://q${c.htmlid}.nz101.com/">进入企业首页></a>
                       				 </div>
                      		  <div class="Cnt_Mod_name">
                           			 <h3>${c.dianpuname}</h3>
                     		   </div>
                        <div class="Cnt_Mod_txt">
                            <p>
                         		       公司简介:${fn:substring(c.dianpujieshao,0,25)}......<a href="http://q${c.htmlid}.nz101.com/">[查看更多]</a>
                            </p>
                        </div>
                    </div>
                </div>
    		 </c:forEach>
            </div>
        </div>
        <!--left热门推荐-->
        <div class="Billboard">
        	<div class="Top_title">
            	<h3>11月综合品牌TOP排行榜</h3>
            </div>
            <div class="s-index-side">
                  <ul class="weekly-list cls">
                    <li style="border-top:0px;">
                        <div class="app-show-title">
                            <span class="num s-index-org">1</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-xia.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                    <li>
                        <div class="app-show-title">
                            <span class="num s-index-org">2</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-xia.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                    <li>
                        <div class="app-show-title">
                            <span class="num s-index-org">3</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-xia.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                    <li>
                        <div class="app-show-title">
                            <span class="num">4</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-xia.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                    <li>
                        <div class="app-show-title">
                            <span class="num">5</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-xia.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                    <li>
                        <div class="app-show-title">
                            <span class="num">6</span>
                            <a href="#">史丹利</a>
                            <p class="PaihangTop"><img src="/resources/dianpu/images/paihang-ping.png" /><em>32154</em><div class="clear"></div></p>
                            <div class="clear"></div>
                        </div>
                        <div class="app-show-block">
                            <a href="#" class="pic"><img src="/resources/dianpu/images/SHidanli.jpg" alt=""/></a>
                            <p>产品：<em>555596</em></p>
                            <p>指数：<em>12564</em></p>
                            <a href="#" class="chakan">查看详情></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <script type="text/javascript">
$(function(){

	$(".weekly-list li").bind("mouseenter",weekly_ani).bind("mouseleave",function(){
		clearTimeout(
			$(this).data("setTime")
		);
	});
	
	function weekly_ani(e){
		var me=$(e.target).closest("li");
		if(me.hasClass("current")) 
		return;
		var orili=me.parent().find(".current");
		$(this).data("setTime",setTimeout(function(){
			weekly_move(me,orili,135,41)
		},150));
	}
	
	function weekly_move(me,orili,h,h2){
		me.addClass("current");
		$(".weekly-list li").unbind("mouseenter",weekly_ani);
		setTimeout(function(){
			var cur_h=me.height();
			if(cur_h < h-2){
				var cur_orih=orili.height();
				var dh=Math.round((h-cur_h)/2.5);
				me.css("height",cur_h+dh);
				orili.css("height",cur_orih-dh);
				setTimeout(arguments.callee,25);
			}else{
				me.addClass("current").css("height",h);
				orili.css("height",h2);
				$(".weekly-list li").bind("mouseenter",weekly_ani);
				orili.removeClass("current");
			}
		},25);
	}
	
	$(".weekly-list").find("li:first").addClass("current").animate({height:135}, 300);
	
});
</script>
    
    
    <!--推荐内容-->
    <div class="Guangao3" style="width:1190px; margin:0px auto; height:90px;margin-top:20px;">
    	<div class="Guang_Lefi_img" style="float:left;"><img src="/resources/images/11901-1.jpg" alt="广告图" /> </div>
    	<div class="Guang_right_img" style="float:right;"><img src="/resources/images/11901-2.jpg" alt="广告图" /></div>
    	<div class="clear"></div>
    </div>
    
    <div class="FenLeiCnt">
    	<div class="FenleiMod Fl1">
        	<div class="FenleiMod_title">
            	<h3>肥料</h3>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="FenleiMod_left">
				<script src="/resources/js/L_slide.js"></script>
                <script type="text/javascript"> $(function(){$(".af3").slide({ affect:3, time:3000,speed:400,  });$(".af4").slide({affect:3,time:3000, speed:400, });$(".af5").slide({ affect:3,time:3000, speed:400,});$(".af6").slide({affect:3,time:3000,speed:400,});	$(".af7").slide({affect:3,     time:3000,          speed:400,    });       })         </script>
            	<div class="wrap af3">
                    <ul class="slidebox">
                        <li><a href="#"><img src="/resources/images/feiliao-1.jpg" /></a></li>
                         <li><a href="#"><img src="/resources/images/feiliao-2.jpg" /></a></li>
                          <li><a href="#"><img src="/resources/images/feiliao-3.jpg" /></a></li>
                           <li><a href="#"><img src="/resources/images/feiliao-4.jpg" /></a></li>
                    </ul>
                </div>
            </div>
            <!--leftbanner-->
            
            <div class="FenleiMod_Zhong">
            	<table cellpadding="0" cellspacing="0">
                	<tr>
                    	<th>商品名称</th><th>商品品牌</th><th>商品用途</th><th>类别</th><!-- <th>净含量</th> --><th>单价</th><!-- <th>操作</th> -->
                    </tr>
                    <c:forEach items="${flcpList }" var="f">
                     <tr class="huaguo-tr">
                    	<td>${fn:substring(f.chanpin.title,0,8) }</td>
                        <td>${f.chanpin.chanpinpinpai.pinpainame }</td>
                        <td><%=DatasManager.getChanpinYongtuById(((Chanpinorleimu)pageContext.findAttribute("f")).getChanpin().getChanpinid()) %> </td>
                        <td>${f.leimu.name } </td>
                        <!-- <td>40kg</td> -->
                        <td style="color:#ff6c00;">${f.chanpin.jiage }元/${f.chanpin.unit }</td>
                        <!-- <td><a href="#">下单</a></td> -->
                        <td></td>
                     </tr>
                    </c:forEach>
                    
                    
                </table>
            </div>
            <!--Zhong内容-->
         
             <div class="FenleiMod_Right">
                <div id="cen_right_top">
                    <h3 class="active">肥料企业排行榜</h3>
                    <h3>产品关注排行</h3>
                
                    <div class="Fenlei-Right-Cnt" style="display:block">
                        <p>
                           <c:forEach items="${List1 }" var="f" varStatus="s">
                        	<i class="txt-Cnt-Title"><em <c:if test="${s.index+1==1 or s.index+1==2 or s.index+1==3 }"> class="PaiHangte" </c:if>>${s.index+1 }</em><a href="http://q${f.dianpu.htmlid}.nz101.com/">${f.dianpu.dianpuname }</a></i>	
                           </c:forEach>
                            
                        </p>
                    </div>
                   <div class="Fenlei-Right-Cnt2">
                        <p>
                        	<i class="txt-Cnt-Title"><em>4</em><a href="#">金养地</a><b>月销：5000袋</b></i>	
                            <i class="txt-Cnt-nei">
                                <em class="em1-2 e-Shangsheng" style="display:none;">377.92%<b style="margin-left:5px;">↑</b></em>
                                <em class="em1-2 e-Xia">377.92%<b style="margin-left:5px; color:#00833c;">↓</b></em>
                            </i>
                        </p>
                    </div> 
                </div>
                
            </div> 
            <div class="clear"></div>
        </div>
        <!--第一层-->
        
        <div class="Gunggao4" style=" width:1190px; margin:0px auto; height:90px; background:url(/resources/images/1190-1.jpg) no-repeat; margin-top:20px;"></div>
        
        <div class="FenleiMod Fl1">
        	<div class="FenleiMod_title">
            	<h3>农药</h3>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="FenleiMod_left">
           	  	<div class="wrap af4">
                    <ul class="slidebox">
                        <li><a href="#"><img src="/resources/images/nongyao-1.jpg" /></a></li>
                         <li><a href="#"><img src="/resources/images/nongyao-2.jpg" /></a></li>
                          <li><a href="#"><img src="/resources/images/nongyao-3.jpg" /></a></li>
                           <li><a href="#"><img src="/resources/images/nongyao-4.jpg" /></a></li>
                    </ul>
                </div>
            </div>
            <!--leftbanner-->
            
            <div class="FenleiMod_Zhong">
            	<table cellpadding="0" cellspacing="0">
                	<tr>
                    	<th>商品名称</th>
                        <th>商品品牌</th>
                        <th>商品用途</th>
                        <th>类别</th>
                      <!--   <th>剂型</th>
                        <th>净含量</th> -->
                        <th>单价</th>
                      <!--   <th>操作</th> -->
                    </tr>
                   <c:forEach items="${nycpList }" var="n">
                    <tr class="huaguo-tr">
                    	<td>${fn:substring(n.chanpin.title,0,8) }</td>
                        <td>${n.chanpin.chanpinpinpai.pinpainame }</td>
                        <td><%=DatasManager.getChanpinYongtuById(((Chanpinorleimu)pageContext.findAttribute("n")).getChanpin().getChanpinid()) %> </td>
                        <td>${n.leimu.name }</td>
                        <!-- <td>水剂</td>
                        <td>40kg</td> -->
                        <td style="color:#ff6c00;">${n.chanpin.jiage }元/${n.chanpin.unit }</td>
                        <!-- <td><a href="#">下单</a></td> -->
                    </tr>
                   </c:forEach>
                </table>
            </div>
            <!--Zhong内容-->
         
         <div class="FenleiMod_Right">
                <div id="cen_right_top2">
                    <h3 class="active">农药企业排行榜</h3>
                    <h3>产品关注排行</h3>
                    <div class="Fenlei-Right-Cnt" style="display:block">
                        <p>
                          <c:forEach items="${List2 }" var="n" varStatus="s">
                        	<i class="txt-Cnt-Title"><em <c:if test="${s.index+1==1 or s.index+1==2 or s.index+1==3 }"> class="PaiHangte" </c:if>>${s.index+1 }</em><a href="http://q${n.dianpu.htmlid}.nz101.com/">${n.dianpu.dianpuname }</a></i>	
                          </c:forEach>
                        </p>
                    </div>
                     <div class="Fenlei-Right-Cnt2">
                        <p>
                        	<i class="txt-Cnt-Title"><em>4</em><a href="#">金养地</a><b>月销：5000袋</b></i>	
                            <i class="txt-Cnt-nei">
                                <em class="em1-2 e-Shangsheng" style="display:none;">377.92%<b style="margin-left:5px;">↑</b></em>
                                <em class="em1-2 e-Xia">377.92%<b style="margin-left:5px; color:#00833c;">↓</b></em>
                            </i>
                        </p>
                    </div> 
                </div>
                
            </div>
            <div class="clear"></div>
        </div>
        
        <div class="Gunggao4" style=" width:1190px; margin:0px auto; height:90px; background:url(/resources/images/1190-2.jpg) no-repeat; margin-top:20px;"></div>
        
        <div class="FenleiMod Fl1">
        	<div class="FenleiMod_title">
            	<h3>种子</h3>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="FenleiMod_left">
            	<div class="wrap af5">
                    <ul class="slidebox">
                        <li><a href="#"><img src="/resources/images/zhongzi-1.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/zhongzi-2.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/zhongzi-3.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/zhongzi-4.jpg" /></a></li>
                    </ul>
                </div>
            </div>
            <!--leftbanner-->
            
            <div class="FenleiMod_Zhong">
            	<table cellpadding="0" cellspacing="0">
                	<tr>
                    	<th>商品名称</th>
                        <th>商品品牌</th>
                        <th>商品用途</th>
                        <th>类别</th>
                       <!--  <th>净含量</th> -->
                        <th>单价</th>
                       <!--  <th>操作</th> -->
                    </tr>
                      <c:forEach items="${zzcpList }" var="c">
                      <tr class="huaguo-tr">
                    	<td>${fn:substring(c.chanpin.title,0,8) }</td>
                        <td>${c.chanpin.chanpinpinpai.pinpainame }</td>
                        <td><%=DatasManager.getChanpinYongtuById(((Chanpinorleimu)pageContext.findAttribute("c")).getChanpin().getChanpinid()) %></td>
                        <td>${c.leimu.name }</td>
                        <!-- <td>40kg</td> -->
                        <td style="color:#ff6c00;">${c.chanpin.jiage }元/${c.chanpin.unit }</td>
                        <!-- <td><a href="#">下单</a></td> -->
                       </tr>
                      </c:forEach>
                    
                </table>
            </div>
            <!--Zhong内容-->
         
           <div class="FenleiMod_Right">
                <div id="cen_right_top3">
                   <h3 class="active">种子企业排行榜</h3>
                    <h3>产品关注排行</h3>
                    <div class="Fenlei-Right-Cnt" style="display:block">
                        <p>
                        	 <c:forEach items="${List3 }" var="n" varStatus="s">
                        	<i class="txt-Cnt-Title"><em <c:if test="${s.index+1==1 or s.index+1==2 or s.index+1==3 }"> class="PaiHangte" </c:if>>${s.index+1 }</em><a href="http://q${n.dianpu.htmlid}.nz101.com/">${n.dianpu.dianpuname }</a></i>	
                          </c:forEach>
                        </p>
                    </div>
                    <div class="Fenlei-Right-Cnt2">
                        <p>
                        	<i class="txt-Cnt-Title"><em>4</em><a href="#">金养地</a><b>月销：5000袋</b></i>	
                            <i class="txt-Cnt-nei">
                                <em class="em1-2 e-Shangsheng" style="display:none;">377.92%<b style="margin-left:5px;">↑</b></em>
                                <em class="em1-2 e-Xia">377.92%<b style="margin-left:5px; color:#00833c;">↓</b></em>
                            </i>
                        </p>
                    </div> 
                </div>
            </div> 
            <div class="clear"></div>
        </div>
        
        <div class="Gunggao4" style=" width:1190px; margin:0px auto; height:90px; background:url(/resources/images/1190-3.jpg) no-repeat; margin-top:20px;"></div>
        
        <div class="FenleiMod Fl1">
        	<div class="FenleiMod_title">
            	<h3>农机</h3>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="FenleiMod_left">
            	<div class="wrap af6">
                    <ul class="slidebox">
                        <li><a href="#"><img src="/resources/images/nongji-1.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongji-2.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongji-3.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongji-4.jpg" /></a></li>
                    </ul>
                </div>
            </div>
            <!--leftbanner-->
            
            <div class="FenleiMod_Zhong">
            	<table cellpadding="0" cellspacing="0">
                	<tr>
                    	<th>商品名称</th>
                        <th>商品品牌</th>
                        <th>商品用途</th>
                        <th>类别</th>
                       <!--  <th>额定功率</th> -->
                        <th>单价</th>
                        <!-- <th>操作</th> -->
                    </tr>
                      <c:forEach items="${njcpList }" var="n">
                     <tr class="huaguo-tr">
                    	<td>${fn:substring(n.chanpin.title,0,8 )}</td>
                        <td>${n.chanpin.chanpinpinpai.pinpainame }</td>
                        <td><%=DatasManager.getChanpinYongtuById(((Chanpinorleimu)pageContext.findAttribute("n")).getChanpin().getChanpinid()) %></td>
                        <td>${n.leimu.name }</td>
                       <!--  <td>80kw/h</td> -->
                        <td style="color:#ff6c00;">${n.chanpin.jiage }元/${n.chanpin.unit }</td>
                       <!--  <td><a href="#">下单</a></td> -->
                    </tr>
                    </c:forEach>
                    
                </table>
            </div>
            <!--Zhong内容-->
         
          <div class="FenleiMod_Right">
                
                <div id="cen_right_top4">
                    <h3 class="active">农机企业排行榜</h3>
                    <h3>产品关注排行</h3>
                    <div class="Fenlei-Right-Cnt" style="display:block">
                        <p>
                        	 <c:forEach items="${List4 }" var="n" varStatus="s">
                        	<i class="txt-Cnt-Title"><em <c:if test="${s.index+1==1 or s.index+1==2 or s.index+1==3 }"> class="PaiHangte" </c:if>>${s.index+1 }</em><a href="http://q${n.dianpu.htmlid}.nz101.com/">${n.dianpu.dianpuname }</a></i>	
                          </c:forEach>
                        </p>
                    </div>
                     <div class="Fenlei-Right-Cnt2">
                        <p>
                        	<i class="txt-Cnt-Title"><em>4</em><a href="#">金养地</a><b>月销：5000袋</b></i>	
                            <i class="txt-Cnt-nei">
                                <em class="em1-2 e-Shangsheng" style="display:none;">377.92%<b style="margin-left:5px;">↑</b></em>
                                <em class="em1-2 e-Xia">377.92%<b style="margin-left:5px; color:#00833c;">↓</b></em>
                            </i>
                        </p>
                    </div> 
                </div>
                
            </div>
            <div class="clear"></div>
        </div>
        
        <div class="Gunggao4" style=" width:1190px; margin:0px auto; height:90px; background:url(/resources/images/1190-4.jpg) no-repeat; margin-top:20px;"></div>
        
        <div class="FenleiMod Fl1">
        	<div class="FenleiMod_title">
            	<h3>农膜</h3>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="FenleiMod_left">
            	<div class="wrap af7">
                    <ul class="slidebox">
                        <li><a href="#"><img src="/resources/images/nongmo-1.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongmo-2.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongmo-3.jpg" /></a></li>
                        <li><a href="#"><img src="/resources/images/nongmo-4.jpg" /></a></li>
                    </ul>
                </div>
            </div>
            <!--leftbanner-->
            
            <div class="FenleiMod_Zhong">
            	<table cellpadding="0" cellspacing="0">
                	<tr>
                    	<th>商品名称</th>
                        <th>商品品牌</th>
                        <th>商品用途</th>
                        <th>类别</th>
                       <!--  <th>净含量</th> -->
                        <th>单价</th>
                       <!--  <th>操作</th> -->
                    </tr>
                    <c:forEach items="${nmcpList }" var="n">
                    <tr class="huaguo-tr">
                    	<td>${fn:substring(n.chanpin.title,0,8) }</td>
                        <td>${n.chanpin.chanpinpinpai.pinpainame }</td>
                        <td><%=DatasManager.getChanpinYongtuById(((Chanpinorleimu)pageContext.findAttribute("n")).getChanpin().getChanpinid()) %></td>
                        <td>${n.leimu.name }</td>
                       <!--  <td>8/吨</td> -->
                        <td style="color:#ff6c00;">${n.chanpin.jiage }元/${n.chanpin.unit }</td>
                       <!--  <td><a href="#">下单</a></td> -->
                        <td></td>
                    </tr>
                    </c:forEach>
                    
                </table>
            </div>
            <!--Zhong内容-->
         
             <div class="FenleiMod_Right">
                
                <div id="cen_right_top5">
                    <h3 class="active">农膜企业排行榜</h3>
                    <h3>产品关注排行</h3>
                
                    <div class="Fenlei-Right-Cnt" style="display:block">
                        <p>
                        	 <c:forEach items="${List5 }" var="n" varStatus="s">
                        	<i class="txt-Cnt-Title"><em <c:if test="${s.index+1==1 or s.index+1==2 or s.index+1==3 }"> class="PaiHangte" </c:if>>${s.index+1 }</em><a href="http://q${n.dianpu.htmlid}.nz101.com/">${n.dianpu.dianpuname }</a></i>	
                          </c:forEach>
                        </p>
                    </div>
                   <div class="Fenlei-Right-Cnt2">
                        <p>
                        	<i class="txt-Cnt-Title"><em>4</em><a href="#">金养地</a><b>月销：5000袋</b></i>	
                            <i class="txt-Cnt-nei">
                                <em class="em1-2 e-Shangsheng" style="display:none;">377.92%<b style="margin-left:5px;">↑</b></em>
                                <em class="em1-2 e-Xia">377.92%<b style="margin-left:5px; color:#00833c;">↓</b></em>
                            </i>
                        </p>
                    </div>
                </div>
                
            </div>
            <div class="clear"></div>
        </div>
        
         <div class="Guangao4" style="width:1190px; margin:0px auto; height:90px;margin-top:20px;">
    	<div class="Guang_Lefi_img" style="float:left;"><img src="/resources/images/11901-3.jpg" alt="广告图" /> </div>
    	<div class="Guang_right_img" style="float:right;"><img src="/resources/images/11901-4.jpg" alt="广告图" /></div>
    	<div class="clear"></div>
    </div>
        
    </div>
    
    <!--分类结束-->
    
    <div class="HangyeZx">
    	<div class="HangyeZx-title">
        	<h3>行业资讯</h3>
        </div>
        
        <div class="HangyeMod HYCnt1" style="margin-left:0px;">
        	<div class="HangyeModtitle">
            	<p>行业新闻</p>
                <a href="http://nzn.nz101.com/hyxw/">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
             <c:forEach items="${hangyenews }" var="h" begin="0" end="0">
            	<a href="#"><img src="${h.newsimg }" /></a>
             </c:forEach>
            </div>
            <div class="HangyeModTxt">
             <c:forEach items="${hangyenews }" var="h" begin="0" end="0" >
            	<p style="color:#2b2b2b;">${fn:substring(h.title,0,12) }</p>
                <p class="txt-p-cnt">${fn:substring(h.description,0,20) }...<a href="#">[查看更多]</a></p>
             </c:forEach>
             <c:forEach items="${hangyenews }" var="h" begin="1" end="2" >
                <p class="txt-p-shulie" style="text-align:left;"><a href="#"><em></em><i>${fn:substring(h.title,0,12) }</i></a><div  class="clear"></div></p>
             </c:forEach>
            </div>
        </div>
        <div class="HangyeMod HYCnt1" >
        	<div class="HangyeModtitle">
            	<p>产品价格</p>
                <a href="http://nzn.nz101.com/cpjg/">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
              <c:forEach items="${jiagenews }" var="n" begin="0" end="0" >
            	<a href="#"><img src="${fn:substring(n.title,0,12) }" /></a>
              </c:forEach>
            </div>
            <div class="HangyeModTxt">
              <c:forEach items="${jiagenews }" var="n" begin="0" end="0" >
            	<p style="color:#2b2b2b;">${fn:substring(n.title,0,12) }</p>
                <p class="txt-p-cnt">${fn:substring(n.description,0,20) }...<a href="#">[查看更多]</a></p>
              </c:forEach>
              <c:forEach items="${jiagenews }" var="n" begin="1" end="2" >
                <p class="txt-p-shulie" style="text-align:left;">
                	<a href="#"><em></em><i>${fn:substring(n.title,0,12) }</i><div class="clear"></div></a>
                </p>
              </c:forEach>
            </div>
        </div>
        <div class="HangyeMod HYCnt1">
        	<div class="HangyeModtitle">
            	<p>农资知识</p>
                <a href="http://nzn.nz101.com/nzzs/">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
              <c:forEach items="${zhishinews }" var="n" begin="0" end="0">
            	<a href="#"><img src="${n.newsimg }" /></a>
              </c:forEach>
            </div>
            <div class="HangyeModTxt">
             <c:forEach items="${zhishinews }" var="n" begin="0" end="0">
            	<p style="color:#2b2b2b;">${fn:substring(n.title,0,10)  }</p>
                <p class="txt-p-cnt">${fn:substring(n.description,0,20) }...<a href="#">[查看更多]</a></p>
             </c:forEach>
             <c:forEach items="${zhishinews }" var="n" begin="1" end="2">
                <p class="txt-p-shulie" style="text-align:left;"><a href="#"><em></em><i>${fn:substring(n.title,0,12) }</i></a><div class="clear"></div></p>
             </c:forEach>
            </div>
        </div>
        <div class="HangyeMod HYCnt1">
        	<div class="HangyeModtitle">
            	<p>政策法规</p>
                <a href="http://nzn.nz101.com/zcfg/">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
             <c:forEach items="${faguinews }" var="n" begin="0" end="0">
            	<a href="#"><img src="${n.newsimg }" /></a>
             </c:forEach>
            </div>
            <div class="HangyeModTxt">
               <c:forEach items="${faguinews }" var="n" begin="0" end="0">
            	<p style="color:#2b2b2b;">${fn:substring(n.title,0,12) }</p>
                <p class="txt-p-cnt">${fn:substring(n.description,0,20) }...<a href="#">[查看更多]</a></p>
               </c:forEach>
               <c:forEach items="${faguinews }" var="n" begin="1" end="2">
                <p class="txt-p-shulie" style="text-align:left;"><a href="#"><em></em><i>${fn:substring(n.title,0,12) }</i><div class="clear"></div></a></p>
               </c:forEach>
            </div>
        </div>
        <div class="HangyeMod HYCnt1">
        	<div class="HangyeModtitle">
            	<p>农资学院</p>
                <a href="http://nzn.nz101.com/nsxy/">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
              <c:forEach items="${xueyuannews }" var="n" begin="0" end="0">
            	<a href="#"><img src="${n.newsimg }" /></a>
              </c:forEach>
            </div>
            <div class="HangyeModTxt">
              <c:forEach items="${xueyuannews }" var="n" begin="0" end="0">
            	<p style="color:#2b2b2b;">${fn:substring(n.title,0,12) }</p>
              </c:forEach>
              <c:forEach items="${xueyuannews }" var="n" begin="1" end="4" varStatus="s">
                <p class="txt-p-shulie" <c:if test="${s.index==0 }">style="padding-top:5px;text-align:left;"</c:if> ><a href="#"><em></em><i>${fn:substring(n.title,0,12) }</i><div class="clear"></div></a></p>
              </c:forEach>
            </div>
        </div>
        <div class="HangyeMod HYCnt1">
        	<div class="HangyeModtitle">
            	<p>热门专题</p>
                <a href="#">查看更多></a>
                <div class="clear"></div>
            </div>
            <div class="HangyeModimg">
             <c:forEach items="${zhuantinews }" var="z" begin="0" end="0">
            	<a href="#"><img src="${z.imgsrc }" /></a>
             </c:forEach>
            </div>
            <div class="HangyeModTxt">
             <c:forEach items="${zhuantinews }" var="z" begin="0" end="0">
            	<p style="color:#2b2b2b;">${fn:substring(z.zhuantiname,0,12) }</p>
             </c:forEach>
             <c:forEach items="${zhuantinews }" var="z" begin="1" end="4" varStatus="s">
                <p class="txt-p-shulie" <c:if test="${s.index==0 }">style="padding-top:5px;text-align:left;"</c:if> ><a href="#"><em></em><i>${fn:substring(z.zhuantiname,0,12) }</i><div class="clear"></div></a></p>
             </c:forEach>
            </div>
        </div>
        <div class="clear"></div>
        
    </div>
    
    <div class="Youqing">
    	<div class="YouqingTitle">
        	<h3>友情链接</h3>
        </div>
        <div class="YouqingTxt">
        	<a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a>
            <a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a><a href="#">中药材</a>
            <div class="clear"></div>
        </div>
    </div>
     <jsp:include page="/website/gotoFoot" />
 
  </body>
</html>
