package br.com.topmake.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.ProdutoDAO;
import br.com.topmake.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void novo() {
		produto = new Produto();
	}
	
	public void Salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.Merge(produto);

			

			Messages.addGlobalInfo("O produto " + produto.getNome() + " foi salvo com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto!!!");
			erro.printStackTrace();
		}
	}
}
