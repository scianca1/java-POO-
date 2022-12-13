package Parcial12022;

public class Filtroautor extends Filtro {
 private String autor;
 public Filtroautor(String a) {
	 this.autor=a;
 }
 public boolean cumple(Noticia n) {
       return n.getAutor().equals(this.autor);
 }
 
}
