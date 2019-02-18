import java.util.NoSuchElementException;

public class ListaEnlazadaDoble<E> {
	
	private int size;
	private NodoLDE<E> inicio, fin;

	public ListaEnlazadaDoble() {
		this.inicio = this.fin = null;
		size = 0;
	}
	
	public ListaEnlazadaDoble(E[] datos) {
		for (int i = 0; i < datos.length; i++) {
			insertarEn(datos[i], i);
		}
	}
	
	public int getSize() {
		return this.size;
	}
	public E getInicio() {
		return this.inicio.getDato();
	}
	
	public E getFin() {
		return this.fin.getDato();
	}
	
	public boolean estaVacia() {
		if (size == 0) { //return this.size == 0;
			return true;
		} else {
			return false;
		}
	}
	
	public void insertarInicio(E dato) {
		NodoLDE<E> nvo = new NodoLDE<E>(dato, null, this.inicio);
		this.inicio = nvo;
		nvo.setPrevious(nvo);
		//solamente si est� vac�a
		if (estaVacia()) {
			this.fin = nvo;
		}
		this.size++;
	}
	
	public void insertarFin(E dato) {
		if (estaVacia()) {
			insertarInicio(dato);
		} else {
			NodoLDE<E> nvo = new NodoLDE<E>(dato, this.fin, null);
			this.fin.setNext(nvo);
			this.fin = nvo;
			this.size++;
		}
	}
	
	public void insertarEn(E dato, int pos) {
		if (pos == 0) {
			insertarInicio(dato);
		} else if (pos == size) {
			insertarFin(dato);
		} else {
			NodoLDE<E> nvo = new NodoLDE<E>(dato);
			NodoLDE<E> current = this.fin;
			for (int i = size; i > pos+1; i--) {
				current = current.getPrevious();
			}
			nvo.setPrevious(current.getPrevious());
			nvo.setNext(current);
			current.setPrevious(nvo);
			nvo.getPrevious().setNext(nvo);
			size++;
		}
	}
	
	public E borrarInicio() {
		try {
			E dato = this.getInicio();
			this.inicio = this.inicio.getNext();
			size--;
			if (this.size == 0) {
				this.fin = null;
			}
			return dato;
		} catch (NullPointerException e) {
			throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vac�a");
		}
	}
	
	public E borrarFin() {
		try {
			E dato = this.getFin();
			this.fin = this.fin.getPrevious();
			size--;
			if (this.size == 0) {
				this.inicio = null;
			}
			return dato;
		} catch (NullPointerException e) {
			throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vac�a");
		}
	}
	
	public void setEn(E dato, int pos) {
		if (pos > this.size || pos < 0) {
			throw new NoSuchElementException("Posici�n Inv�lida");
		}
		NodoLDE<E> current = this.inicio;
		for (int i = 0; i < pos; i++) {
			current = current.getNext();
		}
		current.setDato(dato);
	}
	
	public E borrarEn(int pos) {
		NodoLDE<E> current = this.inicio;
		for (int i = 0; i < pos-2; i++) {
			current = current.getNext();
		}
		E dato = current.getNext().getDato();
		current.setNext(current.getNext().getNext());
		current.getNext().setPrevious(current);
		size--;
		return dato;
	}
	
	public String toString() {
		String res = "";
		NodoLDE<E> current = this.inicio;
		for (int i = 0; i < size; i++) {
			res += current.getDato() + ", ";
			current = current.getNext();
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] listin = {12, 5, 10, 3, 2};
		ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>(listin);
		lista.insertarInicio(2);
		lista.insertarFin(20);
		lista.setEn(30, 2);
		System.out.println(lista);
	}
}

class NodoLDE<E> {
	private NodoLDE<E> next, previous;
	private E dato;
	
	public NodoLDE<E> getNext() {
		return next;
	}
	public void setNext(NodoLDE<E> next) {
		this.next = next;
	}
	public NodoLDE<E> getPrevious() {
		return previous;
	}
	public void setPrevious(NodoLDE<E> previous) {
		this.previous = previous;
	}
	public E getDato() {
		return dato;
	}
	public void setDato(E dato) {
		this.dato = dato;
	}
	
	public NodoLDE(E dato, NodoLDE<E> previous, NodoLDE<E> next) {
		super();
		this.dato = dato;
		this.previous = previous;
		this.next = next;
	}
	
	public NodoLDE(E dato) {
		this(dato, null, null);
	}
}