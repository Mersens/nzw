$(".ui-select").selectWidget({
		change       : function (changes) {
			return changes;
		},
		effect       : "slide",
		keyControl   : true,
		speed        : 200,
		scrollHeight :0
	});
	
function sousuo(){		
	var typeid = $("#selecttypeid").val();
	var selectname ="0";
	if($("#selectname").val()!==""){
		selectname=$("#selectname").val();
	}
	if(typeid=="qy"){
		window.location.href="http://q.nz101.com/q_1_0_0_"+selectname+"_1/";
	}else{
		window.location.href="http://q.nz101.com/d_"+typeid+"_"+selectname+"_0_0_0_0_0_0_0_1/";
	}
}
