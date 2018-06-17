public class GerenciadorLogin {

	private Repositorio<Cliente> clientes;
	private Cliente user;
	
	public GerenciadorLogin(Repositorio<Cliente> usuarios) {
		this.clientes = usuarios;
		user = null;
	}
	
	public void Login(String usuario, String password) {
		if(user != null)
			throw new RuntimeException("fail: Ja existe alguem logado");
		if(!clientes.get(usuario).matchPassword(password)) 
		   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
		this.user = clientes.get(usuario);
	}

	public void Logout() {
		if(user == null)
		    throw new RuntimeException("fail: ninguem logado");
		this.user = null;
	}
	
	public Cliente getUser() {
		if(user == null)
			throw new RuntimeException("fail: ninguem logado");
		return user;
	}
	
}