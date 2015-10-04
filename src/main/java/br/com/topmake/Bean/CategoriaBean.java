package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.CategoriaDAO;
import br.com.topmake.domain.Categoria;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CategoriaBean implements Serializable {
	private Categoria categoria;
	private List<Categoria> categorias;

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@PostConstruct
	public void Listar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categorias = categoriaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as categorias!!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		categoria = new Categoria();
	}

	public void salvar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.merge(categoria);

			
			categorias = categoriaDAO.listar();
			

			Messages.addGlobalInfo("A categoria " + categoria.getDescricao() + " foi salva com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a categoria!!!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			categoria = (Categoria) evento.getComponent().getAttributes().get("categoriaSelecionada");
			Messages.addGlobalInfo("Descrição: " + categoria.getDescricao());

			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.excluir(categoria);

			categorias = categoriaDAO.listar();

			Messages.addGlobalInfo("Categoria removida com sucesso ");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover a Categoria" + erro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		categoria = (Categoria) evento.getComponent().getAttributes().get("categoriaSelecionada");
		Messages.addGlobalInfo("" + categoria.getDescricao());
		
	}
}
