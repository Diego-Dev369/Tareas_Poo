import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el año actual: ");
        int a = sc.nextInt();

        Coche coche1 = new Coche("Ferrari", "448 GBT", 2020);
        Coche coche2 = new Coche("Tesla", "Modelo 3", 2022);
        Coche coche3 = new Coche("Honda", "Civic", 2024);

        coche1.mostrarInformacion();
        System.out.println("Edad del coche: " + coche1.calcularEdadDelCoche(a) + " Año(s)");
        coche2.mostrarInformacion();
        System.out.println("Edad del coche: " + coche2.calcularEdadDelCoche(a) + " Año(s)");
        coche3.mostrarInformacion();
        System.out.println("Edad del coche: " + coche3.calcularEdadDelCoche(a) + " Año(s)");
    }
}
