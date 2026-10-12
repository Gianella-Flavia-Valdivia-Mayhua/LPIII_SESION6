package controlador;

import modelo.Jugador;
import modelo.Enemigo;
import vista.CombateView;
import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;
    private Random aleatorio;

    public CombateController(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        vista = new CombateView();
        aleatorio = new Random();
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("Comenzando combate: ");

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            vista.mostrarEstado(jugador, enemigo);

            jugador.atacar(enemigo);
            vista.mostrarMensaje(jugador.getNombre() + " ataca a " + enemigo.getNombre());

            if (enemigo.getSalud() <= 0) {
                break;
            }

            if (aleatorio.nextBoolean()) {
                enemigo.atacar(jugador);
                vista.mostrarMensaje(enemigo.getNombre() + " ataca a " + jugador.getNombre());
            } else {
                vista.mostrarMensaje(enemigo.getNombre() + " no ataca este turno");
            }
        }

        vista.mostrarEstado(jugador, enemigo);

        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("El jugador ha sido derrotado");
        } else {
            vista.mostrarMensaje("¡El jugador ha ganado!");
        }
    }
}
