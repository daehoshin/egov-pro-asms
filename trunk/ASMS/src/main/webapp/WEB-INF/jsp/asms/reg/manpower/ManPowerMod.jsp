<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#saveBtn").bind("click",function(){
		$("#manPowerModForm").attr("action","<c:url value='/reg/manpower/manPowerModAction.do'/>").submit();
	});

	$('#manPowerModForm').validate({
	    rules: {
	    	mp_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	mp_nm			: { required: "인력명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function (frm) {
	    	jsManPowerModAction();
	    }
	});
});

//인력 수정
function jsManPowerModAction()
{
		
	var modForm = $("form[name=manPowerModForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerModAction.do",
		data : modForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsManPowerListSearch(1);
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
            <h4 class="modal-title">인력 수정</h4>
        </div>
        <form id="manPowerModForm" name="manPowerModForm" class="form-horizontal" method="post">
        <input type="hidden" name="mp_id" value="${manPowerVO.mp_id }">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="mp_mng_no">인력명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="mp_nm" id="mp_nm" value="${manPowerVO.mp_nm }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="mp_mng_no">주소<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr" id="addr" value="${manPowerVO.addr }">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="mp_mng_no">상세주소</label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="addr_detail" id="addr_detail" value="${manPowerVO.addr_detail }">
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
