package Repo_Tareas;

public class Curso {
    public String codigoCurso;
    public String nombreCurso;
    public String instructor;

    public Curso(String nombreCurso, String codigoCurso ,String instructor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.instructor = instructor;
    }

    public void mostrarInfoCurso(){
        System.out.println();
        System.out.println("Nombre Curso: " + this.nombreCurso);
        System.out.println("Codigo Curso: " + this.codigoCurso);
        System.out.println("\nInstructor: " + this.instructor);
    }












    public String getCodigoCurso() {
        return codigoCurso;
    }
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
