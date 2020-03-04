import java.util.NoSuchElementException;

public class LinkedList<E> {

	private Nodo<E> inicio, fin;
	private int size;

	public LinkedList() {
		this.inicio = this.fin = null;
		this.size = 0;
	}

	public LinkedList(E[] datos) {
		for (int i = 0; i < datos.length; i++) {
			insertarEn(datos[i], i);
		}
	}

	public E inicio() {
		try {
			return this.inicio.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar valor de lista vacia");
		}

	}

	public E fin() {
		try {
			return this.fin.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar valor de lista vacía");
		}
	}

	public boolean vacia() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void insertarInicio(E dato) {
		Nodo<E> nvo = new Nodo<>(dato, null, this.inicio);
		this.inicio = nvo;
		nvo.setPrev(nvo);
		if (vacia()) {
			this.fin = nvo;
		}
		size++;
	}

	public void insertarFin(E dato) {
		if (vacia()) {
			insertarInicio(dato);
		} else {
			Nodo<E> nvo = new Nodo<E>(dato, this.fin, this.inicio);
			this.fin.setNext(nvo);
			this.fin = nvo;
			this.size++;
		}
			
		
		/*
		if (vacia()) {
			this.insertarInicio(dato);
		} else {
			Nodo<E> nvo = new Nodo<>(dato, this.inicio, this.fin);
			nvo.setPrev(this.fin);
			this.fin.setNext(nvo);
			this.fin = nvo;
			this.fin.setNext(inicio);
			this.inicio.setPrev(nvo);
		}
		*/
	}

	public void insertarEn(E dato, int pos) throws IndexOutOfBoundsException {

		if (pos < 0 || pos > this.size) {

			throw new IndexOutOfBoundsException("Posicion fuera de rango");

		} else if (pos == 0) {
			insertarInicio(dato);
		} else if (pos == size) {
			insertarFin(dato);
		} else {

			Nodo<E> nvo = new Nodo<>(dato);
			Nodo<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();
			}
			nvo.setNext(current);
			nvo.setPrev(current.getPrev());
			nvo.getPrev().setNext(nvo);
			current.setPrev(nvo);
			size++;
		}

	}

	public String toString() {
		String res = "";
		Nodo<E> current = this.inicio;
		for (int i = 0; i < size; i++) {
			res += current.getDato() + ",";
			current = current.getNext();
		}
		return res;
	}

	public static void main(String[] args) {

		Integer[] lista = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		LinkedList<Integer> listita = new LinkedList<>(lista);

		listita.insertarInicio(33);
		listita.insertarFin(22);
		listita.insertarEn(11, 6);

		System.out.println(listita);

	}
}

class Nodo<E> {
	private E dato;
	public Nodo<E> next, prev;

	public Nodo(E dato) {
		this(dato, null, null);
	}

	public Nodo(E dato, Nodo<E> prev, Nodo<E> next) {
		super();
		this.dato = dato;
		this.next = next;
		this.prev = prev;
	}

	public E getDato() {
		return dato;
	}
	public Nodo<E> getNext() {
		return next;
	}
	public Nodo<E> getPrev() {
		return prev;
	}
	public void setDato(E dato) {
		this.dato = dato;
	}
	public void setNext(Nodo<E> next) {
		this.next = next;
	}

	public void setPrev(Nodo<E> prev) {
		this.prev = prev;
	}

}