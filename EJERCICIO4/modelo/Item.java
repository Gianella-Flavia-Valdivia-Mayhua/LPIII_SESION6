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
        if (cantidad <= 0) {
            throw new IllegalArgumentException("No hay cantidad disponible");
        }
        this.cantidad = cantidad - 1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripcion no permitida");
        }
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Tipo no permitido");
        }
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad invalida");
        }
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no permitido");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDescripcion: " + descripcion+ "\nCantidad:" + cantidad + "\nTipo: " + tipo + "\n";
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
