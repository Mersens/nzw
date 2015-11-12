var chainname=/^[\u4e00-\u9fa5]{2,10}$/;
var englishname=/^[a-zA-Z\/ ]{4,20}$/;
var shouji=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|170|177|147|18[0|2|3|5|6|7|8|9])\d{8}$/;

function updatexinxi(){
	document.getElementById("xingmingTip1").style.display='none';
	document.getElementById("xingmingTip2").style.display='none';
	var xingming=$("#xingming").val();
	
	if(xingming==null || xingming==""){
		document.getElementById("xingmingTip1").style.display='block';
		document.getElementById("xingming").focus();
	}else if(chainname.test(xingming)==false && englishname.test(xingming)==false){
		document.getElementById("xingmingTip2").style.display='block';
		document.getElementById("xingming").focus();
	}else{
		document.getElementById("form").submit();
	}
}

function addimg(){
	$.layer({
    type : 2,
    iframe : {
        src : '/user/zhanghu/up.html'
    },
    title : "上传您的个人头像",
    area : ['500px','300px'],
    success : function(){ //层加载成功后进行的回调
        layer.shift('right-bottom',1000); //浏览器右下角弹出
    },
    end : function(){ //层彻底关闭后执行的回调
    success();
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