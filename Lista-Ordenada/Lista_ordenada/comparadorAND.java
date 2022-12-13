package Lista_ordenada;

import java.util.Comparator;

public class comparadorAND<T> extends Comparador<Alumno>{
  private Comparador<T> c1;
  private Comparador<T> c2;
  
  public comparadorAND (Comparador<T> c1,Comparador<T> c2) {
	  try {
		  this.c1=c1;
		  this.c2=c2;
	  }catch(Exception exc) {
		  System.out.println("error");
	  }
	  }
  @Override
  public int compare(Alumno o1,Alumno o2) {
	  int aux=this.c1.compare((T)o1,(T)o2);
	  if(aux==0) {
		 aux= this.c2.compare((T)o1,(T)o2);
	  }
	  return aux;
  }
}
