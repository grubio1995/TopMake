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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(4L);
		System.out.println(usuario.getNome());
		revendedora.setRevendedora(usuario);
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		revendedoraDAO.salvar(revendedora);
		System.out.println("Revendedora Salva");
	}

	@Test
	@Ignore
	public void listar(){
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		List<Revendedora> resultado = revendedoraDAO.listar();
		System.out.println("Registros tabela Revendedora:");
		for(Revendedora revendedora : resultado){
			System.out.println("========================================");
			System.out.println(revendedora.getRevendedora().getNome() + " - " + revendedora.getRevendedora().getLogin() + " - " + revendedora.getRevendedora().getSenha() + " - "
					+ revendedora.getRevendedora().getTipoUsuario() + " - " + revendedora.getRevendedora().getEmail());
			System.out.println("========================================");
		}
	}	

	@Test
	@Ignore
	public void buscar(){
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Revendedora revendedora = revendedoraDAO.buscar(2L);

		if(revendedora == null){
			System.out.println("Nenhuma revendedora encontrada");
		}else{
			System.out.println("Revendedora encontrada:");
			System.out.println(revendedora.getRevendedora().getNome() + " - " + revendedora.getRevendedora().getLogin() + " - " + revendedora.getRevendedora().getSenha() + " - "
					+ revendedora.getRevendedora().getTipoUsuario() + " - " + revendedora.getRevendedora().getEmail());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Revendedora revendedora = revendedoraDAO.buscar(3L);

		revendedoraDAO.excluir(revendedora);

		System.out.println("Revendedora Removida");
		System.out.println("Nome Revendedora: " + revendedora.getRevendedora().getNome());
		System.out.println("Email: " + revendedora.getRevendedora().getEmail());
		System.out.println("Login: " + revendedora.getRevendedora().getLogin());
		System.out.println("Senha: " + revendedora.getRevendedora().getSenha());
		System.out.println("Tipo de usuario: " + revendedora.getRevendedora().getTipoUsuario());

	}
	
	@Test
	@Ignore
	public void editar(){

		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Revendedora revendedora = revendedoraDAO.buscar(4L);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(revendedora.getRevendedora().getCodigo());

		System.out.println("Revendedora A Ser Editada");
		System.out.println("Nome Revendedora: " + revendedora.getRevendedora().getNome());
		System.out.println("Email: " + revendedora.getRevendedora().getEmail());
		System.out.println("Login: " + revendedora.getRevendedora().getLogin());
		System.out.println("Senha: " + revendedora.getRevendedora().getSenha());
		System.out.println("Tipo de usuario: " + revendedora.getRevendedora().getTipoUsuario());

		usuario.setEmail("REVENDEDORA@EMAIL.COM");
		usuario.setLogin("ADM");
		usuario.setSenha("ADM");
		usuarioDAO.editar(usuario);
		revendedora.setRevendedora(usuario);
		revendedoraDAO.editar(revendedora);

		System.out.println("Revendedora Editada");

	}
	
	
	
}
