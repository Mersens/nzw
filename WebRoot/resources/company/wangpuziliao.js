function addwangpu(){
	var dianputype='';
    var dptype = document.getElementsByTagName('input');  
   
    for( var i = 0; i < dptype.length; i++ ){  
        if( dptype[i].type == "radio" ){  
        	 if(dptype[i].checked)
        	   dianputype=dptype[i].value;
             } 
        } 
   
   var leimu = document.getElementsByName("leimu");
   var dianpuleimu='';
   for(var i=0;i<leimu.length;i++){
       if(leimu[i].checked){
    	   dianpuleimu+=leimu[i].value+",";
     }
   }     
   var dianpujieshao=document.getElementById("dianpujieshao").value;
   if(dianputype=='' || dianpuleimu==''){
	   alert("请完善信息再提交 ");
	   return null;
   }else{
	   document.getElementById("btn").style.display="none";
	   $.ajax({
		   type:'post',
		   url:'/gongsi/addWangpuZiliao',
		   data:{"dianputype":dianputype,"dianpuleimu":dianpuleimu,"dianpujieshao":dianpujieshao},
		   dataType:'text',
		   success:function(data){
			   if(data=="1"){
				   alert("提交成功");
				   window.location.href="/user/company/wangpuinfo.html";
			   }
		   }
	   });
   }
   
   
}

function updatewangpu(){
   var leimu = document.getElementsByName("leimu");
   var dianpuleimu='';
   for(var i=0;i<leimu.length;i++){
       if(leimu[i].checked){
    	   dianpuleimu+=leimu[i].value+",";
     }
   }     
   var dianpujieshao=document.getElementById("dianpujieshao").value;
   if(dianpuleimu=='' || dianpujieshao==''){
	   alert("请完善信息再提交 ");
	   return null;
   }else{
	   document.getElementById("btn").disabled=true;
	   $.ajax({
		   type:'post',
		   url:'/gongsi/updateWangpuZiliao',
		   data:{"dianpuleimu":dianpuleimu,"dianpujieshao":dianpujieshao},
		   dataType:'text',
		   success:function(data){
			   if(data=="1"){
				   alert("提交成功");
				   window.location.reload(true);
			   }
		   }
	   });
   }
   
   
}