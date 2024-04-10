package main;

import entrada.Teclado;
import modelo.Cafetera;

public class Main {

	//creado por Alejandro Barbacil Castro
	public static void main(String[] args) {
		int opcion;
		double dinero;
		Cafetera cafetera = new Cafetera();

		do {
			System.out.println("---Seleccione una opcion:---");
			System.out.println("1.Llenar cafetera.");
			System.out.println("2.Servir taza.");
			System.out.println("3.Vaciar cafetera");
			System.out.println("4.Agregar Cafe");
			System.out.println("0. Salir");

			opcion = Teclado.leerEntero("Escoge una opcion");

			switch (opcion) {
			case 1:
				if (Cafetera.llenarCafetera()) {
					System.out.println("Cafetera llenada con exito con :" + Cafetera.getCantidadActual());
				}
				break;
			case 2:
				int cantidadAServir = Teclado.leerEntero("Cantidad a servir?");
				if (Cafetera.servirTaza(cantidadAServir)) {
					System.out.println("Taza servida con exito, cantidad restante: " + Cafetera.getCantidadActual() );
				}else {
					System.out.println("Error al servir todo, se ha servido lo que quedaba");
				}
				break;
			case 3:
				if (Cafetera.vaciarCafetera()) {
					System.out.println("Vaciada con exito");
				}else {
					System.out.println("Error al vaciar");
				}
				break;
			case 4:
				int cantidadAgregada = Teclado.leerEntero("Cantidad a agregar?");
				if (Cafetera.agregarCafe(cantidadAgregada)) {
					System.out.println("Cafe agregado con exito, cantidad actual: " + Cafetera.getCantidadActual() );
				}else {
					System.out.println("Error al agregar todo, se ha agregado hasta llenarla");
				}
				break;
			}
		} while (opcion != 0);

		System.out.println("Saliendo del programa...");

	}

}
