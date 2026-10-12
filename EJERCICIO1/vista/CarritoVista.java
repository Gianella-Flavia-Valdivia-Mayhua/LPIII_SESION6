package vista;
import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n        MENÚ CARRITO MVC         ");
        System.out.println("1. Agregar producto al catálogo");
        System.out.println("2. Listar productos disponibles");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento (%)");
        System.out.println("7. Calcular envío y ver total");
        System.out.println("8. Realizar compra");
        System.out.println("9. Ver historial de compras");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    public Producto pedirDatosProducto() {
        System.out.print("Ingrese ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        return new Producto(id, nombre, precio);
    }
    public int pedirId(String accion) {
        System.out.print("Ingrese ID del producto a " + accion + ": ");
        return scanner.nextInt();
    }
    public double pedirDescuento() {
        System.out.print("Ingrese el porcentaje de descuento (0 - 100): ");
        return scanner.nextDouble();
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
    public void mostrarDetalleCarrito(List<Producto> productos, double subtotal, double descuento, double envio, double total) {
        System.out.println("\n--- DETALLE DEL CARRITO ---");
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
            System.out.println("Subtotal: S/ " + String.format("%.2f", subtotal));
            System.out.println("Descuento: - S/ " + String.format("%.2f", descuento));
            System.out.println("Costo Envío: S/ " + String.format("%.2f", envio));
            System.out.println("TOTAL A PAGAR: S/ " + String.format("%.2f", total));
        }
    }
    public void mostrarHistorial(List<Compra> historial) {
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");
        if (historial.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (Compra c : historial) {
                System.out.print(c);
            }
        }
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}
CONTROLADOR:
