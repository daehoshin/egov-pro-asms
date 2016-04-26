<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=storeMdSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	   		jsStoreMdListSearch(1);
	    } 
	});
	jsStoreMdListSearch(1);
	
});

//제조사 검색
function jsStoreMdListSearch(pageNo)
{
	var sf = $("form[name=storeMdSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/common/store/storeMdSearchList.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#manpowerMdList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=storeMdListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

function jsStoreMdClose() {
	$('#myModal').modal('hide');
}
</script>
<div class="modal-dialog" style="width: 800px">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">제조사 선택</h4>
        </div>
        <div class="modal-body">
		   	<form id="storeMdSendForm" name="storeMdSendForm" class="form-horizontal" method="post">
		   	<input type="hidden" name="pageIndex" value="1">
			<input type="hidden" name="orderColumn" value="">
			<input type="hidden" name="orderType" value="">
			<input type="hidden" name="targetForm" value="${targetForm }">
			<input type="hidden" name="targetId" value="${targetId }">
			<input type="hidden" name="targetNm" value="${targetNm }">
			    <div class="row">
			    	<div class="col-md-10">
			    		<div class="pull-left">
			    			<i class="fa fa-list"></i> 전체 : <span id="totalCnt" class="blueText"></span>
			    		</div>
			    	</div>
			    	<div class="col-md-2">
		    			<select name="pageUnit" class="form-control" onchange="jsStoreMdListSearch()">
							<option>10</option>
							<option>30</option>
							<option>50</option>
						</select>
			    	</div>
			    </div>    
			    <div class="row">
			   		<div class="col-md-12">
			   			<div class="ibox float-e-margins">
							<div class="ibox-title">
								<div class="row">
									<div class="col-md-8">
										<span>제조사 검색</span>	
									</div>
									<div class="col-md-4">
										<div class="pull-right">
						                    <a href="javascript:;" onclick="jsSrchReset('storeSendForm','jsStoreMdListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
						                    <a href="javascript:;" onclick="jsStoreMdListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
						               	</div>
									</div>
								</div>
							</div>
							<div class="ibox-content">
				                <div class="form-group">
				                	<label class="col-sm-2 control-label" for="store_nm">제조사명</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="st_nm" id="st_nm"></div>
				                	<label class="col-sm-2 control-label" for="reg_nm">부서명</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="dept_nm" id="dept_nm"></div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="reg_nm">담당자명</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="confirmor_nm" id="confirmor_nm"></div>
								 	<label class="col-sm-2 control-label" for="reg_nm">주소</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="full_addr" id="full_addr"></div>
				                </div>
				                <div class="form-group">    
				                    <label class="col-sm-2 control-label" for="reg_nm">전화번호</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="tel_no" id="tel_no"></div>
				                    <label class="col-sm-2 control-label" for="reg_nm">등록자명</label>
				                    <div class="col-sm-4"><input type="text" class="form-control" name="reg_nm" id="reg_nm"></div>
				                </div>
							</div>
				   		</div>
				   	</div>
				</div>
		   	</form>
		   	<div id="manpowerMdList">
		 	<!-- departmentMdList -->
		   	</div>		
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" onclick="jsStoreMdClose()">닫기</button>
        </div>
    </div>
</div>
