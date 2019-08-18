
public class Fibonacci {
	
	public static long fibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static long fibonacciOpt(int n) {
		long[] calculados = new long[n+1];
		calculados[0] = calculados[1] = 1;
		return fibonacciOpt(n, calculados);
	}
	
	public static long fibonacciOpt(int n,long[] calculados) {
		if (calculados[n] > 0) {
			return calculados[n];
		}else {
			calculados[n] = fibonacciOpt(n-1, calculados) + fibonacciOpt(n-2, calculados);
			return calculados[n];
		}
	}

	public static void main(String[] args) {
		
	long ini = System.nanoTime();
	System.out.println(fibonacciOpt(500));
	long fin = System.nanoTime();
	long duracion = fin- ini;
	System.out.println("Tardó: "+duracion/1000000000.0 + "seg");

	}
}
