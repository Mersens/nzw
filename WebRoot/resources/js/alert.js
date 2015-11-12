// JavaScript Document
$(function () {
    /*点击导航跳转定位*/
    var subnavactive = $(".fixednav ul .navbar_on");
    var subnavscroll = function (target) {
        subnavactive.removeClass("navbar_on");
        target.parent().addClass("navbar_on");
        subnavactive = target.parent();
    }
    $(".fixednav ul li a").click(function () {
        subnavscroll($(this));
        var target = $(this).attr("href");//获取修改地址
        var targetScroll = $(target).offset().top - 0;//获取滚动位置高度
        $("html,body").animate({ scrollTop: targetScroll }, 300);//动画滚动
        return false;
    })

    /*鼠标滚动页面跳转时定位*/
    if (window.location.hash) {
        var targetScroll = $(window.location.hash).offset().top - 0;
        $("html,body").animate({ scrollTop: targetScroll }, 300);
    }
    //var baseTop = $("#subnav").offset().top;
    $(window).scroll(function () {
        var $this = $(this);
        var targetTop = $(this).scrollTop();
        //var height = $(window).height();
        var firstTop = $("#topic_header").offset().top - 0;//获取标签位置
        var secondTop = $("#activities").offset().top - 100;//获取标签位置
        var thirdTop = $("#points").offset().top - 100;//获取标签位置
        var fourTop = $("#redeem").offset().top - 100;//获取标签位置

        if (targetTop < secondTop) {
            subnavscroll($(".navbar01"));
        }
        else if (targetTop > secondTop && targetTop < thirdTop) {
            subnavscroll($(".navbar02"));
        }
        else if (targetTop > thirdTop && targetTop < fourTop) {
            subnavscroll($(".navbar03"));
        }
        else if (targetTop > fourTop) {
            subnavscroll($(".navbar04"));
        }
    })
})


$(function () {

    $(window).resize(function () {
        if (!$("#showbox").is(":visible")) {
            return;
        }
        showDialog();
    });

    $(".btn_del").click(function () {
        $("#showbox").fadeOut();
        $(".mask").hide();

    });
})

//返回
function goBack() {
    $("#showbox").fadeOut();
    $(".mask").hide();
    location.reload();
}

function showDialog() {
    var objw = $(window);
    var objc = $("#showbox");
    var brsw = objw.width();
    var brsh = objw.height();
    var sclL = objw.scrollLeft();
    var curw = objc.width();
    var curh = objc.height();

    var left = sclL + (brsw - curw) / 2;
    var top = (brsh - curh) / 2;
    objc.css({ "left": left, "top": top });
}


$(function () {
    //地区下拉框
    $.get("/City/MyCity", { fid: 0 }, function (data) {
        $(eval(data)).each(function () {
            $("#slProvince").append("<option value=\"" + this["ID"] + "\">" + this["Name"] + "</option>");
        });
    });
    $("#slProvince").bind("change", function () {
        var fid = $(this).find("option:selected").val();
        $("#slCity").html("<option value=\"0\">请选择</option>");
        $("#slArea").html("<option value=\"0\">请选择</option>");
        $.get("/City/MyCity", { fid: fid }, function (data) {
            $(eval(data)).each(function () {
                $("#slCity").append("<option value=\"" + this["ID"] + "\">" + this["Name"] + "</option>");
            });
        });
    });
    $("#slCity").bind("change", function () {
        var fid = $(this).find("option:selected").val();
        $("#slArea").html("<option value=\"0\">请选择</option>");
        $.get("/City/MyCity", { fid: fid }, function (data) {
            $(eval(data)).each(function () {
                $("#slArea").append("<option value=\"" + this["ID"] + "\">" + this["Name"] + "</option>");
            });
        });
    });
});

//修改收货地址
function updateAdresss(id) {
    if (id > 0) {
        $("#editid").val(id);
        var linker, moblie, city, add;
        linker = $("#hidlinker_" + id).val();
        moblie = $("#hidmobile_" + id).val();
        city = $("#hidcity_" + id).val();
        add = $("#hidaddress_" + id).val();
        $("#person").val(linker);
        $("#mobile").val(moblie);
        $("#detailAddress").val(add);
        var arr = new Array();
        arr = city.split(" ");
        $("#slProvince option").each(function () {
            a = $(this).text();
            if ($(this).text() == arr[0].toString()) {
                $("#slProvince").val($(this).val());
                $.get("/City/MyCity", { fid: $(this).val() }, function (data) {
                    $("#slCity").html("<option value=\"0\">请选择</option>");
                    $("#slArea").html("<option value=\"0\">请选择</option>");
                    $(eval(data)).each(function () {
                        $("#slCity").append("<option value=\"" + this["ID"] + "\">" + this["Name"] + "</option>");
                    });
                    $("#slCity option").each(function () {
                        a = $(this).text();
                        if ($(this).text() == arr[1].toString()) {
                            $("#slCity").val($(this).val());
                            $.get("/City/MyCity", { fid: $(this).val() }, function (data) {
                                $(eval(data)).each(function () {
                                    $("#slArea").append("<option value=\"" + this["ID"] + "\">" + this["Name"] + "</option>");
                                });
                                $("#slArea option").each(function () {
                                    a = $(this).text();
                                    if ($(this).text() == arr[2].toString())
                                        $("#slArea").val($(this).val());
                                    else {
                                    }
                                });
                            });
                        }
                    });
                });
            }
        });
    }

    $("#updateAdress").show();
}

