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
<link href="/resources/css/order.css" rel="stylesheet"/>
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>

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
                <img id="i_service" src="/resources/images/top_xia2.png" width="7" height="4" style="float: left; margin-top: 15px;"/>
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
            <div class="logo"><a target="_blank" href="#"><img src="/resources/images/hyzx_logo.png"/></a></div>
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
        <div class="dd_mr">
    <div class="ssdd">
        <div class="ssdd_t">
            <p class="r_tit">搜索订单</p>
            <div class="ssdd_tr"></div>
        </div>
<form action="./我的订单_订单中心_买家中心 - 中钢网_files/我的订单_订单中心_买家中心 - 中钢网.html" method="get">            <div class="ssdd_m">
                <div class="ssdd_ml">
                    <span class="ssdd_ml01">
                        <span>交易流水号：</span><input id="orderno" name="orderno" type="text" value="">
                    </span>
                    <span class="ssdd_ml01">
                        <span>卖方公司名：</span><input id="compname" name="compname" type="text" value="">
                    </span>
                    <span class="ssdd_ml01" style="width:880px;">
                        <span style="width:880px;">
                            <span>下单日期：</span><input class="riqi wdate" id="begindate" name="begindate"  type="text" value=""/>
                            <span style="width:8px;">-</span><input class="riqi wdate" id="enddate" name="enddate"  type="text" value=""/><em style="margin-left:16px;">[</em><input type="button" class="time_sx" id="time_1" onclick="bytime(1)" value="最近3天">
                            <input type="button" class="time_sx" id="time_2" onclick="bytime(2)" value="最近1周" />
                            <input type="button" class="time_sx" id="time_3" onclick="bytime(3)" value="最近1月"/><em>]</em>
                            <input type="checkbox" style="width:12px; float:none; float:left; margin-left:20px; border:none; margin-right:4px;" name="hideClose" id="hideClose"/>
                            <input type="hidden" name="timeType" id="timeType" value="0"/>
                            <label for="hideClose" style="line-height:20px; float:left;vertical-align: top;margin-top: 5px;">隐藏交易关闭订单</label>
                        </span>
                    </span>
                    <span class="ssdd_ml01" style="clear:both;width:220px;">
                        <span>交易状态：</span>
                        <select id="status" name="status"><option value="">全部</option>
<option value="0">待确认订单</option>
<option value="2">待付款订单</option>
<option value="3">待发货订单</option>
<option value="4">已发货订单</option>
<option value="5">交易成功</option>
<option value="7">交易关闭</option>
</select>
                    </span>
                    <span class="ssdd_ml01">
                        <span style="text-align:left;width:75px;">支付方式：</span>
                        <select id="payType" name="payType">
                            <option selected="selected" value="-1">全部</option>
                            <option value="0">
                                在线交易
                            </option>
                            <option value="1">其他支付方式</option>
                        </select>
                        <input type="hidden" name="payVal" id="payVal" value="-1">
                        <div class="ssdd_mr">
                            <input id="Submit1" type="submit" class="ss_but" value=" 搜 索 ">
                        </div>
                    </span>
                </div>

            </div>
</form>
    </div>
    <div class="qbdd">
        <div class="qbdd_t">

            <span class="qbdd_tr">

                <a href="#" class="choose">全部订单</a>
                <a class="num0" href="javascript:void(0);">待确认<i>0</i></a>
                <a class="num0" href="javascript:void(0);">待付款<i>0</i></a>
                <a class="num0" href="javascript:void(0);">待发货<i>0</i></a>
                <a class="num0" href="javascript:void(0);">已发货<i>0</i></a>
                <a class="num0" href="javascript:void(0);">交易成功<i>0</i></a>
                <a class="num0" href="javascript:void(0);">交易关闭<i>0</i></a>
            </span>
        </div>
        <div class="ding_t">
            <div class="ding_tit">
                <span class="pin">订单信息</span>
                <span class="jine">单价(元)</span>
                <span class="dun">订购重量</span>
                <span class="zjine">订购金额</span>
                <span class="zht">交易状态</span>
                <span class="caoz">交易操作</span>
            </div>
            <div class="piling">
                <div style="float:left; width:auto;">
                    <div style="margin-left:10px;" class="find1a"><input style="margin-right:5px;" type="checkbox" name="ck_all">全选</div>
                    <div style="width:122px;" class="find2a"> <input class="zhoa coloa" type="button" value="批量确认收货"> </div>
                </div>
                <div style="width:300px;overflow:hidden; float:right;">
                </div>
            </div>
                <table class="dd_tab">
                    <tbody>
                        <tr class="ddxx_l">
                            <td colspan="6">
                                <div class="noned">暂无订单,这就去挑选资源!<br> <a href="http://www.zgw.com/" style="color:#3673db;">商城首页&gt;&gt;</a></div>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </div>
    </div>
    <div class="piling">
        <div class="find1a"><input style="margin-right:5px;" type="checkbox" name="ck_all">全选</div>
        <div style="width:72px;" class="find2a"> <input class="zhoa coloa" type="button" value="批量确认收货"> </div>
        <div class="pageF" style="margin-right:20px;">
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
                <li style="height:106px; padding-left:0px; margin-left:14px;"><span class="long"></span><img style="margin-left:9px;" src="/resources/images/weixin.png" width="98" height="98"/></li>

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
