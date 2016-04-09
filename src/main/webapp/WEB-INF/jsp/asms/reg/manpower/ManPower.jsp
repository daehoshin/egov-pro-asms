<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=manPowerSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	   		jsManPowerListSearch(1);
	    } 
	});
	
	jsManPowerListSearch(1);
	
});

// 인력 검색
function jsManPowerListSearch(pageNo)
{
	var sf = $("form[name=manPowerSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerListSearch.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#regManPowerList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=manPowerListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 인력 등록화면
function jsManPowerAddForm()
{
	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerAddForm.do",
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 인력 수정화면
function jsManPowerModForm(mp_id)
{
	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerModForm.do",
		data : {mp_id : mp_id},
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 인력 상세
function jsManPowerViewForm(mp_id)
{
	$.ajax({
		type : "post",
		url  : "/reg/manpower/manPowerViewForm.do",
		data : {mp_id : mp_id},
		dataType : "html",
		success:function(ajaxResult){

			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});	
}

function jsManPowerSelectUseStart(){
	
	var lf = $("form[name=manPowerListForm]");
	var checkedCnt = lf.find("[name=mp_id]:checked").length;
	var manPowerStatusCnt = 0;
	
	// 선택된 것 중 이미중지 된 인력 확인
	lf.find("[name=mp_id]:checked").each(function(i){
		if($(this).attr("checkVal")=="01"){
			manPowerStatusCnt++;
		}
	});
	
	if(checkedCnt==0){
		alert("사용허가 할 인력을 선택하십시오.");
		return;
	} else {
		if(manPowerStatusCnt > 0){
			alert("이미 사용상태인 인력이 포함되어 있습니다.\n체크를 해제하시고 다시 진행 해 주십시오.");
			return;
		} else {
			var listForm = lf.serialize();
			
			if (confirm("해당 인력의 시스템 이용을 허가하시겠습니까?")) {
				$.ajax({
					type : "post",
					url  : "/rgst/manpower/manPowerSelectUseStartAction.do",
					data : listForm,
					dataType : "html",
					success:function(ajaxResult){
						
						jsManPowerListSearch(1);
						
					}
				});
			}	
		}
	}
}

function jsManPowerSelectUseStop(){
	
	var lf = $("form[name=manPowerListForm]");
	var checkedCnt = lf.find("[name=mp_id]:checked").length;
	var manPowerStatusCnt = 0;
	
	// 선택된 것 중 이미중지 된 인력 확인
	lf.find("[name=mp_id]:checked").each(function(i){
		if($(this).attr("checkVal")=="02"){
			manPowerStatusCnt++;
		}
	});
	
	if(checkedCnt==0){
		alert("사용중지 할 인력을 선택하십시오.");
		return;
	} else {
		if(manPowerStatusCnt > 0){
			alert("이미 중지상태인 인력이 포함되어 있습니다.\n체크를 해제하시고 다시 진행 해 주십시오.");
			return;
		} else {
			var listForm = lf.serialize();
			
			if (confirm("해당 인력의 시스템 이용을 차단하시겠습니까?")) {
				$.ajax({
					type : "post",
					url  : "/rgst/manpower/manPowerSelectUseStopAction.do",
					data : listForm,
					dataType : "html",
					success:function(ajaxResult){
						
						jsManPowerListSearch(1);
						
					}
				});
			}	
		}
	}
}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><i class="fa fa-user"></i> 인력</h2>
        <ol class="breadcrumb">
            <li>등록</li>
            <li class="active">
                <strong>인력</strong>
            </li>
        </ol>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
   	<form id="manPowerSendForm" name="manPowerSendForm" class="form-horizontal" method="post">
   	<input type="hidden" name="pageIndex" value="1">
	<input type="hidden" name="orderColumn" value="">
	<input type="hidden" name="orderType" value="">
	   	<div class="row">
	   		<div class="col-md-12 marginB5">
	   			<div class="pull-right">
	   				<c:choose>
        				<c:when test="${loginUserVO.user_auth_cd eq 1 }">
        					<a href="javascript:;" onclick="jsManPowerAddForm()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 등록</a>
        					<a href="javascript:;" onclick="jsManPowerSelectUseStart()" class="btn btn-outline btn-primary"><i class="fa fa-pencil"></i> 허가</a>
        					<a href="javascript:;" onclick="jsManPowerSelectUseStop()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 중지</a>
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
    			<select name="pageUnit" class="form-control" onchange="jsManPowerListSearch()">
					<option>20</option>
					<option>40</option>
					<option>60</option>
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
								<span>인력 검색</span>	
							</div>
							<div class="col-md-4">
								<div class="pull-right">
				                    <a href="javascript:;" onclick="jsSrchReset('manPowerSendForm','jsManPowerListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
				                    <a href="javascript:;" onclick="jsManPowerListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
				               	</div>
							</div>
						</div>
					</div>
					<div class="ibox-content">
		                <div class="form-group">
		                	<label class="col-sm-1 control-label" for="mp_mng_no">관리번호</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="mp_mng_no" id="mp_mng_no"></div>
		                	<label class="col-sm-1 control-label" for="dept_nm">부서명</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="dept_nm" id="dept_nm"></div>
		                	<label class="col-sm-1 control-label" for="mp_nm">인력명</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="mp_nm" id="mp_nm"></div>
		                	<label class="col-sm-1 control-label" for="join_dt">입사일</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="join_dt" id="join_dt"></div>
		                </div>
		                <div class="form-group">
		                	<label class="col-sm-1 control-label" for="mp_cd">인력구분</label>
		                	<div class="col-sm-2">
	                			<asms:cdSelect name="mp_cd" codeType="MP02" use="true" optionHead="- 전체 -"/>
		                	</div>
		                	<label class="col-sm-1 control-label" for="join_cd">재직유무</label>
		                	<div class="col-sm-2">
	                			<asms:cdSelect name="join_cd" codeType="MP04" use="true" optionHead="- 전체 -"/>
		                	</div>
		                	<label class="col-sm-1 control-label" for="emp_cd">근무유형</label>
		                	<div class="col-sm-2">
	                			<asms:cdSelect name="emp_cd" codeType="MP03" use="true" optionHead="- 전체 -"/>
		                	</div>
		                	<label class="col-sm-1 control-label" for="use_flag">사용여부</label>
		                	<div class="col-sm-2">
	                			<asms:cdSelect name="use_flag" codeType="MP01" use="true" optionHead="- 전체 -"/>
		                	</div>
		                </div>
					</div>
				</div>
	   		</div>
	   	</div>
   	</form>
   	<div id="regManPowerList">
 	<!-- regManPowerList -->
   	</div>
</div>
