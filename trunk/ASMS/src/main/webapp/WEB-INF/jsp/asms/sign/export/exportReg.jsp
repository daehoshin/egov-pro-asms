<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var isSync = false;
$(document).ready(function(){

	$("#addBtn").bind("click",function(){
		$("#exportAddForm").attr("action","<c:url value='/sign/export/exportAddAction.do'/>").submit();
	});
	
	$('#exportAddForm').validate({
	    rules: {
	    	app_nm			: { required: true }
	    },
	    messages: {
	    	app_nm			: { required: "신청서명을 입력하세요." }
	    },
	    submitHandler: function () {
	    	jsExportAddAction();
	    }
	});
	
});

function jsExportAddAction()
{
	if(isSync) return;
		
	var addForm = $("form[name=exportAddForm]").serialize();
	isSync = true;
	$.ajax({
		type : "post",
		url  : "/sign/export/exportAddAction.do",
		data : addForm,
		dataType : "json",
		success:function(ajaxResult){
			$('#myModal').modal('hide');
			jsExportListSearch(1);
			
		}, error: function(xhr,status,error){
			isSync = false;
		}
	});

}

</script>
<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">반출서 등록</h4>
        </div>
        <div class="ibox-content">
        <form id="exportAddForm" name="exportAddForm" class="form-horizontal" method="post">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="app_nm">신청서명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="app_nm" id="app_nm">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="app_plc">반출장소<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="app_plc" id="app_plc">
		        		</div>
	        		</div>
	        	</div>
	        </div>
        </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-success" id="addBtn">등록</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        </div>
    </div>
</div>
