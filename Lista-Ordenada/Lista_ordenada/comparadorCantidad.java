package Lista_ordenada;

public class comparadorCantidad<T> extends Comparador<ElementoUni>{
   public comparadorCantidad() {}

	@Override
	public int compare(ElementoUni e1, ElementoUni e2) {
		try {
			 if((int)e1.getCantidadAlum()<(int)e2.getCantidadAlum()) {
				 return -1;
			 }
			 else if((int)e1.getCantidadAlum()>(int)e2.getCantidadAlum()) {
				 return 1;
			 }
			  return 0;
        }catch(Exception exc) {
       	 System.out.println("error de tipo");
        }
		 return 0;
	}
 
}
