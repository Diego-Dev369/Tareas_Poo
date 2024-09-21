package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
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

    public void registrarConsulta(Consulta consulta) {
        // Paciente no tenga una consulta en esa fecha

        //Aqui daba error en el segundo parametro de validarDisponibilidadEnFecha()
        if (!validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        this.listaConsultas.add(consulta);
        if (validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha");
            return;
        }

    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    //----------------Métodos para Mostrar Datos ---------------------------------
    public void mostrarPaciente() {
        System.out.println("\n*** PACIENTES DEL HOSPITAL ***");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }
    public void mostrarMedico() {
        System.out.println("\n*** MÉDICOS DEL HOSPITAL ***");
        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatosDelMedico());
        }
    }

    public void mostrarConsultorio(){
        System.out.println("\n*** CONSULTORIOS DEL HOSPITAL ***");
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarDatosConsultorio());
        }
    }

    public void mostrarPacientePorId(String id){
        //Genericos el optional
        /*
            Un stream es una secuencia de elementos que permite realizar operaciones
            como filtrado, mapeo, o reducción de forma más funcional y declarativa
            en lugar de usar bucles tradicionales.
        */
        Optional<Paciente> pacienteEncontrado = this.listaPacientes.stream().filter(
                paciente -> paciente.getId().equals(id)
        ).findFirst();

        if (pacienteEncontrado.isPresent()) {
            System.out.println("\n*** Paciente con id: "+ pacienteEncontrado.get().getId() + " Encontrado ***");
            System.out.println(pacienteEncontrado.get().mostrarDatos());
        }else {
            System.out.println("\nPaciente no encontrado");
        }

         /*for (Paciente paciente : this.listaPacientes) {
            if (paciente.getId().equals(id)){
                System.out.println(paciente.mostrarDatos());
                return;
            }
        }
        System.out.println("Paciente no encontrado");

          */
    }

    public void mostrarMedicoPorId(String id){
        Optional<Medico> medicoEncontrado = this.listaMedicos.stream().filter(medico ->
                medico.getId().equals(id)).findFirst();

        if (medicoEncontrado.isPresent()) {
            System.out.println("\n*** Paciente con id: "+ medicoEncontrado.get().getId() + " Encontrado ***");
            System.out.println(medicoEncontrado.get().mostrarDatosDelMedico());
        }else{
            System.out.println("\nMédico no encontrado");
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

    // ----------------------------Válidaciones-------------------------------------
    private boolean validarDisponibilidadMedico(String fechaDeseada, int idMedico) {
        for (Consulta consulta : listaConsultas) {
            //Modificación de "consulta.getMedico().getId() == idMedico"
            // a
            // consulta.getMedico().getId().equals(idMedico) por ser ahora un String
            if (consulta.getFechaHora().equals(fechaDeseada) && consulta.getMedico().getId().equals(idMedico)) {
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

        String id = String.format("P%d%d%d%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
        return id;
    }
    public String generarIdMedico(String apellido, String fechaNacimiento){
        String primerasLetrasApellido= apellido.charAt(0)+"" + apellido.charAt(1);
        LocalDate fecha = LocalDate.now();

        char ultimoDigitoAnoNacimiento = fechaNacimiento.charAt(fechaNacimiento.length()-1);
        int anoActual = fecha.getYear();
        int numAleatorio = random.nextInt(700000-50+1) + 50;
        int longitudMedicosMasUno =  this.listaMedicos.size() + 1;

        String id = String.format("M%s%s%d%d%d",
                primerasLetrasApellido,ultimoDigitoAnoNacimiento,
                anoActual,numAleatorio,longitudMedicosMasUno);
        return id;
    }

    public String generarIdConsultorio(){
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int diaActual = fecha.getDayOfMonth();
        int numAleatorio = random.nextInt(500000) + 1;
        int longitudConsultorioMasUno =  this.listaConsultorios.size() + 1;

        return String.format("C%d%d%d%d", longitudConsultorioMasUno, diaActual, anoActual, numAleatorio);
    }
}