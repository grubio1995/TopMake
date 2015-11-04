package br.com.topmake.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.topmake.dao.LinhaDAO;
import br.com.topmake.domain.Linha;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LinhaBean implements Serializable {
	
	private Linha linha;
	private List<Linha> linhas;
	
	public List<Linha> getLinhas() {
		return linhas;
	}
	
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	
	@PostConstruct
	public void listar() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhas = linhaDAO.listar();
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as linhas!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		linha = new Linha();
	}
	
	public void salvar() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhaDAO.merge(linha);
			Messages.addGlobalInfo("Linha salva com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a linha!");
			erro.printStackTrace();
		}
		
		novo();
		listar();
	}

	public void excluir(ActionEvent evento) {
		try {
			linha = (Linha) evento.getComponent().getAttributes().get("linhaSelecionada");
			
			LinhaDAO linhaDAO = new LinhaDAO();
			linhaDAO.excluir(linha);
			
			Messages.addGlobalInfo("Linha removida com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover a linha!");
			erro.printStackTrace();
		}
		
		listar();
	}
	
	public void editar(ActionEvent evento) {
		linha = (Linha) evento.getComponent().getAttributes().get("linhaSelecionada");
	}
}
