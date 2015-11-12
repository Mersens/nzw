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
<link href="/resources/css/fapiao.css" rel="stylesheet"/>
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="/resources/text/javascript" src="js/jquery.reveal.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/huiyantx.js"></script>
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
        <div class="right">
            <p class="r_tit">修改已验证手机</p>
                 <!--未认证-->
        <div class="fpgl">
        <!--发票列表选项卡头部（开始）-->
            <ul class="fpgl_t">
           	 	<li class="cur"><a href="#">增值发票</a></li>
            	<li><a href="#">普通发票</a></li>
            </ul>
            <!--发票列表选项卡头部（结束）-->
            <input type="hidden" id="itype" value="0">
            <!--普通发票列表内容(开始)-->
            <div class="ptfp_m">
           	 <!--无数据时提示-->
            <div class="nxx">
              抱歉，你目前暂无维护的普通发票信息，请尽快维护
            </div>
           		 <a class="add_fp" data-reveal-id="myModal">添加</a>
                 <div id="myModal" class="reveal-modal3">
                    <div class="reveal-modal-title">
                    	<p>增值发票信息</p>
                        <a class="close-reveal-modal"></a>
                    </div>
                    <div class="reveal-con">
                        <div class="zzfp_tc">
                  <div class="fptc_t">
                  </div>
                  <div class="fptc_zs">注：请认真填写下述信息，确保您所填写的开票信息与贵公司税务登记证信息一致，避免因开票信息错误给贵公司带来损失！</div>
                  <div class="fp_m" style="width:500px;">
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>单位名称：</div>
                          <div class="fp_right"><input type="text" maxlength="30" name="InvoiceInfo" placeholder="请输入单位名称"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>纳税人识别号：</div>
                          <div class="fp_right"><input type="text" maxlength="30" name="InvoiceFaxNo" placeholder="请输入纳税人识别号"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>注册地址：</div>
                          <div class="fp_right"><input type="text" name="InvoiceRegAddress" placeholder="请输入注册地址"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>注册电话：</div>
                          <div class="fp_right"><input type="text" maxlength="20" name="InvoiceRegTel" placeholder="电话，如0371-8888888、8888888"><span class="err_tip" id="sp_regtel"></span> </div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>开户银行：</div>
                          <div class="fp_right"><input type="text" name="InvoiceBankName" placeholder="请输入开户银行"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>银行账户：</div>
                          <div class="fp_right"><input type="text" maxlength="30" name="InvoiceAccountNo" placeholder="请输入银行账户"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>发票收件人姓名：</div>
                          <div class="fp_right"><input type="text" maxlength="30" name="InvoiceName" placeholder="姓名，如张三、Lily"></div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>发票收件人电话：</div>
                          <div class="fp_right"><input type="text" maxlength="20" name="InvoiceTel" placeholder="请输入正确的11位手机号"><span class="err_tip" id="sp_tel"></span> </div>
                      </div>
                      <div class="fp_m1">
                          <div class="fp_left"><span>*</span>发票寄送地址：</div>
                          <div class="fp_right"><input type="text" name="InvoiceAddress" placeholder="如：滨江开发区丽水大街"></div>
                      </div>
                  </div>
                  <center>
                      <input type="submit" class="bcfpxx" value="保存发票信息"><span id="sp_msg" style="color:red;"></span>
                  </center>
              </div>
                    </div>
                </div>
               
            </div>
            <!--普通发票列表内容(结束)-->
        
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
