<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>

<form id="placeListForm" name="placeListForm" class="form-horizontal" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<ul class="pagination pagination-sm">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsPlaceListSearch" />
			<form:hidden path="pageIndex" />
		</ul>
		<!-- 페이지 End -->
	</div>
</div>
<div class="row">
	 <div class="col-lg-12">
	     <div class="ibox float-e-margins">
	         <div class="ibox-title">
	             <h5>장소 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
		           <table class="table table-striped table-bordered table-hover" >
		            <thead>
			            <tr>
			                <th><input type="checkbox"  checked class="i-checks parentCheckBox"></th>
			                <th>관리번호</th>
			                <th>장소명</th>
			                <th>주소</th>
			                <th>등록자</th>
			                <th>등록상태</th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty RegPlaceList }">
						            <tr>
						            	<td colspan="7" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${RegPlaceList}" varStatus="status">
						            <tr>
						                <td><input type="checkbox" class="i-checks childCheckBox" name="${result.plc_id }"></td>
						                <td>${result.plc_mng_no }</td>
						                <td class="text-navy"><a href="javascript:;" onclick="jsPlaceViewForm('${result.plc_id}')">${result.plc_nm }</a></td>
						                <td>${result.full_addr }</td>
						                <td>${result.reg_nm }</td>
						                <td>${result.reg_status_cm }</td>
						            </tr>
					            </c:forEach>
		            		</c:otherwise>
		            	</c:choose>
		            </tbody>
		            <tfoot>
			            <tr>
			                <th><input type="checkbox"  checked class="i-checks parentCheckBox"></th>
			                <th>관리번호</th>
			                <th>장소명</th>
			                <th>주소</th>
			                <th>등록자</th>
			                <th>등록상태</th>
			            </tr>
		            </tfoot>
		           </table>
	             </div>
	         </div>
	     </div>
	 </div>
</div>
</form> 