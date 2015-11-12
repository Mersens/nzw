var txnoover = true;
$(function () {
    $(".tcxx .tcxx1").click(function () {
        txnoover = false;
        $(".tcxx .tcxx1").hide();
        $(".tcxx .tcxx_m").show();
    });
    $(".tcxx .tcxx2").click(function () {
        txnoover = false;
        getCursor();
        $(".tcxx .tcxx2").hide();
        $(".tcxx .tcxx_m").show();
    });
    $(".tcxx_m .zd_but").click(function () {
        $(".tcxx .tcxx_m").hide();
        setTxstate();
    });
    //$(".tcxx .tcxx_m").mouseover(function () {
    //    $(".tcxx .tcxx1").hide();
    //    $(".tcxx .tcxx2").hide();
    //    $(".tcxx .tcxx_m").show();
    //    getCursor();
    //}).mouseout(function () {
    //    $(".tcxx .tcxx_m").hide();
    //    setTxstate();
    //});
    loadtxlist();
    setInterval("loadtxlist()", 30000);
    $(".tcxx_mm").mouseover(function () {
        txnoover = false;
    }).mouseout(function () {
        txnoover = true;
    });
    document.onclick = function () {
        if (txnoover) {
            $(".tcxx .tcxx_m").hide();
            setTxstate();
        }
    }
    $.post("/UCenter/Guide/IsCaigouNavShow", function (data) {
        if (data)
            $(".nav_m .nav_r").append('<a href="/UCenter/Guide/Info?type=1">完善采购信息</a>');
    })
});
function readmsg(id, tp) {
    $.post("/UCenter/Message/read", { id: id, msgtype: tp });
}
function setTxstate() {
    if ($(".tcxx .tcxx_m").css("display") == "none") {
        var _count = $(".tcxx .tcxx1 a").text();
        if ($("#tcxx").val() == "1" || parseInt(_count) == 0) {
            $(".tcxx .tcxx1").show();
            $(".tcxx .tcxx2").hide();
        }
        else {
            $(".tcxx .tcxx2").show();
            $(".tcxx .tcxx1").hide();
        }
    }
}
function loadtxlist() {
    $(".tcxx .xx_m").load("/UCenter/Message/HuiyanTx", function (data) {
        if (data.indexOf('404页面') > 0) {
            $(".tcxx .xx_m").html('<p style="line-height: 50px; text-align:center;">您暂时没有未读消息</p>');
        }
        txCursor();
    });
    $.post("/UCenter/Message/GetNoReadMsgCount", { index: 0 }, function (data) {
        if (data.indexOf('登录') > 0)
            window.location.reload();
        else {
            $(".tcxx .tcxx1 a").text(data);
            //$(".tcxx .tcxx2 a").text(data);
            //$(".tcxx .tcxx3 span").text(data);
            $(".dengluw span").text(data);
        }
    });
}
function txCursor() {
    $.get("/UCenter/Account/GetcursorMsg?date=" + (new Date()).getMilliseconds(), { maxid_type: $("#maxid_type").val() }, function (data) {
        $("#tcxx").val(data);
        setTxstate();
    });
}
function getCursor() {
    $.post("/UCenter/Account/cursorMsg", { maxid_type: $("#maxid_type").val() });
    $("#tcxx").val("1");
}

function delOrderMsg(id, type, obj) {
    if (confirm("确定要删除吗")) {
        $.post("/UCenter/Message/delMsg", { id: id, type: type }, function (msg) {
            if (msg == 1) {
                alert("删除成功");
                $(obj).parent().parent().remove();
            }
        });
    }
    //取消事件冒泡
    event.stopPropagation();
}


function delSystemMsg(id, type, obj) {
    if (confirm("确定要删除吗")) {
        $.post("/UCenter/Message/delMsg", { id: id, type: type }, function (msg) {
            if (msg == 1) {
                alert("删除成功");
                $(obj).parent().parent().parent().remove();
            }
        });
    }
    //取消事件冒泡
    event.stopPropagation();
}