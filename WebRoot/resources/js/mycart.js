var diaContent = "";
$(function () {
    diaContent = $(".bjPop").html();
})
function addToCart(pid, ton) {
    $.post("/Product/AddToCart", { productId: pid, ton: ton }, function (data) {
        if (data == "-1")
        {
            layer.alert("请先补全企业信息", 12, function () {
                window.location = "/UCenter/EnterpriseAuthentication";
            });
            
            return;
        }
        if (data == "2") {
            layer.alert("不能购买自家店铺资源", 12);
            return;
        }
        //if (data=="1") {
            $.layer({
                type: 2,
                border: [0],
                title: ['确认操作', false],
                iframe: { src: '/Product/ShopCar?pid=' + pid },
                area: ['480px', '230px'],
                offset: ['150px', ''],
                close: function (index) {
                    layer.close(index);
                },
                closeBtn: [0, false]

            });
        //} else {
        //    $.layer({
        //        type: 2,
        //        border: [0],
        //        title: ['确认操作', false],
        //        iframe: { src: '/Product/ConfirmNo' },
        //        area: ['500px', '242px'],
        //        offset: ['150px', ''],
        //        close: function (index) {
        //            layer.close(index);
        //        }
        //    });
        //}
        //if (data == "1") {
        //    $(".bjPop").html(diaContent).dialog({
        //        modal: true,
        //        title: "确认操作",
        //        width: 494,
        //        height: 219,
        //        bgiframe: true,
        //        resize: false

        //    });
        //} else {
        //    var sameStr = $("#closeDia").html();
        //    $(".bjPop").html(sameStr).dialog({
        //        modal: true,
        //        title: "确认操作",
        //        width: 494,
        //        height: 219,
        //        bgiframe: true,
        //        resize: false

        //    });
        //}

    });
}
//委托购买
function wtgm(pid) {
    $.layer({
        type: 2,
        border: [0],
        title: ['委托购买', false],
        iframe: { src: '/Product/MyPurchase?pid=' + pid },
        area: ['539px', '297px'],
        offset: ['150px', ''],
        close: function (index) {
            layer.close(index);
        }
    });
}
/*无提示批量下单*/
function addToCart2(pid, ton) {
    $.post("/Product/AddToCart", { productId: pid, ton: ton }, function (data) {      

    });
}