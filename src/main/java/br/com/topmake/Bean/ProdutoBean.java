package br.com.topmake.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.CategoriaDAO;
import br.com.topmake.dao.LinhaDAO;
import br.com.topmake.dao.ProdutoDAO;
import br.com.topmake.domain.Categoria;
import br.com.topmake.domain.Linha;
import br.com.topmake.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	
	private Produto produto;
	private List<Produto> produtos;
	private List<Categoria> categorias;
	private List<Linha> linhas;
	
	public void novo() {
		produto = new Produto();
    	listarCategorias();
    	listarLinhas();
	}
	
	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
			
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos!");
			erro.printStackTrace();
		}
	}
	
	public void listarCategorias() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categorias = categoriaDAO.listar();
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as categorias!");
			erro.printStackTrace();
		}
	}
	
	public void listarLinhas() {
		try {
			LinhaDAO linhaDAO = new LinhaDAO();
			linhas = linhaDAO.listar();
			
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as linhas!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			Messages.addGlobalInfo("Produto salvo com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto!");
			erro.printStackTrace();
		}
		
		novo();
		listar();
		listarCategorias();
		listarLinhas();
	}

	public void excluir(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		
		try {			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);			
			Messages.addGlobalInfo("Produto removido com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o produto!");
			erro.printStackTrace();
		}
	    
	    listar();
	}

	public void editar(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		listarCategorias();
		listarLinhas();
	}
	
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
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Linha> getLinhas() {
		return linhas;
	}
	
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
}
