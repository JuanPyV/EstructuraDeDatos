//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Ordenamientos.java
//Fecha: 23/02/2020
//Comentarios u observaciones:	

public class Ordenamientos {

	// Bubble sort

	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		boolean desordenado = true;
		for (int i = 0; i < datos.length - 1; i++) { // el numero de iteraciones que requiero
			desordenado = false;
			for (int j = 0; j < datos.length - 1 - i; j++) {// recorrer el erreglo y van a comparar de 2 en 2 elementos,
															// si no estan acomodados intercambiar
				if (datos[j].compareTo(datos[j + 1]) > 0) {
					swap(datos, j, j + 1);
					desordenado = true;
				}
			}
		}
	}

	private static <E> void swap(E[] datos, int i, int j) {
		E aux = datos[i];
		datos[i] = datos[j];
		datos[j] = aux;
	}

	// Mergesort

	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length - 1);
	}

	private static <E extends Comparable<E>> void mergesort(E[] datos, int primero, int ultimo) {
		if (primero < ultimo) {
			int central = (primero + ultimo) / 2;
			mergesort(datos, primero, central);
			mergesort(datos, central + 1, ultimo);
			mezcla(datos, primero, ultimo);
		}
	}

	private static <E extends Comparable<E>> void mezcla(E[] datos, int primero, int ultimo) {
		// El arreglo de datos esta ordenado desde primero-central y de central+1-ultimo
		// pasar los datos ordenados a nuevo arreglo y que queden ordenanod
		// Al final regresar los datos al arreglo original
		E[] tmpArreglo = (E[]) new Comparable[ultimo - primero + 1];
		int central = (primero + ultimo) / 2, j = primero, k = central + 1;

		for (int i = 0; i < tmpArreglo.length; i++) {
			if (j <= central && k <= ultimo) {
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
		System.arraycopy(tmpArreglo, 0, datos, primero, tmpArreglo.length);

	}

	// Quicksort

	public static <E extends Comparable<E>> void quicksort(E[] datos) {
		quicksort(datos, 0, datos.length - 1);
	}

	public static <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {

		if (left < right) {
			int posPivote = particion(datos, left, right);
			quicksort(datos, left, posPivote - 1);
			quicksort(datos, posPivote + 1, right);
		}
	}

	private static <E extends Comparable<E>> int particion(E[] datos, int left, int right) {
		/*
		 * E p = datos[left]; int i = left + 1; for (int j = left + 1; j < right; j++) {
		 * if (datos[j].compareTo(p) < 0) { swap(datos, i, j); i++; } } swap(datos,
		 * left, i - 1); return i - 1; }
		 */

		E p = datos[left];
		int i = left + 1;

		for (int j = left + 1; j <= right; j++) {
			if (datos[j].compareTo(p) < 0) {
				swap(datos, i, j);
				i++;
			}
		}
		swap(datos, left, i - 1);
		return i - 1;
	}

	////////////////////////////////////////////////////////////////////

	private static <E> void imprimirArreglo(E[] datos) {
		for (E tmp : datos) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] datos = { 321, 65132, 165, 13, 165, 12, 316, 51, 34, 61, 2 };
		imprimirArreglo(datos);
		bubbleSort(datos);
		imprimirArreglo(datos);

		String[] arreglin = { "mythical", "mightiest", "cuddly", "distant", "sissy", "cyanide", "pillbox", "glamor",
				"blink", "cuddle", "dinosaur", "horrible" };
		imprimirArreglo(arreglin);
		// Ordenamientos.mergesort(arreglin);
		Ordenamientos.quicksort(arreglin);
		imprimirArreglo(arreglin);
		// TODO Auto-generated method stub

	}

}
