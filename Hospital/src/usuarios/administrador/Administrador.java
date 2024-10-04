package usuarios.administrador;

import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {
    private double sueldo;
    final private String rfc;
    private int aniosTrabajados;

    public Administrador(String id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String rfc, String constrasenia, double sueldo, int aniosTrabajados) {
        super(id, nombre, apellido, fechaNacimiento, telefono, constrasenia, Rol.ADMIN);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.aniosTrabajados = aniosTrabajados;
    }

    //------------------------------Getters y Setters---------------------------------

    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}
    public String getRfc() {return rfc;}
    public int getAniosTrabajados() {return aniosTrabajados;}
    public void setAniosTrabajados(int aniosTrabajados) {this.aniosTrabajados = aniosTrabajados;}
}
