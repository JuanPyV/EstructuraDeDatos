//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: evaluarExpresion (implementacion de stack para postfijos) 
//Fecha: 22/03/2020
//Comentarios u observaciones: busque y me apoye de un algoritmo 

import java.util.Stack;

public class evaluarExpresiones {

	private String expresionInfija;

	public evaluarExpresiones(String expresionInfija) {
		super();
		this.expresionInfija = expresionInfija;
	}

	public void setExpresionInfija(String expresionInfija) {
		this.expresionInfija = expresionInfija;
	}

	public String expresionPostfijo() {

		String exp = "( " + this.expresionInfija + " )";
		String[] arrayInfijo = exp.split(" ");

		Stack<String> pilaEntrada = new Stack<String>();
		Stack<String> pilaTemp = new Stack<String>();
		Stack<String> pilaSalida = new Stack<String>();

		for (int i = arrayInfijo.length - 1; i >= 0; i--) {
			pilaEntrada.push(arrayInfijo[i]);
		}

		while (!pilaEntrada.isEmpty()) {
			switch (jerarquia(pilaEntrada.peek())) {
			case 1:
				pilaTemp.push(pilaEntrada.pop());
				break;
			case 3:
			case 4:
			case 5:
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
		this.expresionInfija = expresionPosfija;
		return expresionPosfija;
	}

	private static int jerarquia(String op) {	
		if (op.equals("^"))
			return 5;
		if (op.equals("*") || op.equals("/"))
			return 4;
		if (op.equals("+") || op.equals("-"))
			return 3;
		if (op.equals(")"))
			return 2;
		if (op.equals("("))
			return 1;
		return 0;
	}

	public Double evaluaExpresion() {
		String[] post = this.expresionInfija.split(" ");

		Stack<String> pilaEntrada = new Stack<String>();
		Stack<String> pilaTemp = new Stack<String>();

		for (int i = post.length - 1; i >= 0; i--) {
			pilaEntrada.push(post[i]);
		}

		String operadores = "+-*/^";
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
		if (op.equals("^"))
			return (Math.pow(num1, num2));
		return 0;
	}

	public static void main(String[] args) {

		//String expr = "10 + 20 * ( 50 / 2 ) - 5.8";
		//evaluarExpresiones expresion = new evaluarExpresiones(expr);
		//System.out.println("Expresion Posfija: " + expresion.expresionPostfijo());
		//System.out.println("Resultado: " + expresion.evaluaExpresion());

	}
}