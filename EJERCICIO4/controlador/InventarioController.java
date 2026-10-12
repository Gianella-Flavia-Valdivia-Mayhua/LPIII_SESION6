package controlador;
import modelo.InventarioModel;
import modelo.Item;
import modelo.Jugador;
import vista.InventarioView;

public class InventarioController {
	private InventarioModel inventario;
    private InventarioView vista;
    private Jugador jugador;

    public InventarioController(Jugador jugador) {
        this.jugador = jugador;
        inventario = jugador.getInventario();
        vista = new InventarioView();
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
	
    public void equiparObjeto(Item item) {
        jugador.equiparObjeto(item);
    }
}
