<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>发票管理</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/guanzhu.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/mycart.js"></script>
<script src="/resources/js/membercare.js"></script>

  </head>
  <body>
 <div class="topline">
    <div class="top">
        <div id="topleft" class="topleft">
        	<a href="#" target="_blank" style=" float:left; margin-right:5px;">18639902393</a>
            <a class="dengluw" style="margin-left:10px;" href="#">退出</a>
        </div>

        <div class="topright">
            <a id="a_index" href="#" class="denglu">101农资网首页</a>
            <span class="xianxian">|</span>
            <a id="a_myorder" href="#" class="denglu">我的订单</a>
            <span class="xianxian">|</span>

            <span id="s_xht" class="xianxiana" style="width:88px;">
                <a id="a_xht" class="wode" href="#">现货通服务</a>
                <img id="i_xht" src="/resources/images/top_xia2.png" width="7" height="4" style="margin-top: 15px; float: left;">
                <div id="d_xht" class="kuangr" style="width: 88px; display: none;">
                    <p><a href="#">加入现货通</a> </p>
                    <p><a href="#">套餐办理</a> </p>
                    <p><a href="#">老客户续费</a> </p>
                </div>
            </span>
            <span class="xianxian ">|</span>
            <span id="s_service" class="xianxiana" style="width: 79px;">
                <a id="a_service" href="#" style="float: left; margin-left: 9px; margin-right: 5px; line-height: 35px;">客户服务</a>
                <img id="i_service" src="/resources/images/top_xia2.png" width="7" height="4" style="float: left; margin-top: 15px;">
                <div id="d_service" class="kuangr" style="width: 79px; top: 28px; height: auto; float: left; display: none">
                    <p>
                        <a href="#" target="_blank">商家入驻</a>
                    </p>
                    <p><a href="#">帮助中心 </a></p>
                    
                    <p><a href="#" target="_blank" class="online qqoffline zxkf">在线客服</a></p>
                    <p><a href="#">投诉中心</a> </p>
                    <p><a href="#">客服邮箱</a> </p>
                </div>
            </span>

        </div>
    </div>
</div>
<div class="nav">
        <div class="nav_m">
            <div class="logo"><a target="_blank" href="#"><img src="/resources/images/hyzx_logo.png"></a></div>
            <div class="nav_r">
                <a href="#" class="wdhyzx">我的会员中心</a>
                <span class="z_line"></span>
                <a target="_blank" href="#">首页</a>
                <a target="_blank" href="#">现货商城</a>
                <a target="_blank" href="#">我的服务</a>
                <a href="#">完善采购信息</a></div>
            </div>
        </div>
    <div class="main" style="margin-bottom:25px;">

<div class="main_l">
            <div class="main_lo">
                <div class="left_tit left_tit2">账户中心</div>
                <div class="l_list">
                    <ul>
                        <li class=""><a href="#">个人信息</a></li>
                        <li class=""><a href="#">公司信息</a></li>
                        <li class="l_list_Dangqian"><a href="#">账户安全</a></li>
                        <li class=""><a href="#" class="f_l">我的资产</a><span class="new"></span></li>
                        <li class=""><a href="#" class="f_l">免费开店</a><span class="new"></span></li>
                        <li class=""><a href="#">我的积分</a></li>
                        <li class=""><a href="#">积分兑换记录</a></li>
                    </ul>
                </div>
            </div>
        
            <div class="main_lo">
                <div class="left_tit left_tit2">我是买方</div>
                <div class="l_list">
                    <ul>
                        <li class=""><a href="#">已买到的现货</a></li>
                        <li class=""><a href="#">购物车</a></li>
                        <li class=""><a href="#">我的关注</a></li>
                        <li><a target="_blank" href="#" class="f_l">发布询价单</a><span class="new"></span></li>
                        <li class=""><a href="#">采购管理</a></li>
                        <li class=""><a href="#">收货地址管理</a></li>
                        <li class=""><a href="#">发票管理</a></li>
                    </ul>
                </div>
            </div>
        
        
            <div class="main_lo">
                <div class="left_tit left_tit2">消息管理</div>
                <div class="l_list">
                    <ul>
                        <li class=""><a href="#">我的消息</a></li>
                        <li class=""><a href="#">浏览历史</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="main_r" style="width:905px; min-height:700px;">
<script type="text/javascript">
$(function () {
initCare();
});
</script>
                <div class="righta"><p class="r_tit">我的关注</p></div>


<table style="color:#666666; margin-top:18px; margin-left:22px;" width="859" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr style="">
        <td width="100" height="30" align="center" bgcolor="#FFFFFF" style=" border:1px solid #dddddd;color:#2291dc; border-top:2px solid #2291dc">关注的商品</td>
        <td width="100" height="32" align="center" bgcolor="#FFFFFF" style="background-color:#FFFFFF; color:#303030; border-bottom:1px solid #dddddd;">
            <a style="color:#4c4c4c;" href="#">关注的店铺</a>
        </td>
        <td colspan="7" bgcolor="#FFFFFF" style=" border-bottom:1px solid #dddddd">&nbsp;</td>
    </tr>




