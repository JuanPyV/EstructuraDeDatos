
// Juan Pablo Velazco Velaquez
// Mayra Patricia Guajardo Palomera
//Comentario: Luis Gerardo nos asesoro con la explicacion del problema

import java.awt.*;
import javax.swing.JPanel;

public class panelHanoi extends JPanel implements Runnable {
	private int x1, x2, x3, y1, y2, y3, n, diskLenght;
	private torres<disco> torrecita1, torrecita2, torrecita3;
	private Thread thread;

	public panelHanoi() {
		super();
		setPreferredSize(new Dimension(900, 600));
		diskLenght = 180;
		x1 = 90;
		x2 = 350;
		x3 = 600;
		y1 = y2 = y3 = 550;
		torrecita1 = new torres<disco>(50, 575);
		torrecita2 = new torres<disco>(310, 575);
		torrecita3 = new torres<disco>(560, 575);
		thread = new Thread(this);
	}

	public void disk(int n) {
		this.n = n;
		for (int i = 0; i < n; i++) {
			this.torrecita1.push(new disco(x1 + 13 * i, y1 - 25 * i, i, diskLenght - 20 * i));
		}
		repaint();
		thread.start();

	}

	public void TorreHanoiRec(int n, torres<disco> inicio, torres<disco> aux, torres<disco> fin)
			throws InterruptedException {

		Thread.sleep(600);
		if (n == 1) {
			mover(inicio, fin);
			repaint();
			Thread.sleep(600);
		} else {
			TorreHanoiRec(n - 1, inicio, fin, aux);
			mover(inicio, fin);
			TorreHanoiRec(n - 1, aux, inicio, fin);
		}
	}

	public void mover(torres<disco> inicio, torres<disco> destino) {
		disco discAux = (disco) inicio.top();
		if (destino == torrecita1) {
			discAux.posXY(x1 + (13 * discAux.getI()), y1 - 25 * destino.size());
		} else if (destino == torrecita2) {
			discAux.posXY(x2 + (13 * discAux.getI()), y2 - 25 * destino.size());
		} else {
			discAux.posXY(x3 + (13 * discAux.getI()), y3 - 25 * destino.size());
		}
		inicio.pop();
		destino.push(discAux);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		torrecita1.paintTorre(g);
		torrecita2.paintTorre(g);
		torrecita3.paintTorre(g);
	}

	public void run() {
		while (torrecita3.size() < n) {
			try {
				Thread.sleep(300);
				TorreHanoiRec(n, torrecita1, torrecita2, torrecita3);
				repaint();
			} catch (InterruptedException e) {

			}
		}
	}
}