import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;


public class SierpinskiGasket extends JFrame {
	
	private Point a, b, c;
	private int nivel;
	
	public SierpinskiGasket() {
		super("Fractal SierpinskiGasket");
		this.setSize(640,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.a = new Point(320,50);
		this.b = new Point(20,380);
		this.c = new Point(620,380);
		this.nivel = 10;
		this.setVisible(true);
		
	}
	
	public Point puntoMedio(Point a, Point b) {
		int xM = (a.x + b.x) /2, 
			yM = (a.y + b.y) /2;
		return new Point(xM,yM);
	
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaTriangulos(g, this.nivel, this.a, this.b, this.c);
	}
	
	public void dibujaLinea(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	public void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c) {
		if (n == 0) {
			this.dibujaLinea(g, a, b);
			this.dibujaLinea(g, b, c);
			this.dibujaLinea(g, c, a);
		}else {
			Point pmAB = this.puntoMedio(a, b), 
				  pmBC = this.puntoMedio(b, c), 
				  pmCA = this.puntoMedio(c, a);
			this.pintaTriangulos(g, n-1, a, pmAB, pmCA);
			this.pintaTriangulos(g, n-1, pmAB, b, pmBC);
			this.pintaTriangulos(g, n-1, pmCA, pmBC, c);
		}
		
	}
	
	public static void main(String[] args) {
		new SierpinskiGasket();
		
	}

}
