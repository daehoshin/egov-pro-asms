<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script language="javascript">
var msg = "<c:out value='${param.msg}'/>";
if (msg == "logout"){
	location.href = "/welcome.jsp";
}else{
	alert("세션이 종료되었습니다 \n로그인페이지로 이동합니다.");
	
		location.href = "/welcome.jsp";
	
}
	
</script>
</head>
<body>

</body>
</html>