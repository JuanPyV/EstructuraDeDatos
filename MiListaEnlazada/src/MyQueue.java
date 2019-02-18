import java.util.NoSuchElementException;

/**
 * Juan Pablo Velazco Velasquez Feb 18, 2019 MyQueue.java
 */

public class MyQueue<E> {

	private MiListaEnlazada<E> lista;

	public MyQueue() {
		this.lista = new MiListaEnlazada<>();
	}

	public void enqueue(E dato) {
		this.lista.insertarFin(dato);
	}

	public E dequeue() {
		try {

			return this.lista.borrarInicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacia");
		}
	}

	public E next() {
		try {

			return this.lista.inicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacia");
		}
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public void flush() {
		this.lista.flush();
	}
	
	

	public static void main(String[] args) {
		MyQueue<String> cola = new MyQueue<>();
		cola.enqueue("Hola");
		cola.enqueue("Que");
		cola.enqueue("Tal");
		cola.enqueue("Espero");
		cola.enqueue("Que");
		cola.enqueue("Funcione");
		
		while(!cola.isEmpty()) {
			System.out.println(cola.dequeue());
		}
		

	}

}
