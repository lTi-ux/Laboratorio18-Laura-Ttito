public class Reino {
    private String nombre;

    // Constructor
    public Reino(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el nombre del reino
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
