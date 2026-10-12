package CONTROLADOR_CARRITO;

import MODELO_CARRITO.*;
import VISTA_CARRITO.CarritoVista;
import VISTA_CARRITO.ResenaVista;
import modelo.Carrito;
import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class CarritoControlador {
    private static List<Producto> catalogo = new ArrayList<>();
    private static List<Compra> historialCompras = new ArrayList<>();
    private static List<Reseña> listaResenas = new ArrayList<>();
    
    private Carrito carrito = new Carrito();
    private CarritoVista vista;
    private ResenaVista resenaVista = new ResenaVista();
    private String correoUsuarioActual;
    private int contadorCompras = 1;
    private boolean haComprado = false; // Controla si puede reseñar

    public CarritoControlador(CarritoVista vista, String correoUsuarioActual) {
        this.vista = vista;
        this.correoUsuarioActual = correoUsuarioActual;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n--- SESIÓN: " + correoUsuarioActual + " ---");
            System.out.println("1. Agregar producto al catálogo");
            System.out.println("2. Listar productos disponibles");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Eliminar producto del carrito");
            System.out.println("6. Aplicar descuento (%)");
            System.out.println("7. Calcular envío y ver total");
            System.out.println("8. Realizar compra");
            System.out.println("9. Ver historial de compras");
            System.out.println("10. Dejar reseña y calificación (Requiere compra previa)");
            System.out.println("11. Ver reseñas de productos");
            System.out.println("0. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");
            
            opcion = vista.pedirId(""); // Reutiliza lectura numérica básica o escáner equivalente

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
                case 10 -> gestionarResena();
                case 11 -> resenaVista.mostrarResenas(listaResenas);
                case 0 -> vista.mostrarMensaje("Cerrando sesión...");
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
        vista.mostrarDetalleCarrito(carrito.getProductos(), carrito.calcularSubtotal(), carrito.calcularMontoDescuento(), carrito.getCostoEnvio(), carrito.calcularTotal());
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
        vista.mostrarMensaje("Descuento aplicado.");
    }

    private void verTotalYEnvio() {
        vista.mostrarMensaje("Total con envío: S/ " + String.format("%.2f", carrito.calcularTotal()));
    }

    private void realizarCompra() {
        if (carrito.getProductos().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
            return;
        }
        Compra nuevaCompra = new Compra(contadorCompras++, carrito.getProductos(), carrito.calcularTotal());
        historialCompras.add(nuevaCompra);
        haComprado = true; // Habilita el permiso para dejar reseñas
        carrito.vaciar();
        vista.mostrarMensaje("¡Compra realizada con éxito! Ahora puedes dejar reseñas.");
    }

    private void gestionarResena() {
        if (!haComprado) {
            resenaVista.mostrarMensaje("Acceso denegado: Debe realizar al menos una compra para dejar reseñas.");
            return;
        }
        Reseña nuevaResena = resenaVista.pedirDatosResena(correoUsuarioActual);
        listaResenas.add(nuevaResena);
        resenaVista.mostrarMensaje("¡Reseña registrada con éxito!");
    }
}
