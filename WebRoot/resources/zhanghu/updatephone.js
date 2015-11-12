var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;

//用于刷新验证码
function genghuan() {
	var url = "/yanzhengma.html?date=" + new Date();
	$("#yzm").attr("src", url);
}

//设定倒数秒数  
var t=90;
//显示倒数秒数  
function showTime(){ 
   t -= 1;  
	document.getElementById("huoqu").style.display="none";
	document.getElementById("rehuoqu").style.display="block";
    document.getElementById("showtime").innerHTML= t;  
   if(t!=0){  
   	//每秒执行一次,showTime()  
	   
   	setTimeout("showTime()",1000);  
   }else{
   	document.getElementById("rehuoqu").style.display="none";
   	document.getElementById("huoqu").style.display="block";
   }
}  

function getPhoneCode(){
	t=90;
	showTime();
	$.ajax({
		type:'post',
		url:'/userCenter/sendPhoneCode',
		dataType:'text',
		success:function(data){
			if(data=="1"){
				alert("验证码已发送至您的手机，请注意查收。");
			}else{
				alert("手机验证码发送失败");
			}
		}
	});
}

function gotoUpdatePhone(){
	var phoneCode=$("#phoneCode").val();
	var yanzhengma=$("#validateCode").val();
	if(phoneCode=="" || phoneCode==null){
		document.getElementById("phoneCode").focus();
		alert("请输入手机验证码");
	}else if(yanzhengma=="" || yanzhengma==null){
		document.getElementById("validateCode").focus();
		alert("请输入验证码");
	}else{
		document.getElementById("phoneForm").submit();
	}
	
}

function getNewPhoneCode(){
	t=90;
	showTime();
	var newphone=$("#NewMobile").val();
	if(newphone=="" || newphone==null){
		alert("请输入手机号码");
	}else if(!shouji.test(newphone)){
		alert("手机号码不正确");
	}else{
		$.ajax({
			type:'post',
			url:'/userCenter/sendNewPhoneCode',
			data:{"newphone":newphone},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("验证码已发送至您的手机，请注意查收。");
				}else{
					alert("手机验证码发送失败");
				}
			}
		});
	}
}


function updatePhone(){
	var newphone=$("#NewMobile").val();
	var phoneCode=$("#MobileCode").val();
	var yanzhengma=$("#ValidateCode").val();
	if(phoneCode=="" || phoneCode==null){
		document.getElementById("MobileCode").focus();
		alert("请输入手机验证码");
	}else if(yanzhengma=="" || yanzhengma==null){
		document.getElementById("ValidateCode").focus();
		alert("请输入验证码");
	}else if(newphone==""){
		document.getElementById("NewMobile").focus();
		alert("请输入手机号码");
	}else{
		$.ajax({
			type:'post',
			url:'/user/zhanghu/xgsj3.html',
			data:{"phoneCode":phoneCode,"yanzhengma":yanzhengma,"newphone":newphone},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="/user/zhanghu/xgsjsuccess.html";
				}else if(data=="0"){
					alert("信息填写不完整");
				}else if(data=="2"){
					alert("手机验证码输入不正确");
				}else if(data="3"){
					alert("验证码输入不正确");
				}
			}
		});
	}
}