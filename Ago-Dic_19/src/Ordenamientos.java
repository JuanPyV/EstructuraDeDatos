//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Ordenamientos.java
//Fecha: 01/09/2019
//Comentarios u observaciones:	

public class Ordenamientos<E> {

	/// Bubble sort
	/// --------------------------------------------------------------------------------------------------------------------

	public static void bubbleSort(int[] datos) {
		boolean desordenados = true;
		for (int i = 0; i < datos.length - 1 && desordenados; i++) {
			desordenados = false;
			for (int j = 0; j < datos.length - 1 - i; j++) {
				if (datos[j] > datos[j + 1]) {
					swap(datos, j, j + 1);
					desordenados = true;
				}
			}
		}
	}
	
	public static void swap(int[] datos, int i, int j) {
		int temp = datos[i];
		datos[i] = datos[j];
		datos[j] = temp;
	}
	
	/// Bubble sort genericos
	/// --------------------------------------------------------------------------------------------------------------------

	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		boolean desordenados;
		for (int i = 0; i < datos.length - 1; i++) {
			desordenados = false;
			for (int j = 0; j < datos.length - 1 - i; j++) {
				if (datos[j].compareTo(datos[j + 1]) > 0) {
					swap(datos, j, j + 1);
					desordenados = true;
				}
			}
			if (!desordenados) {
				break;
			}
		}
	}

	public static <E extends Comparable<E>> void swap(E[] datos, int i, int j) {
		E tmp = datos[i];
		datos[i] = datos[j];
		datos[j] = tmp;

	}

	/// Mergesort Genericos
	/// --------------------------------------------------------------------------------------------------------------------

	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length - 1);
	}

	private static <E extends Comparable<E>> void mergesort(E[] datos, int min, int max) {
		if (min < max) {
			int central = (min + max) / 2;
			mergesort(datos, min, central);
			mergesort(datos, central + 1, max);
			merge(datos, min, max);
		}
	}

	private static <E extends Comparable<E>> void merge(E[] datos, int min, int max) {
		E[] tmpArreglo = (E[]) new Comparable[max - min + 1];
		int central = (min + max) / 2, j = min, k = central + 1;

		for (int i = 0; i < tmpArreglo.length; i++) {
			if (j <= central && k <= max) {
				if (datos[j].compareTo(datos[k]) < 0) {
					tmpArreglo[i] = datos[j++];
				} else {
					tmpArreglo[i] = datos[k++];
				}
			} else if (j <= central) {
				tmpArreglo[i] = datos[j++];
			} else {
				tmpArreglo[i] = datos[k++];
			}
		}
		System.arraycopy(tmpArreglo, 0, datos, min, tmpArreglo.length);

	}

	/// Quicksort Genericos
	/// --------------------------------------------------------------------------------------------------------------------

	public static <E extends Comparable<E>> void quicksort(E[] datos) {
		quicksort(datos, 0, datos.length - 1);
	}

	private static <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {
		if (left < right) {
			int p = particionar(datos, left, right);
			quicksort(datos, left, p - 1);
			quicksort(datos, p + 1, right);
		}
	}

	private static <E extends Comparable<E>> int particionar(E[] datos, int left, int right) {
		E p = datos[left];
		int i = left + 1; 
		
		for (int j = left + 1; j <= right; j++) {
			if (datos[j].compareTo(p) < 0) {
				swap(datos, i, j);
				i++;
			}
		}
		swap(datos, left, i-1);
		return i - 1;
	}
	
	

	/// Imprime Arreglo
	/// --------------------------------------------------------------------------------------------------------------------

	public static <E extends Comparable<E>> void imprimeArreglo(E[] arreglo) {
		for (E valor : arreglo) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] arreglin = { "Juan", "Daniel", "Pablo", "Mayra", "Frank", "Paco", "Patricio", "Bob", "Esponja",
				"Batman", "IronMan" };
		Integer[] arreglin2 = { 2,5,3,1 };
		Ordenamientos.mergesort(arreglin);
		Ordenamientos.imprimeArreglo(arreglin);
		
		Ordenamientos.quicksort(arreglin2);
		Ordenamientos.imprimeArreglo(arreglin2);
		/*
		 * String[] arreglin = { "Juan", "Daniel", "Pablo", "Mayra", "Frank" };
		 * Integer[] numerin = {1,67,89,7,0,3,5}; 
		 * Ordenamientos.bubbleSort(arreglin);
		 * Ordenamientos.imprimeArreglo(arreglin); 
		 * Ordenamientos.bubbleSort(numerin);
		 * Ordenamientos.imprimeArreglo(numerin);
		 * int numeros[] = { 64, 34, 25, 12, 22, 11, 90 }; 
		 * imprimeArreglo(numeros);
		 * bubbleSort(numeros); imprimeArreglo(numeros);
		 */

	}
}
