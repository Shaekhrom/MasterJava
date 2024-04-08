package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import modelo.Jugador;
import modelo.Partido;
import modelo.Equipo;

public class ProgramaPrincipal {
	
	//Creado por Alejandro Barbacil Castro

	public static void main(String[] args) {
		//declaracion de variables
		Scanner scanner = new Scanner(System.in);
        int opcion;
        
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        
        ArrayList<Jugador> listaJugadores1 = new ArrayList<>();
        ArrayList<Jugador> listaJugadores2 = new ArrayList<>();
        ArrayList<Jugador> listaJugadores3 = new ArrayList<>();
        
        Equipo equipo1 = null;
        Equipo equipo2 = null;
        Equipo equipo3 = null;
        
        Partido partido1 = null;
        Partido partido2 = null;
        Partido partido3 = null;
        
      //declaracion de variables
        
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1.Listar a los jugadores de cada equipo ordenados por goles.");
            System.out.println("2.Lista de partidos (con resultados).");
            System.out.println("3.Lista de equipos (ordenados por partidos ganados).");
            System.out.println("4.Añadir datos de ejemplo");
            System.out.println("0. Salir");

            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {           
                case 1:
                	//comprobamos si la lista de equipos esta vacia, si no lo esta iteramos sobre ella
                	if(listaEquipos.isEmpty()) {
                		System.out.println("Error la lista de equipos esta vacia, pulsa 4 para cargar datos");
                		break;
                	}
                	for (Equipo equipo : listaEquipos) {
                        System.out.println(equipo);
                    }
                    break;
                case 2:
                	//comprobamos si la lista de equipos esta vacia, si no lo esta iteramos sobre ella
                	if(listaPartidos.isEmpty()) {
                		System.out.println("Error la lista de partidos esta vacia, pulsa 4 para cargar datos");
                		break;
                	}
                	for (Partido partido : listaPartidos) {
                        System.out.println(partido);
                    }
                    break;
                case 3:
                	//comprobamos si la lista de equipos esta vacia, si no lo esta iteramos sobre ella
                	if(listaEquipos.isEmpty()) {
                		System.out.println("Error la lista de equipos esta vacia, pulsa 4 para cargar datos");
                		break;
                	}
                	for (Equipo equipo : listaEquipos) {
                        System.out.println("Equipo: " + equipo.getNombre() + "Partidos ganados: " + equipo.getPartidosGanados());
                    }
                    break;
                case 4:
                	//Datos Equipo1
                	String nombreEquipo1 = "Paris Saint-Germain";
                	Jugador jugador1 = new Jugador(1, "Lionel Messi", 700, "Paris Saint-Germain");
                    Jugador jugador2 = new Jugador(2, "Cristiano Ronaldo", 800, "Paris Saint-Germain");
                    Jugador jugador3 = new Jugador(3, "Neymar Jr.", 400, "Paris Saint-Germain");              
                    listaJugadores1.add(jugador1);
                    listaJugadores1.add(jugador2);
                    listaJugadores1.add(jugador3);
                    Collections.sort(listaJugadores1, Comparator.comparingInt(Jugador::getGolesMarcados).reversed());                   
                	equipo1 = new Equipo(nombreEquipo1,listaJugadores1, 7 );
                	
                	//Datos equipo2
                	String nombreEquipo2 = "Liverpool";
                	Jugador jugador4 = new Jugador(4, "Robert Lewandowski", 650, "Liverpool");
                    Jugador jugador5 = new Jugador(5, "Kylian Mbappé", 200, "Liverpool");
                    Jugador jugador6 = new Jugador(6, "Mohamed Salah", 300, "Liverpool");
                    listaJugadores2.add(jugador4);
                    listaJugadores2.add(jugador5);
                    listaJugadores2.add(jugador6);
                    Collections.sort(listaJugadores2, Comparator.comparingInt(Jugador::getGolesMarcados).reversed());                   
                    equipo2 = new Equipo(nombreEquipo2,listaJugadores2, 15 );
                    
                    
                    //Datos equipo3
                    String nombreEquipo3 = "Manchester City";
                    Jugador jugador7 = new Jugador(7, "Kevin De Bruyne", 150, "Manchester City");
                    Jugador jugador8 = new Jugador(8, "Sergio Ramos", 50, "Manchester City");
                    Jugador jugador9 = new Jugador(9, "Harry Kane", 400, "Manchester City");
                    listaJugadores3.add(jugador7);
                    listaJugadores3.add(jugador8);
                    listaJugadores3.add(jugador9);
                    Collections.sort(listaJugadores3, Comparator.comparingInt(Jugador::getGolesMarcados).reversed());                   
                    equipo3 = new Equipo(nombreEquipo3,listaJugadores3, 3);
                    
                    
                    //añadimos para iterar después
                    listaEquipos.add(equipo1);
                    listaEquipos.add(equipo2);
                    listaEquipos.add(equipo3);
                    
                    
                    //datos para el case2
                    partido1 = new Partido(equipo1, equipo2, "0 - 1");
                    partido2 = new Partido(equipo3, equipo1, "4 - 2");
                    partido3 = new Partido(equipo2, equipo3, "2 - 3");
                    
                    listaPartidos.add(partido1);
                    listaPartidos.add(partido2);
                    listaPartidos.add(partido3);
                    
                    
                    
                    //ordenamos para el case3
                    Collections.sort(listaEquipos, Comparator.comparingInt(Equipo::getPartidosGanados).reversed());                   

                	
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0); 
        scanner.close(); 
    }
}