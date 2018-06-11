
public class Servico {
	public String idSer;
	public float valor;
	
	public Servico(String idSer, float valor){
		this.idSer = idSer;
		this.valor = valor;
	}

	public String getIdSer() {
		return idSer;
	}

	public void setIdSer(String idSer) {
		this.idSer = idSer;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "["+idSer + ":" + valor + "]";
	}
}
