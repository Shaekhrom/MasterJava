package main;

import java.util.ArrayList; 
import java.util.List;

import modelo.Flauta;
import modelo.Guitarra;
import modelo.GuitarraElectrica;
import modelo.Instrumento;
import modelo.Tambor;

/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 *         En esta clase he instanciado todos los objetos para usar el metodo
 *         de la interfaz, gracias a instanceOf puedo ir jugando con los metodos
 *         e iterar en un arraylist de objetos.
 * 
 */
public class Orquesta {

	public static void main(String[] args) {

		// instanciamos las clases

		Instrumento flauta = new Flauta("flautita", "Travesera", "sopranoTurboPower");
		Instrumento guitarra = new Guitarra("Guitarrona", "madera", 28);
		Instrumento electrica = new GuitarraElectrica("Chispitas", "electronica", 22, 170);
		Instrumento tambor = new Tambor("tamborcito", "metal", 53);

		// creamos lista y añadimos
		List<Instrumento> instrumentos = new ArrayList<>();
		instrumentos.add(flauta);
		instrumentos.add(guitarra);
		instrumentos.add(electrica);
		instrumentos.add(tambor);

		/**
		 * Iteramos en el arraylist, si es de clase tambor el objeto usara 
		 * el metodo aporrear
		 */
		for (Instrumento instrumento : instrumentos) {
			if (instrumento instanceof Tambor) {
				System.out.println(((Tambor) instrumento).aporrear());
			} else {
				System.out.println(instrumento.tocar());
			}
		}

	}

}
