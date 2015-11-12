var zuoji=/^([0-9]{3,4})?[0-9]{7,8}$/;
var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;
var chainname=/^[\u4e00-\u9fa5]{2,10}$/;
var englishname=/^[a-zA-Z\/ ]{4,20}$/;

//判断字符或汉字长度
String.prototype.gblen = function() {    
    var len = 0;    
    for (var i=0; i<this.length; i++) {    
        if (this.charCodeAt(i)>127 || this.charCodeAt(i)==94) {    
             len += 2;    
         } else {    
             len ++;    
         }    
     }    
    return len;    
}


function addgongsi(){
	document.getElementById("gongsinamaTS").style.display='none';
	document.getElementById("miaoshuTS").style.display='none';
	document.getElementById("dizhiTS").style.display='none';
	document.getElementById("dianhuaTS").style.display='none';
	document.getElementById("chuanzhenTS").style.display='none';
	document.getElementById("lianxirenTS").style.display='none';
	document.getElementById("lianxirendianhuaTS").style.display='none';
	var gongsinama=$("#gongsinama").val();
	var jiancheng=$("#jiancheng").val();
	var miaoshu=$("#miaoshu").val();
	var dizhi=$("#dizhi").val();
	var dianhua=$("#dianhua").val();
	var chuanzhen=$("#chuanzhen").val();
	var lianxiren=$("#lianxiren").val();
	var lianxirendianhua=$("#lianxirendianhua").val();
	var provinceid=$('#provinceid').combobox('getValue');
	var cityid=$('#cityid').combobox('getValue');
	var areaid=$('#areaid').combobox('getValue');
	var yingyezhizhao=$("#yingyezhizhao").val();
	var shuiwuzheng=$("#shuiwudengji").val();
	var zuzhidaima=$("#jigoudaima").val();
	if(gongsinama==null || gongsinama=="" || jiancheng==null || jiancheng=="" || miaoshu==null || miaoshu=="" || provinceid==null || provinceid=="" || cityid==null || cityid=="" || areaid==null || areaid=="" || dizhi==null || dizhi=="" || dianhua==null || dianhua=="" || chuanzhen==null || chuanzhen=="" || lianxiren==null || lianxiren=="" || lianxirendianhua==null || lianxirendianhua=="" || yingyezhizhao==null || yingyezhizhao=="" || shuiwuzheng==null || shuiwuzheng=="" || zuzhidaima==null || zuzhidaima==""){
		alert("请完善信息后再提交");
	}else if(gongsinama.gblen()<10 || gongsinama.gblen>100){
		document.getElementById("gongsinamaTS").style.display='block';
		document.getElementById("gongsinamaTS").innerHTML='公司名称必须在10—100个字符之间 (注：一个汉字代表2个字符)';
	}else if(miaoshu.gblen()<10 || miaoshu.gblen>1000){
		document.getElementById("miaoshuTS").style.display='block';
		document.getElementById("miaoshuTS").innerHTML='描述必须在10—1000个字符之间 (注：一个汉字代表2个字符)';
	}else if(dizhi.gblen()<10){
		document.getElementById("dizhiTS").style.display='block';
		document.getElementById("dizhiTS").innerHTML='请填写详细地址';
	}else if(!zuoji.test(dianhua)){
		document.getElementById("dianhuaTS").style.display='block';
		document.getElementById("dianhuaTS").innerHTML='电话格式不正确,例子：03715877177';
	}else if(!zuoji.test(chuanzhen)){
		document.getElementById("chuanzhenTS").style.display='block';
		document.getElementById("chuanzhenTS").innerHTML='传值格式不正确,例子：03715877177';
	}else if(chainname.test(lianxiren)==false && englishname.test(lianxiren)==false){
		document.getElementById("lianxirenTS").style.display='block';
		document.getElementById("lianxirenTS").innerHTML='请输入正确的联系人姓名';
	}else if(!shouji.test(lianxirendianhua)){
		document.getElementById("lianxirendianhuaTS").style.display='block';
		document.getElementById("lianxirendianhuaTS").innerHTML='手机号码格式不正确';
	}else{
		$.ajax({
			type:'post',
			url:'/gongsi/addGongsiXinxi?provinceid='+provinceid+'&cityid='+cityid+'&areaid='+areaid,
			data:$("#gsform").serialize(),
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="/user/company/shenhe.html";
				}else if(data=="2"){
					document.getElementById("gongsinamaTS").style.display='block';
					document.getElementById("gongsinamaTS").innerHTML='该公司名称已存在，请重新输入';
				}
			}
		});
		
		
		
	}
}

