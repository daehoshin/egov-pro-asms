<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=placeSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	   		jsPlaceListSearch(1);
	    } 
	});
	
	jsPlaceListSearch(1);
	
});

// 장소 검색
function jsPlaceListSearch(pageNo)
{
	var sf = $("form[name=placeSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/rgst/place/placeListSearch.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#regPlaceList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=placeListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 장소 등록화면
function jsPlaceAddForm()
{
	$.ajax({
		type : "post",
		url  : "/rgst/place/placeAddForm.do",
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 장소 수정화면
function jsPlaceModForm(plc_id)
{
	$.ajax({
		type : "post",
		url  : "/rgst/place/placeModForm.do",
		data : {plc_id : plc_id},
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

// 장소 상세
function jsPlaceViewForm(plc_id)
{
	$.ajax({
		type : "post",
		url  : "/rgst/place/placeViewForm.do",
		data : {plc_id : plc_id},
		dataType : "html",
		success:function(ajaxResult){

			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});	
}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2>장소</h2>
        <ol class="breadcrumb">
            <li>등록</li>
            <li class="active">
                <strong>장소</strong>
            </li>
        </ol>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
   	<form id="placeSendForm" name="placeSendForm" class="form-horizontal" method="post">
   	<input type="hidden" name="pageIndex" value="1">
	<input type="hidden" name="orderColumn" value="">
	<input type="hidden" name="orderType" value="">
	   	<div class="row">
	   		<div class="col-md-12 marginB5">
	   			<div class="pull-right">
			   		<a href="javascript:;" onclick="jsPlaceAddForm()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 등록</a>
			        <a href="javascript:;" onclick="" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 삭제</a>
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
    			<select name="pageUnit" class="form-control" onchange="jsPlaceListSearch()">
					<option>10</option>
					<option>30</option>
					<option>50</option>
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
								<span>장소 검색</span>	
							</div>
							<div class="col-md-4">
								<div class="pull-right">
				                    <a href="javascript:;" onclick="jsSrchReset('placeSendForm','jsPlaceListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
				                    <a href="javascript:;" onclick="jsPlaceListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
				               	</div>
							</div>
						</div>
					</div>
					<div class="ibox-content">
		                <div class="form-group">
		                	<label class="col-sm-1 control-label" for="plc_mng_no">관리번호</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="plc_mng_no" id="plc_mng_no"></div>
		                	<label class="col-sm-1 control-label" for="plc_nm">장소명</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="plc_nm" id="plc_nm"></div>
		                	<label class="col-sm-1 control-label" for="full_addr">주소</label>
		                    <div class="col-sm-2"><input type="text" class="form-control" name="full_addr" id="full_addr"></div>
		                	<label class="col-sm-1 control-label" for="reg_stauts">등록상태</label>
		                    <div class="col-sm-2"><asms:cdSelect name="reg_status" codeType="PLC01" use="true" optionHead="- 전체 -"/></div>
		                </div>
					</div>
				</div>
	   		</div>
	   	</div>
   	</form>
   	<div id="regPlaceList">
 	<!-- regPlaceList -->
   	</div>
</div>
