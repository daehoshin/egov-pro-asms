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
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Login</title>
	
	<script src="/bootstrap-theme/js/jquery-2.1.1.js"></script>
	<script src="/bootstrap-theme/js/bootstrap.min.js"></script>
	
    <link href="/bootstrap-theme/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap-theme/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="/bootstrap-theme/css/animate.css" rel="stylesheet">
    <link href="/bootstrap-theme/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">IN+</h1>

            </div>
            <h3>Welcome to ASMS</h3>
            <p>본 시스템은 자산관리 시스템으로써 여러분의 소중한 자산을 관리 해 드립니다.
            </p>
            <form name="loginForm" method="post" action="<c:url value="/j_spring_security_check"/>">
                <div class="form-group">
                    <input type="text" class="form-control" id="j_username" name="j_username" placeholder="Username" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="j_password" name="j_password" placeholder="Password" required="required">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
S
                <a class="btn btn-sm btn-white btn-block" href="register.html">Forgot password?</a>
            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
        </div>
    </div>

</body>

</html>
	<%-- <form name="loginForm" method="post" action="<c:url value="/j_spring_security_check"/>">
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
</html> --%>

<script type="text/javascript">

	$(document).ready(function() {
		$("#j_username").focus();
		var loginResult = "<c:out value='${param.result}' />";
		
		if (loginResult == "false") {
			alert("사용자 아이디가 없거나 비밀번호가 일치하지 않습니다.");
		}

		if (opener) {
			alert("세션이 종료되었습니다.");
			self.close();
		}
		
		 $("#j_username").keyup(function(event){
	        if (!(event.keyCode >=37 && event.keyCode<=40)) {
	            var inputVal = $(this).val();
	            $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	        }
	    }); 

	
	});

	function fncLoginCheck() {
		var frm = document.loginForm;
		frm.action = "<c:url value='j_spring_security_check' />";
		frm.submit();
	}

	function onOnlyAlphaNumber(evt) {
		var code = evt.which ? evt.which : event.keyCode;
		alert(code);
		if (!(code >= 37 && code <= 40)) {
			return false;
		}
	}
	
</script>
