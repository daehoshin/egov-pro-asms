<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#saveBtn").bind("click",function(){
		$("#equipmentModForm").attr("action","<c:url value='/rgst/equipment/equipmentModAction.do'/>").submit();
	});

	$('#equipmentModForm').validate({
	    rules: {
	    	eq_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	eq_nm			: { required: "장비명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function (frm) {
	    	jsEquipmentModAction();
	    }
	});
});

//장비 수정
function jsEquipmentModAction()
{
		
	var modForm = $("form[name=equipmentModForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/rgst/equipment/equipmentModAction.do",
		data : modForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsEquipmentListSearch(1);
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
            <h4 class="modal-title">장비 수정</h4>
        </div>
        <form id="equipmentModForm" name="equipmentModForm" class="form-horizontal" method="post">
        <input type="hidden" name="eq_id" value="${equipmentVO.eq_id }">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="eq_mng_no">장비명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="eq_nm" id="eq_nm" value="${equipmentVO.eq_nm }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="eq_mng_no">주소<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr" id="addr" value="${equipmentVO.addr }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="eq_mng_no">상세주소</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr_detail" id="addr_detail" value="${equipmentVO.addr_detail }">
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
