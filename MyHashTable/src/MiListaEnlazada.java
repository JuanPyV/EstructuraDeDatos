import java.util.NoSuchElementException;

//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MiLIstaEnlazada.java
//Fecha: 13/02/2019
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
		for (int i = 0; i < datos.length; i++) {
			if (i == 0) {
				insertarInicio(datos[i]);
				i++;
			}
			NodoLE<E> nvo = new NodoLE<E>(datos[i], this.fin);

			this.fin.setNext(nvo);// Va a ser el siguiente nodo con su dato y referencia
			this.fin = nvo;// este es nuestro ultimo elemento de nuestra lista
			this.size++;
		}
	}

	public NodoLE<E> getInicio() {
		return inicio;
	}

	public E inicio() {
		try {
			return this.inicio.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el primer elemento de una lista enlazada");
		}
	}

	public E fin() {
		try {
			return this.fin.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el ultimo elemento de una lista enlazada");
		}
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
		// insertar dato en una posicion
		int cont = 0;
		if (pos > this.size || pos < 0) {
			throw new IndexOutOfBoundsException("La posicion excede el arreglo");
		}
		if (estaVacia()) {
			insertarInicio(dato);
		} else if (pos == 0) {
			insertarInicio(dato);
		} else {
			NodoLE<E> nvo = new NodoLE<E>(dato, this.inicio);// creamos con valor y lo ponemos al principio
			NodoLE<E> current = this.inicio;// va a ser el nodo que vas a ir posicionando
			while (cont < pos - 1) {
				cont++;
				current = current.getNext();// Va cambiando de nodo, avanzando hasta uno antes de la posicion que quiero
			}
			nvo.setNext(current.getNext());// hacemos la relacion entre el nodo que creamos y el nodo siguiente del que
											// nos
											// quedamos
			current.setNext(nvo);// hacemos la relacion con el nodo que creamos y con el nodo en el que nos
									// quedamos
		}
		size++;

	}

	public E borrarInicio() {
		try {
			E res = this.inicio();
			this.inicio = this.inicio.getNext();
			this.size--;
			if (this.size == 0) {
				this.fin = null;
			}
			return res;
		} catch (NullPointerException e) {
			throw new IndexOutOfBoundsException("NO se puede borrar el inicio de una lista vacia");
		}
	}

	public E borrarFin() {
		if (this.size > 1) {
			E dato = this.fin();
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < this.size + 2; i++) {
				current = current.getNext();
			}
			// quiero que current se detenga uno antes de fin
			current.setNext(null);
			this.fin = current;
			this.size--;
			return dato;
		} else {
			try {
				return this.borrarInicio();
			} catch (IndexOutOfBoundsException e) {
				throw new IndexOutOfBoundsException("NO se puede borrar el fin de una lista vacia");
			}
		}

	}

	public void flush() {
		this.inicio = this.fin = null;
		this.size = 0;
		System.gc();
	}

	public E getEn(int pos) {
		if (pos == this.size - 1) {
			return this.fin();
		} else {

		}
		if (pos >= 0 && pos < this.size) {
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();
			}
			return current.getDato();
		} else {
			throw new IndexOutOfBoundsException(
					"NO se puede regresar el elemento en la posicion " + pos + " en la lista de tamaño " + this.size);
		}

	}

	public void setEn(E dato, int pos) {
		if (pos >= 0 && pos < this.size) {
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();
			}
			current.setDato(dato);
		} else {
			throw new IndexOutOfBoundsException(
					"NO se puede regresar el elemento en la posicion" + pos + "en la lista de tamaño" + this.size);
		}
	}

	public E borrarEn(int pos) {
		if (pos > size - 1 || pos < 0) {
			throw new IndexOutOfBoundsException("Index incorrecto");
		} else if (pos == 0) {
			return borrarInicio();
		} else if (pos == this.size) {
			return borrarFin();
		} else {
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos - 1; i++) {
				current = current.getNext();
			}
			E dato = current.getNext().getDato();
			current.setNext(current.getNext().getNext());
			size--;
			return dato;
		}
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

		Integer[] listNumeritos = { 1, 3, 5, 7, 9 };
		MiListaEnlazada<Integer> lista2 = new MiListaEnlazada<>(listNumeritos);

		lista2.insertarEn(0, 3);
		System.out.println(lista2);

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