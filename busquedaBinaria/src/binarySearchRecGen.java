//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: binarySearchRecGen.java
//Fecha: 26/01/2019
//Comentarios u observaciones: 	

public class binarySearchRecGen {

	public static <E extends Comparable<E>> int binarySearchRec(E[] valores, E valor) {		
		return binarySearchRec(valores, valor, 0, valores.length - 1);
	}

	
	private static <E extends Comparable<E>> int binarySearchRec(E[] valores, E valor, int min, int max) {
		int avg;
		
		avg = (min + max) / 2;	
			if (valor.equals(valores[avg])) {
				return avg;
			}
			else if (valor.compareTo(valores[avg]) < 0) {
				return binarySearchRec(valores, valor, min, avg-1);
			} else if (valor.compareTo(valores[avg]) > 0){
				return binarySearchRec(valores, valor, avg+1, max);
			}

		return -1;
	}

	public static <E> void main(String[] args) {

		String[] palabritas = {"ardilla", "ballena", "cabra", "delfin", "elefante", "foca", "gato", 
				"hiena", "iguana", "jirafa", "perro", "koala"};
		System.out.println(binarySearchRec(palabritas, "ballena"));
	}
	
}
