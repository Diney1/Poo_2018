
public class Cliente {
	private String idCli;
	private String nome;
	private Repositorio<Animal> animais;
	
	public Cliente(String idCli, String nome) {
			this.idCli = idCli;
			this.nome = nome;
			animais = new Repositorio<Animal>("animais");
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Repositorio<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(Repositorio<Animal> animais) {
		this.animais = animais;
	}

	@Override
	public String toString() {
		return "" + idCli + " : " + nome;
	}

	public String mostrar() {
		String saida = "";
		for(Animal a : animais.getAll())
			saida += a.toString() + "\n";
		return saida;
	}

}
