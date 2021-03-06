package whatsapp;

public class Chat {
	private String chat;
	public Repositorio<User> userchats;
	public Repositorio<Message> msg;
	int qtdmsg = 0;
	
	public Chat(String chat) {
		this.chat = chat;
		userchats = new Repositorio<User>("usuarios");
		msg = new Repositorio<Message>("mensagens");
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Repositorio<User> getUserchats() {
		return userchats;
	}

	public void setUserchats(Repositorio<User> userchats) {
		this.userchats = userchats;
	}

	public Repositorio<Message> getMsg() {
		return msg;
	}

	public void setMsg(Repositorio<Message> msg) {
		this.msg = msg;
	}
	//ESCREVER MENSAGENS
	public void escrever(Message m) {
		for(User u : userchats.getAll()) {
			u.getGrupos().get(getChat()).getMsg().add(m.getIndice(), m);
		}
		msg.add(m.getIndice(),  m);
	}
	//MOSTRAR OS USUARIOS QUE EST�O NO GRUPO
	public String mostrarusuarios() {
		String saida = "[";
		for(User u : userchats.getAll())
			saida += u.toString() + " ";
		return saida + "]";
	}
	
	//ADICIONAR USUARIOS AO GRUPO
	public void adicionarAOgrupo(User usuario) {
		userchats.add(usuario.getIdUSer(), usuario);
		usuario.getGrupos().add(getChat(), new Chat(getChat()));
	} 
	
	//MOSTRAR MENSAGENS
	public String mostrarmsg(String user) {
		String saida = "";
		for(Message m : msg.getAll()) {
			if(!user.equals(m.getUser())) {
				saida += m +" ";
			}
		}
		return saida;
	}
	
	
	
	
	public String toString() {
		return " "+chat;
	}
	
	
}
