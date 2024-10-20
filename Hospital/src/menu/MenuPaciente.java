package menu;

import hospital.Hospital;
import usuarios.pacientes.Paciente;

import java.util.Scanner;

public class MenuPaciente {
    private Scanner scanner = new Scanner(System.in);
    public int opc;

    public int mostrarMenu(Paciente paciente) {
        do {
            System.out.print("\nBienvenido/a " + paciente.getNombre());
            System.out.println("""
                \n----------Menú de opciones----------
                1.- Ver mis consultas
                2.- Ver mi información personal
                3.- Ver mi expediente
                4.- Salir""");
            System.out.print("Elija una opción: ");
            opc = scanner.nextInt();
            return opc;


        } while (opc != 4);
    }

    public void procesarDatosMenu(int opc, Paciente paciente, Hospital hospital) {
        switch (opc) {
            case 1:
                hospital.mostrarConsultasPacientes(paciente.getId());
                break;
            case 2:
                hospital.mostrarPacientePorId(paciente.getId());
                break;
            case 3:
                //ver mi expediente
                break;
            case 4:
                System.out.println("\n-----Adiosito-----");
                break;
            default:
                System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
        }
    }
}