function checkIsAdd() {
    $('input:radio[name="adress"]').change(function () {
        var add = $('input:radio[name="adress"]:checked').val();
        if (add == 0) {
            updateAdresss(0);
        }
        else {
            $("#updateAdress").hide();
        }
    });
}

//保存地址
function SaveAdress() {
    var id, linker, moblie, cityid, add;

    id = $("#editid").val();
    linker = $("#person").val();
    moblie = $("#mobile").val();
    cityid = $("#slArea").val();
    add = $("#detailAddress").val();
    $("#val_linker").html("");
    $("#val_mobile").html("");
    $("#val_area").html("");
    $("#val_address").html("");
    if ($.trim(linker) == "") {
        $("#val_linker").html("请输入收货人");
        return;
    }
    if ($.trim(moblie) == "") {
        $("#val_mobile").html("请输入手机");
        return;
    }
    else {
        var regex = /^(13|15|17|18|14)[0-9]{9}$/;
        if (!regex.test(moblie)) {
            $("#val_mobile").html("手机号码无效");
            return;
        }
    }
    if ($.trim(cityid) == "0") {
        $("#val_area").html("请选择区域");
        return;
    }
    if ($.trim(add) == "") {
        $("#val_address").html("请输入详细地址");
        return;
    }
    $.post("/Jifen/SaveAddress", { linker: linker, mobile: moblie, cityid: cityid, address: add, id: id }, function (data) {
        var province = $("#slProvince").find("option:selected").text();
        var city = $("#slCity").find("option:selected").text();
        var area = $("#slArea").find("option:selected").text();
        var citytext = province + " " + city + " " + area;
        if (id > 0) {
            $("#hidlinker_" + id).val(linker);
            $("#hidmobile_" + id).val(moblie);
            $("#hidcityid_" + id).val(cityid);
            $("#hidcity_" + id).val(citytext);
            $("#hidaddress_" + id).val(add);
            $("#adressinfo").text(linker + " " + moblie + " " + citytext + " " + add);
            $("#updateAdress").hide();
        }
        else {
            var html = '';
            html += '<input type="hidden" name="h_person" id="hidlinker_' + data + '" value="' + linker + '" />';
            html += '<input type="hidden" name="h_mobile" id="hidmobile_' + data + '" value="' + moblie + '" />';
            html += '<input type="hidden" name="h_areaid" id="hidcityid_' + data + '" value="' + cityid + '" />';
            html += '<input type="hidden" id="hidcity_' + data + '" value="' + citytext + '" />';
            html += '<input type="hidden" name="h_address" id="hidaddress_' + data + '" value="' + add + '" />';
            html += '<input type="hidden" id="hidid_' + data + '" value="' + data + '" />';
            html += '<span id="adressinfo">' + linker + ' ' + moblie + ' ' + citytext + ' ' + add + '</span>';
            html += '<a href="javascript:void(0)" onclick="updateAdresss(' + data + ')"> 修改</a></p>';
            $("#editid").val(data);
            $("#addAdress").hide();
            $("#updateAdress").hide();
            $("#linkAdd").hide();
            $("#adressList").append(html);
        }
    });

}

function cancleSave() {
    $("#updateAdress").hide();
}

function checkAdress() {
    $("#person").blur("keyup", function () {
        var linker = $.trim($("#person").val());
        if (linker.length <= 0) {
            $("#val_linker").show();
            $("#val_linker").html("请输入收货人");
            $("#person").focus();
        }
        else {
            $("#val_linker").hide();
        }
    });
    $("#mobile").blur(function () {
        var moblie = $("#mobile").val();
        var regex = /^(13|15|17|18|14)[0-9]{9}$/;
        if (!regex.test(moblie)) {
            $("#val_mobile").show();
            $("#val_mobile").html("手机号码无效");
            $("#mobile").focus();
        }
        else {
            $("#val_mobile").hide();
        }
    });

    $("#slArea").blur(function () {
        var slArea = $("#slArea").val();
        if ($.trim(slArea) == "") {
            $("#val_area").show();
            $("#val_area").html("请输入收货人");
            $("#slArea").focus();
        }
        else {
            $("#val_area").hide();
        }
    });

    $("#detailAddress").blur(function () {
        var detailAddress = $("#detailAddress").val();
        if ($.trim(detailAddress) == "") {
            $("#val_address").show();
            $("#val_address").html("请输入收货地址");
            $("#detailAddress").focus();
        }
        else {
            $("#val_address").hide();
        }
    });
}

//兑换奖品
function duiHuan() {
    var id = $("#hidgiftId").val();   //奖品编号
    var adressId = $("#editid").val();  //邮寄地址编号
    $.post("/Jifen/DuiHuan", { id: id, adressId: adressId }, function (data) {
        if (data == -1) {
            //没有登录
            window.open('/Account/Login')
        }
        if (data == 0) {
            //积分不足
            $(".jf_tc").hide();
            $("#jf_login_jf").hide();
            $("#jf_login_jfless").show();
        }
        if (data == 1) {
            //兑换成功
            $(".jf_tc").hide();
            $("#jf_login_jf").hide();
            $.post("/Jifen/GiftData", { id: id, adressId: adressId }, function (data) {
                var result = data.split('|');
                $("#spanTotal").html(result[0]);
                $("#spanDuiHuan").html(result[1]);
                $("#padress").html(result[2]);

                $("#jf_login_sucess").show();
            });
        }
    });
}

$(function () {
    checkIsAdd();

});