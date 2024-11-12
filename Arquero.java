public class Arquero extends Soldado {
    private int flechasDisponibles;  // Atributo particular de los arqueros

    // Constructor
    public Arquero(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito, int flechasDisponibles) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.flechasDisponibles = flechasDisponibles;
    }

    // Acción particular: disparar una flecha
    public void dispararFlecha() {
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(getNombre() + " ha disparado una flecha. Flechas restantes: " + flechasDisponibles);
        } else {
            System.out.println(getNombre() + " no tiene flechas disponibles!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Flechas disponibles: " + flechasDisponibles;
    }
}
