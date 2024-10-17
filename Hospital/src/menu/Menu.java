package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.Usuario;
import utils.Rol;
import utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Hospital hospital = new Hospital();
    public Usuario usuarioEnSesion;


    private void mostrarMenuPaciente(Paciente paciente) {
        int opc;
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
            scanner.nextLine();

            switch (opc) {
                case 1:
                    hospital.mostrarConsultasPacientes(usuarioEnSesion.id);
                    break;
                case 2:
                    hospital.mostrarPacientePorId(usuarioEnSesion.id);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\n-----Adiosito-----");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        } while (opc != 4);
    }

    private void mostrarMenuMedico(Medico medico) {
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

            switch (opc) {
                case 1:
                    hospital.mostrarConsultasMedicos(usuarioEnSesion.id);
                    break;
                case 2:
                    hospital.mostrarPacientesDeMedico(usuarioEnSesion.id);
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
                    hospital.mostrarMedicoPorId(usuarioEnSesion.id);
                    break;
                case 7:
                    System.out.println("\n-----Adiosito-----");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        } while (opc != 7);
    }

    public void login(){
        int intentosMaximos = 5, intentosUser=0;
        this.mostrarMenuAdmin(hospital.administrador);
        while(intentosUser < intentosMaximos){
            System.out.print("\n--------Bienvenido/a--------\n");
            System.out.println("---Inicia sesión para continuar---");

            scanner.nextLine();
            System.out.print("Ingrese su usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            usuarioEnSesion = hospital.validarInicioSesion(usuario,contrasena);

            if (usuarioEnSesion instanceof Usuario){
                if (usuarioEnSesion.getRol() == Rol.PACIENTE){
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    this.mostrarMenuPaciente(pacienteEnSesion);
                    intentosUser=0;
                }else if (usuarioEnSesion.getRol() == Rol.MEDICO){
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    this.mostrarMenuMedico(medicoEnSesion);
                    intentosUser=0;
                }else{
                    Administrador AdminEnSesion = (Administrador) usuarioEnSesion;
                    this.mostrarMenuAdmin(AdminEnSesion);
                    intentosUser=0;
                }
            }else{
                intentosUser= mostrarErrorInicioSesion(intentosUser);
            }
        }
        System.out.println("\nLímite de intentos alcanzado\n");
    }

    private int mostrarErrorInicioSesion(int intentosUser){
        System.out.print("\nUsuario o contraseña incorrecta, intente de nuevo\n");
        intentosUser++;
        return intentosUser;
    }

    private void mostrarMenuAdmin(Administrador admin) {
        int respuesta = 0;

        while (respuesta != 12) {
            System.out.println("Bienvenido " + admin.nombre);
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
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    String id = hospital.generarIdPaciente(), telefono="";
                    boolean existeNumTelefonoP = false;

                    System.out.println("-- Registrar paciente --");
                    System.out.print("Ingrese el/los nombre(s) del paciente: ");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese los apellido(s) del paciente: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese el año de nacimiento: ");
                    int ano = scanner.nextInt();

                    System.out.print("Ingrese el mes de nacimiento: ");
                    int mes = scanner.nextInt();

                    System.out.print("Ingrese el dia de nacimiento: ");
                    int dia = scanner.nextInt();

                    LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);

                    scanner.nextLine();
                    System.out.print("Ingrese su tipo de sangre: ");
                    String tipoSangre = scanner.nextLine();

                    System.out.print("Ingrese su sexo: ");
                    String sexoString = scanner.next();
                    char sexo = sexoString.charAt(0);
                    scanner.nextLine();

                    while(!existeNumTelefonoP) {
                        System.out.print("Ingrese el teléfono del paciente: ");
                        telefono = scanner.nextLine();
                        if (!hospital.validarNumeroTelefonoPaciente(telefono)){
                            System.out.println("\nEl número de telefono ya está en uso, ingrese otro por favor");
                        }else{
                            existeNumTelefonoP = true;
                        }
                    }

                    System.out.print("Ingrese la contrasenia del paciente: ");
                    String contrasenaPaciente = scanner.nextLine();


                    Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, telefono, contrasenaPaciente);
                    hospital.registrarPaciente(paciente);

                    System.out.println("\nPaciente registrado exitosamente");
                    break;
                case 2:
                    boolean existeNumTelefonoM = false, existeRFCM = false;
                    String telefonoM = "", rfc = "";
                    System.out.println("\n-- Registrar un médico --");

                    System.out.println("Ingrese el nombre del médico: ");
                    scanner.nextLine();
                    String nombreM = scanner.nextLine();
                    System.out.println("Ingrese el apellido del médico: ");
                    String apellidoM = scanner.nextLine();
                    
                    System.out.println("Ingrese el año de nacimiento: ");
                    int anoM = scanner.nextInt();

                    System.out.println("Ingrese el mes de nacimiento: ");
                    int mesM = scanner.nextInt();

                    System.out.println("Ingrese el dia de nacimiento: ");
                    int diaM = scanner.nextInt();
                    scanner.nextLine();

                    LocalDate fechaNacimientoM = LocalDate.of(anoM, mesM, diaM);

                    while(!existeNumTelefonoM){
                        System.out.println("Ingrese el teléfono del médico: ");
                        telefonoM = scanner.nextLine();

                        if (!hospital.validarNumTelefonoMedico(telefonoM)){
                            System.out.println("\nEl número de telefono ya está en uso, ingrese otro por favor");
                        }else{
                            existeNumTelefonoM = true;
                        }
                    }
                    while(!existeRFCM){
                        System.out.println("Ingrese el rfc del médico: ");
                        rfc = scanner.nextLine();

                        if (!hospital.validarRFCMedico(rfc)){
                            System.out.println("\nEl RFC ya está en uso, ingrese otro por favor");
                        }else{
                            existeRFCM = true;
                        }
                    }

                    System.out.print("Ingrese la constrasenia del medico: ");
                    String constraseniaMedico = scanner.nextLine();

                    String anioCadena = String.valueOf(fechaNacimientoM.getYear());

                    String idMedico = hospital.generarIdMedico(apellidoM, anioCadena);

                    Medico medico = new Medico(idMedico, nombreM, apellidoM, fechaNacimientoM, telefonoM, rfc, constraseniaMedico);
                    hospital.registrarMedico(medico);


                    System.out.println("\nMédico registrado exitosamente");
                    break;
                case 3:
                    System.out.println("\n-- Registrar un consultorio --");
                    String idConsultorio = hospital.generarIdConsultorio();

                    System.out.println("Ingrese el numero de piso del consultorio: ");
                    int piso = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el número del consultorio: ");
                    int numero = scanner.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio,piso,numero);
                    hospital.registrarConsultorio(consultorio);

                    System.out.println("\nConsultorio registrado exitosamente");
                    break;
                case 4:
                    System.out.println("\n-- Registrar una consulta --");
                    boolean banderaFechaConsulta = true;
                    LocalDateTime fechaConsulta = null;
                    String idConsulta = hospital.generarIdConsulta();

                    while(banderaFechaConsulta){
                        System.out.println("Ingrese el dia de la consulta deseada: ");
                        int diaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese el mes de la consulta deseada: ");
                        int mesConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese el año de la consulta deseada: ");
                        int anoConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese la hora de la consulta deseada: ");
                        int horaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese los minutos de la consulta deseada: ");
                        int minutosonsulta = scanner.nextInt();
                        scanner.nextLine();

                        fechaConsulta = LocalDateTime.of(
                                anoConsulta, mesConsulta,
                                diaConsulta, horaConsulta, minutosonsulta );

                        if (!hospital.validarFechaConsulta(fechaConsulta)){
                            System.out.println("\nLa fecha no puede estar en el pasado, intente de nuevo");
                        }else{
                            banderaFechaConsulta = false;
                        }
                    }

                    Paciente pacienteConsulta = null;
                    Medico medicoConsulta = null;
                    Consultorio consultorioConsulta = null;

                    while(pacienteConsulta == null){
                        System.out.println("Ingresa el id del paciente: ");
                        String pacienteId = scanner.nextLine();

                        pacienteConsulta =  hospital.obtenerPacientePorId(pacienteId);

                        if (pacienteConsulta == null){
                            System.out.println("\nPaciente no encontrado, intenta de nuevo");
                        }
                    }

                    while(medicoConsulta == null){
                        System.out.println("Ingresa el ID del Médico: ");
                        String MedicoId = scanner.nextLine();

                        medicoConsulta = hospital.obtenerMedicoPorId(MedicoId);

                        if (medicoConsulta == null){
                            System.out.println("\nMédico no encontrado, intenta de nuevo");
                        }
                    }

                    while(consultorioConsulta == null){
                        System.out.println("Ingresa el ID del consultorio: ");
                        String ConsultorioId = scanner.nextLine();

                        consultorioConsulta = hospital.obtenerConsultorioPorId(ConsultorioId);

                        if (consultorioConsulta == null){
                            System.out.println("\nConsultorio no encontrado, intenta de nuevo");
                        }
                    }

                    System.out.println();

                    Consulta nuevaConsulta = new Consulta(idConsulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta, Status.PENDIENTE);
                    if (hospital.validarConsulta(fechaConsulta, consultorioConsulta.piso , medicoConsulta.getId())) {
                        hospital.registrarConsulta(nuevaConsulta);
                        System.out.println("Consulta registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la consulta. El consultorio o el médico no están disponibles en esa fecha.");
                    }

                    break;
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
                    hospital.mostrarConsultas();
                    break;
                case 9:
                    System.out.println("\n-----Mostrar paciente por id-----");
                    System.out.println("Ingresa el id del paciente que deseas buscar: ");
                    String idPaciente = scanner.next();

                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("\n-----Mostrar médico por id-----");
                    System.out.println("Ingresa el id del medico que deseas buscar: ");
                    String idBusquedaMedico = scanner.next();

                    hospital.mostrarMedicoPorId(idBusquedaMedico);
                    break;
                case 11:
                    System.out.println("\n-----Mostrar consultorio por id-----");
                    System.out.println("Ingresa el id del consultorio que deseas buscar: ");
                    String idBusquedaConsul = scanner.next();

                    hospital.mostrarConsultorioPorId(idBusquedaConsul);
                    break;
                case 12:
                    System.out.println("\n-----Adiosito-----\n");
                    return;
            }
        }
        scanner.close();
    }
}
