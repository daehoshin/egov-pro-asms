<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
$(document).ready(function() {
	
	$.ajaxSetup({
		async: false
	});
	$("#myModal").draggable({
	    handle: ".modal-header"
	});
	
	$(document).ajaxStart(function () {
		$("#ProgressBar").fadeIn(250);
	}).ajaxStop(function () {
		$("#ProgressBar").fadeOut(250);
	}).ajaxError(function( event, jqxhr, settings, thrownError ) {
		if ( jqxhr.status == 403 ) {
			alert("세션이 종료되었습니다 \n로그인페이지로 이동합니다.");
			location.href = "/welcome.jsp";
		} else if ( jqxhr.status == 1001 ) {
			alert("첨부파일은 최대 500MB까지 업로드할 수 있습니다.");
		} else if ( jqxhr.status == 1002 ) {
			alert("잘못된 파일형식(확장자) 입니다.");
		} else if ( jqxhr.status == 1003 ) {
			alert("첨부파일은 최대 2GB까지 업로드할 수 있습니다.");
		} else if ( jqxhr.status == 1004 ) {
			alert("파일업로드 에러입니다.");
		} else {
			alert(thrownError);
		}
	});
	
});
</script>
<div id="ProgressBar" class="sk-spinner sk-spinner-wave" style="display:none;">
    <div class="sk-rect1"></div>
    <div class="sk-rect2"></div>
    <div class="sk-rect3"></div>
    <div class="sk-rect4"></div>
    <div class="sk-rect5"></div>
</div>
<div class="modal inmodal fade" id="myModal" tabindex="-1" role="dialog"  aria-hidden="true"></div>
