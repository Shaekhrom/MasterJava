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
 * Servlet implementation class ServletInsertarProducto
 */
public class ServletInsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String sector = request.getParameter("sector");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto nuevoProducto = new Producto(nombre, sector, precio, stock);

		TiendaService tiendaService = new TiendaService();
		tiendaService.agregarProducto(nuevoProducto);
		String mensaje = "Producto " + nombre + " agregado con éxito.";

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
