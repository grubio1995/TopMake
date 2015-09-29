package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Revendedora;
import br.com.topmake.domain.Usuario;

public class RevendedoraDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer usuarioCodigo = 4;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuário encontrado!");
		}
		else {
			Revendedora revendedora = new Revendedora();
			revendedora.setUsuario(usuario);
			
			RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
			revendedoraDAO.Salvar(revendedora);		
			System.out.println("Revendedora salva com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		List<Revendedora> resultado = revendedoraDAO.Listar();
		
		System.out.println("Total de revendedoras encontradas: " + resultado.size());
		
		for(Revendedora revendedora : resultado) {
			System.out.println(revendedora.getUsuario().getNome()
				+ " - " + revendedora.getUsuario().getLogin() + " - " + revendedora.getUsuario().getSenha()
				+ " - "	+ revendedora.getUsuario().getTipoUsuario() + " - " + revendedora.getUsuario().getEmail());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer revendedoraCodigo = 2;
		
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Revendedora revendedora = revendedoraDAO.Buscar(revendedoraCodigo);

		if(revendedora == null) {
			System.out.println("Nenhuma revendedora encontrada!");
		}
		else {
			System.out.println(revendedora.getUsuario().getNome()
					+ " - " + revendedora.getUsuario().getLogin() + " - " + revendedora.getUsuario().getSenha()
					+ " - "	+ revendedora.getUsuario().getTipoUsuario() + " - " + revendedora.getUsuario().getEmail());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Integer revendedoraCodigo = 3;
		
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();		
		Revendedora revendedora = revendedoraDAO.Buscar(revendedoraCodigo);
		
		if (revendedora == null) {
			System.out.println("Nenhuma revendedora encontrado!");
		}
		else {
			revendedoraDAO.Excluir(revendedora);
			System.out.println("Revendedora removida com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer revendedoraCodigo = 4;
		String revendedoraEmail = "REVENDEDORA@EMAIL.COM";
		String revendedoraLogin = "ADMIN";
		String revendedoraSenha = "admin";
		
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Revendedora revendedora = revendedoraDAO.Buscar(revendedoraCodigo);
		
		if (revendedora == null) {
			System.out.println("Nenhuma revendedora encontrada!");
		}
		else {
			Integer usuarioCodigo = revendedora.getUsuario().getCodigo().intValue();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
			
			if (usuario == null) {
				System.out.println("Nenhum usuário encontrado!");
			}
			else {
				usuario.setEmail(revendedoraEmail);
				usuario.setLogin(revendedoraLogin);
				usuario.setSenha(revendedoraSenha);
				revendedora.setUsuario(usuario);
				
				usuarioDAO.Editar(usuario);
				revendedoraDAO.Editar(revendedora);
				System.out.println("Revendedora editada com sucesso!");
			}
			
		}

	}
	
}
