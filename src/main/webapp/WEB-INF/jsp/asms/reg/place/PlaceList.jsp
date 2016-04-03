<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsSort(orderColumnValue){
	
	var frm = $("form[name='placeSendForm']");
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
	jsPlaceListSearch(1);
}

</script>

<form id="placeListForm" name="placeListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${placeVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${placeVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsPlaceListSearch" />
			<form:hidden path="pageIndex" />
		</div>
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
			                <th class="widthP5 textCenter"><input type="checkbox"  checked class="i-checks parentCheckBox"></th>
			                <th class="widthP15 textCenter"><a href="javascript:jsSort('PLC_MNG_NO');">관리번호</a>
			                ${placeVO.orderColumn eq "PLC_MNG_NO" ? placeVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP25 textCenter"><a href="javascript:jsSort('PLC_NM');">장소명</a>
			                ${placeVO.orderColumn eq "PLC_NM" ? placeVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP35 textCenter"><a href="javascript:jsSort('FULL_ADDR');">주소</a>
			                ${placeVO.orderColumn eq "FULL_ADDR" ? placeVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsSort('REG_NM');">등록자</a>
			                ${placeVO.orderColumn eq "REG_NM" ? placeVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsSort('REG_STATUS');">등록상태</a>
			                ${placeVO.orderColumn eq "REG_STATUS" ? placeVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
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
						                <td class="textCenter"><input type="checkbox" class="i-checks childCheckBox" name="${result.plc_id }"></td>
						                <td class="textCenter">${result.plc_mng_no }</td>
						                <td class="textLeft blueText"><a href="javascript:;" onclick="jsPlaceViewForm('${result.plc_id}')">${result.plc_nm }</a></td>
						                <td class="textLeft">${result.full_addr }</td>
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