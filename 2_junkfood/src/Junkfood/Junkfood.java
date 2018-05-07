package junkfood;

import java.util.ArrayList;
import java.util.Scanner;

class Espiral{
	String nome;
	int qtd;
	float preco;
	
	public Espiral(String nome, int qtd, float preco){
		
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
		
	}

	@Override
	public String toString(){
			if(this.nome == null) {
				return "[- : 0 U : 0 RS]";
			}else {
			return "[ "+ this.nome + " : " + this.qtd + " U : " + this.preco + " RS]";
			}
	}
}
	
class Maquina{
	
	ArrayList<Espiral> espirais;
	public float lucro;
	public float saldo_Cli;
	static int maxProdutos;
	
	public Maquina(int qtdEspirais, int maxProdutos){
		this.lucro = 0f;
		this.saldo_Cli = 0f;
		this.espirais = new ArrayList<Espiral>();
		Maquina.maxProdutos = maxProdutos;
		for ( int i = 0 ; i < qtdEspirais ; i++) {
			this.espirais.add(new Espiral(null, 0, 0));
		}
	}
		
	
	public void add(int indice, String nome, int qtd, float preco) {
		for(int i = 0; i < espirais.size(); i++) {
			if((indice == i) && (qtd <= Maquina.maxProdutos)) {
				espirais.get(indice).nome = nome;
				espirais.get(indice).preco = preco;
				espirais.get(indice).qtd = qtd;
				return;
			}
			else if(Maquina.maxProdutos < qtd ) {
				throw new RuntimeException("fail: limite de produtos eh "+ Maquina.maxProdutos + " por espiral");
			}
		}
			throw new RuntimeException("fail: Indice " + indice +" não existe");
		
		}
	
	public void Limparespiral(int indice) {
		this.espirais.get(indice).nome = null;
		this.espirais.get(indice).qtd = 0;
		this.espirais.get(indice).preco = 0;
	}
	
	public void atualizarespiral(int indice, String nome, int qtd, float preco) {
		this.espirais.get(indice).nome = nome;
		this.espirais.get(indice).qtd = qtd;
		this.espirais.get(indice).preco = preco;
	}
	
	public void troco() {
		float saldo = saldo_Cli;
		saldo_Cli -= saldo_Cli;
		throw new RuntimeException("Seu troco " +saldo); 
		
	}
	
	
	public void Comprar(int indice){
			for(int i = 0; i < espirais.size();) {
				if((espirais.get(i).qtd > 0) && (saldo_Cli >= espirais.get(i).preco)) {
					espirais.get(i).qtd -= 1;
					saldo_Cli -= espirais.get(i).preco;
					lucro += espirais.get(i).preco;
					throw new RuntimeException("comprou um " + espirais.get(i).nome + "\nsaldo: " + saldo_Cli+ " R$");
				}
				else if(espirais.get(i).qtd <= 0) {
					throw new RuntimeException("fail: espiral sem produtos");
				}
				else {
					throw new RuntimeException("fail: " + espirais.get(i).nome + " valor " + espirais.get(i).preco + ", saldo insuficiente");
				}
			}
		
			throw new RuntimeException("fail: indice nao existe");
	}
	
	public String toString() {
		String saida = "";
		for (int i = 0; i < espirais.size(); i++)
			saida += i + " " + espirais.get(i) + " \n";
		return  "saldo: " + saldo_Cli + " R$\n" + saida;
	}
	
	public void addDinheiro(float valor) {
		saldo_Cli += valor;
	}
	public void sair() {
		System.exit(0);
	}

}

class Controller{
	   Maquina maq;
	    static final int DEFAULT_ESPIRAIS = 3;
	    static final int DEFAULT_MAX = 5;
	    public Controller() {
	        maq = new Maquina(DEFAULT_ESPIRAIS, DEFAULT_MAX);
	    }
	    
	    //recebe uma string e tenta converter em float
	    private float toFloat(String s) {
	        return Float.parseFloat(s);
	    }
	    
	    //nossa funcao oraculo que recebe uma pergunta e retorna uma resposta
	    public String oracle(String line){
	        String ui[] = line.split(" ");

	        if(ui[0].equals("help"))
	            return "show, init _espirais _maximoespirais, add _id _nome _qtd _preco\n"
	            		+ "Limpar _indice, dinheiro _valor, comprar _indice\n"
	            		+ "atualizar _id _nome _qtd _ preco";
	        
	        else if(ui[0].equals("init")) {
	            maq = new Maquina(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
	        }
	        else if(ui[0].equals("show"))
	            return "" + maq;
	        
	        else if(ui[0].equals("add"))
	        	maq.add(Integer.parseInt(ui[1]),ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
	        
	        else if(ui[0].equals("Limpar"))
	        	maq.Limparespiral(Integer.parseInt(ui[1]));
	        
	        else if(ui[0].equals("atualizar"))
	        	maq.atualizarespiral(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
	        
	        else if(ui[0].equals("dinheiro")) 
	        	maq.addDinheiro(Float.parseFloat(ui[1]));
	        
	        else if(ui[0].equals("comprar"))
				maq.Comprar(Integer.parseInt(ui[1]));

	        else if(ui[0].equals("troco"))
				maq.troco();
	        else
	            return "comando invalido";
	        return "done";
	    }
	}

public class Junkfood {
	  //cria um objeto scan para ler strings do teclado
    static Scanner scan = new Scanner(System.in);
 
    //aplica um tab e retorna o texto tabulado com dois espaços
    static private String tab(String text){
        return "  " + String.join("\n  ", text.split("\n"));
    }
    
    public static void main(String[] args) {
        Controller cont = new Controller();
        System.out.println("Digite um comando ou help:");
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
