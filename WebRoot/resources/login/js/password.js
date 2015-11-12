var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;

//用于刷新验证码
function genghuan() {
	var url = "/yanzhengma.html?date=" + new Date();
	$("#yzm").attr("src", url);
}


function testname(){
	var username=$("#username").val();
	var yanzhengma=$("#yanzhengma").val();
	if(username=="" || yanzhengma==""){
		alert("信息填写不完整");
	}else{
		$.ajax({
			type:'post',
			url:'/password/gotoTestUsername',
			data:{"username":username,"yanzhengma":yanzhengma},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="findpwd_2.html";
				}else if(data=="0"){
					alert("信息填写不完整");
				}else if(data=="2"){
					alert("用户名不存在");
				}else if(data="3"){
					alert("验证码输入不正确");
				}
			}
		});
	}
	
}

function testphone(){
	var userphone=$("#userphone").val();
	var phonecode=$("#phonecode").val();
	if(userphone=="" || phonecode==""){
		alert("信息填写不完整");
	}else{
		$.ajax({
			type:'post',
			url:'/password/gotoTestUserphone',
			data:{"userphone":userphone,"phonecode":phonecode},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="findpwd_3.html";
				}else if(data=="0"){
					alert(data)
					alert("信息填写不完整");
				}else if(data=="2"){
					alert("手机号码未绑定");
				}else if(data="3"){
					alert("验证码输入错误");
				}else if(data="4"){
					window.location.href="/login.html";
				}
			}
		});
	}
	
}

function updatepwd(){
	var newpwd=$("#newpwd").val();
	var renewpwd=$("#renewpwd").val();
	if(newpwd=="" || renewpwd==""){
		alert("信息填写不完整");
	}else if(!IsPwd(newpwd)){
		alert("密码格式错误");
	}else if(newpwd!=renewpwd){
		alert("两次密码输入不一致");
	}else{
		$.ajax({
			type:'post',
			url:'/password/gotoUpdatePassword',
			data:{"newpwd":newpwd,"renewpwd":renewpwd},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="/success.html";
				}else if(data=="0"){
					alert("信息填写不完整");
				}else if(data=="2"){
					alert("两次密码输入不一致");
				}else if(data="3"){
					window.location.href="/login.html";
				}
			}
		});
	}
	
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

function sendcode() { 
	var phone = $("#userphone").val();
	if(issend==1){
		if(!shouji.test(phone)){
			alert("您输入的手机号码错误 ");
			return;
		}
		$.ajax({
			type:'post',
			url:"/password/sendrandByPhone",
			data:{
				userphone : phone
			},
			dataType:'text',
			success:function(data){
				if(data=="false"){
					alert("您输入的手机号码错误 ");
				}else{
					issend=0;
					settime();
				}
			}
		});
	}
} 



//获取手机验证码


function settime() { 
   if (countdown == 0) { 
		document.getElementById("botn").removeAttribute("disabled");    
		document.getElementById("botn").innerHTML="获取验证码"; 
        issend=1;
		countdown = 60; 
		return;
   } else { 
		document.getElementById("botn").setAttribute("disabled", true); 
		document.getElementById("botn").innerHTML="重新发送(" + countdown + ")"; 
		countdown--; 
   } 
	setTimeout(function() { 
	settime(); 
	},1000);
} 
