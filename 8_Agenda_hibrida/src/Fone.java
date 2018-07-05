public class Fone {

	private String idfone;
	private String numero;
	
	public Fone(String idfone, String numero) {
		this.idfone = idfone;
		this.numero = numero;
	}

	public String getIdfone() {
		return idfone;
	}

	public void setIdfone(String idfone) {
		this.idfone = idfone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return  idfone + ":" + numero;
	}
}
