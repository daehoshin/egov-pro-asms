<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsExportListSort(orderColumnValue){
	
	var frm = $("form[name='exportSendForm']");
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
	jsExportListSearch(1);
}

</script>

<form id="exportListForm" name="exportListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${exportVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${exportVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsExportListSearch" />
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
			                <th class="widthP5 textCenter"><input type="checkbox" class="parentCheckBox"></th>
			                <th class="widthP15 textCenter"><a href="javascript:jsExportListSort('APP_NO');">관리번호</a>
			                ${exportVO.orderColumn eq "APP_NO" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP25 textCenter"><a href="javascript:jsExportListSort('APP_NM');">신청서명</a>
			                ${exportVO.orderColumn eq "APP_NM" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsExportListSort('REG_DT');">등록일자</a>
			                ${exportVO.orderColumn eq "REG_DT" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                <th class="widthP10 textCenter"><a href="javascript:jsExportListSort('APP_DT');">신청일자</a>
			                ${exportVO.orderColumn eq "APP_DT" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                <th class="widthP10 textCenter"><a href="javascript:jsExportListSort('CONFIRM_DT');">확인일자</a>
			                ${exportVO.orderColumn eq "CONFIRM_DT" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsExportListSort('REG_NM');">등록자</a>
			                ${exportVO.orderColumn eq "REG_NM" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP10 textCenter"><a href="javascript:jsExportListSort('APP_CD_NM');">신청서상태</a>
			                ${exportVO.orderColumn eq "APP_CD_NM" ? exportVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty exportList }">
						            <tr>
						            	<td colspan="8" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${exportList}" varStatus="status">
						            <tr>
						                <td class="textCenter"><input type="checkbox" class="childCheckBox" name="app_id" value="${result.app_id}" checkVal="${result.app_cd }"></td>
						                <td class="textCenter">${result.app_no }</td>
						                <td class="textLeft blueText"><a href="javascript:;" onclick="jsExportDetailForm('${result.app_id}')">${result.app_nm }</a></td>
						                <td class="textCenter">${result.reg_dt }</td>
						                <td class="textCenter">${result.app_dt }</td>
						                <td class="textCenter">${result.confirm_dt }</td>
						                <td class="textCenter">${result.reg_nm }</td>
						                <td class="textCenter">${result.app_cd_nm }</td>
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