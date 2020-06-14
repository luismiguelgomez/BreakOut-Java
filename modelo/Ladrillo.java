package modelo;

public class Ladrillo {

	private int ancho;
	private int alto;
	private int posx;
	private int posy;
	private boolean visible;
	
	public Ladrillo(int pAncho, int pAlto, int pPosx, int pPosy) {
		
		visible = true;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void destruir() {
		visible = false;
	}
	
	public void reiniciar() {
		visible = true;
	}

	
}
