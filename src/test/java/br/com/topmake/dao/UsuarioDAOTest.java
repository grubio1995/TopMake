package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		String usuarioNome = "Teste";
		String usuarioEmail = "teste@gmail.com";
		String usuarioLogin = "ADMIN";
		String usuarioSenha = "admin";
		Character usuarioTipoUsuario = 'A';
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioNome);
		usuario.setEmail(usuarioEmail);
		usuario.setLogin(usuarioLogin);
		usuario.setSenha(usuarioSenha);
		usuario.setTipoUsuario(usuarioTipoUsuario);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.Salvar(usuario);
		System.out.println("Usuário salvo com sucesso!");		
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.Listar();
		
		System.out.println("Total de usuários encontrados: " + resultado.size());
		
		for (Usuario usuario : resultado) {
			System.out.println(usuario.getNome() + " - " + usuario.getEmail() + " - " + usuario.getLogin() + " - "
					+ usuario.getSenha() + " - " + usuario.getTipoUsuario());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer usuarioCodigo = 1;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuário encontrado");
		}
		else {
			System.out.println("Usuário encontrado!");
			System.out.println(usuario.getNome() + " - " + usuario.getEmail() + " - " + usuario.getLogin() + " - "
					+ usuario.getSenha() + " - " + usuario.getTipoUsuario());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Integer usuarioCodigo = 3;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuário encontrado!");
		}
		else {
			usuarioDAO.Excluir(usuario);
			System.out.println("Usuário removido com sucesso!");
		}		
	}

	@Test
	@Ignore
	public void editar() {
		Integer usuarioCodigo = 4;
		String usuarioNome = "Teste novo";
		String usuarioEmail = "teste-novo@gmail.com";
		String usuarioLogin = "novousuario";
		String usuarioSenha = "novasenha";
		Character usuarioTipoUsuario = 'C';
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuário encontrado!");
		}
		else {
			usuario.setNome(usuarioNome);
			usuario.setEmail(usuarioEmail);
			usuario.setLogin(usuarioLogin);
			usuario.setSenha(usuarioSenha);
			usuario.setTipoUsuario(usuarioTipoUsuario);
			usuarioDAO.Editar(usuario);
			
			System.out.println("Usuário editado com sucesso!");		
		}

	}
	
}
