package br.com.topmake.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.topmake.dao.CategoriaDAO;
import br.com.topmake.domain.Categoria;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CategoriaBean implements Serializable {
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void novo() {
		categoria = new Categoria();
	}
	public void Salvar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.salvar(categoria);

			novo();

			Messages.addGlobalInfo("A categoria " + categoria.getDescricao() + " foi salva com sucesso!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a categoria!!!");
			erro.printStackTrace();
		}
	}
}
