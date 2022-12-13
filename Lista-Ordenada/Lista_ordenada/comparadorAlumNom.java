package Lista_ordenada;

public class comparadorAlumNom extends Comparador<Alumno>{
    public comparadorAlumNom() {}
	@Override
	public int compare(Alumno a1, Alumno a2) {
		
		return a1.getNombre().compareTo(a2.getNombre());
	}
   
}
