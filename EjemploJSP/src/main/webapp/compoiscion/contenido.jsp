<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de ejemplo de include</title>
</head>
<body>

<%@include file="cabecera.jsp" %>
<h1>Titular</h1>
<br>
Este es el contenido de mi pagina<br>
<br>
<%@include file="pie.jsp" %>

</body>
</html>