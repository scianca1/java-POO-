package Parcial12022;
import java.util.ArrayList;
public class Clasificador {
   
   private ArrayList<String>palabras;
   private Filtro condicion;
   
   public Clasificador(Filtro f) {
	   this.condicion=f;
   }
   public void addpalabrasclave(String p) {
	   this.palabras.add(p);
   }
   public void clasificar(Noticia n) {
	  if( condicion.cumple(n)) {
		  for (String p:palabras) {
			  n.addpalabras(p);
		  }
	  }
   }
   
   
}
