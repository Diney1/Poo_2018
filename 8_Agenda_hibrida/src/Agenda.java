
public class Agenda {

	private Repositorio<Entrada> entradas;
	private Repositorio<Entrada> favoritos;
	int quantidade = 0;
	public Agenda() {
		entradas = new Repositorio<Entrada>("entradas");
		favoritos = new Repositorio<Entrada>("favoritos");
	}

	public Repositorio<Entrada> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Repositorio<Entrada> favoritos) {
		this.favoritos = favoritos;
	}

	public Repositorio<Entrada> getEntradas() {
		return entradas;
	}
	
	
	public void rmEntry(String identrada) {
		this.entradas.remove(identrada);
	}
	
	public void favoritar(Entrada id) {
		if(!id.isfavorit())
			id.setfavorit(true);
		this.favoritos.add(id.getIdentrada(), id);
	}
	
	public void desfavoritar(Entrada id) {
		if(id.isfavorit())
			id.setfavorit(false);
		this.favoritos.remove(id.getIdentrada());
	}
	
	public String mostrarFavoritos() {
		String saida = "";
		for(Entrada e : favoritos.getAll())
			saida += e.toString() + "\n";
		return saida;
	}
	
	public String mostrar() {
		String saida = "";
		for(Entrada e : entradas.getAll()) {
			if(e instanceof Password) {
				quantidade = ((Password) e).getPassword().length();
				   saida += e.toString() + " " + e.converte(quantidade) + "\n";
			}
			else
			saida += e.toString() + "\n";
		}
		
		
		return saida;
	}
}
