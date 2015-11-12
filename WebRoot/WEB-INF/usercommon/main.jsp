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
<link type="text/css" rel="stylesheet" href="/resources/css/hyzx.css" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/layer.min.js"></script>
<script src="/resources/js/huiyantx.js"></script>
<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
<script src="/resources/js/h.js" type="text/javascript"></script>
  </head>
  <body>
  <div class="topline">
    <div class="top">
        <div id="topleft" class="topleft">
        	<a href="#" target="_blank" style=" float:left; margin-right:5px;">18639902393</a>
            <a class="dengluw" style="margin-left:10px;" href="#">退出</a>
        </div>

        <div class="topright">
            <!--
            <span id="s_myzg" class="xianxiana" style="width: 88px;">
                <a id="a_myzg" class="wode" href="#">我的中钢网</a>
                <img id="i_myzg" src="./会员中心_files/top_xia2.png" width="7" height="4" style="margin-top: 15px; float: left;">
                <div id="d_myzg" class="kuangr" style="display: none">
                    <p>
                        
                        <a href="http://www.zgw.com/UCenter/Order/OrderList?status=0">待处理的订单<span id="order">(0)</span></a>
                    </p>
                    <p><a href="http://www.zgw.com/UCenter/BuyerCenter/MyCare">我的关注 </a></p>
                    <p><a href="http://www.zgw.com/UCenter/Account/UserInfo">账号管理</a> </p>
                </div>
            </span>
            <span class="xianxian">|</span>-->
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
<script src="js/qqkefu.js"></script>
    <div class="nav">
            <div class="nav_m">
                <div class="logo"><a target="_blank" href="#"><img src="/resources/images/hyzx_logo.png"></a></div>
                <div class="nav_r">
                    <a href="./会员中心_files/会员中心.html" class="wdhyzx">我的会员中心</a>
                    <span class="z_line"></span>
                    <a target="_blank" href="#">首页</a>
                    <a target="_blank" href="#">现货商城</a>
                    <a target="_blank" href="#">我的服务</a>
                    <a href="#">完善采购信息</a></div>
                </div>
            </div>
    <div class="main">

   			 <div class="main_l">
        <div class="main_lo">
            <div class="left_tit left_tit2">账户中心</div>
            <div class="l_list">
                <ul>
                    <li class=""><a href="#">个人信息</a></li>
                    <li class=""><a href="#">公司信息</a></li>
                    <li class=""><a href="#">账户安全</a></li>
                    <li class=""><a href="#" class="f_l" >我的资产</a><span class="new"></span></li>
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
        <div class="main_r" style="width:905px;">
            <div class="tcxx">
                <input type="hidden" name="tcxx" id="tcxx" value="1">
                <div class="tcxx1" style="" title="点击展开消息">
                    <img src="/resources/images/naoling_gray.png"><a href="javascript:void(0);">0</a>
                </div>
                <div class="tcxx2" style="display: none;" title="点击展开消息">
                    <div class="clock-animate">
                        <img src="/resources/images/naoling_org.png">
                        <a href="javascript:void(0);">新消息</a>
                    </div>
                </div>
                <div class="tcxx_m" style="display: none;">
                    <div class="tcxx_mm">
                        <div class="xx_tit">
                            <div class="xx_titl">消息</div>
                            <div class="xx_titr">
                                <a target="_blank" href="#">查看全部消息&gt;</a>
                                <a class="hl" target="_blank" href="#" style="display:none;">忽略全部</a>
                            </div>
                        </div>
                        <div class="xx_m">
                        <input type="hidden" name="maxid_type" id="maxid_type" value="">
   						<p style="line-height: 50px; text-align:center;">您暂时没有未读消息</p>
							<script type="text/javascript">
                                $(function () {
                                    showDeleteOrder();
                                    showDeleteSystem();
                                });
                            
                                //判断删除订单按钮是否显示
                                function showDeleteOrder() {
                                    $(".ddzt_r").each(function () {
                                        $(this).mouseover(function () {
                                            $(this).find(".xx_del").show();
                                        }).mouseout(function () {
                                            $(this).find(".xx_del").hide();
                                        });
                                    });
                                }
                            
                                //判断删除订单按钮是否显示
                                function showDeleteSystem() {
                                    $(".xx1").each(function () {
                                        $(this).mouseover(function () {
                                            $(this).find("table tbody tr td").eq(2).find("input").show();
                                        }).mouseout(function () {
                                            $(this).find("table tbody tr td").eq(2).find("input").hide();
                                        });
                                    });
                                }
                            
                                function openOrderDetail(url, id, mesType) {
                                    window.open(url);
                                    readmsg(id, mesType);
                                }
                            </script>
                       </div>
                    </div>
                    <input class="zd_but" type="button" title="收起">
                </div>

            </div>
            
