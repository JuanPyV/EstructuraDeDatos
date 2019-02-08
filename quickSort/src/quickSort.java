
public class quickSort {

	public static <E extends Comparable<E>> void quicksort(E[] datos) {
		quicksort(datos, 0, datos.length - 1);
	}

	private static <E extends Comparable<E>> void quicksort(E[] datos, int min, int max) {
		if (min < max) {
			int p = particionar(datos, min, max);
			quicksort(datos, min, p - 1);
			quicksort(datos, p + 1, max);
		}
	}

	private static <E extends Comparable<E>> int particionar(E[] datos, int min, int max) {
		// va a particionar el arreglo en los menores a p y los mayores a p
		// y regresa la posicion donde queda el pivote
		E p = datos[min];
		int i = min + 1; 
		
		for (int j = min + 1; j <= max; j++) {
			if (datos[j].compareTo(p) < 0) {
				swap(datos, i, j);
				i++;
			}
		}
		swap(datos, min, i-1);
		return i - 1;
	}

	private static <E> void swap(E[] datos, int i, int j) {
		E tmp = datos[i];
		datos[i] = datos[j]; 
        datos[j] = tmp; 

	}

	public static void main(String[] args) {
		
		 //Integer[] arreglito = {10, 7, 8, 9, 1, 5};
		 String[] arreglito = { "1959", "1809", "1953", "1950", "PRIMERA", "AM�RICA", "CUENTOS", "DE", "DE", "DEL",
					"DEL", "EL", "EL", "REVISTA", "EN", "ANTERIORMENTE", "EN", "LLANO", "EN", "EN", "ES", "ESCRITOR",
					"ESCRITOR", "FUE", "HAB�A", "JUAN", "MEXICANO", "LA", "RULFO", "LA", "LLAMAS", "PERO", "PUBLICACI�N",
					"PUBLICADO", "RECOPILACI�N", "SE", "T�TULO", "UNA", "PEDRO" };
		 quickSort.quicksort(arreglito);
		 
		 
		 for (int i = 0; i < arreglito.length; i++) {
				System.out.print(arreglito[i] + " ");
			}

	}

}
