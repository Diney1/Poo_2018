package whatsapp;

public class Message {
	private String indice;
	private String user;
	private String texto;
	private boolean lido;
	
	public Message(String indice, String user, String texto) {
		this.indice = indice;
		this.user = user;
		this.texto = texto;
		this.lido = false;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isLido() {
		return lido;
	}

	public void setLido(boolean lido) {
		this.lido = lido;
	}
	
	public String toString() {
		return " " + user + ":" + texto;
	}

}
