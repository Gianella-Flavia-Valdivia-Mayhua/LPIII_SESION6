package vista;

import modelo.Jugador;
import modelo.Enemigo;

public class CombateView {

    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("ESTADO DEL COMBATE");
        System.out.println(jugador);
        System.out.println(enemigo);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

