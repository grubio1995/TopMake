package br.com.topmake.bean;

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
	public void listar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categorias = categoriaDAO.listar();
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as categorias!");
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
			Messages.addGlobalInfo("Categoria salva com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a categoria!");
			erro.printStackTrace();
		}
		
		novo();
		listar();
	}

	public void excluir(ActionEvent evento) {
		try {
			categoria = (Categoria) evento.getComponent().getAttributes().get("categoriaSelecionada");
			
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.excluir(categoria);
			
			Messages.addGlobalInfo("Categoria removida com sucesso!");
		}
		catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover a categoria!");
			erro.printStackTrace();
		}
		
		listar();
	}
	
	public void editar(ActionEvent evento) {
		categoria = (Categoria) evento.getComponent().getAttributes().get("categoriaSelecionada");
	}
}
