package usuarios.cliente;

import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public LocalDate fechaNacimiento;
    final private String CURP;
    public String correoE;

    public Cliente(String id, String nombre, String apellido, String telefono, String contrasenia, LocalDate fechaNacimiento, String CURP, String correoE) {
        super(id, nombre, apellido, telefono,contrasenia, Rol.CLIENTE);
        this.fechaNacimiento = fechaNacimiento;
        this.correoE = correoE;
        this.CURP = CURP;
    }

    // Método para mostrar información del cliente

    public String mostrarInformacionCliente() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", curp='" + CURP + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", Correo Electronico='" + correoE + '\'' +
                '}';
    }


    //-------------Getters y Setters-------------

    public String getCorreoE() {
        return correoE;
    }
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }
    public String getCURP() {
        return CURP;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

