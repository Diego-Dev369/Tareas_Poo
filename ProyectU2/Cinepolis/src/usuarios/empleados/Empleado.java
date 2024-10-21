package usuarios.empleados;

import usuarios.Usuario;
import utils.Rol;

public class Empleado extends Usuario {
    private String rfc;

    public Empleado(String id, String nombre, String apellido, String telefono, String contrasenia, String rfc) {
        super(id, nombre, apellido, telefono,contrasenia, Rol.EMPLEADO);

        this.rfc = rfc;
    }
}
