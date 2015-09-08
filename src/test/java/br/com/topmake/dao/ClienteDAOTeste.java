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
		cliente.setBairro("Centro");
		cliente.setCelular("99999-9999");
		cliente.setCep("18800-000");
		cliente.setCidade("Piraju");
		cliente.setCpf("XXXXXXXXX-X");
		Date d = new Date();
		cliente.setDataNascimento(d);
		cliente.setEstado("SP");
		cliente.setEstadoCivil("Solteiro");
		cliente.setRg("XXXXXXXXXXX-XX");
		cliente.setSexo('M');
		cliente.setTelefone("XXXX-XXXX");
		Usuario usuario = new Usuario();     // a ver
		cliente.setUsuario(usuario);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);	
	}

	@Test
	public void listar(){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		System.out.println("Registros tabela Clientes:");
		for(Cliente categoria : resultado){
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
					
		}
	}

}
