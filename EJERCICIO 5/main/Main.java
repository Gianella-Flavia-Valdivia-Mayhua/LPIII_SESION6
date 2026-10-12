
package main;

import vista.CalculadoraView;
import controlador.CalculadoraController;

public class Main {
    public static void main(String[] args) {
        CalculadoraView vista = new CalculadoraView();
        CalculadoraController controlador = new CalculadoraController(vista);

        controlador.iniciar();
    }
}
