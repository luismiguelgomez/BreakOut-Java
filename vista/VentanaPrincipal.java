package vista;

import javax.swing.JFrame;

import controlador.Controller;

public class VentanaPrincipal extends JFrame {

	private Panel panel;
	
	public VentanaPrincipal(Controller c, int ancho, int alto) {

		panel = new Panel(c);
		add(panel);
		
		setBounds(400, 100, ancho, alto+50);
		setTitle("Break - Breker");
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
