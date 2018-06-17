import java.util.Scanner;

public class Controller {
		Repositorio<Cliente> clientes;
		Repositorio<Conta> contas;
		Scanner sca;
		GerenciadorLogin ger;
	    int num_conta = 0;
	    int cont_contas = 0;
		    
	public Controller(){
		sca = new Scanner(System.in);
		clientes = new Repositorio<Cliente>("username");
		ger = new GerenciadorLogin(clientes);
		contas = new Repositorio<Conta>("conta");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addcliente"))
			clientes.add(ui[1], new Cliente(ui[1], ui[2]));
		
		else if (ui[0].equals("showcli")) {
			String saida = "";
			for(Cliente c : clientes.getAll())
				saida += c.toString() + "\n";
			return saida;
		}
		
		else if(ui[0].equals("login")) {
			ger.Login(ui[1], ui[2]);
		    ger.getUser().contas.add(""+ num_conta , new Conta(num_conta));
		    num_conta++;
            cont_contas++;
		}
		
		else if(ui[0].equals("deposito"))
		    ger.getUser().contas.get(ui[1]).depositar(Float.parseFloat(ui[2]));	
		
		else if(ui[0].equals("saque"))
			ger.getUser().contas.get(ui[1]).sacar(Float.parseFloat(ui[2]));
		
		else if(ui[0].equals("encerrar")) {
			ger.getUser().contas.get(ui[1]).encerrar();
			cont_contas--;
		}
		
		else if(ui[0].equals("saldo"))
			System.out.println(""+ger.getUser().contas.get(ui[1]).getSaldo());
		
		else if(ui[0].equals("addconta")) {
			if(cont_contas > 1)
				throw new RuntimeException("fail: você possui o numero maximo de contas ativa");
			ger.getUser().contas.add("" + num_conta, new Conta(num_conta));
			num_conta++;
			cont_contas++;
		}
		
		else if(ui[0].equals("transferir"))
			ger.getUser().contas.get(ui[1]).transferir(Float.parseFloat(ui[2]), clientes.get(ui[3]).contas.get(ui[4]));
		    
		else if(ui[0].equals("logout"))
			ger.Logout();
		else if(ui[0].equals("showcontas")) {
			System.out.println(ger.getUser().getIdcliente());
			System.out.println(ger.getUser().getContas().toString());
		}
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




