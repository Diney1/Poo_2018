package whatsapp;

public class User {
	private String id;
	private Repositorio<Chat> grupos;
	private Repositorio<Message> mensagens;
	int qtdmsg = 0;
	
	public User(String id) {
		this.id = id;
		grupos = new Repositorio<Chat>("grupos");
		mensagens = new Repositorio<Message>("mensagens");
	}

	public String getIdUSer() {
		return id;
	}

	public void setIdUSer(String idUSer) {
		this.id = idUSer;
	}

	public Repositorio<Chat> getGrupos() {
		return grupos;
	}

	public void setGrupos(Repositorio<Chat> grupos) {
		this.grupos = grupos;
	}

	public Repositorio<Message> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Message> mensagens) {
		this.mensagens = mensagens;
	}
	
	public String toString() {
		return id;
	}
	
	
	//Verifica se a pessoa está no grupo se estiver, retorna a mensagem
	public Chat retornarChat(Chat c) {
		for(Chat chat : grupos.getAll())
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		throw new RuntimeException("fail: voce não esta neste grupo");
	}
	
	//ok
	public void mostrarmensagens(Chat c) {
		if(retornarChat(c) != null) {
			System.out.println(c.mostrarmsg(getIdUSer()));
		}
	}
	
	//ok
	public String contarMensagens(Chat c) {
		String saida = "";
		for(Message m : c.getMsg().getAll()) {
			if(!m.getUser().equals(id)) {
				if(!m.isLido()) {
					qtdmsg++;
					m.setLido(true);
				}
			}
		}
		saida += qtdmsg;
		qtdmsg = 0;
		return saida;
	}
	
	public String mostrargrupos() {
		String saida = "[ ";
		for(Chat c : grupos.getAll())
			saida += c.toString() + " ";
		return saida + " ]";
	}
}
