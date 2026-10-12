
package modelo;

public class CalculadoraGeneral {
    private Historial<String> historial;

    public CalculadoraGeneral() {
        historial = new Historial<>();
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) throws CalculadoraException {
        if (b == 0) {
            throw new CalculadoraException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    public void guardarOperacion(String operacion) {
        historial.agregar(operacion);
    }

    public void mostrarHistorial() {
        historial.mostrar();
    }

    public void limpiarHistorial() {
        historial.limpiar();
    }
}
