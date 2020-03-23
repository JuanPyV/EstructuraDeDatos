import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FractalSG extends JFrame {

	private Point a = new Point(550, 100), b = new Point(50, 400), c = new Point(750, 550);
	private int nivel;

	public FractalSG() {
		super("Fractal Sierpinski Gasket");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Que nivel desea pintar:"));
		this.setVisible(true);
	}

	private void pintaLinea(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}

	private Point puntoMedio(Point a, Point b) {
		int xM = (a.x + b.x) / 2, yM = (a.y + b.y) / 2;
		return new Point(xM, yM);
	}

	private void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c) {
		if (n == 0) {
			this.pintaLinea(g, a, b);
			this.pintaLinea(g, b, c);
			this.pintaLinea(g, c, a);
		} else {
			Point pmAB = this.puntoMedio(a, b), pmBC = this.puntoMedio(b, c), pmCA = this.puntoMedio(c, a);
			this.pintaTriangulos(g, n - 1, a, pmAB, pmCA);
			this.pintaTriangulos(g, n - 1, pmAB, b, pmBC);
			this.pintaTriangulos(g, n - 1, pmCA, pmBC, c);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.pintaTriangulos(g, this.nivel, this.a, this.b, this.c);
	}

	public static void main(String[] args) {
		new FractalSG();

	}

}
