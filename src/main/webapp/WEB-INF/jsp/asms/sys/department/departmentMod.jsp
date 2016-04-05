<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>

<script type="text/javascript">
$(document).ready(function(){
	$("#saveBtn").bind("click",function(){
		$("#deptModForm").attr("action","<c:url value='/sys/department/deptModAction.do'/>").submit();
	});

	$('#deptModForm').validate({
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
	    	jsDeptModAction();
	    }
	});
	
});

//부서 수정
function jsDeptModAction()
{
		
	var modForm = $("form[name=deptModForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/sys/department/deptModAction.do",
		data : modForm,
		dataType : "json",
		success:function(ajaxResult){
			
			jsDeptListSearch(1);
			
		}, error: function(xhr,status,error){
			 
		}
	});
}

</script>

<form id="deptModForm" name="deptModForm" class="form-horizontal" method="post">
    <div class="row">
    	<div class="ibox float-e-margins">
    		<div class="ibox-title">
	    		<div class="row">
	    			<div class="col-xs-12">
		            	<h5>부서 수정</h5>
		            	<div class="pull-right">
		    				<a href="javascript:;" onclick="" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 저장</a>
				        	<a href="javascript:;" onclick="jsCloseView()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 닫기</a>	    			
	    				</div>
	    			</div>
	    		</div>
    		</div>
            <div class="ibox-content">
               <div class="form-group"><label class="col-sm-3 control-label">부서코드</label>
                   <div class="col-sm-9"><input type="text" name="dept_cd" class="form-control" value="${deptVO.dept_cd }" readonly="readonly">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">부서명</label>
                   <div class="col-sm-9"><input type="text" name="dept_nm" class="form-control" value="${deptVO.dept_nm }">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">시작일자</label>
                   <div class="col-sm-9"><input type="text" name="start_dt" class="form-control" value="${deptVO.start_dt }">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">종료일자</label>
                   <div class="col-sm-9"><input type="text" name="endt_dt" class="form-control" value="${deptVO.endt_dt }">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">사용여부</label>
               	   <div class="col-sm-9"><asms:cdRadio name="use_flag" codeType="DEP01" use="true" defaultCode="${deptVO.use_flag }"/> 
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록자</label>
               	   <div class="col-sm-9"><input type="text" name="reg_nm" class="form-control" value="${deptVO.reg_nm }" readonly="readonly">
                   </div>
               </div>
               <div class="hr-line-dashed"></div>
               <div class="form-group"><label class="col-sm-3 control-label">등록일자</label>
                   <div class="col-sm-9"><input type="text" name="reg_dt" class="form-control" value="${deptVO.reg_dt }" readonly="readonly">
                   </div>
               </div>
            </div>
        </div>
    </div>
</form>
