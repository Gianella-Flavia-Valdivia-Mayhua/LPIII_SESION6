package controlador;
import modelo.InventarioModel;
import modelo.Item;
import vista.InventarioView;
public class InventarioController {
  private InventarioModel inventario;
  private InventarioView vista;
  public InventarioController() {
  inventario=new InventarioModel();
  vista=new InventarioView();
  }
  public void agregarItem(Item i) {
    inventario.agregarItem(i);
  }
  public void eliminarItem(Item i) {
    inventario.eliminarItem(i);
  }
  public void verInventario() {
    vista.mostrarInventario(inventario.obtenerItems());
  }
  public void mostrarDetalles(Item item) {
    vista.mostrarDetallesitem(item);
  }
  public void buscarItem(String nombre) {
    if(inventario.buscarItem(nombre)) {
      vista.mostrarMensaje("Se encontro el item");
    }else {
      vista.mostrarMensaje("No se encontro el item");
    }
    }
}
