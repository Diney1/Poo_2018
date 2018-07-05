
public class Note extends Entrada{

	private String texto;
	
	public Note(String id, String texto) {
		super(id);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String toString() {
		return " " + super.toString() + " : " + texto;
	}
}
