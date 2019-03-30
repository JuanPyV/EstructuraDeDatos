
public class maxHeap<E extends Comparable<E>> {

	private int size;
	private E[] heap;

	private maxHeap(int size2) {
		this.heap = (E[]) new Comparable[size2];
		this.size = 0;
	}

	public void insertar(E dato) {
		heap[this.size] = dato;
		this.size++;
	}

	public void borrar() {
		heap[0] = heap[this.size - 1];
		heap[this.size - 1] = null;
		this.size--;
		heapify(0);
	}

	public void heapify() {
		heapify(this.size / 2 - 1);
	}

	public void heapify(int index) {
		if (index >= 0) {
			try {
				while (heap[index].compareTo(heap[index * 2 + 1]) < 0
						|| heap[index].compareTo(heap[index * 2 + 2]) < 0) {
					if (heap[index].compareTo(heap[index * 2 + 1]) < 0) {
						swap(index, index * 2 + 1);
						if (index * 2 + 1 <= this.size / 2 - 1) {
							heapify(index * 2 + 1);
						}

					} else {
						swap(index, index * 2 + 2);
						if (index * 2 + 2 <= this.size / 2 - 1) {
							heapify(index * 2 + 2);
						}
					}
					if (index * 2 + 2 == this.size || heap[index * 2 + 2] == null) {
						break;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			} catch (NullPointerException e) {
			} finally {

				if (index >= 1) {
					heapify(--index);
				}
			}
		}

	}

	public void swap(int padre, int hijo) {
		E temp = this.heap[padre];
		this.heap[padre] = this.heap[hijo];
		this.heap[hijo] = temp;
	}

	public static void main(String[] args) {
		maxHeap<Integer> heap = new maxHeap<>(20);
		heap.insertar(5);
		heap.insertar(9);
		heap.insertar(14);
		heap.insertar(23);
		heap.insertar(1);
		heap.insertar(6);
		heap.insertar(35);
		heap.insertar(19);
		heap.heapify();
		heap.borrar();

	}
}
