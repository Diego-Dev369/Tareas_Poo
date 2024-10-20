package usuarios;

import utils.Rol;
import java.time.LocalDate;

public class Usuario {
    //Herencia
    public String id;
    public String nombre;
    public String apellido;
    public LocalDate fechaNacimiento;
    public String telefono;
    public Rol rol; // enum
    private String contrasenia;

    public Usuario(String id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rol = rol;
        this.contrasenia = contrasenia;
    }

    // -----------------Getters y Setters--------------------------------------

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getContrasenia() {return contrasenia;}
    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}
}
