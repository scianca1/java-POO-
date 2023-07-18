package greedy;

import java.util.ArrayList;

public class SolucionGreedy {
    ArrayList<Arco<Integer>> solucion;
    Integer metrica;
    Integer suma;

    public SolucionGreedy(){
        this.solucion = new ArrayList<Arco<Integer>>();
    }
    public ArrayList<Arco<Integer>> getRuta(ArrayList<String[]> datos) {
        this.solucion.clear();
        this.suma = 0;
        this.metrica = 0;
        ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
        ArrayList<String> verticesTotales = new ArrayList<String>();
        for (String [] fila : datos){
            Arco<Integer> auxIda = new Arco(fila[0], fila[1],Integer.parseInt(fila[2]));
            Arco<Integer> auxVuelta = new Arco(fila[1], fila[0],Integer.parseInt(fila[2]));
            if (!arcos.contains(auxIda)){
                arcos.add(auxIda);
            }
            if (!arcos.contains(auxVuelta)){
                arcos.add(auxVuelta);
            }
            if (!verticesTotales.contains(fila[0])){
                verticesTotales.add(fila[0]);
            }
            if (!verticesTotales.contains(fila[1])){
                verticesTotales.add(fila[1]);
            }
        }

        this.greedy(arcos, verticesTotales);
        return this.solucion;
    }

    private void greedy(ArrayList<Arco<Integer>> arcos, ArrayList<String> verticesTotales) {
        ArrayList<String> verticesParciales = new ArrayList<String>();
        Arco<Integer> a = this.seleccionar(verticesParciales, arcos);
        if(a == null){
            System.out.println("no hay solucion");
            return;
        }
        arcos.remove(a);
        solucion.add(a);
        this.suma += a.getEtiqueta();
        verticesParciales.add(a.getVerticeOrigen());
        verticesParciales.add(a.getVerticeDestino());
        while(!isSolution(verticesTotales, verticesParciales) && !arcos.isEmpty()){
            this.metrica++;
            a = this.seleccionar(verticesParciales, arcos);
            if(a == null){
                System.out.println("no hay solucion");
                return;
            }
            arcos.remove(a);
            if(esFactible(a, verticesParciales)){
                if(!verticesParciales.contains(a.getVerticeOrigen())){
                    verticesParciales.add(a.getVerticeOrigen());
                }
                if(!verticesParciales.contains(a.getVerticeDestino())){
                    verticesParciales.add(a.getVerticeDestino());
                }
                this.solucion.add(a);
                this.suma += a.getEtiqueta();
            }
        }
        if(!isSolution(verticesTotales, verticesParciales)){
            System.out.println("no hay solucion");
        }
    }
    private boolean esFactible(Arco<Integer> a, ArrayList<String> verticesParciales) {
        for(String vertice : verticesParciales){
            if(a.getVerticeDestino().equals(vertice)){
                return false;
            }
        }
        return true;
    }
    private boolean isSolution(ArrayList<String> verticesTotales, ArrayList<String> verticesParciales) {
        return verticesParciales.size() == verticesTotales.size();
    }
    private Arco<Integer> seleccionar(ArrayList<String> verticesParciales ,ArrayList<Arco<Integer>> arcos){
        Arco<Integer> arco = null;
        if(verticesParciales.isEmpty()){
            arco = arcos.get(0);
            for(Arco<Integer> aux : arcos){
                if(arco.getEtiqueta() > aux.getEtiqueta()){
                    arco = aux;
                }
            }
        }
        else{
            for (Arco<Integer> aux : arcos){
                if(this.contieneVerticeEnOrigen(aux, verticesParciales)){
                    arco = aux;
                }
            }
            if(arco == null){
                return null;
            }
            for(Arco<Integer> aux : arcos){
                if(this.contieneVerticeEnOrigen(aux, verticesParciales)){
                    if(arco.getEtiqueta() > aux.getEtiqueta()){
                        arco = aux;
                    }
                }
            }
        }
        return arco;
    }
    private boolean contieneVerticeEnOrigen(Arco<Integer> aux, ArrayList<String> verticesParciales) {
        for(String vertice : verticesParciales){
            if(aux.getVerticeOrigen().equals(vertice)){
                return true;
            }
        }
        return false;
    }

    public Integer getMetrica() {
        return this.metrica;
    }

    public Integer getSuma() {
        return this.suma;
    }
    
}
