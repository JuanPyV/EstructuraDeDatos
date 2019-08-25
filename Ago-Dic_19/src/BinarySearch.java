
public class BinarySearch {
	 /*
	public static int binarySearch(int valor, int[] valores) {
		int min = 0, max = valores.length - 1, avg;
		// si el valor buscado esta en avg regresar la posicion, si no revisar si es
		// mayor o menor del valor buscado y actualizar los indices

		while (min <= max) {
			avg = (min + max) / 2;
			if (valor == valores[avg]) {
				return avg;
			} else if (valor < valores[avg]) {
				max = avg - 1;

			} else {
				min = avg + 1;
			}

		}
		return -1;
	}

	public static <E extends Comparable<E>> int binarySearch(String valor, String[] valores) {
		int min = 0, max = valores.length - 1, avg;

		while (min <= max) {
			avg = (min + max) / 2;
			if (valor.equals(valores[avg])) {
				return avg;
			} else if (valor.compareTo( valores[avg]) < 0) {
				max = avg - 1;

			} else {
				min = avg + 1;
			}
			// si el valor buscado esta en avg regresar la posicion, si no revisar si es
			// mayor o menor del valor buscado y actualizar los indices
		}
		return -1;
	}
	*/
	
	public static <E extends Comparable<E>> int binarySearch(E valor, E[] valores) {
		int min = 0, max = valores.length - 1, avg;

		while (min <= max) {
			avg = (min + max) / 2;
			if (valor.equals(valores[avg])) {
				return avg;
			} else if (valor.compareTo( valores[avg]) < 0) {
				max = avg - 1;

			} else {
				min = avg + 1;
			}
			// si el valor buscado esta en avg regresar la posicion, si no revisar si es
			// mayor o menor del valor buscado y actualizar los indices
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] numeros = { -10, -5, 0, 12, 30, 42, 55, 62, 70, 90 };
		System.out.println(binarySearch(90, numeros));
		String[] palabras = {"alo", "carro", "avion", "troca"};
		System.out.println(binarySearch("troca", palabras));

	}

}
