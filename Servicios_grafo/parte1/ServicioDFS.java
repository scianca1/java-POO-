package parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class  ServicioDFS {
private Grafo<?> grafo;
private HashMap<Integer,HashMap<String,Integer>> informacion;
ArrayList<Integer> posibleRecorrido;
private Integer tiempo;

//claves del HashMap<Integer, HashMap<String, Integer>>:
//clave -> vertice
//valor -> HashMap<String, Integer>: 
        //color -> (-1 = BLANCO, 0 = AMARILLO, 1 = NEGRO)
        //tDescubrimiento -> int;
        //tFinalizacion -> int;

	
	public ServicioDFS(Grafo<?> grafo) {
		this.informacion= new HashMap<Integer,HashMap<String,Integer>>();
		this.grafo = grafo;
		posibleRecorrido = new ArrayList<Integer>();
    }
	public void DFS() {
		this.posibleRecorrido.clear();
		this.tiempo=0;
		this.informacion.clear();
		Iterator<Integer> Ivertices= this.grafo.obtenerVertices();
		while(Ivertices.hasNext()) {
			HashMap<String,Integer> info= new HashMap<String,Integer>();
			info.put("color", -1);
			info.put("Tdescubrimiento", 0);
			info.put("Tfinalizacion", 0);
			informacion.put(Ivertices.next(), info);
		}
		Ivertices= this.grafo.obtenerVertices();
		  while(Ivertices.hasNext()){
	            Integer i = Ivertices.next();
	            if (this.informacion.get(i).get("color") == -1){//(BLANCO)
	                this.DFSvisit(i);
	            }
	        }   
		
		
	}
	public void DFSvisit(Integer vertice) {
		this.posibleRecorrido.add(vertice);
		this.tiempo ++;
	    this.informacion.get(vertice);
	    HashMap<String, Integer> infoDeVertice =this.informacion.get(vertice);
        infoDeVertice.replace("color", 0);
        infoDeVertice.replace("Tdescubrimiento",tiempo);
        // reemplaza la variable color por 0 (AMARILLO)
		Iterator<Integer> Iadyacentes= this.grafo.obtenerAdyacentes(vertice);
		while(Iadyacentes.hasNext()) {
			 Integer indice = Iadyacentes.next();
	         HashMap<String, Integer> infoDeAdyacente = this.informacion.get(indice);
	            if(infoDeAdyacente.get("color") == -1){
	                //si encuentra un vertice con un color = -1 (BLANCO)
	                this.DFSvisit(indice);
		}
	}
		infoDeVertice.replace("color", 1);
		infoDeVertice.replace("Tfinalizacion", tiempo+1);
		 
	}
	
	public List<Integer> dfsForest() {
		this.DFS();
		return this.posibleRecorrido;
	}
	 public void funcionX(Integer i){
	        System.out.print(i + " -");
	    }
}
