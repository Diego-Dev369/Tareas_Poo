package dulceria;

import java.util.ArrayList;

public class Inventario {
    public ArrayList<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        this.listaProductos.add(producto);
        System.out.println("Producto registrado exitosamente\n");
    }


    public void eliminarProducto(String nombreProducto) {
        int longitudOriginal = this.listaProductos.size(); // 3

        this.listaProductos.removeIf((producto) -> producto.getNombre().equals(nombreProducto));

        if (longitudOriginal != this.listaProductos.size()) {
            System.out.println("Se eliminó el prodcuto con el nombre: " + nombreProducto);
        } else {
            System.out.println("No existe un producto con el nombre: " + nombreProducto);
        }
    }

    public void mostrarProductos() {
        System.out.println("\n*** PRODUCTOS DISPONIBLES ***\n");

        if (this.listaProductos.isEmpty()) {
            System.out.println("⚠️ No existen productos en el sistema ⚠️\n");
            return;
        }

        int iterador = 1;
        for (Producto producto : this.listaProductos) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.printf("│  Producto #%d                              │\n", iterador);
            System.out.println("├───────────────────────────────────────────┤");
            System.out.printf("│  Nombre: %-30s   │\n", producto.getNombre());
            System.out.printf("│  Precio: $%-29.2f   │\n", producto.getPrecio());
            System.out.println("└───────────────────────────────────────────┘");
            iterador++;
        }
        System.out.println();
    }



}


