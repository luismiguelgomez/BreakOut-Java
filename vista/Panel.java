package vista;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

import controlador.Controller;
import modelo.Juego;

public class Panel extends JPanel implements KeyListener, ActionListener {

	private Controller controlador;
	private int delay;
	private boolean estado;
	private Timer tiempo;
	
	
	public Panel (Controller c) {
		controlador = c;
		delay = 8;
		tiempo = new Timer(delay, this);
		estado = true;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paint(Graphics g) {
		if (controlador.getJuego().getPuntuacion() > 18) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 500, 500);
			
			g.setColor(Color.yellow);
			g.drawString("HAS GANADO", (getWidth()/2)-45, (getHeight()/2) - 80);
			g.drawString("Su puntuación fue:" + controlador.getJuego().getPuntuacion(), (getWidth()/2)-80, (getHeight()/2) - 50);
			g.drawString("Presiona la tecla R para jugar de nuevo" + controlador.getJuego().getPuntuacion(), (getWidth()/2)-80, (getHeight()/2) - 20);
		} else if(estado == false) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 500, 500);
			
			g.setColor(Color.red);
			g.drawString("HAS PERDIDO!", (getWidth()/2)-45, (getHeight()/2) - 80);
			g.drawString("Su puntuación fue:" + controlador.getJuego().getPuntuacion(), (getWidth()/2)-80, (getHeight()/2) - 50);
			g.drawString("Presiona la tecla R para jugar de nuevo" + controlador.getJuego().getPuntuacion(), (getWidth()/2)-80, (getHeight()/2) - 20);
		} else {
			g.setColor(Color.black);
			g.fillRect(0, 0, 500, 500);
			
			//Bola
			g.setColor(Color.orange);
			g.drawOval(controlador.getJuego().getBola().getPosx(), controlador.getJuego().getBola().getPosy(), controlador.getJuego().getBola().getAncho(), controlador.getJuego().getBola().getAlto());
			
			//Jugador
			g.setColor(Color.yellow);
			g.drawRect(controlador.getJuego().getJugador().getPosx(), controlador.getJuego().getJugador().getPosy(), controlador.getJuego().getJugador().getAncho(), controlador.getJuego().getJugador().getAlto());
			
			Rectangle jugador = new Rectangle(controlador.getJuego().getJugador().getPosx(), controlador.getJuego().getJugador().getPosy(), controlador.getJuego().getJugador().getAncho(), controlador.getJuego().getJugador().getAlto()); 
			Rectangle bola = new Rectangle(controlador.getJuego().getBola().getPosx(), controlador.getJuego().getBola().getPosy(), controlador.getJuego().getBola().getAncho(), controlador.getJuego().getBola().getAlto());
			
			//Choque del jugador y la bola
			if (bola.intersects(jugador)) {
				controlador.getJuego().getBola().intertiry();
				if (controlador.getJuego().getJugador().getPosx() + 
						(controlador.getJuego().getJugador().getAncho() / 2)
						> controlador.getJuego().getBola().getPosx()) {
					
					//Si el movimiento de la bola es hacia la derecha
					if(controlador.getJuego().getBola().getDirx() > 0) {
						//Rebotar la bola hacia la izquierda
						controlador.getJuego().getBola().invertirx();
					} 
				} else {
					//Si el movimiento de la bola es hacia la izquierda
					if(controlador.getJuego().getBola().getDirx() < 0) {
						//Rebotar la bola hacia la derecha
						controlador.getJuego().getBola().invertirx();
					}
				}
			}	
			
			for (int i = 0; i < controlador.getJuego().getMAX_FIL_LADRILLOS(); i++) {
				//Columnas
				for (int j = 0; j < controlador.getJuego().getMAX_COL_LADRILLOS(); j++) {
			
					//Dibujar el ladrillo
					
					Juego claseJuego = new Juego();
					claseJuego.inicializarLadrillos();
					
					int x = controlador.getJuego().getLadrillos()[i][j].getPosx();
					int y = controlador.getJuego().getLadrillos()[i][j].getPosy();
					int ancho = controlador.getJuego().getLadrillos()[i][j].getAncho();
					int alto = controlador.getJuego().getLadrillos()[i][j].getAlto();

					if (controlador.getJuego().getLadrillos()[i][j].isVisible()) {
						//Dibujar el ladrillo
						g.drawRect(x, y, ancho, alto);
						Rectangle ladrillo = new Rectangle(x, y, ancho, alto);
						//choque entre ladrillos y bola
						if (ladrillo.intersects(bola)) {
							controlador.getJuego().getLadrillos()[i][j].setVisible(false);
							controlador.getJuego().getBola().intertiry();
							controlador.getJuego().setPuntuacion(controlador.getJuego().getPuntuacion() + 1);
						}
						
					}
					
				}
			}
			
			g.setColor(Color.cyan);
			g.drawString("Puntuación : " + controlador.getJuego().getPuntuacion(), 400, 27);
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tiempo.start();
		repaint();
		estado = controlador.getJuego().getBola().mover(getWidth(), getHeight());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && estado == true) {
			tiempo.start();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && estado == true) {
			controlador.getJuego().getJugador().moverDerecha(12, getWidth());
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && estado == true) {
			controlador.getJuego().getJugador().moverIzquierda(12);
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			controlador.getJuego().reinicializar();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
