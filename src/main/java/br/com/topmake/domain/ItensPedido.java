package br.com.topmake.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItensPedido extends GenericDomain {

	@Column(nullable = false)
	private Short quantidadeProduto;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorProduto;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Pedido pedido;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Produto produto;

	public Short getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Short quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
