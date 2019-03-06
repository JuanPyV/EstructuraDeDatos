
// Juan Pablo Velazco Velaquez
// Mayra Patricia Guajardo Palomera
//Comentario: Luis Gerardo nos asesoro con la explicacion del problema

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ventanaHanoi extends JFrame {

	public ventanaHanoi() {
		super("Towers of Hanoi");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelHanoi panel = new panelHanoi();
		controlHanoi control = new controlHanoi(panel);
		this.add(panel, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ventanaHanoi test = new ventanaHanoi();
	}
}