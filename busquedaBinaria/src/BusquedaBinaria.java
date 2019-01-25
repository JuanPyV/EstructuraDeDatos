
public class BusquedaBinaria {

	public static int binarySearch(int valor, int[] datos) {
		int min = 0, max = datos.length - 1, avg;
		
		while (min <= max) {
			avg = (min + max) / 2;
			if (datos[avg] == valor) {
				return avg;
			}
			else if (datos[avg] < valor) {
				min = avg + 1;
			} else {
				max = avg - 1;
			}
		}
		return -1;
	}
	
	public static <E extends Comparable <E>> int binarySearch(E valor, E[] datos) {
		int min = 0, max = datos.length - 1, avg;
		
		while (min <= max) {
			avg = (min + max) / 2;
			if (valor.equals(datos[avg])) {
				return avg;
			}
			else if (valor.compareTo(datos[avg]) < 0) {
				min = avg + 1;
			} else {
				max = avg - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] numeros = {-10, -5, 0, 12, 30, 42, 55, 62, 70, 90};		
		System.out.println(binarySearch(90, numeros));
		String[] palabras = {"Daniel",  "Esau",  "Francisco", "Juan","Luis", "Martin", "Oscar", "Santiago"};
		System.out.println(binarySearch("Esau", palabras));

	}
}