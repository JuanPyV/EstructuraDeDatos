import java.util.NoSuchElementException;

public class MyHashTable<k, v> {
	private MiListaEnlazada<MyNodeHash<k, v>>[] tabla;
	private int size;
	private MyNodeHash<k, v> inicio;
	private static final double LOAD_FACTOR = 0.75;
	// load factor es relacion entre numero de datos y tamaño de arreglo
	// si tenemos un arreglo de 100 el maximo numero de datos es 75

	public MyHashTable() {
		this.tabla = (MiListaEnlazada<MyNodeHash<k, v>>[]) new MiListaEnlazada[11];
		// agregas listas enlazadas en casa pocision de la tabla
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}
		this.size = 0;
	}

	public void put(k llave, v valor) {
		// si la llave ya existe se sobreescribe el valor de ahuevo
		int index = llave.hashCode() % this.tabla.length;
		this.tabla[index].insertarFin(new MyNodeHash<>(llave, valor));
		this.size++;
		// verifico si excedi el numero de carga
		if ((double) this.size / this.tabla.length > MyHashTable.LOAD_FACTOR) {
			rehashing();
		}
	}

	public void rehashing() {
		// genera una nueva tabla de tamaño doble + 1 y guarda los elementos de la tabla
		// anterior en la nueva tabla
		// la tabla grande sera la nueva tabla, IMPORTANTE reacomodar los elementos en
		// la nueva tabla.

		MiListaEnlazada<MyNodeHash<k, v>>[] tablaTemp = this.tabla;
		this.tabla = (MiListaEnlazada<MyNodeHash<k, v>>[]) new MiListaEnlazada[this.tabla.length * 2 + 1];

		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}

		for (int i = 0; i < tablaTemp.length; i++) {

			if (tablaTemp[i].size() > 0) {
				for (int j = 0; j < tablaTemp[i].size(); i++) {
					int pos = tablaTemp[i].getEn(j).llave.hashCode() % this.tabla.length;
					this.tabla[pos] = tablaTemp[i];
				}
			}

		}

	}

	public v get(k llave) {
		// calcular el indice donde deberia estar la llave
		// buscar en la lista si esta un nodo con la la llave buscada, si esta regresar
		// el valor si no no such element
		int index = llave.hashCode() % this.tabla.length;
		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].getEn(i).llave.equals(llave)) {
				return tabla[index].getEn(i).valor;
			}
		}
		throw new NoSuchElementException("La llave: " + llave + ", no fue encontrada");

	}

	public v delete(k llave) {
		// calcular el indice donde deberia estar la llave
		// buscar en la lista si esta un nodo con la llave buscada, si esta borrar el
		// nodo con la llave si no // no sush element
		int index = llave.hashCode() % this.tabla.length;
		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].getEn(i).llave.equals(llave)) {
				return tabla[index].borrarEn(i).getValor();
			}
		}
		throw new NoSuchElementException("La llave: " + llave + ", no fue encontrada");
	}

	public boolean containsKey(k llave) {
		// regresa true si la tabla tiene la llave que paso como parametro
		int index = llave.hashCode() % this.tabla.length;

		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].getEn(i).llave.equals(llave)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		// vacia la tabla
		this.tabla = (MiListaEnlazada<MyNodeHash<k, v>>[]) new MiListaEnlazada[11];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}
		this.size = 0;

	}

	public static void main(String[] args) {

		MyHashTable<Integer, String> tablita = new MyHashTable<>();
		tablita.put(2, "Hola");
		tablita.put(3, "Como");
		tablita.put(4, "Estas");
		tablita.put(5, "Yo");
		tablita.put(6, "Bien");
		tablita.put(7, "Adios");
		System.out.println(tablita.get(5));
		tablita.rehashing();
		System.out.println(tablita.containsKey(3));
		System.out.println(tablita.delete(6));
		tablita.clear();

	}

}

class MyNodeHash<k, v> {
	k llave;
	v valor;

	public MyNodeHash(k llave, v valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}

	public v getValor() {
		return valor;
	}

	public void setValor(v valor) {
		this.valor = valor;
	}

	public k getLlave() {
		return llave;
	}

}