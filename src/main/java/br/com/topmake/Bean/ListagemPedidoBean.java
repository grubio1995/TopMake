package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.PedidoDAO;
import br.com.topmake.domain.Pedido;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ListagemPedidoBean implements Serializable {
	private Pedido pedido;
	private List<Pedido> pedidos;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void novo() {
		pedido = new Pedido();
	}

	@PostConstruct
	public void Listar() {
		try {
			PedidoDAO pedidosDAO = new PedidoDAO();
			pedidos = pedidosDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Pedidos!!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			pedidoDAO.merge(pedido);

			Messages.addGlobalInfo("O Pedido do(a) cliente: " + pedido.getCliente().getUsuario().getNome() + " foi salvo com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o pedido!!!");
			erro.printStackTrace();
		}
	}


	public void editar(ActionEvent evento) {
		pedido = (Pedido) evento.getComponent().getAttributes().get("pedidoSelecionada");
		Messages.addGlobalInfo("" + pedido.getCliente().getUsuario().getNome());
		
	}
}
