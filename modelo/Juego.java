package modelo;

public class Juego {

	private int MAX_COL_LADRILLOS;
	private int MAX_FIL_LADRILLOS;
	private int puntuacion;
	private boolean estado;
	private Ladrillo ladrillos[][];
	private Bola bola;
	private int ANCHO;
	private int ALTO;
	private Jugador jugador;
	
	
	public Juego() {
		MAX_COL_LADRILLOS = 6;
		MAX_FIL_LADRILLOS = 3;
		ALTO = 500;
		ANCHO = 500;
		estado = true;
		puntuacion = 0;
		bola = new Bola(20, 20, 240, 325, 1, -2);
		jugador = new Jugador(100, 15, 200, 480);
		ladrillos = new Ladrillo[MAX_FIL_LADRILLOS][MAX_COL_LADRILLOS];
		inicializarLadrillos();
	}
	
	public void inicializarLadrillos() {
		for (int i = 0; i < MAX_FIL_LADRILLOS; i++) {
			for (int j = 0; j < MAX_COL_LADRILLOS; j++) {
				
				ladrillos[i][j] = new Ladrillo(40, 30, (j*60)+80, (i*100)+60);
			}
		}
	}
	
	public void reinicializar () {
		inicializarLadrillos();
		bola = new Bola(20, 20, 240, 325, 1, -2);
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Ladrillo[][] getLadrillos() {
		return ladrillos;
	}

	public void setLadrillos(Ladrillo[][] ladrillos) {
		this.ladrillos = ladrillos;
	}

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public int getANCHO() {
		return ANCHO;
	}

	public void setANCHO(int aNCHO) {
		ANCHO = aNCHO;
	}

	public int getALTO() {
		return ALTO;
	}

	public void setALTO(int aLTO) {
		ALTO = aLTO;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getMAX_COL_LADRILLOS() {
		return MAX_COL_LADRILLOS;
	}

	public int getMAX_FIL_LADRILLOS() {
		return MAX_FIL_LADRILLOS;
	}
	
	

	
}
