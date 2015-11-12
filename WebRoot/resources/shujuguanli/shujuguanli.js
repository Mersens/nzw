function addshuxing(){
	var shuxingid=$("#shuxingid").val();
	var shuxingname=$("#shuxingname").val();
	if(shuxingid==null || shuxingid=="" || shuxingname==null || shuxingname==""){
		alert("请填写完整");
	}else{
		$("#form").submit();
	}
}

function addyongtu(){
	var yongtuname=$("#yongtuname").val();
	var paixuval=$("#paixuval").val();
	if(yongtuname==null || yongtuname=="" || paixuval==null || paixuval==""){
		alert("请完善信息再提交");
	}else{
		$("#form").submit();
	}
}

function xuanze(obj){
	var cate=$(obj).find("option:selected").text();
	$("#xzvalue").html(cate);
}

function addchengfen(){
	var cate=$("#category").val();
	var chengfenname=$("#chengfenname").val();
	var paixuval=$("#paixuval").val();
	$("#cate").val(cate);
	if(cate==null || cate=="" || chengfenname==null || chengfenname=="" || paixuval==null || paixuval==""){
		alert("请完善信息再提交");
	}else{
		$("#form").submit();
	}
	
	
}

function addpinpai(){
	var pinpainame=$("#pinpainame").val();
	var paixuval=$("#paixuval").val();
	if(pinpainame==null || pinpainame=="" || paixuval==null || paixuval==""){
		alert("请完善信息再提交");
	}else{
		$("#form").submit();
	}
}

function addleimushuxing(){
	var cate=$("#category").val();
	var shuxing=$("#shuxing").val();
	var orderby=$("#orderby").val();
	$("#shuxingval").val(shuxing);
	if(cate==null || cate=="" || shuxing==null || shuxing=="" || orderby==null || orderby==""){
		alert("请完善信息再提交");
	}else{
		$("#form").submit();
	}
}