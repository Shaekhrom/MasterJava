package com.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // leemos la sesion
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        String nombre = usuario.getNombre();
        String apellidos = usuario.getApellidos();
        HashMap<String, String> listaNotas = usuario.getAsignaturaYnota();

        ArrayList<Double> notas = new ArrayList<>();

        double sumaNotas = 0.0;
        for (String asignatura : listaNotas.keySet()) {
            String notaStr = listaNotas.get(asignatura);
            try {
                Double nota = Double.parseDouble(notaStr);
                notas.add(nota);
                sumaNotas += nota;
            } catch (NumberFormatException e) {
                
                e.printStackTrace();
            }
        }

        double media = sumaNotas / notas.size();

        String resultado;
        if (media >= 5.0) {
            resultado = "Aprobado";
        } else {
            resultado = "No aprobado";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Bienvenido: " + nombre + "<br>");
        out.println("Detalles de usuario: " + apellidos + "<br>");

        for (String asignatura : listaNotas.keySet()) {
            String nota = listaNotas.get(asignatura);
            out.println("Asignatura: " + asignatura + ", Nota: " + nota + "<br>");
        }

        out.println("Media de notas: " + media + "<br>");
        out.println("Resultado: " + resultado + "<br>");

        out.println("<form action=\"GestorMatriculas\" method=\"get\">");
        out.println("<input type=\"submit\" value=\"Gestionar matriculas\">");
        out.println("</form>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
