<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="asms" uri="/WEB-INF/tlds/asms.tld" %>
<%@ include file= '/WEB-INF/jsp/asms/common/orderByImage.jsp'%>
<script type="text/javascript">

//정렬
function jsMpMdListSort(orderColumnValue){
	
	var frm = $("form[name='mpMdSendForm']");
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
	jsMpMdListSearch(1);
}

//선택된 값 타겟에 넣어줌
function jsTargetInsert(mp_id, mp_nm, targetForm, targetId, targetNm){
	$("#"+targetForm).find("#"+targetId).val(mp_id);
	$("#"+targetForm).find("#"+targetNm).val(mp_nm); 
	jsMpMdClose();
}
</script>

<form id="mpMdListForm" name="mpMdListForm" method="post">
<input type="hidden" name="listCnt" value="${paginationInfo.totalRecordCount }">
<input type="hidden" name="orderColumn" value="<c:out value="${mpMdVO.orderColumn}"/>">
<input type="hidden" name="orderType" value="<c:out value="${mpMdVO.orderType}"/>">
<div class="row">
	 <div class="col-lg-12">
		<!-- 페이지 Start -->
		<div class="btn-group">
			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="jsMpMdListSearch" />
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
			                <th class="widthP30 textCenter"><a href="javascript:jsMpMdListSort('MP_CD');">인력코드</a>
			                ${mpMdVO.orderColumn eq "MP_CD" ? mpMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP35 textCenter"><a href="javascript:jsMpMdListSort('MP_NM');">인력명</a>
			                ${mpMdVO.orderColumn eq "MP_NM" ? mpMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			                <th class="widthP30 textCenter"><a href="javascript:jsMpMdListSort('USE_FLAG');">사용여부</a>
			                ${mpMdVO.orderColumn eq "USE_FLAG" ? mpMdVO.orderType eq "ASC" ? sAscSortImg : sDescSortImg : "" }
			                </th>
			            </tr>
		            </thead>
		            <tbody>
		            	<c:choose>
		            		<c:when test="${empty mpMdList }">
						            <tr>
						            	<td colspan="4" class="text-center">조회된 목록이 없습니다.</td>
						            </tr>	            		
		            		</c:when>
		            		<c:otherwise>
		            			<c:forEach var="result" items="${mpMdList}" varStatus="status">
						            <tr>
						                <td class="textCenter">${result.mp_cd }</td>
						                <td class="textLeft blueText"><a href="javascript:;" ondblclick="jsTargetInsert('${result.mp_id}','${result.mp_nm}','${mpMdVO.targetForm }','${mpMdVO.targetId }','${mpMdVO.targetNm }')">${result.mp_nm }</a></td>
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