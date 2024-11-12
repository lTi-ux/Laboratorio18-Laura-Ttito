public class Ejercito {
    private List<Soldado> soldados;
    private Reino reino;
    private int id;

    public Ejercito(Reino reino, int id) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
        this.id = id;
    }

    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public Reino getReino() {
        return reino;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return reino.getNombre() + " - Ejército " + id;
    }
}
