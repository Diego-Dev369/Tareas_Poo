package usuarios;

import utils.Rol;

public class Usuario {
    public String id;
    public String nombre;
    public String apellido;
    private String telefono;
    public String contrasenia;
    public Rol rol;

    public Usuario(String id, String nombre, String apellido, String telefono, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    //----------Getters y Setters-------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() { return contrasenia;}

    public Rol getRol() { return rol; }
}

