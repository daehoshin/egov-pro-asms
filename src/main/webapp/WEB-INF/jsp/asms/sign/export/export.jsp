<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	 $('#app_dt').datepicker({
         keyboardNavigation: false,
         forceParse: false,
         autoclose: true,
         format: "yy/mm/dd",
         todayHighlight: true
     });
	 
	$('#confirm_dt').datepicker({
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true,
        format: "yy/mm/dd",
        todayHighlight: true
    });
	
	$("form[name=exportSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	    	jsExportListSearch(1);
	    } 
	});
	
	jsExportListSearch(1);
	
});

// 반출서 검색
function jsExportListSearch(pageNo)
{
	var sf = $("form[name=exportSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/sign/export/exportListSearch.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			// 조회된 리스트 넣어줌
			$('#exporteList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=exportListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

//반출서 등록화면
function jsExportRegForm()
{
	$.ajax({
		type : "post",
		url  : "/sign/export/exportRegForm.do",
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

//반출서 수정화면
function jsExportModForm(plc_id)
{
	/* $.ajax({
		type : "post",
		url  : "/rgst/export/placeModForm.do",
		data : {plc_id : plc_id},
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});*/
	alert("jsExportModForm");
 }

// 반출신청서 상세
function jsExportDetailForm(app_id)
{
	$.ajax({
		type : "POST",
		url  : "/sign/export/exportDetail.do",
		data : {'app_id' : app_id},
		dataType : "html",
		success:function(ajaxResult){

			$('#mainSection').addClass('col-md-8');
			$('#subSection').addClass('col-md-4');
			$('#subSection').html(ajaxResult);
			
		}, error: function(xhr,status,error){
			 
		}
	});	
}

function jsExportSelectDel(){
	
	var lf = $("form[name=exportListForm]");
	var checkedCnt = lf.find("[name=app_id]:checked").length;
	var exportStatusCnt = 0;
	
	lf.find("[name=app_id]:checked").each(function(i){
		if($(this).attr("checkVal")=="02"){ //신청 처리가 된 반출 건
			exportStatusCnt++;
		}
	});
	
	if(checkedCnt==0){
		alert("삭제 할 반출서를 선택하십시오.");
		return;
	} else {
		if(exportStatusCnt > 0){
			alert("이미 신청 처리가 된 반출서가 포함되어있습니다.\n체크를 해제하시고 다시 진행 해 주십시오.");
			return;
		} else {
			
			var listForm = lf.serialize();
			
			if (confirm("선택 하신 반출서를 삭제하시겠습니까?")) {
				alert("반출서 삭제!");
				/* $.ajax({
					type : "post",
					url  : "/sign/export/placeSelectDelRsnForm.do?executeUrl=/rgst/place/placeSelectDelAction.do",
					data : listForm,
					dataType : "html",
					success:function(ajaxResult){
						
						$('#myModal').html(ajaxResult);
						$('#myModal').modal('show');
						
					}
				}); */
			}	
		}
	}
}

function jsCloseView(){
	$('#mainSection').removeClass('col-md-8');
	$('#subSection').removeClass('col-md-4');
}
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><i class="fa fa-building-o"></i> 장비반출 목록</h2>
        <ol class="breadcrumb">
            <li>결재</li>
            <li class="active">
                <strong>장비반출</strong>
            </li>
        </ol>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div id="mainSection">
		   	<form id="exportSendForm" name="exportSendForm" class="form-horizontal" method="post">
		   	<input type="hidden" name="pageIndex" value="1">
			<input type="hidden" name="orderColumn" value="">
			<input type="hidden" name="orderType" value="">
			   	<div class="row">
			   		<div class="col-md-12 marginB5">
			   			<div class="pull-right">
			   				<c:choose>
		        				<c:when test="${loginUserVO.user_auth_cd eq 1 }">
		        					<a href="javascript:;" onclick="jsExportRegForm()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 반출서 작성</a>
					        		<a href="javascript:;" onclick="jsExportSelectDel()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 일괄삭제</a>
		        				</c:when>
		        			</c:choose>
				        </div>
			   		</div>
			    </div>
			    <div class="row">
			    	<div class="col-md-10">
			    		<div class="pull-left">
			    			<i class="fa fa-list"></i> 전체 : <span id="totalCnt" class="blueText"></span>
			    		</div>
			    	</div>
			    	<div class="col-md-2">
		    			<select name="pageUnit" class="form-control" onchange="jsExportListSearch()">
							<option>20</option>
							<option>40</option>
							<option>80</option>
							<option>100</option>
						</select>
			    	</div>
			    </div>    
			    <div class="row">
			   		<div class="col-md-12">
			   			<div class="ibox float-e-margins">
							<div class="ibox-title">
								<div class="row">
									<div class="col-md-8">
										<span>반출서 검색</span>	
									</div>
									<div class="col-md-4">
										<div class="pull-right">
						                    <a href="javascript:;" onclick="jsSrchReset('exportSendForm','jsExportListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
						                    <a href="javascript:;" onclick="jsExportListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
						               	</div>
									</div>
								</div>
							</div>
							<div class="ibox-content">
				                <div class="form-group">
				                	<label class="col-sm-1 control-label" for="app_no">관리번호</label>
				                    <div class="col-sm-2"><input type="text" class="form-control" name="app_no" id="app_no"></div>
				                	<label class="col-sm-1 control-label" for="app_nm">신청서명</label>
				                    <div class="col-sm-2"><input type="text" class="form-control" name="app_nm" id="app_nm"></div>
				                	<label class="col-sm-1 control-label" for="app_hm_id">신청자</label>
				                    <div class="col-sm-2"><input type="text" class="form-control" name="app_hm_id" id="app_hm_id"></div>
				                    <label class="col-sm-1 control-label" for="confirmor_id">확인자</label>
				                    <div class="col-sm-2"><input type="text" class="form-control" name="confirmor_id" id="confirmor_id"></div>
				                    <label class="col-sm-1 control-label" for="datepicker">신청일자</label>
				                    <div class="col-sm-3">
				                    	<div class="input-daterange input-group" id=app_dt>
		                                    <input type="text" class="input-sm form-control" name="app_dt_st"/>
		                                    <span class="input-group-addon">~</span>
		                                    <input type="text" class="input-sm form-control" name="app_dt_ed"/>
		                                </div>
				                    </div>
				                    <label class="col-sm-1 control-label" for="confirm_dt">처리일자</label>
				                    <div class="col-sm-3">
				                    	<div class="input-daterange input-group" id="confirm_dt">
		                                    <input type="text" class="input-sm form-control" name="confirm_dt_st"/>
		                                    <span class="input-group-addon">~</span>
		                                    <input type="text" class="input-sm form-control" name="confirm_dt_ed"/>
		                                </div>
				                    </div>
		 		                    <label class="col-sm-1 control-label" for="app_cd">신청서상태</label>
				                	<div class="col-sm-2"><asms:cdSelect name="app_cd" codeType="EXP01" use="true" optionHead="- 전체 -"/></div>
				                </div>
							</div>
						</div>
			   		</div>
			   	</div>
		   	</form>
		   	<div id="exporteList">
		 	<!-- exportList -->
		   	</div>
	   	</div>
	   	<div id="subSection">
	   	</div>
	</div>
</div>
