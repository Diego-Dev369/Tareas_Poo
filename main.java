package Repo_Tareas;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base=0, altura=0, sueldoBase, bonificacion, porcentajeImpuestos, dividendos, exencion;
        int horasExtra, ingresos;

        /*Rectangulo rectangulo = new Rectangulo(altura,base);

        System.out.print("Ingrese la base: ");
        base = sc.nextDouble();
        System.out.print("Ingrese la altura: ");
        altura = sc.nextDouble();
        rectangulo.base = base;
        rectangulo.altura = altura;

        System.out.println("Área: " + rectangulo.calcularArea(base,altura) + " u^2");
        System.out.println("Perimetro: " + rectangulo.calcularPerimetro(base,altura));

         */
        /*
        Empleado empleado;
        System.out.println("**Si un dato estará vacio poner 0 como respuesta");
        System.out.print("Ingrese su sueldo base: ");
        sueldoBase = sc.nextDouble();
        System.out.print("Ingrese su bonificacion: ");
        bonificacion = sc.nextDouble();
        System.out.print("Ingrese horas extra: ");
        horasExtra = sc.nextInt();
        
        empleado = new Empleado(sueldoBase,bonificacion,horasExtra);

        System.out.println("Respuesta");
        if (bonificacion==0 && horasExtra==0) {
            System.out.println(empleado.calcularSalario(sueldoBase));
        } else if (horasExtra == 0) {
            System.out.println(empleado.calcularSalario(sueldoBase,bonificacion));
        }else {
            System.out.println(empleado.calcularSalario(sueldoBase,bonificacion,horasExtra));
        }
         */
        CalculadoraImpuestos calculadora;
        System.out.println("**Si un dato estará vacio poner 0 como respuesta");
        System.out.print("Coloque sus ingresos: ");
        ingresos = sc.nextInt();
        System.out.print("Ingrese el porcentaje de impuestos: ");
        porcentajeImpuestos = sc.nextDouble();
        System.out.print("Ingrese los dividendos: ");
        dividendos = sc.nextDouble();
        System.out.print("Ingrese la exención: ");
        exencion = sc.nextDouble();
        System.out.println();
        
        calculadora = new CalculadoraImpuestos(ingresos, porcentajeImpuestos, dividendos, exencion);

        if (porcentajeImpuestos == 0 && dividendos == 0 && exencion == 0) {
            System.out.println("Impuestos a pagar: " + calculadora.calcularImpuestos(ingresos));
        } else if (dividendos == 0 && exencion == 0) {
            System.out.println("Impuestos a pagar: " + calculadora.calcularImpuestos(ingresos, porcentajeImpuestos));
        }else if (ingresos == 0){
            System.out.println("Impuestos a pagar: " + calculadora.calcularImpuestos(porcentajeImpuestos, dividendos, exencion));
        }
    }
}
