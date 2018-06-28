import java.util.Scanner;

public class Controller {
	Repositorio<Usuario> usuarios;
	Scanner sca;
	Gerenciador gerenciador_tweet;
	int numTweet = 1;
	int cont = 0;
	
	
	public Controller() {
		usuarios =  new Repositorio<Usuario>("usuarios");
		sca = new Scanner(System.in);
		gerenciador_tweet = new Gerenciador();
	} 
	
	
	public String query(String line) {
		String[] ui = line.split(" ");
	
		if(ui[0].equals("help")) {
			throw new RuntimeException(""
					+ "adduser _usuario, showuser\n"
					+ "seguir _idseguindo _iduseguidor\n"
					+ "twittar ");
		}
		//ok
		else if(ui[0].equals("adduser"))
			usuarios.add(ui[1], new Usuario(ui[1]));
		
		//ok
		else if (ui[0].equals("showuser")) {
			String saida = "";
			for(Usuario u : usuarios.getAll()) {
				saida += u.toString() + "\n   Seguidores ["+u.mostrarSeguidores()+"]\n   Seguindo ["+u.mostrarSeguidos()+"] \n";
			}
			return saida;
		}
		
		//ok
		else if(ui[0].equals("seguir"))
			usuarios.get(ui[2]).seguir(usuarios.get(ui[1]));
		//ok 
		else if(ui[0].equals("twittar")) {
			String texto = "";
			for(int i = 3; i < ui.length; i++) {
				texto += ui[i] + " ";
			}
			Tweet aux = new Tweet(numTweet, usuarios.get(ui[1]), ui[2], texto);
			for(Usuario u : usuarios.get(ui[1]).getSeguidores().getAll()) 
				u.addTime(aux);
			 
			usuarios.get(ui[1]).criarTweet(aux);
			gerenciador_tweet.Gerenciador_Tweet(aux);
			numTweet++;
		}
		//ok
		else if(ui[0].equals("darlike")) {
			usuarios.get(ui[1]).darLike(Integer.parseInt(ui[2]));
			gerenciador_tweet.getTweets().get(ui[2]).darLike(usuarios.get(ui[1]).getId());
		}
		//ok
		else if(ui[0].equals("mytweets"))
			System.out.println(usuarios.get(ui[1]).mostrarMyTweets());
		//ok
		else if(ui[0].equals("timeline"))
			System.out.println(usuarios.get(ui[1]).mostrarTime());
		//ok
		else if(ui[0].equals("showlikes"))
			System.out.println(" " + gerenciador_tweet.getTweets().get(ui[1]).Mostrarlikes());
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
/*
adduser diney
done
adduser claro 
done
seguir diney claro
done
seguir claro diney
done
*/