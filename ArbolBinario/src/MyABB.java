/**
 * Juan Pablo Velazco Feb 21, 2019 MyABB.java
 */

public class MyABB<E extends Comparable<E>> {

	private NodoABB<E> raiz;
	private int size;

	public MyABB() {
		this.raiz = null;
		this.size = 0;

	}

	public void insert(E dato) {
		NodoABB<E> nvo = new NodoABB<>(dato);
		if (this.raiz != null) {
			NodoABB<E> current = new NodoABB<>(dato);
			NodoABB<E> prev = null;

			current = this.raiz;
			while (current != null) {
				prev = current;
				current = dato.compareTo(current.data) < 0 ? current.left : current.right;
			}
			// Current esta en null y prev esta en quien sera el padre de dato.
			if (dato.compareTo(prev.data) < 0) {
				prev.left = nvo;
			} else {
				prev.right = nvo;
			}
		} else {
			this.raiz = nvo;
		}
		this.size++;
	}

	public E borrar(E dato) {
		NodoABB<E> current = this.raiz, prev = null;

		boolean lado; // lado es true entonces el hijo esta del lado izquierdo sino esta del lado
						// derecho

		// buscando al nodo a borrar y al padre del nodo a borrar
		
		while (!dato.equals(current.data)) {
			
			prev = current;
			
			// current esta igualado a la condicion, si es verdadera toma el valor que esta
			// entre el ? y : y si es falso toma el ultimo valor
			
			current = dato.compareTo(current.data) < 0 ? current.left : current.right;
		}

		// current ya esta en el nodo a borrar y prev en el parent de current

		// revisar si current esta del lado izquierdo o derecho del padre
		
		lado = prev.left == current; // si es verdaero current es izq si no der
		
		// caso en el que el nodo a borrar es una hoja
		if (current.right == null && current.left == null) {
			if (lado) {
				prev.left = null;
			} else {
				prev.right = null;
			}

			// caso 2 solo tiene un hijo y es el izquierdo
		} else if (current.right == null) {
			if (lado) {
				prev.left = current.left;
			} else {
				prev.right = current.left;
			}

			// caso 2.5 solo tiene un hijo y es el derecho 
		} else if (current.left == null) {
			if (lado) {
				prev.left = current.right;
			}
			else {
				prev.right = current.right;

			}
			//tiene dos hijos el nodo a eliminar
		}else {
			NodoABB<E> predecesor = predecesor(current);
			current.data = predecesor.data;
			predecesor = null;
		}
		
		
		
	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo){
		NodoABB<E> current= nodo.left;
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}

	public static void main(String[] args) {

		MyABB<Integer> arbol = new MyABB<>();
		arbol.insert(50);
		arbol.insert(25);
		arbol.insert(75);
		arbol.insert(1);
		arbol.insert(40);
		arbol.insert(60);
		arbol.insert(100);
		System.out.println("Fin");
	}

}

class NodoABB<E> {
	E data;
	NodoABB<E> left, right;

	public NodoABB(E data, NodoABB<E> left, NodoABB<E> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public NodoABB(E data) {
		this(data, null, null);
	}

	public String toString() {
		return this.data.toString();
	}
}
