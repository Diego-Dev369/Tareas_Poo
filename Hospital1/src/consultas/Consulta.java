package consultas;

import medicos.Medicos;
import pacientes.Paciente;
import consultorios.Consultorio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {
    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medicos medico;
    public Consultorio consultorio;

   /* public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }*/

    public Consulta(LocalDateTime fechaHora, Paciente paciente, Medicos medico, Consultorio consultorio) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medicos getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public String mostrarDatos() {
        String datos = String.format("ID: %d, Fecha/Hora: %s, Paciente: %s, Médico: %s, Consultorio: %d", id, fechaHora, paciente, medico, consultorio);
        return datos;
    }
}
