package vista;
import java.util.List;
import modelo.Item;

public class InventarioView {
	
	public void mostrarInventario(List<Item> items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	public void mostrarDetallesitem(Item item) {
		System.out.println(item);
	}
}
