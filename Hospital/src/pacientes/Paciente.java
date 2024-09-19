package pacientes;

public class Paciente {
    public int id;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String tipoSangre;
    public char sexo;
    private String telefono;

    public Paciente(int id, String nombre, String apellido, String fechaNacimiento, String tipoSangre, char sexo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public String mostrarDatos() {
        return String.format("Id: %d, Nombre: %s, Apellidos: %s, Fecha de nacimiento: %s, Tipo de sangre: %s, Sexo: %s, Telefono: %s",
                id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, telefono);
    }
}
