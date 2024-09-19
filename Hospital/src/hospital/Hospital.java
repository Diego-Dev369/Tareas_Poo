package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medicos;
import pacientes.Paciente;

import java.util.ArrayList;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medicos> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsulta = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medicos medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {
        // Paciente no tenga una consulta en esa fecha

        if (!validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsulta)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        this.listaConsulta.add(consulta);

        if (validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsulta)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha");
            return;
        }
    }


    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void mostrarPaciente(Paciente paciente) {
        System.out.println("\n*** PACIENTES DEL HOSPITAL ***");
        for (Paciente pasiente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    private boolean validarDisponibilidadMedico(String fehcaDeseada, int idMedico) {
        for (Consulta consulta : listaConsulta) {
            if (consulta.getFechaHora().equals(fehcaDeseada) && consulta.getMedico().getId() == idMedico) {
                return false;
            }
        }

        return true;
    }

    /*
    Trasladado a validarHopitl
    private boolean validarDisponibilidadEnFechaConsulta(String fechaDeseada, int numeroConsultorio) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.fechaHora.equals(fechaDeseada) && numeroConsultorio == consulta.consultorio.getNumeroConsultorio()) {
                return false;
            }
        }
        return true;
    }*/
}

