package br.com.topmake.dao;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Pedido;
import br.com.topmake.domain.Pagamento;
import br.com.topmake.domain.Usuario;
import java.math.BigDecimal;

public class PedidoDAOTeste {

	@Test
	@Ignore
	public void salvar(){
		Pedido pedido = new Pedido();
		Date d = new Date();
		pedido.setDataPedido(d);
		pedido.setDataVenda(d);
		Pagamento pagamento = new Pagamento();
		pedido.setPagamento(pagamento);
		pedido.setStatus("Andamento");
		Usuario usuario = new Usuario();
		pedido.setUsuario(usuario);
		BigDecimal bd = new BigDecimal(34.12);
		pedido.setValorTotal(bd);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.salvar(pedido);
	}

	@Test
	public void listar(){
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> resultado = pedidoDAO.listar();
		System.out.println("Registros tabela Pedidos:");
		for(Pedido pedido : resultado){
			System.out.println("Status:" + pedido.getStatus());		
			System.out.println("Data Pedido:" + pedido.getDataPedido());
			System.out.println("Data Venda:" + pedido.getDataVenda());
			System.out.println("Status:" + pedido.getStatus());
			System.out.println("Valor Total:" + pedido.getValorTotal());
			
		}
	}

}
