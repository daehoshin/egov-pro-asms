function jsMenuLoad(menu_id, menu_div_cd){
	document.menuLoadForm.menu_id.value = menu_id;
	document.menuLoadForm.menu_div_cd.value = menu_div_cd;
	document.menuLoadForm.action = "/menuLoading.do";
	document.menuLoadForm.submit();
}	