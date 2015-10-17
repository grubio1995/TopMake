package br.com.topmake.Bean;

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

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	public void novo() {
		linha = new Linha();
	}
	
	@PostConstruct
	public void listar() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhas = linhaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as linhas!!!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhaDAO.merge(linha);

			linha = new Linha();
			linhas = linhaDAO.listar();

			Messages.addGlobalInfo("A linha foi salva com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a linha!");
			erro.printStackTrace();
		}
	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			linha = (Linha) evento.getComponent().getAttributes().get("linhaSelecionada");
			
			LinhaDAO linhaDAO = new LinhaDAO();
			linhaDAO.excluir(linha);

			linhas = linhaDAO.listar();

			Messages.addGlobalInfo("Linha removida com sucesso ");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover a linha" + erro);
			erro.printStackTrace();
		}
	}

	public void Editar(ActionEvent evento) {
		linha = (Linha) evento.getComponent().getAttributes().get("linhaSelecionada");
		Messages.addGlobalInfo("" + linha.getDescricao());

	}
}
