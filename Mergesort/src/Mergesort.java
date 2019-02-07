//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Mergesort.java
//Fecha: 05/02/2019
//Comentarios u observaciones: 

public class Mergesort {

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

	public static void main(String[] args) {
		String[] palabritas = { "1959", "1809", "1953", "1950", "PRIMERA", "AMÉRICA", "CUENTOS", "DE", "DE", "DEL",
				"DEL", "EL", "EL", "REVISTA", "EN", "ANTERIORMENTE", "EN", "LLANO", "EN", "EN", "ES", "ESCRITOR",
				"ESCRITOR", "FUE", "HABÍA", "JUAN", "MEXICANO", "LA", "RULFO", "LA", "LLAMAS", "PERO", "PUBLICACIÓN",
				"PUBLICADO", "RECOPILACIÓN", "SE", "TÍTULO", "UNA", "PEDRO" };

		Mergesort.mergesort(palabritas);

		for (int i = 0; i < palabritas.length; i++) {
			System.out.print(palabritas[i] + " ");
		}

	}
}