<script src="js/layer.min.js"></script>
<div class="hyzx_main" style="background:#eff2f9; padding-top:14px; min-height:929px;">
    <div class="mm">
        <div class="grxx">
            <div class="gr_tx">

                <img width="80" height="80" src="/resources/images/zwtp.jpg" onerror="this.src=&#39;/images/zwtp.jpg&#39;">
                <div class="img_bg"></div>
                <a href="#" class="ghtx">更换头像</a>
            </div>
            <div class="gr_r">
                <div class="gr_rt">
                    <a href="#">18639902393</a>
                    <img src="/resources/images/vrz.png">
                    <img src="/resources/images/gs_wrz.png">
                    <span class="hy_tit">普通会员</span>
                    <a target="_blank" href="#" class="gmhy" style="">[购买会员]</a>

                    <img src="/resources/images/mre.png" width="22" height="17">
                    <div id="jifen" class="jfen">
                        <span style="color:#0265bd" title="1">当前积分:1</span>

                        <img id="jifenImg" style="display: none; position: absolute; top: 6px; left: 30px; z-index: 9999999" src="/resources/images/hy_arr.png" width="11" height="7">
                        <div id="jifeninfo" class="yjian" style="display:none;">
                            <p>已反馈建议：0条，被采纳 0条，获得积分 0分；</p>
                            <p>已举报现货：0条，被核实 0条，获得积分 0分；</p>
                            <p>中奖积分：0分</p>
                            <p>已兑换积分：0分</p>
                            <div class="quduihuan">
                                <a target="_blank" href="#">去兑换</a>

                            </div>
                        </div>
                    </div>


                    <div class="zhzt">
                        <div class="zt_arr"></div>
                        <div class="zt_m">
                            <div class="zt">
                                <ul>
                                    <li>账户状态：</li>
                                    <li class="sj_rz">
                                        <a href="#">手机已认证</a>
                                    </li>

                                    <li class="yx_rz yx_rz_mr">
                                        <a href="#">邮箱未认证</a>
                                    </li>
                                    <li class="qy_rz qy_rz_mr">
                                    	<a href="#">企业未认证</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="zh">
                                <div class="zh_tit">商鼎通账户：</div>
                                <div class="zt2">
                                    <span class="ye">可开通买家保障，赢得买家更多信赖！</span>
                                    <a href="#" class="cz mskt">马上开通</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mm_r">
            <div class="zskf">
                <img class="rq_sel" src="/resources/images/renqi.png" style="cursor:pointer;" onclick="getkf()">
                <div class="zskf_t">您的专属客服</div>
                <div class="zskf_m">
                    <img class="kf_i" width="80" height="80" src="/resources/images/20141127093529.jpg" onerror="this.src=&#39;../../images/default.jpg&#39;">
                    <div class="kf_zl">
                        <div class="kfzl_n"><span>姓  名：</span>杨北燕</div>
                        <div class="kfzl_n"><span>客  服：</span><a href="#" target="_blank" class="online qqoffline zxkf">在线客服</a></div>
                        <div class="kfzl_n"><span>电  话：</span><span style="float:left">0371-60317037</span></div>
                        <div class="kfzl_n"><span>委托她：</span><a href="javascript:void(0);" class="mfzh">人工找货</a></div>
                    </div>

                </div>
            </div>
        </div>

        <div class="hy_main">
            <div class="hy_m">
                <div class="main1_zj1">
                    <ul>
                        <li class="dingdan">我的订单</li>
                        <li><a class="ddzt" href="http://www.zgw.com/UCenter/Order/orderlist?status=0"><span>待确认订单</span>(<b>0</b>)</a></li>
                        <li><a class="ddzt" href="http://www.zgw.com/UCenter/Order/orderlist?status=2"><span>待付款订单</span>(<b>0</b>)</a></li>
                        <li><a class="ddzt" href="http://www.zgw.com/UCenter/Order/orderlist?status=4"><span>待收货订单</span>(<b>0</b>)</a></li>
                        <li><a class="ddzt" href="http://www.zgw.com/UCenter/Order/orderlist?status=5"><span>交易成功</span>(<b>0</b>)</a></li>
                        <li><a class="ddzt" href="http://www.zgw.com/UCenter/Order/orderlist?status=6"><span>交易关闭</span>(<b>0</b>)</a></li>
                        <li class="ffd"><a class="qbdd" href="#">查看全部订单</a></li>
                    </ul>
                    <div class="table" style="clear:both;">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tbody><tr class="table_bottom">
                                <td style="width:90px;" align="left"><span class="lshh">流水号</span></td>
                                <td style="width:120px;" align="center"><span style="margin-left:0px;">商品名称</span></td>
                                <td style="width:160px;" align="center"><span>卖家信息</span></td>
                                <td style="width:80px;" align="center"><span>总价</span></td>
                                <td style="width:100px;" align="center"><span>下单时间</span></td>
                                <td style="width:120px;" align="center"><span>状态</span></td>
                            </tr>
                        </tbody></table>
                    </div>
                    <div class="llp"><img src="/resources/images/dingdan.png"></div>
                </div>
                <div class="main1_zj2">
                    <ul><li class="dingdana">我关注的商品</li><li class="ffd"><a class="ck" href="#">查看更多&gt;</a></li></ul>
                    <div class="table">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tbody><tr class="table_bottom">
                                <td width="160" align="left"><span class="lshh">商品名称</span></td>
                                <td width="70" align="left"><span class="STYLE8">产家</span></td>
                                <td width="150" align="left"><span class="STYLE8">卖家信息</span></td>
                                <td width="80" align="left"><span class="STYLE8">关注价格</span></td>
                                <td width="90" align="left"><span class="STYLE8">当前价格</span></td>
                                <td width="80" align="left"><span class="STYLE8">关注时间</span></td>
                            </tr>

                        </tbody></table>
                    </div>
                    <div class="llpp"><img src="/resources/images/dingdan2.png"></div>
                </div>
                <div class="main1_zj3">
                    <ul><li class="dingdana">我关注的店铺</li><li class="ffd"><a href="#" style="">查看更多&gt;</a></li></ul>
                    <div class="table">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tbody><tr class="table_bottom">
                                <td width="160" align="left"><span class="lshh">店铺名称</span></td>
                                <td width="100" align="center"><span> 主营项目 </span></td>
                                <td width="90" align="center"><span>所在地</span></td>
                                <td width="100" align="center"><span>联系方式   </span></td>
                                <td width="100" align="center"><span>现货数量 </span></td>
                                <td width="90" align="center"><span>  关注时间</span></td>
                            </tr>
                        </tbody></table>
                    </div>
                    <div class="llppo"><img src="/resources/images/dingdan2.png"></div>
                </div>
            </div>
            <div class="mm_r mm_r2">
                <div class="main_bottom">
                    <p><span style="margin-left:15px;font-size: 14px">浏览历史<span> <a href="#">查看更多&gt;</a></span></span></p>
                    <table class="liulan" width="240" style="text-align:left;" border="0" cellspacing="0" cellpadding="0">
                        <tbody><tr class="lalss" style="color:#333;height:34px;">
                            <td style="padding-left:15px;">[商品]</td>
                            <td>[规格]</td>
                            <td>[价格]</td>
                        </tr>
                    </tbody></table>
                    


                    <img src="/resources/images/jiao.png">
                </div>
            </div>
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
