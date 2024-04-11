package main;

import modelo.Flauta;
import modelo.Guitarra;
import modelo.GuitarraElectrica;
import modelo.Tambor;


/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * En esta clase he instanciado todos los objetos para usar sus metodos en forma de orquesta
 * y poder comprobar como va cambiando segun como esta configurado gracias a la herencia.
 * 
 */
public class Orquesta {

	public static void main(String[] args) {
		
		//instanciamos las clases
		Flauta flauta = new Flauta("flautita", "Travesera", "sopranoTurboPower" );
		Guitarra guitarra = new Guitarra("Guitarrona", "madera", 28);
		GuitarraElectrica electrica = new GuitarraElectrica("Chispitas", "electronica", 22, 170); 
		Tambor tambor = new Tambor("tamborcito", "metal", 53);
		
		//metodos de la orquesta
		System.out.println(flauta.tocar());
		System.out.println(electrica.tocar());
		System.out.println(tambor.aporrear());
		System.out.println(guitarra.tocar());
	}

}
