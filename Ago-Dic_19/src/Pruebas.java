import java.util.Stack;

public class Pruebas {

	private String expresionInfija;

	public Pruebas(String expresionInfija) {
		super();
		this.expresionInfija = expresionInfija;
	}

	public void setExpresionInfija(String expresionInfija) {
		this.expresionInfija = expresionInfija;
	}

	public static String expresionPostfijo(String exp) {

		exp = "( " + exp + " )";
		String[] arrayInfix = exp.split(" ");

		Stack<String> pilaEntrada = new Stack<String>();
		Stack<String> pilaTemp = new Stack<String>();
		Stack<String> pilaSalida = new Stack<String>();

		for (int i = arrayInfix.length - 1; i >= 0; i--) {
			pilaEntrada.push(arrayInfix[i]);
		}

		while (!pilaEntrada.isEmpty()) {
			switch (jerarquia(pilaEntrada.peek())) {
			case 1:
				pilaTemp.push(pilaEntrada.pop());
				break;
			case 3:
			case 4:
				while (jerarquia(pilaTemp.peek()) >= jerarquia(pilaEntrada.peek())) {
					pilaSalida.push(pilaTemp.pop());
				}
				pilaTemp.push(pilaEntrada.pop());
				break;
			case 2:
				while (!pilaTemp.peek().equals("(")) {
					pilaSalida.push(pilaTemp.pop());
				}
				pilaTemp.pop();
				pilaEntrada.pop();
				break;
			default:
				pilaSalida.push(pilaEntrada.pop());
			}
		}

		String expresionPosfija = pilaSalida.toString().replaceAll("[\\]\\[,]", "");
		return expresionPosfija;
	}

	private static int jerarquia(String op) {
		int prf = 0;
		if (op.equals("^"))
			prf = 5;
		if (op.equals("*") || op.equals("/"))
			prf = 4;
		if (op.equals("+") || op.equals("-"))
			prf = 3;
		if (op.equals(")"))
			prf = 2;
		if (op.equals("("))
			prf = 1;
		return prf;
	}

	public static Double evaluaExpresion(String expresion) {
		String[] post = expresion.split(" ");

		Stack<String> pilaEntrada = new Stack<String>();
		Stack<String> pilaTemp = new Stack<String>();

		for (int i = post.length - 1; i >= 0; i--) {
			pilaEntrada.push(post[i]);
		}

		String operadores = "+-*/%";
		while (!pilaEntrada.isEmpty()) {
			if (operadores.contains("" + pilaEntrada.peek())) {
				pilaTemp.push(evaluar(pilaEntrada.pop(), pilaTemp.pop(), pilaTemp.pop()) + "");
			} else {
				pilaTemp.push(pilaEntrada.pop());
			}
		}

		return Double.parseDouble(pilaTemp.peek());

	}

	private static double evaluar(String op, String n2, String n1) {
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		if (op.equals("+"))
			return (num1 + num2);
		if (op.equals("-"))
			return (num1 - num2);
		if (op.equals("*"))
			return (num1 * num2);
		if (op.equals("/"))
			return (num1 / num2);
		if (op.equals("%"))
			return (num1 % num2);
		return 0;
	}

	public static void main(String[] args) {

		String expr = "2 * ( 23 + 6 ) - 1";
		System.out.println("Expresion Posfija: " + expresionPostfijo(expr));
		System.out.println("Resultado: " + evaluaExpresion(expresionPostfijo(expr)));

	}

}