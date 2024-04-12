package com.viewnext.main;

import java.util.ArrayList; 
import java.util.List;

import com.viewnext.interfaz.Mascota;
import com.viewnext.modelo.Animal;
import com.viewnext.modelo.Araña;
import com.viewnext.modelo.Gato;
import com.viewnext.modelo.Pez;
/**
 * @author Alejandro barbacil castro
 * Esta clase contiene el método principal (main) que sirve como punto de entrada del programa. 
 * El programa crea instancias de diferentes tipos de animales y las agrega a una lista.
 * Luego, recorre la lista y realiza algunas operaciones dependiendo del tipo de animal.
 */

public class Main {

	public static void main(String[] args) {
		Animal araña = new Araña(8);
		Animal gato = new Gato(4, "Manuelin");
		Animal pez = new Pez(0, "Bizcochito");

		List<Animal> listaAnimales = new ArrayList<>();

		listaAnimales.add(araña);
		listaAnimales.add(gato);
		listaAnimales.add(pez);
		
		for (Animal animal : listaAnimales) {
			if (animal instanceof Mascota) {
		        if (animal instanceof Pez) {
		            System.out.println(((Pez) animal).jugar());
		            System.out.println(((Pez) animal).andar());
		        } else if (animal instanceof Gato) {
		            System.out.println(((Gato) animal).jugar());
		        }
		    } 
		      System.out.println(animal.comer());
		    
		}

	}
}
