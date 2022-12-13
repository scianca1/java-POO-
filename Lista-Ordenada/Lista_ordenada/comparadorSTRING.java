package Lista_ordenada;

public class comparadorSTRING<T>  extends Comparador<String>{
	public comparadorSTRING() {}
	@Override 
      public int compare(String n1,String n2) {
		 
		 return n1.compareTo(n2);
 }
}
