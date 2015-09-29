package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Pedido;
import br.com.topmake.domain.ItensPedido;
import br.com.topmake.domain.Produto;

public class ItensPedidoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer pedidoCodigo = 2;
		Integer produtoCodigo = 2;
		Short itensPedidoQtdProduto = 10;
		BigDecimal itensPedidoValorProduto = new BigDecimal(590.0);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.Buscar(pedidoCodigo);
		
		if (pedido == null) {
			System.out.println("Nenhum pedido encontrada!");
		}
		else {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.Buscar(produtoCodigo);
			
			if (produto == null) {
				System.out.println("Nenhum produto encontrada!");
			}
			else {
				ItensPedido itensPedido = new ItensPedido();
				
				itensPedido.setPedido(pedido);
				itensPedido.setProduto(produto);
				itensPedido.setValorProduto(itensPedidoValorProduto);
				itensPedido.setQtdProduto(itensPedidoQtdProduto);
				
				ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
				itensPedidoDAO.Salvar(itensPedido);
				System.out.println("Item de pedido salvo com sucesso!");					
			}			
		}
	}

	@Test
	@Ignore
	public void listar() {
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		List<ItensPedido> resultado = itensPedidoDAO.Listar();
		
		System.out.println("Total de itens de pedido encontrados: " + resultado.size());
		
		for(ItensPedido itensPedido : resultado) {
			System.out.println(itensPedido.getCodigo() + " - " + itensPedido.getQtdProduto()
				+ " - " + itensPedido.getValorProduto() + " - " + itensPedido.getPedido().getCodigo()
				+ " - " + itensPedido.getProduto().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer itensPedidoCodigo = 2;
		
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		ItensPedido itensPedido = itensPedidoDAO.Buscar(itensPedidoCodigo);
		
		if(itensPedido == null) {
			System.out.println("Nenhum item de pedido encontrado!");
		}
		else {
			System.out.println(itensPedido.getCodigo() + " - " + itensPedido.getQtdProduto()
			+ " - " + itensPedido.getValorProduto() + " - " + itensPedido.getPedido().getCodigo()
			+ " - " + itensPedido.getProduto().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Integer itensPedidoCodigo = 3;
		
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		ItensPedido itensPedido = itensPedidoDAO.Buscar(itensPedidoCodigo);
		
		if (itensPedido == null) {
			System.out.println("Nenhum item de pedido encontrado!");
		}
		else {
			itensPedidoDAO.Excluir(itensPedido);
			System.out.println("Item de pedido removido com sucesso!");
		}
		
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer pedidoCodigo = 2;
		Integer produtoCodigo = 2;
		Integer itensPedidoCodigo = 3;
		Short itensPedidoQtdProduto = 3;
		BigDecimal itensPedidoValorProduto = new BigDecimal(12.00);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.Buscar(pedidoCodigo);
		
		if (pedido == null) {
			System.out.println("Nenhum pedido encontrado!");
		}
		else {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.Buscar(produtoCodigo);
			
			if (produto == null) {
				System.out.println("Nenhum produto encontrado!");
			}
			else {
				ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
				ItensPedido itensPedido = itensPedidoDAO.Buscar(itensPedidoCodigo);
				
				if (itensPedido == null) {
					System.out.println("Nenhum item de pedido encontrado!");
				}
				else {
					itensPedido.setPedido(pedido);
					itensPedidoDAO.Editar(itensPedido);
					itensPedido.setQtdProduto(itensPedidoQtdProduto);
					itensPedido.setValorProduto(itensPedidoValorProduto);
					
					System.out.println("Item de pedido editado com sucesso!");					
				}							
			}			
		}
	

}	
	
}
