package medicos;

import java.util.Random;

public class Medicos {
    public int id;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    private String telefono;
    private String rfc;
    Random rand = new Random();

    public Medicos(int id, String nombre, String apellido, String fechaNacimiento, String telefono, String rfc) {
        this.id = rand.nextInt(1, 10001);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
    }

    public int getId() {
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