package Repo_Tareas;

public class Rectangulo {

    public double base;
    public double altura;



    public Rectangulo(double base, double altura ) {
        this.altura = altura;
        this.base = base;
    }
    public Rectangulo(int base, int altura) {
        this.altura = (int) altura;
        this.base = (int) base;
    }

    //Getters
    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public double calcularArea(double base, double altura) {
        return this.base * this.altura;
    }
    public double calcularArea(int base, int altura) {
        return this.base * this.altura;
    }
    public double calcularPerimetro(int base, int altura) {
        return 2*(this.base+this.altura);
    }
    public double calcularPerimetro(double base, double altura) {
        return 2*(this.base+this.altura);
    }


}
