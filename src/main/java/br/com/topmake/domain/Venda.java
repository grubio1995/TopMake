package br.com.topmake.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain{
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date dateVenda;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	public Cliente cliente;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	public Pedido pedido;

	public Date getDateVenda() {
		return dateVenda;
	}

	public void setDateVenda(Date dateVenda) {
		this.dateVenda = dateVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
