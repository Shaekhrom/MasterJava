package com.cursojava.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cursojava.model.Producto;
import com.cursojava.service.TiendaService;

/**
 * Servlet implementation class ServletModificarProducto
 */
public class ServletModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreProducto = request.getParameter("nombre");
        String nuevoNombre = request.getParameter("nuevoNombre");
        String sector = request.getParameter("sector");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto productoModificado = new Producto(nuevoNombre, sector, precio, stock);

        TiendaService tiendaService = new TiendaService();
        boolean modificado = tiendaService.modificarProducto(nombreProducto, productoModificado);

        if (modificado) {
        	String mensaje = "Producto modificado con éxito.";

    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><title>Respuesta</title></head><body>");
    		out.println("<script type=\"text/javascript\">");
    		out.println("alert('" + mensaje + "');");
    		out.println("window.location = 'index.html';"); 
    		out.println("</script>");
    		out.println("</body></html>");
        } else {
        	String mensaje = "Error al modificar el producto o no encontrado.";

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
