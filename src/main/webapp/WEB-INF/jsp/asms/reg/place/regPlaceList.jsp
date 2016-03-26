<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<div class="row">
	 <div class="col-lg-12">
	     <div class="ibox float-e-margins">
	         <div class="ibox-title">
	             <h5>장소 목록</h5>
	         </div>
	         <div class="ibox-content">
	             <div class="table-responsive">
	           <table class="table table-striped table-bordered table-hover dataTables-example" >
	            <thead>
		            <tr>
		                <th><input type="checkbox"  checked class="i-checks" name="input[]"></th>
		                <th>관리번호</th>
		                <th>장소명</th>
		                <th>주소</th>
		                <th>등록자</th>
		                <th>등록상태</th>
		            </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="result" items="${RegPlaceList}" varStatus="status">
			            <tr>
			                <td><input type="checkbox"  checked class="i-checks" name="input[]"></td>
			                <td>${status.count }</td>
			                <td>${result.plc_no }</td>
			                <td>${result.plc_nm }</td>
			                <td>${result.full_addr }</td>
			                <td>${result.reg_nm }</td>
			                <td>${result.reg_status_cm }</td>
			            </tr>
		            </c:forEach>
	            </tbody>
	            <tfoot>
		            <tr>
		                <th><input type="checkbox"  checked class="i-checks" name="input[]"></th>
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