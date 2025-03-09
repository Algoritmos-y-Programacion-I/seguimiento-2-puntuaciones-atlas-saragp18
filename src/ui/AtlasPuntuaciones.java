// Análisis:Eventos Atlas decidio expandir su neocio y ahora tambien tiene torneos de videojuegos, en cada ronda podran
//participar maximo 10 jugadores y maximo 5 rondas, ellos necesitan ayuda con el registro de puntaje de cada ronda
//y el puntaje mayor 
// Descripción del programa:
//Registrar puntajes:
// El programa debe permitir ingresar la cantidad de jugadores y la cantidad de rondas jugadas.
//Luego se pide el puntaje de cada jugador en cada ronda. 
// El puntaje de cada ronda es un número entero entre 0 y 100.

// Calcular estdísticas:
// Para cada uno de los jugadores se debe calcular su puntaje total (la suma de sus puntajes en todas las rondas).
// Identificar y mostrar el jugador con la puntuación total más alta. Si hay empate, mostrar a cualquiera de los ganadores.
// Determinar el puntaje promedio de cada jugador en el torneo.
 
//Mostrar resultados: 
// Listar el puntaje total y promedio de cada jugador.
//Mostrar el nombre del jugador con la mayor puntuación total.
// Entradas:
//La cantidad de jugadores debe ser entre 1 y 10 , la cantidad de rondas debe ser entre 1 y 5 y los puntajes de cada 
//jugador en cada ronda.
// Salidas:La cantidad de jugadores y rondas ingresadas. Luego, se muestran los puntajes registrados en cada ronda. 
// Al final, el programa imprime el puntaje total de cada jugador y sus promedios, y dice quién tuvo el resultado más alto.
// Ejemplo:
//# Ingrese el número de jugadores  
// > 2 
// # Ingrese el número de rondas  
// > 3 
// # Ingrese el puntaje del jugador 1 en la ronda 1:  
// > 20
// # Ingrese el puntaje del jugador 1 en la ronda 2:  
// > 20   
// # Ingrese el puntaje del jugador 2 en la ronda 1:  
// > 12  
//7 # Ingrese el puntaje del jugador 2 en la ronda 2:  
// > 24
// # Resultados del torneo:  
// # El puntaje total del jugador 1 es: 40, Promedio: 20
// # El puntaje total del jugador 2 es: 36, Promedio: 18  
// # El jugador con la puntuación más alta es Jugador 1 con 40 puntos
//


package ui; 

import java.util.Scanner; 

public class AtlasPuntuaciones {

  static Scanner escaner = new Scanner(System.in);
	
	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	
	public void run()
	{

	System.out.println("Ingrese la cantidad de jugadores que desean participar: ");
        int cant_Jugadores = escaner.nextInt();
        verificacion_Jugadores(cant_Jugadores);
        System.out.println("Ingrese la cantidad de rondas que desea jugar: ");
        int cantRondas = escaner.nextInt();
        verificacion_Rondas(cantRondas);
        int [] jugadores = jugadores(cant_Jugadores);
        jugadores = puntajeRondas(jugadores,cantRondas);
        resultados_Torneo(jugadores,cantRondas);
        puntuacion_Alta(jugadores);

    }

public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}
	public static int[] jugadores(int cant_Jugadores) {
    int [] jugadores = new int [cant_Jugadores];
    return jugadores;
	}

	public static int[] puntajeRondas(int[] jugadores, int cantRondas) {
     for (int i = 0; i < jugadores.length; i++) { 
        jugadores[i] = registrarPuntajePorRondas(i, cantRondas);
    }
    return jugadores;
}

	public static int registrarPuntajePorRondas(int jugador, int cantRondas) {
    int puntajeTotal = 0;
    for (int i = 0; i < cantRondas; i++) { 
        System.out.println("Ingrese el puntaje del jugador " + (jugador + 1) + " en la ronda " + (i + 1) + ": ");
        puntajeTotal += escaner.nextInt();
    }
    return puntajeTotal;
}

	public static void resultados_Torneo(int[] jugadores, int cantRondas) {
    System.out.println("Resultados del torneo: ");
    for (int i = 0; i < jugadores.length; i++) { 
        System.out.println("El puntaje total del jugador " + (i + 1) + " es: " + jugadores[i] + ", Promedio: " + (jugadores[i]/rondasCant));
     
    }
}
  
public static void puntuacion_Alta(int[] jugadores) {
    int maxPuntaje = jugadores[0]; 
    int jugadorGanador = 1; 

    for (int i = 0; i < jugadores.length; i++) {  
        if (jugadores[i] > maxPuntaje) {
            maxPuntaje = jugadores[i];
            jugadorGanador = i + 1; 
        }
    }

	
	System.out.println("El jugador con la puntuación más alta es: Jugador " + jugadorGanador + " con " + maxPuntaje + " puntos");
}

public static void verificacion_Jugadores(int cantidad_Jugadores) {
    if(cantidad_Jugadores > 10 || cantidad_Jugadores < 1) {
        System.out.println("Digite una cantidad de jugadores valida");
        System.exit(0);
    }
}

public static void verificacion_Rondas(int cantRondas) {
    if(cantRondas > 5 || cantRondas < 1) {
        System.out.println("Digite una cantidad de rondas valida");
        System.exit(0);
    }
}

}	