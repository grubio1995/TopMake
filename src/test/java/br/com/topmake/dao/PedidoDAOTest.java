package br.com.topmake.dao;


import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Pedido;
import br.com.topmake.domain.Status;
import br.com.topmake.domain.Pagamento;
import br.com.topmake.domain.Cliente;
import java.math.BigDecimal;

public class PedidoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer pagamentoCodigo = 2;
		Integer clienteCodigo = 2;
		Integer statusCodigo = 1;
		Date pedidoDataPedido = new Date();
		Date pedidoDataVenda = new Date();
		BigDecimal pedidoValorTotal = new BigDecimal(100.00);
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.Buscar(pagamentoCodigo);
		
		if (pagamento == null) {
			System.out.println("Nenhum pagamento encontrado!");				
		}
		else {
			ClienteDAO clienteDAO = new ClienteDAO();		
			Cliente cliente = clienteDAO.Buscar(clienteCodigo);
			
			if (cliente == null) {
				System.out.println("Nenhum cliente encontrado!");				
			}
			else {
				StatusDAO statusDAO = new StatusDAO();
				Status status = statusDAO.Buscar(statusCodigo);
				if (status == null) {
					System.out.println("Nenhum status encontrado!");					
				}
				else {
					Pedido pedido = new Pedido();
					pedido.setPagamento(pagamento);
					pedido.setDataPedido(pedidoDataPedido);
					pedido.setDataVenda(pedidoDataVenda);
					pedido.setStatus(status);
					pedido.setCliente(cliente);
					pedido.setValorTotal(pedidoValorTotal);
					
					PedidoDAO pedidoDAO = new PedidoDAO();
					pedidoDAO.Salvar(pedido);
					System.out.println("Pedido salvo com sucesso!");
				}				
			}			
		}		
	}

	@Test
	@Ignore
	public void listar() {
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> resultado = pedidoDAO.Listar();
		
		System.out.println("Total de pedidos encontrados: " + resultado.size());
		
		for(Pedido pedido : resultado) {
			System.out.println("============================================");
			System.out.println("Pedido:" + pedido.getCodigo());
			System.out.println("Data Pedido:" + pedido.getDataPedido());
			System.out.println("Data Venda:" + pedido.getDataVenda());
			System.out.println("Status:" + pedido.getStatus());
			System.out.println("Valor Total:" + pedido.getValorTotal());
			System.out.println("Nome Cliente: " + pedido.getCliente().getUsuario().getNome());
			System.out.println("Método pagamento: " + pedido.getPagamento().getMetodo());
			System.out.println("============================================");
		}
	}

	@Test
	@Ignore
	public void buscar(){
		Integer pedidoCodigo = 2;
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.Buscar(pedidoCodigo);
		
		if (pedido == null) {
			System.out.println("Nenhum pedido encontrado!");
		}
		else {
			System.out.println("Pedido:" + pedido.getCodigo());
			System.out.println("Data Pedido:" + pedido.getDataPedido());
			System.out.println("Data Venda:" + pedido.getDataVenda());
			System.out.println("Status:" + pedido.getStatus());
			System.out.println("Valor Total:" + pedido.getValorTotal());
			System.out.println("Nome Cliente: " + pedido.getCliente().getUsuario().getNome());
			System.out.println("Método pagamento: " + pedido.getPagamento().getMetodo());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Integer pedidoCodigo = 3;
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.Buscar(pedidoCodigo);

		if (pedido == null) {
			System.out.println("Nenhum pedido encontrado!");
		}
		else {
			pedidoDAO.Excluir(pedido);
			System.out.println("Pedido removido com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer clienteCodigo = 2;
		Integer pedidoCodigo = 2;
		Date pedidoDataPedido = new Date();
		Status status = new Status();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(clienteCodigo);
		
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado!");
		}
		else {
			PedidoDAO pedidoDAO = new PedidoDAO();
			Pedido pedido = pedidoDAO.Buscar(pedidoCodigo);
			
			if (pedido == null) {
				System.out.println("Nenhum pedido encontrado!");
			}
			else {
				pedido.setDataPedido(pedidoDataPedido);
				pedido.setCliente(cliente);
				pedido.setStatus(status);
				
				pedidoDAO.Editar(pedido);
				
				System.out.println("Pedido editado com sucesso!");				
			}
		}
		
	}

}
