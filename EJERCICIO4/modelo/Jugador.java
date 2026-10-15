package modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public void usarItem() {
        if (cantidad <= 0) {
            throw new ItemExcepcion("No hay cantidad disponible");
        }
        this.cantidad = cantidad - 1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new ItemExcepcion("Descripcion no permitida");
        }
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new ItemExcepcion("Tipo no permitido");
        }
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new ItemExcepcion("Cantidad invalida");
        }
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new ItemExcepcion("Nombre no permitido");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDescripcion: " + descripcion
                + "\nCantidad:" + cantidad + "\nTipo: " + tipo + "\n";
    }
}

