package backtracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private Grafo grafo;
    private HashMap<String, HashMap<String, Integer>> informacionRelevante;
    private Integer tiempo;
    ArrayList<String> posibleRecorrido;
    //claves del HashMap<Integer, HashMap<String, Integer>>:
    //clave -> vertice
    //valor -> HashMap<String, Integer>: 
            //color -> (-1 = BLANCO, 0 = AMARILLO, 1 = NEGRO)
            //tDescubrimiento -> int;
            //tFinalizacion -> int;

    public boolean esConexo(){
        this.DFS();
        Iterator<String> it = this.grafo.obtenerVertices();
        while(it.hasNext()){
            String vertice = it.next();
            if(informacionRelevante.get(vertice).get("color") == -1){
                return false;
            }
        }
        return true;
    }

    public ServicioDFS(Grafo grafo) {
        this.grafo = grafo;
        this.informacionRelevante = new HashMap<String, HashMap<String, Integer>>();
        posibleRecorrido = new ArrayList<String>();
    }

    public void DFS(){
        this.posibleRecorrido.clear();
        this.tiempo = 0;
        this.informacionRelevante.clear();
        Iterator<String> iVertices = this.grafo.obtenerVertices();
        while(iVertices.hasNext()){
            HashMap<String, Integer> info = new HashMap<String, Integer>();
            info.put("color",-1);
            info.put("tDescubrimiento",0);
            info.put("tFinalizacion",0);
            this.informacionRelevante.put(iVertices.next(), info);
        }
        //cargamos todos los datos en nulo y preparamos todo para recorrer el grafo
        iVertices = this.grafo.obtenerVertices();
        String i = iVertices.next();
        this.DFS_visit(i);
    }


    // en el peor de los casos, cada vertice tiene n adyacentes, o sea que 
    // por cada vertice recorrera todos los vertices en el while, o sea que la complejidad del
    // metodo seria O(n^2)
    public void DFS_visit(String vertice){
        this.posibleRecorrido.add(vertice);
        this.tiempo ++;
        this.informacionRelevante.get(vertice);
        HashMap<String, Integer> infoDeVertice = this.informacionRelevante.get(vertice);
        infoDeVertice.replace("color", 0);
        infoDeVertice.replace("tDescubrimiento", this.tiempo);
        //en teoria reemplaza la variable color por 0 (AMARILLO)


        Iterator<String> itAdyacentes = this.grafo.obtenerAdyacentes(vertice);
        while(itAdyacentes.hasNext()){
            String indice = itAdyacentes.next();
            HashMap<String, Integer> infoDeAdyacente = this.informacionRelevante.get(indice);
            if(infoDeAdyacente.get("color") == -1){
                //si encuentra un vertice con un color = -1 (BLANCO)
                this.DFS_visit(indice);
            }
        }
        this.tiempo ++;
        infoDeVertice.replace("color", 1);
        infoDeVertice.replace("tFinalizacion", tiempo);
        //this.funcionX(vertice);
    }

    public void funcionX(Integer i){
        System.out.print(i + " -");
    }
    
    public List<String> dfsForest() {
        this.DFS();
		return this.posibleRecorrido;
	}

}