package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();
    private Random random = new Random();

    // -----------------------Métodos para registros -------------------------------

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta, String idPaciente) {
        //No exista una consulta en la fecha y consultorio deseado
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha.");
            return;
        }
        //Validar disponibilidad medico
        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha.");
            return;
        }

        this.listaConsultas.add(consulta);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    //----------------Métodos para Mostrar Datos ---------------------------------

    public void mostrarPaciente() {
        System.out.println("\n*** PACIENTES DEL HOSPITAL ***");
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
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
            System.out.println("No hay pacientes registrados");
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

    //--------------- Métodos para Obtener id´s---------------------

    public Paciente obtenerPacientePorId(String idP){
        return this.listaPacientes.stream().filter(
                paciente -> paciente.getId().equals(idP)
        ).findFirst().orElse(null);

        //.trim() para eliminar espacios en blanco
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

    // ----------------------------Válidaciones-------------------------------------

    public boolean validarFechaConsulta(LocalDateTime fechaDeseada){
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }

    public boolean validarNumeroTelefonoPaciente(String numeroTelefono) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getTelefono().equals(numeroTelefono)) {
                return false;
            }
        }
        return true;
    }
    public boolean validarNumTelefonoMedico(String numeroTelefono) {
        for (Medico medico : listaMedicos) {
            if (medico.getTelefono().equals(numeroTelefono)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarRFCMedico(String rfc) {
        for (Medico medico : listaMedicos) {
            if (medico.getRfc().equals(rfc)) {
                return false;
            }
        }
        return true;
    }

    // -----------------Métodos para generar id´s----------------------------
    public String generarIdPaciente() {
        // p -{año actual} - {mes actual} - {longitud pacientes +1} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        //int longitudPacientesMasUno =  this.listaConsultas.size() + 1;
        int longitudPacientesMasUno =  this.listaPacientes.size() + 1;
        int numeroAleatorio = random.nextInt(1,100000);

        return String.format("P-%d-%d-%d-%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
    }

    public String generarIdMedico(String apellido, String fechaNacimiento){
        String primerasLetrasApellido= apellido.charAt(0)+"" + apellido.charAt(1);
        LocalDate fecha = LocalDate.now();

        char ultimoDigitoAnoNacimiento = fechaNacimiento.charAt(fechaNacimiento.length()-1);
        int anoActual = fecha.getYear();
        int numAleatorio = random.nextInt(700000-50+1) + 50;
        int longitudMedicosMasUno =  this.listaMedicos.size() + 1;

        return String.format("M-%s-%s-%d-%d-%d",
                primerasLetrasApellido,ultimoDigitoAnoNacimiento,
                anoActual,numAleatorio,longitudMedicosMasUno);
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
}