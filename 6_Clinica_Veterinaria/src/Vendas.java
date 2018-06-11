
public class Vendas {
	public String idAni;
	public String idCli;
	public String idSer;
	public int idvenda;
	public Vendas(int idVenda,String idCli, String idAni, String idSer) {
		this.idvenda = idVenda;
		this.idCli = idCli;
		this.idAni = idAni;
		this.idSer = idSer;
	}

	public int getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	public String getIdAni() {
		return idAni;
	}

	public void setIdAni(String idAni) {
		this.idAni = idAni;
	}

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getIdSer() {
		return idSer;
	}

	public void setIdSer(String idSer) {
		this.idSer = idSer;
	}
	
	public String toString() {
		return idvenda + ":" + idCli + ":" + idAni + ":" + idSer;
	}
	
}
