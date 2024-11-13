import java.util.*;
public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mapa mapa = new Mapa();  
        mapa.generarEjercitos();       
        mapa.posicionarEjercitos();

        while (true) {
            System.out.println("\nEstado actual del mapa:");
            mapa.mostrarMapa();

            // Verificación de si los ejércitos están vivos
            boolean ejercitoInglaterraVivo = false;
            boolean ejercitoFranciaVivo = false;

            // Revisar si los ejércitos tienen soldados vivos
            for (Ejercito ejercito : mapa.getEjercitos()) {
                if (ejercito.getReino().getNombre().equals("Inglaterra") && !ejercito.getSoldados().isEmpty()) {
                    ejercitoInglaterraVivo = true;
                }
                if (ejercito.getReino().getNombre().equals("Francia") && !ejercito.getSoldados().isEmpty()) {
                    ejercitoFranciaVivo = true;
                }
            }

            // Si alguno de los ejércitos no tiene soldados, termina el juego
            if (!ejercitoInglaterraVivo || !ejercitoFranciaVivo) {
                if (!ejercitoInglaterraVivo) {
                    System.out.println("¡El ejército de Inglaterra ha sido derrotado!");
                }
                if (!ejercitoFranciaVivo) {
                    System.out.println("¡El ejército de Francia ha sido derrotado!");
                }
                break; // Termina el ciclo si algún ejército es derrotado
            }

            // Turno de cada ejército
            for (Ejercito ejercito : mapa.getEjercitos()) {
                System.out.println("\nTurno del ejército de " + ejercito.getReino().getNombre());
                System.out.print("Ingrese la fila (1-10) y columna (A-J) de un soldado a mover: ");
                int fila = scanner.nextInt() - 1;
                char columnaChar = scanner.next().charAt(0);
                int columna = columnaChar - 'A';

                System.out.print("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha): ");
                String direccion = scanner.next();

                mapa.moverEjercito(fila, columna, direccion, ejercito.getReino().getNombre());               
            }
        }

        scanner.close();
    }
}

