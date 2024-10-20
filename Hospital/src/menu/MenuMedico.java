package menu;

import hospital.Hospital;
import usuarios.medicos.Medico;

import java.util.Scanner;

public class MenuMedico {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Medico medico) {
        int opc;
        do {
            System.out.print("\nBienvenido/a Dr/Dra. " + medico.getNombre());
            System.out.println("""
                \n----------Menú de opciones----------
                1.- Ver mis consultas
                2.- Ver mis pacientes
                3.- Consultar paciente
                4.- Consultar expediente de paciente
                5.- Completar consulta
                6.- Mostrar información personal
                7.- Salir""");
            System.out.print("Elija una opción: ");
            opc = scanner.nextInt();
            scanner.nextLine();
            return opc;

        } while (opc != 7);
    }

    public void procesarDatosMenu(int opc, Medico medico, Hospital hospital){
        switch (opc) {
            case 1:
                hospital.mostrarConsultasMedicos(medico.getId());
                break;
            case 2:
                hospital.mostrarPacientesDeMedico(medico.getId());
                break;
            case 3:
                // Implementar funcionalidad para consultar paciente
                System.out.println("Ingrese el id del paciente: ");
                String idPaciente = scanner.nextLine();
                hospital.mostrarPacientePorId(idPaciente);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                hospital.mostrarMedicoPorId(medico.getId());
                break;
            case 7:
                System.out.println("\n-----Adiosito-----");
                break;
            default:
                System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
        }
    }
}