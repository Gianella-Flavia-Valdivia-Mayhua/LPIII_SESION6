package MAIN;
import CONTROLADOR_CARRITO.CarritoControlador;
import VISTA_CARRITO.CarritoVista;

public class Main {
    public static void main(String[] args) {
        CarritoVista vista = new CarritoVista();
        CarritoControlador controlador = new CarritoControlador(vista);
        
        controlador.iniciar();
    }
}
