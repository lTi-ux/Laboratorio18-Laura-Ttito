
public class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito, int longitudEspada) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.longitudEspada = longitudEspada;
    }

    public void crearMuro() {
        System.out.println(this.nombre + " ha creado un muro de escudos.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Longitud de espada: " + longitudEspada;
    }
}
