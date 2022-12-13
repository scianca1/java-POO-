package Lista_ordenada;

import java.util.Comparator;

public class comparadorINT<T> extends Comparador<Integer>{
	public comparadorINT() {}
	@Override 
      public int compare(Integer n1,Integer n2) {
		 try {
			 if((int)n1<(int)n2) {
				 return -1;
			 }
			 else if((int)n1>(int)n2) {
				 return 1;
			 }
			  return 0;
         }catch(Exception exc) {
        	 System.out.println("error de tipo");
         }
		 return 0;
	  }
	
	
}
