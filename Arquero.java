public class Arquero extends Soldado {
    private int flechas;

    public Arquero(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito, int flechas) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.flechas = flechas;
    }

    public void disparar() {
        if (flechas > 0) {
            flechas--;
            System.out.println(this.nombre + " ha disparado una flecha.");
        } else {
            System.out.println(this.nombre + " no tiene más flechas.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Flechas restantes: " + flechas;
    }
}
