/**
 * 加载页面时请求显示内容
 */
$(document).ready(
	function() {
		$("#cxstatus2").addClass("qhover");
		ajaxpage('1', "xjdata",$("#status").val(),$("#xjname").val(), $("#sdate").val(),$("#edate").val(), "/xunjia/getXunjiaData");
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
function ajaxpage(page, id, status,xjname, starttime,endtime,url) {
	document.getElementById("status").value=status; 
	document.getElementById("xjname").value=xjname; 
	document.getElementById("sdate").value=starttime; 
	document.getElementById("edate").value=endtime; 
	$("#cxstatus"+status).addClass("qhover");
	$.ajax({
		type:'get',
		url:url,
		data:{"page":page,"status":status,"xjname":xjname,"sdate":starttime,"edate":endtime},
		dataType:'text',
		success:function(data){
			document.getElementById(id).innerHTML = data;
		}
	});
}

function chexiao(val){
	if(confirm("确定要撤消吗？")){
		$.ajax({
			type:'post',
			url:'/xunjia/deleteGongsiDongtai',
			data:{"newsid":val},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("删除成功 ");
					var keywords=$("#xjname").val();
					ajaxpage('1', "xjdata", keywords,null,null, "/xunjia/getXunjiaData");
				}else{
					alert("删除失败");
				}
			}
		});
	}
}

function sousuo(){
	var xjname=$("#xjname").val();
	var status=$("#status").val();
	
	if(xjname!=null && xjname!=""){
		document.getElementById("xjname").innerHTML=xjname; 
	}
	ajaxpage('1', "xjdata",status,$("#xjname").val(), $("#sdate").val(),$("#edate").val(),"/xunjia/getXunjiaData");
}

function chaxun(val){
	$("#status").val(val);
	for(var i=0;i<4;++i){
		$("#cxstatus"+i).removeClass("qhover");
	  }
	ajaxpage('1', "xjdata",val,$("#xjname").val(), $("#sdate").val(),$("#edate").val(),"/xunjia/getXunjiaData");
}

function chakan(id){
	var ydcount=document.getElementById("status1").innerHTML;
	var wdcount=document.getElementById("status0").innerHTML;
	$.ajax({
		type:'post',
		url:'/xunjia/updateXunjiaStatic',
		data:{"xunjiaid":id},
		dataType:'text',
		success:function(data){
			if(data=="1"){
				document.getElementById("status0").innerHTML=parseInt(wdcount)-1;
				document.getElementById("status1").innerHTML=parseInt(ydcount)+1;
			}
			document.getElementById('wd'+id).style.display='none';
			document.getElementById('yd'+id).style.display='block';
		}
	});
}
