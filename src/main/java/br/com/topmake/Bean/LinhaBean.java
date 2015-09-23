package br.com.topmake.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.LinhaDAO;
import br.com.topmake.domain.Linha;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LinhaBean implements Serializable{
	private Linha linha;
	
	public Linha getLinha() {
		return linha;
	}
	
	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public void novo() {
		linha = new Linha();
	}
	public void Salvar() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhaDAO.salvar(linha);

			novo();

			Messages.addGlobalInfo("A linha " + linha.getDescricao() + " foi salva com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a linha!!!");
			erro.printStackTrace();
		}
	}
}
