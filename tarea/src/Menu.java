import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    Tarea tarea1 = new Tarea();
    public void mostrarMenuTareas(){
        int opcion =0;

        while (opcion!=3){
            System.out.println("\n**SISTEMA DE CONTROL DE TAREAS**");
            System.out.println("1.-Escribir una tarea");
            System.out.println("2.-Leer una tarea");
            System.out.println("3.-Salir");
            System.out.println("Selecciona una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("SOLO INGRESA NUMEROS");
                scanner.nextLine();
                opcion = 0;
            }
            switch (opcion){
                case 1:
                    System.out.println("Elegiste la opcion de escribir una tarea.");
                    System.out.println("Anota  la tarea");
                    String tarea = scanner.nextLine();
                    tarea1.AnotarTarea(tarea);
                    break;
                case 2:
                    System.out.println("Elegiste la opcion de leer las tareas.");
                    tarea1.LeerTarea();
                    break;
                case 3:
                    System.out.println("\n-----Chao gracias por usar el control de tareas-----");

                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
        scanner.close();
    }
}
