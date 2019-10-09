import java.util.NoSuchElementException;

public class MyABB<E extends Comparable<E>> {

	private NodoABB<E> root;
	private int size;

	public MyABB() {
		super();
	}

	public E search(E value) {
		NodoABB<E> current = this.root;
		while (current != null) {
			if (current.value.equals(value)) {
				return current.value;

				/*
				 * else{ current = value.compareTo(current.value)<0?current.left:current.right;
				 * }
				 */
			} else if (value.compareTo(current.value) < 0) {
				current = current.left;
			} else {
				current = current.right;

			}
		}
		throw new NoSuchElementException("No se encontro el valor " + value + " en el arbol");
	}

	public void insert(E value) {
		/*
		 * NodoABB<E> nvo = new NodoABB<>(value); if (this.root != null) { NodoABB<E>
		 * current = new NodoABB<>(value); NodoABB<E> prev = null;
		 * 
		 * current = this.root; while (current != null) { prev = current; current =
		 * value.compareTo(current.value) < 0 ? current.left : current.right; } //
		 * Current esta en null y prev esta en quien sera el padre de dato. if
		 * (value.compareTo(prev.value) < 0) { prev.left = nvo; } else { prev.right =
		 * nvo; } } else { this.root = nvo; } this.size++;
		 */
	}

	public void preorden() {
		preorden(this.root);
	}

	private void preorden(NodoABB<E> current) {
		if (current != null) {
			System.out.print(current.value + ",");
			preorden(current.left);
			preorden(current.right);
		}
	}

	public void inorden() {
		inorden(this.root);
	}

	private void inorden(NodoABB<E> current) {
		if (current != null) {
			inorden(current.left);
			System.out.print(current.value + ",");
			inorden(current.right);
		}
	}

	public void postorden() {
		postorden(this.root);
	}

	private void postorden(NodoABB<E> current) {
		postorden(current.left);
		postorden(current.right);
		System.out.print(current.value + ",");

	}

	public void nivel() {
		// imprimte los nodos separad
	}

	public E remove(E value) {
		NodoABB<E> current = this.root, parent = null;
		try {
			while (!current.value.equals(value)) {
				parent = current;
				current = value.compareTo(current.value) < 0 ? current.left : current.right;

			}

			// si llego aqui current esta en el valor a borrar y parent en el padre del nodo
			// a borrar
			if (current.left == null && current.right == null) {
				if (parent.left == current) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				return current.value;
			}
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se encontro el valor " + value + " en el arbol");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyABB<Integer> arbol = new MyABB<>();
		arbol.root = new NodoABB<>(50);
		arbol.root.left = new NodoABB<>(25);
		arbol.root.right = new NodoABB<>(75);
		arbol.root.right.left = new NodoABB<>(60);

		// System.out.println(arbol.search(85));
		// arbol.preorden();
		// arbol.inorden();
		arbol.postorden();

	}

}

class NodoABB<E extends Comparable<E>> {
	final E value;
	NodoABB<E> left, right;

	public NodoABB(E value) {
		super();
		this.value = value;
	}

	public NodoABB(E value, NodoABB<E> left, NodoABB<E> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public NodoABB<E> getLeft() {
		return left;
	}

	public void setLeft(NodoABB<E> left) {
		this.left = left;
	}

	public NodoABB<E> getRight() {
		return right;
	}

	public void setRight(NodoABB<E> right) {
		this.right = right;
	}

	public E getValue() {
		return value;
	}

}