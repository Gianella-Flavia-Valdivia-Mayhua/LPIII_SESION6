CONTROLADOR:
package CONTROLADOR_CARRITO;

import MODELO_CARRITO.Usuario;
import VISTA_CARRITO.AutenticacionVista;
import VISTA_CARRITO.CarritoVista;
import java.util.ArrayList;
import java.util.List;

public class AutenticacionControlador {
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private AutenticacionVista vista;
    private CarritoVista carritoVista;

    public AutenticacionControlador(AutenticacionVista vista, CarritoVista carritoVista) {
        this.vista = vista;
        this.carritoVista = carritoVista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenuInicial();
            switch (opcion) {
                case 1 -> iniciarSesion();
                case 2 -> registrarUsuario();
                case 0 -> vista.mostrarMensaje("Saliendo del sistema...");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarUsuario() {
        String[] datos = vista.pedirDatosRegistro();
        // Verificar si ya existe
        boolean existe = usuariosRegistrados.stream().anyMatch(u -> u.getCorreo().equals(datos[1]));
        if (existe) {
            vista.mostrarMensaje("El correo ya está registrado.");
        } else {
            usuariosRegistrados.add(new Usuario(datos[1], datos[2], datos[0]));
            vista.mostrarMensaje("¡Usuario registrado con éxito!");
        }
    }

    private void iniciarSesion() {
        String[] datos = vista.pedirDatosLogin();
        Usuario usuarioEncontrado = usuariosRegistrados.stream()
                .filter(u -> u.getCorreo().equals(datos[0]) && u.getContrasena().equals(datos[1]))
                .findFirst()
                .orElse(null);

        if (usuarioEncontrado != null) {
            vista.mostrarMensaje("¡Bienvenido, " + usuarioEncontrado.getNombre() + "!");
            // Lanzar el controlador principal del Carrito y Reseñas pasando el usuario actual
            CarritoControlador carritoController = new CarritoControlador(carritoVista, usuarioEncontrado.getCorreo());
            carritoController.iniciar();
        } else {
            vista.mostrarMensaje("Correo o contraseña incorrectos.");
        }
    }
}
