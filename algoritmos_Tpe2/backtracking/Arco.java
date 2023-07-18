package backtracking;
public class Arco <T>{
	private String verticeOrigen;
	private String verticeDestino;
	private T etiqueta;

	public Arco(String verticeOrigen, String verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public String getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public String getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	@Override
	public String toString() {
		return this.verticeOrigen + " <-> " + verticeDestino;	
	}

    @Override
    public boolean equals(Object obj) {
        try {
            Arco aux = (Arco) obj;
            return((this.verticeOrigen.equals(aux.getVerticeOrigen()) && this.verticeDestino.equals(aux.getVerticeDestino())) || 
            this.verticeOrigen.equals(aux.getVerticeDestino()) && this.verticeDestino.equals(aux.getVerticeOrigen()));
        } catch (Exception e) {
            return false;
        }
    }
}