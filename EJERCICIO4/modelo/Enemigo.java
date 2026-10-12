package modelo;

public class Enemigo {
	private String nombre;
	private int salud;
	private int nivel;
	private String tipo;
	
	public Enemigo(String nombre, int salud, int nivel, String tipo) {
		setNombre(nombre);
		setSalud(salud);
		setNivel(nivel);
		setTipo(tipo);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if(tipo==null || tipo.isEmpty()) {
			throw new EnemigoExcepcion("Tipo no permitido");
		}
		this.tipo = tipo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		if(nivel<0 || nivel>30) {
			throw new EnemigoExcepcion("Nivel invalido");
		}
		this.nivel = nivel;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		if(salud <= 0 || salud > 100) {
			this.salud=0;
			throw new EnemigoExcepcion("Salud invalida");
		}
		this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre==null || nombre.isEmpty()) {
			throw new EnemigoExcepcion("Nombre no permitido");
		}
		this.nombre = nombre;
	}
	
	public void atacar(Jugador jugador) {
	    jugador.recibirDanio(10);
	}

	public void recibirDanio(int danio) {
	    setSalud(salud - danio);
	}
	
	@Override
	public String toString() {
	    return "Enemigo\n" +"Nombre: " + nombre +"\nSalud: " + salud +"\nNivel: " + nivel +"\nTipo: " + tipo;
	}
}

