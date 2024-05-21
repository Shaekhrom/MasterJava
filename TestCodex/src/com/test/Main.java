package com.test;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MiListaSecuencial<String> lista = new MiListaSecuencial<>();
        
        // Agregar elementos a la lista
        lista.add("Uno");
        lista.add("Tres");
        
        // Insertar un elemento en una posición específica
        lista.add(1, "Dos");
        
        // Mostrar los elementos de la lista después de realizar las operaciones
        System.out.println("Elementos de la lista antes de modificar 'Tres':");
        for (String s : lista) {
            System.out.println(s);
        }
        
        // Modificar un elemento existente
        lista.set(2, "Cuatro");
        
        // Mostrar los elementos de la lista después de realizar las operaciones
        System.out.println("\nElementos de la lista al modificar 'Tres':");
        for (String s : lista) {
            System.out.println(s);
        }
        
        // Eliminar un elemento de la lista
        lista.remove(2); // Eliminar "Cuatro"
        
        // Mostrar los elementos de la lista después de eliminar "Tres"
        System.out.println("\nElementos de la lista después de eliminar 'cuatro':");
        for (String s : lista) {
            System.out.println(s);
        }
    }
}
