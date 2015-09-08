package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Compra;


public class CompraDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Compra compra = new Compra();
		Date d = new Date();
		compra.setDataCompra(d);
		BigDecimal bd = new BigDecimal(1.0);
		compra.setPrecoTotal(bd);
		CompraDAO compraDAO = new CompraDAO();
		compraDAO.salvar(compra);	
	}

	@Test
	public void listar(){
		CompraDAO compraDAO = new CompraDAO();
		List<Compra> resultado = compraDAO.listar();
		System.out.println("Registros tabela Compras:");
		for(Compra compra : resultado){
			System.out.println("Bairro:" + compra.getDataCompra());	
			System.out.println("Celular:" + compra.getPrecoTotal());	
		}
	}
}
