import java.util.NoSuchElementException;

public class EvaluacionParentesis {

	public static boolean evaluaParentesis(String exp) {
		try {
		MyStack<String> pila = new MyStack<String>();
		String[] tokens = exp.split(" ");
		// regla 1 : si encuentra un parentesis que abre se agreag a la pila
		// regla 2: si encuentra un parentesis que cierra pop y este debe hacer match
		// con el mismo tipo de parentesis
		// sino no esta correctamente escrita
		// 2.1: Si al hacer el pop la pila estaba vacia entonces error
		// regla 3: al final si la pila esta vacia es correcto
		String pop;
		for (String t : tokens) {
			switch (t) {
			case "(":
			case "[":
			case "{":
				pila.push(t);
				break;

			case ")":
				pop = pila.pop();
				if (!"(".equals(pop)) {
					System.out.println("No hace match");
					return false;
				}
				break;
			case "]":
				pop = pila.pop();
				if (!"[".equals(pop)) {
					System.out.println("No hace match");
					return false;
				}
				break;
			case "}":
				pop = pila.pop();
				if (!"{".equals(pop)) {
					System.out.println("No hace match");
					return false;
				}
				break;

			}
		}
		return pila.isEmpty();
		}catch(NoSuchElementException ex) {
			System.out.println("El parentesis no tiene a quien lo abra");
			return false;
		}

	}

	public static void main(String[] args) {
		String expresion = "{ ( 5 + [ ( 6 + 2 ) * 3 ] ) / 4 } + ( 8 * 2 )";
		System.out.println(evaluaParentesis(expresion));
	}

}
