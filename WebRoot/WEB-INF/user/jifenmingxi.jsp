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
<link href="/resources/css/jifenrecord.css" rel="stylesheet" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/alert.js"></script>
<script type="text/javascript">
    $(function () {
        $(".po_exm ul").find("li").each(function () {
            $(this).hover(function () {
                $(this).find(".lihover").show();
            }, function () {
                $(this).find(".lihover").hide();
            })
        });
    });

    $(function () {
        $("#sele").change(function () {
            var id = $(this).find("option:selected").attr("id");
            var typeId = $("#typeval").val();
            location.href = "/UCenter/MyJiFen/JiFenRecord?typeId=" + typeId + "&DateType=" + id;
        })
    })
    $(function () {
        $(".po_ex .po_exm  ul").find("li").each(function () {
            $(this).hover(function () {
                $(this).addClass("hover");
            }, function () {
                $(this).removeClass("hover");
            })
        });
    })

    $(function () {
        $(".po_ex .po_exm ul li .btn_exchange").click(function () {
            $("#hidgiftId").val($(this).attr("giftid"));
            $(".mask").css("opacity", "0.8").show();
            $("#showbox").attr("score", $(this).attr("score"));
            $("#showbox").attr("giftname", $(this).attr("giftname"));
            checkShow();
            showDialog();
            $("#showbox").fadeIn();
            checkAdress();
        });
    });

    //检查显示弹出框
    function checkShow() {
        var isLogin = "True";
        if (isLogin == "True") {
            var companyName = "公司特别棒";
            var fullName = "";
            var nickName = "";
            if (companyName.length <= 0 && fullName.length <= 0) {
                $(".jf_tc").hide();
                $("#jf_login_noinfo").show();
            }
            else {
                var totalScore = "7";
                var score = $("#showbox").attr("score");
                var giftname = $("#showbox").attr("giftname");
                if (parseInt(totalScore) >= parseInt(score)) {
                    $(".jf_tc").hide();
                    $("#jf_login_jf").show();

                }
                else {
                    $(".jf_tc").hide();
                    $("#jf_login_jfless").show();
                }
            }
        }
        else {
            $(".jf_tc").hide();
            $("#jf_login_no").show();
        }
    }
