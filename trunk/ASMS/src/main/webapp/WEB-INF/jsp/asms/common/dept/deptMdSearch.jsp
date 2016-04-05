<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=deptMdSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	   		jsDeptMdListSearch(1);
	    } 
	});
	
	jsDeptMdListSearch(1);
	
});

//부서 검색
function jsDeptMdListSearch(pageNo)
{
	var sf = $("form[name=deptMdSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/common/dept/deptMdSearchList.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#departmentMdList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=deptMdListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

function jsDeptMdClose() {
	$('#myModal').modal('hide');
}
</script>
<div class="modal-dialog" style="width: 850px">
	<div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">부서 선택</h4>
        </div>
        <div class="modal-body">
		   	<form id="deptMdSendForm" name="deptMdSendForm" class="form-horizontal" method="post">
		   	<input type="hidden" name="pageIndex" value="1">
			<input type="hidden" name="orderColumn" value="">
			<input type="hidden" name="orderType" value="">
			<input type="hidden" name="targetForm" value="${targetForm }">
			<input type="hidden" name="targetId" value="${targetId }">
			<input type="hidden" name="targetNm" value="${targetNm }">
			   	<div class="row">
			   		<div class="col-md-12 marginB5">
			   			<div class="pull-right">
        					<a href="javascript:;" onclick="jsDeptMdSelect()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 선택</a>
			        		<a href="javascript:;" onclick="jsDeptMdClose()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 닫기</a>
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
		    			<select name="pageUnit" class="form-control" onchange="jsDeptMdListSearch()">
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
										<span>부서 검색</span>	
									</div>
									<div class="col-md-4">
										<div class="pull-right">
						                    <a href="javascript:;" onclick="jsMdSrchReset('deptSendForm','jsDeptMdListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
						                    <a href="javascript:;" onclick="jsDeptMdListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
						               	</div>
									</div>
								</div>
							</div>
							<div class="ibox-content">
				                <div class="form-group">
				                	<label class="col-sm-1 control-label" for="dept_nm">부서명</label>
				                    <div class="col-sm-3"><input type="text" class="form-control" name="dept_nm" id="dept_nm"></div>
				                	<label class="col-sm-1 control-label" for="reg_nm">등록자</label>
				                    <div class="col-sm-3"><input type="text" class="form-control" name="reg_nm" id="reg_nm"></div>
				                	<label class="col-sm-1 control-label" for="use_flag">사용여부</label>
				                    <div class="col-sm-3"><asms:cdSelect name="use_flag" codeType="DEP01" use="true" optionHead="- 전체 -"/></div>
								</div>
							</div>
				   		</div>
				   	</div>
				</div>
		   	</form>
		   	<div id="departmentMdList">
		 	<!-- departmentMdList -->
		   	</div>		
        </div>
    </div>
</div>
