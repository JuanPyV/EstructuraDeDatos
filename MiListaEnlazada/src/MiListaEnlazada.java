//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MiLIstaEnlazada.java
//Fecha: 11/02/2019
//Comentarios u observaciones: 
public class MiListaEnlazada<E> {

	private NodoLE<E> inicio, fin;
	private int size;

	public MiListaEnlazada() {
		this.inicio = this.fin = null;
		this.size = 0;
	}

	public MiListaEnlazada(E[] datos) {
		// inicializa la lista con los elementos que contiene el arreglo
	}

	public E inicio() {
		return this.inicio.getDato();
	}

	public E fin() {
		return this.fin.getDato();
	}

	public boolean estaVacia() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void insertarInicio(E dato) {
		NodoLE<E> nvo = new NodoLE(dato, this.inicio);
		this.inicio = nvo;
		// Si esta vacia toda la lista el fin tambien es el inicio
		if (this.estaVacia()) {
			this.fin = nvo;
		}

		this.size++;

	}

	public void insertarFin(E dato) {
		if (this.estaVacia()) {
			this.insertarInicio(dato);
		} else {
			NodoLE<E> nvo = new NodoLE<>(dato);
			this.fin.setNext(nvo);
			this.fin = nvo;
			this.size++;
		}
	}

	public void insertarEn(E dato, int pos) {
		//insertar dato en una posicion
	}

	public String toString() {
		String res = "";
		NodoLE<E> current = this.inicio;
		for (int i = 0; i < this.size; i++) {
			res += current.getDato() + ",";
			current = current.getNext();
		}
		return res;
	}

	public static void main(String[] args) {

		MiListaEnlazada<Integer> lista1 = new MiListaEnlazada<>();
		for (int i = 0; i < 5; i++) {
			lista1.insertarInicio(i);
		}
		lista1.insertarFin(10);
		System.out.println(lista1);

	}

}

class NodoLE<E> {
	private E dato;
	private NodoLE<E> next;

	public NodoLE(E dato, NodoLE<E> next) {
		super();
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
