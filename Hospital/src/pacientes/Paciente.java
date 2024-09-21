package pacientes;

public class Paciente {
    public String id;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String tipoSangre;
    public char sexo;
    private String telefono;

    public Paciente(String id, String nombre, String apellido, String fechaNacimiento, String tipoSangre, char sexo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public String mostrarDatos() {
        return String.format("Id: %s, Nombre: %s, Apellidos: %s," +
                        " Fecha de nacimiento: %s, Tipo de sangre: %s, " +
                        "Sexo: %s, Telefono: %s",
                id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, telefono);
    }

    // -----------------Getters y Setters--------------------------------------
    public String getApellido() {
        return apellido;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public char getSexo() {
        return sexo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getTipoSangre() {
        return tipoSangre;
    }
}
