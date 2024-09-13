package Repo_Tareas;

public class Empleado {
    public double salarioBase;
    public double bonificacion;
    public int horasBase;

    public Empleado(double salarioBase, double bonificacion, int horasBase) {
        this.bonificacion = bonificacion;
        this.horasBase = horasBase;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario(double salarioBase, double bonificacion, int horasExtras) {
        return (salarioBase + bonificacion + (20*horasExtras));
    }
    public double calcularSalario(double salarioBase) {
        return salarioBase;
    }
    public double calcularSalario(double salarioBase, double bonificacion) {
        return salarioBase + bonificacion;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public int getHorasBase() {
        return horasBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
