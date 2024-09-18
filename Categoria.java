package Repo_Tareas;
import java.util.ArrayList;
import java.util.Random;

public class Categoria{

    public int idCategoria;
    public String nombre;
    public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    public Random random = new Random();

    public Categoria(String nombre){
        this.idCategoria = this.random.nextInt(1,10001); //id aleatorio
        this.nombre = nombre;
    }
    public void registrarProductoEnCategori(Producto producto){
        this.listaProductos.add(producto);
    }

    public void mostrarDatos() {
        System.out.println("lista.productos.get[0] ");
    }
}