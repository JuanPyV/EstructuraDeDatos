
public class Mergesort {

	public <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length - 1);
	}

	private <E extends Comparable<E>> void mergesort(E[] datos, int min, int max) {
		if (min < max) {
			int central = (min + max) / 2;
			mergesort(datos, min, central);
			mergesort(datos, central + 1, max);
			merge(datos, min, max);
		}
	}

	private static <E extends Comparable<E>> void merge(E[] datos, int min, int max) {
		E[] tmpArreglo = (E[]) new Comparable[max - min + 1];
		int central = (min + max) / 2;

	}

	public static void main(String[] args) {
		int[] numeros = { 2, 3, 8, 6, 7, 4, 1, 9, 5, 0 };
		int numeros2[] = new int[10];
			 
		for (int i = 0; i < numeros.length; i++) {
			numeros2[i] = numeros[i];
		}
		
		for (int i = 0; i< numeros2.length; i++) {
			System.out.print(numeros2[i] + " ");
		}

	}
}
