<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("form[name=menuSendForm]").find('input, select').keypress(function(e) {
	    if (e.keyCode == 13){
	   		jsMenuListSearch(1);
	    } 
	});
	
	jsMenuListSearch(1);
	
});

//메뉴 검색
function jsMenuListSearch(pageNo)
{
	var sf = $("form[name=menuSendForm]");
	
	if (pageNo >= 1){
		sf.find("input[name='pageIndex']").val(pageNo);
	}

	var sendForm = sf.serialize();

	$.ajax({
		type : "post",
		url  : "/sys/menu/menuListSearch.do",
		data : sendForm,
		dataType : "html",
		success:function(ajaxResult){
			
			// 조회된 리스트 넣어줌
			$('#menuList').html(ajaxResult);
			
			// 전체 건수 넣어줌
			var lf = $("form[name=menuListForm]");			
			sf.find("span[id=totalCnt]").html(lf.find("[name=listCnt]").val());
			sf.find("input[name='orderColumn']").val(lf.find("input[name='orderColumn']").val());
			sf.find("input[name='orderType']").val(lf.find("input[name='orderType']").val());
			
			// basic style initialize
			jsInitialize();
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

//메뉴 등록
function jsMenuAddForm(){
	$.ajax({
		type : "post",
		url  : "/sys/menu/menuAddForm.do",
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});
}

/* 
//메뉴 추가화면
function jsMenuAddForm()
{
	$.ajax({
		type : "post",
		url  : "/sys/menu/menuAddForm.do",
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

 */

//메뉴 수정화면
function jsDeptModForm(menu_id)
{
	$.ajax({
		type : "post",
		url  : "/sys/menu/menuModForm.do",
		data : {menu_id : menu_id},
		dataType : "html",
		success:function(ajaxResult){
			
			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
			jsInitialize();
			
		}, error: function(xhr,status,error){
			 
		}
	});
}
 
//메뉴 상세
function jsMenuViewForm(menu_grp_id){

	$.ajax({
		type : "post",
		url  : "/sys/menu/menuViewForm.do",
		data : {menu_grp_id : menu_grp_id},
		dataType : "html",
		success:function(ajaxResult){

			$('#myModal').html(ajaxResult);
			$('#myModal').modal('show');
		  
		}, error: function(xhr,status,error){
			 
		}
	});	
	
}

function jsCloseView(){
	$('#myModal').modal('hide');
}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><i class="fa fa-sliders"></i> 메뉴 관리</h2>
        <ol class="breadcrumb">
            <li>시스템</li>
            <li class="active">
                <strong>메뉴 관리</strong>
            </li>
        </ol>
    </div>
</div>  
<div class="wrapper wrapper-content animated fadeInRight">
   	<div class="row">
   		<div id="mainSection">
		   	<form id="menuSendForm" name="menuSendForm" class="form-horizontal" method="post">
		   	<input type="hidden" name="pageIndex" value="1">
			<input type="hidden" name="orderColumn" value="">
			<input type="hidden" name="orderType" value="">
			   	<div class="row">
			   		<div class="col-md-12 marginB5">
			   			<div class="pull-right">
			   				<c:choose>
		        				<c:when test="${loginUserVO.user_auth_cd eq 1 }">
		        					<a href="javascript:;" onclick="jsMenuAddForm()" class="btn btn-outline btn-success"><i class="fa fa-pencil"></i> 등록</a>
					        		<a href="javascript:;" onclick="jsMenuSelectDel()" class="btn btn-outline btn-danger"><i class="fa fa-pencil"></i> 삭제</a>
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
		    			<select name="pageUnit" class="form-control" onchange="jsDeptListSearch()">
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
										<span>메뉴 검색</span>	
									</div>
									<div class="col-md-4">
										<div class="pull-right">
						                    <a href="javascript:;" onclick="jsSrchReset('menuSendForm','jsMenuListSearch(1)')" class="btn btn-outline btn-default"><i class="fa fa-refresh"></i> 검색 초기화</a>
						                    <a href="javascript:;" onclick="jsMenuListSearch('1')" class="btn btn-outline btn-default"><i class="fa fa-search"></i> 검색</a>
						               	</div>
									</div>
								</div>
							</div>
				   		</div>
				   	</div>
				</div>
		   	</form>
		   	<div id="menuList">
		 	<!-- menuList -->
		   	</div>   			
   		</div>
   		<div id="subSection">
   		<!-- menuAdd -->
   		</div>
   	</div>
</div>
