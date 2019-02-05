//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: bubbleSortGenericos.java
//Fecha: 28/01/2019
//Comentarios u observaciones: 	

public class bubbleSortGenericos <E>{

	public static <E extends Comparable<E>> void bubbleSort(E[] arreglo) {
		boolean cambio;
		for (int i = 0; i < arreglo.length - 1; i++) {
			cambio = false;
			for (int j = 0; j < arreglo.length - 1 - i; j++) {
				if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
					swap(arreglo, j, j + 1);
					cambio = true;
				}
			}
			if (!cambio) {
				break;
			}
		}
	}

	public static <E extends Comparable<E>> void swap(E[] arreglo, int min, int max) {
		E tmp = arreglo[min];
		arreglo[min] = arreglo[max];
		arreglo[max] = tmp;

	}

	public static <E extends Comparable<E>> void imprimeArreglo(E[] arreglo) {
		for (int i = 0; i<arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
	}

	public static void main(String[] args) {
		String[] arreglin = { "Juan", "Daniel", "Pablo", "Mayra", "Frank"};
		bubbleSortGenericos.bubbleSort(arreglin);
		bubbleSortGenericos.imprimeArreglo(arreglin);

	}

}
