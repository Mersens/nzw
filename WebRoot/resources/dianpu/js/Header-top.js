// JavaScript Document
    $(function () {
        $("#s_myzg").mouseover(function () {
            $("#s_myzg").attr("class", "zgang");
            $("#i_myzg").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#d_myzg").show();
        }).mouseout(function () {
            $("#s_myzg").attr("class", "xianxiana");
            $("#i_myzg").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#d_myzg").hide();
        });

		$("#s_wnz").mouseover(function () {
            $("#s_wnz").attr("class", "zgang");
            $("#i_wnz").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#d_wnz").show();
        }).mouseout(function () {
            $("#s_wnz").attr("class", "xianxiana");
            $("#i_wnz").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#d_wnz").hide();
        });
			
        $("#s_service").mouseover(function () {
            $("#s_service").attr("class", "zgang");
            $("#i_service").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#d_service").show();
        }).mouseout(function () {
            $("#s_service").attr("class", "xianxiana");
            $("#i_service").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#d_service").hide();
        });
		
		
		
        $("#s_xht").mouseover(function () {
            $("#s_xht").attr("class", "zgang");
            $("#i_xht").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#d_xht").show();
        }).mouseout(function () {
            $("#s_xht").attr("class", "xianxiana");
            $("#i_xht").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#d_xht").hide();
        });
		
		
		
		$("#x_xht").mouseover(function () {
            $("#x_xht").attr("class", "zgang");
            $("#c_xht").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#b_xht").show();
        }).mouseout(function () {
            $("#x_xht").attr("class", "xianxiana");
            $("#c_xht").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#b_xht").hide();
        });
		
		
		
		$("#m_service").mouseover(function () {
            $("#m_service").attr("class", "zgang");
            $("#l_service").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#b_service").show();
        }).mouseout(function () {
            $("#m_service").attr("class", "xianxiana");
            $("#l_service").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#b_service").hide();
        });
		
		
		$("#m_preson").mouseover(function () {
            $("#m_preson").attr("class", "zgang");
            $("#l_preson").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#b_preson").show();
        }).mouseout(function () {
            $("#m_preson").attr("class", "xianxiana");
            $("#l_preson").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#b_preson").hide();
        });
		
		$("#m_money").mouseover(function () {
            $("#m_money").attr("class", "zgang");
            $("#l_money").attr("src", "/resources/dianpu/images/top_xia.png");
            $("#b_money").show();
        }).mouseout(function () {
            $("#m_money").attr("class", "xianxiana");
            $("#l_money").attr("src", "/resources/dianpu/images/top_xia2.png");
            $("#b_money").hide();
        });
		
		
		
        $(".sjb").hover(function () {
            $(".sjm").show();
        }, function () {
            $(".sjm").hide();
        });
      
    });
