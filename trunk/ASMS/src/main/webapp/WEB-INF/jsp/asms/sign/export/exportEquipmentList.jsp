<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsEquipmentListSort(orderColumnValue){
	
	var frm = $("form[name='exportDetailForm']");
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
	jsEquipmentListSearch(1);
}

</script>

<form id="equipmentListForm" name="equipmentListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${exportEquipmentVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${exportEquipmentVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsEquipmentListSearch" />
			<form:hidden path="pageIndex" />
		</div>
		<!-- 페이지 End -->
	</div>
</div>
<div class="row">
	 <div class="col-lg-12">
	     <div class="ibox float-e-margins">
	         <div class="ibox-title">
	             <h5>반출대상장비 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
		           <table class="table table-striped table-bordered table-hover" >
		            <thead>
			            <tr>
			                <th class="widthP5 textCenter"><input type="checkbox" class="parentCheckBox"></th>
			                <th class="widthP15 textCenter"><a href="javascript:jsEquipmentListSort('EXPORT_CD');">반출상태</a>
			                ${exportEquipmentVO.orderColumn eq "EXPORT_CD" ? exportEquipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP25 textCenter"><a href="javascript:jsEquipmentListSort('EXPORT_RSN');">반출상태 사유</a>
			                ${exportEquipmentVO.orderColumn eq "EXPORT_RSN" ? exportEquipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('EXPORT_DT');">반출일</a>
			                ${exportEquipmentVO.orderColumn eq "EXPORT_DT" ? exportEquipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('RETURN_DUE_DT');">반납예정일</a>
			                ${exportEquipmentVO.orderColumn eq "RETURN_DUE_DT" ? exportEquipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty exportEquipmentList }">
						            <tr>
						            	<td colspan="8" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${exportEquipmentList}" varStatus="status">
						            <tr>
						                <td class="textCenter"><input type="checkbox" class="childCheckBox" name="eqm_id" value="${result.eqm_id}"></td>
						                <td class="textCenter">${result.export_cd }</td>
						                <td class="textLeft">${result.export_rsn }</td>
						                <td class="textCenter">${result.export_dt }</td>
						                <td class="textCenter">${result.return_due_dt }</td>
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