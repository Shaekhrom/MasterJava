package com.viewnext.main;

import com.viewnext.modelo.Vehiculo; 

import entrada.Teclado;

import java.util.ArrayList;
import java.util.List;

import com.viewnext.modelo.Camion;
import com.viewnext.modelo.Coche;
import com.viewnext.modelo.Moto;
import com.viewnext.modelo.TipoMotorMoto;

/**
 * @author Alejandro Barbacil Castro
 * 
 * Clase main compuesta de un menu en el que el usuario puede "jugar" con los distintos
 * vehiculos, en el menu estan las opciones seleccionar vehiculo, arrancarlo, 
 * avanzar y parar. Cada metodo actuara solo sobre el vehiculo seleccionado
 */
public class Main {

	public static void main(String[] args) {
		
		//variables
		int opcion, opcionvehiculo, metrosAAvanzar;
		
		//instanciamos 
		List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		Vehiculo vehiculoActual = null;
		Vehiculo coche1 = new Coche(1,"Impreza", "Subaru", 200, "azul", "awdawil2");
		Vehiculo coche2 = new Coche(2,"Fiesta", "Ford", 123, "verde", "as3tdfgds");
		Vehiculo coche3 = new Coche(3,"Corsa", "Opel", 73, "negro", "3l532fd");
		Vehiculo moto1 = new Moto(4, "Ninja ZX-6R", "Kawasaki", 100, "Rojo", "123ABC", TipoMotorMoto.DOS_TIEMPOS);
		Vehiculo moto2 = new Moto(5, "CBR600RR", "Honda", 120, "Azul", "456DEF", TipoMotorMoto.CUATRO_TIEMPOS);
		Vehiculo moto3 = new Moto(6, "YZF-R6", "Yamaha", 150, "Verde", "789GHI", TipoMotorMoto.DOS_TIEMPOS);
		Vehiculo moto4 = new Moto(7, "GSX-R600", "Suzuki", 110, "Negro", "101JKL", TipoMotorMoto.CUATRO_TIEMPOS);
		Vehiculo camion1 = new Camion(8, "FH16", "Volvo", 600, "Rojo", "123ABC");
		Vehiculo camion2 = new Camion(9, " R730", "Scania", 650, "Azul", "456DEF");
		Vehiculo camion3 = new Camion(10, "Actros", "Mercedes-Benz", 700, "Verde", "789GHI");
		
		listaVehiculos.add(coche1);
		listaVehiculos.add(coche2);
		listaVehiculos.add(coche3);
		listaVehiculos.add(moto1);
		listaVehiculos.add(moto2);
		listaVehiculos.add(moto3);
		listaVehiculos.add(moto4);		
		listaVehiculos.add(camion1);
		listaVehiculos.add(camion2);
		listaVehiculos.add(camion3);	
		
        do {
        	System.out.println("");
            System.out.println("=== Programita de Alejandro ===");
            System.out.println("1. Arrancar");
            System.out.println("2. Avanzar");
            System.out.println("3. Parar");
            System.out.println("4. Conducir");
            System.out.println("5. Listar y seleccionar vehiculo");
            System.out.println("0. Salir del programa");
            System.out.println("");
            opcion = Teclado.leerEntero("Selecciona una opcion: ");

            switch (opcion) {
                case 1:
                	try {
                	System.out.println(vehiculoActual.arrancar());
                	}catch(Exception e) {
                		System.out.println("Error, elige un vehiculo antes en la opcion 5");
                	}
                    break;
                case 2:
                	try {
                		metrosAAvanzar = Teclado.leerEntero("Metros a avanzar?");
                    	System.out.println(vehiculoActual.avanzar(metrosAAvanzar));
                    	}catch(Exception e) {
                    		System.out.println("Error, elige un vehiculo antes en la opcion 5");
                    	}
                    break;
                case 3:
                	try {
                	System.out.println(vehiculoActual.parar());
                	}catch(Exception e) {
                		System.out.println("Error, elige un vehiculo antes en la opcion 5");
                	}
                    break;
                case 4:
                	try{
                	System.out.println(vehiculoActual.conducir());
		        	}catch(Exception e) {
		        		System.out.println("Error, elige un vehiculo antes en la opcion 5");
		        	}
                	break;
                case 5:
                    boolean vehiculoEncontrado = false;
                    for (Vehiculo vehiculo : listaVehiculos) {
                        System.out.println(vehiculo.toString());
                    }
                    opcionvehiculo = Teclado.leerEntero("Selecciona un vehiculo por id: ");
                    for (Vehiculo vehiculo : listaVehiculos) {
                        if (vehiculo.getId() == opcionvehiculo) {
                            vehiculoActual = vehiculo;
                            vehiculoEncontrado = true;
                            break;
                        }
                    }
                    if (!vehiculoEncontrado) {
                        System.out.println("Error, no se ha encontrado un vehiculo con esa ID");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida, selecciona del 1 al 4.");
            }
        } while (opcion != 0);

    }
}
