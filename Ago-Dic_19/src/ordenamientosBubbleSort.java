
public class ordenamientosBubbleSort {

	public static void bubbleSort(int[] datos) {
		boolean desordenados = true;
		for (int i = 0; i < datos.length - 1  && desordenados; i++) {
			desordenados = false;
			for (int j = 0; j < datos.length - 1-i; j++) {
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
	
	public static void imprimeArreglo(int[] arreglo) {
		for (int valor : arreglo) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numeros[] = { 64, 34, 25, 12, 22, 11, 90 };
		imprimeArreglo(numeros);
		bubbleSort(numeros);
		imprimeArreglo(numeros);

	}

}
