package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import expedientes.Expediente;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.Usuario;
import utils.Rol;
import utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Hospital {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();
    private Random random = new Random();
    public Scanner scanner = new Scanner(System.in);
    public Expediente expediente;
    public Administrador administrador;
    //Datos de fecha de Admin
    public LocalDate fechaNacimientoAdmin = LocalDate.of(2004, 11, 23);

    public Hospital(){
        administrador = new Administrador("A","Administrador","1", fechaNacimientoAdmin,"44232323","Rt3","123","A@gmail.com",12.78, 5);
        this.listaUsuarios.add(administrador);
        this.listaAdministradores.add(administrador);
    }

    // -----------------------Métodos para C.R.U.D -------------------------------

    public void registrarPaciente(Paciente paciente) {
        this.listaUsuarios.add(paciente);
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
        this.listaUsuarios.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha.");
            return;
        }
        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha.");
            return;
        }
        this.listaConsultas.add(consulta);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void eliminarConsultaPorId(String idConsulta){
        for (Consulta consulta : this.listaConsultas) {
            if (consulta.getId().equals(idConsulta)) {
                this.listaConsultas.remove(consulta);
                return;
            }
        }
    }

    //----------------Métodos para Mostrar Datos ---------------------------------

    public void mostrarPaciente() {
        System.out.println("\n*** PACIENTES DEL HOSPITAL ***");
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay usuarios.pacientes registrados");
        }else{
            for (Paciente paciente : this.listaPacientes) {
                System.out.println(paciente.mostrarDatos());
            }
        }
    }

    public void mostrarMedico() {
        System.out.println("\n*** MÉDICOS DEL HOSPITAL ***");
        if (listaMedicos.isEmpty()) {
            System.out.println("No hay médicos registrados");
        }else {
            for (Medico medico : this.listaMedicos) {
                System.out.println(medico.mostrarDatosDelMedico());
            }
        }
    }

    public void mostrarConsultorio(){
        System.out.println("\n*** CONSULTORIOS DEL HOSPITAL ***");
        if (listaConsultorios.isEmpty()) {
            System.out.println("No hay usuarios.pacientes registrados");
        }else {
            for (Consultorio consultorio : this.listaConsultorios) {
                System.out.println(consultorio.mostrarDatosConsultorio());
            }
        }
    }

    public void mostrarPacientePorId(String id){
        Paciente paciente = obtenerPacientePorId(id);
        if (paciente != null) {
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("No se encontró el paciente con el ID " + id);
        }
    }

    public void mostrarAdministradorPorId(String id){
        Administrador administrador1 = obtenerAdministradorPorId(id);
        if (administrador1 != null) {
            System.out.println(administrador1.mostrarDatos());
        } else {
            System.out.println("No se encontró el paciente con el ID " + id);
        }
    }

    public void mostrarMedicoPorId(String id){
        Medico medico = obtenerMedicoPorId(id);
        if (medico != null) {
            System.out.println(medico.mostrarDatosDelMedico());
        } else {
            System.out.println("No se encontró el medico con el ID " + id);
        }

    }

    public void mostrarConsultorioPorId(String id){
        Optional<Consultorio> consultorioEncontrado = this.listaConsultorios.stream().filter(
                consultorio -> consultorio.getId().equals(id)).findFirst();
        if (consultorioEncontrado.isPresent()) {
            System.out.println("\n*** Consultorio con id: "+ consultorioEncontrado.get().getId() + " Encontrado ***");
            System.out.println(consultorioEncontrado.get().mostrarDatosConsultorio());
        }else{
            System.out.println("\nConsultorio no encontrado");
        }
    }

    public void mostrarConsultas(){
        if (listaConsultas.isEmpty()) {
            System.out.println("No existen consultas registradas");
            return;
        }
        System.out.println("Lista de consultas: ");
        for (Consulta consulta : this.listaConsultas) {
            System.out.println(consulta.mostrarInformacion());
        }
    }

    //Tarea 3-10-24
    public void mostrarConsultasMedicos(String id) {
        List<Consulta> consultasMedico = this.listaConsultas.stream()
                .filter(consulta -> consulta.getMedico().getId().equals(id))
                .toList();

        if (consultasMedico.isEmpty()) {
            System.out.println("\nNo tiene consultas registradas.");
        } else {
            System.out.println("\n*** Consultas del Médico ***");
            for (Consulta consulta : consultasMedico) {
                System.out.println(consulta.mostrarInformacion());
            }
        }
    }

    public void mostrarPacientesDeMedico(String id) {
        List<Paciente> pacientesMedico = this.listaConsultas.stream()
                .filter(consulta -> consulta.getMedico().getId().equals(id))
                .map(Consulta::getPaciente)
                .distinct()
                .toList();

        if (pacientesMedico.isEmpty()) {
            System.out.println("\nNo tiene usuarios.pacientes registrados.");
        } else {
            System.out.println("\n*** PACIENTES DEL MÉDICO ***");
            for (Paciente paciente : pacientesMedico) {
                System.out.println(paciente.mostrarDatos());
            }
        }
    }

    public void mostrarConsultasPacientes(String id) {
        List<Consulta> consultasPaciente = this.listaConsultas.stream()
                .filter(consulta -> consulta.getPaciente().getId().equals(id))
                .toList();

        if (consultasPaciente.isEmpty()) {
            System.out.println("\nNo tiene consultas registradas.");
        } else {
            System.out.println("\n*** Consultas del Paciente ***");
            boolean existenConsultasPendientes = false;
            for (Consulta consulta : consultasPaciente) {
                System.out.println(consulta.mostrarInformacion());
                if (consulta.getStatus() == Status.PENDIENTE) {
                    existenConsultasPendientes = true;
                }
            }
            if (!existenConsultasPendientes) {
                System.out.println("No tienes consultas pendientes.");
            }
        }
    }

    //--------------- Métodos para Obtener id´s---------------------

    public Paciente obtenerPacientePorId(String idP){
        return this.listaPacientes.stream().filter(
                paciente -> paciente.getId().equals(idP)
        ).findFirst().orElse(null);
    }

    public Administrador obtenerAdministradorPorId(String idP){
        return this.listaAdministradores.stream().filter(
                administrador -> administrador.getId().equals(idP)
        ).findFirst().orElse(null);
    }

    public Medico obtenerMedicoPorId(String idM){
        return listaMedicos.stream().filter(p -> p.getId().equals(idM)).findFirst().orElse(null);
    }

    public Consultorio obtenerConsultorioPorId(String idConsultorio) {
        return listaConsultorios.stream()
                .filter(p -> p.getId().equals(idConsultorio))
                .findFirst()
                .orElse(null);
    }

    public Consulta obtenerConsultaPorid(String idConsulta){
        for (Consulta consulta : this.listaConsultas) {
            if (consulta.getPaciente().getId().equals(idConsulta)) {
                return consulta;
            }
        }
        return null;
    }

    // ----------------------------Válidaciones-------------------------------------

    public boolean validarFechaConsulta(LocalDateTime fechaDeseada){
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }

    public boolean validarCorreoUsuarioIgual(ArrayList<? extends Usuario> listaUsuarios, String correo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().trim().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarRFCMedico(String rfc) {
        for (Medico medico : listaMedicos) {
            if (medico.getRfc().equals(rfc)) {
                return false;
            }
        }
        return true;
    }


    public Usuario validarInicioSesion(String idUser, String contrasena){
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idUser) && usuario.getContrasenia().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean validarConsulta(LocalDateTime fechaConsulta, int numeroConsultorio, String idMedico) {
        boolean disponibleConsultorio = validador.validarDisponibilidadEnFechaConsulta(fechaConsulta, numeroConsultorio, this.listaConsultas);
        boolean disponibleMedico = validador.validarDisponibilidadMedico(fechaConsulta, idMedico, this.listaConsultas);

        return disponibleConsultorio && disponibleMedico;
    }

    // -----------------Métodos para generar----------------------------
    public String generarIdPaciente() {
        // p -{año actual} - {mes actual} - {longitud usuarios.pacientes +1} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        //int longitudPacientesMasUno =  this.listaConsultas.size() + 1;
        int longitudPacientesMasUno =  this.listaPacientes.size() + 1;
        int numeroAleatorio = random.nextInt(1,100000);

        return String.format("P-%d-%d-%d-%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
    }

    public String generarIdMedico(String apellido, String fechaNacimiento) {
        if (apellido.length() < 2) {
            System.out.println("El apellido debe tener al menos 2 caracteres.");
            return null;
        }
        if (fechaNacimiento.length() < 1) {
            System.out.println("La fecha de nacimiento no puede estar vacía.");
            return null;
        }

        String primerasLetrasApellido = apellido.charAt(0) + "" + apellido.charAt(1);
        LocalDate fecha = LocalDate.now();

        char ultimoDigitoAnoNacimiento = fechaNacimiento.charAt(fechaNacimiento.length() - 1);
        int anoActual = fecha.getYear();
        int numAleatorio = random.nextInt(700000 - 50 + 1) + 50;
        int longitudMedicosMasUno = this.listaMedicos.size() + 1;

        return String.format("M-%s-%s-%d-%d-%d",
                primerasLetrasApellido, ultimoDigitoAnoNacimiento,
                anoActual, numAleatorio, longitudMedicosMasUno);
    }



    public String generarIdConsultorio(){
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int diaActual = fecha.getDayOfMonth();
        int numAleatorio = random.nextInt(500000) + 1;
        int longitudConsultorioMasUno =  this.listaConsultorios.size() + 1;

        return String.format("C-%d-%d-%d-%d", longitudConsultorioMasUno, diaActual, anoActual, numAleatorio);
    }

    public String generarIdConsulta(){
        int diaActual = LocalDate.now().getDayOfMonth();
        int numeroAleatorio = new Random().nextInt(100000 - 50) + 50;
        return String.format("C-%d-%d-%d", listaConsultorios.size() + 1, numeroAleatorio, diaActual);

    }

    //cuando medico quiera terminar una consulta
    public void generarExpedienteConsulta(String idConsulta, String idPaciente){
        Consulta consulta = this.obtenerConsultaPorid(idConsulta);
        Paciente paciente = this.obtenerPacientePorId(idPaciente);

        if (consulta == null) {
            System.out.println("No existe una consulta con el id proporcionado");
            return;
        }


        if (paciente == null) {
            System.out.println("No existe una consulta con el id proporcionado");
            return;
        }

        consulta.setStatus(Status.TERMINADA);

        //Eliminar consulta de lista de consultas
        this.eliminarConsultaPorId(idConsulta);


        System.out.println("Ingresa las observaciones finales de la consulta: ");
        String observaciones = scanner.nextLine();

        expediente = new Expediente(consulta, observaciones);

        //Registrar expediente al paciente
        paciente.registrarExpediente(expediente);
        System.out.println("Consulta finalizada");
    }
    
}