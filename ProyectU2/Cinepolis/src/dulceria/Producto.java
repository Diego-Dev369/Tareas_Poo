package dulceria;


public class Producto {
    public String nombre;
    public Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    // Getters


    public String getNombre() {
        return nombre;
    }
    public Double getPrecio() {
        return precio;
    }


    public String mostrarProducto() {
        return String.format("Nombre: %s, precio: %.2f",
                nombre,
                precio
        );
    }
}

