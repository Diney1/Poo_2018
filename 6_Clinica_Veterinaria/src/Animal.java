public class Animal {
	public int idAni;
	public String nome;
	public String especie;
	public Animal(int idAni, String nome, String especie) {
			this.idAni = idAni;
			this.nome = nome;
			this.especie = especie;
	}
	
	public int getIdAni() {
		return idAni;
	}

	public void setIdAni(int idAni) {
		this.idAni = idAni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Animal: ["+ idAni + ":" + nome + ":" + especie + "]";
	}
}