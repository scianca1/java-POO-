package Parcial12022;

import java.util.ArrayList;

public class NotiaPaga extends Noticia {
  public  NotiaPaga () {
	  super();
  }
  @Override 
  public  ArrayList <Noticia> buscar(Filtro f){
	  ArrayList<Noticia>noticiaquecumple= new ArrayList<>();
	  noticiaquecumple.add(this);
	  return noticiaquecumple;
  }
}
