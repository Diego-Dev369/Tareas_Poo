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

    public String mostrarDatos() {
        return String.format("Id: %s, Nombre: %s, Apellidos: %s," +
                        " Fecha de nacimiento: %s, Tipo de sangre: %s, " +
                        "Sexo: %s, Telefono: %s",
                id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
    }

    // -----------------Getters y Setters--------------------------------------

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public char getSexo() {return sexo;}
    public void setSexo(char sexo) {this.sexo = sexo;}
    public String getTipoSangre() {return tipoSangre;}
    public void setTipoSangre(String tipoSangre) {this.tipoSangre = tipoSangre;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
}
