package modelo;

public class Cafetera {
	
	//atributos
	private static double capacidadMaxima;
	private static double cantidadActual;
	
	
	//constructores
	
	//predeterminado capMax 1000c.c, actual cero
	public Cafetera() {
		super();
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
	}
	
	//cantidad actual de cafe igual a la capacidad maxima
	public Cafetera(double capacidadMaxima) {
		super();
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = capacidadMaxima;
	}
	
	//si cantActual > capMax la ajustara al maximo
		public Cafetera(double capacidadMaxima, double cantidadActual) {
			super();
			this.capacidadMaxima = capacidadMaxima;
			
			if(cantidadActual > capacidadMaxima) {
				this.cantidadActual = capacidadMaxima;

			}
			this.cantidadActual = cantidadActual;
		}
		
		
		//getters y setters
		public static double getCapacidadMaxima() {
			return capacidadMaxima;
		}

		public static void setCapacidadMaxima(double capacidadMaxima) {
			Cafetera.capacidadMaxima = capacidadMaxima;
		}

		public static double getCantidadActual() {
			return cantidadActual;
		}

		public static void setCantidadActual(double cantidadActual) {
			Cafetera.cantidadActual = cantidadActual;
		}
	
		
		
		//comprueba si se ha llenado correctamente
		public static boolean llenarCafetera() {
			setCantidadActual(getCapacidadMaxima());
			
			if (getCapacidadMaxima() == getCantidadActual()) {
				return true; // si se llena correctamente
			}else {
				return false; //si hay un error al llenar
			}
		}
		
		//quita x cantidad de cafe de la cafetera
		public static boolean servirTaza(int cantidadAServir) {
			if(cantidadAServir > getCantidadActual()) {
				setCantidadActual(0);
				return false; //false si cantidad a servir no llega
			}else {
				setCantidadActual(getCantidadActual() - cantidadAServir);
				return true; //true si puede servir todo
			}
		}
		
		
		//capacidad actual de cafe a 0
		public static boolean vaciarCafetera() {
			setCantidadActual(0);
			if(getCantidadActual() == 0) {
				return true;
			}else {
				return false;
			}
		}
		
		
		//añade cafe a la cafetera
		public static boolean agregarCafe(int cantidadAgregada) {
			double cantidadTest = 0;
			
			cantidadTest = (getCantidadActual() + cantidadAgregada);
			
			if(cantidadTest > getCapacidadMaxima()) {
				setCantidadActual(getCapacidadMaxima());
				return false; //no se ha podido agregar todo
			}else {
				setCantidadActual(cantidadTest);
				return true; //agregado con exito
			}
		}
	
	
}
