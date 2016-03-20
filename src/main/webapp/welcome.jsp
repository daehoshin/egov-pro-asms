<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.*"%>
<%
	String result = request.getParameter("result") == null
			? ""
			: (String) request.getParameter("result");
	if (session.getAttribute("LoginUser") != null) { // login 되어 있지 않은 상태
		response.sendRedirect("/main.do");
	}
%>
<html>
<head>
<title>자산관리시스템</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="/css/login/login-kdj/login.css" />
<!-- <script src="/js/common/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/bootstrap-theme/html/js/placeholders.jquery.js"></script> -->
<script type="text/javascript">

	$(document).ready(function() {
		$("#id").focus();
		var loginResult = "<c:out value='${param.result}' />";
		
		if (loginResult == "false") {
			alert("사용자 아이디가 없거나 비밀번호가 일치하지 않습니다.");
		}

		if (opener) {
			alert("세션이 종료되었습니다.");
// 			opener.location.href = "<c:url value="/welcome.jsp"/>";
			self.close();
		}
		
		 $("#id").keyup(function(event){
	        if (!(event.keyCode >=37 && event.keyCode<=40)) {
	            var inputVal = $(this).val();
	            $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	        }
	    }); 

	
	});

	function fncLoginCheck() {
		var frm = document.loginForm;
		//frm.action = '<c:url value="/common/loginCheck.do" />';
		frm.action = "<c:url value='j_spring_security_check' />";
		frm.submit();
	}

	function fncViewerFileDown() {
		//var shtml = '<OBJECT ID="SellExe" CLASSID="CLSID:7B34D66E-FBED-44BF-9BCA-FBB5143FCC96" CODEBASE="/control/ezPDFReaderS20.cab#VERSION=2,0,2,46">'; 
		//shtml += '</OBJECT>';
		//document.write (shtml);
		window.open("/control/ezPDFReaderS20.exe");
	}	
	
	function onOnlyAlphaNumber(evt) {
		var code = evt.which ? evt.which : event.keyCode;
		alert(code);
		if (!(code >= 37 && code <= 40)) {
			return false;
		}
	}
	
</script>
</head>
<body>
	<form name="loginForm" method="post" action="<c:url value="/j_spring_security_check"/>">
		<div class="wrap">
			<div class="login_box">
				<div class="login_form">
					<div class="box">
						<div class="box_login">
							<ul>
								<li>
									<img src="/images/login/login-kdj/id.png" title="아이디" alt="아이디">
									<input name="j_username" class="input_150" id="id" style="ime-mode: inactive;" type="text" maxlength="50"/>
								</li>
								<li>
									<img src="/images/login/login-kdj/pwd.png" title="패스워드" alt="패스워드">
									<input name="j_password" class="input_150" id="" style="ime-mode: inactive;" type="password" maxlength="50"/>
								</li>
							</ul>
						</div>
						<div class="box_button">
							<input type="image" src="/images/login/login-kdj/btn_login2.gif" width="96" height="58" border="0" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
