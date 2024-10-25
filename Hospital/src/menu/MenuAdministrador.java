package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import utils.Rol;
import utils.Status;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdministrador {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Administrador admin) {
        int respuesta=0;
            while (respuesta != 13) {
                System.out.println("\nBienvenido " + admin.nombre);
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
                        12.- Ver mi información
                        13.- Salir""");
                System.out.print("Elija una opción: ");
                respuesta = scanner.nextInt();
                return respuesta;

            }
            return 0;
    }

    public void procesarDatosMenu(int respuesta, Administrador administrador, Hospital hospital){
        switch (respuesta) {
            case 1:
                System.out.println("-- Registrar paciente --");

                String id = hospital.generarIdPaciente();
                ArrayList<String> datosPaciente = this.obtenerDatosComun(Rol.PACIENTE, hospital);

                System.out.print("Ingrese su tipo de sangre: ");
                String tipoSangre = scanner.nextLine();

                System.out.print("Ingrese su sexo: ");
                String sexoString = scanner.next();

                char sexo = sexoString.charAt(0);
                scanner.nextLine();

                Paciente paciente = new Paciente(
                        id,                                   // ID
                        datosPaciente.get(0),                 // Nombre
                        datosPaciente.get(1),                 // Apellido
                        LocalDate.parse(datosPaciente.get(2)),// Fecha de nacimiento
                        tipoSangre,                           // Tipo de sangre
                        sexo,                                 // Sexo
                        datosPaciente.get(3),                 // Teléfono
                        datosPaciente.get(4),                 // Contraseña
                        datosPaciente.get(5)                  // Email
                );
                hospital.registrarPaciente(paciente);

                System.out.println("\nPaciente registrado exitosamente");
                break;
            case 2:
                ArrayList<String> datosMedico = this.obtenerDatosComun(Rol.MEDICO, hospital);
                boolean existeRFCM = false;
                String rfc = "";
                String anioCadena = String.valueOf(datosMedico.get(2));
                String idMedico;

                while (!existeRFCM) {
                    System.out.println("\n-- Registrar un médico --");
                    System.out.print("Ingrese el RFC del médico: ");
                    rfc = scanner.nextLine().trim();

                    if (!hospital.validarRFCMedico(rfc)) {
                        System.out.println("\nEl RFC ya está en uso, ingrese otro por favor");
                    } else {
                        existeRFCM = true;
                    }
                }

                if (datosMedico.size() > 1) {
                    idMedico = hospital.generarIdMedico(datosMedico.get(1), anioCadena);
                } else {
                    System.out.println("Error: datosMedico no contiene suficientes elementos.");
                    return;
                }

                Medico medico = new Medico(
                        idMedico,                            // ID
                        datosMedico.get(0),                  // Nombre
                        datosMedico.get(1),                  // Apellido
                        LocalDate.parse(datosMedico.get(2)), // Fecha de nacimiento
                        datosMedico.get(3),                  // Teléfono
                        rfc,                                 // RFC
                        datosMedico.get(4),                  // Contraseña
                        datosMedico.get(5)                   // Email
                );
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
                //Ver mi información
                System.out.println("Mis Datos");
                hospital.mostrarAdministradorPorId(administrador.id);
                break;
            case 13:
                System.out.println("\n-----Adiosito-----\n");
                break;
        }
    }

    private ArrayList<String> obtenerDatosComun(Rol rol, Hospital hospital){
        String tipoUsuario = rol == Rol.PACIENTE ? "Paciente" : rol == Rol.MEDICO ? "Medico" : "Administrador";

        ArrayList<String> datos = new ArrayList<>();

        // 0 - Nombre jeje
        System.out.print("Ingrese el/los nombre(s) del "+tipoUsuario+": ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        datos.add(nombre);

        // 1 - Apellidos
        System.out.print("Ingrese los apellido(s) "+tipoUsuario+": ");
        String apellido = scanner.nextLine();
        datos.add(apellido);

        // 2 - Fecha de nacimiento
       datos.add(obtenerFechaNacimientoUsuario(tipoUsuario));

        // 3 - Telefono
        boolean telefonoValido = false;
        while (!telefonoValido) {
            System.out.print("Ingrese el teléfono del " + tipoUsuario + ": ");
            String telefono = scanner.nextLine().trim();
            boolean telefonoRepetidoPaciente = validarTelefonoRepetido(hospital.listaPacientes, telefono);
            boolean telefonoRepetidoMedico = validarTelefonoRepetido(hospital.listaMedicos, telefono);

            if (!telefonoRepetidoPaciente && !telefonoRepetidoMedico) {
                datos.add(telefono);
                telefonoValido = true;
            } else {
                System.out.println("El teléfono ya existe. Intente con otro.");
            }
        }

        // 4 - Contraseña
        System.out.print("Ingrese la contraseña "+tipoUsuario+": ");
        String contrasena = scanner.nextLine();
        datos.add(contrasena);

        // 5 - Email
        boolean correoValido = false;
        while (!correoValido) {
            System.out.println("Ingrese el correo electrónico " + tipoUsuario + ": ");
            String correo = scanner.nextLine().trim();
            boolean correoRepetidoPaciente = hospital.validarCorreoUsuarioIgual(hospital.listaPacientes, correo);
            boolean correoRepetidoMedico = hospital.validarCorreoUsuarioIgual(hospital.listaMedicos, correo);

            if (!correoRepetidoPaciente && !correoRepetidoMedico) {
                datos.add(correo);
                correoValido = true;
            } else {
                System.out.println("El correo ya existe. Intente con otro.");
            }
        }


        return datos;
    }

    //Generico
    //Contras: se le puede poner cualquier tipo de dato
    //Ventajas: Mandar listas de un solo tipo si extiende de ella, no puede aceptar de otro tipo de lista

    private boolean validarTelefonoRepetido(ArrayList<? extends Usuario> listaUsuarios, String telefono) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getTelefono().trim().equals(telefono)) {
                return true;
            }
        }
        return false;
    }

    private String obtenerFechaNacimientoUsuario(String tipoUsuario){
        boolean esFechaValida = false;
        LocalDate fechaNacimiento = LocalDate.now();
        while (!esFechaValida) {
            System.out.print("Ingrese el año de nacimiento " + tipoUsuario + ": ");
            int ano = scanner.nextInt();

            System.out.print("Ingrese el mes de nacimiento (1-12) " + tipoUsuario + ": ");
            int mes = scanner.nextInt();

            System.out.print("Ingrese el dia de nacimiento (1-30) " + tipoUsuario + ": ");
            int dia = scanner.nextInt();
            scanner.nextLine();

            // 2
            fechaNacimiento = LocalDate.of(ano, mes, dia);

            if (fechaNacimiento.isAfter(LocalDate.now())) {
                System.out.println("La fecha de nacimiento no puede ser posterior al dia de hoy");
                esFechaValida = false;
            }else{
                esFechaValida = true;
            }

        }
        return fechaNacimiento.toString();
    }
}

