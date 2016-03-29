<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#regFinishBtn").bind("click",function(){
		$("#placeViewForm").attr("action","<c:url value='/rgst/place/placeRegFinishAction.do'/>").submit();
	});

	$('#placeViewForm').validate({
	    rules: {
	    	plc_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	plc_nm			: { required: "장소명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function (frm) {
	    	jsPlaceRegFinishAction();
	    }
	});
});

// 등록완료
function jsPlaceRegFinishAction(){
	if (confirm("기록물건을 등록완료 처리하시겠습니까?")) {
		var viewForm = $("form[name=placeViewForm]").serialize();

		$.ajax({
			type : "post",
			url  : "/rgst/place/placeRegFinishAction.do",
			data : viewForm,
			dataType : "json",
			success:function(ajaxResult){
				
				jsPlaceListSearch(1);
				$('#myModal').modal('hide');
				
			}, error: function(xhr,status,error){
				 
			}
		});
	}
}

// 삭제
function jsPlaceDelAction(plc_id) {
	if (confirm("기록물건을 삭제하시겠습니까?")) {
		$.ajax({
			type : "post",
			url  : "/reg/common/placeDelRsnForm.do",
			data : {plc_id : plc_id, callbackName : 'jsPlaceDelComplete', executeUrl : '/rgst/place/placeDelAction.do'},
			dataType : "html",
			success:function(ajaxResult){
				
				$('#mdCommonDialog').html(ajaxResult);
				$('#mdCommonDialog').modal('show');
				
				jsInitialize();
			}
		});
	}	
}

</script>
<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">장소 상세</h4>
        </div>
        <form id="placeViewForm" name="placeViewForm" class="form-horizontal" method="post">
        <input type="hidden" name="plc_id" value="${placeVO.plc_id }">
	        <div class="modal-body">
	        	<div class="form-group"><label class="col-lg-2 control-label">장소명</label>
                	<div class="col-lg-10"><p class="form-control-static">${placeVO.plc_nm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">주소</label>
                	<div class="col-lg-10"><p class="form-control-static">${placeVO.addr }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">상세주소</label>
                	<div class="col-lg-10"><p class="form-control-static">${placeVO.addr_detail }</p></div>
                </div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="regFinishBtn">등록완료</button>
            <button type="button" class="btn btn-primary" onclick="jsPlaceModForm('${placeVO.plc_id }')">수정</button>
            <button type="button" class="btn btn-primary" onclick="jsPlaceDelAction('${placeVO.plc_id }')">삭제</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
