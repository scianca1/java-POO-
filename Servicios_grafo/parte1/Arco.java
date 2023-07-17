package parte1;

public class Arco <T>{
	private Integer verticeOrigen;
	private Integer verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	@Override
	public String toString() {
		return String.valueOf(this.etiqueta);
	}
	public boolean equals(Object obj) {
        try {
            Arco<Integer> aux = (Arco<Integer>) obj;
            return this.verticeOrigen.equals(aux.getVerticeOrigen()) && this.verticeDestino.equals(aux.getVerticeDestino());
        } catch (Exception e) {
            return false;
        }
    }
}
