
package controlador;

import modelo.CalculadoraGeneral;
import modelo.CalculadoraEstandar;
import modelo.CalculadoraCientifica;
import modelo.CalculadoraException;
import vista.CalculadoraView;

public class CalculadoraController {
    private CalculadoraView vista;

    public CalculadoraController(CalculadoraView vista) {
        this.vista = vista;
    }

    public void iniciar() {
        while (true) {
            try {
                int opcion = vista.mostrarMenuPrincipal();

                switch (opcion) {
                    case 1:
                        iniciarEstandar(new CalculadoraEstandar());
                        break;
                    case 2:
                        iniciarCientifica(new CalculadoraCientifica());
                        break;
                    case 0:
                        vista.mostrarMensaje("Saliendo de la calculadora...");
                        return;
                    default:
                        vista.mostrarMensaje("Opcion no valida.");
                }
            } catch (Exception e) {
                vista.mostrarMensaje("Ingrese una opcion numerica valida.");
                return;
            }
        }
    }

    private void iniciarEstandar(CalculadoraEstandar calculadora) {
        while (true) {
            try {
                int opcion = vista.mostrarMenuEstandar();
                double a;
                double b;
                double resultado;

                switch (opcion) {
                    case 1:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.sumar(a, b);
                        mostrarYGuardar(calculadora, a + " + " + b, resultado);
                        break;

                    case 2:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.restar(a, b);
                        mostrarYGuardar(calculadora, a + " - " + b, resultado);
                        break;

                    case 3:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.multiplicar(a, b);
                        mostrarYGuardar(calculadora, a + " * " + b, resultado);
                        break;

                    case 4:
                        a = vista.pedirNumero("Ingrese el dividendo: ");
                        b = vista.pedirNumero("Ingrese el divisor: ");
                        resultado = calculadora.dividir(a, b);
                        mostrarYGuardar(calculadora, a + " / " + b, resultado);
                        break;

                    case 5:
                        calculadora.mostrarHistorial();
                        break;

                    case 6:
                        calculadora.limpiarHistorial();
                        vista.mostrarMensaje("Historial limpiado.");
                        break;

                    case 0:
                        return;

                    default:
                        vista.mostrarMensaje("Opcion no valida.");
                }
            } catch (CalculadoraException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            } catch (Exception e) {
                vista.mostrarMensaje("Entrada no valida.");
                return;
            }
        }
    }

    private void iniciarCientifica(CalculadoraCientifica calculadora) {
        while (true) {
            try {
                int opcion = vista.mostrarMenuCientifico();
                double a;
                double b;
                double resultado;

                switch (opcion) {
                    case 1:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.sumar(a, b);
                        mostrarYGuardar(calculadora, a + " + " + b, resultado);
                        break;

                    case 2:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.restar(a, b);
                        mostrarYGuardar(calculadora, a + " - " + b, resultado);
                        break;

                    case 3:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.multiplicar(a, b);
                        mostrarYGuardar(calculadora, a + " * " + b, resultado);
                        break;

                    case 4:
                        a = vista.pedirNumero("Ingrese el dividendo: ");
                        b = vista.pedirNumero("Ingrese el divisor: ");
                        resultado = calculadora.dividir(a, b);
                        mostrarYGuardar(calculadora, a + " / " + b, resultado);
                        break;

                    case 5:
                        a = vista.pedirNumero("Ingrese la base: ");
                        b = vista.pedirNumero("Ingrese el exponente: ");
                        resultado = calculadora.potencia(a, b);
                        mostrarYGuardar(calculadora, a + " ^ " + b, resultado);
                        break;

                    case 6:
                        a = vista.pedirNumero("Ingrese el numero: ");
                        resultado = calculadora.raiz(a);
                        mostrarYGuardar(calculadora, "Raiz de " + a, resultado);
                        break;

                    case 7:
                        a = vista.pedirNumero("Ingrese el angulo en grados: ");
                        resultado = calculadora.seno(a);
                        mostrarYGuardar(calculadora, "Seno de " + a, resultado);
                        break;

                    case 8:
                        a = vista.pedirNumero("Ingrese el angulo en grados: ");
                        resultado = calculadora.coseno(a);
                        mostrarYGuardar(calculadora, "Coseno de " + a, resultado);
                        break;

                    case 9:
                        a = vista.pedirNumero("Ingrese el angulo en grados: ");
                        resultado = calculadora.tangente(a);
                        mostrarYGuardar(calculadora, "Tangente de " + a, resultado);
                        break;

                    case 10:
                        a = vista.pedirNumero("Ingrese un valor entre -1 y 1: ");
                        resultado = calculadora.arcoSeno(a);
                        mostrarYGuardar(calculadora, "Arco seno de " + a, resultado);
                        break;

                    case 11:
                        a = vista.pedirNumero("Ingrese un valor entre -1 y 1: ");
                        resultado = calculadora.arcoCoseno(a);
                        mostrarYGuardar(calculadora, "Arco coseno de " + a, resultado);
                        break;

                    case 12:
                        a = vista.pedirNumero("Ingrese un numero: ");
                        resultado = calculadora.arcoTangente(a);
                        mostrarYGuardar(calculadora, "Arco tangente de " + a, resultado);
                        break;

                    case 13:
                        a = vista.pedirNumero("Ingrese un numero positivo: ");
                        resultado = calculadora.logaritmo(a);
                        mostrarYGuardar(calculadora, "Logaritmo de " + a, resultado);
                        break;

                    case 14:
                        a = vista.pedirNumero("Ingrese el primer numero: ");
                        b = vista.pedirNumero("Ingrese el segundo numero: ");
                        resultado = calculadora.modulo(a, b);
                        mostrarYGuardar(calculadora, a + " % " + b, resultado);
                        break;

                    case 15:
                        calculadora.mostrarHistorial();
                        break;

                    case 16:
                        calculadora.limpiarHistorial();
                        vista.mostrarMensaje("Historial limpiado.");
                        break;

                    case 0:
                        return;

                    default:
                        vista.mostrarMensaje("Opcion no valida.");
                }
            } catch (CalculadoraException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            } catch (Exception e) {
                vista.mostrarMensaje("Entrada no valida.");
                return;
            }
        }
    }

    private void mostrarYGuardar(CalculadoraGeneral calculadora,
            String operacion, double resultado) {
        vista.mostrarResultado(resultado);
        calculadora.guardarOperacion(operacion + " = " + resultado);
    }
}
