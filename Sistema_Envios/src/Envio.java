public abstract class Envio {
    double costoBase;
    double peso;

    public Envio(double costoBase, double peso) {
        this.costoBase = costoBase;
        this.peso = peso;
    }

    public abstract String calcularTiempoYCostoEntrega();

    public void validarPeso() {
        if (peso <= 0) {
            System.out.println("El peso no es válido, debe ser mayor que 0");
        } else {
            System.out.println("Peso aceptado");
        }
    }

    public Double getCostoBase() {
        return costoBase;
    }

    public Double getPeso() {
        return peso;
    }
}