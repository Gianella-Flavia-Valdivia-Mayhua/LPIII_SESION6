package VISTA_CARRITO;

import MODELO_CARRITO.Reseña;
import java.util.List;
import java.util.Scanner;

public class ResenaVista {
    private Scanner scanner = new Scanner(System.in);

    public Reseña pedirDatosResena(String correoUsuario) {
        System.out.println("\n--- DEJAR RESEÑA Y CALIFICACIÓN ---");
        System.out.print("Ingrese el ID del producto comprado: ");
        int idProd = scanner.nextInt();
        System.out.print("Ingrese calificación (1 a 5): ");
        int calif = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Escriba su comentario: ");
        String comentario = scanner.nextLine();
        return new Reseña(correoUsuario, idProd, calif, comentario);
    }

    public void mostrarResenas(List<Reseña> resenas) {
        System.out.println("\n--- RESEÑAS DE PRODUCTOS ---");
        if (resenas.isEmpty()) {
            System.out.println("No hay reseñas registradas.");
        } else {
            for (Reseña r : resenas) {
                System.out.println(r);
                System.out.println("--------------------------");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}
