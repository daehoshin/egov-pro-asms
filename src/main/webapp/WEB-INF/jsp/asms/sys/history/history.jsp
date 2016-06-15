<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=historySendForm]").find('input, select').keypress(function(e) {
	    if (e.keyHistory == 13){
	   		jsHistoryListSearch(1);
	    } 
	});
	
	jsHistoryListSearch(1);
	
});

//감사이력 검색
function jsHistoryListSearch(pageNo)
{
	var sf = $("form[name=historySendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/sys/history/historyListSearch.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#historyList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=historyListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

//감사이력 등록화면
function jsHistoryAddForm()
{
	$.ajax({
		type : "post",
		url  : "/sys/history/historyAddForm.do",
		dataType : "html",
		success:function(ajaxResult){
			
			$('#mainSection').addClass('col-md-8');
			$('#subSection').addClass('col-md-4');
			$('#subSection').html(ajaxResult);
		  
			jsInitialize();
			
		}, error: function(xhr,status,error){
			 
		}
	});
}

//감사이력 수정화면
function jsHistoryModForm(history_id)
{
	$.ajax({
		type : "post",
		url  : "/sys/history/historyModForm.do",
		data : {history_id : history_id},
		dataType : "html",
		success:function(ajaxResult){
			
			$('#mainSection').addClass('col-md-8');
			$('#subSection').addClass('col-md-4');
			$('#subSection').html(ajaxResult);
		  
			jsInitialize();
			
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 감사이력 상세
function jsHistoryViewForm(history_id){

	$.ajax({
		type : "post",
		url  : "/sys/history/historyViewForm.do",
		data : {history_id : history_id},
		dataType : "html",
		success:function(ajaxResult){

			$('#mainSection').addClass('col-md-8');
			$('#subSection').addClass('col-md-4');
			$('#subSection').html(ajaxResult);
		  
		}, error: function(xhr,status,error){
			 
		}
	});	
	
}

function jsCloseView(){
	$('#mainSection').removeClass('col-md-8');
	$('#subSection').removeClass('col-md-4');
}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><i class="fa fa-sun-o"></i> 감사이력 관리</h2>
        <ol class="breadcrumb">
            <li>시스템</li>
            <li class="active">
                <strong>감사이력 관리</strong>
            </li>
        </ol>
    </div>
</div>  
<div class="wrapper wrapper-content animated fadeInRight">
   	<div class="row">
   		<div id="mainSection">
		   	<form id="historySendForm" name="historySendForm" class="form-horizontal" method="post">
		   	<input type="hidden" name="pageIndex" value="1">
			<input type="hidden" name="orderColumn" value="">
			<input type="hidden" name="orderType" value="">
			   	<div class="row">
			   		<div class="col-md-12 marginB5">
			   			<div class="pull-right">
			   				<c:choose>
		        				<c:when test="${loginHistoryVO.history_auth_cd eq 1 }">
		        					<a href="javascript:;" onclick="jsHistoryAddForm()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 등록</a>
					        		<a href="javascript:;" onclick="jsHistorySelectDel()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 삭제</a>
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
		    			<select name="pageUnit" class="form-control" onchange="jsHistoryListSearch()">
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
										<span>감사이력 검색</span>	
									</div>
									<div class="col-md-4">
										<div class="pull-right">
						                    <a href="javascript:;" onclick="jsSrchReset('historySendForm','jsHistoryListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
						                    <a href="javascript:;" onclick="jsHistoryListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
						               	</div>
									</div>
								</div>
							</div>
							<div class="ibox-content">
				                <div class="form-group">
				                	<label class="col-sm-1 control-label" for="history_nm">감사이력명</label>
				                    <div class="col-sm-3"><input type="text" class="form-control" name="history_nm" id="history_nm"></div>
				                	<label class="col-sm-1 control-label" for="reg_nm">등록자</label>
				                    <div class="col-sm-3"><input type="text" class="form-control" name="reg_nm" id="reg_nm"></div>
				                	<label class="col-sm-1 control-label" for="use_flag">사용여부</label>
				                    <div class="col-sm-3"><asms:cdSelect name="use_flag" historyType="DEP01" use="true" optionHead="- 전체 -"/></div>
								</div>
							</div>
							<div class="ibox-content">
				                <div class="form-group">
				                	<label class="col-sm-1 control-label" for="detp_find_nm">감사이력찾기</label>
				                    <div class="col-sm-3">
				                    	<div class="input-group m-b">
				                    		<input type="text" class="form-control" id="history_find_nm" name="history_find_nm" readonly="readonly"> <span class="input-group-addon" onclick="jsHistoryMdSearch('historySendForm','history_find_id','history_find_nm')"><span class="fa fa-sun-o"></span></span>
				                    		<input type="hidden" name="history_find_id" id="history_find_id">
				                    	</div>
				                    </div>
				                	<label class="col-sm-1 control-label" for="mp_find_nm">인력찾기</label>
				                    <div class="col-sm-3">
				                    	<div class="input-group m-b">
				                    		<input type="text" class="form-control" id="mp_find_nm" name="mp_find_nm" readonly="readonly"> <span class="input-group-addon" onclick="jsMpMdSearch('mpSendForm','mp_find_id','mp_find_nm')"><span class="fa fa-sun-o"></span></span>
				                    		<input type="hidden" name="mp_find_id" id="mp_find_id">
				                    	</div>
				                    </div>
				                	<label class="col-sm-1 control-label" for="store_find_nm">제조사찾기</label>
				                    <div class="col-sm-3">
				                    	<div class="input-group m-b">
				                    		<input type="text" class="form-control" id="store_find_nm" name="store_find_nm" readonly="readonly"> <span class="input-group-addon" onclick="jsStoreMdSearch('storeSendForm','store_find_id','store_find_nm')"><span class="fa fa-sun-o"></span></span>
				                    		<input type="hidden" name="store_find_id" id="store_find_id">
				                    	</div>
				                    </div>
								</div>
							</div>
				   		</div>
				   	</div>
				</div>
		   	</form>
		   	<div id="historyList">
		 	<!-- historyList -->
		   	</div>   			
   		</div>
   		<div id="subSection">
   		<!-- historyAdd -->
   		</div>
   	</div>
</div>
