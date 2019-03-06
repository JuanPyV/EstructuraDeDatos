
// Juan Pablo Velazco Velaquez
// Mayra Patricia Guajardo Palomera
//Comentario: Luis Gerardo nos asesoro con la explicacion del problema

import java.awt.*;

public class disco {
	int torre, x, y, width, height, i;

	public disco(int x, int y, int i, int largo) {
		this.i = i;
		this.x = x;
		this.y = y;
		this.width = largo;
	}

	public int getI() {
		return i;
	}

	public void posXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paintDisc(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, 25);
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, 25);
	}
}