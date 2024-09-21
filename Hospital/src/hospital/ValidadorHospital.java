package hospital;

import consultas.Consulta;

import java.util.ArrayList;

public class ValidadorHospital {
// El segundo parametro del metodo se cambio de int a String
    public boolean validarDisponibilidadEnFecha(String fechaDeseada, String numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            //Corrección en la segunda condición del if debido a que el numero de consultorio se convirtió en un String
            if (consulta.getFechaHora().equals(fechaDeseada) && numeroConsultorio.equals(consulta.getConsultorio().getNumeroConsultorio())) {
                return false;
            }
        }
        return true;
    }
}
