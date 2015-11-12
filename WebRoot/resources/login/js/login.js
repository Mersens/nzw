var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;
function login(){
	 var username = $("#username").val();
	 var userpwd = $("#userpwd").val();
	document.getElementById("tishi").innerHTML=""; 
	if(!shouji.test(username) && !isRegisterUserName(username)){
		document.getElementById("tishi").innerHTML="手机号码或用户名格式错误";    
		return;
	}

	if(!IsPwd(userpwd)){
		document.getElementById("tishi").innerHTML="您输入的密码格式错误";    
		return;
	}
	document.getElementById('xianshisubmit').style.display = "none";
	$.ajax({
		type:'post',
		url:"/login/IsLogin",
		data:{
			  username:username,
			  userpwd:userpwd
		},
		dataType:'text',
		success:function(data){
			if(data=="true"){
				window.location.href='/user/info.html';
			}else{
				document.getElementById("tishi").innerHTML="您输入的账号或密码错误";    
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
//验证密码字数
function IsPwd(inputCode) {
   if (inputCode.length <= 0 || inputCode.length >=20) {
   	 return false;
   }  else{
   	return true;
   }
}

