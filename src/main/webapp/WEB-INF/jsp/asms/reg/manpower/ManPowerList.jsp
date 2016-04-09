<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsManPowerListSort(orderColumnValue){
	
	var frm = $("form[name='manPowerSendForm']");
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
	jsManPowerListSearch(1);
}

</script>

<form id="manPowerListForm" name="manPowerListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${manPowerVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${manPowerVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsManPowerListSearch" />
			<form:hidden path="pageIndex" />
		</div>
		<!-- 페이지 End -->
	</div>
</div>
<div class="row">
	 <div class="col-lg-12">
	     <div class="ibox float-e-margins">
	         <div class="ibox-title">
	             <h5>인력 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
		           <table class="table table-striped table-bordered table-hover" >
		            <thead>
			            <tr>
			                <th class="widthP5 textCenter"><input type="checkbox" class="parentCheckBox"></th>
			                <th class="widthP20 textCenter"><a href="javascript:jsManPowerListSort('MP_MNG_NO');">관리번호</a>
			                ${manPowerVO.orderColumn eq "MP_MNG_NO" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsManPowerListSort('MP_NM');">인력명</a>
			                ${manPowerVO.orderColumn eq "MP_NM" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsManPowerListSort('MP_CD');">인력구분</a>
			                ${manPowerVO.orderColumn eq "MP_CD" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsManPowerListSort('JOIN_CD');">재직유형</a>
			                ${manPowerVO.orderColumn eq "JOIN_CD" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsManPowerListSort('EMP_CD');">근무유형</a>
			                ${manPowerVO.orderColumn eq "EMP_CD" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP15 textCenter"><a href="javascript:jsManPowerListSort('USE_FLAG');">사용여부</a>
			                ${manPowerVO.orderColumn eq "USE_FLAG" ? manPowerVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty RegManPowerList }">
						            <tr>
						            	<td colspan="7" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${RegManPowerList}" varStatus="status">
						            <tr>
						                <td class="textCenter"><input type="checkbox" class="childCheckBox" name="mp_id" value="${result.mp_id }" checkVal="${result.use_flag }" ></td>
						                <td class="textCenter">${result.mp_mng_no }</td>
						                <td class="textCenter blueText"><a href="javascript:;" onclick="jsManPowerViewForm('${result.mp_id}')">${result.mp_nm }</a></td>
						                <td class="textCenter">${result.mp_cd_cm }</td>
						                <td class="textCenter">${result.join_cd_cm }</td>
						                <td class="textCenter">${result.emp_cd_cm }</td>
						                <td class="textCenter">${result.use_flag_cm }</td>
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