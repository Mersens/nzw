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
<link href="/resources/css/Xunjia.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/jquery.unobtrusive-ajax.min.js"></script>
<script src="/resources/js/Xunjia.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/layer.min.js"></script>
<script src="/resources/js/partialfooter.js"></script>

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
<script type="text/javascript">
    $(function () {
        $(".xjd_tab th i").hover(function () {
            $(this).children(".showbox").show();
        }, function () {
            $(this).children(".showbox").hide();
        });
    })
</script>
<form action="images/【采购报价】最新钢材采购信息及报价信息-中钢网.html" data-ajax="true" data-ajax-success="OnSuccess" id="form0" method="post">    <div class="cg_main">
        <input type="hidden" name="proepId" value="0" id="proepId">
        <div class="bjdxq_tit" style="line-height:70px;">询价单</div>
        <div class="cg_m" style="background: #fff; overflow: hidden; min-height: 510px;margin-bottom:70px;">
            <div class="xjdm">
                <div class="xjd_ts">
                    <span>想了解最低价？</span>请填写如下信息给经销商（信息保密，不对外公开）
                </div>
                <div class="xjcp">
                    <div class="xjcp_tit">询价产品</div>
                    <table class="xjd_tab">
                        <tbody><tr>
                            <th width="160"><span>*</span>品名</th>
                            <th width="160"><span>*</span>材质</th>
                            <th width="160"><span>*</span>规格<i><div class="showbox" style="display: none;">填写规则：厚*宽*长<div class="icon_arrow"></div></div></i></th>
                            <th width="120"><span>*</span>采购量(吨)</th>
                            <th width="120"><span>*</span>产地/厂家</th>
                            <th width="120"><span>*</span>收货地</th>
                            <th width="190">报价要求</th>
                        </tr>
                        <tr>
                            <td>
                                <a class="delete_cg" href="javascript:void(0);" style="display:none;"><img src="/resources/images/xjd_jian.png" style="margin-bottom:2px; margin-right:6px;"></a><input name="Pm" class="xjd_inp" type="text" value="" placeholder="例：普碳中板">
                            </td>
                            <td>
                                <input name="Cz" style=" width:130px;" class="xjd_inp" type="text" value="" placeholder="例：Q235B">
                            </td>
                            <td>
                                <input name="Gg" id="Gg" style=" width:140px;" class="xjd_inp" type="text" value="" placeholder="例：6*1000*6000">
                            </td>
                            <td>
                                <input name="Ton" class="xjd_inp" type="text" value="0">
                            </td>
                            <td>
                                <div id="cj" class="xjd_s cjxz">
                                    <input id="ProductArea" name="ProductArea" type="text" value="" autocomplete="off">

                                </div>
                            </td>
                            <td>
                                <div class="xjd_s" style="position:relative;">
                                    <input for="area" name="DeliveryArea" type="text" autocomplete="off">
                                </div>
                            </td>
                            <td>
                                <input type="hidden" name="cgindex" value="0">
                                <input name="IsTax0" type="checkbox" checked="checked" value="true">&nbsp;需要报含税价
                            </td>
                        </tr>

                    </tbody></table>
                        <a id="add_cg" href="javascript:void(0);" style="color:#466083; margin-left:6px; font-size:14px; line-height:28px;">
                            <img src="/resources/images/xjd_add.png" style="margin-bottom:2px;">&nbsp;添加产品
                        </a>
                    <div class="mask" style="opacity: 0.8; display: none;"></div>
                    <div id="showbox" style="left: 486.5px; top: 20.5px; display: none;">
                        <div class="top_tip top_ws">
                            <div class="tip_tt">
                                <span>温馨提示</span>
                                <b class="btn_del"></b>
                            </div>
                            <div class="tip_box">
                                <i></i>
                                <p>亲，询价单信息不完整，请完善您的询价单信息！</p>
                                <p>(请输入<b id="unerror"></b>)</p>
                                <div class="jb_f"><a class="btn btn_yellow" href="javascript:close();">立即完善</a></div>
                            </div>
                        </div>
                        <div class="top_tip top_xg">
                            <div class="tip_tt">
                                <span>温馨提示</span>
                                <b class="btn_del"></b>
                            </div>
                            <div class="tip_box">
                                <i></i>
                                <p>亲，询价单信息输入有误，请输入正确的询价单信息！</p>
                                <p>(请输入<b id="errorcon"></b>)</p>
                                <div class="jb_f"><a class="btn btn_yellow" href="javascript:close();">立即修改</a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="xj_mid">
                    <span class="org">*</span>您的姓名：<input name="Name" type="text" class="name_inp"><span><input name="Sex" value="0" type="radio" checked="checked">先生</span><span><input name="Sex" value="1" type="radio">女士</span><br>
                    <span class="org">*</span>手机号码：<input name="Mobile" type="text" class="name_inp" value="18639902393">
                    <div class="field-validation-error">
                    </div>
                </div>
                <div class="jxs">
                    <input class="zxzdj" type="submit" value="咨询最低价">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="area_box">
    <ul>
        <li class="prvli on">
            <i>*</i>省
        </li>
        <li class="cityli no_on">
            <i>*</i>市
        </li>
    </ul>
    <div class="area_prv">
        <table>
            <tbody><tr>
                <td class="zm">A-G</td>
                <td>
                    <span fid="50">重庆</span>
                    <span fid="44">广东</span>
                    <span fid="34">安徽</span>
                    <span fid="11">北京</span>
                    <span fid="35">福建</span><br>
                    <span fid="62">甘肃</span>
                    <span fid="45">广西</span>
                    <span fid="52">贵州</span>
                </td>
            </tr>
            <tr>
                <td class="zm">H-K</td>
                <td>
                    <span fid="42">湖北</span>
                    <span fid="36">江西</span>
                    <span fid="46">海南</span>
                    <span fid="13">河北</span>
                    <span fid="41">河南</span><br>
                    <span fid="23">黑龙江</span>
                    <span fid="43">湖南</span>
                    <span fid="22">吉林</span>
                    <span fid="32">江苏</span>
                </td>
            </tr>
            <tr>
                <td class="zm">L-S</td>
                <td>
                    <span fid="61">陕西</span>
                    <span fid="51">四川</span>
                    <span fid="64">宁夏</span>
                    <span fid="63">青海</span>
                    <span fid="31">上海</span><br>
                    <span fid="14">山西</span>
                    <span fid="37">山东</span>
                    <span fid="21">辽宁</span>
                    <span fid="15">内蒙古</span>
                </td>
            </tr>
            <tr>
                <td class="zm">T-Z</td>
                <td>
                    <span fid="12">天津</span>
                    <span fid="54">西藏</span>
                    <span fid="65">新疆</span>
                    <span fid="33">浙江</span>
                    <span fid="53">云南</span>
                </td>
            </tr>
        </tbody></table>

    </div>
    <div class="area_city" style="display:none;">
          <div style="text-align:center">请选省份</div>
    </div>
