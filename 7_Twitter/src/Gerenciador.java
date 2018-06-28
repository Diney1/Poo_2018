
public class Gerenciador {
	private Repositorio<Tweet> tweets;
	
	
	public Gerenciador() {
		tweets = new Repositorio<Tweet>("tweets");
	}


	public Repositorio<Tweet> getTweets() {
		return tweets;
	}


	public void setTweets(Repositorio<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void Gerenciador_Tweet(Tweet t) {
		tweets.add(""+t.getIdTweet(), t);
	}
	
	public String mostrarTweets() {
		String saida = " ";
		for(Tweet t : tweets.getAll())
			saida += t.toString() + " ";
		return saida;
	}
	
}
