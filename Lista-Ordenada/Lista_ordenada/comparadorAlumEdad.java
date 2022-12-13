package Lista_ordenada;

public class comparadorAlumEdad extends Comparador<Alumno>{
	public comparadorAlumEdad () {}
	@Override
	public int compare(Alumno a1,Alumno a2) {
//		Comparador<Integer> comint= new comparadorINT<>();
//		return comint.compare((int)a1.getEdad(),(int)a2.getEdad());
			 try {
				 if((int)a1.getEdad()<(int)a2.getEdad()) {
					 return -1;
				 }
				 else if((int)a1.getEdad()>(int)a2.getEdad()) {
					 return 1;
				 }
				  return 0;
	         }catch(Exception exc) {
	        	 System.out.println("error de tipo");
	         }
			 return 0;
	}
	
}
