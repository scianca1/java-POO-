package Lista_ordenada;

public class comparadorAlumDNI extends Comparador <Alumno> {
 public  comparadorAlumDNI() {}
	@Override
	public int compare(Alumno a1, Alumno a2) {
	
		 try {
			 if((int)a1.getDni()<(int)a2.getDni()) {
				 return -1;
			 }
			 else if((int)a1.getDni()>(int)a2.getDni()) {
				 return 1;
			 }
			  return 0;
         }catch(Exception exc) {
        	 System.out.println("error de tipo");
         }
		 return 0;
	}

}
