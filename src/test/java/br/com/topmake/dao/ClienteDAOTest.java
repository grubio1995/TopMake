package br.com.topmake.dao;

import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Cliente;
import br.com.topmake.domain.Usuario;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer usuarioCodigo = 2;
		
		String clienteBairro = "Teste";
		String clienteCelular = "Teste";
		String clienteCep = "Teste";
		String clienteCidade = "Teste";
		String clienteCpf = "Teste";
		Date clienteDataNascimento = new Date();
		String clienteEstado = "Teste";
		String clienteEstadoCivil = "Teste";
		String clienteRg = "Teste";
		Character clienteSexo = 'M';
		String clienteTelefone = "Teste";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuário encontrado!");
		}
		else {
			Cliente cliente = new Cliente();
			
			cliente.setBairro(clienteBairro);
			cliente.setCelular(clienteCelular);
			cliente.setCep(clienteCep);
			cliente.setCidade(clienteCidade);
			cliente.setCpf(clienteCpf);
			cliente.setDataNascimento(clienteDataNascimento);
			cliente.setEstado(clienteEstado);
			cliente.setEstadoCivil(clienteEstadoCivil);
			cliente.setRg(clienteRg);
			cliente.setSexo(clienteSexo);
			cliente.setTelefone(clienteTelefone);		
			cliente.setUsuario(usuario);
			
			ClienteDAO clienteDAO = new ClienteDAO();			
			clienteDAO.Salvar(cliente);
			System.out.println("Cliente salvo com sucesso!");
		}

	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.Listar();
		
		System.out.println("Total de clientes encontrados: " + resultado.size());
		
		for (Cliente cliente : resultado) {
			System.out.println("========================================");
			System.out.println("Nome:" + cliente.getUsuario().getNome());
			System.out.println("E-mail:" + cliente.getUsuario().getEmail());
			System.out.println("Login:" + cliente.getUsuario().getLogin());
			System.out.println("Senha:" + cliente.getUsuario().getSenha());
			System.out.println("Tipo de usuário:" + cliente.getUsuario().getTipoUsuario());			
			System.out.println("Bairro:" + cliente.getBairro());
			System.out.println("Celular:" + cliente.getCelular());
			System.out.println("CEP:" + cliente.getCep());
			System.out.println("Cidade:" + cliente.getCidade());
			System.out.println("CPF:" + cliente.getCpf());
			System.out.println("Data Nascimento:" + cliente.getDataNascimento());
			System.out.println("Estado:" + cliente.getEstado());
			System.out.println("Estado Civil:" + cliente.getEstadoCivil());
			System.out.println("RG:" + cliente.getRg());
			System.out.println("Sexo:" + cliente.getSexo());
			System.out.println("Telefone:" + cliente.getTelefone());
			System.out.println("========================================");
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer clienteCodigo = 2;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(clienteCodigo);
		
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado!");
		}
		else {
			System.out.println("Cliente encontrado!");			
			System.out.println(cliente.getCodigo() + " - " + cliente.getBairro()
				+ " - " + cliente.getCep() + " - " + cliente.getCidade()
				+ " - " + cliente.getEstado() + " - " + cliente.getTelefone()
				+ " - " + cliente.getCelular() + " - " + cliente.getSexo()
				+ " - " + cliente.getCpf() + " - " + cliente.getRg()
				+ " - " + cliente.getDataNascimento() + " - " + cliente.getEstadoCivil());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Integer clienteCodigo = 3;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(clienteCodigo);
		
		clienteDAO.Excluir(cliente);
		
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado!");
		}
		else {
			clienteDAO.Excluir(cliente);
			System.out.println("Cliente removido com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer usuarioCodigo = 2;
		Integer clienteCodigo = 2;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(usuarioCodigo);
		
		if (usuario == null) {
			System.out.println("Nenhum usuario encontrado!");
		}
		else {
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.Buscar(clienteCodigo);
			
			if (cliente == null) {
				System.out.println("Nenhum cliente encontrado!");
			}
			else {
				cliente.setCelular("(14) 99123-4567");
				clienteDAO.Editar(cliente);
			}
		}
			
	}
}
