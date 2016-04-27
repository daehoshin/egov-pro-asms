<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){

	$("#addBtn").bind("click",function(){
		$("#manPowerAddForm").attr("action","<c:url value='/reg/manpower/manPowerAddAction.do'/>").submit();
	});
	
	$('#manPowerAddForm').validate({
	    rules: {
	    	mp_nm			: { required: true },
	    	addr			: { required: true }
	    },
	    messages: {
	    	mp_nm			: { required: "인력명을 입력하세요." },
	    	addr			: { required: "주소를 선택하세요." }
	    },
	    submitHandler: function () {
	    	jsManPowerAddAction();
	    }
	});
	
});

//인력 등록
function jsManPowerAddAction()
{
		
	var addForm = $("form[name=manPowerAddForm]").serialize();

	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerAddAction.do",
		data : addForm,
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
            <h4 class="modal-title">인력 등록</h4>
        </div>
        <form id="manPowerAddForm" name="manPowerAddForm" class="form-horizontal" method="post">
	        <div class="modal-body">
	        	<!-- <div class="row">
	        		<div class="form-group">
		        		<div class="col-xs-2">
		        			<label class="control-label" for="mp_mng_no">인력명<span class="redText"> *</span></label>
		        		</div>
		        		<div class="col-xs-10">
		        			<input type="text" class="form-control" name="mp_nm" id="mp_nm">
		        		</div>
	        		</div>
	        	</div> -->
	        	<!-- 
	        	인력 구분을 최 상단에 위치시켜 내부/외부 구분하여 메타정보 다르게 받을것
	        	JSP (^ 필수사항)
	        		내부 -> 인력구분^, 인력명^, 로그인아이디^, 비밀번호^, 사용자권한^, 메뉴그룹^, 사용여부^, 입사일^, 부서명^, 직급^, 근무유형^, 재직유무-02번 default code^, 생년월일^, 주소^, 상세주소, 이메일^, 전화번호^ 
	        		외부 -> 인력구분^, 인력명^, 로그인아이디, 비밀번호, 사용자권한, 메뉴그룹, 사용여부^, 부서명, 직급, 근무유형^, 재직유무^, 생년월일, 주소, 상세주소, 이메일, 전화번호
	        	JAVA
	        		내부 -> 인력ID, 인력관리NO, 접속허가, 접속권한, 비밀번호 암호화, 등록자ID, 등록자NM, 등록자DT, 최종수정자ID, 최종수정자NM, 최종수정자DT 
	        		외부 -> 인력ID, 인력관리NO, 접속허가, 접속권한, 비밀번호 암호화, 등록자ID, 등록자NM, 등록자DT, 최종수정자ID, 최종수정자NM, 최종수정자DT 
	        	 -->
	        </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-success" id="addBtn">등록</button>
            <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        </div>
    </div>
</div>
