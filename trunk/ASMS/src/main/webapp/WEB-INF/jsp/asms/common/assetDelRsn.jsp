<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal-dialog modal-sm">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">${modalTitleNm } 삭제 사유</h4>
        </div>
        <form id="assetDelForm" name="assetDelForm" class="form-horizontal" method="post">
	    <input type="hidden" name="asset_pk" value="${asset_pk }">    
	    <input type="hidden" name="asset_type" value="${asset_type }">    
	        <div class="modal-body">
	        	<div class="row">
	        		<textarea class="form-control" rows="5" name="asset_del_rsn" maxlength="1000"></textarea>
	        	</div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-danger" onclick="jsDelRsnSave()">삭제</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        </div>
    </div>
</div>

<script type="text/javascript">

function jsDelRsnSave() {
	$("#assetDelForm").attr("action","${executeUrl}").submit()
}

function jsDelSaveAction() {
	
	var delForm = $("form[name='assetDelForm']").serialize();
	
	$.ajax({
		type : "post",
		url  : "${executeUrl}",
		data : delForm,
		dataType : "json",
		success:function(ajaxResult){
			eval("${callbackName}();");
			$('#myModalSub').modal('hide');
			
		}
	});
}

$('#deleteRecordForm').validate({
    rules: {
    	asset_del_rsn : { required: true }
    },
    messages: {
    	asset_del_rsn : { required: "삭제사유를 입력하세요." }
    },
    submitHandler: function (frm) {
    	jsDelSaveAction();
    }
});

</script>
