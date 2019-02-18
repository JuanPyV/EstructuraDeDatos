/**
 * Juan Pablo Velazco Velasquez Feb 18, 2019 MyStack.java
 */

public class MyStack<E> {

	private MiListaEnlazada<E> lista;

	public MyStack() {
		this.lista = new MiListaEnlazada<>();
	}

	public void push(E dato) {
		this.lista.insertarInicio(dato);
	}

	public E pop() {
		try {
			return this.lista.borrarInicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoClassDefFoundError("No se puede hacer un pop de un Stack vacio");
		}
	}

	public E top() {
		try {
			return this.lista.inicio();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoClassDefFoundError("No se puede hacer un top de un Stack vacio");
		}

	}

	public int size() {
		return this.size();
	}

	public boolean isEmpty() {
		return this.lista.estaVacia();
	}

	public String toString() {
		return this.lista.toString();
	}

	public static void main(String[] args) {

		MyStack<Integer> pila = new MyStack<>();
		
		for(int i = 0; i < 100; i++) {
			pila.push(i);
		}
		
		while(!pila.isEmpty()) {
			System.out.println(pila.pop());
		}
		
		
	}

}
