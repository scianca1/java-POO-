package parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioBFS {
private Grafo<?> grafo;
private List<Integer> cola;
private HashMap<Integer,String> visitados;// puede contener "visitado" y "no visitado" 
private ArrayList<Integer> posibleRecorrido;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.cola= new ArrayList<Integer>();
		this.visitados= new HashMap<Integer,String>();
		this.posibleRecorrido= new ArrayList<Integer>();
	}
	public void BFS() {
		this.cola.clear();
		this.visitados.clear();
		Iterator<Integer> vertices=this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer vertice=vertices.next();			
			this.visitados.put(vertice,"no visitado");
		}
		vertices=this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer vertice=vertices.next();
			if(visitados.get(vertice)=="no visitado") {
				BFSvisit(vertice);
				
			}
		}
		
	}
	public void BFSvisit(Integer vertice) {
		this.visitados.replace(vertice,"visitado");
		this.cola.add(vertice);
		this.posibleRecorrido.add(vertice);
		while(!this.cola.isEmpty()) {
			Integer vertice1= this.cola.get(0);
			this.cola.remove(0);
			Iterator<Integer> adyacentes=this.grafo.obtenerAdyacentes(vertice1);
			while(adyacentes.hasNext()) {
				Integer verticeadyacente= adyacentes.next();
				if(!this.posibleRecorrido.contains(verticeadyacente)) {
				this.posibleRecorrido.add(verticeadyacente);
				}
				if(this.visitados.get(verticeadyacente)!=null&&this.visitados.get(verticeadyacente)=="no visitado") {
					this.cola.add(verticeadyacente);
					this.visitados.replace(verticeadyacente,"visitado");
				}
				
			}
		}
    }
	
	public List<Integer> bfsForest() {
		this.BFS();
		return this.posibleRecorrido;
	}
}
