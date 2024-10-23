
package usuarios.medicos;

import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;

public class Medico extends Usuario {
    // Se cambio el tipo de dato int del id a String

    final private String rfc;

    public Medico(String id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String rfc, String constrasenia) {
        super(id, nombre, apellido, fechaNacimiento, telefono, constrasenia, Rol.MEDICO);
        this.rfc = rfc;
    }

    //------------------------------Metodos para mostrar datos---------------------------------

    public String mostrarDatosDelMedico() {
       return   super.mostrarInformacion() + String.format("RFC: "+this.rfc);
    }

    //------------------------------Getters y Setters---------------------------------

    public String getRfc() {
        return rfc;
    }
}