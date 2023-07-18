package backtracking;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<String,HashSet<String>> vertices;
	private ArrayList <Arco<T>> arcos;
	
    public GrafoDirigido() {
        this.vertices= new HashMap<String,HashSet<String>>();
        this.arcos= new ArrayList<Arco<T>>();
    }
	@Override
	public void agregarVertice(String verticeId) {//complejidad= O(1)
		if(!this.vertices.containsKey(verticeId)) {
		   this.vertices.put(verticeId,new HashSet<String>());
		}
	}

	@Override
	public void borrarVertice(String verticeId) { //complejidad= O(N)
		this.vertices.remove(verticeId);
		for(int i=0;i<arcos.size();i++) {
			if(arcos.get(i).getVerticeDestino()==verticeId||arcos.get(i).getVerticeOrigen()==verticeId) {
				 this.arcos.remove(arcos.get(i));
			}
		}
    }

	@Override
	public void agregarArco(String verticeId1, String verticeId2, T etiqueta) {//complejidad= O(1)
		if(this.vertices.containsKey(verticeId1)&& this.vertices.containsKey(verticeId2)) {
			Arco<T> nuevoarco= new Arco<T>(verticeId1,verticeId2,etiqueta);
		    this.arcos.add(nuevoarco);
		    this.vertices.get(verticeId1).add(verticeId2);
		}
    }

	@Override
	public void borrarArco(String verticeId1, String verticeId2) {//complejidad= O(N)
		for(int i=0;i<arcos.size();i++) {
			if(arcos.get(i).getVerticeOrigen().equals(verticeId1)&& arcos.get(i).getVerticeDestino().equals(verticeId2)) {
				this.arcos.remove(arcos.get(i));
			}
		}

	}

	@Override
	public boolean contieneVertice(String verticeId) {//complejidad= O(1)
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(String verticeId1, String verticeId2) {//complejidad= O(N)
		for(Arco<T> a:arcos) {
			if(a.getVerticeOrigen().equals(verticeId1)&& a.getVerticeDestino().equals(verticeId2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(String verticeId1, String verticeId2) {//complejidad= O(N)
		for(Arco<T> a:arcos) {
			if(a.getVerticeOrigen().equals(verticeId1)&& a.getVerticeDestino().equals(verticeId2)) {
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
	public Iterator<String> obtenerVertices() {//complejidad= O(1)
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<String> obtenerAdyacentes(String verticeId) {//complejidad= O(1)
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
	public Iterator<Arco<T>> obtenerArcos(String verticeId) {//complejidad= O(N)
		ArrayList<Arco<T>> aux= new ArrayList<Arco<T>>();
		for(Arco<T> a:this.arcos) {
			if(a.getVerticeOrigen().equals(verticeId)|| a.getVerticeDestino().equals(verticeId)) {
				aux.add(a);
			}
		}
		return aux.iterator();
	}
    @Override
    public boolean esConexo() {
        ServicioDFS dfs = new ServicioDFS(this);
        return dfs.esConexo();
    }


	

}