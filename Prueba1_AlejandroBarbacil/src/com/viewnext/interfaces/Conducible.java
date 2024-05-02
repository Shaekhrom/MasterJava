package com.viewnext.interfaces;
/**
 * @author Alejandro barbacil castro
 * Interfaz que se usa para implementar los metodos arrancar avanzar
 * y parar en la clase abstracta vehiculo
 */
public interface Conducible {
	   
   //metodos
	String arrancar();
	
	String avanzar(int numMetrosAvanzados);
	
	String parar();
	
	String conducir();
}
