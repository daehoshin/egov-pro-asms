<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script language="javascript">
var msg = "<c:out value='${param.msg}'/>";
if (msg == "logout"){
	location.href = "/welcome.jsp";
} else {
	alert("세션이 종료되었습니다 \n로그인페이지로 이동합니다.");
	location.href = "/welcome.jsp";
}
</script>
</head>
<body>
</body>
</html>