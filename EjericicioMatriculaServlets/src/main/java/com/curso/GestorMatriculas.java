package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GestorMatriculas
 */
public class GestorMatriculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Configuración del tipo de contenido de la respuesta
	    response.setContentType("text/html");
	    
	    // Crear un objeto PrintWriter para escribir la respuesta
	    PrintWriter out = response.getWriter();
	    
	    // Generar el HTML del formulario
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<title>Gestor</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h2>Gestion de matriculas</h2>");
	    
	    out.println("<form action=\"RegistrarMatriculas\" method=\"post\">");
	    out.println("Registrar nueva matricula: <input type=\"text\" name=\"nombreMatricula\"><br>");        
	    out.println("<input type=\"submit\" value=\"Registrar\">");
	    out.println("</form>");
	    
	    out.println("<br>");
	    out.println("<form action=\"Servlet2\" method=\"get\">");
	    out.println("<input type=\"submit\" value=\"Volver\">");
	    out.println("</form>");
	    out.println("</body>");
	    out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}


}