</tbody></table>
<div class="xiangqingf find" style="margin-left:22px;">
    <div class="find1"><input type="checkbox" id="ck_all1" name="ck_all">&nbsp;全选</div>
    <div class="find2">  </div>
    <div class="find4" style="margin-top:8px;">
        <a class="jhd" id="bnt_addorder" style="cursor:pointer;">
            加入购物车
        </a>
        <a class="qxdp" id="bnt_cancelcare" style="cursor:pointer;">取消关注</a>
    </div>

    <div class="find10">
        <input placeholder="输入品名" style="width:179px; height:30px; border:1px solid #ddd; padding-left:3px;" type="text" id="Pm" name="Pm">
        <input type="button" class="sousuu" style="margin-left:-5px; background:#FF9900; border:0px; width:50px; height:32px; cursor:pointer;color:white;font-family:" microsoft="" yahei","微软雅黑";"="" id="bnt_search" value=" 搜 索 ">
    </div>


</div>
<table style="width:859px;margin-left:22px;" class="gz_tab" width="857" border="0" cellspacing="0" cellpadding="0">


    <tbody><tr>
        <td height="33" align="center" bgcolor="#FFFFFF">品名</td>
        <td width="50" align="center" bgcolor="#FFFFFF">交货地</td>
        <td width="162" align="center" bgcolor="#FFFFFF"> 供应商   </td>
        <td width="81" align="center" bgcolor="#FFFFFF"> 现货重量  </td>
        <td width="108" align="center" bgcolor="#FFFFFF"> 当前价格    </td>
        <td width="80" align="center" bgcolor="#FFFFFF"> 上次价格    </td>
        <td width="118" align="center" bgcolor="#FFFFFF">   操作  </td>
    </tr>

        <tr>
            <td colspan="7" style="text-align: center; font-size: 15px;">
                <div class="nothing" style="line-height:36px;">您的搜索暂无数据！</div>
            </td>
        </tr>
</tbody></table>

<div class="xiangqingf find" style="margin-left:22px; margin-bottom:20px;">

    
</div>
        
        
        </div>
    </div>
    <div class="clear"></div>
    
<div class="help">
    <div class="help_des">
        <div>
            <ul class="mai">
                <span class="mai_i01"></span>
                <li class="lihead">我要买农药</li>
                <li><a href="#">快速找货</a></li>
                <li><a href="#">下订单</a></li>
                <li><a href="#">买家采购流程</a></li>
                <li><a href="#">发布采购招标 </a></li>
                <li><a href="#">如何支付</a></li>
            </ul>
        </div>
        <div>
            <ul class="mai">
                <span class="mai_i02"></span>
                    <li class="lihead">我要卖农药</li>
                    <li><a href="#">发布现货资源</a></li>
                    <li><a href="#">卖家交易流程</a></li>
                    
                    <li><a href="#">如何给买家报价</a></li>
                    <li><a href="#">无障碍提现流程</a></li>
                </ul>
</div>
        <div>
            <ul class="mai">
                <span class="mai_i03"></span>
                <li class="lihead">账户服务</li>
                <li><a href="#">用户注册</a></li>
                <li><a href="#">找回密码途径</a></li>
                <li><a href="#">账户认证</a></li>
                <li><a href="#">多用户登录 </a></li>
                
            </ul>
        </div>
        <div>
            <ul class="mai">
                <span class="mai_i04"></span>
                <li class="lihead">常见问题</li>
                <li><a href="#">无法注册</a></li>
                <li><a href="#">什么是担保交易</a></li>
                <li><a href="#">交易纠纷处理</a></li>
                <li><a href="#">联系客服</a></li>
                <li><a href="#">进入帮助中心</a></li>
            </ul>
        </div>
        <div style="width:233px;">
            <ul>
                <li style=" padding-left:0px;margin-left:32px;" class="lihead">我要买农药</li>
                <li style=" padding-left:15px;margin-left:32px; font-size:14px;" class="kfphone"></li>
                <li style=" padding-left:0px;margin-left:32px;font-size:14px;">服务热线 : 400-700-8508</li>
                <li style="height:106px; padding-left:0px; margin-left:14px;"><span class="long"></span><img style="margin-left:9px;" src="/resources/images/weixin.png" width="98" height="98"></li>

            </ul>
        </div>
    </div>
</div>
<div class="footer" style="background-color:white;">
	<div class="f_nav">
		<a href="#" rel="nofollow">关于我们</a>|
		<a href="#" rel="nofollow">联系我们</a>|
		<a href="#" rel="nofollow">广告服务</a>|
		<a href="#" rel="nofollow">商家入驻</a>|
		<a href="#" rel="nofollow">商会联盟</a>|
		<a href="#" target="_blank" rel="nofollow">友情链接</a>|
		<a href="#" target="_blank" rel="nofollow">101农资公益</a>|
		<a href="#" target="_blank" rel="nofollow">网站地图</a>
		<a href="#" rel="nofollow" style="display:none;">商会联盟管理</a>
	</div>
</div>
<div class="footter" id="jiao" style="background-color:white;">
	<p> Copyright&nbsp;©&nbsp;2005 - 2015 101农资网 All Rights Reserved</p>
	<p>
		<span style=" color:#ff8800">全国咨询/投诉电话：400-700-8508 </span>   E-mail：kf@steelcn.com <a href="#" target="_blank" style="color:#8a8a8a" rel="nofollow">
			豫ICP备 14018983号 
		</a>
	</p>
    <!--添加底部-->
</div>
  </body>
</html>
