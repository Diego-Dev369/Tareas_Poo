package Repo_Tareas;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char opc = ' ';

        while (opc != 'n' || opc != 'N') {
            System.out.println("¿Quieres registrar un estudiante? (S/N)");
            if (opc == 's' || opc == 'S') {
                System.out.println("¿Cuántos cursos quieres registrar?");
                int nEstudiantes = sc.nextInt();
                for (int i = 0; i < nEstudiantes; i++) {
                    System.out.println("Registr0 de un estudiante");
                    //Crear un objeto estudiante
                    System.out.println("**Registro de estudiante**");
                    System.out.println("Ingrese el id del estudiante");
                    String id = sc.nextLine();

                    System.out.println("Ingrese el nombre del estudiante");
                    String nombre = sc.nextLine();

                    Estudiante est = new Estudiante(id, nombre);
                    System.out.println("Estudiante registrado");

                    //crear un objeto curso
                    System.out.println("¿Quieres Registrar un curso?");
                    opc = sc.next().charAt(0);
                    if (opc == 's' || opc == 'S') {
                        System.out.println("¿Cuántos cursos quieres registrar?");
                        int nCursos = sc.nextInt();
                        for (int i = 0; i < nCursos; i++) {
                            System.out.println("** Registro de curso "+ (i+1) + " **");
                            System.out.println("Ingrese nombre del curso");
                            String nombreCurso = sc.nextLine();

                            System.out.println("Ingrese el código del curso");
                            String codigoCurso = sc.nextLine();

                            System.out.println("Ingrese el nombre del instructor");
                            String instructor = sc.nextLine();

                            Curso curso = new Curso(nombreCurso, codigoCurso, instructor);
                            System.out.println("Curso registrado");
                        }

                    }

                }
            }


            }
        }












    }
}
