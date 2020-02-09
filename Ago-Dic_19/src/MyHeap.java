//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MyHeap (Implementacion de Heap) 
//Fecha: 27/10/2019
//Comentarios u observaciones: 

import java.util.Arrays;

public class MyHeap<E extends Comparable<E>> {

	private int size;
	private E[] heap;

	// Constructor default
	private MyHeap() {
		this.size = 127;
		this.heap = (E[]) new Comparable[size];

	}

	// constructor (E[]) -> heapify
	private MyHeap(E[] arr) {
		heap = Arrays.copyOf(arr, arr.length);

		int i = (arr.length - 2) / 2;
		while (i >= 0)
			heapify(i--);
	}

	public void heapify(int index) {

		int left = (2 * index + 1);
		int right = (2 * index + 2);

		int smallest = index;

		if (left < size && heap[left].compareTo(heap[index]) < 0)
			smallest = left;

		if (right < size && heap[right].compareTo(heap[smallest]) < 0)
			smallest = right;

		if (smallest != index) {
			swap(index, smallest);
			heapify(smallest);
		}

	}

	public void swap(int padre, int hijo) {
		E temp = this.heap[padre];
		this.heap[padre] = this.heap[hijo];
		this.heap[hijo] = temp;
	}

	// insert (E): void
	public void insertar(E dato) {
		heap[this.size] = dato;
		this.size++;
	}

	// delete(): E
	public void delete() {
		heap[0] = heap[this.size - 1];
		heap[this.size - 1] = null;
		this.size--;
		heapify(0);
	}

	// isEmpty(): boolean
	public boolean isEmpty() {
		return this.size == 0;
	}

	// size(): int
	public int size() {
		return this.size;
	}

	// toString():separar por "," y espacios
	public String toString() {
		String res = "";
		E current = this.heap[0];
		for (int i = 0; i <= this.size; i++) {
			res += current + ", ";
			current = this.heap[0 + i];
		}
		return res;
	}

	public static void main(String[] args) {
		
	}

}
