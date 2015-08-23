package br.com.topmake.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity

public class Produto extends GenericDomain {
	
	@Column(length = 30, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String cor;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;
	
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Short qtd;
	
	@Column(nullable = false)
	private Short qtdMinima;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Categoria categoria;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Linha linha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQtd() {
		return qtd;
	}

	public void setQtd(Short qtd) {
		this.qtd = qtd;
	}

	public Short getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Short qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}	
}
