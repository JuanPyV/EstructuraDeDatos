// Juan Pablo Velazco Velasquez A00368753

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyABBFinal<E extends Comparable<E>> extends MyABBFinalPadre<E> implements Iterable<NodoABB> {
	
	
	@Override
	public Iterator<NodoABB> iterator() {
		return new Iterator<NodoABB>() {
			
			NodoABB<E> root = raiz;
			
			Queue<NodoABB> cola = new LinkedList<>();
			
			{
				cola.add(root);
			}

			@Override
			public boolean hasNext() {
				if (cola.peek() != null) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public NodoABB next() {
				if (hasNext()) {
					if(root.izq != null) {
						cola.add(root.izq);
					}if(root.der != null) {
						cola.add(root.der);
					}				
					
					return cola.poll();
				} else {
					return null;
				}

			}
		};
	}
	public static void main(String[] args) {
	}
}
