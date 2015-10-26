package br.com.topmake.Bean;

import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.ItensCompraDAO;
import br.com.topmake.domain.ItensCompra;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItensCompraBean implements Serializable{
	
	private ItensCompra itensCompra;
	private List<ItensCompra> itensCompras;
	public ItensCompra getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra (ItensCompra itensCompra) {
		this.itensCompra = itensCompra;
	}
	public List<ItensCompra> getItensCompras() {
		return itensCompras;
	}
	public void setItensCompras (List<ItensCompra> itensCompras) {
		this.itensCompras = itensCompras;
	}
	
	public void novo(){
		itensCompra = new ItensCompra();
	}
	
	@PostConstruct
	public void Listar() {
		try {
			ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
			itensCompras = itensCompraDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar a compra!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
			itensCompraDAO.merge(itensCompra);

			itensCompras = itensCompraDAO.listar();
			

			Messages.addGlobalInfo("O Item " + itensCompra.getProduto().getNome() + " foi adicionado com sucesso! ");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar adicionar o item!!!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			itensCompra = (ItensCompra) evento.getComponent().getAttributes().get("itemCompraSelecionada");
			
			ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
			itensCompraDAO.excluir(itensCompra);

			itensCompras = itensCompraDAO.listar();

			Messages.addGlobalInfo("Item removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o Item " + erro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		itensCompra = (ItensCompra) evento.getComponent().getAttributes().get("itemCompraSelecionada");
				
	}
		
		
		
		
		
		
		
}//fim do programa
