package CONTROLADOR_CARRITO;
import MODELO_CARRITO.*;
import VISTA_CARRITO.CarritoVista;
import modelo.Carrito;
import modelo.Compra;
import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class CarritoControlador {
    private List<Producto> catalogo = new ArrayList<>();
    private Carrito carrito = new Carrito();
    private List<Compra> historialCompras = new ArrayList<>();
    private CarritoVista vista;
    private int contadorCompras = 1;

    public CarritoControlador(CarritoVista vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> agregarProductoCatalogo();
                case 2 -> vista.mostrarProductos(catalogo);
                case 3 -> agregarAlCarrito();
                case 4 -> verCarrito();
                case 5 -> eliminarDelCarrito();
                case 6 -> aplicarDescuento();
                case 7 -> verTotalYEnvio();
                case 8 -> realizarCompra();
                case 9 -> vista.mostrarHistorial(historialCompras);
                case 0 -> vista.mostrarMensaje("¡Gracias por usar el sistema!");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarProductoCatalogo() {
        Producto p = vista.pedirDatosProducto();
        catalogo.add(p);
        vista.mostrarMensaje("Producto agregado al catálogo correctamente.");
    }

    private void agregarAlCarrito() {
        int id = vista.pedirId("agregar al carrito");
        Producto p = catalogo.stream().filter(prod -> prod.getId() == id).findFirst().orElse(null);
        if (p != null) {
            carrito.agregarProducto(p);
            vista.mostrarMensaje("Producto añadido al carrito.");
        } else {
            vista.mostrarMensaje("Producto no encontrado en el catálogo.");
        }
    }

    private void verCarrito() {
        vista.mostrarDetalleCarrito(
            carrito.getProductos(),
            carrito.calcularSubtotal(),
            carrito.calcularMontoDescuento(),
            carrito.getCostoEnvio(),
            carrito.calcularTotal()
        );
    }

    private void eliminarDelCarrito() {
        int id = vista.pedirId("eliminar del carrito");
        if (carrito.eliminarProducto(id)) {
            vista.mostrarMensaje("Producto eliminado del carrito.");
        } else {
            vista.mostrarMensaje("El producto no estaba en el carrito.");
        }
    }

    private void aplicarDescuento() {
        double desc = vista.pedirDescuento();
        carrito.aplicarDescuento(desc);
        vista.mostrarMensaje("Descuento del " + desc + "% aplicado.");
    }

    private void verTotalYEnvio() {
        vista.mostrarMensaje("Costo de envío estimado: S/ " + String.format("%.2f", carrito.getCostoEnvio()));
        vista.mostrarMensaje("Total con envío y descuento: S/ " + String.format("%.2f", carrito.calcularTotal()));
    }

    private void realizarCompra() {
        if (carrito.getProductos().isEmpty()) {
            vista.mostrarMensaje("No se puede realizar la compra: El carrito está vacío.");
            return;
        }
        Compra nuevaCompra = new Compra(contadorCompras++, carrito.getProductos(), carrito.calcularTotal());
        historialCompras.add(nuevaCompra);
        carrito.vaciar();
        vista.mostrarMensaje("¡Compra realizada con éxito!");
    }
}
