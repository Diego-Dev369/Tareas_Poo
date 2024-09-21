package medicos;

import java.util.Random;

public class Medico {
    // Se cambio el tipo de dato int del id a String
    public String id;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    private String telefono;
    private String rfc;
    Random rand = new Random();

    public Medico(String id, String nombre, String apellido, String fechaNacimiento, String telefono, String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
    }

    //------------------------------Metodos para mostrar datos---------------------------------

    public String mostrarDatosDelMedico() {
        return String.format("Id: %s, Nombre: %s, Apellidos: %s," +
                " Fecha de nacimiento: %s", id, nombre,apellido,fechaNacimiento);
    }

    //------------------------------Getters y Setters---------------------------------

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getRfc() {
        return rfc;
    }
}