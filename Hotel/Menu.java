package Hotel;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    Hotel hotel = new Hotel();
    public void mostrarMenuHotel(){
        int opcion =0;

        while (opcion!=4){
            System.out.println("\n**SISTEMA RESERVA DE HABITACIONES**");
            System.out.println("\n**BIENVENIDO AL SUPER MINI HOTEL**");
            System.out.println("1.-Mostrar detalles de las habitaciones");
            System.out.println("2.-Realizar una reserva");
            System.out.println("3.-Liberar una habitacion");
            System.out.println("4.-Salir");
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
                    System.out.println("Elegiste la opcion de mostrar detalles de las habitaciones.");
                    hotel.mostrarDetalles();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion de realizar una reserva.");
                    System.out.println("Ingresa la habitacion que eliges para pasar la noche 0.-Individual 1.-Doble 2.-Suite");

                    try {
                        int numero=scanner.nextInt();
                        if (numero < 0 || numero> 2) {
                            System.out.println("Número de habitación inválido. Debes ingresar un número entre 0 y 2.");
                        } else {
                            hotel.reserva(numero);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("SOLO INGRESA NÚMEROS.");
                        scanner.nextLine();
                    } catch (Hotel.HabitacionNoDisponibleException e) {
                        System.out.println(e.getMessage());
                    } catch (Hotel.NumeroDeNochesInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    int numero2=0;
                    System.out.println("Elegiste la opcion de liberar una habitacion.");
                    System.out.println("Ingresa el numero de habitacion que deseas liberar.");

                    try {
                        numero2=scanner.nextInt();
                        if (numero2 < 0 || numero2 > 2) {
                            System.out.println("Número de habitación inválido. Debes ingresar un número entre 0 y 2.");
                        } else {
                            hotel.LiberarHabitacion(numero2);
                        }
                    }catch (InputMismatchException e){
                        System.out.println("SOLO INGRESA NUMEROS");
                        scanner.nextLine();
                    }
                    break;
                case 4:
                    System.out.println("\n-----Chao gracias por usar el sistema de reservas-----");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
        scanner.close();
    }
}
