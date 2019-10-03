
public class MyStack<E> {

	private MiListaEnlazada<E> lista;

	public MyStack() {
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

	public void push(E dato) {
		this.lista.insertAtFirst(dato);
	}

	public E pop() {
		try {
			return this.lista.removeFirst();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoClassDefFoundError("No se puede hacer un pop de un Stack vacio");
		}
	}

	public E top() {
		try {
			return this.lista.first();
		} catch (IndexOutOfBoundsException ex) {
			throw new NoClassDefFoundError("No se puede hacer un top de un Stack vacio");
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
