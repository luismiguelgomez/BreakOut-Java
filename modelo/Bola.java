package modelo;

public class Bola {

	private int ancho;
	private int alto;
	private int posx;
	private int posy;
	private int dirx;
	private int diry;
	
	public Bola(int pAncho, int pAlto, int pPosx, int pPosy, int pDirx, int pDiry) {
		ancho = pAncho;
		alto = pAlto;
		posx = pPosx;
		posy = pPosy;
		dirx = pDirx;
		diry = pDiry;
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

	public int getDirx() {
		return dirx;
	}

	public void setDirx(int dirx) {
		this.dirx = dirx;
	}

	public int getDiry() {
		return diry;
	}

	public void setDiry(int diry) {
		this.diry = diry;
	}
	
	public boolean mover(int pAlto, int pAncho) {
		boolean rta = true;
		
		if (dirx > 0 && diry < 0) {
			if (posy + diry < 0 ) {
				intertiry();
			}
			if (posx + dirx + ancho > pAncho) {
				invertirx();
			}
		} else if (dirx < 0 && diry < 0) {
			if (posy + diry < 0) {
				intertiry();
			}
			if (posx + dirx < 0) {
				invertirx();
			}
		} else if (dirx < 0 && diry > 0) {
			if (posy + diry + alto > pAlto) {
				rta = false;
			}
			if (posx + dirx < 0) {
				invertirx();
			}
		} else if (dirx > 0 && diry > 0) {
			if (posy + diry + alto > pAlto) {
				rta = false;
			}
			if (posx + dirx + ancho > pAncho) {
				invertirx();
			}
		}
		
		posx = posx + dirx;
		posy = posy + diry;
		
		return rta;
	}
	
	public void invertirx() {
		dirx = -dirx;
	}

	public void intertiry () {
		diry = -diry;
	}
}
