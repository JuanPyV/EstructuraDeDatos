//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MyHashtable.java
//Fecha: 06/05/2020
//Comentarios u observaciones: 	

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<V, K> {
	// Direccionamiento por encadenamiento
	private LinkedList<NodoHT<K, V>>[] tabla;
	private int size;

	public MyHashTable() {
		// Valor impar o primo
		this(11);
	}

	public MyHashTable(int legth) {
		this.tabla = (LinkedList<NodoHT<K, V>>[]) new LinkedList[legth];
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<NodoHT<K, V>>();
		}
		this.size = 0;
	}

	// Validar si la tabla no ha excedido el factor de carga
	// Factor de carga máximo = 0.75
	public void put(K llave, V valor) {
		// Si el factor de carga es mayor al permitido -> rehashing
		if ((double) this.size / this.tabla.length > 0.75) {
			rehashing();
		}
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		this.tabla[pos].addFirst(new NodoHT<>(llave, valor));
		this.size++;
	}

	public V get(K llave) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		LinkedList<NodoHT<K, V>> lista = this.tabla[pos];
		// Para cada nodo de la lista
		for (NodoHT<K, V> nodo : lista) {
			if (nodo.llave.equals(llave)) {
				return nodo.valor;
			}
		}
		throw new NoSuchElementException("No se encontró la llave " + llave + " en la tabla");
	}

	// Este método se mandará a llamar al inicio del put cuando el factor de carga
	// se ha excedido (0.75). Deberá duplicar + 1, la capacidad del arreglo.
	////// rehashing
	private void rehashing() {
		LinkedList<NodoHT<K, V>>[] temporal = this.tabla;
		this.tabla = (LinkedList<NodoHT<K, V>>[]) new LinkedList[this.tabla.length * 2 + 1];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new LinkedList<>();
		}
		for (int i = 0; i < temporal.length; i++) {
			if (temporal[i].size() > 0) {
				for (int j = 0; j < temporal[i].size(); j++) {
					int pos = temporal[i].get(j).llave.hashCode() % this.tabla.length;
					if (pos < 0) {
						pos = pos * -1;
					}
					this.tabla[pos].addLast(temporal[i].get(j));
				}
			}
		}

	}

	////// Hacer el delete
	public V delete(K llave) {
		int index = Math.abs(llave.hashCode() % this.tabla.length);
		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].get(i).llave.equals(llave)) {
				this.size--;
				return tabla[index].remove(i).getValor();
			}
		}
		throw new NoSuchElementException("La llave: " + llave + ", no fue encontrada");
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	///// hacer el containsKey
	// Regresa si la llave pasada como parámetro está en la hastable o no
	// Regresa si la llave K, está en la HT.
	public boolean containskey(K llave) {
		int index = Math.abs(llave.hashCode() % this.tabla.length);
		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].get(i).llave.equals(llave)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}

class NodoHT<K, V> {
	K llave;
	V valor;

	public NodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}

	public K getLlave() {
		return llave;
	}

	public V getValor() {
		return valor;
	}

	public void setLlave(K llave) {
		this.llave = llave;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}
}