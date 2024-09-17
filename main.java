package Repo_Tareas;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0, cantidad;
        char op;
        Producto producto;

        System.out.println("¿Quiere ingresar un stock? s/n");
        op = sc.next().charAt(0);

        if (op == 's' || op == 'S') {
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = sc.next();
            System.out.println("Ingrese el precio del producto: ");
            float precio = sc.nextFloat();
            sc.nextLine();
            System.out.println("Ingrese el stock de producto: ");
            int stock = sc.nextInt();
            producto = new Producto(nombre,precio,stock);
        }else{
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = sc.next();
            System.out.println("Ingrese el precio del producto: ");
            float precio = sc.nextFloat();
            producto = new Producto(nombre,precio);
        }

        while (opc != 4) {
            System.out.println("\n*** Bienvenido ****");
            System.out.println("\n1. Aumentar stock" +
                    "\n2. Reducir stock" +
                    "\n3. Información del producto" +
                    "\n4. Salir");
            System.out.print("Elección: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese cuanto aumentará el stock: ");
                    cantidad = sc.nextInt();
                    producto.aumentarStock(cantidad);
                    break;
                case 2:
                    System.out.print("Ingrese cuanto reducirá el stock: ");
                    cantidad = sc.nextInt();
                    producto.reduceStock(cantidad);
                    break;
                case 3:
                    producto.mostrarProducto();
                    break;
                case 4:
                    System.out.println("Adiosito");
                    return;
            }
        }
    }
}
