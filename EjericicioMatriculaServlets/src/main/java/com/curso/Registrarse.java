package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import com.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Registrarse extends HttpServlet {
    private static final long serialVersionUID = 1L;

       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        // Configuración del tipo de contenido de la respuesta
        response.setContentType("text/html");
        
        // Crear un objeto PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();
        
        // Generar el HTML del formulario
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Formulario</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Formulario de Registro</h2>");
        
        out.println("<form action=\"RegistrarDatos\" method=\"post\">");
        out.println("Nombre: <input type=\"text\" name=\"nombre\"><br>");        
        out.println("Detalles: <input type=\"text\" name=\"detalles\"><br>");
        out.println("Contrasena: <input type=\"password\" name=\"contrasena\"><br>");
        out.println("<input type=\"submit\" value=\"Registrar\">");
        out.println("</form>");
        
        out.println("<br>");
        out.println("<form action=\"index.html\" method=\"get\">");
        out.println("<input type=\"submit\" value=\"Volver\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
