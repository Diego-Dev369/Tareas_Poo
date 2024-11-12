package Hotel;
public class Habitacion {

    public String tipo;
    public double precioPorNoche;
    public boolean disponible;

    public Habitacion(String tipo, double precioPorNoche, boolean disponible) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }
}
