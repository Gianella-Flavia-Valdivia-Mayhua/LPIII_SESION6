package modelo;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int idCompra;
    private List<Producto> productos;
    private double totalPagado;

    public Compra(int idCompra, List<Producto> productos, double totalPagado) {
        this.idCompra = idCompra;
        this.productos = new ArrayList<>(productos);
        this.totalPagado = totalPagado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Compra #").append(idCompra).append(" ---\n");
        for (Producto p : productos) {
            sb.append("  - ").append(p.getNombre()).append(" (S/ ").append(p.getPrecio()).append(")\n");
        }
        sb.append("Total Pagado: S/ ").append(String.format("%.2f", totalPagado)).append("\n");
        return sb.toString();
    }
}
