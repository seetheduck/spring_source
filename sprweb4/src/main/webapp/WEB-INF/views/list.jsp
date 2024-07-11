<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
배고파~~~ ${msg}<br>
배고파~~~ ${requestScope.msg}<br>
<%
String ss = (String)request.getAttribute("msg");
out.println("배고파~~~" + ss);
%>


</body>
</html>