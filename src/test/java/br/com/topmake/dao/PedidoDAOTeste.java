package br.com.topmake.dao;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Pedido;
import br.com.topmake.domain.Pagamento;
import br.com.topmake.domain.Cliente;
import java.math.BigDecimal;

public class PedidoDAOTeste {

	@Test
	@Ignore
	public void salvar(){
		Pedido pedido = new Pedido();
		Date d = new Date();
		pedido.setDataPedido(d);
		pedido.setDataVenda(d);
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(2L);
		pedido.setPagamento(pagamento);
		pedido.setStatus("TESTE");
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(2L);
		pedido.setCliente(cliente);
		BigDecimal bd = new BigDecimal(100.00);
		pedido.setValorTotal(bd);

		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.salvar(pedido);
	}

	@Test
	@Ignore
	public void listar(){
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> resultado = pedidoDAO.listar();
		System.out.println("Registros tabela Pedidos:");
		for(Pedido pedido : resultado){
			System.out.println("============================================");
			System.out.println("Status:" + pedido.getStatus());		
			System.out.println("Data Pedido:" + pedido.getDataPedido());
			System.out.println("Data Venda:" + pedido.getDataVenda());
			System.out.println("Status:" + pedido.getStatus());
			System.out.println("Valor Total:" + pedido.getValorTotal());
			System.out.println("============================================");
		}
	}

	@Test
	//@Ignore
	public void buscar(){
	
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(2L);
		if(pedido == null){
			System.out.println("Nenhum pedido encontrado");
		}else{
			System.out.println("Data do pedido: " + pedido.getDataPedido());
			System.out.println("Status do pedido: " + pedido.getStatus());
			System.out.println("valor pedido: " + pedido.getValorTotal());
			System.out.println("Nome Cliente: " + pedido.getCliente().getUsuario().getNome());
			System.out.println("Metodo pagamento: " + pedido.getPagamento().getMetodo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
	
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(3L);
		pedidoDAO.excluir(pedido);
		System.out.println("Pedido Removido");
		System.out.println("Data do pedido: " + pedido.getDataPedido());
		System.out.println("Status do pedido: " + pedido.getStatus());
		System.out.println("valor pedido: " + pedido.getValorTotal());
		System.out.println("CPF Cliente: " + pedido.getCliente().getCpf());
		System.out.println("Metodo pagamento: " + pedido.getPagamento().getMetodo());
	}

	@Test
	@Ignore
	public void editar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(2L);
		
		System.out.println("Código do Cliente " + cliente.getCodigo());
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(2L);

		System.out.println("Pedido Editado");
		System.out.println("Data do pedido: " + pedido.getDataPedido());
		System.out.println("Status do pedido: " + pedido.getStatus());
		System.out.println("valor pedido: " + pedido.getValorTotal());
		System.out.println("CPF Cliente: " + pedido.getCliente().getCpf());
		System.out.println("Metodo pagamento: " + pedido.getPagamento().getMetodo());
		
		Date d = new Date();
		pedido.setDataPedido(d);
		pedido.setCliente(cliente);
		pedido.setStatus("Realizado");
		
		pedidoDAO.editar(pedido);
		
		System.out.println("Pedido editado");
		
	}

}
