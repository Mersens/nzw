// JavaScript Document

 var _focusProductArea, taxindex = 0;
    $(function () {
        $.post("/Category/GetChangJia", function (data) {
            _saarea = data;
            $(".xjd_list li").remove();
            $(".xjd_list").append("<li><a href='javascript:void(0);'>不限</a></li>");
            $.each(data, function (i, d) {
                $(".xjd_list").append("<li><a href='javascript:void(0);'>" + d.Name + "</a></li>");
            });
            $(".xjd_list li a").click(function () {
                _focusProductArea.val($(this).text());
                $(".xjd_list").hide();
            });
        });
        productEvenLoad();
        $(".xjd_list").mouseover(function () {
            $(this).show();
        }).mouseout(function () {
            $(this).hide();
        });
        $("#add_cg").click(function () {
            taxindex += 1;
            $(".xjd_tab").append('<tr><td><a class="delete_cg" href="javascript:void(0);"><img src="images/xjd_jian.png" style="margin-bottom:2px; margin-right:6px;"/></a><input name="Pm" class="xjd_inp" type="text" value="" /></td><td><input name="Cz" style=" width:130px;" class="xjd_inp" type="text" value="" /></td><td><input name="Gg" style=" width:140px;" class="xjd_inp" type="text" value="" /></td><td><input name="Ton" class="xjd_inp" type="text" value="" /></td><td><div id="cj" class="xjd_s cjxz"><input id="ProductArea" name="ProductArea" type="text" value="" autocomplete="off" /></div></td><td><div class="xjd_s" style="position:relative;"><input for="area" name="DeliveryArea" type="text" value="" autocomplete="off" /> </div></td><td><input type="hidden" name="cgindex" value="' + taxindex + '" /><input name="IsTax' + taxindex + '" type="checkbox" checked="checked" value="true" />&nbsp;需要报含税价</td></tr>');
            $(".delete_cg").click(function () {
                $(this).closest("tr").remove();
                checkdel();
            });
            checkdel();
            areaEvenLoad();
            productEvenLoad();
        });
        var gg = "", w = "", w1 = "", h = "", h1 = "";
        gg = getUrlParam("gg");
        w = getUrlParam("w");
        w1 = getUrlParam("w1");
        h = getUrlParam("h");
        h1 = getUrlParam("h1");
        if (w != null && w1 != null) {
            gg += "*(" + w + "-" + w1 + ")";
        }
        else if (w != null || w1 != null) {
            if (w != null) {
                gg += "*" + w;
            }
            else if (w1 != null) {
                gg += "*" + w1;
            }
        }
        if (h != null && h1 != null) {
            gg += "*(" + h + "-" + h1 + ")";
        }
        else if (h != null || h1 != null) {
            if (h != null) {
                gg += "*" + h;
            }
            else if (h1 != null) {
                gg += "*" + h1;
            }
        }
        $("#Gg").val(gg);
    });
    function productEvenLoad() {
        $("input[name=ProductArea]").click(function () {
            _focusProductArea = $(this);
            $(".xjd_list").css("top", (parseInt($(this).offset().top) + parseInt($(this).css("height"))));
            $(".xjd_list").css("left", ($(this).offset().left));
            $(".xjd_list").show();
        });
        //$("input").attr("maxlength", "15");
    }
    function OnSuccess(data) {
        if (data == "1") {
            $.layer({
                type: 2,
                border: [0],
                closeBtn: [0],
                title: false,
                iframe: { src: '/XunJia/XunJiaOk' },
                area: ['370px', '200px'],
                close: function (index) {
                    layer.close(index);
                }
            })
        }
        else {
            var arry = new Array();
            var str = "";
            if (data.indexOf(",")>0)
            {
                //str += "(";
                arry = data.split(',');
                for (var i = 0; i < arry.length; i++)
                {
                    if ($.trim(arry[i]) != "") {
                        if (arry[i].indexOf(".") < 0) {
                            str += arry[i] + "、";
                        }
                        else {
                            var a = arry[i].split('.');
                            for (var j = 0; j < a.length; j++) {
                                if (j == a.length - 1) {
                                    str += arry[j] + "、";
                                }
                            }
                        }
                    }
                }
                str = str.substring(0,str.length - 1);
                //str += ")";
                $("#unerror").text(str);
                $(".mask").css("opacity", "0.8").show();
                showDialog();
                $("#showbox").fadeIn();
                $(".top_ws").show();
                $(".top_xg").hide();

            }
            else if (data.indexOf(".") > 0) {
            
                arry = data.split('.');
                for (var i = 0; i < arry.length; i++) {
                    if ($.trim(arry[i]) != "") {
                        if (data.indexOf(",") < 0) {
                            str += arry[i] + "、";
                        } else {
                            var a = arry[i].split(',');
                            for (var j = 0; j < a.length; j++) {
                                if (j == a.length - 1) {
                                    str += arry[j] + "、";
                                }
                            }
                        }
                    }
                }
                str = str.substring(0, str.length - 1);
              
                $("#errorcon").text(str);
                $(".mask").css("opacity", "0.8").show();
                showDialog();
                $("#showbox").fadeIn();
                $(".top_ws").hide();
                $(".top_xg").show();
            }
            else {
                $(".field-validation-error").text(data);
            }
        }
    }
    function checkdel() {
        if ($(".delete_cg").length == 1)
            $(".delete_cg").hide();
        else
            $(".delete_cg").show();
    }
    //获取URL参数值
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    $(function () {
        $(".btn_del").click(function () {
            $("#showbox").fadeOut();
            $(".mask").hide();

        });
    })
    function close() {
        $("#showbox").hide();
        $(".mask").hide();
    }
    function showDialog() {
        var objw = $(window);
        var objc = $("#showbox");
        var brsw = objw.width();
        var brsh = objw.height();
        var sclL = objw.scrollLeft();
        //var sclT=objw.scrollTop();
        var curw = objc.width();
        var curh = objc.height();


        var left = sclL + (brsw - curw) / 2;
        var top = (brsh - curh) / 2;

        objc.css({ "left": left, "top": top });
    }


    $(window).resize(function () {
        if (!$("#showbox").is(":visible")) {
            return;
        }
        showDialog();
    });