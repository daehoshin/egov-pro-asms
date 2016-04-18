<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#regFinishBtn").bind("click",function(){
		$("#equipmentViewForm").attr("action","<c:url value='/rgst/equipment/equipmentRegFinishAction.do'/>").submit();
	});

	$('#equipmentViewForm').validate({
	    rules: {
	    	eq_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	eq_nm			: { required: "장비명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function (frm) {
	    	jsEquipmentRegFinishAction();
	    }
	});
});

// 등록완료
function jsEquipmentRegFinishAction(eq_id,reg_status){
	if(reg_status!='01'){
		alert("등록중인 장비만 등록완료 할 수 있습니다.");
		return;
	}
	if (confirm("해당 장비를 등록완료 처리하시겠습니까?")) {
		$.ajax({
			type : "post",
			url  : "/rgst/equipment/equipmentRegFinishAction.do",
			data : {eq_id : eq_id},
			dataType : "json",
			success:function(ajaxResult){
				
				jsEquipmentListSearch(1);
				$('#myModal').modal('hide');
				
			}, error: function(xhr,status,error){
				 
			}
		});
	}
}

// 삭제
function jsEquipmentDel(eq_id,reg_status) {
	if(reg_status=='03'){
		alert("이미 삭제 처리 된 장비입니다.");
		return;
	}
	if (confirm("해당 장비를 삭제하시겠습니까?")) {
		$.ajax({
			type : "post",
			url  : "/rgst/equipment/equipmentDelRsnForm.do",
			data : {eq_id : eq_id, callbackName : 'jsEquipmentDelComplete', executeUrl : '/rgst/equipment/equipmentDelAction.do'},
			dataType : "html",
			success:function(ajaxResult){
				
				$('#myModalSub').html(ajaxResult);
				$('#myModalSub').modal('show');
				
			}
		});
	}	
}

// 삭제완료
function jsEquipmentDelComplete() {
	
	alert("삭제되었습니다.");
	jsEquipmentListSearch(1);
	$('#myModal').modal('hide');
	
}

</script>
<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">장비 상세</h4>
        </div>
        <form id="equipmentViewForm" name="equipmentViewForm" class="form-horizontal" method="post">
        <input type="hidden" name="asset_pk" value="${equipmentVO.eq_id }">
	        <div class="modal-body">
	        	<div class="form-group"><label class="col-lg-2 control-label">장비명</label>
                	<div class="col-lg-10"><p class="form-control-static">${equipmentVO.eq_nm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">주소</label>
                	<div class="col-lg-10"><p class="form-control-static">${equipmentVO.addr }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">상세주소</label>
                	<div class="col-lg-10"><p class="form-control-static">${equipmentVO.addr_detail }</p></div>
                </div>
                <c:if test="${equipmentVO.reg_status eq 03}">
	                <div class="hr-line-dashed"></div>
		        	<div class="form-group"><label class="col-lg-2 control-label">삭제사유</label>
	                	<div class="col-lg-10"><p class="form-control-static"><textarea class="form-control" readonly="readonly" rows="5" name="del_rsn">${equipmentVO.del_rsn }</textarea></p></div>
	                </div>
	            </c:if> 
	        </div>
        </form>
        <div class="modal-footer">
        	<div class="pull-left">
        		<c:choose>
					<c:when test="${loginUserVO.user_auth_cd eq 1 }">
        				<button type="button" class="btn btn-warning" onclick="jsEquipmentRegFinishAction('${equipmentVO.eq_id }','${equipmentVO.reg_status }')">등록완료</button>
        				<button type="button" class="btn btn-danger" onclick="jsEquipmentDel('${equipmentVO.eq_id }','${equipmentVO.reg_status }')">삭제</button>
            		</c:when>
            		<c:otherwise>
		            	<button type="button" class="btn btn-warning" disabled="disabled" onclick="jsEquipmentRegFinishAction('${equipmentVO.eq_id }')">등록완료</button>
		            	<button type="button" class="btn btn-danger" disabled="disabled" onclick="jsEquipmentDel('${equipmentVO.eq_id }')">삭제</button>
            		</c:otherwise>
            	</c:choose>
        	</div>
        	<div class="pull-right">
        		<c:choose>
        			<c:when test="${loginUserVO.user_auth_cd eq 1 }">
		        		<button type="button" class="btn btn-primary" onclick="jsEquipmentModForm('${equipmentVO.eq_id }')">수정</button>
		            </c:when>
		            <c:otherwise>
		            	<button type="button" class="btn btn-primary" disabled="disabled" onclick="jsEquipmentModForm('${equipmentVO.eq_id }')">수정</button>
		            </c:otherwise>
		        </c:choose>
		        <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        	</div>
        </div>
    </div>
</div>
