//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MyABB (Implementacion de ABB) 
//Fecha: 09/10/2019
//Comentarios u observaciones: 

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
				
			}
			//solo tiene un hijo y es el izquierdo
			else if (parent.right == null) {
				if (parent.left == current) {
					parent.left = current.left;
				} else {
					parent.right = current.left;
				}

				// solo tiene un hijo y es el derecho
			} else if (current.left == null) {
				if (parent.left == current) {
					parent.left = current.right;
				} else {
					parent.right = current.right;

				}
				//dos hijos el nodo a eliminar
			} else {
				NodoABB<E> predecesor = predecesor(current);
				current.value = predecesor.value;
				if (current.left == predecesor) {
					predecesor = null;
				} else {
					E dato = remove(predecesor.value);
					current.value = dato	;
				}
			}
			return current.value;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("No se encontro el valor " + value + " en el arbol");
		}

	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo) {
		NodoABB<E> current = nodo.left;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyABB<Integer> arbol = new MyABB<>();
		arbol.insert(21);
		arbol.insert(13);
		arbol.insert(33);
		arbol.insert(10);
		arbol.insert(18);
		arbol.insert(25);
		arbol.insert(40);
		arbol.insert(29);
		arbol.insert(27);
		arbol.insert(30);
		arbol.preorden();
		System.out.println("");
		//arbol.inorden();
		System.out.println(arbol.remove(30));
		System.out.println("");
		arbol.preorden();
		//arbol.postorden();

	}

}

class NodoABB<E extends Comparable<E>> {
	E value;
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