public class Reino {
    private String nombre;
    private int bonusDefensa;
    private int bonusAtaque;

    public Reino(String nombre) {
        this.nombre = nombre;
        this.bonusDefensa = 0;
        this.bonusAtaque = 0;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para asignar un bono basado en el tipo de territorio
    public void asignarBonus(String tipoTerritorio) {
        switch (tipoTerritorio) {
            case "Bosque":
                this.bonusDefensa = 2;
                this.bonusAtaque = 1;
                break;
            case "Campo Abierto":
                this.bonusDefensa = 1;
                this.bonusAtaque = 2;
                break;
            case "Montaña":
                this.bonusDefensa = 3;
                this.bonusAtaque = 0;
                break;
            case "Desierto":
                this.bonusDefensa = 0;
                this.bonusAtaque = 3;
                break;
            case "Playa":
                this.bonusDefensa = 1;
                this.bonusAtaque = 1;
                break;
            default:
                this.bonusDefensa = 0;
                this.bonusAtaque = 0;
                break;
        }
    }

    // Métodos getter para los bonus
    public int getBonusDefensa() {
        return bonusDefensa;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }
}
