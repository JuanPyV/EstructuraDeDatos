
public class bubbleSort {

	public static void bubbleSort(int[] valores) {
		boolean cambio;
		for (int i = 0; i < valores.length - 1; i++) {
			cambio = false;
			for (int j = 0; j < valores.length - 1 - i; j++) {
				if (valores[j] > valores[j + 1]) {
					swap(valores, j, j + 1);
					cambio = true;
				}
			}
			if (!cambio) {
				break;
			}
		}
	}

	public static void swap(int[] arreglo, int min, int max) {
		int tmp = arreglo[min];
		arreglo[min] = arreglo[max];
		arreglo[max] = tmp;

	}

	public static void imprimeArreglo(int[] arreglo) {
		for (int valor : arreglo) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int numeros[] = { 64, 34, 25, 12, 22, 11, 90 };
		imprimeArreglo(numeros);
		bubbleSort(numeros);
		imprimeArreglo(numeros);
	}

}
