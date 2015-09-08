package br.com.topmake.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain {
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorTotal;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	
	@Column(length = 20, nullable = false)
	private String status;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private Pagamento pagamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
