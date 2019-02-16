
public class InsertionSort {

	public static <E extends Comparable<E>> void ordena (E[] datos) {
		for (int i = 0; i < datos.length-1; i++) {
			int pos = i;
			for (int j = i+1 ; j < datos.length; j++) {
				if (datos[j].compareTo(datos[pos]) < 0) {
					pos = j;
				}
			}
			E tmp = datos[pos];
			datos[pos] = datos[i];
			datos[i] = tmp;
		}
	}
	
	public static <E extends Comparable<E>> void imprime(E[] datos){
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer datos[] = {0,-1,-14,-36,20,100,9099,100,2312,321};
		InsertionSort.imprime(datos);
		InsertionSort.ordena(datos);
		InsertionSort.imprime(datos);
	}

}
