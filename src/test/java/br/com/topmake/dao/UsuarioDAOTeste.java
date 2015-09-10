package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Usuario;

public class UsuarioDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setEmail("email2@teste.com");
		usuario.setLogin("adm2");
		usuario.setSenha("adm2");
		usuario.setTipoUsuario('A');

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		System.out.println("Salvo com sucesso!");
		
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		System.out.println("Registros tabela Usuario:");
		for (Usuario usuario : resultado) {
			System.out.println("===========================================");
			System.out.println("Nome:" + usuario.getNome());
			System.out.println("Login:" + usuario.getLogin());
			System.out.println("Senha:" + usuario.getSenha());
			System.out.println("Tipo:" + usuario.getTipoUsuario());
			System.out.println("email:" + usuario.getEmail());
			System.out.println("===========================================");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		if (usuario == null) {
			System.out.println("Nenhum usuario encontrado");
		} else {
			System.out.println("===========================================");
			System.out.println("Usuario encontrado:");
			System.out.println(usuario.getNome() + " - " + usuario.getEmail() + " - " + usuario.getLogin() + " - "
					+ usuario.getSenha() + " - " + usuario.getTipoUsuario());
			System.out.println("===========================================");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(3L);

		usuarioDAO.excluir(usuario);

		System.out.println("Usuario Removido");
		System.out.println("Nome do Usuario: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
	}

	@Test
	@Ignore
	public void editar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(4L);

		System.out.println("Usuario A Ser Editado");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario:" + usuario.getTipoUsuario());

		usuario.setNome("Teste3");
		usuario.setEmail("email");
		usuario.setLogin("admTst");
		usuario.setSenha("admTst");
		usuario.setTipoUsuario('C');
		usuarioDAO.editar(usuario);

		System.out.println("Usuario Editado");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario:" + usuario.getTipoUsuario());

	}
}
