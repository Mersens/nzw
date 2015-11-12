function updatepwd(){
	var oldpwd=$("#oldPassword").val();
	var newpwd=$("#newPassword").val();
	var confirmpwd=$("#confirmPassword").val();
	
	if(oldpwd=="" || oldpwd==null || newpwd=="" || newpwd==null || confirmpwd=="" || confirmpwd==null){
		alert("请将信息填写完整再提交");
	}else if(newpwd!=confirmpwd){
		alert("两次密码输入不一致");
	}else if(oldpwd.length<6 || newpwd.length<6 || confirmpwd.length<6){
		alert("密码长度太短");
	}else{
		document.getElementById("submit").style.display="none";
		$.ajax({
			type:'post',
			url:'/userCenter/updateUserPassword ',
			data:{"oldpwd":oldpwd,"newpwd":newpwd,"confirmpwd":confirmpwd } ,
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("密码修改成功 ");
					document.getElementById("pwdForm").reset();
				}else if(data=="2"){
					alert("原密码输入不正确");
				}else if(data=="3"){
					alert("两次密码输入不一致");
				}else if(data=="0"){
					alert("请将信息填写完整再提交");
				}
				document.getElementById("submit").style.display="block";
			}
		});
		
	}
	
	
	
	
}