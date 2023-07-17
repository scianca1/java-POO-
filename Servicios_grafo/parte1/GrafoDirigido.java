package parte1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer,HashSet<Integer>> vertices;
	private ArrayList <Arco<T>> arcos;
	
	    public GrafoDirigido() {//complejidad= O(1) inicializamos los vertices y arcos
	    	
	    	this.vertices= new HashMap<Integer,HashSet<Integer>>();
	    	this.arcos= new ArrayList<Arco<T>>();
	    }
	@Override
	public void agregarVertice(int verticeId) {
		//complejidad= O(1) nos fijamos que el vertice no este contenido ya en los vertices, que es un hashmap
		//por lo que acceder a un vertice con su clave es O(1)
		if(!this.vertices.containsKey(verticeId)) {
		   this.vertices.put(verticeId,new HashSet<Integer>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) { 
		//complejidad= O(N) donde N es la cantidad de arcos,ya que los recorremos todos
		
		this.vertices.remove(verticeId);
		for(int i=0;i<arcos.size();i++) {
			if(arcos.get(i).getVerticeDestino()==verticeId||arcos.get(i).getVerticeOrigen()==verticeId) {
				if(arcos.get(i).getVerticeDestino()==verticeId) {
					this.vertices.get(arcos.get(i).getVerticeOrigen()).remove(verticeId);
				}
				 this.arcos.remove(arcos.get(i));
			}
		}
    }

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {//complejidad= O(1)
		if(this.vertices.containsKey(verticeId1)&& this.vertices.containsKey(verticeId2)) {
			Arco<T> nuevoarco= new Arco<T>(verticeId1,verticeId2,etiqueta);
			if(!this.arcos.contains(nuevoarco)) {
		    this.arcos.add(nuevoarco);
		    this.vertices.get(verticeId1).add(verticeId2);
		    }
		}
    }

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {//complejidad= O(N) donde N es la cantidad de arcos de nuestro grafo, y recorremos toda la lista 
		for(int i=0;i<arcos.size();i++) {
			if(arcos.get(i).getVerticeOrigen()==verticeId1&& arcos.get(i).getVerticeDestino()==verticeId2) {
				this.arcos.remove(arcos.get(i));
			}
		}

	}

	@Override
	public boolean contieneVertice(int verticeId) {//complejidad= O(1)
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {//complejidad= O(N)   donde N es la cantidad de arcos de nuestro grafo, y recorremos toda la lista 
		for(Arco<T> a:arcos) {
			if(a.getVerticeOrigen()==verticeId1&& a.getVerticeDestino()==verticeId2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {//complejidad= O(N)  donde N es la cantidad de arcos de nuestro grafo, y recorremos toda la lista 
		for(Arco<T> a:arcos) {
			if(a.getVerticeOrigen()==verticeId1&& a.getVerticeDestino()==verticeId2) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() { //complejidad= O(1)
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() { //complejidad= O(1)
		return this.arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {//complejidad= O(1)
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {//complejidad= O(1)
		if(this.vertices.containsKey(verticeId)) {
			return this.vertices.get(verticeId).iterator();
			}
	     return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {//complejidad= O(1)
		return  this.arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {//complejidad= O(N)  donde N es la cantidad de arcos de nuestro grafo, y recorremos toda la lista 
		ArrayList<Arco<T>> aux= new ArrayList<Arco<T>>();
		for(Arco<T> a:this.arcos) {
			if(a.getVerticeOrigen()==verticeId) {
				aux.add(a);
			}
		}
		return aux.iterator();
	}
	

}
