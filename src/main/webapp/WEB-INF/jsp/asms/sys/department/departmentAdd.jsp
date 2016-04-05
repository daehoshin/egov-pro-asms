<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<script type="text/javascript">
$(document).ready(function(){

	$("#addBtn").bind("click",function(){
		$("#deptAddForm").attr("action","<c:url value='/sys/department/deptAddAction.do'/>").submit();
	});
	
	$.validator.addMethod("requiredByUseFlag", function(value, element) {
		var frm = $("form[name='deptAddform']");
       	var useFlag = frm.find(":radio[name=use_flag]:checked").val();
       	alert(useFlag);
		if (useFlag == "") {
			alert("if절"+useFlag);
			return false;
		} else {
			alert("else절"+useFlag);
			return;
		}
     });
	
	$('#deptAddForm').validate({
	    rules: {
	    	dept_nm			: { required: true },
	    	start_dt		: { required: true },
	    	endt_dt			: { required: true },
	    	use_flag		: { requiredByUseFlag: true }
	    },
	    messages: {
	    	dept_nm			: { required: "부서명을 입력하세요." },
	    	start_dt		: { required: "시작일자를 선택하세요." },
	    	end_dt			: { required: "종료일자를 선택하세요." },
	    	use_flag		: { requiredByUseFlag: "사용여부를 선택하세요." }
	    },
	    submitHandler: function () {
	    	jsDeptAddAction();
	    }
	});
	
});

//부서 등록
function jsDeptAddAction()
{
		
	var addForm = $("form[name=deptAddForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/sys/department/deptAddAction.do",
		data : addForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsDeptListSearch(1);
			
		}, error: function(xhr,status,error){
			 
		}
	});
}

</script>    
<form id="deptAddForm" name="deptAddForm" class="form-horizontal" method="post">
    <div class="row">
    	<div class="ibox float-e-margins">
    		<div class="ibox-title">
	    		<div class="row">
	    			<div class="col-xs-12">
		            	<h5>부서 등록</h5>
		            	<div class="pull-right">
		    				<a href="javascript:;" onclick="" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 저장</a>
				        	<a href="javascript:;" onclick="jsCloseView()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 닫기</a>	    			
	    				</div>
	    			</div>
	    		</div>
    		</div>
            <div class="ibox-content">
               <div class="form-group"><label class="col-sm-3 control-label">부서명</label>
                   <div class="col-sm-9"><input type="text" name="dept_nm" class="form-control">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">시작일자</label>
                   <div class="col-sm-9"><input type="text" name="start_dt" class="form-control">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">종료일자</label>
                   <div class="col-sm-9"><input type="text" name="endt_dt" class="form-control">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">사용여부</label>
               	   <div class="col-sm-9"><asms:cdRadio name="use_flag" codeType="DEP01" use="true" defaultCode="01"/> 
                   </div>
               </div>
            </div>
        </div>
    </div>
</form>
