package br.com.topmake.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.PedidoDAO;
import br.com.topmake.domain.Pedido;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PedidoBean implements Serializable {
	private Pedido pedido;
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void novo() {
		pedido = new Pedido();
	}
	public void salvar() {
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			pedidoDAO.merge(pedido);

			

			Messages.addGlobalInfo("O pedido do(a) cliente: " + pedido.getCliente() + " foi salvo com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o pedido!!!");
			erro.printStackTrace();
		}
	}
}
