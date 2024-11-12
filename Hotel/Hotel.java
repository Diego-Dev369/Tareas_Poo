package Hotel;
import java.util.Scanner;

public class Hotel {
    public Scanner scanner = new Scanner(System.in);

    Habitacion[] listadoHabitacion = new Habitacion[3];

    public Hotel() {
        listadoHabitacion[0] = new Habitacion("0. Individual", 100, true);
        listadoHabitacion[1] = new Habitacion("1. Doble", 200, true);
        listadoHabitacion[2] = new Habitacion("2. Suite", 300, true);

    }
    public void mostrarDetalles() {
        for (Habitacion habitacion : listadoHabitacion) {
            System.out.println("Tipo: " + habitacion.tipo + ", Precio: " + habitacion.precioPorNoche + ", Disponibilidad: " + (habitacion.disponible ? "Libre":"Ocupada"));
        }
    }

    public void reserva(int NumeroHabitacion) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException{
        if(listadoHabitacion[NumeroHabitacion].disponible==false){
            throw new HabitacionNoDisponibleException("La habitación ya está reservada y no es posible su utilización.");
        } else {
            System.out.println("Ingresa el numero de noches que deseas reservarla");
            scanner.nextLine();
            int x = scanner.nextInt();

            if (x < 1) {  // Modificación: Verificamos si el número de noches es válido
                throw new NumeroDeNochesInvalidoException("El número de noches debe ser mayor que 0.");
            }
            int costo=PrecioAPagar(x,NumeroHabitacion);
            System.out.println("El precio por la reservacion es:"+costo);
            int opcion = 0;
            while (opcion != 1 && opcion != 2) {
            System.out.println("Esta segro de realizar el pago? 1.-SI 2.-NO");
            opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Pago realizado para la habitación: " + NumeroHabitacion);
                        System.out.println("La reserva se ha realizado con exito");
                        OcuparHabitacion(NumeroHabitacion);
                        break;
                    case 2:
                        System.out.println("No se realizó el pago para la habitación: " + NumeroHabitacion);
                        System.out.println("No se realizo la reserva");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese 1 para Sí o 2 para No.");
                        break;
                }
            }
        }
    }

    public void OcuparHabitacion(int NumeroHabitacion) {
        listadoHabitacion[NumeroHabitacion].disponible=false;
    }

    public int PrecioAPagar(int x,int NumeroHabitacion) {
        int precio=(int)listadoHabitacion[NumeroHabitacion].precioPorNoche;
        int PrecioTotal=precio*x;
        return PrecioTotal;
    }

    public void LiberarHabitacion(int NumeroHabitacion) {
        if(NumeroHabitacion>-1 && NumeroHabitacion<3){
        if(listadoHabitacion[NumeroHabitacion].disponible==true){
        System.out.println("Esa habitacion ya estaba disponible");
        } else {
            listadoHabitacion[NumeroHabitacion].disponible=true;
            System.out.println("La habitacion ya se encuentra disponible");
         }
        }else {
            System.out.println("Esa habitacion no se encuentra en el HOTEL");
        }
    }
    public class HabitacionNoDisponibleException extends Exception {
        public HabitacionNoDisponibleException(String message) {
            super(message);
        }
    }

    public class NumeroDeNochesInvalidoException extends Exception {
        public NumeroDeNochesInvalidoException(String message) {
            super(message);
        }
    }


}
