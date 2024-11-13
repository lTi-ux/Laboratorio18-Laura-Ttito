import java.util.*; 

public class Ejercito {
    private List<Soldado> soldados;  // Lista de soldados en el ejército
    private Reino reino;             // El reino al que pertenece el ejército
    private int id;                  // Identificador del ejército

    // Constructor
    public Ejercito(Reino reino, int id) {
        this.reino = reino;
        this.soldados = new ArrayList<>();  // Inicializa la lista de soldados
        this.id = id;
    }

    // Método para agregar un soldado al ejército
    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    // Método para obtener la lista de soldados
    public List<Soldado> getSoldados() {
        return soldados;
    }

    // Método para obtener el reino al que pertenece el ejército
    public Reino getReino() {
        return reino;
    }

    // Método para obtener el ID del ejército
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return reino.getNombre() + " - Ejercito " + id;
    }
}
