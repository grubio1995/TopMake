package br.com.topmake.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Pagamento extends GenericDomain{

	@Column(nullable = false, length = 20)
	private String metodo;
	
	@Column(nullable = false, length = 20)
	private String situacao;
	
	@Column(nullable = false, length = 100)
	private String nomeTitular;
	
	@Column(nullable = false, length = 20)
	private String numeroCartao;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorPedido; 
	
	@Column(nullable = false, length = 20)
	private String numeroConta;
	
	@Column(nullable = false, length = 20)
	private String numeroAgencia;

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
}
