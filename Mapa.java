import java.util.*;

public class Mapa {
    private Soldado[][] tablero;
    private List<Ejercito> ejercitos;
    private String tipoTerritorio;
    private final int filaMax = 10;
    private final int columnaMax = 10;

    public Mapa() {
        this.tablero = new Soldado[filaMax][columnaMax];
        this.ejercitos = new ArrayList<>();
        this.tipoTerritorio = generarTerritorio();
    }

    // Genera aleatoriamente el tipo de territorio
    private String generarTerritorio() {
        String[] territorios = {"Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa"};
        Random rand = new Random();
        return territorios[rand.nextInt(territorios.length)];
    }

    // Asigna bonus según el tipo de territorio al reino
    public void asignarBonusTerritorio() {
        for (Ejercito ejercito : ejercitos) {
            ejercito.getReino().asignarBonus(tipoTerritorio);
        }
    }

    // Genera los ejércitos (para 2 reinos: Inglaterra y Francia)
    public void generarEjercitos() {
        // Crear dos reinos
        Reino reino1 = new Reino("Inglaterra");
        Reino reino2 = new Reino("Francia");

        // Crear los ejércitos
        Ejercito ejercito1 = new Ejercito(reino1, 1);
        Ejercito ejercito2 = new Ejercito(reino2, 2);

        // Crear soldados y agregar al ejército
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {  // Aleatorio entre 1 y 10 soldados
            Soldado soldado = new Soldado(i + 1, "Soldado" + (i + 1), rand.nextInt(5) + 1,
                    rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(3) + 1, ejercito1);
            ejercito1.agregarSoldado(soldado);
        }
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {  // Aleatorio entre 1 y 10 soldados
            Soldado soldado = new Soldado(i + 1, "Soldado" + (i + 1), rand.nextInt(5) + 1,
                    rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(3) + 1, ejercito2);
            ejercito2.agregarSoldado(soldado);
        }

        // Añadir los ejércitos al mapa
        ejercitos.add(ejercito1);
        ejercitos.add(ejercito2);
    }

    // Posicionar los ejércitos en el mapa
    public void posicionarEjercitos() {
        Random rand = new Random();
        for (Ejercito ejercito : ejercitos) {
            for (Soldado soldado : ejercito.getSoldados()) {
                int fila, columna;
                do {
                    fila = rand.nextInt(filaMax);
                    columna = rand.nextInt(columnaMax);
                } while (tablero[fila][columna] != null);  // Verificamos que no haya un soldado en esa posición
                tablero[fila][columna] = soldado;
            }
        }
    }

    // Mostrar el estado actual del mapa
    public void mostrarMapa() {
        System.out.println("Territorio: " + tipoTerritorio);
        System.out.print("    ");
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();
        for (int i = 0; i < filaMax; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < columnaMax; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("  - ");
                } else {
                    System.out.print(" " + tablero[i][j].toString().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

    // Mover un ejército de una posición a otra
    public void moverEjercito(int fila, int columna, String direccion, String reinoNombre) {
        Soldado soldado = tablero[fila][columna];

        if (soldado == null || !soldado.estaVivo() || !soldado.getEjercito().getReino().getNombre().equals(reinoNombre)) {
            System.out.println("No hay un ejército válido para mover en esa posición.");
            return;
        }

        // Determinar nueva posición
        int nuevaFila = fila;
        int nuevaColumna = columna;
        switch (direccion.toLowerCase()) {
            case "arriba": nuevaFila--; break;
            case "abajo": nuevaFila++; break;
            case "izquierda": nuevaColumna--; break;
            case "derecha": nuevaColumna++; break;
            default: 
                System.out.println("Dirección inválida.");
                return;
        }

        // Verificar que la nueva posición esté dentro del mapa
        if (nuevaFila < 0 || nuevaFila >= filaMax || nuevaColumna < 0 || nuevaColumna >= columnaMax) {
            System.out.println("Movimiento fuera de los límites del mapa.");
            return;
        }

        // Verificar si hay otro ejército en la nueva posición
        if (tablero[nuevaFila][nuevaColumna] != null) {
            System.out.println("¡Batalla en curso! El ejército rival está en la nueva posición.");
            realizarBatalla(fila, columna, nuevaFila, nuevaColumna, reinoNombre);
        } else {
            // Mover el soldado
            tablero[nuevaFila][nuevaColumna] = soldado;
            tablero[fila][columna] = null;
            System.out.println("Movimiento realizado con éxito.");
        }
    }

    // Realizar una batalla entre dos ejércitos
    private void realizarBatalla(int fila1, int columna1, int fila2, int columna2, String reinoAtacante) {
        Soldado soldado1 = tablero[fila1][columna1];
        Soldado soldado2 = tablero[fila2][columna2];
        
        int vidaTotal1 = soldado1.getEjercito().getSoldados().stream().mapToInt(Soldado::getVidaActual).sum();
        int vidaTotal2 = soldado2.getEjercito().getSoldados().stream().mapToInt(Soldado::getVidaActual).sum();

        double probabilidadVictoria1 = (double) vidaTotal1 / (vidaTotal1 + vidaTotal2);
        double probabilidadVictoria2 = 1 - probabilidadVictoria1;

        Random rand = new Random();
        if (rand.nextDouble() < probabilidadVictoria1) {
            System.out.println(soldado1.getEjercito().getReino().getNombre() + " ha ganado la batalla!");
            // El ejército 1 gana
            tablero[fila2][columna2] = soldado1;  // Mueve el soldado vencedor a la nueva casilla
            tablero[fila1][columna1] = null;
        } else {
            System.out.println(soldado2.getEjercito().getReino().getNombre() + " ha ganado la batalla!");
            // El ejército 2 gana
            tablero[fila1][columna1] = soldado2;  // Mueve el soldado vencedor a la nueva casilla
            tablero[fila2][columna2] = null;
        }
    }
    // Método para acceder a la lista de ejércitos
    public List<Ejercito> getEjercitos() {
        return ejercitos;
    }
}
