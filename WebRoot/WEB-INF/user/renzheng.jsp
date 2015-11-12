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
<link href="/resources/css/jquery-ui-1.9.2.custom.css" rel="stylesheet" />
<link href="/resources/css/qye.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/layer.min.js"></script>
<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
<script src="/resources/js/h.js" type="text/javascript"></script>
<script src="/resources/js/Tianxie.js" type="text/javascript"></script>

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
                <img id="i_xht" src="/resources/images/top_xia2.png" width="7" height="4" style="margin-top: 15px; float: left;"/>
                <div id="d_xht" class="kuangr" style="width: 88px; display: none;">
                    <p><a href="#">加入现货通</a> </p>
                    <p><a href="#">套餐办理</a> </p>
                    <p><a href="#">老客户续费</a> </p>
                </div>
            </span>
            <span class="xianxian ">|</span>
            <span id="s_service" class="xianxiana" style="width: 79px;">
                <a id="a_service" href="#" style="float: left; margin-left: 9px; margin-right: 5px; line-height: 35px;">客户服务</a>
                <img id="i_service" src="/resources/images/top_xia2.png" width="7" height="4" style="float: left; margin-top: 15px;" />
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
<script src="js/qqkefu.js"></script>
<div class="nav">
        <div class="nav_m">
            <div class="logo"><a target="_blank" href="#"><img src="/resources/images/hyzx_logo.png" /></a></div>
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
                        <li class="l_list_Dangqian"><a href="#">公司信息</a></li>
                        <li class=""><a href="#">账户安全</a></li>
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
        <div class="right">
            <p class="r_tit">企业认证</p>
                 <!--未认证-->
                <div class="qiye" style="display:none;">
                    <div class="qiye_left" style="width:200px; font-size:18px; color:#333;">
                        <img style="margin-right:6px;" src="/resources/images/rz_wrz.png" />企业资料认证
                        <img style="margin-left:6px;margin-right:6px;" src="/resources/images/rz_img.png" />
                    </div>
                    <div class="qiye_center" style="width:460px;">
                        <p style="line-height: 20px; color:#999; font-size:12px; border-bottom:none; margin-top:8px; margin-left:20px;">
                            <span style=" color:#414141;line-height: 24px; font-size:14px; font-weight:bold;">完成认证，增加信任</span><br/>
                            完成认证可以增加交易对象对您的信任度，也是中钢网在线交易<br>的基础工作。
                                <span class="red" style=" font-weight:normal;">未认证</span>
                        </p>
                    </div>
                    <div class="qiye_right" style=" float:left">
                        <input name="button" type="button" class="rzpq" style=" "  value="我要认证">
                    </div>
                </div>
                
                <div class="qiye" style="height:90px;">
            <div class="qiye_left" style="width:80px; font-size:18px; color:#333; border-right:none;">
            	<img style="margin-right:6px;width:50px;height:50px;" src="/resources/images/rz_shz.png" /></div>
            <div class="qiye_center" style="width:740px; margin-bottom:12px;">
                <p style="line-height: 24px; color:#333; width:740px; border-bottom:none; margin-top:8px; margin-left:20px; position:relative;">
                    <span style=" color:#ff4400;line-height: 24px; font-size:14px; font-weight:bold;">正在审核中：</span><br/>
                    您的认证资料已经提交成功，中钢网客服将在1-2个工作日内进行处理，请您耐心等待，如您急需认证可点此直接<br>联系客服
                    <a style="position:absolute; left:57px; top:47px;" href="#" qq="4007008508" target="_blank" onclick="QQPanel()" class="qqoffline" title="中钢网客服" >
                     <img width="73" height="22" src="/resources/images/kef1-h2.png" />  
                    </a>
                    <span style="margin-left:80px;">或致电：<span style="color:#ff4400">400-700-8508</span></span>
                        <span class="red" style=" font-weight:normal; display:none;">正在审核认证</span>
                </p>
            </div>
        </div>
                
                
                
                <div class="qiye" style="display:none;">
                    <div class="qiye_left" style="width:200px; font-size:18px; color:#333;">
                        <img style="margin-right:6px;" src="/resources/images/rz_wrz.png" />企业资料认证
                        <img style="margin-left:6px;margin-right:6px;" src="/resources/images/rz_img.png"/>
                    </div>
                    <div class="qiye_center" style="width:460px;">
                        <p style="line-height: 20px; color:#999; font-size:12px; border-bottom:none; margin-top:8px; margin-left:20px;">
                            <span style=" color:#414141;line-height: 24px; font-size:14px; font-weight:bold;">完成认证，增加信任</span><br>
                            完成认证可以增加交易对象对您的信任度，也是中钢网在线交易<br/>的基础工作。
                                <span class="red" style=" font-weight:normal; color:#0eb306">已认证</span>
                        </p>
                    </div>
                    <div class="qiye_right" style=" float:left">
                        <input name="button" type="button" class="rzpq" style=" "  value="修改信息" />
                    </div>
                </div>
                
        
        
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
                <li style="height:106px; padding-left:0px; margin-left:14px;"><span class="long"></span><img style="margin-left:9px;" src="/resources/images/weixin.png" width="98" height="98" /></li>

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
