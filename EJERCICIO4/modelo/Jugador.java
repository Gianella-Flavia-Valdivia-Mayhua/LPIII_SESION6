package modelo;

public class Jugador {
	private String nombre;
	private int salud;
	private int nivel;
	private InventarioModel inventario;
	private Item objeto_usado;
	
	public Jugador(String nombre, int salud, int nivel) {
		setNombre(nombre);
		setSalud(salud);
		setNivel(nivel);
		inventario=new InventarioModel();
		objeto_usado=null;
	}


	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
	    if (nivel < 0 || nivel>30) {
	        throw new JugadorExcepcion("Nivel invalido");
	    }
	    this.nivel = nivel;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
	    if (salud <= 0 || salud > 100) {
	    	this.salud=0;
	        throw new JugadorExcepcion("Salud invalida");
	    }
	    this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
	    if (nombre == null || nombre.isEmpty()) {
	        throw new JugadorExcepcion("Nombre no permitido");
	    }
	    this.nombre = nombre;
	}

	public InventarioModel getInventario() {
		return inventario;
	}

	public void atacar(Enemigo enemigo) {
		if(objeto_usado==null) {
			 throw new JugadorExcepcion("No hay objeto equipado");
		}else {
			enemigo.recibirDanio(objeto_usado.getDanio());
		}
	    
	}

	public void recibirDanio(int danio) {
	    setSalud(salud - danio);
	}
	
	public void equiparObjeto(Item item) {
	    if (!inventario.buscarItem(item.getNombre())) {
	        throw new JugadorExcepcion("El objeto no esta en el inventario");
	    }

	    objeto_usado = item;
	}
	@Override
	public String toString() {
	    return "Jugador\n" +"Nombre: " + nombre +"\nSalud: " + salud +"\nNivel: " + nivel;
	}
}
