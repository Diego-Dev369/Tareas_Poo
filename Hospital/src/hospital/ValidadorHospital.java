package hospital;

import consultas.Consulta;

import java.util.ArrayList;

public class ValidadorHospital {

    public boolean validarDisponibilidadEnFecha(String fehcaDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fehcaDeseada) && numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
                return false;
            }
        }
        return true;
    }
}
