public class Main {
    public static void main(String[] args) {
        Envio envioNacional = new EnvioNacional(300.00, 6.0, 600);
        envioNacional.validarPeso();
        System.out.println(envioNacional.calcularTiempoYCostoEntrega());

        System.out.println();

        Envio envioInternacional = new EnvioInternacional(500.00, 12.00, "Mexico");
        envioInternacional.validarPeso();
        System.out.println(envioInternacional.calcularTiempoYCostoEntrega());

    }
}
