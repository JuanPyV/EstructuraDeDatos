import javax.swing.JOptionPane;

//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Arreglo.java
//Fecha: 19/01/2019
//Comentarios u observaciones: 

public class Arreglo {

	public static void main(String[] args) {
		
		int number, borrar, agregar, numAgregar;
		int n = 10;
		int[] arreglo = new int[10];
		
		for (int i=0; i<n; i++) {
			number = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero"));
			arreglo[i] = number;
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(Integer.toString(arreglo[i]) +" ");
		}
		
		borrar = Integer.parseInt(JOptionPane.showInputDialog("Que posicion quieres borrar?"));
		if ( arreglo[borrar-1] == 0) {
			System.out.println("\n"+"No hay numero en esa posicion");
		}else {
			arreglo[borrar-1] = 0;
			System.out.println("\n" + "El numero ah sido BORRADO");
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(Integer.toString(arreglo[i]) +" ");
		}
		
		agregar = Integer.parseInt(JOptionPane.showInputDialog("En que posicion quieres agregar?"));
		if ( arreglo[agregar-1] != 0) {
			System.out.println("\n"+"Existe un numero en esa posicion");
		}else {
			numAgregar = Integer.parseInt(JOptionPane.showInputDialog("Que numero quieres agregar a esa posicion?"));
			arreglo[agregar-1] = numAgregar;
			System.out.println("\n" + "El numero ah sido AGREGADO");
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(Integer.toString(arreglo[i]) +" ");
		}
	}
}
