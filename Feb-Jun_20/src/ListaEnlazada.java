import java.util.NoSuchElementException;

public class ListaEnlazada<E> {

	private NodoLE<E> inicio, fin;
	private int size;

	public ListaEnlazada() {

		this.inicio = this.fin = null;
		this.size = 0;
	}

	public E inicio() {
		try {
			return this.inicio.valor;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el primer elemento de una lista vacia");
		}
	}

	public E fin() {
		try {
			return this.fin.valor;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar el ultimo elemento de una lista vacia");
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void insertarInicio(E dato) {
		this.inicio = new NodoLE<>(dato, this.inicio);
		if (this.fin == null) {
			this.fin = this.inicio;
		}
		size++;
	}
	
	public ListaEnlazada(E[] valores) {
		//Inicializa la lista con los elementos del arreglo
		// Ej: si recibo {6,4,10,3}  -> 6 -> 4 -> 10 -> 3
				
		for (int i = 0; i < valores.length; i++) {
			if (i == 0) {
				insertarInicio(valores[i]);
				i++;
			}
			NodoLE<E> nvo = new NodoLE<E>(valores[i], this.fin);
			this.fin.setNext(nvo);
			this.fin = nvo;
			this.size++;
		}
	}
	
	public E borrarInicio() {
		//Borra de la lista el primer elemento y me regresa el valor que estaba ahi
		// arroja un NoSuchElementException si la lista estaba vacia 
		
		try {
			E res = this.inicio();
			this.inicio = this.inicio.getNext();
			this.size--;
			if (this.size == 0) {
				this.fin = null;
			}
			return res;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("NO se puede borrar el inicio de una lista vacia");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NodoLE<E> {
	E valor;
	NodoLE<E> next;

	public NodoLE(E valor) {
		this(valor, null);
	}

	public NodoLE(E valor, NodoLE<E> next) {
		this.valor = valor;
		this.next = next;
	}

	public E getValor() {
		return valor;
	}

	public void setValor(E valor) {
		this.valor = valor;
	}

	public NodoLE<E> getNext() {
		return next;
	}

	public void setNext(NodoLE<E> next) {
		this.next = next;
	}

	public String toString() {
		return this.valor + "";
		// return this.valor.toString;
	}

}
