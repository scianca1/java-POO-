package Lista_ordenada;

public class Alumno extends ElementoUni{
	private String nombre,apellido;
	private int edad,dni;
	private ListaOrdenada<String> intereses;
	private Comparador orden;
	
	public Alumno(String nombre,String apellido,int dni,int edad) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.edad=edad;
		Comparador<String> intereses= new comparadorSTRING();
		this.intereses= new ListaOrdenada<>(intereses);
	}
	public void setInteres(String interes) {
		intereses.add(interes);
	}
	public ListaOrdenada<String> getIntereses() {
		ListaOrdenada<String> copia= new ListaOrdenada<>(this.orden);
		for (String i:intereses) {
			copia.add(i);
		}
		return copia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	public String toString() {
		return this.nombre+" "+this.getApellido();
	}
	@Override
	public ListaOrdenada getAlumnos(Comparador orden) {
		ListaOrdenada<Alumno> lista= new ListaOrdenada<>(orden);
		lista.add(this);
		return lista ;
	}
	@Override
	public int getCantidadAlum() {
		return 1;
	}
	

}
