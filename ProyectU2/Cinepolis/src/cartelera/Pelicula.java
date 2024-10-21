package cartelera;

import utils.EstadoPelicula;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pelicula {
    public String id;
    public String titulo;
    public int duracion;
    public String genero;
    public String clasificacion;
    public String sinopsis;
    public EstadoPelicula estado;
    public ArrayList<LocalTime> Horario;

    public Pelicula(
            String id, String titulo, int duracion, String genero, String clasificacion, String sinopsis, EstadoPelicula estado) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.estado = estado;
        this.Horario = new ArrayList<>();
    }


    public void agregarFuncion(LocalTime funcion) {
        Horario.add(funcion);
    }
    public String mostrarInformacionpelicula() {
        return "Pelicula{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", genero='" + genero + '\'' +
                ", Clasificacion='" + clasificacion + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    //-------------Getters y Setters--------------
    public String getId() {
        return id;
    }
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public EstadoPelicula getEstado() {
        return estado;
    }
    public void setEstado(EstadoPelicula estado) {
        this.estado = estado;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public ArrayList<LocalTime> getHorario() {return Horario;}
    public void setHorario(ArrayList<LocalTime> horario) {Horario = horario;}

}
