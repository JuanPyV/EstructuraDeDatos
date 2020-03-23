import java.util.NoSuchElementException;

public class ListaEnlazada<E> {

	private NodoLE<E> inicio, fin;
	private int size;

	public ListaEnlazada() {

		this.inicio = this.fin = null;
		this.size = 0;
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
	
	public void insertarFin(E valor) {
		/*
		if (this.isEmpty()) {
			this.insertarInicio(valor);
		} else {
			NodoLE<E> nvo = new NodoLE<>(valor);
			this.fin.setNext(nvo);
			
			this.size++;
		}
		*/
		if(this.size>0) {
			this.fin.next = new NodoLE<>(valor);
			this.fin = this.fin.next;
			this.size++;
		}else {
			this.insertarInicio(valor);
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
	
	
	
	public String toString() {
		String res = "";
		NodoLE<E> current = this.inicio;
		for (int i = 0; i < this.size; i++) {
			res+=current.valor+",";
			current = current.next;	
		}
		return res;
	}
	
	//insertarEn 
	public void insertarEn(E dato, int pos) {
		// insertar dato en una posicion
				int cont = 0;
				if (pos > this.size || pos < 0) {
					throw new IndexOutOfBoundsException("La posicion excede el arreglo");
				}
				if (isEmpty()) {
					insertarInicio(dato);
				} else if (pos == 0) {
					insertarInicio(dato);
				} else {
					NodoLE<E> nvo = new NodoLE<E>(dato, this.inicio);
					NodoLE<E> current = this.inicio;
					while (cont < pos - 1) {
						cont++;
						current = current.getNext();
					}
					nvo.setNext(current.getNext());
					current.setNext(nvo);
				}
				size++;
	}
	
	// borrarEn
	
	public E borraEn(int pos) throws NoSuchElementException{
		if (this.size <= 1) {
			return this.borrarFin();
		} else if (pos == this.size - 1) {
			return this.borrarFin();
		} else {
			NodoLE<E> current = this.inicio;
			E dato;
			for (int i = 0; i < pos - 1; i++) {
				current = current.getNext();
			}
			dato = current.getNext().getValor();
			current.setNext(current.getNext().getNext());
			this.size--;
			return dato;
		}
	}
	
	public void setAt(E valor, int pos) {
		
		if (pos >= 0 && pos < this.size) {
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current = current.getNext();
			}
			current.setValor(valor);
		} else {
			throw new IndexOutOfBoundsException(
					"NO se puede regresar el elemento en la posicion" + pos + "en la lista de tamaño" + this.size);
		}
			
		
	}
	
	public E borrarFin() {
		try {
			E valor = this.fin.valor;
			if(this.size > 1) {
				
				NodoLE<E> current = this.inicio;
				for(int i = 0; i < this.size-2; i++) {
					current = current.next;
				}
				current.next = null;
				this.fin = current;
					
			}else {
				return this.borrarInicio();
			}
			this.size--;
			return valor;
			
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el elemento de una lista vacia");
		}			
		
	}
	
	

	public static void main(String[] args) {
		Integer[] valores = { 1, 3, 5, 7, 9 };
		ListaEnlazada<Integer> lista = new ListaEnlazada<Integer>(valores);
		System.out.println(lista);
		// TODO Auto-generated method stub

	}

}

/////////////////////////////////////////////////////////////////////////////////////////

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
