//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Recursion.java
//Fecha: 15/02/2020
//Comentarios u observaciones:	

public class Recursion {

	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor) {

		return buscaUltimo(valores, valor, 0);
	}

	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor, int pos) {

		if (pos == valores.length) {
			return -1;
		} else if (valores[pos].equals(valor)) {
			int tmp = pos;
			System.out.println("Indice: " + tmp);
			int x = buscaUltimo(valores, valor, pos + 1);
			if (x > tmp) {
				return x;
			}
			return pos;
		} else {
			return buscaUltimo(valores, valor, pos + 1);
		}

	}

	public static void main(String[] args) {

		Integer[] numeros = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(buscaUltimo(numeros, 8));

	}

}
