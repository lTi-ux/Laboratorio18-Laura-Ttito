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

    // Constructor que inicializa todos los atributos del soldado
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
        this.ejercito = ejercito;  // Asignamos el ejército al que pertenece
    }

    // Métodos getter y setter
    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean estaVivo() {
        return vive;
    }

    public Ejercito getEjercito() {
        return ejercito;
    }

    // Método para atacar a otro soldado
    public void atacar(Soldado enemigo) {
        // Calcula el daño basado en el nivel de ataque y defensa
        int daño = this.nivelAtaque - enemigo.nivelDefensa;

        // Si el daño es positivo, se lo restamos a la vida del enemigo
        if (daño > 0) {
            enemigo.setVidaActual(enemigo.getVidaActual() - daño);
            System.out.println(this.nombre + " ha atacado a " + enemigo.getNombre() + " causando " + daño + " de daño.");
        } else {
            System.out.println(this.nombre + " ha fallado el ataque.");
        }
    }

    // Método para mostrar información del soldado
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Ataque: " + nivelAtaque + " | Defensa: " + nivelDefensa +
                " | Vida: " + vidaActual + " | Velocidad: " + velocidad;
    }

    // Método para moverse
    public void mover(int deltaX, int deltaY) {
        System.out.println(this.nombre + " se mueve a la posición (" + deltaX + ", " + deltaY + ").");
    }
}

