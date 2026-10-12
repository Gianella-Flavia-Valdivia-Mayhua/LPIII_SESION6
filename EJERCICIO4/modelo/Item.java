package modelo;

public class Item {
	private String nombre;
	private int cantidad;
	private String tipo;
	private String descripcion;
	private int danio;
	
	public Item(String nombre, int cantidad, String tipo, String descripcion, int danio) {
		setNombre(nombre);
		setCantidad(cantidad);
		setTipo(tipo);
		setDescripcion(descripcion);
		setDanio(danio);
	}
	public void usarItem() {
		if(cantidad>0) {
			this.cantidad=cantidad-1;
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Nombre: "+nombre+"\nDescripcion: "+descripcion+"\nCantidad: "+cantidad+"\nTipo: "+tipo+"\n";
	}
	
	public void setDanio(int danio) {
	    if (danio < 0 || danio > 10) {
	        throw new IllegalArgumentException("Daño inválido");
	    }
	    this.danio = danio;
	}
	public int getDanio() {
		return danio;
	}
}