</div>
<script type="text/javascript">
    var _overcity = false;
    var _focusDeliveryArea;
    $(function () {
        $(".area_prv span").click(function () {
            var ptext = $(this).text();
            $.post("/XunJia/GetCity", { fid: $(this).attr("fid") }, function (data) {
                $(".area_city").text("");
                $(data.list).each(function (index) {
                    $(".area_city").append("<span cid='" + this.ID + "' val='" + ptext + "-" + this.Name + "'>" + this.Name + "</span>");
                    $(".area_prv").hide();
                    $(".area_city").show();
                    $(".area_city span").click(function () {
                        _focusDeliveryArea.val($(this).attr("val"));
                        $(".area_box").hide();
                    });
                    $(".prvli").removeClass("on").addClass("no_on");
                    $(".cityli").removeClass("no_on").addClass("on");
                });
            });
        });
        areaEvenLoad();
        $(".area_box").mouseover(function () {
            $(".area_box").show();
            _overcity = true;
        }).mouseout(function () {
            _overcity = false;
        });
        $(window).click(function () {
            if (!_overcity) $(".area_box").hide();
        });
        $(".prvli").click(function () {
            prvshow();
        });
        $(".cityli").click(function () {
            $(".area_prv").hide(); $(".area_city").show();
            $(".prvli").removeClass("on").addClass("no_on");
            $(".cityli").removeClass("no_on").addClass("on");
        });
    });
    function prvshow()
    {
        $(".area_city").hide(); $(".area_prv").show();
        $(".cityli").removeClass("on").addClass("no_on");
        $(".prvli").removeClass("no_on").addClass("on");
    }
    function areaEvenLoad()
    {
        $("input[for=area]").click(function () {
            $(".area_box").show();
            _overcity = true;
            prvshow();
            _focusDeliveryArea = $(this);
            $(".area_box").css("top", (parseInt($(this).offset().top) + parseInt($(this).css("height"))));
            $(".area_box").css("left", ($(this).offset().left));
        }).mouseout(function () {
            _overcity = false;
        });
    }
