var zuoji=/^0\d{2,3}-?\d{7,8}$/;
var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;
var chinaname=/^[\u4E00-\u9FA5a-zA-Z0-9_]{0,}$/;
function addzaixianyijia(){
	var mingcheng=$("#mingcheng").val();
	var shuliang=$("#shuliang").val();
	var msgcenter=$("#msgcenter").val();
	var lianxiren=$("#lianxiren").val();
	var dianhua=$("#dianhua").val();
	if(mingcheng=="" || mingcheng==null || shuliang=="" || shuliang==null || msgcenter=="" || msgcenter==null || lianxiren=="" || lianxiren==null || dianhua=="" || dianhua==null){
		alert("请将信息填写完整再提交");
	}else if(shouji.test(dianhua)==false && zuoji.test(dianhua)==false){
		alert("请输入正确的联系电话");
	}else if(!chinaname.test(lianxiren)){
		alert("请输入正确的联系人");
	}else if(parseInt(shuliang)==0){
		alert("请输入有效的数量");
	}else{
		document.getElementById("submit").style.display="none";
		$.ajax({
			type:'post',
			url:'/dianpuWeb/addZaixianYijia',
		    data:$("#yijiaForm").serialize(),
		    success: function(data) {
               if(data=="1"){
            	   alert("提交成功");
            	   document.getElementById("yijiaForm").reset();
               }else if(data=="2"){
            	   alert("请将信息填写完整再提交");
               }else{
            	   alert("提交失败，请重新提交");
               }
               document.getElementById("submit").style.display="block";
            }
		});
		
	}
	
}