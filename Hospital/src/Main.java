import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        int respuesta = 0;
        Hospital hospital = new Hospital();

        while (respuesta != 12) {
            System.out.println("""
                    \n----------Menú de opciones----------
                    1.- Registrar un paciente
                    2.- Registrar un médico
                    3.- Registrar un consultorio
                    4.- Registrar una consulta
                    5.- Mostrar paciente(s)
                    6.- Mostrar medico(s)
                    7.- Mostrar consultorio(s)
                    8.- Mostrar consulta(s)
                    9.- Mostrar paciente por id
                    10.- Mostrar Médico por id
                    11.- Mostrar Consultorio por id
                    12.- Salir""");
            System.out.print("Elija una opción: ");
            respuesta = scaner.nextInt();

            switch (respuesta) {
                case 1:
                    // En Hospital
                    // p -{año actual} - {mes actual} - {longitud pacientes +1} - {1,1000000}

                    String id = hospital.generarIdPaciente();
                    System.out.println("-- Registrar paciente --");
                    System.out.println("Ingrese el/los nombre(s) del paciente: ");
                    scaner.nextLine();
                    String nombre = scaner.nextLine();
                    System.out.println("Ingrese el/los apellido(s) del paciente: ");
                    String apellido = scaner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento: ");
                    String fechaNacomiento = scaner.nextLine();
                    System.out.println("Ingrese su tipo de sangre: ");
                    String tipoSangre = scaner.nextLine();
                    System.out.println("Ingrese su sexo: ");
                    String sexoString = scaner.next();
                    char sexo = sexoString.charAt(0);
                    scaner.nextLine();
                    System.out.println("Ingrese el teléfono del paciente: ");
                    String telefono = scaner.nextLine();

                    Paciente paciente = new Paciente(id, nombre,apellido,fechaNacomiento,tipoSangre,sexo,telefono);
                    hospital.registrarPaciente(paciente);

                    System.out.println("\nPaciente registrado exitosamente");
                    break;
                case 2:
                    System.out.println("\n-- Registrar un médico --");

                    System.out.println("Ingrese el nombre del médico: ");
                    scaner.nextLine();
                    String nombreM = scaner.nextLine();
                    System.out.println("Ingrese el apellido del médico: ");
                    String apellidoM = scaner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento: ");
                    String fechaNacomientoM = scaner.nextLine();
                    System.out.println("Ingrese el teléfono del médico: ");
                    String telefonoM = scaner.nextLine();
                    System.out.println("Ingrese el rfc del médico: ");
                    String rfc = scaner.nextLine();
                    String idMedico = hospital.generarIdMedico(apellidoM, fechaNacomientoM);

                    Medico medico = new Medico(idMedico,nombreM, apellidoM, fechaNacomientoM,telefonoM,rfc);
                    hospital.registrarMedico(medico);

                    System.out.println("\nMédico registrado exitosamente");
                    break;
                case 3:
                    System.out.println("\n-- Registrar un consultorio --");
                    String idConsultorio = hospital.generarIdConsultorio();
                    System.out.println("Ingrese el numero de piso del consultorio: ");
                    int piso = scaner.nextInt();
                    scaner.nextLine();
                    System.out.println("Ingrese el número del consultorio: ");
                    String numero = scaner.nextLine();

                    Consultorio consultorio = new Consultorio(idConsultorio,piso,numero);
                    hospital.registrarConsultorio(consultorio);

                    System.out.println("\nConsultorio registrado exitosamente");
                    break;
                case 4:
                    System.out.println("\n-- Registrar una consulta --");
                    return;
                case 5:
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    hospital.mostrarMedico();
                    break;
                case 7:
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    //Mostrar las consultas
                    break;
                case 9:
                    System.out.println("\n-----Mostrar paciente por id-----");
                    System.out.println("Ingresa el id del paciente que deseas buscar: ");
                    String idPaciente = scaner.next();

                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("\n-----Mostrar médico por id-----");
                    System.out.println("Ingresa el id del medico que deseas buscar: ");
                    String idBusquedaMedico = scaner.next();

                    hospital.mostrarMedicoPorId(idBusquedaMedico);
                    break;
                case 11:
                    System.out.println("\n-----Mostrar consultorio por id-----");
                    System.out.println("Ingresa el id del consultorio que deseas buscar: ");
                    String idBusquedaConsul = scaner.next();

                    hospital.mostrarConsultorioPorId(idBusquedaConsul);
                    break;
                case 12:
                    System.out.println("\n-----Adiosito-----");
                    return;
            }
        }
    }
}