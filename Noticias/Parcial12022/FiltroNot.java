package Parcial12022;

public class FiltroNot extends Filtro {
	private Filtro f;
	
	FiltroNot(Filtro f) {
		this.f= f;
	}
	public boolean cumple(Noticia n) {
		return !this.f.cumple(n);
	}

}
