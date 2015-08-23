package br.com.topmake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Linha extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String classificacao;

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
}
