package Lista_ordenada;

public class comparadorINV<T> extends Comparador<T>{
 private Comparador<T> com;
 
 public comparadorINV(T c) {
	 try {
		 this.com=(Comparador)c;
	 }catch(Exception exc) {
		 System.out.println("error");
	 }
 }
 public int compare(T o1,T o2) {
	 return (this.com.compare(o1, o2))*-1;
 }
}
