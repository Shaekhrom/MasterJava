package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.modelo.Usuario;

/**
 * Servlet implementation class RegistrarDatos
 */
public class RegistrarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Obtener los parámetros enviados por el usuario
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("detalles");
	        String email = request.getParameter("contrasena");
	        
	        // Crear un objeto Usuario con los datos recibidos
	        Usuario usuario = new Usuario(nombre, apellido, email);
	        
	        // Obtener la sesión o crear una nueva si no existe
	        HttpSession sesion = request.getSession(true);
	        sesion.setMaxInactiveInterval(120);

	        // Guardar el objeto Usuario en la sesión
	        sesion.setAttribute("usuario", usuario);
	        
	        // Redirigir a otra página, por ejemplo, una página de confirmación
	        String mensaje = "Registrado con éxito, ya puedes volver e iniciar sesion";
	        response.setContentType("text/html");
	        response.getWriter().println("<script type=\"text/javascript\">");
	        response.getWriter().println("alert('" + mensaje + "');");
	        response.getWriter().println("window.location.href='index.html';");
	        response.getWriter().println("</script>"); 
	    }

}
