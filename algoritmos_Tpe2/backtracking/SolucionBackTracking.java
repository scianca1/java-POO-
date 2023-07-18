package backtracking;
import java.util.ArrayList;

public class SolucionBackTracking {
    ArrayList<Arco<Integer>> solucionIdeal;
    Integer sumaSolucionIdeal;
    Integer metrica;
    ArrayList<String> verticesTotales;
    public SolucionBackTracking() {
        this.solucionIdeal = new ArrayList<Arco<Integer>>();
        this.verticesTotales = new ArrayList<String>();
    }


    public ArrayList<Arco<Integer>> getmejorRuta(ArrayList<String[]> datos) {
        this.metrica = 0;
        this.sumaSolucionIdeal = Integer.MAX_VALUE;
        this.solucionIdeal.clear();
        this.verticesTotales.clear();
        Estado e = this.cargarEstado(datos);
        this.back(e);
        return this.solucionIdeal;
    }

    public Estado cargarEstado(ArrayList<String[]> datos){
        ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
        for (String [] fila : datos){
            Arco<Integer> aux = new Arco<Integer>(fila[0], fila[1],Integer.parseInt(fila[2]));
            if (!arcos.contains(aux)){
                arcos.add(aux);
            }
            if (!this.verticesTotales.contains(fila[0])){
                this.verticesTotales.add(fila[0]);
            }
            if (!this.verticesTotales.contains(fila[1])){
                this.verticesTotales.add(fila[1]);
            }
        }
        Estado e = new Estado(arcos);
        return e;
    }


    private void back(Estado e) {
        this.metrica++;
        if (this.isSolucion(e)){
            if(this.esFactible(e)){
                this.solucionIdeal = new ArrayList<Arco<Integer>>(e.getSolucionParcial());
                this.sumaSolucionIdeal = e.getContador();
            }
        }
        else{
            Arco<Integer> tunel = e.getPosibilidades().get(0);
            e.getPosibilidades().remove(0);
            e.setContador(e.getContador() + tunel.getEtiqueta());
            if(e.getContador() < this.sumaSolucionIdeal){
                e.solucionParcial.add(tunel);
                this.back(e);
            }
            e.solucionParcial.remove(tunel);
            e.setContador(e.getContador() - tunel.getEtiqueta());
            if(e.getContador() < this.sumaSolucionIdeal){
                this.back(e);
            }
            e.getPosibilidades().add(tunel);
        }
    }


    private boolean isSolucion(Estado e) {
        //1ro me fijo si posibilidades esta vacio
        if (!e.getPosibilidades().isEmpty()){
            return false;
        }
        return true;
    }

    //el metodo "es factible" originalmente se usa en greedy, pero debemos usarlo
    //aqui tambien para controlar algunas cosas
    public boolean esFactible(Estado e){
        //chekeamos que todos los las estaciones esten en nuestra solucion parcial
        ArrayList<String> verticesParciales = getVerticesParciales(e.getSolucionParcial());
        for (String vertice : this.verticesTotales){
            if(!verticesParciales.contains(vertice)){
                return false; 
            }
        } 
        Grafo  g = new GrafoNoDirigido(this.verticesTotales, e.getSolucionParcial());
        //para saber si los tuneles se conectan todos entre si, debemos corroborar que
        //el grafo que se formaria es conexo.
        if(!g.esConexo()){
            return false;
        }
        //y por ultimo verificaremos que la solucion ya guardada no es mejor que la actual
        if(e.getContador() > this.sumaSolucionIdeal){
            return false;
        }
        //si no, cumple con ninguno de los if anteriores, significa que es una solucion valida y mejor que
        //la que ya habiamos almacenado
        return true;
    }


    private ArrayList<String> getVerticesParciales(ArrayList<Arco<Integer>> solucionParcial) {
        ArrayList<String> aux = new ArrayList<String>();
        for (Arco<Integer> arco : solucionParcial){
            if(!aux.contains(arco.getVerticeOrigen())){
                aux.add(arco.getVerticeOrigen());
            }
            if(!aux.contains(arco.getVerticeDestino())){
                aux.add(arco.getVerticeDestino());
            }
        }
        return aux;
    }

    public Integer getMetrica(){
        return this.metrica;
    }

    public Integer getmMejorSuma(){
        return this.sumaSolucionIdeal;
    }
}
