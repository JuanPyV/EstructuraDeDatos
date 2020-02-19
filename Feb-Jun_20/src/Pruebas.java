
public class Pruebas {

	public static void main(String[] args) {

		int[] array = { 5, 4, 3, 2, 1, 1, 2, 3, 4, 5 };
		int elementoBuscar = 4;
		System.out.println(array.length);
		int posElementoENcontrado = posicionElementoRecursivo(array, elementoBuscar, 0);

		System.out.println(posElementoENcontrado);

	}

	public static int posicionElementoRecursivo(int[] array, int elementoBuscar, int indice) {
		if (indice == array.length) {
			return -1;
		} else if (array[indice] == elementoBuscar) {
			int tmp = indice;
			System.out.println("Indice: " + tmp);
			posicionElementoRecursivo(array, elementoBuscar, indice + 1);
			if (tmp < indice) {
				indice = tmp;
			}
			return indice;
		} else {
			return posicionElementoRecursivo(array, elementoBuscar, indice + 1);
		}

	}

}
