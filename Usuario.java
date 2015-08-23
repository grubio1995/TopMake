package br.com.topmake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain  {
	
	@Column(length = 100,nullable = false)
	private String nome;
	
	@Column(length = 80, nullable = false)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String login;
	
	@Column(length = 32, nullable = false)
	private String senha;

	@Column(nullable = false)
	private char tipoUsuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
