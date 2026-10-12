VISTA:
package VISTA_CARRITO;

import java.util.Scanner;

public class AutenticacionVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuInicial() {
        System.out.println("\n=== BIENVENIDO AL SISTEMA ===");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String[] pedirDatosRegistro() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String pass = scanner.nextLine();
        return new String[]{nombre, correo, pass};
    }

    public String[] pedirDatosLogin() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String pass = scanner.nextLine();
        return new String[]{correo, pass};
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}
