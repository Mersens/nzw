// JavaScript Document

$(document).ready(function() {
	$(".SouDiqu ul.nav li").hover(function(){
		$(this).addClass("on");

	},
	function(){
		$(this).removeClass("on");

	})
});

$(document).ready(function() {
	$(".SouDiqu ul.nav li").hover(function(){
		$(this).parent(".ffff").siblings("p").addClass("choice");

	},
	function(){
		$(this).parent(".ffff").siblings("p").removeClass("choice");
	})
});

$(document).ready(function() {       
		if ($(".SouDiqu ul.nav li").find(".ffff") .html()!="") {
			$(".SouDiqu ul.nav li").parent(".ffff").siblings("p").append("<span class='sub'></span>");                
		}
});