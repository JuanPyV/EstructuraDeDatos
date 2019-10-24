//Autor: A00368753 Juan Pablo Velazco Velasquez
//Nombre de la clase: MyHashtable.java
//Fecha: 03/10/2019
//Comentarios u observaciones: 	

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<V, K> {

	private LinkedList<MyNodeHT<K, V>>[] tabla;
	private int size;
	private static final double LoafFactor = 0.75;

	// constructor, se crea la talba de tamaño 11 y agrego una LinkedList a cada
	// espacio
	public MyHashTable() {
		this.tabla = (LinkedList<MyNodeHT<K, V>>[]) new LinkedList[11];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new LinkedList<>();
		}
		this.size = 0;

	}

	// put(llave, valor
	public void put(K llave, V valor) {
		if ((double) this.size / this.tabla.length > MyHashTable.LoafFactor) {
			rehashing();
		}
		int pos = Math.abs(llave.hashCode()) % this.tabla.length;
		this.tabla[pos].add(new MyNodeHT<K, V>(llave, valor));
		this.size++;

	}

	// priavte rehashing(): incrementa el tamaño de la lista al doble + 1 cuando se
	// exceda loadfactor
	private void rehashing() {
		LinkedList<MyNodeHT<K, V>>[] temporal = this.tabla;
		this.tabla = (LinkedList<MyNodeHT<K, V>>[]) new LinkedList[this.tabla.length * 2 + 1];
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

	// get(llave):valor
	public V get(K llave) {
		int pos = llave.hashCode() % this.tabla.length;
		for (int i = 0; i < this.tabla[pos].size(); i++) {
			if (this.tabla[pos].get(i).llave.equals(llave)) {
				return this.tabla[pos].get(i).valor;
			}
		}
		throw new NoSuchElementException("No se encontró un valor que contenga esa llave");

	}

	public V remove(K llave) {
		// borra de la tabla el elemento que tiene esa llave y regresa el valor asociado
		// si la llave no esta arroja nosuchelementexception
		int index = llave.hashCode() % this.tabla.length;
		for (int i = 0; i < tabla[index].size(); i++) {
			if (tabla[index].get(i).llave.equals(llave)) {
				this.size--;
				return tabla[index].remove(i).getValor();
			}
		}
		throw new NoSuchElementException("La llave: " + llave + ", no fue encontrada");
	}

	// containsKey(llave): boolean true si la llave esta en la hashtable
	public boolean containsKey(K llave) {
		int index = llave.hashCode() % this.tabla.length;
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

class MyNodeHT<K, V> {
	K llave;
	V valor;

	public MyNodeHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}

	public String toString() {
		return "Llave: " + this.llave + ", Valor: " + this.valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public K getLlave() {
		return llave;
	}

	public V getValor() {
		return valor;
	}

}
