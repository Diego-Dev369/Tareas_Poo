package Repo_Tareas;
import java.util.ArrayList;
public class Inventario {

    public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    public ArrayList<Categoria> listaCategorias  = new ArrayList<Categoria>();
    Producto producto;

    public void registrarCategoria(Categoria c){
        this.listaCategorias.add(c);
    }

    public void registrarProducto(Producto producto) {
        this.listaProductos.add(producto);
        System.out.println("Se registro un nuevo producto");
    }

    public void mostrarProductos() {
        System.out.println("*** PRODUCTOS EN EL SISTEMA ***");
        if (listaProductos.size() == 0) {
            System.out.println("\nNo existen productos en el sistema");
            return;
        }
        for (Producto p1 : listaProductos) {
            System.out.println("Id: " + p1.id);
            System.out.println("Nombre: " + p1.nombre);
            System.out.println("Precio: " + p1.precio);
            System.out.println("Descripción: " + p1.descripcion);
            System.out.println("Categoria: " + p1.idCategoria);
            System.out.println("Stock: " + p1.stock);
        }
    }

    public boolean validarExistenciaDeCategorias() {
        return this.listaCategorias.size() == 0;
    }
    public void mostrarCategorias() {
        System.out.println("*** CATEGORIAS EN EL SISTEMA ***");
        for (Categoria c : listaCategorias) {
            System.out.println("Categoria: " + c.nombre + "Id: " + c.idCategoria);
        }
    }

    public void mostrarCategoriaConProducto() {
        System.out.println("* CATEGORIAS EN EL SISTEMA CON PRODUCTOS *");
        for (Categoria c : listaCategorias) {
            System.out.println("Categoría: " + c.nombre);
            int productoIndex = 1;
            boolean tieneProductos = false;
            for (Producto p : listaProductos) {
                if (p.idCategoria == c.idCategoria) {
                    System.out.println("Producto " + productoIndex + ": [" +
                            p.nombre +
                            " Descripción: " + p.descripcion +
                            " Precio: " + p.precio +
                            " Stock: " + p.stock + "]");
                    productoIndex++;
                    tieneProductos = true;
                }
            }
            if (!tieneProductos) {
                System.out.println("Esta categoría no tiene productos.");
            }
        }
    }

    public void eliminarProducto(int idProdEliminar) {
        int longitudOriginal = listaProductos.size();
        listaProductos.removeIf(Producto -> Producto.idCategoria == idProdEliminar) ;
        if (longitudOriginal != listaProductos.size()) {
            System.out.println("Se elimino el producto con el id: " + idProdEliminar);
        }else {
            System.out.println("No existe el producto con el id: " + idProdEliminar);
        }
    }
}

