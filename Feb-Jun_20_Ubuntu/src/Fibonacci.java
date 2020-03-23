
public class Fibonacci {

	// Si no hace referencia a ningun atributo de la clase, el metodo puede ser
	// estatico (de preferencia)

	public static long fibonacci(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// funcion de preparacion; inicializa valores, manda llamar la funcion de
	// recursion
	public static long fibonacciOpt(int n) {
		long[] res = new long[n + 1];
		res[0] = res[1] = 1;
		return fibonacciOpt(n, res);
	}

	private static long fibonacciOpt(int n, long[] res) {
		if (res[n] != 0) {
			return res[n];
		}
		res[n] = fibonacciOpt(n - 1, res) + fibonacciOpt(n - 2, res);
		return res[n];
	}

	public static void main(String[] args) {
		long ini = System.nanoTime(), fin;
		System.out.println(Fibonacci.fibonacciOpt(9999));
		fin = System.nanoTime();
		System.out.println("Se tardo " + (fin - ini) / 1000000000.0);
	}

}
