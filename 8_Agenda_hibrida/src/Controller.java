import java.util.Scanner;

public class Controller {

		Scanner sca;
        Agenda agenda;
        String senhamestra;
        AgendaMaster master;
		
	public Controller() {
		sca = new Scanner(System.in);
		agenda = new Agenda();
		master = new AgendaMaster(agenda);
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addcontato"))
			agenda.getEntradas().add(ui[1], new Contato(ui[1]));
		
		else if(ui[0].equals("addpass")) 
			agenda.getEntradas().add(ui[1], new Password(ui[1],ui[2]));
		
		else if (ui[0].equals("addnote")) {
			String texto = "";
			for (int i = 2; i < ui.length; i++)
				texto += ui[i] + " ";
			agenda.getEntradas().add(ui[1], new Note(ui[1], texto));
		}
		
		else if(ui[0].equals("masterpass"))
			master.setSenhamestra(ui[1]);
		
		else if(ui[0].equals("showpassmestre"))
			master.mostrarSenhas(ui[1]);
		
		else if(ui[0].equals("showpass")) {
			master.addPass();
			String show = "";
			for (Password p : master.getSenhas().getAll()) {
				int quantidade = p.getIdentrada().length();
				show += p.toString() + " " + p.converte(quantidade) + "\n";
			}
			return show;
		}
	
		else if (ui[0].equals("addfone"))
			master.getContatos().get(ui[1]).addFone(new Fone(ui[2], ui[3]));
		
		else if (ui[0].equals("showfones")) {
			System.out.println("User: " + master.getContatos().get(ui[1]).getIdentrada());
			System.out.println(master.getContatos().get(ui[1]).mostrarFone());
		} 
		
		else if (ui[0].equals("rmfone")) 
			master.getContatos().get(ui[1]).rmFone(ui[2]);
		
		else if (ui[0].equals("showcontatos")) {
			master.addContato();
			String saida = "";
			for (Contato c : master.getContatos().getAll())
				saida += c.toString() + "\n";
			return saida;
		} 
		
		else if (ui[0].equals("shownotes")) {
			master.addNote();
			String saida = "";
			for (Note n : master.getNotas().getAll())
				saida += n.toString() + "\n";
			return saida;
		} 
		
		else if (ui[0].equals("favoritar"))
			agenda.favoritar(agenda.getEntradas().get(ui[1]));
		
		else if (ui[0].equals("desfavoritar"))
			agenda.desfavoritar(agenda.getEntradas().get(ui[1]));
		
		else if (ui[0].equals("showfavoritos")) 
			System.out.println(agenda.mostrarFavoritos());
		
		else if (ui[0].equals("showentradas")) 
			System.out.println(agenda.mostrar());
		
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
