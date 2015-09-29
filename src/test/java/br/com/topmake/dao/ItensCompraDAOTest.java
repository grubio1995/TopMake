package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.ItensCompra;
import br.com.topmake.domain.Compra;
import br.com.topmake.domain.Produto;

public class ItensCompraDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer compraCodigo = 2;
		Integer produtoCodigo = 2;
		Short compraQtdProduto = 12;
		BigDecimal compraValorProduto = new BigDecimal(199.0);
		
		ItensCompra itensCompra = new ItensCompra();
		
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.Buscar(compraCodigo);
		
		if (compra == null) {
			System.out.println("Nenhuma compra encontrada!");
		}
		else {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.Buscar(produtoCodigo);
			
			if (produto == null) {
				System.out.println("Nenhum produto encontrada!");
			}
			else {
				itensCompra.setValorProduto(compraValorProduto);
				itensCompra.setCompra(compra);
				itensCompra.setProduto(produto);
				itensCompra.setQtdProduto(compraQtdProduto);
				
				ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
				
				itensCompraDAO.Salvar(itensCompra);
				System.out.println("Item de compra salvo com sucesso!");				
			}			
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		List<ItensCompra> resultado = itensCompraDAO.Listar();
		
		System.out.println("Total de itens de compra encontrados: " + resultado.size());
		
		for(ItensCompra itensCompra : resultado) {
			System.out.println(itensCompra.getCodigo() + " - " + itensCompra.getProduto().getCodigo()
					+ " - " + itensCompra.getQtdProduto() + " - " + itensCompra.getValorProduto()
					+ " - " + itensCompra.getCompra().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer itensCompraCodigo = 3;
		
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		ItensCompra itensCompra = itensCompraDAO.Buscar(itensCompraCodigo);
		
		if (itensCompra == null) {
			System.out.println("Nenhum item de compra encontrado!");
		}
		else {
			System.out.println(itensCompra.getCodigo() + " - " + itensCompra.getProduto().getCodigo()
					+ " - " + itensCompra.getQtdProduto() + " - " + itensCompra.getValorProduto()
					+ " - " + itensCompra.getCompra().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Integer itensCompraCodigo = 3;
		
		ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
		ItensCompra itensCompra = itensCompraDAO.Buscar(itensCompraCodigo);
		
		itensCompraDAO.Excluir(itensCompra);
		
		if (itensCompra == null) {
			System.out.println("Nenhum item de compra encontrado!");
		}
		else {
			itensCompraDAO.Excluir(itensCompra);
			System.out.println("Item de compra removido com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer compraCodigo = 2;
		Integer produtoCodigo = 2;
		Integer itensCompraCodigo = 3;
		Short itensCompraQtdProduto = 5;
		BigDecimal itensCompraValorProduto = new BigDecimal(13);		
		
		CompraDAO compraDAO = new CompraDAO();		
		Compra compra = compraDAO.Buscar(compraCodigo);
		
		if (compra == null) {
			System.out.println("Nenhuma compra encontrada!");
		}
		else {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.Buscar(produtoCodigo);
			
			if (produto == null) {
				System.out.println("Nenhum produto encontrado!");
			}
			else {
				ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
				ItensCompra itensCompra = itensCompraDAO.Buscar(itensCompraCodigo);	
				
				if (itensCompra == null) {
					System.out.println("Nenhum produto encontrado!");
				}
				else {
					itensCompra.setQtdProduto(itensCompraQtdProduto);
					itensCompra.setProduto(produto);
					itensCompra.setCompra(compra);
					
					itensCompra.setValorProduto(itensCompraValorProduto);
					itensCompraDAO.Editar(itensCompra);
					
					System.out.println("Item de compra editado com sucesso!");
				}
			}			
		}

		
}		
	
}
