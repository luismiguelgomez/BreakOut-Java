package controlador;

import modelo.Juego; 
import vista.VentanaPrincipal;

public class Controller {

	private Juego juego;
	private VentanaPrincipal ventana;
	
	public Controller () {
		juego = new Juego();
		ventana = new VentanaPrincipal(this, juego.getANCHO(), juego.getALTO());
	}

	/**
	 * sirve para traer lo que tiene el juego
	 * @return datos juego
	 */
	public Juego getJuego() {
		return juego;
	}
	/**
	 * se utiliza para enviar datos al juego
	 * @param juego-es requerido para enviar un dato
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
}