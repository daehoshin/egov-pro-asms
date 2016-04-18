<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsEquipmentListSort(orderColumnValue){
	
	var frm = $("form[name='equipmentSendForm']");
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
<input type="hidden" name="orderColumn" value="<c:out value="${equipmentVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${equipmentVO.orderType}"/>">
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
	             <h5>장비 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
		           <table class="table table-striped table-bordered table-hover" >
		            <thead>
			            <tr>
			                <th class="widthP5 textCenter"><input type="checkbox" class="parentCheckBox"></th>
			                <th class="widthP15 textCenter"><a href="javascript:jsEquipmentListSort('EQM_MNG_NO');">관리번호</a>
			                ${equipmentVO.orderColumn eq "EQM_MNG_NO" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsEquipmentListSort('EQM_NM');">장비명</a>
			                ${equipmentVO.orderColumn eq "EQM_NM" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('EQM_STATE_CD');">장비상태</a>
			                ${equipmentVO.orderColumn eq "EQM_STATE_CD" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP5 textCenter"><a href="javascript:jsEquipmentListSort('EQM_SIZE');">크기</a>
			                ${equipmentVO.orderColumn eq "EQM_SIZE" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('EQM_WEIGHT');">무게</a>
			                ${equipmentVO.orderColumn eq "EQM_WEIGHT" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('QUALITY');">재질</a>
			                ${equipmentVO.orderColumn eq "QUALITY" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('HND_TYPE');">취급유형</a>
			                ${equipmentVO.orderColumn eq "HND_TYPE" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('REG_NM');">등록자</a>
			                ${equipmentVO.orderColumn eq "REG_NM" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsEquipmentListSort('REG_STATUS');">등록상태</a>
			                ${equipmentVO.orderColumn eq "REG_STATUS" ? equipmentVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty RegEquipmentList }">
						            <tr>
						            	<td colspan="6" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${RegEquipmentList}" varStatus="status">
						            <tr>
						                <td class="textCenter"><input type="checkbox" class="childCheckBox" name="eqm_id" value="${result.eqm_id }" checkVal="${result.reg_status }"></td>
						                <td class="textCenter">${result.eqm_mng_no }</td>
						                <td class="textCenter blueText"><a href="javascript:;" onclick="jsEquipmentViewForm('${result.eqm_id}')">${result.eqm_nm }</a></td>
						                <td class="textCenter">${result.eqm_state_cd_cm }</td>
						                <td class="textCenter">${result.eqm_size_cm }</td>
						                <td class="textCenter">${result.eqm_weight_cm }</td>
						                <td class="textCenter">${result.quality_cm }</td>
						                <td class="textCenter">${result.hnd_type_cm }</td>
						                <td class="textCenter">${result.reg_nm }</td>
						                <td class="textCenter">${result.reg_status_cm }</td>
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