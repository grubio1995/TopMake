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
		Pedido pedido = new Pedido();
		itensPedido.setPedido(pedido);
		BigDecimal bd = new BigDecimal(1.0);
		itensPedido.setValorProduto(bd);
		Produto produto = new Produto();
		itensPedido.setProduto(produto);
		Short s = 12;
		itensPedido.setQuantidadeProduto(s);
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		itensPedidoDAO.salvar(itensPedido);	
	}

	@Test
	public void listar(){
		ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
		List<ItensPedido> resultado = itensPedidoDAO.listar();
		System.out.println("Registros tabela Itens Pedido:");
		for(ItensPedido itensPedido : resultado){
			System.out.println("Qtd:" + itensPedido.getQuantidadeProduto());	
			System.out.println("valor:" + itensPedido.getValorProduto());	
		}
	}
	
}
