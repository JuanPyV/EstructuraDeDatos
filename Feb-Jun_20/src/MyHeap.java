//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MyHeap  
//Fecha: 24/04/2020
//Comentarios u observaciones: 

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHeap<E extends Comparable<E>> {
	private E[] values;
	private int size; // Representa cuántos elementos hay guardados en el Heap

	public MyHeap(int length) {
		this.values = (E[]) new Comparable[length];
		this.size = 0;
	}

	public MyHeap(E[] data) {// Suponer que el arreglo se recibe lleno
		this.values = data;
		heapify();
		this.size = data.length;
	}

	public MyHeap() {
		this(10);
	}

	public void heapify() {
		// Tarea hacer que los datos del arreglo complan la condicion de heap.
		// O(nlog(n))
		int index = (this.size - 2) / 2;

		int left = (2 * index + 1);
		int right = (2 * index + 2);

		int smallest = index;

		if (left < size && values[left].compareTo(values[index]) < 0)
			smallest = left;

		if (right < size && values[right].compareTo(values[smallest]) < 0)
			smallest = right;

		if (smallest != index) {
			swap(index, smallest);
			heapify();
		}
	}

	public void swap(int padre, int hijo) {
		E temp = this.values[padre];
		this.values[padre] = this.values[hijo];
		this.values[hijo] = temp;
	}

	public int getSize() {
		return this.size;
	}

	
	public void insert(E data) {
		//O(log(n))
		if(values.length == this.size) {
			E[] tmp=(E[])new Comparable[this.size*2];
			//Pasar todos los elementos de values a tmp
			tmp = Arrays.copyOf(values, values.length);
			this.values=tmp;
		}
		this.values[this.size]=data;
		heapify();
		this.size++;
	}
	
	 
	
	/*
	 * public E remove() { //O(log(n)) if(this.size>0) { //Completar } else { throw
	 * new NoSuchElementException("No se puede borrar de un Heap vacio"); } }
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < this.size; i++) {
			res += this.values[i] + ",";
		}
		return res;
	}

	public static void main(String[] args) {

		
		
		
	}
}
