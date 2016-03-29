<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){

	$("#addBtn").bind("click",function(){
		$("#placeAddForm").attr("action","<c:url value='/rgst/place/placeAddAction.do'/>").submit();
	});
	
	$('#placeAddForm').validate({
	    rules: {
	    	plc_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	plc_nm			: { required: "장소명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function () {
	    	jsPlaceAddAction();
	    }
	});
	
});

//장소 등록
function jsPlaceAddAction()
{
		
	var addForm = $("form[name=placeAddForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/rgst/place/placeAddAction.do",
		data : addForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsPlaceListSearch(1);
			$('#myModal').modal('hide');
			
		}, error: function(xhr,status,error){
			 
		}
	});
}

</script>
<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">장소 등록</h4>
        </div>
        <form id="placeAddForm" name="placeAddForm" class="form-horizontal" method="post">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_no">장소명</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="plc_nm" id="plc_nm">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_no">주소</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr" id="addr">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_no">상세주소</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr_detail" id="addr_detail">
		        		</div>
	        		</div>
	        	</div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="addBtn">Save changes</button>
        </div>
    </div>
</div>
