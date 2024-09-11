public class Coche {
    public String marca;
    public String modelo;
    public int año, año_actual;

    public Coche(String marca, String modelo, int año){
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void mostrarInformacion() {
        System.out.println("\nDetalles de auto: " + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAño: " + año);
    }

    public int calcularEdadDelCoche(int año_actual){
        return año_actual - this.año;
    }
}
