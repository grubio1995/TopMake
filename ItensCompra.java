package br.com.topmake.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItensCompra extends GenericDomain {

		@Column(nullable = false)
		private Short qtdProduto;
		
		@Column(nullable = false, precision = 6, scale = 2)
		private BigDecimal valorProduto;
		
		@JoinColumn(nullable = false)
		@ManyToOne
		private Produto produto;
		
		@JoinColumn(nullable = false)
		@ManyToOne
		private Compra compra;

		public Short getQtdProduto() {
			return qtdProduto;
		}

		public void setQtdProduto(Short qtdProduto) {
			this.qtdProduto = qtdProduto;
		}

		public BigDecimal getValorProduto() {
			return valorProduto;
		}

		public void setValorProduto(BigDecimal valorProduto) {
			this.valorProduto = valorProduto;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public Compra getCompra() {
			return compra;
		}

		public void setCompra(Compra compra) {
			this.compra = compra;
		}
}
