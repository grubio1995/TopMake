package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Linha;

public class LinhaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		String linhaDescricao = "Botanical Effects";
		
		Linha linha = new Linha();
		linha.setDescricao(linhaDescricao);
		
		LinhaDAO linhaDAO = new LinhaDAO();
		linhaDAO.salvar(linha);
		System.out.println("Linha salva com sucesso!");
	}

	@Test
	@Ignore
	public void listar(){
		LinhaDAO linhaDAO = new LinhaDAO();
		List<Linha> resultado = linhaDAO.listar();
		
		System.out.println("Total de linhas encontradas: " + resultado.size());
		
		for(Linha linha : resultado) {
			System.out.println(linha.getCodigo() + " - " + linha.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer linhaCodigo = 2;
		
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(linhaCodigo);
		
		if (linha == null) {
			System.out.println("Nenhuma linha encontrada!");
		}
		else {
			System.out.println("Linha encontrada!");			
			System.out.println(linha.getCodigo() + " - " + linha.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Integer linhaCodigo = 3;
		
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(linhaCodigo);
		
		if (linha == null) {
			System.out.println("Nenhuma linha encontrada!");
		}
		else {
			linhaDAO.excluir(linha);
			System.out.println("Linha removida com sucesso!");			
		}
	} 
	
	@Test
	@Ignore
	public void editar() {
		Integer linhaCodigo = 4;
		String linhaDescricao = "TimeWise";
		
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(linhaCodigo);
		
		if (linha == null) {
			System.out.println("Nenhuma linha encontrada!");
		}
		else {			
			linha.setDescricao(linhaDescricao);
			linhaDAO.editar(linha);
			System.out.println("Linha editada com sucesso!");
		}
	}
}
