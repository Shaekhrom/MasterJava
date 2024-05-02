package main;

import modelo.Factura;
import modelo.Pagina;

public class GestionDeImpresion {

	public static void main(String[] args) {

		Pagina pagina = new Pagina(50,20);
		
		Factura factura = new Factura (235, 3983);
		
		System.out.println("");
		System.out.println("---Informe de paginas---");
		System.out.println("Numero de paginas: " + pagina.informeCorto());
		System.out.println(pagina.informeLargo());
		System.out.println("");
		
		System.out.println("---Informe de facturas---");
		System.out.println("Numero de factura: " + factura.informeCorto());
		System.out.println(factura.informeLargo());
	}

}
