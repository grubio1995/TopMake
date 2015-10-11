package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.StatusDAO;
import br.com.topmake.domain.Status;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class StatusBean implements Serializable {
	private Status status;
	private List<Status> statuss;

	public List<Status> getStatuss() {
		return statuss;
	}

	public void setStatuss(List<Status> statuss) {
		this.statuss = statuss;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	@PostConstruct
	public void Listar() {
		try {
			StatusDAO statusDAO = new StatusDAO();
			statuss = statusDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os status!!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		status = new Status();
	}

	public void salvar() {
		try {
			StatusDAO statusDAO = new StatusDAO();
			statusDAO.merge(status);

			
			statuss = statusDAO.listar();
			

			Messages.addGlobalInfo("O status " + status.getDescricao() + " foi salvo com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o status!!!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			status = (Status) evento.getComponent().getAttributes().get("statusSelecionado");
			Messages.addGlobalInfo("Descrição: " + status.getDescricao());

			StatusDAO statusDAO = new StatusDAO();
			statusDAO.excluir(status);

			statuss = statusDAO.listar();

			Messages.addGlobalInfo("Status removido com sucesso ");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o Status" + erro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		status = (Status) evento.getComponent().getAttributes().get("statusSelecionado");
		Messages.addGlobalInfo("" + status.getDescricao());
		
	}
}
