<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="">
		<label for="numero">Selecciona un numero:</label> <select
			name="numero" id="numero">
			<% for (int i = 0; i <= 9; i++) { %>
			<option value="<%= i %>"><%= i %></option>
			<% } %>
		</select> <input type="submit" value="Mostrar">
	</form>

	<% 
    if (request.getMethod().equals("POST")) {
        int numeroSeleccionado = Integer.parseInt(request.getParameter("numero"));
        for (int i = 0; i <= numeroSeleccionado; i++) {
            out.println(i + "<br>");
        }
    }
    %>
</body>
</html>
