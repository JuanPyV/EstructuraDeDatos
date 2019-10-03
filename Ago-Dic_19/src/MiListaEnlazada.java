
//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MiListaEnlazada.java
//Fecha: 04/09/2019
//Comentarios u observaciones:

import java.util.NoSuchElementException;

public class MiListaEnlazada<E> {

	private NodoLE<E> first, last;
	private int size;

	public MiListaEnlazada() {
		this.first = this.last = null;
		this.size = 0;
	}

	// Tarea
	public MiListaEnlazada(E[] valores) {
		for (int i = 0; i < valores.length; i++) {
			if (i == 0) {
				insertAtFirst(valores[i]);
				i++;
			}
			NodoLE<E> nvo = new NodoLE<E>(valores[i], this.last);

			this.last.setNext(nvo);
			this.last = nvo;
			this.size++;
		}

	}

	public E first() throws NoSuchElementException {
		try {
			return this.first.dato;
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("No se puede mostrar el primer dato de una lista vacia");
		}
	}

	public E last() throws NoSuchElementException {
		try {
			return this.last.dato;
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("No se puede mostrar el ultimo dato de una lista vacia");
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void insertAtFirst(E dato) {
		NodoLE<E> nvo = new NodoLE<>(dato, this.first);
		this.first = nvo;
		// Si esta vacia toda la lista el fin tambien es el inicio
		if (this.isEmpty()) {
			this.last = nvo;
		}

		this.size++;

	}

	// Tarea
	public void insertarAtLast(E dato) {
		// Si la lista esta vacia se inserta al principio
		if (this.isEmpty()) {
			this.insertAtFirst(dato);
		} else {
			NodoLE<E> nvo = new NodoLE<>(dato);
			this.last.setNext(nvo);
			this.last = nvo;
			this.size++;
		}
	}

	// Tarea
	public void insertAt(E dato, int pos) {
		// insertar dato en una posicion
		int cont = 0;
		if (pos > this.size || pos < 0) {
			throw new IndexOutOfBoundsException("La posicion excede el arreglo");
		}
		if (isEmpty()) {
			insertAtFirst(dato);
		} else if (pos == 0) {
			insertAtFirst(dato);
		} else {
			NodoLE<E> nvo = new NodoLE<E>(dato, this.first);
			NodoLE<E> current = this.first;
			while (cont < pos - 1) {
				cont++;
				current = current.getNext();
			}
			nvo.setNext(current.getNext());
			current.setNext(nvo);
		}
		size++;

	}

	public E removeFirst() {
		// Que pasa si la lista tiene un solo elemento?!
		try {
			E dato = this.first();
			this.first = this.first.next;
			this.size--;
			if (this.size == 0) {
				this.last = null;
			}
			return dato;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("NO se puede borrar el inicio de una lista vacia");
		}
	}

	// Tarea
	public E removeLast() {
		if (this.size <= 1) {
			return removeFirst();
		} else {
			NodoLE<E> current = this.first;
			E dato = this.last();
			for (int i = 0; i < this.size - 2; i++) {
				current = current.getNext();
			}
			current.next = null;
			this.last = current;
			this.size--;
			return dato;
		}
	}

	public E removeAt(int pos) throws NoSuchElementException{
		if (this.size <= 1) {
			return this.removeFirst();
		} else if (pos == this.size - 1) {
			return this.removeLast();
		} else {
			NodoLE<E> current = this.first;
			E dato;
			for (int i = 0; i < pos - 1; i++) {
				current = current.getNext();
			}
			dato = current.getNext().getDato();
			current.setNext(current.getNext().getNext());
			this.size--;
			return dato;
		}

	}

	public void setAt(E dato, int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || this.size >= pos) {
			throw new IndexOutOfBoundsException(
					"No se puede colocar un valor en la posicion " + pos + " en una lista de tamaño " + this.size);
		} else {
			NodoLE<E> current = this.first;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();

			}
			current.setDato(dato);
		}
	}

	public String toString() {
		String res = "";
		NodoLE<E> current = this.first;
		for (int i = 0; i < this.size; i++) {
			res += current.getDato() + " ";
			current = current.getNext();
		}
		return res;
	}

	public static void main(String[] args) {

		Integer[] listNumeritos = { 1, 3, 5, 7, 9 };
		MiListaEnlazada<Integer> lista = new MiListaEnlazada<>(listNumeritos);

		lista.insertAt(48, 3);
		lista.insertarAtLast(23);
		lista.insertAtFirst(11);

		System.out.println(lista);

		System.out.println(lista.removeFirst());
		System.out.println(lista.removeLast());

		System.out.println(lista);

	}

}

class NodoLE<E> {
	E dato;
	NodoLE<E> next;

	public NodoLE(E dato, NodoLE<E> next) {
		this.dato = dato;
		this.next = next;
	}

	public NodoLE(E dato) {
		this(dato, null);
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public NodoLE<E> getNext() {
		return next;
	}

	public void setNext(NodoLE<E> next) {
		this.next = next;
	}

}
