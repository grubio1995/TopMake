package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.topmake.dao.ProdutoDAO;
import br.com.topmake.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@PostConstruct
	public void Listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.Listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos!");
			erro.printStackTrace();
		}
	}

	public void Novo() {
		produto = new Produto();
	}
	
	public void Salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.Merge(produto);
			
			produtos = produtoDAO.Listar();	

			Messages.addGlobalInfo("O produto " + produto.getNome() + " foi salvo com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto!");
			erro.printStackTrace();
		}
	}

	public void Excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			Messages.addGlobalInfo("Descrição: " + produto.getDescricao());

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.Excluir(produto);

			produtos = produtoDAO.Listar();

			Messages.addGlobalInfo("Produto removido com sucesso ");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o produto: " + erro);
			erro.printStackTrace();
		}
	}

	public void Editar(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		Messages.addGlobalInfo("" + produto.getDescricao());
		
	}
}
