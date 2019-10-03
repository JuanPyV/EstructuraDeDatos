
public class NReinas {

	private int[] reinas;

	public NReinas(int n) {
		this.reinas = new int[n];
		for (int i = 0; i < this.reinas.length; i++) {
			this.reinas[i] = -1;
		}
	}

	public boolean valida(int fila, int columna) {
		for (int i = 0; i < fila; i++) {
			if (this.reinas[i] == columna) {
				return false;
			}
			if (Math.abs((fila - i)) == Math.abs((columna - this.reinas[i]))) {
				return false;
			}
		}
		return true;
	}

	public void imprimeSolucion() {
		for (int i = 0; i < this.reinas.length; i++) {
			System.out.print(this.reinas[i] + ",");
		}
		System.out.println();
	}

	private void busca(int fila) {
		for (int i = 0; i < this.reinas.length; i++) {
			if (valida(fila, i)) {
				this.reinas[fila] = i;
				if (fila < this.reinas.length - 1) {
					busca(fila + 1);
				} else {
					imprimeSolucion();
				}
			}
		}
	}
	
	public void busca() {
		this.busca(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NReinas tablero = new NReinas(15);
		tablero.busca();
		

	}

}
