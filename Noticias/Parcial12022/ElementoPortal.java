package Parcial12022;

import java.util.ArrayList;

public abstract class ElementoPortal {
   public abstract  ArrayList <Noticia> buscar(Filtro f);
   public abstract String getcategoria();
   public abstract ArrayList<String> getpalabrasclave();
}
