package br.com.topmake.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Revendedora;
import br.com.topmake.domain.Usuario;

public class RevendedoraDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Revendedora revendedora = new Revendedora();
		Usuario usuario = new Usuario();
		revendedora.setRevendedora(usuario);
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		revendedoraDAO.salvar(revendedora);	
	}

	@Test
	public void listar(){
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		List<Revendedora> resultado = revendedoraDAO.listar();
		System.out.println("Registros tabela Revendedora:");
		for(Revendedora revendedora : resultado){
			System.out.println("Linha:" + revendedora.getRevendedora());		
		}
	}
}
