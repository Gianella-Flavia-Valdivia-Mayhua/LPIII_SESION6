
package modelo;

public class CalculadoraCientifica extends CalculadoraGeneral {
    public CalculadoraCientifica() {
        super();
    }

    public double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public double raiz(double a) throws CalculadoraException {
        if (a < 0) {
            throw new CalculadoraException("No se puede calcular la raiz de un numero negativo.");
        }
        return Math.sqrt(a);
    }

    public double seno(double a) {
        return Math.sin(Math.toRadians(a));
    }

    public double coseno(double a) {
        return Math.cos(Math.toRadians(a));
    }

    public double tangente(double a) throws CalculadoraException {
        if (Math.abs(Math.cos(Math.toRadians(a))) < 0.0000001) {
            throw new CalculadoraException("La tangente no esta definida para ese angulo.");
        }
        return Math.tan(Math.toRadians(a));
    }

    public double arcoSeno(double a) throws CalculadoraException {
        if (a < -1 || a > 1) {
            throw new CalculadoraException("El valor debe estar entre -1 y 1.");
        }
        return Math.toDegrees(Math.asin(a));
    }

    public double arcoCoseno(double a) throws CalculadoraException {
        if (a < -1 || a > 1) {
            throw new CalculadoraException("El valor debe estar entre -1 y 1.");
        }
        return Math.toDegrees(Math.acos(a));
    }

    public double arcoTangente(double a) {
        return Math.toDegrees(Math.atan(a));
    }

    public double logaritmo(double a) throws CalculadoraException {
        if (a <= 0) {
            throw new CalculadoraException("El numero debe ser mayor que cero.");
        }
        return Math.log10(a);
    }

    public double modulo(double a, double b) throws CalculadoraException {
        if (b == 0) {
            throw new CalculadoraException("No se puede calcular el modulo entre cero.");
        }
        return a % b;
    }
}
