/**
 * JavaScript JSONP Library v0.1
 * Copyright (c) 2011 snandy
 * Blog: http://www.cnblogs.com/snandy
 * QQ群: 34580561
 * Date: 2011-04-26
 * 
 * 接口
 * Sjax.load(
 *    url, // 跨越请求的URL
 *    success,  // 回调函数，必须定义一个形参，用于接收后台返回的全局变量jsonp （约定后台返回如jsonp = {...}结构）
 *    timestamp, // 传true会加一个时间戳，防止缓存，不传默认不加
 * );
 * 
 * 示例
 * Sjax.load('servlet/json', function(jsonp){
 *    // todo with jsonp
 * }, true);
 * 
 */

Sjax =
function(win){
		
	var isIE = /*@cc_on!@*/!1,
		doc = win.document,
		head = doc.getElementsByTagName('head')[0];
		
	function request(url, success, timestamp){
		var script = doc.createElement('script');
		
		function callback(){
			if(typeof jsonp != 'undefined'){
				success(jsonp);
			}else{
				alert('warning: jsonp did not return.');
			}		
			// Handle memory leak in IE
			script.onload = script.onreadystatechange = null;
			if( head && script.parentNode ){
				head.removeChild(script);
			}
		}
		if(isIE){
			script.onreadystatechange = function(){
				var readyState = this.readyState;
				if(readyState == 'loaded' || readyState == 'complete'){
					callback();
				}
			}
		}else{
			script.onload = function(){
				callback();
			}
		}
		if(timestamp){
			url += '?ts=' + (new Date).getTime();
		}
		script.src = url;
		head.insertBefore(script, head.firstChild);
	}
	
	return {load:request};
}(this);