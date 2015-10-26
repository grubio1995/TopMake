package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.topmake.dao.ClienteDAO;
import br.com.topmake.dao.UsuarioDAO;
import br.com.topmake.domain.Cliente;
import br.com.topmake.domain.Usuario;

/**
 * @author Gabriel Rubio
 *
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Usuario> usuarios;

	public void salvar(){
		
		try{
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);
			
			cliente = new Cliente();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			clientes = clienteDAO.listar();
			
			Messages.addGlobalInfo("Cliente salvo com sucesso");
			
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao salvar um novo cliente");
		}
	}
	
	@PostConstruct
	public void listar(){

		try{
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os clientes");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		
		try{
			cliente = new Cliente();

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();

		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo cliente");
		}
	}
	
	public void excluir(ActionEvent evento){
		
		try{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			cliente = new Cliente();
			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Cliente excluída com sucesso");

		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover um cliente");
			erro.printStackTrace();
		}

	}
	
	public void editar(ActionEvent evento){
		try{

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um cliente");
			erro.printStackTrace();
		}
		 
	}
	
	@PostConstruct
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
