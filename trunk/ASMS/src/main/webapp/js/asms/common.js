$(document).ready(function(){
	// DataTables Setting
	$('.dataTables-example').DataTable({
	    dom: '<"html5buttons"B>lTfgitp',
	    buttons: [
	        { extend: 'copy'},
	        {extend: 'csv'},
	        {extend: 'excel', title: 'ExampleFile'},
	        {extend: 'pdf', title: 'ExampleFile'},

	        {extend: 'print',
	         customize: function (win){
	                $(win.document.body).addClass('white-bg');
	                $(win.document.body).css('font-size', '10px');

	                $(win.document.body).find('table')
	                        .addClass('compact')
	                        .css('font-size', 'inherit');
	        }
	        }
	    ]

	});
	
});

// 메뉴 불러오기
function jsMenuLoad(menu_id, menu_div_cd){
	document.menuLoadForm.menu_id.value = menu_id;
	document.menuLoadForm.menu_div_cd.value = menu_div_cd;
	document.menuLoadForm.action = "/menuLoading.do";
	document.menuLoadForm.submit();
}

// 현재 데이터 표시
function jsCurrentData(Target, currentId){

}

// 검색 초기화
function jsSrchReset(target,executeJsNm) 
{
	 $("form[name='"+target+"']").find('input').each(function() {
	  	   $(this).val("");
      }); 
	  $("form[name='"+target+"']").find('hidden').each(function() {
		  	$(this).val("");
	  });  
	  $("form[name='"+target+"']").each(function() {
		    this.reset();
	  });  

	  eval(executeJsNm);
}


function jsInitialize(){
	// 체크박스 체크 표시
	$('.i-checks').iCheck({
    	checkboxClass: 'icheckbox_square-green',
    	radioClass: 'iradio_square-green',
	});
	
}

