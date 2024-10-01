package pacientes;

import java.time.LocalDate;

public class Paciente {
    public String id;
    public String nombre;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public String tipoSangre;
    public char sexo;
    private String telefono;


    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String mostrarDatos() {
        String datos = String.format("ID: %s, Nombre: %s, Apellidos: %s, Fecha de Nacimiento: %s, Tipo de Sangre: %s, Sexo: %s, Teléfono: %s", this.id, this.nombre, this.apellidos, this.fechaNacimiento, this.tipoSangre, this.sexo, this.telefono, this.tipoSangre, this.sexo, this.telefono);
        return datos;
    }
}
