
package vista;

import java.util.Scanner;

public class CalculadoraView {
    private Scanner leer;

    public CalculadoraView() {
        leer = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("CALCULADORA");
        System.out.println("1. Calculadora estandar");
        System.out.println("2. Calculadora cientifica");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
        return leer.nextInt();
    }

    public int mostrarMenuEstandar() {
        System.out.println("\nCALCULADORA ESTANDAR");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Ver historial");
        System.out.println("6. Limpiar historial");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opcion: ");
        return leer.nextInt();
    }

    public int mostrarMenuCientifico() {
        System.out.println("\nCALCULADORA CIENTIFICA");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("6. Raiz cuadrada");
        System.out.println("7. Seno");
        System.out.println("8. Coseno");
        System.out.println("9. Tangente");
        System.out.println("10. Arco seno");
        System.out.println("11. Arco coseno");
        System.out.println("12. Arco tangente");
        System.out.println("13. Logaritmo base 10");
        System.out.println("14. Modulo");
        System.out.println("15. Ver historial");
        System.out.println("16. Limpiar historial");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opcion: ");
        return leer.nextInt();
    }

    public double pedirNumero(String mensaje) {
        System.out.print(mensaje);
        return leer.nextDouble();
    }

    public void mostrarResultado(double resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
