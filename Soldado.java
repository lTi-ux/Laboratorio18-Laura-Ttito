public class Soldado {
    private int id;
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private Ejercito ejercito;  // Referencia al ejército al que pertenece el soldado

    public Soldado(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, Ejercito ejercito) {
        this.id = id;
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;  // La vida actual comienza igual a la vida máxima
        this.velocidad = velocidad;
        this.actitud = "Defensiva";  // Valor por defecto
        this.vive = true;  // El soldado está vivo al principio
        this.ejercito = ejercito;
    }

    // Métodos getter y setter
    public int getVidaActual() {
        return vidaActual;
    }

    public boolean estaVivo() {
        return vive;
    }

    public void recibirDanio(int danio) {
        vidaActual -= danio;
        if (vidaActual <= 0) {
            vive = false;
            vidaActual = 0;
        }
    }

    @Override
    public String toString() {
        return nombre + " | Vida: " + vidaActual + " | Actitud: " + actitud;
    }
}
