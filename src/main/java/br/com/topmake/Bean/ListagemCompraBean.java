package br.com.topmake.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.CompraDAO;
import br.com.topmake.domain.Compra;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class ListagemCompraBean implements Serializable {
	private Compra compra;
	private List<Compra> compras;

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra getCompra() {
		return compra;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public void novo() {
		compra = new Compra();
	}

	@PostConstruct
	public void Listar() {
		try {
			CompraDAO comprasDAO = new CompraDAO();
			compras = comprasDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Compras!!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CompraDAO compraDAO = new CompraDAO();
			compraDAO.merge(compra);

			Messages.addGlobalInfo("A Compra : " + compra.getCodigo() + " foi salva com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a compra!!!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		compra = (Compra) evento.getComponent().getAttributes().get("compraSelecionada");
		Messages.addGlobalInfo("" + compra.getCodigo());
		
	}
}
