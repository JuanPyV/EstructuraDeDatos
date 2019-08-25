
//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Busqueda Binaria con recursiva y genericos 
//Fecha: 23/08/2019
//Comentarios u observaciones: 

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame {

	private int nivel, largo, x1, y1;

	public YaMeHiceBolas() {
		super("Ya Me Hice Bolas");
		this.setSize(720, 700);
		this.largo = 600;
		this.x1 = 50;
		this.y1 = 60;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel de profundidad"));
		this.setVisible(true);

	}

	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculo(g, this.nivel, this.x1, this.y1, this.largo);

	}

	public void dibujarCirculo(Graphics g, int x1, int y1, int largo) {
		g.drawOval(x1, y1, largo, largo);
	}

	public void pintaCirculo(Graphics g, int nivel, int x1, int y1, int largo) {

		if (nivel >= 0) {
			dibujarCirculo(g, x1, y1, largo);
			pintaCirculo(g, nivel - 1, x1 + largo / 2, y1 + largo / 4, largo / 2);
			pintaCirculo(g, nivel - 1, x1, y1 + largo / 4, largo / 2);
		}
	}

	public static void main(String[] args) {
		new YaMeHiceBolas();

	}

}
