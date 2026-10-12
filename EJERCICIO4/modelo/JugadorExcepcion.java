package modelo;

public class JugadorExcepcion extends RuntimeException {
    public JugadorExcepcion(String mensaje) {
        super(mensaje);
    }
}
