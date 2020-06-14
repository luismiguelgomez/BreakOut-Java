package modelo;

public class Jugador {

	private int ancho;
	private int alto;
	private int posx;
	private int posy;
	
	public Jugador(int pAncho, int pAlto, int pPosx, int pPosy) {
		ancho = pAncho;
		alto = pAlto;
		posx = pPosx;
		posy = pPosy;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	public void reiniciarJugador(int pAncho) {
		posx = (int)(pAncho - ancho) / 2;
	}
	
	public void moverDerecha (int pMovi, int pAncho) {
		int limite = posx + ancho + pMovi;
		
		if (limite < pAncho) {
			posx = posx + pMovi;
		}
	}
	
	public void moverIzquierda(int pMovi) {
		if (posx - pMovi > 0) {
			posx = posx - pMovi;
		}
		
	}

}
