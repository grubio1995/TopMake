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
		linha.setClassificacao("Infantil");
		
		LinhaDAO linhaDAO = new LinhaDAO();
		linhaDAO.salvar(linha);	
	}

	@Test
	public void listar(){
		LinhaDAO linhaDAO = new LinhaDAO();
		List<Linha> resultado = linhaDAO.listar();
		System.out.println("Registros tabela Linha:");
		for(Linha linha : resultado){
			System.out.println("Linha:" + linha.getClassificacao());		
		}
	}
}
