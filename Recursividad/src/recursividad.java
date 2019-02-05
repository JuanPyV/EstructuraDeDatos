//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: Arreglo.java
//Fecha: 19/01/2019
//Comentarios u observaciones: 

public class recursividad {

	public static void main(String[] args) {
		
		System.out.println(sumatoria(10));
		System.out.println(base10a2(123));

	}
	
	private static int sumatoria(int num){
		  if (num==0)
		    return 0;
		  else
		    return num + sumatoria(num-1);
		}
	
	private static int base10a2 (int a) {
		if(a == 0){
		    return 0;
		  }else{
			  return (a % 2 + 10 * base10a2(a / 2));
		  }
		
	}

}