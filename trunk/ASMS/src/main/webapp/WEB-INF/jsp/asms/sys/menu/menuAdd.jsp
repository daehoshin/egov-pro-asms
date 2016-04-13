<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<script type="text/javascript">
$(document).ready(function(){

	$("#addBtn").bind("click",function(){
		$("#menuAddForm").attr("action","<c:url value='/sys/menu/menuAddAction.do'/>").submit();
	});
	
	$.validator.addMethod("requiredByUseFlag", function(value, element) {
		var frm = $("form[name='menuAddForm']");
       	var useFlag = frm.find(":radio[name=use_flag]:checked").val();
       	alert(useFlag);
		if (useFlag == "") {
			alert("if절"+useFlag);
			return false;
		} else {
			alert("else절"+useFlag);
			return true;
		}
     });
	
	$('#menuAddForm').validate({
	    rules: {
	    	menu_grp_nm		: { required: true },
	    	use_flag		: { requiredByUseFlag: true }
	    },
	    messages: {
	    	menu_grp_nm		: { required: "메뉴그룹명을 입력하세요." },
	    	use_flag		: { requiredByUseFlag: "사용여부를 선택하세요." }
	    },
	    submitHandler: function () {
	    	jsMenuAddAction();
	    }
	});
	
});

//메뉴그룹 등록
function jsMenuAddAction()
{
		
	var addForm = $("form[name=menuAddForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/sys/menu/menuAddAction.do",
		data : addForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsMenuListSearch(1);
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
            <h4 class="modal-title">메뉴그룹 등록</h4>
        </div>
        <form id="menuAddForm" name="menuAddForm" class="form-horizontal" method="post">
	        <div class="modal-body">
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-3">
		        			<label class="control-label" for="menu_grp_nm">메뉴그룹명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-9">
		        			<input type="text" class="form-control" name="menu_grp_nm" id="menu_grp_nm">
		        		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-3">
		        			<label class="control-label" for="use_flag">사용여부<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-9">
		        			<asms:cdRadio name="use_flag" codeType="MEN01" use="true" defaultCode="01"/>
		        		</div>
	        		</div>
	        	</div>
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-success" id="addBtn">등록</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        </div>
    </div>
</div>
