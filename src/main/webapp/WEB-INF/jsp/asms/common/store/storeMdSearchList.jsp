<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsStoreMdListSort(orderColumnValue){
	
	var frm = $("form[name='storeMdSendForm']");
	var orderColumn = frm.find("input[name='orderColumn']");
	var orderType = frm.find("input[name='orderType']");
	
	if(orderColumn.val() == orderColumnValue || orderColumn.val() == "") {
		if(orderType.val() == "DESC" || orderType.val() == "") {
			orderType.val("ASC");
	    }else{
	    	orderType.val("DESC");
	    } 
	}else{
		orderType.val("DESC");
	}
	orderColumn.val(orderColumnValue);
	jsMPMdListSearch(1);
}

//선택된 값 타겟에 넣어줌
function jsTargetInsert(st_id, store_nm, targetForm, targetId, targetNm){
	$("#"+targetForm).find("#"+targetId).val(st_id);
	$("#"+targetForm).find("#"+targetNm).val(store_nm); 
	jsStoreMdClose();
}
</script>

<form id="storeMdListForm" name="storeMdListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${storeMdVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${storeMdVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsStoreMdListSearch" />
			<form:hidden path="pageIndex" />
		</div>
		<!-- 페이지 End -->
	</div>
</div>
<div class="row">
	 <div class="col-lg-12">
	     <div class="ibox float-e-margins">
	         <div class="ibox-title">
	             <h5>제조사 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
		           <table class="table table-striped table-bordered table-hover" >
		            <thead>
			            <tr>
			                <th class="widthP20 textCenter"><a href="javascript:jsStoreListSort('ST_NM');">제조사명</a>
			                ${storeMdVO.orderColumn eq "ST_NM" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsStoreListSort('DEPT_NM');">부서명</a>
			                ${storeMdVO.orderColumn eq "DEPT_NM" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsStoreListSort('CONFIRMOR_NM');">담당자명</a>
			                ${storeMdVO.orderColumn eq "CONFIRMOR_NM" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP30 textCenter"><a href="javascript:jsStoreListSort('FULL_ADDR');">주소</a>
			                ${storeMdVO.orderColumn eq "FULL_ADDR" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP20 textCenter"><a href="javascript:jsStoreListSort('TEL_NO');">전화번호</a>
			                ${storeMdVO.orderColumn eq "TEL_NO" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsStoreListSort('REG_NM');">등록자명</a>
			                ${storeMdVO.orderColumn eq "REG_NM" ? storeMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty storeMdList }">
						            <tr>
						            	<td colspan="6" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${storeMdList}" varStatus="status">
						            <tr>
						            	<td class="textCenter blueText"><a href="javascript:;" ondblclick="jsTargetInsert('${result.st_id}','${result.st_nm}','${storeMdVO.targetForm }','${storeMdVO.targetId }','${storeMdVO.targetNm }')">${result.st_nm }</a></td>
						                <td class="textCenter">${result.dept_nm }</td>
						                <td class="textCenter">${result.confirmor_nm }</td>
						                <td class="textLeft">${result.full_addr }</td>
						                <td class="textCenter">${result.tel_no }</td>
						                <td class="textCenter">${result.reg_nm }</td>
						            </tr>
					            </c:forEach>
		            		</c:otherwise>
		            	</c:choose>
		            </tbody>
		           </table>
	             </div>
	         </div>
	     </div>
	 </div>
</div>
</form>