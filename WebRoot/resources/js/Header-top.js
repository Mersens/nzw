// JavaScript Document

    $(function () {
        $("#s_myzg").mouseover(function () {
            $("#s_myzg").attr("class", "zgang");
            $("#i_myzg").attr("src", "/resources/images/top_xia.png");
            $("#d_myzg").show();
        }).mouseout(function () {
            $("#s_myzg").attr("class", "xianxiana");
            $("#i_myzg").attr("src", "/resources/images/top_xia2.png");
            $("#d_myzg").hide();
        });

        $("#s_service").mouseover(function () {
            $("#s_service").attr("class", "zgang");
            $("#i_service").attr("src", "/resources/images/top_xia.png");
            $("#d_service").show();
        }).mouseout(function () {
            $("#s_service").attr("class", "xianxiana");
            $("#i_service").attr("src", "/resources/images/top_xia2.png");
            $("#d_service").hide();
        });
        $("#s_xht").mouseover(function () {
            $("#s_xht").attr("class", "zgang");
            $("#i_xht").attr("src", "/resources/images/top_xia.png");
            $("#d_xht").show();
        }).mouseout(function () {
            $("#s_xht").attr("class", "xianxiana");
            $("#i_xht").attr("src", "/resources/images/top_xia2.png");
            $("#d_xht").hide();
        });
        $(".sjb").hover(function () {
            $(".sjm").show();
        }, function () {
            $(".sjm").hide();
        });
      
    });
