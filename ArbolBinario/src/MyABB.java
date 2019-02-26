/**
 * Juan Pablo Velazco 
 * Feb 21, 2019 
 * MyABB.java
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
