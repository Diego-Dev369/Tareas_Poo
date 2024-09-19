import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        int respuesa = 0;

        while (respuesa != 7) {
            System.out.println("""
                    1.- Registrar paciente
                    2.- Registrar medico
                    3.- Registrar consultorio
                    4.- Registrar consulta
                    5.- Mostrar paciente
                    6.- Mostrar medico
                    7.- Mostrar consultorios
                    8.- Mostrar consulta
                    9.-Salir""");
            System.out.print("Eliga una opcion: ");
            respuesa = scaner.nextInt();

            switch (respuesa) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }

    }
}