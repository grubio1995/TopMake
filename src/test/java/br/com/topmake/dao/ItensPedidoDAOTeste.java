package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Pedido;
import br.com.topmake.domain.ItensPedido;
import br.com.topmake.domain.Produto;

public class ItensPedidoDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		ItensPedido itensPedido = new ItensPedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(2L);
		itensPedido.setPedido(pedido);
		BigDecimal bd = new BigDecimal(590.0);
		itensPedido.setValorProduto(bd);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		itensPedido.setProduto(produto);
		Short s = 10;
		itensPedido.setQuantidadeProduto(s);
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		itensPedidoDAO.salvar(itensPedido);	
	}

	@Test
	@Ignore
	public void listar(){
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		List<ItensPedido> resultado = itensPedidoDAO.listar();
		System.out.println("Registros tabela Itens Pedido:");
		for(ItensPedido itensPedido : resultado){
			System.out.println("===========================================");
			System.out.println("Qtd:" + itensPedido.getQuantidadeProduto());	
			System.out.println("valor:" + itensPedido.getValorProduto());	
			System.out.println("===========================================");
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		ItensPedido itensPedido = itensPedidoDAO.buscar(2L);
		if(itensPedido == null){
			System.out.println("Nenhum Itens de pedido encontrado");
		}else{
			System.out.println("Quantidade de produto: " + itensPedido.getQuantidadeProduto());
			System.out.println("Valor do produto: " + itensPedido.getValorProduto());
			System.out.println("Pedido: " + itensPedido.getPedido().getCodigo());
			System.out.println("Produto: " + itensPedido.getProduto().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		ItensPedido itensPedido = itensPedidoDAO.buscar(codigo);
		
		itensPedidoDAO.excluir(itensPedido);
		
		System.out.println("Item do pedido removido");
		System.out.println("Quantidade de produto: " + itensPedido.getQuantidadeProduto());
		System.out.println("Valor do produto: " + itensPedido.getValorProduto());
		System.out.println("Pedido: " + itensPedido.getPedido().getCodigo());
		System.out.println("Produto: " + itensPedido.getProduto().getCodigo());
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(2L);
		
		System.out.println("Código do pedido: " + pedido.getCodigo());
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		System.out.println("Código do produto: " + produto.getCodigo());

		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		ItensPedido itensPedido = itensPedidoDAO.buscar(3L);

		System.out.println("Itens de pedido a serem editados");
		System.out.println("Quantidade de produto: " + itensPedido.getQuantidadeProduto());
		System.out.println("Valor do produto: " + itensPedido.getValorProduto());
		System.out.println("Pedido: " + itensPedido.getPedido().getCodigo());
		System.out.println("Produto: " + itensPedido.getProduto().getCodigo());
		Short s = 3;
		itensPedido.setQuantidadeProduto(s);
		BigDecimal bg = new BigDecimal(12.00);
		itensPedido.setValorProduto(bg);
		itensPedido.setPedido(pedido);
		itensPedidoDAO.editar(itensPedido);
		
		System.out.println("Itens de pedido editados");

}	
	
}
