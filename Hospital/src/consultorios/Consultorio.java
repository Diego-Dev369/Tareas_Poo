package consultorios;

public class Consultorio {
    public String id;
    public int piso;
    public int numeroConsultorio;

    //Se cambio el tipo de dato del numero de consultorio por String ya
    // que daba error en la clase hospital, especificamente en el metodo registrarConsulta if #1
    public Consultorio(String id, int piso, int numeroConsultorio) {
        this.id = id;
        this.piso = piso;
        this.numeroConsultorio = numeroConsultorio;
    }

    //-----------------Método para mostrar los datos del consultorio :v--------------
    public String mostrarDatosConsultorio() {
        return String.format("Id: %s, Número de piso: %d, Número de consultorio: %s", id, piso, numeroConsultorio);
    }



    //---------------Getters y Setters-----------------
    public String getId() {
        return id;
    }
    public int getPiso() {
        return piso;
    }
    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }
}
