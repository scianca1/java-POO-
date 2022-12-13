package Parcial12022;

public class FiltroAnd extends Filtro {
  private Filtro f1;
  private Filtro f2;
  private Filtro f3;
  
  public FiltroAnd(Filtro f1, Filtro f2) {
	  this.f1=f1;
	  this.f2= f2;
	  this.f3=null;
	  }

  public FiltroAnd(Filtro f1, Filtro f2,Filtro f3) {
	  this.f1=f1;
	  this.f2= f2;
	  this.f3=f3;
  }
  public boolean cumple(Noticia n) {
	  if(f3==null) 
	  {return f1.cumple(n) && f2.cumple(n);}
	  else {
		 return f1.cumple(n) && f2.cumple(n) && f3.cumple(n);
	  }
  }
}
