package Repo_Tareas;

public class CalculadoraImpuestos {

    public int ingresos;
    public double porcentajeImpuestos;
    public double dividendos;
    public double exencion;

    public CalculadoraImpuestos(int ingresos, double porcentajeImpuestos, double dividendos, double exencion) {
        this.ingresos = ingresos;
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.dividendos = dividendos;
        this.exencion = exencion;
    }

    public double calcularImpuestos(int ingresos){
        return this.ingresos + .15f;
    }
    public double calcularImpuestos(int ingresos, double porcentajeImpuestos){
        return this.ingresos * (this.porcentajeImpuestos / 100);
    }
    public double calcularImpuestos(double porcentajeImpuestos, double dividendos, double exencion){
        double impuestos = this.dividendos * (this.porcentajeImpuestos / 100);
        if (impuestos > exencion){
            return impuestos - exencion;
        }else { return 0;}
    }
}
