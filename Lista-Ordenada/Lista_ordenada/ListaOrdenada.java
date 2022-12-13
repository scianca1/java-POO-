package Lista_ordenada;

import java.util.Comparator;
import java.util.Iterator;

public class ListaOrdenada<T> implements Iterable<T>{
	private Nodo<T> raiz;
	private Comparator<T> orden;
	private int tamanio=0;
	   
	   public ListaOrdenada(Comparator<T> orden) {
		   this.raiz= null;
		   this.orden= orden;
	   }
	public void add(T info) {
    	this.tamanio++;
		Nodo<T> nodo= new Nodo<>(info);
		if(this.raiz==null) {
			this.raiz= nodo;
		}
		else if(orden.compare(nodo.getInfo(),this.raiz.getInfo())<=0) {
		    
			nodo.setSignodo(this.raiz);
			this.raiz= nodo;
			
		}
		else {
			Nodo<T>anterior=this.raiz;
			for(Nodo<T> nodoi = this.raiz;nodoi!=null; nodoi=nodoi.getSignodo()) {
				if(orden.compare((T)nodoi.getInfo(),(T)nodo.getInfo())<0) {
					if(nodoi.getSignodo()==null) {
						nodoi.setSignodo(nodo);
						nodoi=nodoi.getSignodo();
						break;
					}
				}
				else  {
				    nodo.setSignodo(nodoi);
				    anterior.setSignodo(nodo);
					break;
				}
				anterior=nodoi;
			}
		}
	}
	private Nodo<T> get(int pos){
		int contador=0;
		if(pos<this.tamanio) {
			for(Nodo<T> nodoi = this.raiz;nodoi!=null; nodoi=nodoi.getSignodo()) {
				if(contador==pos) {
					       Nodo<T> copia= nodoi.getcopia();
								return copia;
								
						}
				contador++;
			}
		}
		return null;
		
	}
	public int gettamanio() {
		return this.tamanio;
	}
	public void eliminarNodo(int posicion) {
		if (this.tamanio>0) {
			if (posicion == 0) {
				Nodo<T> primer = raiz;
				raiz = raiz.getSignodo();
				primer.setSignodo(null) ;
				this.tamanio--;
			} else if (posicion < this.tamanio){
				Nodo<T> puntero = raiz;
				int contador = 0;
				while(contador < (posicion -1)) {
					puntero = puntero.getSignodo();
					contador++;
				}
				Nodo<T> temp = puntero.getSignodo();
				puntero.setSignodo(temp.getSignodo());
				temp.setSignodo(null) ;
				this.tamanio--;
			 }
		}
	}
	public void eliminarocurrencias(T valor){
		for (int i=0;this.tamanio>0&&this.get(i)!=null;i++) {
			
			if(this.get(i).getInfo().equals(valor)) {
				this.eliminarNodo(i);
				i--;
				
			}
		}
	}
	public String getposocurrencia(T valor) {
		for (int i=0;this.tamanio>0&&this.get(i)!=null;i++) {
			
			if(this.get(i).getInfo().equals(valor)) {
				return "El primer nodo con valor "+valor+" esta en la posicion sub "+i;
				}
			
			
		}
		
		return "La palabra "+valor+" no se encuentra en la lista";
		
	}

	public void setOrden(Comparator<T> orden) {
		this.orden= orden;
		this.ordenar();
	}
	private void ordenar() {
		tamanio=0;
		Nodo<T> guardado=raiz;
		this.raiz=null;
		int contador=0;
		for (Nodo<T> aux=guardado;aux!=null;aux= guardado) {
			
			   guardado= guardado.getSignodo();
				this.add(aux.getInfo());
			    if(contador==0) {
			    	this.raiz.setSignodo(null);
			    }
			    contador++;
		}

	}
	public boolean contiene(T element) {
		for(int i=0;i<this.tamanio;i++) {
			if( this.get(i).getInfo().equals(element)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterador<T>(this.raiz);
	}
	
	
	

}
