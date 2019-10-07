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
		NodoABB<E> nvo = new NodoABB<>(value);
		if (this.root != null) {
			NodoABB<E> current = new NodoABB<>(value);
			NodoABB<E> prev = null;

			current = this.root;
			while (current != null) {
				prev = current;
				current = value.compareTo(current.value) < 0 ? current.left : current.right;
			}
			// Current esta en null y prev esta en quien sera el padre de dato.
			if (value.compareTo(prev.value) < 0) {
				prev.left = nvo;
			} else {
				prev.right = nvo;
			}
		} else {
			this.root = nvo;
		}
		this.size++;
	}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyABB<Integer> arbol = new MyABB<>();
		arbol.root = new NodoABB<>(50);
		arbol.root.left = new NodoABB<>(50);
		arbol.root.right = new NodoABB<>(50);
		arbol.root.right.left = new NodoABB<>(50);

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