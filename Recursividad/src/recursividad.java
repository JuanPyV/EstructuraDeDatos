//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Arreglo.java
//Fecha: 18/08/2019
//Comentarios u observaciones: 

public class recursividad {
	
	private static int multiplicacion(int a, int b) {
		if (b == 0 || a == 0) {
			return 0;
		}if (b == 1) {
			return a;
		}if (a == 1) {
			return b;
		}else {
			System.out.println(b);
			return a + multiplicacion(a, b-1);
		}
	}

	private static int base10a2(int a) {
		if (a == 0) {
			return 0;
		} else {
			return (a % 2 + 10 * base10a2(a / 2));
		}

	}

	public static void main(String[] args) {

		//System.out.println(base10a2(123));
		System.out.println(multiplicacion(5, 1000));
	}

}
