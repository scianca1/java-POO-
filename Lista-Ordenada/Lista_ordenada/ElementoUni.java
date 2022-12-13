package Lista_ordenada;



public abstract class ElementoUni {
  public abstract ListaOrdenada<ElementoUni> getAlumnos(Comparador<Alumno> orden);
  public abstract int getCantidadAlum();
}
