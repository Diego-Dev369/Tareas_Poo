import java.util.ArrayList;
import java.util.Scanner;
import excepcionesPer.Excepciones.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Procucto> listaProductos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = sc.nextDouble();
            System.out.print("Ingrese la cantidad de productos: ");
            int cantidad = sc.nextInt();

            Procucto producto = new Procucto(nombre, precio, cantidad);
            listaProductos.add(producto);
            System.out.println("\nProducto agregado correctamente\n");

           producto.mostrarDetalles();

        }catch (ProductoInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }catch (PrecioInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }catch (CantidadInvalidaException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            sc.close();
        }
    }
}
