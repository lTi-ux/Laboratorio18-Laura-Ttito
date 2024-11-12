public class Caballero extends Soldado {
    private boolean montado;   // Estado: montado o desmontado
    private String armaActual; // Puede ser "espada" o "lanza"

    // Constructor
    public Caballero(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.montado = false;  // El caballero comienza desmontado
        this.armaActual = "espada";  // Comienza con espada
    }

    // Acción particular: montar el caballo
    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "lanza";
            System.out.println(getNombre() + " se ha montado en su caballo y ha cambiado a lanza.");
        } else {
            System.out.println(getNombre() + " ya está montado.");
        }
    }

    // Acción particular: desmontar el caballo
    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "espada";
            System.out.println(getNombre() + " se ha desmontado y ha cambiado a espada.");
        } else {
            System.out.println(getNombre() + " ya está desmontado.");
        }
    }

    // Acción particular: envestir
    public void envestir() {
        if (montado) {
            System.out.println(getNombre() + " ha envestido con su lanza.");
        } else {
            System.out.println(getNombre() + " ha envestido con su espada (2 ataques).");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Montado: " + (montado ? "Sí" : "No") + " | Arma: " + armaActual;
    }
}
