import java.util.*;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el mapa y los ejércitos
        Mapa mapa = new Mapa();  
        mapa.generarEjercitos();       
        mapa.posicionarEjercitos();
        mapa.mostrarMapa();
        
        // Inicialización de la lógica del juego
        while (true) {
            System.out.println("\nEstado actual del mapa:");
            mapa.mostrarMapa();

            // Verificar si hay ejércitos vivos
            boolean ejercito1Vivo = false;
            boolean ejercito2Vivo = false;
            for (Ejercito ejercito : mapa.getEjercitos()) {
                if (!ejercito.getSoldados().isEmpty()) {
                    if (ejercito.getReino().getNombre().equals("Inglaterra") || ejercito.getReino().getNombre().equals("Francia")) {
                        ejercito1Vivo = true;
                    } else {
                        ejercito2Vivo = true;
                    }
                }
            }
            if (!ejercito1Vivo || !ejercito2Vivo) {
                if (!ejercito1Vivo) {
                    System.out.println("¡El ejército de Inglaterra y Francia ha sido derrotado!");
                }
                if (!ejercito2Vivo) {
                    System.out.println("¡El ejército de los otros reinos ha sido derrotado!");
                }
                break; // Terminar el juego si no hay ejércitos vivos
            }

            // Mostrar los datos de los ejércitos
            for (Ejercito ejercito : mapa.getEjercitos()) {
                System.out.println("\nTurno del ejército de " + ejercito.getReino().getNombre());
                System.out.println("Datos de los soldados:");
                for (Soldado soldado : ejercito.getSoldados()) {
                    System.out.println(soldado.toString());
                }

                // Mostrar el soldado con mayor vida y el promedio de vida
                Soldado soldadoConMayorVida = obtenerSoldadoConMayorVida(ejercito);
                double promedioVida = obtenerPromedioVida(ejercito);
                System.out.println("Soldado con mayor vida: " + soldadoConMayorVida.toString());
                System.out.println("Promedio de vida: " + promedioVida);

                // Mostrar ranking de poder
                List<Soldado> rankingDePoder = obtenerRankingDePoder(ejercito);
                System.out.println("Ranking de poder:");
                for (Soldado s : rankingDePoder) {
                    System.out.println(s.toString());
                }

                // Mostrar estadísticas de batalla
                System.out.print("Ingrese la fila (1-10) y columna (A-J) de un soldado a mover: ");
                int fila = scanner.nextInt() - 1;
                char columnaChar = scanner.next().charAt(0);
                int columna = columnaChar - 'A';

                System.out.print("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha): ");
                String direccion = scanner.next();

                mapa.moverEjercito(fila, columna, direccion, ejercito.getReino().getNombre());
                mapa.mostrarMapa();
            }
        }
        scanner.close();
    }

    // Obtener el soldado con mayor vida de un ejército
    public static Soldado obtenerSoldadoConMayorVida(Ejercito ejercito) {
        Soldado soldadoConMayorVida = null;
        for (Soldado soldado : ejercito.getSoldados()) {
            if (soldadoConMayorVida == null || soldado.getVidaActual() > soldadoConMayorVida.getVidaActual()) {
                soldadoConMayorVida = soldado;
            }
        }
        return soldadoConMayorVida;
    }

    // Calcular el promedio de vida de los soldados de un ejército
    public static double obtenerPromedioVida(Ejercito ejercito) {
        int sumaVida = 0;
        for (Soldado soldado : ejercito.getSoldados()) {
            sumaVida += soldado.getVidaActual();
        }
        return (double) sumaVida / ejercito.getSoldados().size();
    }

    // Ordenar los soldados de un ejército por su poder (según el nivel de vida)
    public static List<Soldado> obtenerRankingDePoder(Ejercito ejercito) {
        List<Soldado> soldados = new ArrayList<>(ejercito.getSoldados());
        Collections.sort(soldados, (s1, s2) -> Integer.compare(s2.getVidaActual(), s1.getVidaActual()));
        return soldados;
    }
}
