package Parcial12022;
import java.util.ArrayList;
public class Seccion extends ElementoPortal {
  private ArrayList<ElementoPortal> elementos;
  private int pos;
  private static final String defecto="sin definir";
   
  protected Seccion () {
	  this.elementos= new ArrayList<>();
	  this.pos=5;
  }
  public  ArrayList<String> getpalabrasclave(){
	  ArrayList<String>palabrasclave= new ArrayList<>();
	  for (ElementoPortal e:elementos) {
		  if(!palabrasclave.containsAll(e.getpalabrasclave())){
			  palabrasclave.addAll(e.getpalabrasclave());
		  }
	  }
	  return palabrasclave;
  }
  public String getcategoria() {
	  if (pos<this.elementos.size()) {
	  return elementos.get(pos).getcategoria();
	  }
	  return defecto;
  }
  public   ArrayList <Noticia> buscar(Filtro f){
	  ArrayList<Noticia> noticiaquecumple= new ArrayList<>();
	  for(ElementoPortal e:elementos) {
		noticiaquecumple.addAll(e.buscar(f));
		}
	  return noticiaquecumple;
  }

public int getPos() {
	return pos;
}

public void setPos(int pos) {
	this.pos = pos;
}
public void addelemento(ElementoPortal e) {
	this.elementos.add(e);
}

public static void main(String[] args) {
	Noticia noticia1=new Noticia();
	Noticia noticia2=new Noticia();
	Noticia noticia3=new Noticia();
	Noticia noticia4=new Noticia();
	Noticia noticia5=new Noticia();
	Seccion deporte= new Seccion();
	
	deporte.addelemento(noticia1);
	deporte.addelemento(noticia2);
	deporte.addelemento(noticia3);
	deporte.addelemento(noticia4);
	deporte.addelemento(noticia5);
	
	Filtro titulo= new FiltroTitulo("mati");
//	Filtro autor= new Filtroautor("yo");
//	Filtro tituloautor= new FiltroOr(titulo,autor);
//	Filtro notituloautor= new FiltroNot(autor);
	noticia1.setTitulo("nacho");
	noticia1.setAutor("yo");
	noticia1.addpalabras("aaa");
	noticia5.addpalabras("palabraa");
	noticia1.addpalabras("palabraa");
	noticia3.setTitulo("mati");
	noticia5.setCategoria("policial");
	 System.out.println(deporte.buscar(titulo));
}



  
}
