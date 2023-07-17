package parte1;

import java.util.List;

public class mimain {
	public static void main(String [] args) {
       
	//creacion de grafo con sus vertices
        Grafo<Integer> grafoDirigido = new GrafoDirigido<Integer>();
        grafoDirigido.agregarVertice(1);
        grafoDirigido.agregarVertice(2);
        grafoDirigido.agregarVertice(3);
        grafoDirigido.agregarVertice(4);
        grafoDirigido.agregarVertice(5);
        grafoDirigido.agregarVertice(6);
        grafoDirigido.agregarVertice(7);
        grafoDirigido.agregarVertice(8);

   // agregando arcos entre vertices
        grafoDirigido.agregarArco(1,2,0);
        grafoDirigido.agregarArco(2,3,0);
        grafoDirigido.agregarArco(3,4,0);
        grafoDirigido.agregarArco(3,5,0);
        grafoDirigido.agregarArco(2,5,0);
        grafoDirigido.agregarArco(5,6,0);
        grafoDirigido.agregarArco(5,7,0);
        grafoDirigido.agregarArco(4,7,0);
        grafoDirigido.agregarArco(6,7,0);
        grafoDirigido.agregarArco(7,5,0);
        
        //Prueba del ServicioDFS
        
        ServicioDFS DFS= new ServicioDFS(grafoDirigido);
        List<Integer> recorridoDFS= DFS.dfsForest();
        System.out.println("Recorrido DFS: ");
       for(Integer v:recorridoDFS) {
    	   System.out.print(v+"|");
       }
       System.out.println(" ");
       System.out.println("---------------------------");
       
       //Prueba del BFS
       ServicioBFS BFS= new ServicioBFS(grafoDirigido);
       List<Integer> RecorridoBFS= BFS.bfsForest();
       System.out.println("Recorrido BFS: ");
       for(Integer v:RecorridoBFS) {
    	   System.out.print(v+"|");
       }
       System.out.println(" ");
       System.out.println("---------------------------");
       
       
      //prueba del Servicio caminos 
        ServicioCaminos camino = new ServicioCaminos(grafoDirigido, 1, 5, 10);
        List<List<Integer>> caminos = camino.caminos();
        System.out.println("Servicios caminos: ");
        for (List<Integer> posibleCamino : caminos) {
        	for(int i=0;i<posibleCamino.size();i++){
        		if(!((posibleCamino.indexOf(posibleCamino.get(i)))==(posibleCamino.size()-1))) {
                System.out.print(posibleCamino.get(i) + "--> ");
                }
        		else {
        			System.out.print(posibleCamino.get(i) );
        		}
            }
            System.out.println(" ");
        }
        //prueba de error en servicios  borrar el vertice, y que no pase por un camino que lo contenga
        grafoDirigido.borrarVertice(4);
        ServicioCaminos camino2 = new ServicioCaminos(grafoDirigido, 1, 5, 10);
        List<List<Integer>> caminos2 = camino2.caminos();
        System.out.println("Servicios caminos: ");
        for (List<Integer> posibleCamino : caminos2) {
        	for(int i=0;i<posibleCamino.size();i++){
        		if(!((posibleCamino.indexOf(posibleCamino.get(i)))==(posibleCamino.size()-1))) {
                System.out.print(posibleCamino.get(i) + "--> ");
                }
        		else {
        			System.out.print(posibleCamino.get(i) );
        		}
            }
            System.out.println(" ");
        }
        
      //Prueba del BFS en error, despues de borrar el 4
        ServicioBFS BFS1= new ServicioBFS(grafoDirigido);
        List<Integer> RecorridoBFS1= BFS1.bfsForest();
        System.out.println("Recorrido BFS: ");
        for(Integer v:RecorridoBFS1) {
     	   System.out.print(v+"|");
        }
        System.out.println(" ");
        System.out.println("---------------------------");

    }

}