function updategongsi(){
	document.getElementById("miaoshuTS").style.display='none';
	document.getElementById("dizhiTS").style.display='none';
	document.getElementById("dianhuaTS").style.display='none';
	document.getElementById("chuanzhenTS").style.display='none';
	document.getElementById("lianxirenTS").style.display='none';
	document.getElementById("lianxirendianhuaTS").style.display='none';
	var jiancheng=$("#jiancheng").val();
	var miaoshu=$("#miaoshu").val();
	var dizhi=$("#dizhi").val();
	var dianhua=$("#dianhua").val();
	var chuanzhen=$("#chuanzhen").val();
	var lianxiren=$("#lianxiren").val();
	var lianxirendianhua=$("#lianxirendianhua").val();
	var provinceid=$('#provinceid').combobox('getValue');
	var cityid=$('#cityid').combobox('getValue');
	var areaid=$('#areaid').combobox('getValue');
	var yingyezhizhao=$("#yingyezhizhao").val();
	var shuiwuzheng=$("#shuiwudengji").val();
	var zuzhidaima=$("#jigoudaima").val();
	if(jiancheng==null || jiancheng=="" || miaoshu==null || miaoshu=="" || provinceid==null || provinceid=="" || cityid==null || cityid=="" || areaid==null || areaid=="" || dizhi==null || dizhi=="" || dianhua==null || dianhua=="" || chuanzhen==null || chuanzhen=="" || lianxiren==null || lianxiren=="" || lianxirendianhua==null || lianxirendianhua=="" || yingyezhizhao==null || yingyezhizhao=="" || shuiwuzheng==null || shuiwuzheng=="" || zuzhidaima==null || zuzhidaima==""){
		alert("请完善信息后再提交");
	}else 
		if(miaoshu.gblen()<10 || miaoshu.gblen>1000){
		document.getElementById("miaoshuTS").style.display='block';
		document.getElementById("miaoshuTS").innerHTML='描述必须在10—1000个字符之间 (注：一个汉字代表2个字符)';
	}else if(dizhi.gblen()<10){
		document.getElementById("dizhiTS").style.display='block';
		document.getElementById("dizhiTS").innerHTML='请填写详细地址';
	}else if(!zuoji.test(dianhua)){
		document.getElementById("dianhuaTS").style.display='block';
		document.getElementById("dianhuaTS").innerHTML='电话格式不正确,例子：03715877177';
	}else if(!zuoji.test(chuanzhen)){
		document.getElementById("chuanzhenTS").style.display='block';
		document.getElementById("chuanzhenTS").innerHTML='传值格式不正确,例子：03715877177';
	}else if(chainname.test(lianxiren)==false && englishname.test(lianxiren)==false){
		document.getElementById("lianxirenTS").style.display='block';
		document.getElementById("lianxirenTS").innerHTML='请输入正确的联系人姓名';
	}else if(!shouji.test(lianxirendianhua)){
		document.getElementById("lianxirendianhuaTS").style.display='block';
		document.getElementById("lianxirendianhuaTS").innerHTML='手机号码格式不正确';
	}else{
		$.ajax({
			type:'post',
			url:'/gongsi/updateGongsiXinxi?provinceid='+provinceid+'&cityid='+cityid+'&areaid='+areaid,
			data:$("#upgsform").serialize(),
			dataType:'text',
			success:function(data){
				if(data=="1"){
					window.location.href="/user/company/shenhe.html";
				}else{
					alert("提交失败");
				}
			}
		});
		
	}
}




function addimg(val){
	$.layer({
    type : 2,
    iframe : {
        src : '/gongsi/gotoUpFile?type='+val
    },
    title : "上传公司证件",
    area : ['500px','300px'],
    closeBtn: [0, true],
    success : function(){ //层加载成功后进行的回调
        layer.shift('right-bottom',1000); //浏览器右下角弹出
    },
    end : function(){ //层彻底关闭后执行的回调
    }
});
	
}
/**
 * 上传图片
 * @returns {Boolean}
 */
function upfile(){
	if (document.getElementById("imgsrc").value.replace(/\s/g, "") != ""){//不能为空
	    var FileType = "jpg,jpeg,JPG,png,PNG,GIF,gif";    //这里是允许的后缀名，注意要小写
	    var FileName = document.getElementById("imgsrc").value;
	    FileName = FileName.substring(FileName.lastIndexOf('.')+1, FileName.length).toLowerCase(); //这里把后缀名转为小写了，不然一个后缀名会有很多种大小写组合，
	    if (FileType.indexOf(FileName) == -1){
	           alert("附件格式不正确！");
	           return false;
		}else{
			//window.parent.document.getElementById('noup').style.display = 'none';
			document.getElementById("upform").submit();
		}
    }
}
