
public class Usuario {
	
	private String id;
	private Repositorio<Usuario> seguidos;
	private Repositorio<Usuario> seguidores;
	private Repositorio<Tweet> myTweet;
	private Repositorio<Tweet> timeline;
	Tweet mensagem;
	int cont_tweets = 0;
	public Usuario(String id) {
		this.id = id;
		seguidos = new Repositorio<Usuario>("seguidos");
		seguidores = new Repositorio<Usuario>("seguidores");
		myTweet = new Repositorio<Tweet>("myTweet");
		timeline = new Repositorio<Tweet>("timeline");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Repositorio<Usuario> getSeguidos() {
		return seguidos;
	}

	public Repositorio<Usuario> getSeguidores() {
		return seguidores;
	}
	
	public Repositorio<Tweet> getTimeline() {
		return timeline;
	}
	
	//Métodos
	public String toString() {
		return "" +id;
	}
	
	//ok
	public String mostrarSeguidores() {
		String mostrar = "";
		for(Usuario seguidores : seguidores.getAll())
			mostrar += seguidores + " ";
		return mostrar;
	}
	//ok
	public String mostrarSeguidos() {
		String mostrar = "";
		for(Usuario sigo : seguidos.getAll())
			mostrar += sigo + " ";
		return mostrar;
	}
	
	//ok
	public void seguir(Usuario user) {
		user.seguidos.add(getId(), new Usuario(getId()));
		seguidores.add(user.getId(), user);
	}
	
	public void criarTweet(Tweet t) {
		myTweet.add(""+t.getIdTweet(), t);
	}
	
	//ok
	public String mostrarMyTweets() {
		String mostrar = "";
		for(Tweet t : myTweet.getAll()) {
			mostrar += " " + t.getIdTweet() + " " + t.getUser() + " " + t.getTitulo() + " " + t.getTexto()+ "\n";
		}
		return mostrar;
	}
	
	public void darLike(int idTweet) {
		for(Tweet t : timeline.getAll()) {
			if(t.getIdTweet() == idTweet) {
				if(!t.isLike()) {
					   t.setLike(true);
				 	   return;
				}
			}
		}
		throw new RuntimeException("fail: você não possui esse Tweet");
	}
	
	
	//ok
	public void addTime(Tweet t) {
		this.timeline.add(""+t.getIdTweet(), t);
	}
	
	public String mostrarTime() {
    	String saida = "";
    	for(Tweet t : timeline.getAll()) {
    		if(!t.isLido()) {
    		   saida += " " + t.getIdTweet() + " " +t.getUser()+ ":"+t.getTitulo() + " " + t.getTexto() + "\n"; 
    		   t.setLido(true);
    	       cont_tweets++;
    	    }
    	}
    	System.out.println(" Voce tem :" + cont_tweets + " tweets");
    	cont_tweets = 0;
    	return saida;
    }
	
}