
public class NReinas {

	private int[] tablero;

	public NReinas(int n) {
		this.tablero = new int[n];

	}

	private void imprimeTablero() {
		for (int i = 0; i < this.tablero.length; i++) {
			System.out.print(this.tablero[i] + ",");
		}
		System.out.println();
	}

	private boolean valida(int fila, int columna) {
		for (int i = 0; i < columna; i++) {
			// Validar que no haya otra reina en la misma fila en las columnas anteriores
			if (this.tablero[i] == fila) {
				return false;
			}
			if (Math.abs((columna - i)) == Math.abs((fila - this.tablero[i]))) {
				return false;
			}
		}
		return true;
	}
	
	private void busca(int columna) {
		for(int i=0; i<this.tablero.length;i++) {
			if(valida(i, columna)) {
				this.tablero[columna]=i;
			}if (columna == this.tablero.length -1) {
				imprimeTablero();
			}else {
				busca(columna+1);
			}
		}
	}
	

	public void busca() {
		busca(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NReinas reinas = new NReinas(4);
		reinas.busca(0);
	}

}
