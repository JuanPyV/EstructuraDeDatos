import java.util.NoSuchElementException;

public class MyQueue<E> {

	private ListaEnlazada<E> lista;

	public MyQueue() {
		this.lista = new ListaEnlazada<>();

	}

	public int size() {
		return this.lista.size();
	}

	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

	public void flush() {
		this.lista = new ListaEnlazada<>();
		System.gc();
	}

	public void enqueue(E dato) {
		this.lista.insertarFin(dato);
	}

	public E dequeue() {
		try {
			return this.lista.borrarInicio();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacia");
		}

	}

	public E next() {
		try {
			return this.lista.inicio();
		}catch (NoSuchElementException e) {
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

		while (!cola.isEmpty()) {
			System.out.print(cola.dequeue() + ", ");
		}
		// TODO Auto-generated method stub

	}

}
