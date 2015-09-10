package br.com.topmake.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Linha;

public class LinhaDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Linha linha = new Linha();
		linha.setClassificacao("Teste");
		
		LinhaDAO linhaDAO = new LinhaDAO();
		linhaDAO.salvar(linha);	
	}

	@Test
	@Ignore
	public void listar(){
		LinhaDAO linhaDAO = new LinhaDAO();
		List<Linha> resultado = linhaDAO.listar();
		System.out.println("Registros tabela Linha:");
		for(Linha linha : resultado){
			System.out.println("Linha:" + linha.getClassificacao());		
		}
	}
	

	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;		
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(codigo);
		if(linha == null){
			System.out.println("Nenhum produto encontrado");
		}else
			System.out.println("Classificação da linha: " + linha.getClassificacao());
	}
	
	@Test
	@Ignore
	public void excluir(){
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(3L);
		linhaDAO.excluir(linha);
		System.out.println("Linha removido com sucesso!!!");
	} 
	
	@Test
	@Ignore
	public void editar(){
		
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(4L);

		System.out.println("Linha A Ser Editada");
		System.out.println("Linha: " + linha.getClassificacao());
		
		linha.setClassificacao("Teste2");
		
		linhaDAO.editar(linha);
		System.out.println("Editado com sucesso!");
	}
}
