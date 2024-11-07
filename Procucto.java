import excepcionesPer.Excepciones.*;

public class Procucto {
    public String nombre;
    public double precio;
    public int stock;

    public Procucto(String nombre, double precio, int stock) throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new ProductoInvalidoException("El nombre no puede ser vacio o nulo");
        }
        if(precio <= 0){
            throw new PrecioInvalidoException("El precio no puede ser menor o igual que 0");
        }
        if(stock < 0){
            throw new CantidadInvalidaException("El stock no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public double calcularValorTotal() {
        return precio * stock;
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Valor total: " + calcularValorTotal()+"\n");
    }


}
