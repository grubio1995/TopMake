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
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.buscar(2L);
		itensCompra.setCompra(compra);		
		BigDecimal bd = new BigDecimal(199.0);
		itensCompra.setValorProduto(bd);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		itensCompra.setProduto(produto);
		Short s = 55;
		itensCompra.setQtdProduto(s);
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		itensCompraDAO.salvar(itensCompra);	
	}

	@Test
	@Ignore
	public void listar(){
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		List<ItensCompra> resultado = itensCompraDAO.listar();
		System.out.println("Registros tabela Itens Compra:");
		for(ItensCompra itensCompra : resultado){
			System.out.println("=====================================");
			System.out.println("Qtd:" + itensCompra.getQtdProduto());	
			System.out.println("valor:" + itensCompra.getValorProduto());	
			System.out.println("=====================================");
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		ItensCompra itensCompra = itensCompraDAO.buscar(3L);
		if(itensCompra == null){
			System.out.println("Nenhuma Itens de Compra encontrada");
		}else{
			System.out.println("Quantidade de produto: " + itensCompra.getQtdProduto());
			System.out.println("Valor do produto: " + itensCompra.getValorProduto());
			System.out.println("Produto: " + itensCompra.getProduto().getCodigo());
			System.out.println("Compra: " + itensCompra.getCompra().getCodigo());
		}
}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		ItensCompra itensCompra = itensCompraDAO.buscar(codigo);
		
		itensCompraDAO.excluir(itensCompra);
		
		System.out.println("Item da compra removido");
		System.out.println("Quantidade de produto: " + itensCompra.getQtdProduto());
		System.out.println("Valor do produto: " + itensCompra.getValorProduto());
		System.out.println("Produto: " + itensCompra.getProduto().getCodigo());
		System.out.println("Compra: " + itensCompra.getCompra().getCodigo());
		
}
	
	@Test
	@Ignore
	public void editar(){
	
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.buscar(2L);
		
		System.out.println("Código da compra: " + compra.getCodigo());
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		System.out.println("Código do produto: " + produto.getCodigo());
		
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		ItensCompra itensCompra = itensCompraDAO.buscar(3L);
		
		System.out.println("Itens de compra a serem editados");
		System.out.println("Quantidade de produto: " + itensCompra.getQtdProduto());
		System.out.println("Valor do produto: " + itensCompra.getValorProduto());
		System.out.println("Produto: " + itensCompra.getProduto().getNome());
		System.out.println("Codigo Compra: " + itensCompra.getCompra().getCodigo());
		Short s = 5;
		itensCompra.setQtdProduto(s);
		itensCompra.setProduto(produto);
		itensCompra.setCompra(compra);
		BigDecimal bg = new BigDecimal(13);
		itensCompra.setValorProduto(bg);
		itensCompraDAO.editar(itensCompra);
		
		System.out.println("Itens de compra editados");

		
}		
	
}
