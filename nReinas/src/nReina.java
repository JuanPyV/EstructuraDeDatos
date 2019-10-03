public class nReina {
	private int[] reinas;
	
	public nReina(int n) {
		this.reinas = new int[n];
		for( int i = 0; i<this.reinas.length; i++) {
			this.reinas[i] = -1;
		}
	}
	
	public boolean valida(int fila, int columna) {
		for (int i=0; i<fila; i++) {
			//Validar que no haya otra reina en la misma columna 
			if (columna == this.reinas[i]) {
				return false;
			}
			//Validar que no esten en la misma diagonal
			if(Math.abs(fila-i) == Math.abs(columna-this.reinas[i])) {
				return false;
			}
		}
		return false;
	}
	
	public void busca(int fila) {
		for(int i=0; i<this.reinas.length; i++) {
			if (valida(fila,i)) {
				this.reinas[fila] = i;
				if(fila<this.reinas.length-1) {
					busca(fila+1);
				}else {
					//Imprimir el resultado
					imprimeSolucion();
				}
			}
		}
	}
	
	public void busca() {
		this.busca(0);
	}
	
	public void imprimeSolucion() {
		for(int pos:this.reinas) {
			System.out.print(pos+",");
		}
		System.out.println();
	}
	
	
	public static void main(String [] args) {
		nReina tablero = new nReina(4);
		tablero.busca();
	}
}
