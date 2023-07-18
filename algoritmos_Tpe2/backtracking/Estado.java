package backtracking;
import java.util.ArrayList;

public class Estado {
    Integer contador;
    ArrayList<Arco<Integer>> solucionParcial;
    ArrayList<Arco<Integer>> posibilidades;
    public ArrayList<Arco<Integer>> getPosibilidades() {
        return posibilidades;
    }
    
    public Estado(ArrayList<Arco<Integer>> arcos){
        this.posibilidades = arcos;
        this.solucionParcial = new ArrayList<Arco<Integer>>();
        this.contador = 0;
    }
    
    public ArrayList<Arco<Integer>> getSolucionParcial() {
        return solucionParcial;
    }
    
    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
}
