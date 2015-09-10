package br.com.topmake.dao;

import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Cliente;
import br.com.topmake.domain.Usuario;

public class ClienteDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Cliente cliente = new Cliente();
		cliente.setBairro("TESTE");
		cliente.setCelular("TESTE");
		cliente.setCep("TESTE");
		cliente.setCidade("TESTE");
		cliente.setCpf("TESTE");
		Date d = new Date();
		cliente.setDataNascimento(d);
		cliente.setEstado("TESTE");
		cliente.setEstadoCivil("TESTE");
		cliente.setRg("TESTE");
		cliente.setSexo('F');
		cliente.setTelefone("TESTE");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(2L);
		cliente.setUsuario(usuario);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);	
	}

	@Test
	@Ignore
	public void listar(){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		System.out.println("Registros tabela Clientes:");
		for(Cliente categoria : resultado){
			System.out.println("========================================");
			System.out.println("Bairro:" + categoria.getBairro());	
			System.out.println("Celular:" + categoria.getCelular());
			System.out.println("CEP:" + categoria.getCep());
			System.out.println("Cidade:" + categoria.getCidade());
			System.out.println("CPF:" + categoria.getCpf());
			System.out.println("Data Nascimento:" + categoria.getDataNascimento());
			System.out.println("Estado:" + categoria.getEstado());
			System.out.println("Estado Civil:" + categoria.getEstadoCivil());
			System.out.println("Rg:" + categoria.getRg());
			System.out.println("Sexo:" + categoria.getSexo());
			System.out.println("Telefone:" + categoria.getTelefone());
			System.out.println("========================================");
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(2L);
		
		if(cliente == null){
			System.out.println("Nenhum cliente encontrado");
		}else{
			System.out.println("Cliente encontrado:");
			System.out.println(cliente.getCodigo() + " - " + cliente.getBairro() +
		 " - " + cliente.getCep() + " - " + cliente.getCidade() + " - " 
		 + cliente.getEstado() + " - " + cliente.getTelefone() +
		 " - " + cliente.getCelular() + " - " + cliente.getSexo() 
		 + " - " + cliente.getCpf() + " - " + cliente.getRg() + " - " 
		 + cliente.getDataNascimento() + " - " + cliente.getEstadoCivil() );
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(3L);
		
		clienteDAO.excluir(cliente);

		System.out.println("Cliente Removido");
		System.out.println("Nome do Usuario: " + cliente.getUsuario());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Cidade: " + cliente.getCidade());
		System.out.println("Estado: " + cliente.getEstado());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Celular: " + cliente.getCelular());
		System.out.println("Sexo: " + cliente.getSexo());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("RG: " + cliente.getRg());
		System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
		System.out.println("Estado Civil: " + cliente.getEstadoCivil());
	}
	
	@Test
	@Ignore
	public void editar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(2L);
		
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario:" + usuario.getTipoUsuario());

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(2L);
		
		System.out.println("Cliente A Ser Editado");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario:" + usuario.getTipoUsuario());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Cidade: " + cliente.getCidade());
		System.out.println("Estado: " + cliente.getEstado());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Celular: " + cliente.getCelular());
		System.out.println("Sexo: " + cliente.getSexo());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("RG: " + cliente.getRg());
		System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
		System.out.println("Estado Civil: " + cliente.getEstadoCivil());
		
		
		cliente.setCelular("909090909090");
		clienteDAO.editar(cliente);
		
		System.out.println("Cliente Editado");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario:" + usuario.getTipoUsuario());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Cidade: " + cliente.getCidade());
		System.out.println("Estado: " + cliente.getEstado());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Celular: " + cliente.getCelular());
		System.out.println("Sexo: " + cliente.getSexo());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("RG: " + cliente.getRg());
		System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
		System.out.println("Estado Civil: " + cliente.getEstadoCivil());
			
	}
}
