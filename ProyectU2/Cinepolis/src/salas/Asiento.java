package salas;

import utils.EstadoAsiento;
import utils.TipoAsiento;

public class Asiento {
    public String Id; //// fila y columna
    public TipoAsiento tipo; // normal, VIP o premium
    public EstadoAsiento estado; // libre, ocupado, reservado
    public Double precio;

    public Asiento(TipoAsiento tipo) {
        this.tipo = tipo;
        this.estado = EstadoAsiento.DISPONIBLE;
        this.precio = calcularPrecio(tipo);
    }

    private Double calcularPrecio(TipoAsiento tipo) {
        switch (tipo) {
            case PREMIUM:
                return TipoAsiento.PREMIUM.getCosto();
            case VIP:
                return TipoAsiento.VIP.getCosto();
            default:
                return 100.0;
        }

    }

    public Double getPrecio() {
        return precio;
    }

    public String getId() {
        return Id;
    }

    public TipoAsiento getTipo() {
        return tipo;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public EstadoAsiento setEstado(EstadoAsiento estado) {
        return estado;
    }

    public String mostrarEstado() {
        return "Asiento{" +
                "estado=" + estado +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }


}
