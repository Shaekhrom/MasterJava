package com.cursojava.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class ServletEliminarProducto
 */
public class ServletEliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreProducto = request.getParameter("nombre");

        TiendaService tiendaService = new TiendaService();
        boolean eliminado = tiendaService.borrarProductoPorNombre(nombreProducto);

        if (eliminado) {
        	String mensaje = "Producto eliminado con éxito.";

    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><title>Respuesta</title></head><body>");
    		out.println("<script type=\"text/javascript\">");
    		out.println("alert('" + mensaje + "');");
    		out.println("window.location = 'index.html';"); 
    		out.println("</script>");
    		out.println("</body></html>");
        } else {
        	String mensaje = "Error al eliminar el producto o no encontrado.";

    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><title>Respuesta</title></head><body>");
    		out.println("<script type=\"text/javascript\">");
    		out.println("alert('" + mensaje + "');");
    		out.println("window.location = 'index.html';"); 
    		out.println("</script>");
    		out.println("</body></html>");
        }
    }

}
