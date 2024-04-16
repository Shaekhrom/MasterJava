package main;

import modelo.Electrodomestico;
import modelo.Lavadora;
import modelo.Television;

public class Main {
    public static void main(String[] args) {
        // creamos el array
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        //creamos 8 objetos y los metemos al arraylist
        electrodomesticos[0] = new Television(264, true, 300, "negro", 'A', 15); 
        electrodomesticos[1] = new Television(942, false, 400, "rojo", 'B', 20); 
        electrodomesticos[2] = new Lavadora(275, 25); 
        electrodomesticos[3] = new Lavadora(345, 234, "azul", 'C', 30); 
        electrodomesticos[4] = new Television(235, true, 500, "blanco", 'E', 35); 
        electrodomesticos[5] = new Lavadora(8563, 643, "negro", 'F', 40); 
        electrodomesticos[6] = new Television(23516, false, 6020, "rojo", 'A', 50); 
        electrodomesticos[7] = new Lavadora(23425, 55); 
        electrodomesticos[8] = new Lavadora(8563, 643, "negro", 'F', 40);
        electrodomesticos[9] = new Lavadora(235, 914, "blanco", 'B', 40);

        // ponemos precios iniciales
        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisiones = 0;

        // recorremos el array para calcular precios
        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavadora) {
                precioTotalLavadoras += electrodomestico.precioFinal();
            } else if (electrodomestico instanceof Television) {
                precioTotalTelevisiones += electrodomestico.precioFinal();
            }
            precioTotalElectrodomesticos += electrodomestico.precioFinal();
        }

        // mostrar precios
        System.out.println("Precio total de Electrodomesticos: " + precioTotalElectrodomesticos);
        System.out.println("Precio total de Lavadoras: " + precioTotalLavadoras);
        System.out.println("Precio total de Televisiones: " + precioTotalTelevisiones);
    }
}

