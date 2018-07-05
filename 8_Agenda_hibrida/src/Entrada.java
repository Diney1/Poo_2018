
public abstract class Entrada {

	private String id;
	private boolean favorit ;
	
	public Entrada(String identrada) {
		this.id = identrada;
		favorit = false;
	}

	public String getIdentrada() {
		return id;
	}

	public void setIdentrada(String identrada) {
		this.id = identrada;
	}

	public boolean isfavorit() {
		return favorit;
	}

	public void setfavorit(boolean favorit) {
		this.favorit = favorit;
	}
	
	public String converte(int qtd) {
		String saida ="";
		for(int i=0; i < qtd; i++)
			saida += '*';
		return saida;
	}
	
	public String toString() {
		if(favorit)
		    return "@" + id ;
		else
			return "-" + id;
	}
	
}
