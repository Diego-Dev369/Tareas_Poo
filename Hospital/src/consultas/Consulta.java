package consultas;

import consultorios.Consultorio;
import medicos.Medicos;
import pacientes.Paciente;

public class Consulta {
    public int id;
    public String fechaHora;
    public Paciente paciente;
    public Medicos medico;
    public Consultorio consultorio;

    public Consulta(int id, String fechaHora, Paciente paciente, Medicos medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public int getId() {
        return id;
    }

    public String getFechaHora() {
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
}