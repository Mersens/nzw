/**
 * 加载页面时请求显示内容
 */
$(document).ready(
	function() {
		var status=$("#status").val();
		if(status==null || status==''){
			$("#cpstatus1").addClass("active");
		}
		ajaxpage('1', "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
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
	$("#cpstatus"+status).addClass("active");
	$.ajax({
		type:'get',
		url:url,
		data:{"page":page,"status":status},
		dataType:'text',
		success:function(data){
			document.getElementById(id).innerHTML = data;
		}
	});
}

function chaxun(val){
	$("#status").val(val);
	for(var i=0;i<4;++i){
		$("#cpstatus"+i).removeClass("active");
	  }
	ajaxpage('1', "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
}

function xiajia(id,page){
	if(confirm("确定要下架此商品吗？")){
		$.ajax({
			type:'post',
			url:'/sellerCenter/updateChanpinStatus',
			data:{"id":id},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("该商品已成功下架");
					ajaxpage(page, "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
				}
			}
		});
	}
}


function addChanpin(){
	var title=$("#title").val();
	var keyword=$("#keyword").val();
	var miaoshu=$("#miaoshu").val();
	var offerDetail=$("#offerDetail").val();
	if(title=='' || title==null || keyword=='' || keyword==null || miaoshu=='' || miaoshu==null){
		alert("请完善信息再提交");
		return;
	}else{
		$.ajax({
			type:'post',
			url:'/sellerCenter/addChanpinXinxi',
			data:$("#shangpinform").serialize(),
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href='/user/seller/fabu4.html';
				}
			}
		});
	}
}

function tijiaochanpin(){
	var unit=$("#unit").val();
	var jiage=$("#jiage").val();
	if(unit=='' || jiage=='' || unit==null || jiage==null){
		alert("请完善信息再提交");
		return;
	}else{
		$.ajax({
			type:'post',
			url:'/sellerCenter/addChanpinJiaoyiXinxi',
			data:{"unit":unit,"jiage":jiage},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href='/user/seller/fabusuccess.html';
				}
			}
		});
	}
	
	
}

function allxiajia(){
	var order = [];
	$("[name=chanpin]:checked").each(function() {
		order.push($(this).val());
	});
	var values = order.join(',');
	if(confirm("确定要下架所选产品吗？")){
		$.ajax({
			type:'post',
			url:'/sellerCenter/updateAllChanpinStatus',
			data:{"ids":values},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("批量下架成功");
					ajaxpage('1', "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
				}
			}
		});
	}
}

function deleteAll(){
	var order = [];
	$("[name=chanpin]:checked").each(function() {
		order.push($(this).val());
	});
	var values = order.join(',');
	if(confirm("确定要删除所选产品吗？")){
		$.ajax({
			type:'post',
			url:'/sellerCenter/deleteAllChanpin',
			data:{"ids":values},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("批量删除成功");
					ajaxpage('1', "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
				}
			}
		});
	}
}

function shangjia(id,page){
	if(confirm("确定要上架此产品吗？")){
		$.ajax({
			type:'post',
			url:'/sellerCenter/chanpinShangjia',
			data:{"id":id},
			dataType:'text',
			success:function(data){
				if(data=="1"){
					alert("产品上架成功");
					ajaxpage(page, "chanpindata",$("#status").val(),null, null,null, "/sellerCenter/getChanpinData");
				}
			}
		});
	}
}
