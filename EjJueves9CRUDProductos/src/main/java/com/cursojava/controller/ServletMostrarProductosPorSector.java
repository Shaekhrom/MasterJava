package com.cursojava.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cursojava.model.Producto;
import com.cursojava.service.TiendaService;


public class ServletMostrarProductosPorSector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sector = request.getParameter("sector");

        TiendaService tiendaService = new TiendaService();
        List<Producto> productosPorSector = tiendaService.listaProductosPorSeccion(sector);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Productos por Sector</title></head><body>");
        out.println("<h2>Productos del sector: " + sector + "</h2>");
        out.println("<ul>");
        for (Producto producto : productosPorSector) {
            out.println("<li>" + "Nombre: " + producto.getNombre() + "  || Precio: " + producto.getPrecio()+ "  || Stock: " + producto.getStock() + "</li>");
        }
        out.println("</ul>");
        out.println("<button class=\"boton\" onclick=\"window.location.href='Buscar.html'\">Volver</button>");
        out.println("</body></html>");
    }

}
