package parte1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ServicioCaminos{
    Grafo<?> grafo;
    Integer origen, destino, lim, contadorDeArcos;
    LinkedList<List<Integer>> lista;
 

    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        lista = new LinkedList<List<Integer>>();
    }

    public List<List<Integer>> caminos(){
    	this.lista.clear();
        LinkedList<Integer> listaInt = new LinkedList<Integer>();
        ArrayList<Arco<Integer>> arcosParciales = new ArrayList<Arco<Integer>>();
        this.contadorDeArcos = 0;
        
        this.caminos(this.origen, listaInt, arcosParciales);
		return this.lista;
	}

    private void caminos(Integer vertice, LinkedList<Integer> listaParcial, ArrayList<Arco<Integer>> arcosParciales){
        if(isSolution(vertice)){
            this.operarSolucion(vertice, listaParcial);
        }

        else{
            if(tieneAdyacentes(vertice)){
                listaParcial.add(vertice);

                Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
                while(it.hasNext()){
                    Integer hijo = it.next();
                    if(!contieneArcos(arcosParciales, vertice, hijo)){
                        arcosParciales.add((Arco<Integer>) grafo.obtenerArco(vertice, hijo));
                        contadorDeArcos++;
                        if(!this.poda()){
                            this.caminos(hijo, listaParcial, arcosParciales);
                        }
                        arcosParciales.remove(grafo.obtenerArco(vertice, hijo));
                        contadorDeArcos--;
                    }
                }
                listaParcial.remove(vertice);
            }
        }
    }

    private boolean isSolution(Integer vertice){
        if(vertice.equals(this.destino)){
            return true;
        }
        return false;
    }

    private boolean contieneArcos(ArrayList<Arco<Integer>> arcosParciales, Integer vertice, Integer hijo){
        for(Arco<Integer> a: arcosParciales){
            Integer origen = a.getVerticeOrigen();
            Integer destino = a.getVerticeDestino();
            if (origen.equals(vertice) && destino.equals(hijo)){
                return true;
            }
        }
        return false;
    }

    private boolean tieneAdyacentes(Integer vertice){
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
        return it.hasNext();
    }

    private void operarSolucion(Integer vertice, LinkedList<Integer> listaParcial){
        	if (!this.poda()) {
            listaParcial.add(vertice);
            LinkedList<Integer> listaSolucion = new LinkedList<Integer>(listaParcial);
            this.lista.add(listaSolucion);
            listaParcial.remove(vertice);
            }
    }

    private boolean poda(){
        return this.contadorDeArcos > this.lim;
    }
 }
