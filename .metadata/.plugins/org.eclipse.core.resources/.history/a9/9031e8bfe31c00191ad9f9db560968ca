public class Factorial {
	
	public static long factorial(int n) {
		if(n <=1) {
			return 1;
		} else {
			return n*factorial(n-1); //podemos usar igual (--n)
		}
	}
	
	public static long fibonacci(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}  else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static long fibonacciOpt(int n) {
		long[] tabla = new long[n+1];
		tabla[0] = tabla[1] = 1;
		return fibonacciOpt(n, tabla);
	}
	
	private static long fibonacciOpt(int n, long[] tabla) {
		if (tabla[n] != 0) {
			return tabla[n]; //si ya hay un valor en esa posición en la tabla, que lo regrese así
		} else { //si no, que lo calcule
			tabla[n] = fibonacciOpt(n-1, tabla) + fibonacciOpt(n-2, tabla);
			return tabla[n];
		}
	}
	
	
	public static void main(String[] args) {
		//System.out.println(Factorial.factorial(5));
		long tIni, tFin;
		tIni = System.nanoTime();
		//System.out.println(Factorial.fibonacci(51));
		System.out.println(Factorial.fibonacciOpt(1000));
		tFin = System.nanoTime();
		double total = tFin - tIni;
		System.out.println("Tiempo en segundos " + total/1000000000.0);
	}
}