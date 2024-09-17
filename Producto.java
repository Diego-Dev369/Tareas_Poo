package Repo_Tareas;

public class Producto {
    private String nombre;
    private float precio;
    private int stock;

    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    public void aumentarStock(int cantidad) {
        if (cantidad >= 0) {
            this.stock += cantidad;
            System.out.println("Se aumentó el stock a " + this.stock);
        }
    }
    public void reduceStock(int cantidad) {
        if (cantidad >= 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
            System.out.println("El stock se redujo a " + this.stock);
        }else{
            System.out.println("La cantidad para eliminar algo del stock debe ser menor que la cantidad del stock");
        }
    }
    public void mostrarProducto() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Stock: " + this.stock);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }else{
            System.out.println("El nombre no puede estar vacío");
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio >= 0) {
            this.precio = precio;
        }else{
            System.out.println("El precio no puede ser negativo");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }else{
            System.out.println("El stock no puede ser negativo");
        }
    }
}
