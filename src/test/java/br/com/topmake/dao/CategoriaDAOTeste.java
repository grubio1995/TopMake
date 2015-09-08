package br.com.topmake.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Categoria;

public class CategoriaDAOTeste {

	@Test
	@Ignore
	public void salvar(){
		Categoria categoria = new Categoria();
		categoria.setDescricao("Masculina");
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.salvar(categoria);	
	}

	@Test
	public void listar(){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> resultado = categoriaDAO.listar();
		System.out.println("Registros tabela Categoria");
		for(Categoria categoria : resultado)
			System.out.println(categoria.getDescricao() );	
	}

}
