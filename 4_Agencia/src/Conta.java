 
public class Conta {

	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;
	int cont_extrato;
	
	public Conta(int numero) {
		this.numero = numero;
		this.saldo += saldo;
		this.extrato = new Repositorio<Operacao>("extrato");
		this.ativa =  true;
	}

	public boolean depositar(float valor) {
		if (ativa) {
			if (valor <= 0)
				throw new RuntimeException("Fail: valor negativo ou igual a zero.");
			
			this.extrato.add(""+cont_extrato, new Operacao("depositar", valor));
			this.saldo += valor;
			cont_extrato++;
		    return true;
		}
		throw new RuntimeException("Fail: Conta não ativa");
	}
	
	public void sacar(float valor) {
		if(ativa) {
			if (valor <= 0) {
				throw new RuntimeException("Fail: valor negativo ou igual a zero.");
			}
			if (valor > saldo) {
				throw new RuntimeException("Fail: valor maior que o saldo.");
			}
		     this.saldo -= valor;
		     this.extrato.add( "" + cont_extrato , new Operacao("sacar", valor));
		     cont_extrato++;
		     return;
		}
		throw new RuntimeException("Fail: Conta não ativa");
	}
	
	
	
	public void transferir(float valor, Conta other) {
		
		if (this.ativa) {
			if (valor < 0)
				throw new RuntimeException("Fail: valor menor que 0");
			this.extrato.add("" + cont_extrato, new Operacao("transferencia", valor));
			this.saldo -= valor;
			other.saldo += valor;
			cont_extrato++;
			return;
		}
		throw new RuntimeException("Fail: Conta não ativa");
	}
	
	public void encerrar() {
		this.ativa = false;
	}
	
	public float getSaldo() {
		return saldo;
	}

	public float setSaldo(float saldo) {
		return this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public Repositorio<Operacao> getExtrato() {
		return extrato;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	public String toString() {		
		return "Conta: " + numero + " - Saldo: " + saldo + " - Status: " + ativa;
	}
}
