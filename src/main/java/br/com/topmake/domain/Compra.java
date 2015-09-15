package br.com.topmake.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Compra extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCompra;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoTotal;
	
	public Date getDataCompra() {
		return dataCompra;
	}
	
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

}
