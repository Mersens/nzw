// JavaScript Document

$(function () {
	$(".main_lo .left_tit").each(function () {
		$(this).click(function () {
			if ($(this).hasClass("left_tit2")) {
				$(this).next(".l_list").hide();
				$(this).removeClass("left_tit2");
			}
			else {
				$(this).next(".l_list").show();
				$(this).addClass("left_tit2");
			}
		});
	});
});