
// Juan Pablo Velazco Velaquez
// Mayra Patricia Guajardo Palomera
//Comentario: Luis Gerardo nos asesoro con la explicacion del problema

import java.awt.*;
import java.util.NoSuchElementException;

public class torres<E> {
	int x, y, height, width;
	MiListaEnlazada<disco> lista;

	public torres() {
		lista = new MiListaEnlazada<>();
	}

	public void push(disco dato) {
		lista.insertarInicio(dato);
	}

	public disco pop() throws NoSuchElementException {
		try {
			return this.lista.borrarInicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un pop de una pila vacia");
		}
	}

	public disco top() throws NoSuchElementException {
		try {
			return this.lista.inicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un top de una pila vacia");
		}
	}

	public int size() {
		return this.lista.size();
	}

	public boolean isEmpty() {
		return this.lista.estaVacia();
	}

	public void flush() {
		this.lista.flush();
	}

	public torres(int x, int y) {
		this.x = x;
		this.y = y;
		this.lista = new MiListaEnlazada<>();
	}

	public void paintTorre(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(this.x + 138, this.y - 375, 8, 375);
		g.fillRect(0, 570, 1250, 200);
		g.setColor(Color.BLACK);
		g.drawRect(0, 570, 1250, 200);
		if (!isEmpty()) {
			NodoLE<disco> current = lista.getInicio();
			for (int i = 0; i < size(); i++) {
				current.getDato().paintDisc(g);
				current = current.getNext();
			}
		}
	}
}