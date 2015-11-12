
function addimg(val){
	$.layer({
    type : 2,
    iframe : {
        src : '/sellerCenter/gotoUploadFiles'
    },
    title : "上传产品图片",
    area : ['500px','300px'],
    closeBtn: [0, true],
    success : function(){ //层加载成功后进行的回调
        layer.shift('right-bottom',1000); //浏览器右下角弹出
    },
    end : function(){ //层彻底关闭后执行的回调
    }
});
	
}


function upimg(){
	if (document.getElementById("chanpinimgsrc").value.replace(/\s/g, "") != ""){//不能为空
	    var FileType = "jpg,jpeg,JPG,png,PNG,GIF,gif";    //这里是允许的后缀名，注意要小写
	    var FileName = document.getElementById("chanpinimgsrc").value;
	    FileName = FileName.substring(FileName.lastIndexOf('.')+1, FileName.length).toLowerCase(); //这里把后缀名转为小写了，不然一个后缀名会有很多种大小写组合，
	    if (FileType.indexOf(FileName) == -1){
	           alert("附件格式不正确！");
	           return false;
		}else{
			//window.parent.document.getElementById('noup').style.display = 'none';
			document.getElementById("chanpinform").submit();
		}
    }
}