package main;

import entrada.Teclado;
import modelo.Cuenta;

public class Main {

	//Creado por Alejandro Barbacil Castro
	public static void main(String[] args) {
		
		int opcion;
		double dinero;

		do {
			System.out.println("---Seleccione una opcion:---");
			System.out.println("1.Ingresar dinero en cuenta.");
			System.out.println("2.Retirar dinero en cuenta.");
			System.out.println("3.Mostrar dinero en cuenta");
			System.out.println("0. Salir");

			opcion = Teclado.leerEntero("Escoge una opcion");

			switch (opcion) {
			case 1:
				
				dinero = Teclado.leerReal("Cantidad a ingresar?");
				
				if(Cuenta.ingresar(dinero)) {
					System.out.println("Ingresado con exito en la cuenta");
				}else {
					System.out.println("Error al insertar");
				}
				break;
			case 2:
				dinero = Teclado.leerReal("Cantidad a retirar?");
				
				if(Cuenta.retirar(dinero)) {
					System.out.println("Retirado con exito en la cuenta");
				}else {
					System.out.println("Error al retirar");
				}
				break;
			//usamos atributo estatico de Cuenta sin instanciar ningun objeto	
			case 3:
				System.out.println("Dinero actual: " + Cuenta.getCantidad());
				break;
			}
		} while (opcion != 0);

		System.out.println("Saliendo del programa...");
	}
}
