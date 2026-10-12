package main;

import modelo.Jugador;
import modelo.Enemigo;
import modelo.Item;
import controlador.InventarioController;
import controlador.CombateController;

public class main {
    public static void main(String[] args) {
        try {
            Jugador jugador = new Jugador("Gianella", 100, 1);
            Enemigo enemigo = new Enemigo("Goblin", 100, 1, "Bestia");

            InventarioController inventarioController = new InventarioController(jugador);

            Item espada = new Item("Espada", 1, "Arma", "Espada de combate", 8);

            inventarioController.agregarItem(espada);
            inventarioController.equiparObjeto(espada);
            inventarioController.verInventario();

            CombateController combateController =
                    new CombateController(jugador, enemigo);

            combateController.iniciarCombate();

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
