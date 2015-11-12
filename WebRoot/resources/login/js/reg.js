var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;
//在线协议选取的测试
function xiexi(){
	if($("#xiexi").is(":checked")){
		 document.getElementById('yincangsubmit').style.display = "none";
		  document.getElementById('xianshisubmit').style.display = "";
		  
	}else{
		 document.getElementById('xianshisubmit').style.display = "none";
		  document.getElementById('yincangsubmit').style.display = "";
	}
}

function IsReg(){
	 var phone = $("#phone").val();
	 var username = $("#username").val();
	 var userpwd = $("#userpwd").val();
	 var userrand = $("#userrand").val();
	document.getElementById("tishi").innerHTML=""; 
	if(!shouji.test(phone)){
		document.getElementById("tishi").innerHTML="您输入的手机号码错误";    
		return;
	}
	if(!isRegisterUserName(username) || username=="请输入用户名"){
		document.getElementById("tishi").innerHTML="您输入的用户登录名错误";    
		return;
	}
	if(!validate(userrand)){
		document.getElementById("tishi").innerHTML="您输入的验证码错误";    
		return;
	}
	if(!IsPwd(userpwd)){
		document.getElementById("tishi").innerHTML="您输入的密码格式错误";    
		return;
	}
	document.getElementById('xianshisubmit').style.display = "none";
	$.ajax({
		type:'post',
		url:"/reg/IsReg",
		data:{
			  phone:phone,
			  username:username,
			  userpwd:userpwd,
			  userrand:userrand
		},
		dataType:'text',
		success:function(data){
			if(data=="true"){
				window.location.href='/user/info.html';
			}else{
				document.getElementById('xianshisubmit').style.display = "";
			}
		}
	});
}
//验证用户名
function isRegisterUserName(s)  
{  
var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;  
if (!patrn.exec(s)) return false;
return true;
} 
//验证验证码字数
function validate(inputCode) {
    if (inputCode.length <= 0 || inputCode.length !=6) {
    	 return false;
    }  else{
    	return true;
    }
}
//验证验证码字数
function IsPwd(inputCode) {
    if (inputCode.length <= 0 || inputCode.length >=20) {
    	 return false;
    }  else{
    	return true;
    }
}


var countdown=60; 
var issend=1; 

//获取手机验证码

function sendrand(val) { 
	document.getElementById("tishi").innerHTML=""; 
	var phone = $("#phone").val();
	if(issend==1){
		if(!shouji.test(phone)){
			document.getElementById("tishi").innerHTML="您输入的手机号码错误";    
			return;
		}
		$.ajax({
			type:'post',
			url:"/reg/sendrandByPhone",
			data:{
				phone : phone
			},
			dataType:'text',
			success:function(data){
				if(data=="false"){
					document.getElementById("tishi").innerHTML="您输入的手机号码已经被注册过了";    
				}else{
					issend=0;
					settime(val);
				}
			}
		});
	}
} 



//获取手机验证码


function settime(val) { 
if (countdown == 0) { 
val.removeAttribute("disabled");    
val.value="免费获取验证码"; 
issend=1;
countdown = 60; 
return;
} else { 
val.setAttribute("disabled", true); 
val.value="重新发送(" + countdown + ")"; 
countdown--; 
} 
setTimeout(function() { 
settime(val) 
},1000) 
} 
