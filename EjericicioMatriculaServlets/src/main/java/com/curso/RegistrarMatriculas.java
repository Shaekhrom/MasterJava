package com.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrarMatriculas
 */
public class RegistrarMatriculas extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombreMatricula = request.getParameter("nombreMatricula");
	    HttpSession sesion = request.getSession(true);
	    sesion.setMaxInactiveInterval(120);
	    Usuario usuario = (Usuario) sesion.getAttribute("usuario");

	    ArrayList<String> matriculas = usuario.getMatriculas();
	    matriculas.add(nombreMatricula);
	    usuario.setMatriculas(matriculas);
	    sesion.setAttribute("usuario", usuario);

	    String mensaje = "Matricula añadida satisfactoriamente";

	 
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	   
        out.println("<html><body>");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + mensaje + "');");
        out.println("window.location.href = 'GestorMatriculas';"); 
        out.println("</script>");
        out.println("</body></html>");
    }
}
