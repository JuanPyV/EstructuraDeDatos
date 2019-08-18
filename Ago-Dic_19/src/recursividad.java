//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: recursividad 
//Fecha: 18/08/2019
//Comentarios u observaciones: 

public class recursividad {
	
	private static int multPrep(int a, int b) {
		if (a < 0 && b < 0) {
			return multiplicacion(a, b);
		}if (a < 0) {
			return multiplicacion(a, b) * -1;
		}if (b < 0 ) {
			return multiplicacion(a, b) * -1;
		}else {
			return multiplicacion(a, b);
		}
		
	}
	
	private static int multiplicacion(int a, int b) {
		if(b == 1) {
			return a;
		}else{
			if( a < 0 && b < 0) {
				a = a * -1;
				b = b * -1;
				return b + multiplicacion(b, a-1);
			}
			if(a < 0) {
				a = a * -1;
				return b + multiplicacion(b, a-1);
			}if(b < 0) {
				b = b * -1;
				return a + multiplicacion(a, b-1);
			}
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

		int base = 123;
		int a = 0;
		int b = -5;
		System.out.println("El numero " + base + " en binario es: " + base10a2(base));
		System.out.println("El resultado de la operacion es: " + multPrep(a, b));
	}

}
