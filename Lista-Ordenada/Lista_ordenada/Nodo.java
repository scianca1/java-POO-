package Lista_ordenada;


public class Nodo<T> {
	 private T info;
	 private Nodo<T> signodo;
	  
	 public Nodo(T info) {
		   this.info= info; 
		   this.signodo= null;
	 }

	public T getInfo() {
		return info;
	}

	public  Nodo<T> getSignodo() {
		return signodo;
	}

	public void setSignodo(Nodo<T> signodo) {
		this.signodo = signodo;
	}
	@Override
	public boolean equals(Object obj) {
		try {
			Nodo<T> otroNodo = (Nodo)obj;
			return this.getInfo().equals(otroNodo.getInfo());
		}
		catch (Exception e) {
			return false;
		}
	}
	public String toString() {
		 return String.valueOf(this.info);
	 }
	public Nodo<T> getcopia(){
		Nodo<T> copia= new Nodo<T>(this.getInfo());
		copia.setSignodo(this.getSignodo());
		return copia;
	}
	 
}
