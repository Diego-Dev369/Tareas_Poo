package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medicos;
import pacientes.Paciente;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medicos> listaMedicos = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medicos medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
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

    public void mostrarPaciente() {
        if (listaPacientes.size() == 0) {
            System.out.println("No hay pacientes registrados");
        }

        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    public void mostrarMedico() {
        if (listaMedicos.size() == 0) {
            System.out.println("No hay medicos registrados");
        }

        for (Medicos medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatos());
        }
    }

    public void mostrarConsultorio() {
        if (listaConsultorios.size() == 0) {
            System.out.println("No hay consultorios registrados");
        }

        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarDatos());
        }
    }

    public void mostrarConsulta() {
        if (listaConsultas.size() == 0) {
            System.out.println("No hay consultas registradas");
        }

        for (Consulta consulta : this.listaConsultas) {
            System.out.println(consulta.mostrarDatos());
        }

    }

    public String generarIdPaciente() {
        //P-{año actual}--{mes actual}{longitudpacientes+1}{1,10000}
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacientesMasUno = this.listaPacientes.size() + 1;
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 100001);

        String id = String.format("P%d%d%d%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
        return id;
    }

    public String generarIdMedico(String apellido, LocalDate anioMedico) {
        //M-{Primeras 2 letras de su apellido} - {ultimo dígito de su año de nacimiento} - {año actual} - {numero aleatorio entre 50 y 700000} - {longitud de la lista de medicos + 1}
        Random random = new Random();
        String anioEnCadena = String.valueOf(anioMedico);
        LocalDate fecha = LocalDate.now();
        String primerasLetrasApellido = apellido.substring(0, 2).toUpperCase();
        String ultimoDigitoAnoNacimiento = anioEnCadena.substring(anioEnCadena.length() - 1).toUpperCase();
        int anoActual = fecha.getYear();
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 500001);
        int longitudMedicosMasUno = this.listaMedicos.size() + 1;


        String id = String.format("M%s%s%d%d%d", primerasLetrasApellido, ultimoDigitoAnoNacimiento, anoActual, numeroAleatorio, longitudMedicosMasUno);
        return id;
    }

    public String generarIdConsultorio() {
        //C-{longitud de la lista de consultorios + 1}-{dia actual}-{año actual}-{numero aleatorio entre 1 y 500000}
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int longitudConsultorioMasUno = this.listaConsultas.size() + 1;
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 500001);
        String id = String.format("C%d%d%d%d", longitudConsultorioMasUno, diaActual, anoActual, numeroAleatorio);
        return id;
    }

    public Paciente obtenerPacientePorId(String idPaciente) {
        return listaPacientes.stream().filter(p -> p.getId().equals(idPaciente)).findFirst().orElse(null);
    }


    public void mostrarPacientePorId(String idPaciente) {

        Paciente paciente = obtenerPacientePorId(idPaciente);
        if (paciente != null) {
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("No se encontró el paciente con el ID " + idPaciente);
        }
        /*for (Paciente paciente : this.listaPacientes){
            if(paciente.getId().equals(id)){
                System.out.println(paciente.mostrarDatos());
                return;
            }
        }
        System.out.println("Paciente no encontrado.");*/
    }

    public Medicos obtenerMedicoPorId(String idMedico) {
        return listaMedicos.stream().filter(p -> p.getId().equals(idMedico)).findFirst().orElse(null);
    }


    public void mostrarMedicoPorId(String idMedico) {
        Medicos medico = obtenerMedicoPorId(idMedico);
        if (medico != null) {
            System.out.println(medico.mostrarDatos());
        } else {
            System.out.println("No se encontró el medico con el ID " + idMedico);
        }

    }

    public Consultorio obtenerConsultorioPorId(String idConsultorio) {
        return listaConsultorios.stream().filter(p -> p.getId().equals(idConsultorio)).findFirst().orElse(null);
    }

    public void mostrarConsultorioPorId(String idConsultorio) {
        Consultorio consultorio = obtenerConsultorioPorId(idConsultorio);
        if (consultorio != null) {
            System.out.println(consultorio.mostrarDatos());
        } else {
            System.out.println("No se encontró el consultorio con el ID " + idConsultorio);
        }

    }

    public List<Medicos> listarMedicos() {
        return listaMedicos;
    }

    public void listarMedicosPorId() {
        List<Medicos> medicos = this.listarMedicos();
        if (medicos.isEmpty()) {
            System.out.println("No hay médicos registrados.");
            return;
        }
        System.out.println("Médicos registrados:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". ID: " + medicos.get(i).getId() + ", Nombre: " + medicos.get(i).getNombre() + " Apellidos: " + medicos.get(i).getApellidos() + " Fecha de nacimiento: " + medicos.get(i).getFechaNacimiento() + " Teléfono: " + medicos.get(i).getTelefono() + " RFC: " + medicos.get(i).getRfc());
        }
    }


    public List<Consultorio> getConsultorios() {
        return listaConsultorios;
    }

    public void listarConsultorios() {
        List<Consultorio> consultorios = this.getConsultorios();
        if (consultorios.isEmpty()) {
            System.out.println("No hay consultorios registrados.");
            return;
        }

        System.out.println("Consultorios registrados:");
        for (int i = 0; i < consultorios.size(); i++) {
            System.out.println((i + 1) + ". ID: " + consultorios.get(i).getId() +
                    ", Piso: " + consultorios.get(i).getPiso() + ", Número de Consultorio: " + consultorios.get(i).getNumeroConsultorio());
        }
    }
}
