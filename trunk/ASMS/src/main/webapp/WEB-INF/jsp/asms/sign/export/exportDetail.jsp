<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#exportDetailForm .hr-line-dashed {
	margin: 10px 0
}

#exportDetailForm.col-sm-2 {
	width: 20%
}

#exportDetailForm .control-label {
	padding-top: 0px
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		jsEquipmentListSearch(1);
	});

	function jsEquipmentListSearch(pageNo) {
		var sf = $("form[name=exportDetailForm]");

		if (pageNo >= 1) {
			sf.find("input[name='pageIndex']").val(pageNo);
		}

		var sendForm = sf.serialize();

		$.ajax({
			type : "post",
			url : "/sign/export/exportEquipmentListSearch.do",
			data : sendForm,
			dataType : "html",
			success : function(ajaxResult) {
				// 조회된 리스트 넣어줌
				$('#equipmentList').html(ajaxResult);

				// 전체 건수 넣어줌
				var lf = $("form[name=equipmentListForm]");
				sf.find("span[id=totalCnt]").html(
						lf.find("[name=listCnt]").val());
				sf.find("input[name='orderColumn']").val(
						lf.find("input[name='orderColumn']").val());
				sf.find("input[name='orderType']").val(
						lf.find("input[name='orderType']").val());

				// basic style initialize
				jsInitialize();

			},
			error : function(xhr, status, error) {

			}
		});
	}
</script>

<form id="exportDetailForm" name="exportDetailForm"
	class="form-horizontal" method="post">
	<input type="hidden" name="app_id" value="${exportVO.app_id}">
	<input type="hidden" name="pageIndex" value="1"> 
	<input type="hidden" name="orderColumn" value=""> 
	<input type="hidden" name="orderType" value="">
	<div class="row">
		<div class="ibox-title">
			<div class="row">
				<div class="col-xs-12">
					<h5>반출서 상세</h5>
					<div class="pull-right">
						<a href="javascript:;" class="btn btn-outline btn-success"><iclass="fa fa-pencil"></i> 수정</a> 
						<a href="javascript:;" onclick="jsCloseView()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i>닫기</a>
					</div>
				</div>
			</div>
		</div>
		<div class="ibox-content">
			<div class="form-group">
				<label class="col-sm-2 control-label">관리번호</label>
				<div class="col-sm-9">${exportVO.app_no}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">신청서명</label>
				<div class="col-sm-9">${exportVO.app_nm}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">신청인</label>
				<div class="col-sm-9">${exportVO.reg_nm}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">확인자</label>
				<div class="col-sm-9">${exportVO.confirmor_nm}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">신청서상태</label>
				<div class="col-sm-9">${exportVO.app_cd_nm}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">등록일자</label>
				<div class="col-sm-9">${exportVO.reg_dt}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">신청일자</label>
				<div class="col-sm-9">${exportVO.app_cd_nm}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">처리일자</label>
				<div class="col-sm-9">${exportVO.confirm_dt}</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label class="col-sm-2 control-label">반출상태</label>
				<div class="col-sm-9">신청</div>
			</div>
			<div class="hr-line-dashed"></div>
	
		</div>
		<div id="equipmentList">
			<!-- equipmentList -->
		</div>
	</div>
</form>

