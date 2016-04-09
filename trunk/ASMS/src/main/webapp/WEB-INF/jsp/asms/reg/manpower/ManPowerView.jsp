<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

// 사용중지
function jsManPowerUseStopAction(mp_id,use_flag,update_flag){
	var msg;
	if(update_flag==01){
		msg = "해당 인력의 시스템 이용을 허가하시겠습니까?";
	} else {
		msg = "해당 인력의 시스템 이용을 차단하시겠습니까?";
	}
	if (confirm(msg)) {
		$.ajax({
			type : "post",
			url  : "/rgst/manpower/ManPowerUseStartStopAction.do",
			data : {mp_id : mp_id, update_flag : update_flag},
			dataType : "json",
			success:function(ajaxResult){
				
				jsManPowerListSearch(1);
				$('#myModal').modal('hide');
				
			}, error: function(xhr,status,error){
				 
			}
		});	
	}
}
</script>
<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">인력 상세</h4>
        </div>
        <form id="manPowerViewForm" name="manPowerViewForm" class="form-horizontal" method="post">
        <input type="hidden" name="asset_pk" value="${manPowerVO.mp_id }">
	        <div class="modal-body">
	        	<div class="form-group"><label class="col-lg-2 control-label">관리번호</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.mp_mng_no }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">인력명</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.mp_nm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">로그인ID</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.login_user_id }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">부서명</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.dept_nm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">직급</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.position }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">생년월일</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.birth_dt }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">주소</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.full_addr }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">이메일</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.email }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">전화번호</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.tel_no }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">인력구분</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.mp_cd_cm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">근무유형</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.emp_cd_cm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">재직유무</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.join_cd_cm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">사용여부</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.use_flag_cm }</p></div>
                </div>
                <div class="hr-line-dashed"></div>
	        	<div class="form-group"><label class="col-lg-2 control-label">등록자명</label>
                	<div class="col-lg-10"><p class="form-control-static">${manPowerVO.reg_nm }</p></div>
                </div>
	        </div>
        </form>
        <div class="modal-footer">
        	<div class="pull-left">
        		<c:choose>
        			<c:when test="${manPowerVO.use_flag eq 01 }">
						<button type="button" class="btn btn-warning" onclick="jsManPowerUseStopAction('${manPowerVO.mp_id }','${manPowerVO.use_flag }','02')">사용중지</button>        			
        			</c:when>
        			<c:otherwise>
        				<button type="button" class="btn btn-warning" onclick="jsManPowerUseStopAction('${manPowerVO.mp_id }','${manPowerVO.use_flag }','01')">사용</button>
        			</c:otherwise>
        		</c:choose>
        	</div>
        	<div class="pull-right">
		        <button type="button" class="btn btn-primary" onclick="jsManPowerModForm('${manPowerVO.mp_id }')">수정</button>
		        <button type="button" class="btn btn-white" data-dismiss="modal">닫기</button>
        	</div>
        </div>
    </div>
</div>
