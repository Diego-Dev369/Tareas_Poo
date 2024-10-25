package expedientes;

import consultas.Consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Expediente {
    public String id;
    public Consulta consulta;
    public String observaciones;
    public LocalDateTime fechaExpediente;
    private Random random = new Random();

    public Expediente(Consulta consulta, String observaciones) {
        this.id = this.generarId();
        this.consulta = consulta;
        this.fechaExpediente = LocalDateTime.now();
        this.observaciones = observaciones;
    }

    public String generarId() {
        // E -{año actual} - {mes actual} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int numeroAleatorio = random.nextInt(1,100000);

        return String.format("E-%d-%d-%d", anoActual, mesActual, numeroAleatorio);
    }
}
