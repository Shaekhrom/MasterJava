<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String numtabla = request.getParameter("tabla");
	int tablaSeleccionada = Integer.parseInt(numtabla);
	%>

	<p>
		Tabla del:
		<%=tablaSeleccionada%></p>

	<table border="1">
		<%
		for (int j = 1; j <= 10; j++) {
		%>
		<tr>
			<td><%=tablaSeleccionada%> x <%=j%> = <%=tablaSeleccionada * j%></td>
		</tr>
		<%
		}
		%>
	
</body>
</html>