package modelo;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();
    private double porcentajeDescuento = 0.0;
    private double costoEnvio = 15.00; // Costo de envío base

    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void aplicarDescuento(double porcentaje) {
        this.porcentajeDescuento = porcentaje;
    }
    public double getCostoEnvio() {
        return productos.isEmpty() ? 0.0 : costoEnvio;
    }
    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal += p.getPrecio();
        }
        return subtotal;
    }
    public double calcularMontoDescuento() {
        return calcularSubtotal() * (porcentajeDescuento / 100);
    }
    public double calcularTotal() {
        if (productos.isEmpty()) return 0.0;
        return calcularSubtotal() - calcularMontoDescuento() + getCostoEnvio();
    }
    public void vaciar() {
        productos.clear();
        porcentajeDescuento = 0.0;
    }
}