</script>
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
            <p class="r_tit">我的积分</p>
                             <!--未认证-->
                <div class="points">
    <div class="cpoin">
        <div class="cpoin_l">
            可用的积分<br>
            <span class="cpoin_red">7</span>分
        </div>
        <div class="cpoin_r">
            <a href="#" class="ex">去兑换礼品</a>
            <a href="#" target="_blank" class="ea">如何赚取积分？</a>
        </div>
    </div>

    <div class="po_de">
        <div class="po_det">
            <ul>
                <li typeid="-2" class="on"><a href="#" style="color:white;">积分明细</a></li>
                <li typeid="0" class=""><a href="#" style="color:black;">积分收入</a></li>
                <li typeid="-1" class=""><a href="#" style="color:black;">积分支出</a></li>
            </ul>
            <div class="ck">
                <span>查看明细</span>
                <select id="sele" class="selm">
                    <option selected="&#39;selected&#39;" id="0" value="0">全部积分记录</option>
                    <option id="1" value="1">最近三个月的积分记录</option>
                    <option id="2" value="2">三个月前的积分记录</option>
                </select>
            </div>
            <input type="hidden" name="typeval" id="typeval" value="-2">
            <input type="hidden" name="dateval" id="dateval" value="0">
        </div>
        <div class="po_dem">
            <div class="po_demt">
                <span class="rqt">日期</span>
                <span class="srt">收入/支出</span>
                <span class="xxsmt">详细说明</span>
            </div>
                <div class="po_mm">
                    <ul>

                            <li>
                                <span class="rqm">2015/8/21 10:03:00</span>
                                <span class="srm">
                                        <span class="red">+2</span>
                                </span>
                                <span class="xxsmm">登录成功(每日一次)</span>
                            </li>
                            <li>
                                <span class="rqm">2015/8/20 9:37:00</span>
                                <span class="srm">
                                        <span class="red">+2</span>
                                </span>
                                <span class="xxsmm">登录成功(每日一次)</span>
                            </li>
                            <li>
                                <span class="rqm">2015/8/19 1:48:00</span>
                                <span class="srm">
                                        <span class="red">+2</span>
                                </span>
                                <span class="xxsmm">登录成功(每日一次)</span>
                            </li>
                            <li>
                                <span class="rqm">2015/8/18 9:44:00</span>
                                <span class="srm">
                                        <span class="red">+1</span>
                                </span>
                                <span class="xxsmm">注册获取积分</span>
                            </li>

                        

                    </ul>
                    <div class="clear"></div>
                    <div class="pageF" style="margin-right:20px;">
                        
                    </div>
                </div>         </div>
        <div class="po_ex" id="po_ex">
            <div class="po_ext">积分兑换</div>
            <div class="po_exm">
                <ul>

                                <li class="">
                                    <div class="pic">
                                   	 	<img src="/resources/images/20150605092304.png">
                                    </div>
                                    <div class="text">
                                        <h3>苹果iPhone 6 （16G）</h3>
                                        <p>888 积分</p>
                                    </div>
                                    <input type="button" score="1" giftname="苹果iPhone 6 （16G）" class="down btn_exchange" giftid="2" value="兑换" />

                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092228.png"></div>
                                    <div class="text">
                                        <h3>iPad Air 16G WiFi版</h3>
                                        <p>666 积分</p>
                                    </div>
                                    <!--<input type="button" score="666" giftname="iPad Air 16G WiFi版" class="dh btn_exchange" giftid="3" value="兑换" />-->
                                 <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                 <div class="ydw_bg"></div>
                                </li>
                                <li class="">
                                    <div class="pic"><img src="/resources/images/20150605092238.png"></div>
                                    <div class="text">
                                        <h3>华为荣耀智能手环</h3>
                                        <p>298 积分</p>
                                    </div>
                                    <!--<input type="button" score="298" giftname="华为荣耀智能手环" class="dh btn_exchange" giftid="4" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li class="">
                                    <div class="pic"><img src="/resources/images/20150605092254.png"></div>
                                    <div class="text">
                                        <h3>HP P1108 激光打印机</h3>
                                        <p>270 积分</p>
                                    </div>
                                    <!--<input type="button" score="270" giftname="HP P1108 激光打印机" class="dh btn_exchange" giftid="6" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li class="">
                                    <div class="pic"><img src="/resources/images/20150605092320.png"></div>
                                    <div class="text">
                                        <h3>500元超市购物卡</h3>
                                        <p>200 积分</p>
                                    </div>
                                    <!--<input type="button" score="200" giftname="500元超市购物卡" class="dh btn_exchange" giftid="7" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li class="hover">
                                    <div class="pic"><img src="/resources/images/20150605092334.png"></div>
                                    <div class="text">
                                        <h3>派克墨水笔礼盒套装</h3>
                                        <p>150 积分</p>
                                    </div>
                                    <!--<input type="button" score="150" giftname="派克墨水笔礼盒套装" class="dh btn_exchange" giftid="8" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092355.png"></div>
                                    <div class="text">
                                        <h3>200超市购物卡</h3>
                                        <p>100 积分</p>
                                    </div>
                                    <!--<input type="button" score="100" giftname="200超市购物卡" class="dh btn_exchange" giftid="9" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092409.png"></div>
                                    <div class="text">
                                        <h3>100元话费充值</h3>
                                        <p>55 积分</p>
                                    </div>
                                    <!--<input type="button" score="55" giftname="100元话费充值" class="dh btn_exchange" giftid="10" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092433.png"></div>
                                    <div class="text">
                                        <h3>50元话费充值</h3>
                                        <p>30 积分</p>
                                    </div>
                                    <!--<input type="button" score="30" giftname="50元话费充值" class="dh btn_exchange" giftid="11" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092500.png"></div>
                                    <div class="text">
                                        <h3>中钢小神龙公仔</h3>
                                        <p>20 积分</p>
                                    </div>
                                    <!--<input type="button" score="20" giftname="中钢小神龙公仔" class="dh btn_exchange" giftid="12" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092518.png"></div>
                                    <div class="text">
                                        <h3>精致陶瓷杯</h3>
                                        <p>15 积分</p>
                                    </div>
                                    <!--<input type="button" score="15" giftname="精致陶瓷杯" class="dh btn_exchange" giftid="13" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                                <li>
                                    <div class="pic"><img src="/resources/images/20150605092555.png"></div>
                                    <div class="text">
                                        <h3>小礼品（零食）</h3>
                                        <p>10 积分</p>
                                    </div>
                                    <!--<input type="button" score="10" giftname="小礼品（零食）" class="dh btn_exchange" giftid="14" value="兑换" />-->
                                <span class="down">兑换</span>
                                 <div class="ydw_cen">已兑完</div>
                                <div class="ydw_bg"></div>
                                </li>
                </ul>
                <input type="hidden" value="0" id="hidgiftId">
            </div>
        </div>
    </div>