</script>
<ul class="xjd_list" style="display:none"><li><a href="javascript:void(0);">不限</a></li><li><a href="javascript:void(0);">宝钢不锈钢</a></li><li><a href="javascript:void(0);">南钢</a></li><li><a href="javascript:void(0);">沙钢</a></li><li><a href="javascript:void(0);">永钢</a></li><li><a href="javascript:void(0);">淮钢</a></li><li><a href="javascript:void(0);">杭钢</a></li><li><a href="javascript:void(0);">马钢</a></li><li><a href="javascript:void(0);">济钢</a></li><li><a href="javascript:void(0);">莱钢</a></li><li><a href="javascript:void(0);">青钢</a></li><li><a href="javascript:void(0);">日照</a></li><li><a href="javascript:void(0);">福建三钢</a></li><li><a href="javascript:void(0);">新钢</a></li><li><a href="javascript:void(0);">萍钢</a></li><li><a href="javascript:void(0);">山东鲁丽</a></li><li><a href="javascript:void(0);">青山控股</a></li><li><a href="javascript:void(0);">久立</a></li><li><a href="javascript:void(0);">宝钢特殊钢</a></li><li><a href="javascript:void(0);">兴澄</a></li><li><a href="javascript:void(0);">兆顺</a></li><li><a href="javascript:void(0);">西城</a></li><li><a href="javascript:void(0);">宁波宝新</a></li><li><a href="javascript:void(0);">南昌</a></li><li><a href="javascript:void(0);">石横</a></li><li><a href="javascript:void(0);">春冶</a></li><li><a href="javascript:void(0);">飞达</a></li><li><a href="javascript:void(0);">长达</a></li><li><a href="javascript:void(0);">华伟</a></li><li><a href="javascript:void(0);">中天</a></li><li><a href="javascript:void(0);">福达</a></li><li><a href="javascript:void(0);">宁钢</a></li><li><a href="javascript:void(0);">山钢集团</a></li><li><a href="javascript:void(0);">首钢</a></li><li><a href="javascript:void(0);">唐钢</a></li><li><a href="javascript:void(0);">邯钢</a></li><li><a href="javascript:void(0);">包钢</a></li><li><a href="javascript:void(0);">宣钢</a></li><li><a href="javascript:void(0);">承钢</a></li><li><a href="javascript:void(0);">天钢</a></li><li><a href="javascript:void(0);">太钢</a></li><li><a href="javascript:void(0);">天铁</a></li><li><a href="javascript:void(0);">石钢</a></li><li><a href="javascript:void(0);">长钢</a></li><li><a href="javascript:void(0);">临钢</a></li><li><a href="javascript:void(0);">津西</a></li><li><a href="javascript:void(0);">河钢集团</a></li><li><a href="javascript:void(0);">邯郸永兴</a></li><li><a href="javascript:void(0);">邢钢</a></li><li><a href="javascript:void(0);">唐山建龙</a></li><li><a href="javascript:void(0);">德龙</a></li><li><a href="javascript:void(0);">文丰</a></li><li><a href="javascript:void(0);">纵横</a></li><li><a href="javascript:void(0);">普阳</a></li><li><a href="javascript:void(0);">海鑫</a></li><li><a href="javascript:void(0);">敬业</a></li><li><a href="javascript:void(0);">鞍钢</a></li><li><a href="javascript:void(0);">本钢</a></li><li><a href="javascript:void(0);">通钢</a></li><li><a href="javascript:void(0);">北台</a></li><li><a href="javascript:void(0);">凌钢</a></li><li><a href="javascript:void(0);">东北特钢</a></li><li><a href="javascript:void(0);">西钢</a></li><li><a href="javascript:void(0);">新抚钢</a></li><li><a href="javascript:void(0);">黑龙江建龙</a></li><li><a href="javascript:void(0);">营口</a></li><li><a href="javascript:void(0);">吉林建龙</a></li><li><a href="javascript:void(0);">武钢</a></li><li><a href="javascript:void(0);">鄂钢</a></li><li><a href="javascript:void(0);">柳钢</a></li><li><a href="javascript:void(0);">广钢</a></li><li><a href="javascript:void(0);">韶钢</a></li><li><a href="javascript:void(0);">安钢</a></li><li><a href="javascript:void(0);">济源</a></li><li><a href="javascript:void(0);">涟钢</a></li><li><a href="javascript:void(0);">湘钢</a></li><li><a href="javascript:void(0);">湖北新冶钢</a></li><li><a href="javascript:void(0);">珠钢</a></li><li><a href="javascript:void(0);">华美</a></li><li><a href="javascript:void(0);">信钢</a></li><li><a href="javascript:void(0);">衡阳钢管</a></li><li><a href="javascript:void(0);">广州联众</a></li><li><a href="javascript:void(0);">永通特钢</a></li><li><a href="javascript:void(0);">冷钢</a></li><li><a href="javascript:void(0);">汉冶</a></li><li><a href="javascript:void(0);">酒钢</a></li><li><a href="javascript:void(0);">八钢</a></li><li><a href="javascript:void(0);">龙钢</a></li><li><a href="javascript:void(0);">略钢</a></li><li><a href="javascript:void(0);">西宁特钢</a></li><li><a href="javascript:void(0);">汉中</a></li><li><a href="javascript:void(0);">宝鸡石油</a></li><li><a href="javascript:void(0);">攀钢</a></li><li><a href="javascript:void(0);">成钢</a></li><li><a href="javascript:void(0);">重钢</a></li><li><a href="javascript:void(0);">昆钢</a></li><li><a href="javascript:void(0);">威钢</a></li><li><a href="javascript:void(0);">达钢</a></li><li><a href="javascript:void(0);">水钢</a></li><li><a href="javascript:void(0);">德胜</a></li><li><a href="javascript:void(0);">长城特钢</a></li><li><a href="javascript:void(0);">贵钢</a></li><li><a href="javascript:void(0);">玉溪</a></li><li><a href="javascript:void(0);">西昌新钢业</a></li><li><a href="javascript:void(0);">舞钢</a></li><li><a href="javascript:void(0);">元宝山</a></li><li><a href="javascript:void(0);">中铁</a></li><li><a href="javascript:void(0);">邯宝</a></li><li><a href="javascript:void(0);">郑特钢</a></li><li><a href="javascript:void(0);">晋钢</a></li><li><a href="javascript:void(0);">宝钢</a></li><li><a href="javascript:void(0);">泰钢</a></li><li><a href="javascript:void(0);">梅钢</a></li></ul>

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
