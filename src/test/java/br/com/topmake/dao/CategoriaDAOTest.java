package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Categoria;

public class CategoriaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		String categoriaDescricao = "Fragância";
		
		Categoria categoria = new Categoria();
		categoria.setDescricao(categoriaDescricao);
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.salvar(categoria);
		System.out.println("Categoria salva com sucesso!");
	}
	
	@Test
	@Ignore
	public void listar() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> resultado = categoriaDAO.listar();
		
		System.out.println("Total de categorias encontradas: " + resultado.size());
		
		for (Categoria categoria : resultado) {
			System.out.println(categoria.getCodigo() + " - " + categoria.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer categoriaCodigo = 1;
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(categoriaCodigo);
		
		if (categoria == null) {
			System.out.println("Nenhuma categoria encontrada!");
		}
		else {
			System.out.println("Categoria encontrada!");
			System.out.println(categoria.getCodigo() + " - " + categoria.getDescricao());
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Integer categoriaCodigo = 1;
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(categoriaCodigo);
		
		if (categoria == null) {
			System.out.println("Nenhuma categoria encontrada!");
		}
		else {
			categoriaDAO.excluir(categoria);
			System.out.println("Categoria removida com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer categoriaCodigo = 4;
		String categoriaDescricao = "Pele";
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(categoriaCodigo);
		
		if (categoria == null) {
			System.out.println("Nenhuma categoria encontrada!");
		}
		else {
			categoria.setDescricao(categoriaDescricao);
			
			categoriaDAO.editar(categoria);
			System.out.println("Categoria editada com sucesso!");
		}		
	}
}