</div>
                <div class="clear"></div>
                <div class="mask"></div>
                <div id="showbox" score="" giftid="" giftname="">
                    <!--未登录-->
                    <div style="display:none" id="jf_login_no" class="jf_tc">
                        <div class="jf_tc_t">
                            <span>礼品兑换</span>
                            <b class="btn_del"></b>
                        </div>
                        <div class="jf_box">
                            <p>您还未登录，请您登录后进行礼品兑换！</p>
                            <div class="jb_f"><input class="btn" type="button" value="登  录" ></div>
                        </div>
                    </div>
                    <!--已登录但未完善信息-->
                    <div style="display:none" id="jf_login_noinfo" class="jf_tc">
                        <div class="jf_tc_t">
                            <span>礼品兑换</span>
                            <b class="btn_del"></b>
                        </div>
                        <div class="jf_box">
                            <p>您还未维护个人信息和公司信息，请维护个人信息或公司信息。</p>
                            <div class="jb_f">
                                <input class="btn" type="button" value="维护个人信息" />
                                <input class="btn blue_btn" type="button" value="维护公司信息" />
                            </div>
                        </div>
                    </div>
                    <!--已登录但积分不足-->
                    <div style="display:none" id="jf_login_jfless" class="jf_tc">
                        <div class="jf_tc_t">
                            <span>礼品兑换</span>
                            <b class="btn_del"></b>
                        </div>
                        <div class="jf_box">
                            <div class="jfxx">
                                <p>提示：当前积分不足,无法进行换,赶快参加活动赚取积分吧！</p>
                                <div class="jb_f btn_del"><a class="btn" href="#">赚取积分</a></div>
                            </div>
                
                        </div>
                    </div>
                    <!--登录兑换填写收货地址-->
                    <div style="display:none" id="jf_login_jf" class="jf_tc jf_tc_address">
                        <div class="jf_tc_t">
                            <span>礼品兑换</span>
                            <b class="btn_del"></b>
                        </div>
                        <div class="jf_box">
                            <div class="jfxx">
                                <span>当前积分：<b>7分</b></span>
                                <span>已使用积分：<b>0分</b></span>
                            </div>
                            <div class="jb_address">
                                <h3>收货信息</h3>
                
                                <ul>
                                        <li id="adressList">
                                            <a id="linkAdd" href="javascript:void(0)" onload="updateAdresss(0);" onclick="updateAdresss(0)">添加</a>
                                        </li>
                                        <script>$(function () { $("#updateAdress").show(); });</script>
                                    <li>
                                        <div id="updateAdress" style="">
                                            <input type="hidden" value="0" id="editid">
                                            <table class="table01" width="100%" border="0" cellpadding="0" cellspacing="0">
                                                <tbody>
                                                    <tr>
                                                        <th width="100" align="right" scope="row"><b>*</b>收货人：</th>
                                                        <td><input class="txt" type="text" id="person" name="person" maxlength="20"></td>
                                                        <td><span class="valtext" id="val_linker"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th align="right" scope="row"><b>*</b>手&nbsp;&nbsp;机：</th>
                                                        <td><input class="txt" type="text" id="mobile" name="mobile" maxlength="20"></td>
                                                        <td><span class="valtext" id="val_mobile"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th align="right" scope="row"><b>*</b>所在地区：</th>
                                                        <td>
                                                            <select id="slProvince" class="sel">
                                                                <option value="0">请选择</option>
                                                            <option value="11">北京</option><option value="12">天津</option><option value="13">河北</option><option value="14">山西</option><option value="15">内蒙古</option><option value="21">辽宁</option><option value="22">吉林</option><option value="23">黑龙江</option><option value="31">上海</option><option value="32">江苏</option><option value="33">浙江</option><option value="34">安徽</option><option value="35">福建</option><option value="36">江西</option><option value="37">山东</option><option value="41">河南</option><option value="42">湖北</option><option value="43">湖南</option><option value="44">广东</option><option value="45">广西</option><option value="46">海南</option><option value="50">重庆</option><option value="51">四川</option><option value="52">贵州</option><option value="53">云南</option><option value="54">西藏</option><option value="61">陕西</option><option value="62">甘肃</option><option value="63">青海</option><option value="64">宁夏</option><option value="65">新疆</option></select>
                                                            <select id="slCity" class="sel">
                                                                <option value="0">请选择</option>
                                                            </select>
                                                            <select id="slArea" class="sel">
                                                                <option value="0">请选择</option>
                                                            </select>
                                                        </td>
                                                        <td><span class="valtext" id="val_area"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th align="right" valign="top" scope="row"><b>*</b>详细地址：</th>
                                                        <td><input id="detailAddress" name="detailAddress" maxlength="20" class="txt" type="text"></td>
                                                        <td><span class="valtext" id="val_address"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">&nbsp;</th>
                                                        <td><input class="btn" type="button" onclick="SaveAdress();" value="确认"><input class="btn blue_btn" type="button" onclick="cancleSave();" value="取消"></td>
                                                        <td></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="btn_sure">
                
                                <input class="btn" type="button" onclick="duiHuan();" value="确认兑换">
                            </div>
                        </div>
                    </div>
                    <!--兑换成功-->
                    <div style="display:none" id="jf_login_sucess" class="jf_tc jf_tc_address">
                        <div class="jf_tc_t">
                            <span>兑换成功</span>
                            <b class="btn_del"></b>
                        </div>
                        <div class="jf_box">
                            <div class="jfxx">
                                <span>成功兑换积分：<span id="spanDuiHuan"></span>分</span>
                                <span>当前剩余积分：<span id="spanTotal"></span>分</span>
                            </div>
                            <div class="jf_address_sure">
                                <h3>收货信息：</h3>
                                <p id="padress"></p>
                            </div>
                            <div class="jb_f">
                                <p>温馨提示：我们将会在1-2个工作日通过快递的方式将礼品邮寄给您，请您耐心等待！</p>
                                <input class="btn" type="button" value="返回" onclick="goBack();" />
                                <input class="btn blue_btn" type="button" value="查看兑换记录" />
                            </div>
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
