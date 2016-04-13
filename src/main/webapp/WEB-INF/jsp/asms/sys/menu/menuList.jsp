<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsMenuListSort(orderColumnValue){
	
	var frm = $("form[name='menuSendForm']");
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
	jsMenuListSearch(1);
}

</script>

<form id="menuListForm" name="menuListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${menuVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${menuVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsMenuListSearch" />
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
			                <th class="widthP30 textCenter"><a href="javascript:jsMenuListSort('MENU_GRP_ID');">메뉴코드</a>
			                ${menuVO.orderColumn eq "DEPT_CD" ? menuVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP35 textCenter"><a href="javascript:jsMenuListSort('MENU_GRP_NM');">메뉴명</a>
			                ${menuVO.orderColumn eq "DEPT_NM" ? menuVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP30 textCenter"><a href="javascript:jsMenuListSort('USE_FLAG');">사용여부</a>
			                ${menuVO.orderColumn eq "USE_FLAG" ? menuVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty SysMenuList }">
						            <tr>
						            	<td colspan="4" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${SysMenuList}" varStatus="status">
						            <tr>
						                <td class="textCenter"><input type="checkbox" class="childCheckBox" name="menu_id" value="${result.menu_id }"></td>
						                <td class="textCenter">${result.menu_cd }</td>
						                <td class="textLeft blueText"><a href="javascript:;" onclick="jsMenuViewForm('${result.menu_id}')">${result.menu_nm }</a></td>
						                <td class="textLeft">${result.use_flag_cm }</td>
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