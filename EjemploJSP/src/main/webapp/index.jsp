<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Mi primer ejemplo con JSP</h1>

	<%
	//Esto es un scriplet, si esta entre porcentajes es codigo java

	String saludo = "Hola desde el mundo Java";
	out.println(saludo);
	%>

	<br> Esto esta despues del scriplet
	<br>

	<%
	String texto = "Otra vez en JSP";
	%>
	<ul>
		<li><%=texto%></li>
	</ul>

	<%
	for (int i = 0; i < 10; i++) {
		out.println("<p>" + i + "<p>");
	}
	%>

	<h2>Tambien podria hacer esto</h2>
	<%
	for (int i = 0; i < 10; i++) {
	%>
	<p><%=i%></p>
	<%
	}
	%>


	<%
	for (int i = 1; i < 7; i++) {
	%>

	<h <%=i%>>Bienvenido a mi sitio</h<%=i%>>
	<%
	}
	%>

	<h2>Tablas de multiplicar</h2>

	<%
	for (int i = 1; i <= 10; i++) {
	%>
	<p>Tabla del: <%=i%></p>
	<%
	for (int j = 1; j <= 10; j++) {
	%>
	<%
	out.println("<td>" + i + " x " + j + " = " + (i * j) + "</td>");
	%>
	<br>
	<%
	}
	}
	%>



</body>
</html>