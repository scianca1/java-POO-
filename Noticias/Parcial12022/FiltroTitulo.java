package Parcial12022;

public class FiltroTitulo extends Filtro {
     private String titulo;
      
     public FiltroTitulo(String t) {
    	 this.titulo= t;
     }
     public boolean cumple(Noticia n) {
    	return n.getTitulo().contains(this.titulo);
     }
}
