package br.com.topmake.domain;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Revendedora extends GenericDomain {

	@JoinColumn(nullable = false)
	@OneToOne
	private Usuario usuario;

	public Usuario getRevendedora() {
		return usuario;
	}

	public void setRevendedora(Usuario usuario) {
		this.usuario = usuario;
	}

}
