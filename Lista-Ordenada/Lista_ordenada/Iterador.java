package Lista_ordenada;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {
    private Nodo<T> cursor;
    
    public Iterador(Nodo<T> cursor) {
    	this.cursor=cursor;
    }
	@Override
	public boolean hasNext() {
		
		return cursor!=null;
	}

	@Override
	public T next() {
		T valor= this.cursor.getInfo();
		this.cursor= cursor.getSignodo();
		return valor;
	}
  
}
