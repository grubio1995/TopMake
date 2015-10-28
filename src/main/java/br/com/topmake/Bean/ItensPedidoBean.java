package br.com.topmake.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.ItensPedidoDAO;
import br.com.topmake.domain.ItensPedido;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItensPedidoBean implements Serializable{
	private ItensPedido itensPedido;
	private List<ItensPedido> itensPedidos;
	public ItensPedido getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(ItensPedido itensPedido) {
		this.itensPedido = itensPedido;
	}
	public List<ItensPedido> getItensPedidos() {
		return itensPedidos;
	}
	public void setItensPedidos(List<ItensPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	public void novo(){
		itensPedido = new ItensPedido();
	}
	
	@PostConstruct
	public void Listar() {
		try {
			ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
			itensPedidos = itensPedidoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as categorias!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
			itensPedidoDAO.merge(itensPedido);

			
			itensPedidos = itensPedidoDAO.listar();
			

			Messages.addGlobalInfo("O Item " + itensPedido.getProduto().getNome() + " foi adicionado com sucesso! ");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar adicionar o item!!!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			itensPedido = (ItensPedido) evento.getComponent().getAttributes().get("itemPedidoSelecionada");
			
			ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
			itensPedidoDAO.excluir(itensPedido);

			itensPedidos = itensPedidoDAO.listar();

			Messages.addGlobalInfo("Item removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o Item " + erro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		itensPedido = (ItensPedido) evento.getComponent().getAttributes().get("itemPedidoSelecionada");
				
	}
	

}
