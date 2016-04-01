<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#saveBtn").bind("click",function(){
		$("#placeModForm").attr("action","<c:url value='/rgst/place/placeModAction.do'/>").submit();
	});

	$('#placeModForm').validate({
	    rules: {
	    	plc_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	plc_nm			: { required: "장소명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function (frm) {
	    	jsPlaceModAction();
	    }
	});
});

//장소 수정
function jsPlaceModAction()
{
		
	var modForm = $("form[name=placeModForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/rgst/place/placeModAction.do",
		data : modForm,
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
            <h4 class="modal-title">장소 수정</h4>
        </div>
        <form id="placeModForm" name="placeModForm" class="form-horizontal" method="post">
        <input type="hidden" name="plc_id" value="${placeVO.plc_id }">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_mng_no">장소명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="plc_nm" id="plc_nm" value="${placeVO.plc_nm }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_mng_no">주소<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr" id="addr" value="${placeVO.addr }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="plc_mng_no">상세주소</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr_detail" id="addr_detail" value="${placeVO.addr_detail }">
		        		</div>
	        		</div>
	        	</div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="saveBtn">저장</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        </div>
    </div>
</div>
