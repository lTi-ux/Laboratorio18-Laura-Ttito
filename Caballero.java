public class Caballero extends Soldado {
    private String arma;  // "espada" o "lanza"
    private boolean montado;

    public Caballero(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.arma = "espada";
        this.montado = false;
    }

    public void montar() {
        if (!montado) {
            montado = true;
            arma = "lanza";
            System.out.println(this.nombre + " se ha montado y ahora tiene una lanza.");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            arma = "espada";
            System.out.println(this.nombre + " se ha desmontado y ahora tiene una espada.");
        }
    }

    public void envestir() {
        if (montado) {
            System.out.println(this.nombre + " ha realizado una embestida con lanza.");
        } else {
            System.out.println(this.nombre + " ha atacado dos veces con espada.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Arma: " + arma + " | Montado: " + montado;
    }
}
