package Repo_Tareas;
import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner sc = new Scanner(System.in);
        int opcion =0;

        while (opcion != 7){
            System.out.println("Bienvenido");
            System.out.print("\n1: Registrar producto: ");
            System.out.print("\n2: Eliminar producto: ");
            System.out.print("\n3: Mostrar producto: ");
            System.out.print("\n4: Mostrar Categorias");
            System.out.print("\n5: Mostrar Categorias con  productos");
            System.out.print("\n6: Registrar categoria");
            System.out.println("\n7: Salir: ");

            System.out.print("Selecione una opción:  ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    if (inventario.validarExistenciaDeCategorias()){
                        System.out.println("No existe categorias en el sistema");
                        break;
                    }
                    System.out.println("\nOpcion 1: Registrar producto");

                    System.out.println("Ingrese nombre: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese descripcion : ");
                    String descripcion = sc.next();
                    System.out.println("Ingrese precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese el id de la categoria en la cual registrarás la categoria: ");
                    int  idCategoria = sc.nextInt();
                    boolean bandera = true;
                    while (bandera) {
                        System.out.println("Categorias");

                        boolean categoriaEncontrada = false;

                        for (Categoria c : inventario.listaCategorias) {
                            if (idCategoria == c.idCategoria) {
                                System.out.println("Ingrese stock: ");
                                int stock = sc.nextInt();
                                sc.nextLine();

                                Producto producto1 = new Producto(nombre, descripcion, precio, stock, idCategoria);
                                inventario.registrarProducto(producto1);
                                bandera = false;
                                categoriaEncontrada = true;
                                break;
                            }
                        }

                        if (!categoriaEncontrada) {
                            System.out.println("Ninguna coincidencia en el id de la categoria dada. Ingrese otro id:");
                            idCategoria = sc.nextInt();
                        }
                    }

                    break;
                case 2:
                    System.out.println("\nOpcion 1: Eliminar producto");
                    System.out.println("Ingrese el id del producto");
                    int id = sc.nextInt();

                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;

                case 4:
                    //Mostrar Categoria
                    inventario.mostrarCategorias();
                    break;
                case 5:
                    inventario.mostrarCategoriaConProducto();
                    break;
                case 6:
                    System.out.println("\nMostrar categoria");
                    System.out.println("Ingresa el nombre de la categoria");
                    String nombreCat = sc.next();

                    Categoria cat = new Categoria(nombreCat);
                    inventario.registrarCategoria(cat);
                    System.out.println("Categoria registrada con exito");
                    break;
                case 7:
                    System.out.println("Adios");
                    return;
            }
        }
    }
}
