import java.util.Arrays;
//Juan Pablo Velazco Velasquez
//A00368753

//FAVOR DE NO BORRAR LOS COMENTARIOS
//NI MOVERLOS DE POSICIÓN
//Completa la firma de la clase
public class ABBSol202011<E extends Comparable<E>> extends ABBAbstract<E> {

	public ABBSol202011() {
		// Llama al constructor padre
		super();
	}

	// Implementar la inserción en el ABB. Puedes suponer que el valor
	// que se va a insertar n
	public void insertar(E valor) {
		System.out.println("Insertando " + valor);
		if (this.size == 0) {
			this.valores[0] = valor;
			this.size++;
			return;
		}

		boolean insertado = false;
		int indice = 0;
		int pos = 0;
		while (!insertado) {
			if (valor.compareTo(this.valores[indice]) < 0) {
				pos = indice * 2 + 1;
				if (pos < this.valores.length) {
					if (this.valores[pos] == null) {
						this.valores[pos] = valor;
						insertado = true;
						this.size++;
					} else {
						indice = (indice * 2) + 1;
					}
				} else {
					expansion();
				}

			} else if (valor.compareTo(this.valores[indice]) > 0) {
				pos = indice * 2 + 2;
				if (pos < this.valores.length) {
					if (this.valores[pos] == null) {
						this.valores[pos] = valor;
						insertado = true;
						this.size++;
					} else {
						indice = (indice * 2) + 2;
					}
				} else {
					expansion();
				}

			}

		}

		// Prueba este método en el main insertando los valores
		// {3969,904,2692,3474,393,2838,2006,1815,2973,4017,2760,4911,2271,3667,2726,3064,4889,4634,2386,4637,926,1143,3015,1125,100,2479,2288,2451,1577,3866,1370,3388,1375,1497,145,1947,1914,871,2645,2122,2584,3569,673,4452,496,3211,4307,4688,4920,2303};

	}

	// Aquí implementa la expansion del arreglo.
	// Se llamará sólo cuando la posicion donde se debe insertar un valor no existe
	protected void expansion() {
		//
		E[] expansion = Arrays.copyOf(this.valores, this.valores.length * 2);
		this.valores = expansion;

	}

	// Funcion de preparación. Después de escribir todo el recorrido debe haber un
	// salto de linea
	public void inorden() {
		inorden(0);
	}

	// Función recursiva que imprime el recorrido inorden del arbol separando cada
	// elemento por una coma
	// y sin espacios en blanco
	protected void inorden(int pos) {
		if(pos) {
			inorden(2 * pos + 1);
			System.out.print(pos + ",");
			inorden(2 * pos + 2);
		}
		

	}

	public static void main(String[] args) {
		// Haz una instancia de esta clase en la cual el genérico sea un Integer
		ABBSol202011<Integer> ejemplo = new ABBSol202011<>();

		// Inicializa un arreglo con los valores a insertar en el ABB.
		// (Descomentaría la siguiente línea y completala)
		Integer[] enteros = { 3969, 904, 2692, 3474, 393, 2838, 2006, 1815, 2973, 4017, 2760, 4911, 2271, 3667, 2726,
				3064, 4889, 4634, 2386, 4637, 926, 1143, 3015, 1125, 100, 2479, 2288, 2451, 1577, 3866, 1370, 3388,
				1375, 1497, 145, 1947, 1914, 871, 2645, 2122, 2584, 3569, 673, 4452, 496, 3211, 4307, 4688, 4920,
				2303 };

		// Haz un ciclo para ir insertando los valores del arreglo en el ABB
		for (int i = 0; i < enteros.length; i++) {
			ejemplo.insertar(enteros[i]);
		}
		
		ejemplo.inorden();

	}

}