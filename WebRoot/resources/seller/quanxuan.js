function allCheck(check, param) {
	var checkbox = document.getElementsByName(param);
	if (check.checked) {
		for ( var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = "checked";
		}
	} else {
		for ( var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = "";
		}
	}
}


$(function(){
	$('[data-type="checkbox"]').click(function(){
		var data_value = $(this).attr('data-value'),
			txtalso = $.trim($(".txtValue").val());
		if($(this).prop("checked")) {
			if(txtalso.length > 0) {
				if(txtalso.indexOf(data_value+',') != -1) {
					return ;
				} else {
					txtalso += data_value + ',';
				}
			} else {
				txtalso = data_value+',';
			}
		} else {
			if(txtalso.indexOf(data_value+',') != -1) {
				txtalso = txtalso.replace(data_value+',', '');
			}
		}
		$(".txtValue").val(txtalso);
	});
	$('[data-type="checkall"]').click(function(){
		var str = '';
		if($(this).prop("checked")) {
			$.each($('[data-type="checkbox"]'), function(i){
				str += $(this).attr('data-value') + ',';
			});
			$('[data-type="checkbox"]').prop('checked', true);
		} else {
			$('[data-type="checkbox"]').prop('checked', false);
		}
		$(".txtValue").val(str);
	});
});