package br.com.topmake.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Categoria;

public class CategoriaDAOTeste {

	@Test
	public void salvar(){
		Categoria categoria = new Categoria();
		categoria.setDescricao("Teste");
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.salvar(categoria);	
	}

	@Test
	@Ignore
	public void listar(){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> resultado = categoriaDAO.listar();
		System.out.println("Registros tabela Categoria");
		for(Categoria categoria : resultado)
			System.out.println(categoria.getDescricao() );	
	}

	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(codigo);
		if(categoria == null){
			System.out.println("Nenhum produto encontrado");
		}else
			System.out.println("Categoria: " + categoria.getDescricao());
		
	}
	
	@Test
	@Ignore
	public void excluir(){

		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(4L);
		categoriaDAO.excluir(categoria);

		System.out.println("Categoria removido com sucesso!!!");
	}
	
	@Test
	@Ignore
	public void editar(){
	
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(4L);
	
		System.out.println("Categoria A Ser Editada");
		System.out.println("Categoria: " + categoria.getDescricao());
		
		categoria.setDescricao("Teste2");
		
		categoriaDAO.editar(categoria);
	}

}
