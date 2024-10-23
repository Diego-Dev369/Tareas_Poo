package usuarios.pacientes;

import expedientes.Expediente;
import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;
    public Expediente expediente;
    public ArrayList<Expediente> expedientes = new ArrayList<>();


    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;

    }


    public String mostrarDatos() {
        String datosPaciente = String.format(" Tipo de sangre: %s, sexo: %s", tipoSangre, sexo);
        return super.mostrarInformacion() + datosPaciente;
    }

    public void registrarExpediente(Expediente expediente) {
        this.expedientes.add(expediente);
    }

    // -----------------Getters y Setters--------------------------------------

    public char getSexo() {return sexo;}
    public void setSexo(char sexo) {this.sexo = sexo;}
    public String getTipoSangre() {return tipoSangre;}
    public void setTipoSangre(String tipoSangre) {this.tipoSangre = tipoSangre;}
}
