public class Espadachin extends Soldado {
    private int longitudEspada;  // Atributo particular de los espadachines

    // Constructor
    public Espadachin(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito, int longitudEspada) {
        super(id, nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, ejercito);
        this.longitudEspada = longitudEspada;
    }

    // Acción particular: crear un muro de escudos
    public void crearMuroDeEscudos() {
        System.out.println(getNombre() + " ha creado un muro de escudos!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Longitud espada: " + longitudEspada;
    }
}
