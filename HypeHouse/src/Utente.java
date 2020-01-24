public class Utente {
	private String Username;
	private String Password;
	private String TipoUtente;
	private String Nome;
	private String Cognome;
	private String Email;
	
	public Utente(String username,String pswd,String tipo,String nome,String cognome ,String email) {
		this.setUsername(username);
		this.setPassword(pswd);
		this.setTipoUtente(tipo);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
	}
	
	
	
	
	//getter and setter

	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getTipoUtente() {
		return TipoUtente;
	}


	public void setTipoUtente(String tipoUtente) {
		TipoUtente = tipoUtente;
	}

	
	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
}
