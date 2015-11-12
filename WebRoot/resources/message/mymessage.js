/**
 * 加载页面时请求显示内容
 */
$(document).ready(
	function() {
		ajaxpage('1', "msgdiv",null,$("#typeid").val(), null,null, "/message/getMyMessageData");
	}
);






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
	document.getElementById("typeid").value=typeid; 
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

function chaxun(val){
	$("#typeid").val(val);
	for(var i=0;i<4;++i){
		if(i==val){
			$("#type"+val).removeClass("itemnav");
			$("#type"+val).addClass("itemnav curnav");
		}else{
			$("#type"+i).removeClass("itemnav curnav");
			$("#type"+i).addClass("itemnav");
		}
	}
	ajaxpage('1', "msgdiv",null,$("#typeid").val(), null,null, "/message/getMyMessageData");
}

function delmsg(id,page){
	if(confirm("确定要删除吗？")){
		$.ajax({
			type:'post',
			url:'/message/deleteMyMessage',
			data:{"msgid":id},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("删除成功 ");
					ajaxpage(page, "msgdiv",null,$("#typeid").val(), null,null, "/message/getMyMessageData");
				}else{
					alert("删除失败");
				}
			}
		});
	}
}

