
public class Contato extends Entrada{

	private Repositorio<Fone> fones;
	
	public Contato(String id) {
		super(id);
		fones = new Repositorio<Fone>("telefones");
	}

	public Repositorio<Fone> getFones() {
		return fones;
	}

	public void setFones(Repositorio<Fone> fones) {
		this.fones = fones;
	}
	
	public void addFone(Fone f) {
		this.fones.add(f.getIdfone(), f);
	}
	
	public void rmFone(String idfone) {
	    this.fones.remove(idfone);	
	}
	
	public String mostrarFone() {
		String mostre = " [";
		for(Fone f : fones.getAll())
			mostre += f.toString() + "]" + "\n";
		return mostre;
	}
	public String toString() {
		return super.toString() + fones.toString();
	}
}
