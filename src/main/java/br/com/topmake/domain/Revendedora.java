package br.com.topmake.domain;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
public class Revendedora extends GenericDomain {
	
	@JoinColumn(nullable = false)
	@OneToOne
	private Usuario revendedora;

	public Usuario getRevendedora() {
		return revendedora;
	}

	public void setRevendedora(Usuario revendedora) {
		this.revendedora = revendedora;
	}
	
	
	
}
