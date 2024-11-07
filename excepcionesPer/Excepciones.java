package excepcionesPer;

public class Excepciones {

    public static class ProductoInvalidoException extends Exception {
        public ProductoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class PrecioInvalidoException extends Exception {
        public PrecioInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class CantidadInvalidaException extends Exception {
        public CantidadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
}
