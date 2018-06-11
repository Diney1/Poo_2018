import java.util.Scanner;

class Controller {
	Repositorio<Cliente> clientes;
	Repositorio<Servico> servicos;
	Repositorio<Vendas> vendas;
	Repositorio<Animal> animais;
	Scanner sca;
	int nextid = 1;
	int idvenda = 1;
	float dinheiro = 0f;
	public Controller() {
		clientes = new Repositorio<Cliente>("clientes");
		servicos = new Repositorio<Servico>("servicos");
		vendas = new Repositorio<Vendas>("vendas");
		animais = new Repositorio<Animal>("animais");
		sca = new Scanner(System.in);
	}
	
	

	public String oracle(String line){
		String ui[] = line.split(" ");
		
		if(ui[0].equals("help"))
			return "addCli _idCliente _nome, showCli\n"
			     + "addAnimal _idCli _nome _especie, showAnimal\n"
			     + "addServ _idServ _preco, showServ\n"
			     + "vendaServ _idCli _idAni _idServ, showVenda\n"
			     + "showLucro";
		else if (ui[0].equals("addCli")) {
			String nome_ = "";
	    	for(int i = 2; i<ui.length; i++)
	    		nome_ += ui[i] +" ";
	    	clientes.add(ui[1], new Cliente(ui[1], nome_));
	    }
	    else if(ui[0].equals("showCli")) {
	    	String cli = "";
	    	for(Cliente c : clientes.getAll())
	    		cli += c.toString() +"\n";	
	    	return cli;
	    }
	    else if(ui[0].equals("addAnimal")) {
	    	clientes.get(ui[1]).getAnimais().add(ui[2], new Animal(nextid, ui[2], ui[3]));
	    	nextid++;
	    }
	    else if(ui[0].equals("showAnimal")) {
	    	String show = "";
	    	for(Cliente c : clientes.getAll())
	    			show += c.mostrar() + "\n";
	    	return show;
	    }
	    else if(ui[0].equals("addServ"))
			servicos.add(ui[1], new Servico(ui[1],Float.parseFloat(ui[2])));
	    else if(ui[0].equals("showServ")) {
			String serv = "";
			for(Servico s : servicos.getAll())
				serv += s.toString() + "\n";
			return serv;
		}
	    else if(ui[0].equals("vendaServ")) {
		    clientes.get(ui[1]); 
		    clientes.get(ui[1]).getAnimais().get(ui[2]);
		    servicos.get(ui[3]);
		    vendas.add(""+idvenda, new Vendas(idvenda,ui[1],ui[2],ui[3]));
		    dinheiro += servicos.get(ui[3]).getValor();
		    idvenda++;
		}
	    else if(ui[0].equals("showVenda")){
		    String total = "";
		    for(Vendas v : vendas.getAll())
			    total += v.toString() + "\n";
		    return total;
		}
	    else if(ui[0].equals("showLucro"))
	    	System.out.println(dinheiro);
	    else
	    	return " comando invalido";
	    return "done";
	    }
	}
	
	public class ServicoClinica{
		 //cria um objeto scan para ler strings do teclado
	    static Scanner scan = new Scanner(System.in);
	    
	    //aplica um tab e retorna o texto tabulado com dois espaços
	    static private String tab(String text){
	        return "  " + String.join("\n  ", text.split("\n"));
	    }
	    
	    public static void main(String[] args) {
	        Controller cont = new Controller();
	        System.out.println("Digite um comando:");
	        while(true){
	            String line = scan.nextLine();
	            try {
	                //se não der problema, faz a pergunta e mostra a resposta
	                System.out.println(tab(cont.oracle(line)));
	            }catch(Exception e) {
	                //se der problema, mostre o erro que deu
	                System.out.println(tab(e.getMessage()));
	            	}
	        	}
	    	}
	}
	

