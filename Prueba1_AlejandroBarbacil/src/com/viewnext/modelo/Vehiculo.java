package com.viewnext.modelo;

import java.time.Duration;
import java.time.LocalTime;

import com.viewnext.interfaces.Conducible;

/**
 * @author Alejandro Barbacil Castro
 * Clase abstracta vehiculo que proporciona metodos y atributos 
 * comunes para los vehiculos ademas de implementar la interfaz conducible.
 */

public abstract class Vehiculo implements Conducible {

	// instancias de clases
	LocalTime horaActual = LocalTime.now();
	
	//constantes
	private final String  matricula;

	// atributos
	private int id;
	private String modelo;
	private String marca;
	private int caballosDePotencia;
	private int numRuedas;
	boolean arrancado = false;
	private String color;
	int metrosTotales;
	LocalTime horaInicioViaje;
	LocalTime tiempoFin;
	int tiempoViaje;
	int minutoViaje;
	int segundosViaje;
	double velocidad;

	// constructor
	public Vehiculo(int id, String modelo, String marca, int caballosDePotencia, String color, String matricula) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.caballosDePotencia = caballosDePotencia;
		this.matricula = matricula;
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCaballosDePotencia() {
		return caballosDePotencia;
	}

	public void setCaballosDePotencia(int caballosDePotencia) {
		this.caballosDePotencia = caballosDePotencia;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public String getVelocidad() {
		return "Velocidad actual: " + calcularVelocidadActual() + " km/h";
	}

	// toString
	@Override
	public String toString() {
		return "Vehiculo [id " + id + " modelo=" + modelo + ", marca=" + marca + ", caballosDePotencia="
				+ caballosDePotencia + ", numRuedas=" + numRuedas + "]";
	}

	// metodos
	/**
	 * Metodo que marca el vehiculo como arrancado con un booleano, establece la
	 * hora de arranque y devuelve el string y la hora del arranque
	 * 
	 */
	@Override
	public String arrancar() {
		if (arrancado == true) {
			return "Error, el vehiculo ya ha sido arrancado";
		}
		arrancado = true;
		horaInicioViaje = horaActual;
		return "Vehiculo arrancado a las " + horaInicioViaje.getHour() + " horas, " + horaInicioViaje.getMinute()
				+ " minutos y " + horaInicioViaje.getSecond() + " segundos";
	}

	/**
	 * Metodo que primero comprueba si esta arrancado, si no lo esta muestra el
	 * mensaje correspondiente, si lo esta hace calculos varios para poder mostrar
	 * los metros avanzados, totales y el tiempo transcurrido
	 * 
	 */
	@Override
	public String avanzar(int numMetrosAvanzados) {
		if (arrancado != true) {
			return "El vehiculo no puede avanzar porque no a arrancado aun";
		} else {
			horaActual = LocalTime.now();
			metrosTotales += numMetrosAvanzados;

			return "Avanzo " + numMetrosAvanzados + " metros, Metros totales: (" + metrosTotales
					+ "), Tiempo actual de viaje: " + calcularDiferenciaHoras(horaActual, horaInicioViaje) + " "
					+ getVelocidad();
		}
	}

	/**
	 * Metodo que comprueba si el vehiculo esta arrancado, si no lo esta muestra el
	 * mensaje correspondiente, si lo esta calcula el tiempo total del viaje y lo
	 * devuelve como String
	 */
	@Override
	public String parar() {
		if (arrancado != true) {
			return "El vehiculo ya esta parado porque no ha arrancado todavia";
		} else {
			horaActual = LocalTime.now();
			tiempoViaje = horaActual.getHour() - horaInicioViaje.getHour();
			minutoViaje = horaActual.getMinute() - horaActual.getMinute();
			segundosViaje = horaActual.getSecond();

			return "Vehiculo parado, Tiempo final: " + calcularDiferenciaHoras(horaActual, horaInicioViaje);
		}
	}

	/**
	 * Calcula la diferencia entre las dos horas pasadas por parametros
	 * 
	 * @param hora1
	 * @param hora2
	 * 
	 */
	public static String calcularDiferenciaHoras(LocalTime hora1, LocalTime hora2) {
		Duration diff = Duration.between(hora2, hora1);
		long horas = diff.toHours();
		long minutos = diff.toMinutes() % 60;
		long segundos = diff.getSeconds() % 60;

		return "" + horas + " horas, " + minutos + " minutos y " + segundos + " segundos.";
	}

	/**
	 * Metodo que calcula la velocidad en km/h, obtiene el tiempo actual, calcula la
	 * diferencia de tiempo desde el inicio del viaje hasta ahora, pasa el tiempo a
	 * segundos, divide los metros totales entre los segundos pasados y lo convierte
	 * a kilometros por hora, entonces lo devuelve como double
	 * 
	 */
	public double calcularVelocidadActual() {
	    LocalTime horaActual = LocalTime.now();
	    Duration duracion = Duration.between(horaInicioViaje, horaActual);

	    long segundosTranscurridos = duracion.getSeconds();
	    double velocidadMetrosPorSegundo = (double) metrosTotales / segundosTranscurridos;
	    double velocidadKilometrosPorHora = velocidadMetrosPorSegundo * 3.6;

	    velocidadKilometrosPorHora = Math.round(velocidadKilometrosPorHora * 100.0) / 100.0;

	    return velocidadKilometrosPorHora;
	}


}