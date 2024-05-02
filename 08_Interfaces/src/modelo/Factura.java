package modelo;

import interfaces.Imprimible;

public class Factura implements Imprimible {
	private int nFactura;
	private int codigoCliente;
	
	
	//constructor
	public Factura(int nFactura, int codigoCliente) {
		super();
		this.nFactura = nFactura;
		this.codigoCliente = codigoCliente;
	}
	
	
	//getters y setters
	public int getnFactura() {
		return nFactura;
	}


	public void setnFactura(int nFactura) {
		this.nFactura = nFactura;
	}


	public int getCodigoCliente() {
		return codigoCliente;
	}


	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	//toString
	@Override
	public String toString() {
		return "Factura [nFactura=" + nFactura + ", codigoCliente=" + codigoCliente + "]";
	}

	
	//metodos interfaz
	@Override
	public String informeLargo() {
		return "Numero de factura: " + getnFactura() + " Codigo del cliente: " + getCodigoCliente();
	}
	
	@Override
	public int informeCorto() {
		return getnFactura();
	}
	
	
}
