package compra.boleto;

import cartelera.Pelicula;

import java.time.LocalDateTime;
import java.util.List;

public class Boleto {
    public String id;
    public int noSala;
    public LocalDateTime fechaHora;
    public String nombrePelicula;
    public String asiento;
    public String tipoAsiento; //VIP, PREMIUM 0 o normal
    public String cliente;
    public double precio;

    private List<String> asientosSeleccionados;
    private List<String> articulosExtra;
    private Pelicula pelicula;
    //public boolean tipoDescuento; quite de constructor para pruebas

    public Boleto(String id, int noSala, LocalDateTime fechaHora, String nombrePelicula, String asiento, String tipoAsiento, String cliente, double precio) {
        this.id = id;
        this.noSala = noSala;
        this.fechaHora = fechaHora;
        this.nombrePelicula = nombrePelicula;
        this.asiento = asiento;
        this.tipoAsiento = tipoAsiento;
        this.cliente = cliente;
        this.precio = precio;

    }

    public Boleto(Pelicula pelicula, List<String> asientosSeleccionados, List<String> articulosExtra ,double precio) {
        this.asientosSeleccionados = asientosSeleccionados;
        this.articulosExtra = articulosExtra;
        this.pelicula = pelicula;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoSala() {
        return noSala;
    }

    public void setNoSala(int noSala) {
        this.noSala = noSala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String mostrarInformacion() {
        return "Id: " + id +
                ", No de sala: " + noSala +
                ", Fecha y Hora: " + fechaHora +
                ", nombre pelicula: " + nombrePelicula +
                ", Asiento: " + asiento +
                ", Tipo Asiento: " + tipoAsiento +
                ",cliente: " + cliente +
                ", precio: " + precio;
    }

    public void mostrarBoleto() {
        System.out.println("========== BOLETO DE CINE ==========");
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("Clasificación: " + pelicula.getClasificacion());
        System.out.println("Duración: " + pelicula.getDuracion() + " min");
        System.out.println("Asientos seleccionados: " + String.join(", ", asientosSeleccionados));
        System.out.println("Artículos extras: " + (articulosExtra.isEmpty() ? "Ninguno" : String.join(", ", articulosExtra)));
        System.out.println("=====================================");
    }
}
