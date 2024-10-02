package consultas;

import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDateTime;

public class Consulta {
    public String id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(String id,LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    //------------------------------ Métodos ---------------------------------
    public String mostrarInformacion(){
        return String.format("\nId: %s, Fecha: %s, Id paciente: %s, Nombre paciente: %d, Id médico: %s, Nombre médico: %s, Piso consultorio: %d, Num. Concultorio: %d",
                id,
                fechaHora,
                paciente.getId(),
                paciente.getNombre(),
                medico.getId(),
                medico.getNombre(),
                consultorio.getPiso(),
                consultorio.getNumeroConsultorio()
        );
    }


    //------------------------------Getters y Setters---------------------------------

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public Medico getMedico() {return medico;}
    public void setMedico(Medico medico) {this.medico = medico;}
    public Paciente getPaciente() {return paciente;}
    public void setPaciente(Paciente paciente) {this.paciente = paciente;}
    public LocalDateTime getFechaHora() {return fechaHora;}
    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}
    public Consultorio getConsultorio() {return consultorio;}
    public void setConsultorio(Consultorio consultorio) {this.consultorio = consultorio;}
}