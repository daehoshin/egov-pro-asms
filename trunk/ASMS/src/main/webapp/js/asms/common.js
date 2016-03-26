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

function jsMenuLoad(menu_id, menu_div_cd){
	document.menuLoadForm.menu_id.value = menu_id;
	document.menuLoadForm.menu_div_cd.value = menu_div_cd;
	document.menuLoadForm.action = "/menuLoading.do";
	document.menuLoadForm.submit();
}

function jsCurrentData(Target, currentId){

}

function jsInitialize(){
	// CheckBox Checked Color
	$('.i-checks').iCheck({
    	checkboxClass: 'icheckbox_square-green',
    	radioClass: 'iradio_square-green',
	});
}