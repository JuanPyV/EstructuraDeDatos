import java.util.Iterator;
import java.util.NoSuchElementException;

public class EjemploIterador implements Iterable<Integer> {

	private Integer[] valores;
	private int size;

	public EjemploIterador(Integer[] valores) {
		this.valores = valores;
		this.size = valores.length;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int pos = 0;
			boolean callRemove = false;

			@Override
			public boolean hasNext() {
				return pos < size;
			}

			@Override
			public Integer next() {
				if (hasNext()) {
					callRemove = true;
					return valores[pos++];
				} else {
					throw new NoSuchElementException("No hay mas elementos por regresar");
				}

			}

			@Override
			public void remove() {
				if (this.callRemove) {
					for (int i = pos; i < size; i++) {
						valores[i - 1] = valores[i];
					}
					size--;
					pos--;
					this.callRemove = false;

				}
			}
		};
	}

	public static void main(String[] args) {
		Integer[] valores = new Integer[] { 11, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4 };
		EjemploIterador ei = new EjemploIterador(valores);
		for (Integer tmp : ei) {
			System.out.println(tmp);
		}

		Iterator<Integer> it = ei.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}