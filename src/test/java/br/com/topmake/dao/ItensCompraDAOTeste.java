package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.ItensCompra;
import br.com.topmake.domain.Compra;
import br.com.topmake.domain.Produto;

public class ItensCompraDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		ItensCompra itensCompra = new ItensCompra();
		Compra compra = new Compra();
		itensCompra.setCompra(compra);
		BigDecimal bd = new BigDecimal(1.0);
		itensCompra.setValorProduto(bd);
		Produto produto = new Produto();
		itensCompra.setProduto(produto);
		Short s = 12;
		itensCompra.setQtdProduto(s);
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		itensCompraDAO.salvar(itensCompra);	
	}

	@Test
	public void listar(){
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		List<ItensCompra> resultado = itensCompraDAO.listar();
		System.out.println("Registros tabela Itens Compra:");
		for(ItensCompra itensCompra : resultado){
			System.out.println("Qtd:" + itensCompra.getQtdProduto());	
			System.out.println("valor:" + itensCompra.getValorProduto());	
		}
	}
}
