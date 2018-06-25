import java.util.Scanner;

public class Controller {
	Scanner sca;
	Agencia agencia;
	Repositorio<Cliente> clientes;
	public Controller() {
		sca = new Scanner(System.in);
		agencia = new  Agencia();
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if(ui[0].equals("addcliente"))
			agencia.addCliente(ui[1]);
		else if(ui[0].equals("showcli"))
			System.out.println(" "+agencia.toString());
		else if(ui[0].equals("addconta"))
			agencia.abrirNovaConta(ui[1]);
		else if(ui[0].equals("encerrar"))
			agencia.encerrar(ui[1], Integer.parseInt(ui[2]));
		else if(ui[0].equals("login"))
			agencia.Login(ui[1]);
		else if(ui[0].equals("logout"))
			agencia.Logout();
		else if(ui[0].equals("showcontas")) {
			System.out.println(agencia.getUser().getIdCliente());
			System.out.println(agencia.getUser().getContas().toString());
		}
		else if(ui[0].equals("saldo"))
			System.out.println("R$: "+agencia.getConta(Integer.parseInt(ui[1])).getSaldo());
		else if(ui[0].equals("deposito"))
			agencia.getConta(Integer.parseInt(ui[1])).depositar(Float.parseFloat(ui[2]));
		else if(ui[0].equals("saque"))
			agencia.getConta(Integer.parseInt(ui[1])).sacar(Float.parseFloat(ui[2]));
		else if(ui[0].equals("extrato"))
			System.out.println(agencia.getConta(Integer.parseInt(ui[1])).getExtrato());
		else if(ui[0].equals("transferir"))
			agencia.getConta(Integer.parseInt(ui[1])).transferir(agencia.getContaCli(Integer.parseInt(ui[2])), Float.parseFloat(ui[3]));
		else
			return " Comando invalido";
		return "done";
	}




		public void shell() {
			while (true) {
				String line = sca.nextLine();
				try {
					System.out.println(query(line));
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
			}
		}
		
		public static void main(String[] args) {
	        Controller c = new Controller();
	        c.shell();
	    }
	  
	}



