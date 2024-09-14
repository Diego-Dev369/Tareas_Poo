package Repo_Tareas;

import java.util.ArrayList;

public class Estudiante {
    public String nombre;
    public String idEstudiante;
    public ArrayList<Curso> ListaCursos;

    public Estudiante(String idEstudiante, String nombre) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.ListaCursos = new ArrayList<>();
    }

    public void asignarCurso(Curso c) {
        this.ListaCursos.add(c);
        System.out.println("Curso asignado");
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public ArrayList<Curso> getListaCursos() {
        return ListaCursos;
    }
    public void setListaCursos(ArrayList<Curso> listaCursos) {
        ListaCursos = listaCursos;
    }
}
