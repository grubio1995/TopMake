package br.com.topmake.bean;

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
	private List<Status> statusLista;
	
	public List<Status> getStatusLista() {
		return statusLista;
	}
	
	public void setStatusLista(List<Status> statusLista) {
		this.statusLista = statusLista;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@PostConstruct
	public void listar() {
		try {
			StatusDAO statusDAO = new StatusDAO();
			statusLista = statusDAO.listar();
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os status!");
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
			Messages.addGlobalInfo("Status salvo com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o status!");
			erro.printStackTrace();
		}
		
		novo();
		listar();
	}

	public void excluir(ActionEvent evento) {
		try {
			status = (Status) evento.getComponent().getAttributes().get("statusSelecionado");
			
			StatusDAO statusDAO = new StatusDAO();
			statusDAO.excluir(status);
			
			Messages.addGlobalInfo("Status removido com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o status!");
			erro.printStackTrace();
		}
		
		listar();
	}
	
	public void editar(ActionEvent evento) {
		status = (Status) evento.getComponent().getAttributes().get("statusSelecionado");
	}
}
