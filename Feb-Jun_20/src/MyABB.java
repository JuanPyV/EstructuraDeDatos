import java.util.NoSuchElementException;

public class MyABB<E extends Comparable<E>> {

	private MyNodoABB<E> raiz;
	private int size;

	public MyABB() {
		super();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E buscar(E valor) {
		MyNodoABB<E> current = this.raiz;
		while (current != null) {
			if (current.dato.equals(valor)) {
				return current.dato;
			} else if (valor.compareTo(current.dato) < 0) {
				current = current.der;
			} else {
				current = current.izq;
			}
		}
		throw new NoSuchElementException(valor + "no se encontro en el arbol");

	}

	public void insertar(E valor) {

		if (this.isEmpty()) {
			this.raiz = new MyNodoABB<>(valor);

		} else {
			MyNodoABB<E> current = this.raiz, prev = null;
			while (current != null) {
				prev = current;
				if (valor.compareTo(current.dato) < 0) {
					current = current.der;
				} else {
					current = current.izq;
				}
			}
			// current esta en null y prev esta en quien sera el padre del nuevo nodo
			if (valor.compareTo(prev.dato) < 0) {
				prev.izq = new MyNodoABB<>(valor);
			} else {
				prev.der = new MyNodoABB<>(valor);
			}
			this.size++;
		}
	}

	public void insertarRec(E valor) { // suponer que el elemento no existe en el arbol
		this.raiz = insertarRec(this.raiz, valor);
		this.size++;
	}

	private MyNodoABB<E> insertarRec(MyNodoABB<E> current, E valor) {
		if (current == null) {
			return new MyNodoABB<E>(valor);
		}
		if (valor.compareTo(current.dato) < 0) {
			current.izq = insertarRec(current.izq, valor);
		} else if (valor.compareTo(current.dato) > 0) {
			current.der = insertarRec(current.der, valor);
		}
		return current;
	}
	
	public E borrar(E valor) {
		//borrar un valor del arbol
		// implementar todos los casos 1)hoja, 2)un hijo, 3)dos hijos 
		//Casos especiales: borrar la raiz o un dato que no existe
		return null;
	}
	
	//Estudiar el recorrido de un arbol en preorden, inorden y postorden
	
	public void preorden() {
		this.preorden(this.raiz);
		System.out.println();
	}
	
	private void preorden(MyNodoABB<E> current) {
		if(current != null) {
			System.out.print(current.dato + ",");
			preorden(current.izq);
			preorden(current.der);
		}
	}
	
	
	public static void main(String[] args) {
		MyABB<Integer> arbol = new MyABB<>();
		arbol.insertar(100);
		arbol.insertar(50);
		arbol.insertar(200);
		arbol.insertar(25);
		arbol.insertar(75);
		arbol.insertar(150);
		arbol.insertar(250);
		arbol.preorden();
		System.out.println("FIN");
		

	}

}

class MyNodoABB<E extends Comparable<E>> {
	E dato;
	MyNodoABB<E> izq, der;

	public MyNodoABB(E dato) {
		this(dato, null, null);
		// estamos usando otro constructor
	}

	public MyNodoABB(E dato, MyNodoABB<E> izq, MyNodoABB<E> der) {
		this.dato = dato;
		this.izq = izq;
		this.der = der;
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public MyNodoABB<E> getIzq() {
		return izq;
	}

	public void setIzq(MyNodoABB<E> left) {
		this.izq = left;
	}

	public MyNodoABB<E> getDer() {
		return der;
	}

	public void setDer(MyNodoABB<E> right) {
		this.der = right;
	}

	public String toString() {
		return this.dato.toString();
	}

}
