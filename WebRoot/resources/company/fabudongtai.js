/**
 * 加载页面时请求显示内容
 */
$(document).ready(
	function() {
		ajaxpage('1', "dongtaidiv",null,$("#newstitle").val(), null,null, "/gongsi/getGongsiDongtaiData");
	}
);


function fabu(){
	var title=$("#title").val();
	var keywords=$("#keywords").val();
	var miaoshu=$("#miaoshu").val();
	var center=$("#center").val();
	if(title=="" || miaoshu=="" || center==""){
		alert("请完善信息");
	}else{
		document.getElementById("newsForm").submit();
	}
}




/**
 * 关于AJAX的数据更新
 * 
 * @param page	页面
 * @param id	要显示的id
 * @param starttime 	开始时间
 * @param endtime 	结束时间
 * @param url	请求的路径
 * 
 */
function ajaxpage(page, id, status,typeid, starttime,endtime,url) {
	document.getElementById("newstitle").value=typeid; 
	$.ajax({
		type:'get',
		url:url,
		data:{"page":page,"typeid":typeid},
		dataType:'text',
		success:function(data){
			document.getElementById(id).innerHTML = data;
		}
	});
}

function deleteDongtai(val){
	if(confirm("确定要删除吗？")){
		$.ajax({
			type:'post',
			url:'/gongsi/deleteGongsiDongtai',
			data:{"newsid":val},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("删除成功 ");
					var keywords=$("#newstitle").val();
					ajaxpage('1', "dongtaidiv",null, keywords,null, null,"/gongsi/getGongsiDongtaiData");
				}else{
					alert("删除失败");
				}
			}
		});
	}
}

function sousuo(){
	var keywords=$("#newstitle").val();
	if(keywords!=null && keywords!=""){
		document.getElementById("newstitle").innerHTML=keywords; 
		ajaxpage('1', "dongtaidiv", null,$("#newstitle").val(),null,null,"/gongsi/getGongsiDongtaiData");
	}
}

