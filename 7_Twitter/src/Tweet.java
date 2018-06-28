import java.util.ArrayList;

public class Tweet {
	private int idTweet;
	Usuario user;
	private String titulo;
	private String texto;
	private boolean lido;
	private boolean like;
	private ArrayList<String> qtd_likes;
	
	public Tweet(int id, Usuario user, String titulo, String texto) {
		this.idTweet = id;
		this.user = user;
		this.titulo = titulo;
		this.texto = texto;
		this.lido = false;
		this.like = false;
		qtd_likes = new ArrayList<String>();
	}

	public int getIdTweet() {
		return idTweet;
	}

	public void setIdTweet(int idTweet) {
		this.idTweet = idTweet;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isLido() {
		return lido;
	}

	public void setLido(boolean lido) {
		this.lido = lido;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public ArrayList<String> getQtd_likes() {
		return qtd_likes;
	}
	
	public void darLike(String user) {
		this.qtd_likes.add(user);
	}
	
	public String Mostrarlikes() {
		String saida = " ";
		
		for(int i = 0; i < qtd_likes.size(); i++) {
			saida += "" + qtd_likes.get(i) + "\n";
		}
		return saida;
	}
	
	public String toString() {
		return idTweet+ " : " +user+ " : " +titulo+ " : " +texto;  
	}
}
	