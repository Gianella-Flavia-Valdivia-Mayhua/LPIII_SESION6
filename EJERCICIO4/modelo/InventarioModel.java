package modelo;
import java.util.List;
import java.util.ArrayList;

public class InventarioModel {
	private List<Item> items;
	
	public InventarioModel() {
	    items = new ArrayList<>();
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public void eliminarItem(Item item) {
		if(buscarItem(item.getNombre())) {
			items.remove(item);
		}else {
			throw new IllegalArgumentException("No existe ese item");
		}
	}
	
	public List<Item> obtenerItems() {
		return items;
	}
	
	public boolean buscarItem(String nombre) {
		for(Item i:items) {
			if(i.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	}
