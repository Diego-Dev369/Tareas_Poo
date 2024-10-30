public class EnvioNacional extends Envio {
    private int distanciaKm;

    public EnvioNacional(Double costoBase, Double peso, int distanciaKm) {
        super(costoBase, peso);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempoEntrega = (distanciaKm / 200) + 1;

        double costoEntrega = getCostoBase();
        if (super.getPeso() > 5) {
            costoEntrega += getCostoBase() * .05;
        }
        return String.format("Peso válido: %.2f kg\n" +
                        "Envío nacional - Costo Total: %.2f, Tiempo de entrega: %d",
                getPeso(), costoEntrega, tiempoEntrega) + " dias";
    }
}

