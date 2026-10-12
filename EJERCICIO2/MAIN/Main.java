package MAIN;
import  CONTROLADOR_CARRITO.AutenticacionControlador;
import VISTA_CARRITO.AutenticacionVista;
import VISTA_CARRITO.CarritoVista;

public class Main {
    public static void main(String[] args) {
        AutenticacionVista authVista = new AutenticacionVista();
        CarritoVista carritoVista = new CarritoVista();
        
        AutenticacionControlador authControlador = new AutenticacionControlador(authVista, carritoVista);
        
        // Inicia el sistema pidiendo Registro o Login
        authControlador.iniciar();
    }
}
