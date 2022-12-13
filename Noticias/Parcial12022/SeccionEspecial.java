package Parcial12022;
import java.util.ArrayList;
//import java.util.Collection;

public class SeccionEspecial extends Seccion{
	
	private int numeropalabras;
	private String categoriafija;
	
	public SeccionEspecial (String cat) {
		super();
		this.numeropalabras=3;
		this.categoriafija=cat;
	}
	
	public void setnumeropalabras(int n) {
		this.numeropalabras= n;
	}
	@Override
	public String getcategoria() {
		return this.categoriafija;
	}
	public ArrayList<String> getpalabrasclave(){
		ArrayList<String> copia= super.getpalabrasclave();
//		Collection.sort(copia);
		ArrayList<String> resultado= new ArrayList<>();
	
		for(int i=0;i<copia.size()&&i<this.numeropalabras;i++) {
			resultado.add(copia.get(i));
		}
		return resultado;
	}

}
