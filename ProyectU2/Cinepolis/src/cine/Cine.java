package cine;

import compra.Compra;
import compra.boleto.Boleto;
import cartelera.Pelicula;
import dulceria.Inventario;
import salas.Asiento;
import salas.Sala;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.cliente.Cliente;
import usuarios.empleados.Empleado;
import utils.EstadoAsiento;
import utils.EstadoPelicula;
import utils.Rol;
import utils.TipoAsiento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Cine {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public ArrayList<Sala> listaSalas = new ArrayList<>();
    public ArrayList<Compra> listaCompras = new ArrayList<>();
    private Random random = new Random();
    public Scanner scanner = new Scanner(System.in);
    public Administrador administradorPredeterminado;
    public Cliente clientePredeterminado;
    LocalDate date = LocalDate.now();
    public ArrayList<Boleto> listaBoletos = new ArrayList<>();

    //mod para q funcionara
    public Cine() {
        this.administradorPredeterminado = new Administrador("A-1", "Admin", "1", "222", "ajcrrf", Rol.ADMINISTRADOR);
        this.clientePredeterminado = new Cliente("1","Cliente1", "1", "1","1" ,date, "33", "33");
        this.listaAdministradores.add(this.administradorPredeterminado);
        this.listaUsuarios.add(this.administradorPredeterminado);
        this.listaClientes.add(this.clientePredeterminado);
        this.listaUsuarios.add(this.clientePredeterminado);
    }

    //------------- Métodos de Agregación -----------------

    public void agregarPeliculaALista(Pelicula pelicula) {
        this.listaPeliculas.add(pelicula);
    }

    //--------------Métodos para generar id´s------------

    public String generarIdPelicula() {
        // p - {longitud usuarios.pacientes +1} - {1-100000}
        int longitudPeliculaMasUno = this.listaPeliculas.size() + 1;
        int numeroAleatorio = random.nextInt(1, 100000);

        return String.format("P-%d-%d", longitudPeliculaMasUno, numeroAleatorio);
    }

    public String generarIdCliente() {  // ID que inicie con C - año actual - mes actual - listaClientes+1 - random 1/100000
        Random random = new Random();

        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudClientes = this.listaClientes.size() + 1;
        int numeroAleatorio = random.nextInt(10000);

        String id = String.format("C%d%d%d%d",
                anoActual, mesActual, longitudClientes, numeroAleatorio);

        return id;
    }

    public String generarIdEmpleado() {  // ID que inicie con E - año actual - mes actual - listaEmpleados+1 - random 1/100000

        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudEmpleados = this.listaEmpleados.size() + 1;
        int numeroAleatorio = random.nextInt(10000);

        return String.format("E-%d-%d-%d-%d", anoActual, mesActual, longitudEmpleados, numeroAleatorio);
    }

    public String generarIdCompra() {  // ID que inicie con E - año actual - mes actual - listaEmpleados+1 - random 1/100000

        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudListaCompras = this.listaCompras.size() + 1;
        int numeroAleatorio = random.nextInt(10000);

        return String.format("VTA-%d-%d-%d-%d", anoActual, mesActual, longitudListaCompras, numeroAleatorio);
    }

    //------------Métodos para C.R.U.D----------------

    public void registrarPelicula() {
        boolean continuar;
        do {
            System.out.println("Registro de una película");
            String id = this.generarIdPelicula();
            System.out.print("Ingrese el título: ");
            String titulo = scanner.nextLine();

            int duracion;
            while (true) {
                System.out.print("Ingrese la duración (min): ");
                if (scanner.hasNextInt()) {
                    duracion = scanner.nextInt();
                    scanner.nextLine();
                    if (duracion > 0) {
                        break;
                    } else {
                        System.out.println("La duración debe ser un número positivo. Intente de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Debe ingresar un número entero.");
                    scanner.nextLine();
                }
            }

            System.out.print("Ingrese el género: ");
            String genero = scanner.nextLine();
            System.out.print("Ingrese la clasificación: ");
            String clasificacion = scanner.nextLine();
            System.out.print("Ingrese la sinopsis: ");
            String sinopsis = scanner.nextLine();

            System.out.println("Seleccione el estado de la película:" +
                    "\n1. Estado Actual \n" +
                    "2. Estado Próximamente");
            System.out.print("Selección: ");
            int estado;
            while (true) {
                estado = scanner.nextInt();
                scanner.nextLine();
                if (estado == 1 || estado == 2) {
                    break;
                } else {
                    System.out.println("Selección no válida. Intente de nuevo (1 o 2).");
                }
            }

            Pelicula pelicula;
            if (estado == 1) {
                pelicula = new Pelicula(id, titulo, duracion, genero, clasificacion, sinopsis, EstadoPelicula.ACTUAL);
            } else {
                pelicula = new Pelicula(id, titulo, duracion, genero, clasificacion, sinopsis, EstadoPelicula.PROXIMAMENTE);
            }

            boolean agregarOtraFuncion;
            do {
                System.out.println("Ingrese la hora y los minutos de la función: ");
                int hora;
                do {
                    System.out.print("Ingrese la hora (0-23): ");
                    hora = scanner.nextInt();
                    scanner.nextLine();
                    if (hora < 0 || hora > 23) {
                        System.out.println("La hora debe estar entre 0 y 23, intente de nuevo");
                    }
                } while (hora < 0 || hora > 23);

                int minutos;
                do {
                    System.out.print("Ingrese los minutos (0-59): ");
                    minutos = scanner.nextInt();
                    scanner.nextLine();
                    if (minutos < 0 || minutos > 59) {
                        System.out.println("Los minutos deben estar entre 0 y 59, intente de nuevo");
                    }
                } while (minutos < 0 || minutos > 59);

                LocalTime funcion = LocalTime.of(hora, minutos);
                pelicula.agregarFuncion(funcion);

                System.out.println("\n¿Desea agregar otra función? S/N");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                agregarOtraFuncion = respuesta.equals("s");
            } while (agregarOtraFuncion);

            this.agregarPeliculaALista(pelicula);
            System.out.println("Registro exitoso");

            System.out.print("¿Quiere agregar otra película? s/n: ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s");
        } while (continuar);
    }


    public void actualizarDatosPelicula(String idPelicula) {
        Optional<Pelicula> peliculaEncontrada = this.listaPeliculas.stream().filter(
                pelicula -> pelicula.getId().equals(idPelicula)).findFirst();

        if (peliculaEncontrada.isPresent()) {
            System.out.println("--Actualice los datos--");
            System.out.println("Titulo actual: " + peliculaEncontrada.get().getTitulo());
            scanner.nextLine();
            System.out.println("Nuevo Titulo: ");
            String nuevoTitulo = scanner.nextLine();

            int duracion = 0;
            boolean bandDuracion = false;
            System.out.println("Duracion actual: " + peliculaEncontrada.get().getDuracion());
            do {
                // Posible expansion de condición para los horarios >:(
                System.out.println("Nueva Duración (en minutos): ");
                //Esto en caso de que nos equivoquemos e ingresemos una letra, que no se cierre el programa :)
                if (scanner.hasNextInt()) {
                    duracion = scanner.nextInt();
                    bandDuracion = true;
                } else {
                    System.out.println("Ingresa un valor entero, intenta de nuevo");
                    scanner.next();
                }
            } while (!bandDuracion);

            scanner.nextLine();
            System.out.println("Género actual: " + peliculaEncontrada.get().getGenero());
            System.out.println("Nuevo Género: ");
            String genero = scanner.nextLine();

            System.out.println("Clasificación actual: " + peliculaEncontrada.get().getClasificacion());
            System.out.println("Nueva Clasificación: ");
            String clasificacion = scanner.nextLine();

            System.out.println("Sinopsis Actual: " + peliculaEncontrada.get().getSinopsis());
            System.out.println("Nueva Sinopsis: ");
            String sinopsis = scanner.nextLine();

            boolean bandEstado = false;
            int seleccion;
            System.out.println("Estado de pelicula actual: " + peliculaEncontrada.get().getEstado());
            while (!bandEstado) {
                System.out.println("Nuevo Estado de la pelicula:" +
                        "\n1. Estado Actual \n" +
                        "2. Estado Proximamente");
                System.out.print("Selección: ");
                //Otra vez de que si nos equivoquemos e ingresemos una letra, que no se cierre el programa
                if (scanner.hasNextInt()) {
                    seleccion = scanner.nextInt();
                    if (seleccion == 1) {
                        peliculaEncontrada.get().setEstado(EstadoPelicula.ACTUAL);
                        bandEstado = true;
                    } else if (seleccion == 2) {
                        peliculaEncontrada.get().setEstado(EstadoPelicula.PROXIMAMENTE);
                        bandEstado = true;
                    } else {
                        System.out.println("Opción no válida, intente de nuevo.");
                    }
                } else {
                    System.out.println("Ingresa un valor entero, intenta de nuevo");
                    scanner.next(); // Limpiar la entrada no válida <:}
                }
            }

            peliculaEncontrada.get().setTitulo(nuevoTitulo);
            peliculaEncontrada.get().setDuracion(duracion);
            peliculaEncontrada.get().setGenero(genero);
            peliculaEncontrada.get().setClasificacion(clasificacion);
            peliculaEncontrada.get().setSinopsis(sinopsis);
        } else {
            System.out.println("\nPelicula no encontrada");
        }
    }

    public void eliminarPelicula(String idPelicula) {
        for (Pelicula pelicula : this.listaPeliculas) {
            if (pelicula.getId().equals(idPelicula)) {
                this.listaPeliculas.remove(pelicula);
                return;
            }
        }
    }

    //----------- Validaciones -----------

    public Usuario validarInicioSesion(String idUsuario, String contrasena) {
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasena)) {
                return usuario;
            }

        }
        return null;
    }

    //--------------Métodos para mostrar datos----------------

    public void mostrarAsientos() {

        //String mostrarAsientos [] [];
        String butacas[] = {"A", "B", "C", "D", "E", "F"};
        int filas = 6, columnas = 6, columna;
        int fila;

        String mostrarAsientos[][] = new String[filas][columnas];

        //// llenar la matriz
        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                mostrarAsientos[fila][columna] = butacas[fila] + String.valueOf(columna + 1);
            }
        }

        System.out.println("\t\tPANTALLA\n========================");

        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                System.out.print(mostrarAsientos[fila][columna] + "\t");

            }
            System.out.println("\t");
        }
    }

    public void mostrarCartelera() {
        int i = 1;
        System.out.println("=====================================");
        System.out.println("             CARTELERA               ");
        System.out.println("=====================================");
        for (Pelicula pelicula : listaPeliculas) {
            System.out.println(i + ". " + String.format("Titulo: %s", pelicula.getTitulo()));
            System.out.println("   Clasificación: " + pelicula.getClasificacion());
            System.out.println("   Duración: " + pelicula.getDuracion() + " min");
            System.out.print("   Horarios: \n");
            for (LocalTime funcion : pelicula.getHorario()) {
                System.out.print(funcion + " - ");
            }
            System.out.println("\n-------------------------------------");
            i++;
        }
    }

    public String generarIdBoleto() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int numeroAleatorio = random.nextInt(10, 1000);
        String id = String.format("T%d%d%d", anoActual, mesActual, numeroAleatorio);
        return id;
    }

    public String buscarNombreClientePorId(String id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(id)) {
                return cliente.getNombre(); //modf
            }
        }
        return "El id es incorrecto";
    }

    public String buscarTituloPeliculaPorId(String id) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getId().equals(id)) {
                return pelicula.getTitulo();
            }
        }
        return "El id es incorrecto";
    }


    public final int FILAS = 6;
    public final int COLUMNAS = 6;
    public ArrayList<String> asientos;

    public void inicializar() {
        asientos = new ArrayList<>();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos.add((char) ('A' + i) + "" + (j + 1)); // Inicializa con A1, A2, ..., F6
            }
        }
    }

    public int obtenerIndicesAsiento(String idAsiento) {
        return asientos.indexOf(idAsiento);
    }

    public boolean estaReservado(int indice) {
        return indice >= 0 && asientos.get(indice).equals("X"); // Verifica si el asiento está reservado
    }

    public String reservarAsiento(String idAsiento) {
        int indice = obtenerIndicesAsiento(idAsiento);

        if (indice == -1) {
            return "El asiento " + idAsiento + " no existe.";
        }
        if (estaReservado(indice)) {
            return "El asiento " + idAsiento + " ya está ocupado.";
        } else {
            asientos.set(indice, "X"); // Marca el asiento como reservado
            return idAsiento;
        }
    }

    public void registrarBoleto(Boleto boleto) {
        this.listaBoletos.add(boleto);
    }

    public void mostrarBoletosTodos() {
        System.out.println("\n BOLETOS VENDIDOS");
        for (Boleto boleto : this.listaBoletos) {
            System.out.println(boleto.mostrarInformacion());
        }
    }

    public void mostrarClientesTodos() {
        System.out.println("\n CLIENTES REGISTRADOS");
        for (Cliente cliente : this.listaClientes) {
            System.out.println(cliente.mostrarInformacionCliente());
        }
        System.out.println();
    }

    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        this.listaUsuarios.add(cliente);
    }

    public void mostrarPeliculasTodas() {
        System.out.println("\n PELICULAS REGISTRADAS");
        for (Pelicula pelicula : this.listaPeliculas) {
            System.out.println(pelicula.mostrarInformacionpelicula());
        }
    }

    public int MesCumpleañosParaVerSiHayDescuento(String id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(id)) {
                int mes = cliente.getFechaNacimiento().getMonthValue();
                return mes;
            }
        }
        return 0;
    }

    public Pelicula seleccionarPelicula() {
        System.out.println("Selecciona el número de la película que deseas ver:");
        int opcion = scanner.nextInt();

        return listaPeliculas.get(opcion - 1);
    }

    public List<String> seleccionarAsientos() {
        Scanner scanner = new Scanner(System.in);
        List<String> asientosSeleccionados = new ArrayList<>();
        String asiento;

        System.out.println("Ingresa los asientos que deseas (ej. A1, B3) y escribe 'fin' para terminar:");

        while (true) {
            asiento = scanner.nextLine();
            if (asiento.equalsIgnoreCase("fin")) {
                break;
            }
            asientosSeleccionados.add(asiento);
        }

        return asientosSeleccionados;
    }

    public List<String> seleccionarArticulos() {
        Scanner scanner = new Scanner(System.in);
        List<String> articulosExtra = new ArrayList<>();
        String articulo;

        System.out.println("Selecciona los artículos extra (palomitas, refresco, etc.) y escribe 'fin' para terminar:");
        while (true) {
            articulo = scanner.nextLine();
            if (articulo.equalsIgnoreCase("fin")) {
                break;
            }
            articulosExtra.add(articulo);
        }
        return articulosExtra;
    }

    public void MetodoPago(double x, String id) {
        System.out.println("Deseas pagar en 1: efectivo o con 2: PAYPAL");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                // Pago en efectivo
                System.out.println("Has elegido pagar en efectivo. El monto a pagar es: $" + x);
                int y = 2;
                while (y == 2) {
                    System.out.println("¿Usuario ya pagó? 1: Sí, 2: No");
                    y = scanner.nextInt();
                    if (y == 1) {
                        System.out.println("Pago realizado con éxito.");
                    } else if (y == 2) {
                        System.out.println("Ingrese el pago a caja.");
                    } else {
                        System.out.println("Opción inválida. Por favor, elige 1 o 2.");
                    }
                }
                break;

            case 2:
                // Pago con PayPal
                boolean pagoExitoso = false;
                System.out.println("Has elegido pagar con PAYPAL. El monto a pagar es: $" + x);

                for (Cliente cliente : listaClientes) {
                    if (cliente.getId().equals(id)) {
                        String correo = cliente.getCorreoE();
                        while (!pagoExitoso) {
                            System.out.print("Ingresa la contraseña de tu correo (" + correo + "): ");
                            String contrasenia = scanner.nextLine();
                            String usercontra = cliente.getContrasenia();

                            if (contrasenia.equals(usercontra)) {
                                System.out.println("Pago realizado con éxito.");
                                pagoExitoso = true;
                                break;
                            } else {
                                System.out.println("Contraseña incorrecta. Vuelve a intentarlo.");
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Selecciona 1 o 2.");
                break;
        }
    }
}