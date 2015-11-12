// JavaScript Document

$(document).ready(function(){
	var hdw = $('.content ul li:gt(7):not(:last)');

	hdw.hide();

	$('.boxmore a').click(function(){
		if (hdw.is(':visible')){
			hdw.hide();
			$('.boxmore a span').css('background','url(images/down.png) no-repeat center right').text('更多');
			$('ul li').removeClass('onebox');
		}else{
			hdw.show();
			$('.boxmore a span').css('background','url(images/up.png) no-repeat center right').text('隐藏');
		};
		return false;
	});
});


$(document).ready(function(){
	var hdw = $('.content1 ul li:gt(7):not(:last)');

	hdw.hide();

	$('.boxmore1 a').click(function(){
		if (hdw.is(':visible')){
			hdw.hide();
			$('.boxmore1 a span').css('background','url(images/down.png) no-repeat center right').text('更多');
			$('ul li').removeClass('onebox');
		}else{
			hdw.show();
			$('.boxmore1 a span').css('background','url(images/up.png) no-repeat center right').text('隐藏');
		};
		return false;
	});
});


$(document).ready(function(){
	var hdw = $('.content2 ul li:gt(7):not(:last)');

	hdw.hide();

	$('.boxmore2 a').click(function(){
		if (hdw.is(':visible')){
			hdw.hide();
			$('.boxmore2 a span').css('background','url(images/down.png) no-repeat center right').text('更多');
			$('ul li').removeClass('onebox');
		}else{
			hdw.show();
			$('.boxmore2 a span').css('background','url(images/up.png) no-repeat center right').text('隐藏');
		};
		return false;
	});
});

$(document).ready(function(){
	var hdw = $('.content3 ul li:gt(7):not(:last)');

	hdw.hide();

	$('.boxmore3 a').click(function(){
		if (hdw.is(':visible')){
			hdw.hide();
			$('.boxmore3 a span').css('background','url(images/down.png) no-repeat center right').text('更多');
			$('ul li').removeClass('onebox');
		}else{
			hdw.show();
			$('.boxmore3 a span').css('background','url(images/up.png) no-repeat center right').text('隐藏');
		};
		return false;
	});
});



$(document).ready(function(){
	var hdw = $('.content4 ul li:gt(7):not(:last)');

	hdw.hide();

	$('.boxmore4 a').click(function(){
		if (hdw.is(':visible')){
			hdw.hide();
			$('.boxmore4 a span').css('background','url(images/down.png) no-repeat center right').text('更多');
			$('ul li').removeClass('onebox');
		}else{
			hdw.show();
			$('.boxmore4 a span').css('background','url(images/up.png) no-repeat center right').text('隐藏');
		};
		return false;
	});
});