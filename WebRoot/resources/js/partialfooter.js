
/* add by zhenggj 20150622 hm.baidu.com */
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fb0130e82267094ce1365dc3ef9e1688a' type='text/javascript'%3E%3C/script%3E"));


$(function () {
    $.get("/Order/OrderCount", function (data) {
        if (data > -1) {
            $("#order").html("(" + data + ")");
        }
    });
    //$.get("/UCenter/Product/CareProductCount", function (data) {
    //$.get("/UCenter/Order/OrderCount", function (data) {
    //    if (data > -1) {
    //        $("#order").html("(" + data + ")");
    //    }
    //});
    //$.get("/UCenter/Product/CareProductCount", function (data) {

    //    if (data > -1) {
    //        $("#care").html("(" + data + ")");
    //    }
    //});
    $.get("/Product/CartCount?t=" + (new Date()).getMilliseconds(), function (data) {
        $("#mycart").html("(" + data + ")");
        $("#car_num").val(data);
        $("#car_numhd").html(data);
        $("#end").html(data);
        if (typeof (setcart) == "function") {
            setcart();
        }
    });
    $("#a_msg").mouseover(function () {
        $(".rightmsg").show();
    }).mouseout(function () {
        $(".rightmsg").hide();
    });
    $(".rightmsg").mouseover(function () {
        $(".rightmsg").show();
    }).mouseout(function () {
        $(".rightmsg").hide();
    });
    $(".main .car").mouseover(function () {
        $(".car_ydl").show();
        $(".car_wdl").show();
    }).mouseout(function () {
        $(".car_ydl").hide();
        $(".car_wdl").hide();
    });
    $(".car_ydl").mouseover(function () {
        $(".car_ydl").show();
    }).mouseout(function () {
        $(".car_ydl").hide();
    });
})
function addToFavorite() {
    var d = "http://www.zgw.com/";
    var c = "中钢网";
    if (document.all)
    { window.external.AddFavorite(d, c); }
    else {
        if (window.sidebar) { window.sidebar.addPanel(c, d, ""); }
        else
        { alert("对不起，您的浏览器不支持此操作!\n请您使用菜单栏或Ctrl+D收藏本站。"); }
    }
}
function closemsg() {
    $(".rightmsg").hide();
}
function login() {
    $.layer({
        type: 2,
        shadeClose: true,
        title: false,
        closeBtn: [0, false],
        shade: [0.2, '#000'],
        border: [0],
        offset: ['', ''],
        area: ['453px', '300px'],
        iframe: { src: '/Account/miniLogin' }
    });

}

//判断浏览器是否安装了falsh
function flashChecker() {
    var hasFlash = 0;         //是否安装了flash
    var flashVersion = 0; //flash版本
    var isIE =/*@cc_on!@*/0;      //是否IE浏览器

    if (isIE) {
        var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
        if (swf) {
            hasFlash = 1;
            VSwf = swf.GetVariable("$version");
            flashVersion = parseInt(VSwf.split(" ")[1].split(",")[0]);
        }
    } else {
        if (navigator.plugins && navigator.plugins.length > 0) {
            var swf = navigator.plugins["Shockwave Flash"];
            if (swf) {
                hasFlash = 1;
                var words = swf.description.split(" ");
                for (var i = 0; i < words.length; ++i) {
                    if (isNaN(parseInt(words[i]))) continue;
                    flashVersion = parseInt(words[i]);
                }
            }
        }
    }
    return { f: hasFlash, v: flashVersion };
}
function ajaxPage() {
    var newval = $("#gotonum").val();
    if (isNaN(newval))
        newval = 1;
    var oldUrl = window.location.search;
    var paramName = 'page';
    var nUrl = '';
    var re = eval('/(' + paramName + '=)([^&]*)/gi');
    if (oldUrl.length == 0) {
        nUrl = oldUrl + '?page=' + newval;
    }
    else if (oldUrl.indexOf(paramName) < 0)
        nUrl = oldUrl + '&page=' + newval;
    else {
        nUrl = oldUrl.replace(re, paramName + '=' + newval);
    }
    window.location.href = nUrl;
}
function ajaxRoutePage() {
    var newval = $("#gotonum").val();
    if (isNaN(newval))
        newval = 1;
    var oldUrl = window.location.href;
    var newUrl = "";
    var splitF = '?';
    var paramName = '_p';
    var href = "";
    if (oldUrl.indexOf(splitF) > 0) {
        newUrl = oldUrl.split(splitF)[0];
    }
    else {
        newUrl = oldUrl;
    }
    if (newUrl.indexOf(paramName) > 0) {
        if (parseInt(newval) > 1) {
            href = newUrl.split(paramName)[0] + paramName + newval;
        }
        else {
            href = newUrl.split(paramName)[0]
        }
    }
    else {
        if (parseInt(newval) > 1) {
            href = newUrl + paramName + newval;
        }
        else {
            href = newUrl;
        }
    }
    window.location.href = href;
}

