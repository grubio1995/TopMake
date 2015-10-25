package br.com.topmake.Bean;

import java.io.Serializable;

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
			itensCompra = (ItensCompra) evento.getComponent().getAttributes().get("itemCompraSelecionada");
			
			ItensCompraDAO itensCompraDAO = new ItensCompraDAO();
			itensCompraDAO.excluir(itensCompra);

			itensCompra = itensCompraDAO.listar();

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
