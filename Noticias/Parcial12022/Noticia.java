package Parcial12022;
import java.util.ArrayList;
public class Noticia extends ElementoPortal {
 private String titulo;
 private String contenido;
 private String autor;
 private String categoria;
 private ArrayList<String>palabrasclave;
 
 public Noticia() {
	 this.titulo= "sin titulo";
	 this.contenido= "vacio";
	 this.autor="sin autor";
	 this.categoria= "sin categoria";
	 this.palabrasclave= new ArrayList<>();
	 
 }
 
 public void addpalabras(String p) {
	if(!palabrasclave.contains(p)) {
			palabrasclave.add(p);
			}
 }
 public ArrayList<String>  getpalabrasclave(){
	 ArrayList<String>copia= new ArrayList<>();
	 for(String p:palabrasclave) {
		 copia.add(p);
	 }
	 return copia;
 }
 
 
 public  ArrayList <Noticia> buscar(Filtro f){
	 ArrayList<Noticia>noticiaquecumple= new ArrayList<>();
	 if(f.cumple(this)){
		 noticiaquecumple.add(this);
	 }
	 return noticiaquecumple;
 }
public String getcategoria() {
	return this.categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getContenido() {
	return contenido;
}

public void setContenido(String contenido) {
	this.contenido = contenido;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
	this.autor = autor;
}
public String toString(){
	return this.getTitulo();
}



 
}
