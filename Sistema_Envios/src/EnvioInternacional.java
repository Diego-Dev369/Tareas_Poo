public class EnvioInternacional extends Envio {

    String envioInternacional;

    public EnvioInternacional(Double costoBase, Double peso, String envioInternacional) {
        super(costoBase, peso);
        this.envioInternacional = envioInternacional;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempoEntrega = 10;
        if (getPeso() > 10) {
            tiempoEntrega += 3;
        }

        double costoEntrega = getCostoBase();
        if (!this.envioInternacional.equalsIgnoreCase("Mexico")) {
            costoEntrega += getCostoBase() * .20;
        }

        return String.format("Peso valido: %.2f kg\n" +
                "Envio internacional - Costo total: %.2f, Tiempo de entrega: %d", getPeso(), costoEntrega, tiempoEntrega) + " dias";
    }
}
