package modelo;

public class Cuenta {

	//Atributos
	private String titular;
	//lo ponemos estatico para que sea igual para todos los objetos
	private static double cantidad;
	
	
	//sobrecarga de constructores
	public Cuenta(String titular, double cantidad) {
		super();
		this.titular = titular;
		Cuenta.cantidad = cantidad;
	}
	
	
	//getters y setters
	public Cuenta(String titular) {
		super();
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public static double getCantidad() {
		return cantidad;
	}

	public static void setCantidad(double cantidad) {
		Cuenta.cantidad = cantidad;
	}
	
	
	//metodos especiales
	
	//ingresa dinero en la cuenta sumando cantidad actual y cantidad a añadir
	public static boolean ingresar(double cantidad) {
		if(cantidad < 1) {
			return false;
		}
		setCantidad(getCantidad() + cantidad);
		return true;
	}
	
	//retira cantidad solicitada
	public static boolean retirar(double cantidad) {
		double cantidadFinal;
		
		if(cantidad < 1) {			
			
			return false;
		}
		
		cantidadFinal = (getCantidad() - cantidad);
		if(cantidadFinal < 1) {
			return false;
		}
		
		setCantidad(cantidadFinal);
		
		return true;
	}
}


