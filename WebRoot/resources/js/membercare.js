function initCare() {
    $("#bnt_search").click(function () {
        window.location.href = "?Pm=" + $("#Pm").val();
    });
    $("#ck_all").click(function () {
        $("input[name=ck_product]").each(function () {
            $(this).prop("checked", $("#ck_all").prop("checked"));
            $("#ck_all1").prop("checked", $("#ck_all").prop("checked"))
        });
    });
    $("#ck_all1").click(function () {
        $("input[name=ck_product]").each(function () {
            $(this).prop("checked", $("#ck_all1").prop("checked"));
            $("#ck_all").prop("checked", $("#ck_all1").prop("checked"))
        });
    });
    $("#bnt_cancelcare").click(function () {
        var cek = $("input[name=ck_product]:checked").val();
        if (cek == null) {
            alert("请选中关注的商品再取消关注！");
            return;
        }
        if(!confirm("确定要取消关注吗?"))
            return;
        $("input[name=ck_product]:checked").each(function (i) {
            if (i == 0)
                cek = $(this).val();
            else
                cek += "," + $(this).val();
        });
        $.ajax({
            type: "GET",
            dataType: "Text",
            url: "CancelCare",
            data: { ids: cek },
            success: function (data) {
                window.location.href = "?";
            },
            error: function () {
                alert("链接错误");
            }
        });
    });
    $("#bnt_addorder").click(function () {
        var cek = $("input[name=ck_product]:checked").val();
        if (cek == null) {
            alert("请选中关注的商品！");
            return;
        }
        if (!confirm("确定要加入购物车吗?"))
            return;
        var ename = "";
        var istrue = true;
        $("input[name=ck_product]:checked").each(function (i) {
            var id = $(this).val();
            var new_ename = $("#hidenam_" + id).val();
            var pid = $("#hidpid_" + id).val();
            if (ename == "")
                ename = new_ename;
            else if (ename != new_ename)
            {
                alert('不能同时对不同供应商下单！');
                istrue = false;
                return;
            }
            if (pid == 0)
            {
                alert('有不存在的商品，请重新选择！');
                istrue = false;
                return;
            }
        });
        if (istrue) {
            $("input[name=ck_product]:checked").each(function (i) {
                var id = $(this).val();
                var pid = $("#hidpid_" + id).val();
                var ton = $("#hidton_" + id).val();
                addToCart2(pid, ton);
            });
            alert('已加入购物车，请前往购物车完成订单操作');
            window.open('/Product/CartList');
        }
    });
}
function del(id)
{
    if (!confirm("确定要取消关注吗?"))
        return;
    window.location.href = "/UCenter/BuyerCenter/CancelCareAction?ids=" + id;
}
function initCareEn()
{
    $("#bnt_search").click(function () {
        window.location.href = "?Em=" + $("#Em").val();
    });
    $("#ck_all").click(function () {
        $("input[name=ck_product]").each(function () {
            $(this).prop("checked", $("#ck_all").prop("checked"));
            $("#ck_all1").prop("checked", $("#ck_all").prop("checked"))
        });
    });
    $("#ck_all1").click(function () {
        $("input[name=ck_product]").each(function () {
            $(this).prop("checked", $("#ck_all1").prop("checked"));
            $("#ck_all").prop("checked", $("#ck_all1").prop("checked"))
        });
    });
    $("#bnt_cancelcare").click(function () {
        var cek = $("input[name=ck_product]:checked").val();
        if (cek == null) {
            alert("请选择取消关注的店铺");
            return;
        }
        if (!confirm("确定要取消关注吗?"))
            return;
        $("input[name=ck_product]:checked").each(function (i) {
            if (i == 0)
                cek = $(this).val();
            else
                cek += "," + $(this).val();
        });
        $.ajax({
            type: "GET",
            dataType: "Text",
            url: "CancelCareEm",
            data: { ids: cek },
            success: function (data) {
                window.location.href = "?";
            },
            error: function () {
                alert("链接错误");
            }
        });
    });
}
function delen(id) {
    if (!confirm("确定要取消关注吗?"))
        return;
    window.location.href = "/UCenter/BuyerCenter/CancelCareEmAction?ids=" + id;
}