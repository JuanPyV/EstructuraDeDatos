import java.util.NoSuchElementException;

public class MyStack<E> {

	private ListaEnlazada<E> stack;

	public MyStack() {
		this.stack = new ListaEnlazada<>();
	}

	public int size() {
		return this.stack.size();
	}

	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	public void flush() {
		this.stack = new ListaEnlazada<>();
		System.gc();
	}

	public void push(E valor) { // Inserta el elemento al inicio de la pila
		this.stack.insertarInicio(valor);
	}

	public E pop() { // borra un elemento de la pila
		try {
			return this.stack.borrarInicio();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede hacer un pop de un Stack vacio");
		}
	}

	public E top() { // Consulta cual es el elemento que esta "arriba" en la piila 
		try {
			return this.stack.inicio();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("no se puede obtener el primer elemento de una pila vacia");
		}

	}

	public static void main(String[] args) {

		MyStack<Integer> pila = new MyStack<>();

		for (int i = 0; i < 10; i++) {
			pila.push(i);
			
		}

		while (!pila.isEmpty()) {
			System.out.print(pila.pop() + ", ");
		}
	}

}
