import java.util.NoSuchElementException;

public class MyQueue<E> {

	private MiListaEnlazada<E> lista;

	public MyQueue() {
		this.lista = new MiListaEnlazada<>();

	}

	public int size() {
		return this.lista.size();
	}

	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

	public void flush() {
		this.lista = new MiListaEnlazada<>();
		System.gc();
	}

	public void enqueue(E dato) {
		this.lista.insertarAtLast(dato);
	}

	public E dequeue() {
		try {
			return this.lista.removeFirst();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacia");
		}

	}

	public E next() {
		try {
			return this.lista.first();
		}catch (IndexOutOfBoundsException e) {
		throw new NoSuchElementException("No se puede hacer un next de una cola vacia");
		}
	}

	public static void main(String[] args) {

		MyQueue<String> cola = new MyQueue<>();
		cola.enqueue("Hola");
		cola.enqueue("Que");
		cola.enqueue("Tal");
		cola.enqueue("Espero");
		cola.enqueue("Que");
		cola.enqueue("Funcione");

		for (int i = 0; i < cola.size(); i++) {
			System.out.print(cola.dequeue() + ", ");
		}
		System.out.println();

		while (!cola.isEmpty()) {
			System.out.print(cola.dequeue() + ", ");
		}
		// TODO Auto-generated method stub

	}

}
