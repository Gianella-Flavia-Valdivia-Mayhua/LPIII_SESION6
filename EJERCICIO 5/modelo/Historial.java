
package modelo;

import java.util.ArrayList;

public class Historial<T> {
    private ArrayList<T> operaciones;

    public Historial() {
        operaciones = new ArrayList<>();
    }

    public void agregar(T operacion) {
        operaciones.add(operacion);
    }

    public void mostrar() {
        if (operaciones.isEmpty()) {
            System.out.println("No hay operaciones registradas.");
        } else {
            for (int i = 0; i < operaciones.size(); i++) {
                System.out.println((i + 1) + ". " + operaciones.get(i));
            }
        }
    }

    public void limpiar() {
        operaciones.clear();
    }
}
