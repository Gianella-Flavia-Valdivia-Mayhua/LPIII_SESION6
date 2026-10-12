package main;
import controlador.InventarioController;
import modelo.Item;
public class main {
  public static void main(String[] args) {
    InventarioController control_inventario=new InventarioController();
    Item espada = new Item();
    espada.setNombre("Espada");
    espada.setCantidad(1);
    espada.setTipo("Arma");
    espada.setDescripcion("Espada de acero");
    Item pocion = new Item();
    pocion.setNombre("Pocion de vida");
    pocion.setCantidad(3);
    pocion.setTipo("Pocion");
    pocion.setDescripcion("Recupera salud");
    control_inventario.agregarItem(espada);
    control_inventario.agregarItem(pocion);
    control_inventario.verInventario();
}
