package Lista_ordenada;

import java.util.ArrayList;

public class ElementoComp extends ElementoUni{
   private String titulo;
   private ListaOrdenada<ElementoUni> elementos;
   private Comparador miorden;
   
   
   
	public ElementoComp(Comparador miorden,String titulo) {
//	super();
	this.titulo= titulo;
	this.elementos = new ListaOrdenada<>(miorden);
	this.miorden = miorden;
}

    public void addElemento(ElementoUni e) {
    	this.elementos.add(e);
    }

	@Override
	public ListaOrdenada getAlumnos(Comparador orden) {
		ListaOrdenada<ElementoUni> alumnos=new ListaOrdenada<>(orden);
		for (ElementoUni E:elementos) {
			ListaOrdenada<ElementoUni> aux= new ListaOrdenada<>(orden);
			aux.add(E);
			for(ElementoUni e:aux) {
				if(!alumnos.contiene(e)&&e!=null) {
					alumnos.add(e);
				}
			}
		}
		return alumnos;
	}

	@Override
	public int getCantidadAlum() {
		int suma=0;
		for (ElementoUni E:elementos) {
			suma+=E.getCantidadAlum();
		}
		return suma;
	}
	public String toString() {
		String lista= this.titulo+",";
		if(elementos.gettamanio()>0) {
			for (ElementoUni E:elementos) {
				lista+=E.toString()+",";
			}
		}
		return lista;
	}

}
